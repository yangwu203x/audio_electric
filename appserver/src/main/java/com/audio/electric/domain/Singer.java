package com.audio.electric.domain;

import java.util.Date;

/**
 * 歌手表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Singer {
    private long id;
    private String name;//歌星名字
    private int singerTypeId;//歌手类型
    private String singerPinyin;//歌手拼音
    private int singerZs;//歌手名字数
    private long singerOrdertimes;//歌手点击量
    private String headerPath;//头像
    private Date singerVersion;//出道时间
    private String status;//状态
    private int songCount;//作品数量
    private String singerNation;//歌手国籍

    public Singer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSingerTypeId() {
        return singerTypeId;
    }

    public void setSingerTypeId(int singerTypeId) {
        this.singerTypeId = singerTypeId;
    }

    public String getSingerPinyin() {
        return singerPinyin;
    }

    public void setSingerPinyin(String singerPinyin) {
        this.singerPinyin = singerPinyin;
    }

    public int getSingerZs() {
        return singerZs;
    }

    public void setSingerZs(int singerZs) {
        this.singerZs = singerZs;
    }

    public long getSingerOrdertimes() {
        return singerOrdertimes;
    }

    public void setSingerOrdertimes(long singerOrdertimes) {
        this.singerOrdertimes = singerOrdertimes;
    }

    public String getHeaderPath() {
        return headerPath;
    }

    public void setHeaderPath(String headerPath) {
        this.headerPath = headerPath;
    }

    public Date getSingerVersion() {
        return singerVersion;
    }

    public void setSingerVersion(Date singerVersion) {
        this.singerVersion = singerVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public String getSingerNation() {
        return singerNation;
    }

    public void setSingerNation(String singerNation) {
        this.singerNation = singerNation;
    }
}
