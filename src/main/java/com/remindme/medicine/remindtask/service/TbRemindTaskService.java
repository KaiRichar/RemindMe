package com.remindme.medicine.remindtask.service;

import com.remindme.medicine.remindtask.entity.TbRemindTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.remindme.medicine.remindtask.entity.param.RemindTaskSaveParamVO;

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
}
