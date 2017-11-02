package com.enter.entity;

import javax.persistence.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/21 0021 9:13
 */
@Entity
@Table(name = "tb_address_info")
public class AddressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "country_id")
    private String countryId;//国家编号
    @Column(name = "country")
    private String country;//国家
    @Column(name = "province_id")
    private String provinceId;//省编号
    @Column(name = "province")
    private String province;//省名
    @Column(name = "city_id")
    private String cityId;//城市编号
    @Column(name = "city")
    private String city;//城市名
    @Column(name = "area_id")
    private String areaId;//区编号
    @Column(name = "area")
    private String area;//区名
    @Column(name = "detail_position")
    private String  detailPosition;//详细地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetailPosition() {
        return detailPosition;
    }

    public void setDetailPosition(String detailPosition) {
        this.detailPosition = detailPosition;
    }

}
