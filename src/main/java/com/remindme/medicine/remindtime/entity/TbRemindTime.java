package com.remindme.medicine.remindtime.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 提醒时间表
 * </p>
 *
 * @author Kongql
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbRemindTime implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 提醒时间数据id
     */
    @TableId(value = "time_id", type = IdType.ID_WORKER_STR)
    private String timeId;

    /**
     * 提醒时间
     */
    private String remindTime;

    /**
     * 数据生成时间
     */
    private Date createTime;

    /**
     * 对应提醒条目id
     */
    private String remindItemId;


}
