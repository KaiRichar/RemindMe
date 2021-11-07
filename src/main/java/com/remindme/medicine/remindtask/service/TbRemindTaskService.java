package com.remindme.medicine.remindtask.service;

import com.remindme.medicine.remindtask.entity.TbRemindTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.remindme.medicine.remindtask.entity.param.MedicineRemindTimeParamVO;
import com.remindme.medicine.remindtask.entity.param.RemindTaskSaveParamVO;

import java.util.List;

/**
 * <p>
 * 提醒任务表 服务类
 * </p>
 *
 * @author Kongql
 * @since 2021-10-24
 */
public interface TbRemindTaskService extends IService<TbRemindTask> {

    /**
     * 保存提醒任务
     * @param paramVO
     * @return
     */
    boolean saveRemindTask(RemindTaskSaveParamVO paramVO) throws Exception;
    /**
      * @description: 保存药物信息和对应的提醒时间
      * @param taskId: 提醒任务id
     *  @param paramList:
      * @return: boolean
      * @throws
    　* @date 7/11/2021  3:53 pm
    */
    boolean saveMedicineInfoWithRemindTimeBatch(Long taskId, List<MedicineRemindTimeParamVO> paramList);
}
