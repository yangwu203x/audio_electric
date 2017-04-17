package com.audio.electric.domain;

/**
 * 歌曲表
 * Created by Administrator on 2017/3/17 0017.
 */
public class Song {
    private long id;
    private String name;//歌曲名
    private int singerId;//歌星代号
    private String songFormat;//歌曲文件格式
    private int songZs;//歌曲字数
    private String spell;//歌曲拼音
    private int volume;//默认音量
    private int volumeMin;//最小音量
    private int volumeMax;//最大音量
    private String strack;//手写数据
    private String receivingDate;//更新时间
    private long orderTime;//预订次数
    private String songPath;//歌曲路径
    private String photoPath;//图片
    private String classicStatus;//是否经典老歌
    private String songInfo;//描述
    private String status;//状态
    private long searchTimes;//搜索次数
    private int programId;//节目id
    private String songVersion;//vod版本

    public Song() {
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

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSongFormat() {
        return songFormat;
    }

    public void setSongFormat(String songFormat) {
        this.songFormat = songFormat;
    }

    public int getSongZs() {
        return songZs;
    }

    public void setSongZs(int songZs) {
        this.songZs = songZs;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolumeMin() {
        return volumeMin;
    }

    public void setVolumeMin(int volumeMin) {
        this.volumeMin = volumeMin;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    public String getStrack() {
        return strack;
    }

    public void setStrack(String strack) {
        this.strack = strack;
    }

    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getClassicStatus() {
        return classicStatus;
    }

    public void setClassicStatus(String classicStatus) {
        this.classicStatus = classicStatus;
    }

    public String getSongInfo() {
        return songInfo;
    }

    public void setSongInfo(String songInfo) {
        this.songInfo = songInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(long searchTimes) {
        this.searchTimes = searchTimes;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getSongVersion() {
        return songVersion;
    }

    public void setSongVersion(String songVersion) {
        this.songVersion = songVersion;
    }
}
