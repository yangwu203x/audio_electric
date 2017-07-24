package com.audio.electric.domain;


import org.apache.ibatis.type.Alias;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 11:37
 */
@Alias("Apk")
public class Apk {
    private int id;//id
    private String apkName;//apk文件名
    private String apkVersion;//apk版本号
    private String apkPath;//apk文件路径
    private String serverUrl;//服务器下载
    private int status;//状态,1:线上版本
    private int type ;//类型

    public Apk(int id, String apkName, String apkVersion, String apkPath, String serverUrl, int status) {
        this.id = id;
        this.apkName = apkName;
        this.apkVersion = apkVersion;
        this.apkPath = apkPath;
        this.serverUrl = serverUrl;
        this.status = status;
    }

    public Apk() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getApkVersion() {
        return apkVersion;
    }

    public void setApkVersion(String apkVersion) {
        this.apkVersion = apkVersion;
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath(String apkPath) {
        this.apkPath = apkPath;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
