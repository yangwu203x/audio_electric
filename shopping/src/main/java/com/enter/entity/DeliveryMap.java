package com.enter.entity;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/28 0028 10:59
 */
public class DeliveryMap {
    private String dateStr;
    private String timeStr;
    private String detailStr;

    public DeliveryMap(String dateStr,String timeStr, String detailStr) {
        this.dateStr = dateStr;
        this.timeStr = timeStr;
        this.detailStr = detailStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getDetailStr() {
        return detailStr;
    }

    public void setDetailStr(String detailStr) {
        this.detailStr = detailStr;
    }
}
