package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/13 0013 10:15
 */
@Alias("Shield")
public class Shield {
    private long userId;
    private long toUserId;

    public Shield() {
    }

    public Shield(long userId, long toUserId) {
        this.userId = userId;
        this.toUserId = toUserId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }
}
