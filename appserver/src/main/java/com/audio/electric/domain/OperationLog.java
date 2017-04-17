package com.audio.electric.domain;

/**
 * 操作日志表
 * Created by Administrator on 2017/3/17 0017.
 */
public class OperationLog {
    private long id;
    private long userId;//用户id
    private int operationId;//操作id
    private String createDate;//操作时间
    private String description;//描述

    public OperationLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
