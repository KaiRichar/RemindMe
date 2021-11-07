package com.remindme.medicine.remindtask.service.impl;

import cn.hutool.core.date.DateUnit;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.remindme.medicine.common.utils.SnowflakeIdUtils;
import com.remindme.medicine.medicineinfo.entity.TbMedicineInfo;
import com.remindme.medicine.medicineinfo.service.TbMedicineInfoService;
import com.remindme.medicine.remindtask.entity.TbRemindTask;
import com.remindme.medicine.remindtask.entity.param.MedicineRemindTimeParamVO;
import com.remindme.medicine.remindtask.entity.param.RemindTaskSaveParamVO;
import com.remindme.medicine.remindtask.exception.TaskAccountReachMaxException;
import com.remindme.medicine.remindtask.mapper.TbRemindTaskMapper;
import com.remindme.medicine.remindtask.service.TbRemindTaskService;
import com.remindme.medicine.remindtime.entity.TbRemindTime;
import com.remindme.medicine.remindtime.service.TbRemindTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 提醒任务表 服务实现类
 * </p>
 *
 * @author Kongql
 * @since 2021-10-24
 */
@Service
@Slf4j
public class TbRemindTaskServiceImpl extends ServiceImpl<TbRemindTaskMapper, TbRemindTask> implements TbRemindTaskService {

    @Resource
    private TbMedicineInfoService medicineInfoService;

    @Resource
    private TbRemindTimeService remindTimeService;

    /**
     * 单个用户可以设置的最大任务数量
     */
    private final Integer MAX_TASK_COUNT_FOR_SINGLE_USER = 10;

    @Override
    public boolean saveRemindTask(RemindTaskSaveParamVO paramVO) throws Exception {
        //根据用户id判断已经设定的任务数量
        String userId = paramVO.getCreateUserId();
        LambdaQueryWrapper<TbRemindTask> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TbRemindTask::getCreateUserId, userId);
        wrapper.eq(TbRemindTask::getRemoveFlag, "VALID");
        if (this.count(wrapper) >= MAX_TASK_COUNT_FOR_SINGLE_USER) {
            throw new TaskAccountReachMaxException();
        }
        TbRemindTask remindTask = new TbRemindTask();
        BeanUtils.copyProperties(paramVO, remindTask);
        SnowflakeIdUtils idWorker = new SnowflakeIdUtils(3, 1);
        remindTask.setTaskId(idWorker.nextId());
        //任务的初始状态都为就绪状态
        remindTask.setTaskStatus("wait_to_begin");
        boolean taskBasicInfoSaved = this.save(remindTask);
        if (taskBasicInfoSaved) {
            log.info("提醒任务--{}保存成功", remindTask.toString());
        } else {
            log.info("提醒任务--{}保存失败", remindTask.toString());
        }
        //保存对应的药物和具体的提醒时间
        List<MedicineRemindTimeParamVO> medicineRemindTimeParamVOList = paramVO.getMedicineRemindTimeParamVOList();
        boolean relatedInfo = saveMedicineInfoWithRemindTimeBatch(remindTask.getTaskId(), medicineRemindTimeParamVOList);
        return relatedInfo && taskBasicInfoSaved;
}

    @Override
    public boolean saveMedicineInfoWithRemindTimeBatch(Long taskId, List<MedicineRemindTimeParamVO> paramList) {
        if (taskId == null || paramList == null || paramList.size() == 0) return true;
        //整理药物实体和时间实体
        List<TbMedicineInfo> medicineInfoList = new ArrayList<>();
        List<TbRemindTime> remindTimeList = new ArrayList<>();
        SnowflakeIdUtils idWorker = new SnowflakeIdUtils(3, 1);
        for (MedicineRemindTimeParamVO param : paramList){
            //药物基本信息
            TbMedicineInfo medicineInfo = TbMedicineInfo.builder()
                    .taskId(taskId)
                    .medicineId(idWorker.nextId())
                    .medicineName(param.getMedicineName())
                    .medicineRemark(param.getMedicineRemark()).build();
            medicineInfoList.add(medicineInfo);
            //提醒时间信息
            for(String time : param.getRemindTimeList()){
                TbRemindTime remindTime = TbRemindTime.builder()
                        .timeId(idWorker.nextId())
                        .remindItemId(medicineInfo.getMedicineId())
                        .remindTime(time)
                        .build();
                remindTimeList.add(remindTime);
            }
        }
        boolean medicineInfoSaved = medicineInfoService.saveBatch(medicineInfoList);
        if (medicineInfoSaved == false){
            log.error("任务-{}的药物信息{}保存失败", medicineInfoList.toString());
        }
        boolean remindTimeSaved = remindTimeService.saveBatch(remindTimeList);
        if (remindTimeSaved == false){
            log.error("任务{}的提醒时间保存失败", remindTimeList.toString());
        }
        return medicineInfoSaved && remindTimeSaved;
    }
}


