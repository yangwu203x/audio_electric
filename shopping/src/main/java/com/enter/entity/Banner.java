package com.enter.entity;

import javax.persistence.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:50
 */
@Entity
@Table(name = "tb_banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "pic_url")
    private String picUrl;
    @Column(name = "pic_url2")
    private String picUrl2;
    @Column(name = "info")
    private String info;

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
