package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * 关注表
 * Created by Administrator on 2017/3/17 0017.
 */
@Alias("Attention")
public class Attention {
    private long userId;//用户id
    private long beUserId;//关注用户的id
    private String createDate;//创建时间

    public Attention() {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
