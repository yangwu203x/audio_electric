package com.enter.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 18:12
 */
@Entity
@Table(name = "tb_orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "address")
    private String address;//地址

    @Column(name = "recipients")
    private String recipients;//收件人

    @Column(name = "tel")
    private String tel;//手机号码

    @Column(name = "delivery")
    private String delivery;//配送方式

    @Column(name = "tracking_num")
    private String trackingNum;//快递单号

    @Column(name = "pay")
    private String pay;//支付方式

    @Column(name = "text")
    private String text;

    @Column(name = "order_num")
    private String orderNum;//订单编号

    @Column(name = "price")
    private Double price;//订单总价格

    @Column(name = "order_state")
    private String orderState;//订单状态

    @Column(name = "order_delivery")
    private String orderDelivery;//配送状态

    @Column(name = "order_pay")
    private String orderPay;//支付状态

    @Column(name = "pay_date")
    private Timestamp payDate;//支付时间


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Set<OrderDetail> orderDetails;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(String orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", delivery='" + delivery + '\'' +
                ", pay='" + pay + '\'' +
                ", text='" + text + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", price=" + price +
                ", orderState='" + orderState + '\'' +
                ", orderDelivery='" + orderDelivery + '\'' +
                ", orderPay='" + orderPay + '\'' +
                ", payDate=" + payDate +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
