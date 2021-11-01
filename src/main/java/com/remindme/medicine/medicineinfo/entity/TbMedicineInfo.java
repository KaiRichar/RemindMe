package com.remindme.medicine.medicineinfo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 药物信息表，用于记录药物的元信息，以及服用注意事项
 * </p>
 *
 * @author Kongql
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbMedicineInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 药物数据id
     */
    @TableId(value = "medicine_id", type = IdType.ID_WORKER_STR)
    private String medicineId;

    /**
     * 药物名称
     */
    private String medicineName;

    /**
     * 药物备注信息，注意事项等
     */
    private String medicineRemark;

    /**
     * 所属任务id
     */
    private String taskId;

    /**
     * 数据生成时间
    */
    private Date createTime;


}
