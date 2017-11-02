package com.enter.entity;

import javax.persistence.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/16 0016 10:37
 */
@Entity
@Table(name = "tb_price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "price_left")
    private Double priceLeft;
    @Column(name = "price_right")
    private Double priceRight;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getPriceLeft() {
        return priceLeft;
    }

    public void setPriceLeft(Double priceLeft) {
        this.priceLeft = priceLeft;
    }


    public Double getPriceRight() {
        return priceRight;
    }

    public void setPriceRight(Double priceRight) {
        this.priceRight = priceRight;
    }
}
