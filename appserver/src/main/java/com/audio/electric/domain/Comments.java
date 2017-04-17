package com.audio.electric.domain;

/**
 * 评论表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Comments {
    private long id;
    private long porfolioId;//作品id
    private String content;//评论内容
    private long userId;//评论者id
    private long toUserId;//评论对象的id

    public Comments() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPorfolioId() {
        return porfolioId;
    }

    public void setPorfolioId(long porfolioId) {
        this.porfolioId = porfolioId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
