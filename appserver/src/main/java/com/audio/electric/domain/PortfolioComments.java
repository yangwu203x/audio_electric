package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/13 0013 9:48
 */
@Alias("PortfolioComments")
public class PortfolioComments {
    private long id;
    private long userId;
    private long toUserId = 0l;//默认为0
    private long portfolioId;
    private String content;
    private Date createDate;

    public PortfolioComments() {
    }

    public PortfolioComments(long id, long userId, long toUserId, long portfolioId, String content, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.toUserId = toUserId;
        this.portfolioId = portfolioId;
        this.content = content;
        this.createDate = createDate;
    }

    public long getId() {
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

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
