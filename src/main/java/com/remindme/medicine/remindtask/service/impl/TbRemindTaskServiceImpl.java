package com.remindme.medicine.remindtask.service.impl;

import cn.hutool.core.date.DateUnit;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.remindme.medicine.common.utils.SnowflakeIdUtils;
import com.remindme.medicine.remindtask.entity.TbRemindTask;
import com.remindme.medicine.remindtask.entity.param.RemindTaskSaveParamVO;
import com.remindme.medicine.remindtask.exception.TaskAccountReachMaxException;
import com.remindme.medicine.remindtask.mapper.TbRemindTaskMapper;
import com.remindme.medicine.remindtask.service.TbRemindTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        if (this.count(wrapper) >= MAX_TASK_COUNT_FOR_SINGLE_USER){
            throw new TaskAccountReachMaxException();
        }
        TbRemindTask remindTask = new TbRemindTask();
        BeanUtils.copyProperties(paramVO, remindTask);
        SnowflakeIdUtils idWorker = new SnowflakeIdUtils(3, 1);
        remindTask.setTaskId(idWorker.nextId());
        //任务的初始状态都为就绪状态
        remindTask.setTaskStatus("wait_to_begin");
        return this.save(remindTask);
    }

}
