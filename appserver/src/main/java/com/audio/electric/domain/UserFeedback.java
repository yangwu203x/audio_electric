package com.audio.electric.domain;

/**
 * 用户反馈表
 * Created by Administrator on 2017/3/17 0017.
 */
public class UserFeedback {
    private int id;
    private  long userId;//用户id
    private String content;//反馈内容
    private String createTime;//反馈时间
    private String handleTime;//处理时间
    private String status;//处理状态

    public UserFeedback() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
