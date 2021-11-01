package com.remindme.medicine.remindtask.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 提醒任务表
 * </p>
 *
 * @author Kongql
 * @since 2021-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbRemindTask implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 提醒任务id
     */
    @TableId(value = "TASK_ID", type = IdType.ID_WORKER_STR)
    private Long taskId;

    /**
     * 提醒任务的名称
     */
    @TableField("TASK_NAME")
    private String taskName;

    /**
     * 任务描述
     */
    @TableField("TASK_DESCRIPTION")
    private String taskDescription;

    /**
     * 创建者id
     */
    @TableField("CREATE_USER_ID")
    private String createUserId;

    /**
     * 任务创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 创建者姓名
     */
    @TableField("CREATE_USER_NAME")
    private String createUserName;

    /**
     * 任务开始执行时间（超过这个时间任务才开始执行，用于预设任务）
     */
    @TableField("TASK_BEGIN_TIME")
    private Date taskBeginTime;

    /**
     * 任务持续天数（超过该时间的任务视为过期任务且不再触发提醒），默认持续31天
     */
    @TableField("TASK_RUNNING_DAY")
    private Integer taskRunningDay;

    /**
     * 任务状态：wait_to_begin - 等待开始，  running - 进行中， finished - 已完成。
     */
    @TableField("TASK_STATUS")
    private String taskStatus;

    /**
     * 任务是否已删除， DEL - 已删除, VALID - 生效中 
     */
    @TableField("REMOVE_FLAG")
    private String removeFlag;


}
