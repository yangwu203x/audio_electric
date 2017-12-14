package com.enter.entity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 18:16
 */
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "price_sale")
    private Double priceSale;//商城价
    @Column(name = "price_market")
    private Double priceMarket;//市场价
    @Column(name = "price_cost")
    private Double priceCost;//成本价
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "unit")
    private String unit;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "content")
    private String content;
    @Column(name = "title")
    private String title;
    @Column(name = "is_up")
    private Short isUp;//是否上架
    @Column(name = "is_freight")
    private Short isFreight;//是否免邮费

    @Column(name = "shelf_date")
    private Timestamp shelfDate;//发布时间
    @Column(name = "thumbnail")
    private String thumbnail;//商城缩略图图
    @Column(name = "thumbnail2")
    private String thumbnail2;//首页缩略图图
    @Column(name = "thumbnail3")
    private String thumbnail3;//订单缩略图图
    @Column(name = "thumbnail4")
    private String thumbnail4;//详情缩略图图
    @Column(name = "sn")
    private String sn;//商品编号
    @Column(name = "color")
    private String color;//颜色
    @Column(name = "warn_inventory")
    private Integer warnInventory;//库存
    @Column(name = "color_url")
    private String colorUrl;//颜色图片

    @Column(name = "position")
    private Integer position;//商城摆放位置

    @Column(name = "mobile_url")
    private String mobileUrl;//手机图片

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Set<Thumbnail> thumbnailSet;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="tb_product_parts_set",
        joinColumns=@JoinColumn(name="product_set_id", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="parts_set_id", referencedColumnName="ID"))
    private Set<Parts> partsSet;

    @Transient
    private Set<Property> propertySet;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }

    public Double getPriceMarket() {
        return priceMarket;
    }

    public void setPriceMarket(Double priceMarket) {
        this.priceMarket = priceMarket;
    }

    public Double getPriceCost() {
        return priceCost;
    }

    public void setPriceCost(Double priceCost) {
        this.priceCost = priceCost;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getIsUp() {
        return isUp;
    }

    public void setIsUp(Short isUp) {
        this.isUp = isUp;
    }

    public Short getIsFreight() {
        return isFreight;
    }

    public void setIsFreight(Short isFreight) {
        this.isFreight = isFreight;
    }

    public Integer getWarnInventory() {
        return warnInventory;
    }

    public void setWarnInventory(Integer warnInventory) {
        this.warnInventory = warnInventory;
    }

    public Timestamp getShelfDate() {
        return shelfDate;
    }

    public void setShelfDate(Timestamp shelfDate) {
        this.shelfDate = shelfDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Thumbnail> getThumbnailSet() {
        return thumbnailSet;
    }

    public void setThumbnailSet(Set<Thumbnail> thumbnailSet) {
        this.thumbnailSet = thumbnailSet;
    }

    public Set<Parts> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(Set<Parts> partsSet) {
        this.partsSet = partsSet;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getColorUrl() {
        return colorUrl;
    }

    public void setColorUrl(String colorUrl) {
        this.colorUrl = colorUrl;
    }

    public String getThumbnail2() {
        return thumbnail2;
    }

    public void setThumbnail2(String thumbnail2) {
        this.thumbnail2 = thumbnail2;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Property> getPropertySet() {
        return propertySet;
    }

    public void setPropertySet(Set<Property> propertySet) {
        this.propertySet = propertySet;
    }

    public String getThumbnail3() {
        return thumbnail3;
    }

    public void setThumbnail3(String thumbnail3) {
        this.thumbnail3 = thumbnail3;
    }

    public String getThumbnail4() {
        return thumbnail4;
    }

    public void setThumbnail4(String thumbnail4) {
        this.thumbnail4 = thumbnail4;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", priceSale=" + priceSale +
                ", priceMarket=" + priceMarket +
                ", priceCost=" + priceCost +
                ", keyword='" + keyword + '\'' +
                ", unit='" + unit + '\'' +
                ", weight=" + weight +
                ", content='" + content + '\'' +
                ", isUp=" + isUp +
                ", isFreight=" + isFreight +
                ", warnInventory=" + warnInventory +
                ", shelfDate=" + shelfDate +
                ", thumbnail='" + thumbnail + '\'' +
                ", sn='" + sn + '\'' +
                ", color='" + color + '\'' +
                ", thumbnails=" + thumbnailSet +
                ", partsSet=" + partsSet +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }
}
