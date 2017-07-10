package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * 我的礼物
 * @Author leo_Yang【音特】
 * @Date 2017/4/20 0020 15:04
 */
@Alias("MyGift")
public class MyGift {
    private Long id;
    private int giftId;
    private int amount;//正数为充值,负数为送礼
    private Long userId;
    private String createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
