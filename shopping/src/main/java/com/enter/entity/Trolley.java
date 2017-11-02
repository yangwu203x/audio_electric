package com.enter.entity;

import javax.persistence.*;

/**
 * 购物车
 * @Author leo_Yang【音特】
 * @Date 2017/10/16 0016 10:00
 */
@Entity
@Table(name = "tb_trolley")
public class Trolley {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "sub_total")
    private Double subTotal;
    @Column(name = "count")
    private Integer count;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "status",columnDefinition = "0")
    private int status;//购物车状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Trolley{" +
                "id=" + id +
                ", product=" + product +
                ", subTotal=" + subTotal +
                ", count=" + count +
                ", user=" + user +
                '}';
    }
}
