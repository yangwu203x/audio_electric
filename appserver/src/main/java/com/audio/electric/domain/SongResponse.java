package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/2 0002 13:59
 */
@Alias("SongResponse")
public class SongResponse implements Serializable{

    private String id="";
    private String orderTime="";
    private String name="";
    private String songId="";
    private String spell="";
    private Integer collections = 0;
    private String singerName="";
    private String singerId="";
    private String singerPinyin = "";

    public SongResponse() {
    }

    public SongResponse(String id, String orderTime, String name, String songId, String spell, Integer collections, String singerName, String singerId, String singerPinyin) {
        this.id = id;
        this.orderTime = orderTime;
        this.name = name;
        this.songId = songId;
        this.spell = spell;
        this.collections = collections;
        this.singerName = singerName;
        this.singerId = singerId;
        this.singerPinyin = singerPinyin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public Integer getCollections() {
        return collections;
    }

    public void setCollections(Integer collections) {
        this.collections = collections;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getSingerPinyin() {
        return singerPinyin;
    }

    public void setSingerPinyin(String singerPinyin) {
        this.singerPinyin = singerPinyin;
    }

    @Override
    public String toString() {
        return "SongResponse{" +
                "id='" + id + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", name='" + name + '\'' +
                ", songId='" + songId + '\'' +
                ", spell='" + spell + '\'' +
                ", collections=" + collections +
                ", singerName='" + singerName + '\'' +
                ", singerId='" + singerId + '\'' +
                ", singerPinyin='" + singerPinyin + '\'' +
                '}';
    }
}
