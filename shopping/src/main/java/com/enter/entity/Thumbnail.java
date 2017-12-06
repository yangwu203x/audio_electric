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
    @Column(name = "pic_url2")
    private String picUrl2;
    @Column(name = "pic_url3")
    private String picUrl3;
    @Column(name = "server_url")
    private String ServerUrl;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "selected")
    private Integer selected;
    @Column(name = "position")
    private Integer position;

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


    public String getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }

    public String getPicUrl3() {
        return picUrl3;
    }

    public void setPicUrl3(String picUrl3) {
        this.picUrl3 = picUrl3;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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
