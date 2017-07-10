package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 16:37
 */
@Alias("Product")
public class Product {
    private int id;
    private String type;
    private String expirydate;
    private String mac;

    public Product(int id, String type, String expirydate, String mac) {
        this.id = id;
        this.type = type;
        this.expirydate = expirydate;
        this.mac = mac;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
