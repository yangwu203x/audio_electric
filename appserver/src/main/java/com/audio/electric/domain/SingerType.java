package com.audio.electric.domain;

/**
 * 歌手类型表
 * Created by Administrator on 2017/3/17 0017.
 */
public class SingerType {
    private int id;
    private String name;//类型名
    private String createDate;//创建时间
    private String status;//状态

    public SingerType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
