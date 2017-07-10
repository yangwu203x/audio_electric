package com.audio.electric.domain;

import org.apache.ibatis.type.Alias;

/**
 * 作品表
 * Created by Administrator on 2017/3/17 0017.
 */
@Alias("Portfolio")
public class Portfolio {
    private long id;
    private long userId;//用户id
    private String createDate;//创建时间
    private long listeningTimes;//收听次数
    private long songId;//歌曲id
    private String introduction;//心情
    private String videoPath;//视频路径
    private String audioPath;//音频路径
    private String state;//状态

    public Portfolio() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public long getListeningTimes() {
        return listeningTimes;
    }

    public void setListeningTimes(long listeningTimes) {
        this.listeningTimes = listeningTimes;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
