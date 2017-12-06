package com.enter.entity;

import java.io.Serializable;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/6 0006 18:42
 */
public class StateCount implements Serializable{
    private String state;
    private Long num;

    public StateCount(String state, Long num) {
        this.state = state;
        this.num = num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
