package com.audio.electric.domain;

/**
 * 歌曲风格表
 * Created by Administrator on 2017/3/17 0017.
 */
public class SongScene {
    private int id;
    private  String name;//风格名
    private String createDate;//创建时间

    public SongScene() {
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
