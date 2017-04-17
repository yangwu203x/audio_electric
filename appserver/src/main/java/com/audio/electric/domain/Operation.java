package com.audio.electric.domain;

/**
 * 操作表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Operation {
    private int id;
    private String content;//操作
    private String func;//函数
    private String description;//描述

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
