package com.audio.electric.domain;

import java.io.Serializable;

public class Apk implements Serializable {
    private Integer id;

    private String apkName;

    private String apkVersion;

    private String apkPath;

    private String apkDownPath;

    private String serverUrl;

    private String type;

    private static final long serialVersionUID = 1L;

    public Apk(Integer id, String apkName, String apkVersion, String apkPath, String apkDownPath, String serverUrl, String type) {
        this.id = id;
        this.apkName = apkName;
        this.apkVersion = apkVersion;
        this.apkPath = apkPath;
        this.apkDownPath = apkDownPath;
        this.serverUrl = serverUrl;
        this.type = type;
    }

    public Apk() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName == null ? null : apkName.trim();
    }

    public String getApkVersion() {
        return apkVersion;
    }

    public void setApkVersion(String apkVersion) {
        this.apkVersion = apkVersion == null ? null : apkVersion.trim();
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath(String apkPath) {
        this.apkPath = apkPath == null ? null : apkPath.trim();
    }

    public String getApkDownPath() {
        return apkDownPath;
    }

    public void setApkDownPath(String apkDownPath) {
        this.apkDownPath = apkDownPath == null ? null : apkDownPath.trim();
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl == null ? null : serverUrl.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
        Apk other = (Apk) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getApkName() == null ? other.getApkName() == null : this.getApkName().equals(other.getApkName()))
            && (this.getApkVersion() == null ? other.getApkVersion() == null : this.getApkVersion().equals(other.getApkVersion()))
            && (this.getApkPath() == null ? other.getApkPath() == null : this.getApkPath().equals(other.getApkPath()))
            && (this.getApkDownPath() == null ? other.getApkDownPath() == null : this.getApkDownPath().equals(other.getApkDownPath()))
            && (this.getServerUrl() == null ? other.getServerUrl() == null : this.getServerUrl().equals(other.getServerUrl()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getApkName() == null) ? 0 : getApkName().hashCode());
        result = prime * result + ((getApkVersion() == null) ? 0 : getApkVersion().hashCode());
        result = prime * result + ((getApkPath() == null) ? 0 : getApkPath().hashCode());
        result = prime * result + ((getApkDownPath() == null) ? 0 : getApkDownPath().hashCode());
        result = prime * result + ((getServerUrl() == null) ? 0 : getServerUrl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}