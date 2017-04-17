package com.audio.electric.domain;

/**
 * 屏蔽表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Shield {
    private long userId;//用户id
    private long beUserId;//屏蔽用户的id

    public Shield() {
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
}
