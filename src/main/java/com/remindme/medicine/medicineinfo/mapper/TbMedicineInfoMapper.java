package com.remindme.medicine.medicineinfo.mapper;

import com.remindme.medicine.medicineinfo.entity.TbMedicineInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 药物信息表，用于记录药物的元信息，以及服用注意事项 Mapper 接口
 * </p>
 *
 * @author Kongql
 * @since 2021-11-01
 */
@Mapper
public interface TbMedicineInfoMapper extends BaseMapper<TbMedicineInfo> {

}
