package com.audio.electric.domain;

/**
 * 节目表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Program {
    private int id;
    private int typeId;//节目类型id
    private String name;//节目版本
    private String createDate;//创建时间

    public Program() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
