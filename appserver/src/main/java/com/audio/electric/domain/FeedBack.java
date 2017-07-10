package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/4 0004 13:17
 */
@Alias("feedBack")
public class FeedBack {

    private int id;
    private String msg;
    private long userId;

    public FeedBack() {
    }

    public FeedBack(int id, String msg, long userId) {
        this.id = id;
        this.msg = msg;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
