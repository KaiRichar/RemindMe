package com.remindme.medicine.common.utils.entity.response;

/**
 * 获取错误代码和错误消息的接口方法
 */
public interface IErrorCode {
    /**
     * 得到错误代码
     * @return
     */
    Integer getCode();

    /**
     * 得到错误消息
     * @return
     */
    String getMsg();
}
