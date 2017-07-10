package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
@Alias("Singer")
public class Singer implements Serializable {
    private Integer id;

    private String singerName;

    private String singerType;

    private String singerPinyin;

    private Integer singerOdertimes;

    private String headerPath;

    private String status;

    private String songCount;

    private String singerNation;

    private String prefixPath;

    private String serverUrl;

    private String singerNo;

    private Integer singerZs;

    private Date singerVersion;

    private static final long serialVersionUID = 1L;

    public Singer(Integer id, String singerName, String singerType, String singerPinyin, Integer singerOdertimes, String headerPath, String status, String songCount, String singerNation, String prefixPath, String serverUrl, String singerNo, Integer singerZs, Date singerVersion) {
        this.id = id;
        this.singerName = singerName;
        this.singerType = singerType;
        this.singerPinyin = singerPinyin;
        this.singerOdertimes = singerOdertimes;
        this.headerPath = headerPath;
        this.status = status;
        this.songCount = songCount;
        this.singerNation = singerNation;
        this.prefixPath = prefixPath;
        this.serverUrl = serverUrl;
        this.singerNo = singerNo;
        this.singerZs = singerZs;
        this.singerVersion = singerVersion;
    }

    public Singer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    public String getSingerType() {
        return singerType;
    }

    public void setSingerType(String singerType) {
        this.singerType = singerType == null ? null : singerType.trim();
    }

    public String getSingerPinyin() {
        return singerPinyin;
    }

    public void setSingerPinyin(String singerPinyin) {
        this.singerPinyin = singerPinyin == null ? null : singerPinyin.trim();
    }

    public Integer getSingerOdertimes() {
        return singerOdertimes;
    }

    public void setSingerOdertimes(Integer singerOdertimes) {
        this.singerOdertimes = singerOdertimes;
    }

    public String getHeaderPath() {
        return headerPath;
    }

    public void setHeaderPath(String headerPath) {
        this.headerPath = headerPath == null ? null : headerPath.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSongCount() {
        return songCount;
    }

    public void setSongCount(String songCount) {
        this.songCount = songCount == null ? null : songCount.trim();
    }

    public String getSingerNation() {
        return singerNation;
    }

    public void setSingerNation(String singerNation) {
        this.singerNation = singerNation == null ? null : singerNation.trim();
    }

    public String getPrefixPath() {
        return prefixPath;
    }

    public void setPrefixPath(String prefixPath) {
        this.prefixPath = prefixPath == null ? null : prefixPath.trim();
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl == null ? null : serverUrl.trim();
    }

    public String getSingerNo() {
        return singerNo;
    }

    public void setSingerNo(String singerNo) {
        this.singerNo = singerNo == null ? null : singerNo.trim();
    }

    public Integer getSingerZs() {
        return singerZs;
    }

    public void setSingerZs(Integer singerZs) {
        this.singerZs = singerZs;
    }

    public Date getSingerVersion() {
        return singerVersion;
    }

    public void setSingerVersion(Date singerVersion) {
        this.singerVersion = singerVersion;
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
        Singer other = (Singer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSingerName() == null ? other.getSingerName() == null : this.getSingerName().equals(other.getSingerName()))
            && (this.getSingerType() == null ? other.getSingerType() == null : this.getSingerType().equals(other.getSingerType()))
            && (this.getSingerPinyin() == null ? other.getSingerPinyin() == null : this.getSingerPinyin().equals(other.getSingerPinyin()))
            && (this.getSingerOdertimes() == null ? other.getSingerOdertimes() == null : this.getSingerOdertimes().equals(other.getSingerOdertimes()))
            && (this.getHeaderPath() == null ? other.getHeaderPath() == null : this.getHeaderPath().equals(other.getHeaderPath()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSongCount() == null ? other.getSongCount() == null : this.getSongCount().equals(other.getSongCount()))
            && (this.getSingerNation() == null ? other.getSingerNation() == null : this.getSingerNation().equals(other.getSingerNation()))
            && (this.getPrefixPath() == null ? other.getPrefixPath() == null : this.getPrefixPath().equals(other.getPrefixPath()))
            && (this.getServerUrl() == null ? other.getServerUrl() == null : this.getServerUrl().equals(other.getServerUrl()))
            && (this.getSingerNo() == null ? other.getSingerNo() == null : this.getSingerNo().equals(other.getSingerNo()))
            && (this.getSingerZs() == null ? other.getSingerZs() == null : this.getSingerZs().equals(other.getSingerZs()))
            && (this.getSingerVersion() == null ? other.getSingerVersion() == null : this.getSingerVersion().equals(other.getSingerVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSingerName() == null) ? 0 : getSingerName().hashCode());
        result = prime * result + ((getSingerType() == null) ? 0 : getSingerType().hashCode());
        result = prime * result + ((getSingerPinyin() == null) ? 0 : getSingerPinyin().hashCode());
        result = prime * result + ((getSingerOdertimes() == null) ? 0 : getSingerOdertimes().hashCode());
        result = prime * result + ((getHeaderPath() == null) ? 0 : getHeaderPath().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSongCount() == null) ? 0 : getSongCount().hashCode());
        result = prime * result + ((getSingerNation() == null) ? 0 : getSingerNation().hashCode());
        result = prime * result + ((getPrefixPath() == null) ? 0 : getPrefixPath().hashCode());
        result = prime * result + ((getServerUrl() == null) ? 0 : getServerUrl().hashCode());
        result = prime * result + ((getSingerNo() == null) ? 0 : getSingerNo().hashCode());
        result = prime * result + ((getSingerZs() == null) ? 0 : getSingerZs().hashCode());
        result = prime * result + ((getSingerVersion() == null) ? 0 : getSingerVersion().hashCode());
        return result;
    }
}