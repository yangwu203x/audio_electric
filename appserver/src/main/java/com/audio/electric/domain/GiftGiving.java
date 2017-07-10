package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * 送礼表
 * Created by Administrator on 2017/3/17 0017.
 */
@Alias("GiftGiving")
public class GiftGiving {
    private int id;
    private long userId;
    private int giftId;
    private long portfolioId;
    private String createDate;
    private int amount;

    public GiftGiving() {
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

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
