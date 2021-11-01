package com.remindme.medicine.common.utils;

import com.remindme.medicine.common.utils.entity.response.IErrorCode;
import com.remindme.medicine.common.utils.entity.response.ResponseCode;
import com.remindme.medicine.common.utils.entity.response.ResultVO;

public class ResultVOUtil {

    /*
      * @description: 返回成功的对象
      * @param data:
      * @return: com.remindme.medicine.common.utils.entity.response.ResultVO
      * @throws
    　* @date 31/10/2021 4:13 pm
    */
    public static ResultVO success(Object data){
        return new ResultVO(ResponseCode.SUCCESS, data);
    }

    /**
      * @description: 返回失败的对象
      * @param data:
      * @return: com.remindme.medicine.common.utils.entity.response.ResultVO
      * @throws
    　* @date 31/10/2021 4:31 pm
    */
    public static ResultVO fail(Object data){
        return new ResultVO(ResponseCode.SYS_ERROR, data);
    }
}
