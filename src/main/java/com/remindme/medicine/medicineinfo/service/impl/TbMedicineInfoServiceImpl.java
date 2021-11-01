package com.remindme.medicine.medicineinfo.service.impl;

import com.remindme.medicine.medicineinfo.entity.TbMedicineInfo;
import com.remindme.medicine.medicineinfo.mapper.TbMedicineInfoMapper;
import com.remindme.medicine.medicineinfo.service.TbMedicineInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 药物信息表，用于记录药物的元信息，以及服用注意事项 服务实现类
 * </p>
 *
 * @author Kongql
 * @since 2021-11-01
 */
@Service
public class TbMedicineInfoServiceImpl extends ServiceImpl<TbMedicineInfoMapper, TbMedicineInfo> implements TbMedicineInfoService {

}
