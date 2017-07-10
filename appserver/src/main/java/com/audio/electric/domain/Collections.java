package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * 收藏表
 * Created by Administrator on 2017/3/17 0017.
 */
@Alias("Collections")
public class Collections {
    private long userId;//用户id
    private long portfolioId;//作品id
    private String createDate;//创建时间

    public Collections() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
