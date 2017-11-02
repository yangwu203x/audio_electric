package com.enter.entity;

import javax.persistence.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 17:00
 */
@Entity
@Table(name = "tb_thumbnail")
public class Thumbnail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "pic_url")
    private String picUrl;
    @Column(name = "server_url")
    private String ServerUrl;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "selected")
    private Integer selected;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }


    public String getServerUrl() {
        return ServerUrl;
    }

    public void setServerUrl(String serverUrl) {
        ServerUrl = serverUrl;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "id=" + id +
                ", picUrl='" + picUrl + '\'' +
                ", ServerUrl='" + ServerUrl + '\'' +
                ", productId=" + productId +
                ", selected=" + selected +
                '}';
    }
}
