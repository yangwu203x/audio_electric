package com.audio.electric.domain;

/**
 * 节目类型表
 * Created by Administrator on 2017/3/17 0017.
 */
public class ProgramType {
    private int id;
    private String name;//节目类型名
    private String createDate;//创建时间

    public ProgramType() {
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
