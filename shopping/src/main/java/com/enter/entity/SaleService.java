package com.enter.entity;

import javax.persistence.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/4 0004 15:31
 */
@Entity
@Table(name = "tb_sale_service")
public class SaleService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 1：未审核；2：已审核；3：已收货；4：正在处理；5已完成；6已关闭；
     */
    @Column(name = "state")
    private String state;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @Column(name = "send_way")
    private String sendWay;//退货快递方式
    @Column(name = "s_track_num")
    private String sTrackNum;//退货快递单号
    @Column(name = "receive_way")
    private String receiveWay;//返货快递方式
    @Column(name = "r_track_num")
    private String rTrackNum;//返货快递单号
    @Column(name = "service_type")
    private String serviceType;//售后类型
    @Column(name = "service_num")
    private Integer serviceNum;//售后数量
    @Column(name = "description")
    private String description;//问题描述
    @Column(name = "receiver1")
    private String receiver1;//
    @Column(name = "tel1")
    private String tel1;
    @Column(name = "province_id1")
    private String provinceId1;
    @Column(name = "city_id1")
    private String cityId1;
    @Column(name = "area_id1")
    private String areaId1;
    @Column(name = "simple_address1")
    private String simpleAddress1;
    @Column(name = "detail_address1")
    private String detailAddress1;
    @Column(name = "receiver2")
    private String receiver2;//
    @Column(name = "tel2")
    private String tel2;
    @Column(name = "province_id2")
    private String provinceId2;
    @Column(name = "city_id2")
    private String cityId2;
    @Column(name = "area_id2")
    private String areaId2;
    @Column(name = "simple_address2")
    private String simpleAddress2;
    @Column(name = "detail_address2")
    private String detailAddress2;
    @Column(name = "info")
    private String info;
    @Column(name = "submit_time")
    private String submitTime;
    @Column(name = "checked_time")
    private String checkedTime;
    @Column(name = "receive_time")
    private String receiveTime;
    @Column(name = "handle_time")
    private String handleTime;
    @Column(name = "success_time")
    private  String successTime;



    public SaleService() {
    }

    public SaleService(String state, Orders orders, String sendWay, String sTrackNum, String receiveWay, String rTrackNum, String serviceType) {
        this.state = state;
        this.orders = orders;
        this.sendWay = sendWay;
        this.sTrackNum = sTrackNum;
        this.receiveWay = receiveWay;
        this.rTrackNum = rTrackNum;
        this.serviceType = serviceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getSendWay() {
        return sendWay;
    }

    public void setSendWay(String sendWay) {
        this.sendWay = sendWay;
    }

    public String getsTrackNum() {
        return sTrackNum;
    }

    public void setsTrackNum(String sTrackNum) {
        this.sTrackNum = sTrackNum;
    }

    public String getReceiveWay() {
        return receiveWay;
    }

    public void setReceiveWay(String receiveWay) {
        this.receiveWay = receiveWay;
    }

    public String getrTrackNum() {
        return rTrackNum;
    }

    public void setrTrackNum(String rTrackNum) {
        this.rTrackNum = rTrackNum;
    }

    public Integer getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(Integer serviceNum) {
        this.serviceNum = serviceNum;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiver1() {
        return receiver1;
    }

    public void setReceiver1(String receiver1) {
        this.receiver1 = receiver1;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getProvinceId1() {
        return provinceId1;
    }

    public void setProvinceId1(String provinceId1) {
        this.provinceId1 = provinceId1;
    }

    public String getCityId1() {
        return cityId1;
    }

    public void setCityId1(String cityId1) {
        this.cityId1 = cityId1;
    }

    public String getAreaId1() {
        return areaId1;
    }

    public void setAreaId1(String areaId1) {
        this.areaId1 = areaId1;
    }

    public String getSimpleAddress1() {
        return simpleAddress1;
    }

    public void setSimpleAddress1(String simpleAddress1) {
        this.simpleAddress1 = simpleAddress1;
    }

    public String getDetailAddress1() {
        return detailAddress1;
    }

    public void setDetailAddress1(String detailAddress1) {
        this.detailAddress1 = detailAddress1;
    }

    public String getReceiver2() {
        return receiver2;
    }

    public void setReceiver2(String receiver2) {
        this.receiver2 = receiver2;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getProvinceId2() {
        return provinceId2;
    }

    public void setProvinceId2(String provinceId2) {
        this.provinceId2 = provinceId2;
    }

    public String getCityId2() {
        return cityId2;
    }

    public void setCityId2(String cityId2) {
        this.cityId2 = cityId2;
    }

    public String getAreaId2() {
        return areaId2;
    }

    public void setAreaId2(String areaId2) {
        this.areaId2 = areaId2;
    }

    public String getSimpleAddress2() {
        return simpleAddress2;
    }

    public void setSimpleAddress2(String simpleAddress2) {
        this.simpleAddress2 = simpleAddress2;
    }

    public String getDetailAddress2() {
        return detailAddress2;
    }

    public void setDetailAddress2(String detailAddress2) {
        this.detailAddress2 = detailAddress2;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getCheckedTime() {
        return checkedTime;
    }

    public void setCheckedTime(String checkedTime) {
        this.checkedTime = checkedTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }
}
