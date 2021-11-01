package com.remindme.medicine.common.utils.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "统一请求返回对象")
public class ResultVO<T> {
    @ApiModelProperty(value = "错误代码")
    private Integer code;

    @ApiModelProperty(value = "消息")
    private String msg;

    @ApiModelProperty(value = "对应返回数据")
    private T data;

    public ResultVO(IErrorCode errorCode, T data){
        setCodeMessage(errorCode);
        setData(data);
    }

    public ResultVO setCodeMessage(IErrorCode codeMessage){
        setCode(codeMessage.getCode());
        setMsg(codeMessage.getMsg());
        return this;
    }
}
