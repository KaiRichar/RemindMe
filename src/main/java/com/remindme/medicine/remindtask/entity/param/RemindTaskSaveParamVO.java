package com.remindme.medicine.remindtask.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("提醒任务的保存参数对象")
@Data
public class RemindTaskSaveParamVO {

    /**
     * 提醒任务的名称
     */
    @ApiModelProperty("提醒任务的名称")
    private String taskName;

    /**
     * 任务描述
     */
    @ApiModelProperty("任务描述")
    private String taskDescription;

    /**
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private String createUserId;

    /**
     * 创建者姓名
     */
    @ApiModelProperty("创建者姓名")
    private String createUserName;

    /**
     * 任务开始执行时间（超过这个时间任务才开始执行，用于预设任务）
     */
    @ApiModelProperty("任务开始执行时间（超过这个时间任务才开始执行，用于预设任务）")
    private Date taskBeginTime;

    /**
     * 任务持续天数（超过该时间的任务视为过期任务且不再触发提醒），默认持续31天
     */
    @ApiModelProperty("任务持续天数（超过该时间的任务视为过期任务且不再触发提醒），默认持续31天")
    private Integer taskRunningDay;

}
