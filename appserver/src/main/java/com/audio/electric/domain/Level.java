package com.audio.electric.domain;

/**
 * 等级表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Level {
    private int id;
    private int levelIntegral;//积分
    private String name;//名字
    private String logo;//图片

    public Level() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevelIntegral() {
        return levelIntegral;
    }

    public void setLevelIntegral(int levelIntegral) {
        this.levelIntegral = levelIntegral;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
