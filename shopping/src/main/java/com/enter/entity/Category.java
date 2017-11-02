package com.enter.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 18:02
 */
@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;//名称
    @OneToOne
    @JoinColumn(name="price_id",updatable = false)
    private Price price;//价格id
    @OneToMany
    @JoinColumn(name = "category_id",updatable = false)
    private Set<Product> products;
    @Column(name = "info")
    private String info;//介绍
    @Column(name = "sId")
    private Long sId;//父级id

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }
}
