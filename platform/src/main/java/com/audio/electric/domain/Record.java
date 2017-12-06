package com.audio.electric.domain;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/9/25 0025 11:06
 */
public class Record {
    private String dateStr;
    private String ip;
    private String address;

    public Record() {
    }
    public Record(String[] strs) {
        this.dateStr = strs[0];
        this.ip = strs[1];
        this.address = strs[2];
    }

    public Record(String dateStr, String ip, String address) {
        this.dateStr = dateStr;
        this.ip = ip;
        this.address = address;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Record{" +
                "dateStr='" + dateStr + '\'' +
                ", ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
