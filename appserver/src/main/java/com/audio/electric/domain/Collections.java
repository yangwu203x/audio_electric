package com.audio.electric.domain;

/**
 * 收藏表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Collections {
    private long userId;//用户id
    private long porfolioId;//作品id
    private String createDate;//创建时间

    public Collections() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPorfolioId() {
        return porfolioId;
    }

    public void setPorfolioId(long porfolioId) {
        this.porfolioId = porfolioId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
