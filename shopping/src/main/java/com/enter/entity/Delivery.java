package com.enter.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/28 0028 10:48
 */
public class Delivery {
    private String dateStr;
    private String weekStr;
    private List<DeliveryMap> deliveryMaps = new ArrayList<>();


    public Delivery() {
    }

    public Delivery(String dateStr, String weekStr) {
        this.dateStr = dateStr;
        this.weekStr = weekStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getWeekStr() {
        return weekStr;
    }

    public void setWeekStr(String weekStr) {
        this.weekStr = weekStr;
    }

    public List<DeliveryMap> getDeliveryMaps() {
        return deliveryMaps;
    }

    public void setDeliveryMaps(List<DeliveryMap> deliveryMaps) {
        this.deliveryMaps = deliveryMaps;
    }
}
