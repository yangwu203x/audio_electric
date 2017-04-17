package com.audio.electric.domain;

/**
 * 举报表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Resport {
    private int id;
    private long userId;//用户id
    private long beUserId;//举报用户的id
    private String state;//处理状态
    private String createTime;//举报时间
    private long portfolioId;//作品id

    public Resport() {
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

    public long getBeUserId() {
        return beUserId;
    }

    public void setBeUserId(long beUserId) {
        this.beUserId = beUserId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }
}
