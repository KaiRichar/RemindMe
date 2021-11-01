package com.remindme.medicine.common.utils.entity.response;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
public enum ResponseCode implements IErrorCode {

    SUCCESS(0, "操作成功"),
    SYS_ERROR(1000, "系统错误，稍后再试！");

    private Integer code;

    private String msg;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
