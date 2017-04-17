package com.audio.electric.domain;

/**
 * 在线用户统计表
 * Created by Administrator on 2017/3/17 0017.
 */
public class UserOnline {
    private long id;
    private long userId;//用户id
    private String loginDate;//登陆时间
    private String status;//登陆状态 0:下线；1：上线

    public UserOnline() {
    }

    public UserOnline( long userId, String loginDate, String status) {
        this.userId = userId;
        this.loginDate = loginDate;
        this.status = status;
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

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
