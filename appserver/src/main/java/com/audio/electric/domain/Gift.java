package com.audio.electric.domain;

/**
 * 礼物表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Gift {
    private int id;
    private String name;//礼物名字
    private String logo;//图片
    private int integral;//所需积分
    private String createDate;//创建时间

    public Gift() {
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
