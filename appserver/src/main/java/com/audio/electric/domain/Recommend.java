package com.audio.electric.domain;

/**
 * 推荐表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Recommend {
    private int id;
    private int recommendId;//推荐类型id
    private long songId;//推荐歌曲的id
    private String createDate;//创建时间
    private String status;//状态

    public Recommend() {
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(int recommendId) {
        this.recommendId = recommendId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
