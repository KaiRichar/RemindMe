package com.remindme.medicine.remindtask.exception;

/**
 * 任务创建异常，数量达到上限
 */
public class TaskAccountReachMaxException extends Exception {

    public TaskAccountReachMaxException() {
        super("任务数量已经达到最大可创建上限！");
    }

}
