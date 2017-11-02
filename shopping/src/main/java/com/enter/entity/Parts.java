package com.enter.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 配件
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 17:15
 */
@Entity
@Table(name = "tb_parts")
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "pic_url")
    private String picUrl;
    @Column(name = "server_url")
    private String serverUrl;
    @Column(name = "info")
    private String info;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }


    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
