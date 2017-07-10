package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("SongLack")
public class SongLack implements Serializable {
    private Integer id;

    private String songName;

    private String singerName;

    private String userId;

    private String searchback;

    private String other;

    private String createDate;

    private String status;

    private String langName;//语种

    private static final long serialVersionUID = 1L;

    public SongLack(Integer id, String songName, String singerName, String userId, String searchback, String other, String createDate, String status) {
        this.id = id;
        this.songName = songName;
        this.singerName = singerName;
        this.userId = userId;
        this.searchback = searchback;
        this.other = other;
        this.createDate = createDate;
        this.status = status;
    }

    public SongLack() {
        super();
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSearchback() {
        return searchback;
    }

    public void setSearchback(String searchback) {
        this.searchback = searchback == null ? null : searchback.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SongLack other = (SongLack) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSongName() == null ? other.getSongName() == null : this.getSongName().equals(other.getSongName()))
            && (this.getSingerName() == null ? other.getSingerName() == null : this.getSingerName().equals(other.getSingerName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSearchback() == null ? other.getSearchback() == null : this.getSearchback().equals(other.getSearchback()))
            && (this.getOther() == null ? other.getOther() == null : this.getOther().equals(other.getOther()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSongName() == null) ? 0 : getSongName().hashCode());
        result = prime * result + ((getSingerName() == null) ? 0 : getSingerName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSearchback() == null) ? 0 : getSearchback().hashCode());
        result = prime * result + ((getOther() == null) ? 0 : getOther().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}