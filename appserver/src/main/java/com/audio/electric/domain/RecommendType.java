package com.audio.electric.domain;

/**
 * 歌曲推荐类型表
 * Created by Administrator on 2017/3/17 0017.
 */
public class RecommendType {
    private int id;
    private String name;//推荐类型名
    private String createDate;//创建时间

    public RecommendType() {
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
}
