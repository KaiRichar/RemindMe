package com.remindme.medicine.remindtask.entity.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author 开飞机的猪
 * @title: MedicineRemindTimeParamVO
 * @projectName RemindMe
 * @description: 药物提醒时间参数实体
 * @date 1/11/2021 9:07 pm
 */
@Data
@ApiModel("药物提醒时间参数实体")
public class MedicineRemindTimeParamVO {
    /**
     * 药物名称
     */
    private String medicineName;

    /**
     * 药物备注信息，注意事项等
     */
    private String medicineRemark;

    /**
     * 提醒时间
     */
    private String remindTime;
}
