package com.audio.electric.domain;

import java.io.Serializable;

public class Song implements Serializable {
    private Long id;

    private String name;

    private String songFormat;

    private Integer songZs;

    private String spell;

    private Integer volume;

    private Integer volumeMin;

    private Integer volumeMax;

    private String strack;

    private String receivingDate;

    private Long orderTime;

    private String songPath;

    private String photoPath;

    private String classicStatus;

    private String songInfo;

    private String status;

    private Long searchTimes;

    private Integer programId;

    private String songVersion;

    private String songYears;

    private String volumeOne;

    private String volumeTwo;

    private String langId;

    private String typeId;

    private String pixel;

    private String nature;

    private String scene;

    private String theme;

    private String type;

    private String songId;

    private String singerNameOne;

    private String singerNameTwo;

    private String singerNameThree;

    private Integer singerIdOne;

    private Integer singerIdTwo;

    private Integer singerIdThree;

    private String prefixPath;

    private String serverUrl;

    private static final long serialVersionUID = 1L;

    public Song(Long id, String name, String songFormat, Integer songZs, String spell, Integer volume, Integer volumeMin, Integer volumeMax, String strack, String receivingDate, Long orderTime, String songPath, String photoPath, String classicStatus, String songInfo, String status, Long searchTimes, Integer programId, String songVersion, String songYears, String volumeOne, String volumeTwo, String langId, String typeId, String pixel, String nature, String scene, String theme, String type, String songId, String singerNameOne, String singerNameTwo, String singerNameThree, Integer singerIdOne, Integer singerIdTwo, Integer singerIdThree, String prefixPath, String serverUrl) {
        this.id = id;
        this.name = name;
        this.songFormat = songFormat;
        this.songZs = songZs;
        this.spell = spell;
        this.volume = volume;
        this.volumeMin = volumeMin;
        this.volumeMax = volumeMax;
        this.strack = strack;
        this.receivingDate = receivingDate;
        this.orderTime = orderTime;
        this.songPath = songPath;
        this.photoPath = photoPath;
        this.classicStatus = classicStatus;
        this.songInfo = songInfo;
        this.status = status;
        this.searchTimes = searchTimes;
        this.programId = programId;
        this.songVersion = songVersion;
        this.songYears = songYears;
        this.volumeOne = volumeOne;
        this.volumeTwo = volumeTwo;
        this.langId = langId;
        this.typeId = typeId;
        this.pixel = pixel;
        this.nature = nature;
        this.scene = scene;
        this.theme = theme;
        this.type = type;
        this.songId = songId;
        this.singerNameOne = singerNameOne;
        this.singerNameTwo = singerNameTwo;
        this.singerNameThree = singerNameThree;
        this.singerIdOne = singerIdOne;
        this.singerIdTwo = singerIdTwo;
        this.singerIdThree = singerIdThree;
        this.prefixPath = prefixPath;
        this.serverUrl = serverUrl;
    }

    public Song() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSongFormat() {
        return songFormat;
    }

    public void setSongFormat(String songFormat) {
        this.songFormat = songFormat == null ? null : songFormat.trim();
    }

    public Integer getSongZs() {
        return songZs;
    }

    public void setSongZs(Integer songZs) {
        this.songZs = songZs;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell == null ? null : spell.trim();
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getVolumeMin() {
        return volumeMin;
    }

    public void setVolumeMin(Integer volumeMin) {
        this.volumeMin = volumeMin;
    }

    public Integer getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(Integer volumeMax) {
        this.volumeMax = volumeMax;
    }

    public String getStrack() {
        return strack;
    }

    public void setStrack(String strack) {
        this.strack = strack == null ? null : strack.trim();
    }

    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate == null ? null : receivingDate.trim();
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath == null ? null : songPath.trim();
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    public String getClassicStatus() {
        return classicStatus;
    }

    public void setClassicStatus(String classicStatus) {
        this.classicStatus = classicStatus == null ? null : classicStatus.trim();
    }

    public String getSongInfo() {
        return songInfo;
    }

    public void setSongInfo(String songInfo) {
        this.songInfo = songInfo == null ? null : songInfo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(Long searchTimes) {
        this.searchTimes = searchTimes;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getSongVersion() {
        return songVersion;
    }

    public void setSongVersion(String songVersion) {
        this.songVersion = songVersion == null ? null : songVersion.trim();
    }

    public String getSongYears() {
        return songYears;
    }

    public void setSongYears(String songYears) {
        this.songYears = songYears == null ? null : songYears.trim();
    }

    public String getVolumeOne() {
        return volumeOne;
    }

    public void setVolumeOne(String volumeOne) {
        this.volumeOne = volumeOne == null ? null : volumeOne.trim();
    }

    public String getVolumeTwo() {
        return volumeTwo;
    }

    public void setVolumeTwo(String volumeTwo) {
        this.volumeTwo = volumeTwo == null ? null : volumeTwo.trim();
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId == null ? null : langId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getPixel() {
        return pixel;
    }

    public void setPixel(String pixel) {
        this.pixel = pixel == null ? null : pixel.trim();
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene == null ? null : scene.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId == null ? null : songId.trim();
    }

    public String getSingerNameOne() {
        return singerNameOne;
    }

    public void setSingerNameOne(String singerNameOne) {
        this.singerNameOne = singerNameOne == null ? null : singerNameOne.trim();
    }

    public String getSingerNameTwo() {
        return singerNameTwo;
    }

    public void setSingerNameTwo(String singerNameTwo) {
        this.singerNameTwo = singerNameTwo == null ? null : singerNameTwo.trim();
    }

    public String getSingerNameThree() {
        return singerNameThree;
    }

    public void setSingerNameThree(String singerNameThree) {
        this.singerNameThree = singerNameThree == null ? null : singerNameThree.trim();
    }

    public Integer getSingerIdOne() {
        return singerIdOne;
    }

    public void setSingerIdOne(Integer singerIdOne) {
        this.singerIdOne = singerIdOne;
    }

    public Integer getSingerIdTwo() {
        return singerIdTwo;
    }

    public void setSingerIdTwo(Integer singerIdTwo) {
        this.singerIdTwo = singerIdTwo;
    }

    public Integer getSingerIdThree() {
        return singerIdThree;
    }

    public void setSingerIdThree(Integer singerIdThree) {
        this.singerIdThree = singerIdThree;
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
        Song other = (Song) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSongFormat() == null ? other.getSongFormat() == null : this.getSongFormat().equals(other.getSongFormat()))
            && (this.getSongZs() == null ? other.getSongZs() == null : this.getSongZs().equals(other.getSongZs()))
            && (this.getSpell() == null ? other.getSpell() == null : this.getSpell().equals(other.getSpell()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getVolumeMin() == null ? other.getVolumeMin() == null : this.getVolumeMin().equals(other.getVolumeMin()))
            && (this.getVolumeMax() == null ? other.getVolumeMax() == null : this.getVolumeMax().equals(other.getVolumeMax()))
            && (this.getStrack() == null ? other.getStrack() == null : this.getStrack().equals(other.getStrack()))
            && (this.getReceivingDate() == null ? other.getReceivingDate() == null : this.getReceivingDate().equals(other.getReceivingDate()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getSongPath() == null ? other.getSongPath() == null : this.getSongPath().equals(other.getSongPath()))
            && (this.getPhotoPath() == null ? other.getPhotoPath() == null : this.getPhotoPath().equals(other.getPhotoPath()))
            && (this.getClassicStatus() == null ? other.getClassicStatus() == null : this.getClassicStatus().equals(other.getClassicStatus()))
            && (this.getSongInfo() == null ? other.getSongInfo() == null : this.getSongInfo().equals(other.getSongInfo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSearchTimes() == null ? other.getSearchTimes() == null : this.getSearchTimes().equals(other.getSearchTimes()))
            && (this.getProgramId() == null ? other.getProgramId() == null : this.getProgramId().equals(other.getProgramId()))
            && (this.getSongVersion() == null ? other.getSongVersion() == null : this.getSongVersion().equals(other.getSongVersion()))
            && (this.getSongYears() == null ? other.getSongYears() == null : this.getSongYears().equals(other.getSongYears()))
            && (this.getVolumeOne() == null ? other.getVolumeOne() == null : this.getVolumeOne().equals(other.getVolumeOne()))
            && (this.getVolumeTwo() == null ? other.getVolumeTwo() == null : this.getVolumeTwo().equals(other.getVolumeTwo()))
            && (this.getLangId() == null ? other.getLangId() == null : this.getLangId().equals(other.getLangId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getPixel() == null ? other.getPixel() == null : this.getPixel().equals(other.getPixel()))
            && (this.getNature() == null ? other.getNature() == null : this.getNature().equals(other.getNature()))
            && (this.getScene() == null ? other.getScene() == null : this.getScene().equals(other.getScene()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSongId() == null ? other.getSongId() == null : this.getSongId().equals(other.getSongId()))
            && (this.getSingerNameOne() == null ? other.getSingerNameOne() == null : this.getSingerNameOne().equals(other.getSingerNameOne()))
            && (this.getSingerNameTwo() == null ? other.getSingerNameTwo() == null : this.getSingerNameTwo().equals(other.getSingerNameTwo()))
            && (this.getSingerNameThree() == null ? other.getSingerNameThree() == null : this.getSingerNameThree().equals(other.getSingerNameThree()))
            && (this.getSingerIdOne() == null ? other.getSingerIdOne() == null : this.getSingerIdOne().equals(other.getSingerIdOne()))
            && (this.getSingerIdTwo() == null ? other.getSingerIdTwo() == null : this.getSingerIdTwo().equals(other.getSingerIdTwo()))
            && (this.getSingerIdThree() == null ? other.getSingerIdThree() == null : this.getSingerIdThree().equals(other.getSingerIdThree()))
            && (this.getPrefixPath() == null ? other.getPrefixPath() == null : this.getPrefixPath().equals(other.getPrefixPath()))
            && (this.getServerUrl() == null ? other.getServerUrl() == null : this.getServerUrl().equals(other.getServerUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSongFormat() == null) ? 0 : getSongFormat().hashCode());
        result = prime * result + ((getSongZs() == null) ? 0 : getSongZs().hashCode());
        result = prime * result + ((getSpell() == null) ? 0 : getSpell().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getVolumeMin() == null) ? 0 : getVolumeMin().hashCode());
        result = prime * result + ((getVolumeMax() == null) ? 0 : getVolumeMax().hashCode());
        result = prime * result + ((getStrack() == null) ? 0 : getStrack().hashCode());
        result = prime * result + ((getReceivingDate() == null) ? 0 : getReceivingDate().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getSongPath() == null) ? 0 : getSongPath().hashCode());
        result = prime * result + ((getPhotoPath() == null) ? 0 : getPhotoPath().hashCode());
        result = prime * result + ((getClassicStatus() == null) ? 0 : getClassicStatus().hashCode());
        result = prime * result + ((getSongInfo() == null) ? 0 : getSongInfo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSearchTimes() == null) ? 0 : getSearchTimes().hashCode());
        result = prime * result + ((getProgramId() == null) ? 0 : getProgramId().hashCode());
        result = prime * result + ((getSongVersion() == null) ? 0 : getSongVersion().hashCode());
        result = prime * result + ((getSongYears() == null) ? 0 : getSongYears().hashCode());
        result = prime * result + ((getVolumeOne() == null) ? 0 : getVolumeOne().hashCode());
        result = prime * result + ((getVolumeTwo() == null) ? 0 : getVolumeTwo().hashCode());
        result = prime * result + ((getLangId() == null) ? 0 : getLangId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getPixel() == null) ? 0 : getPixel().hashCode());
        result = prime * result + ((getNature() == null) ? 0 : getNature().hashCode());
        result = prime * result + ((getScene() == null) ? 0 : getScene().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSongId() == null) ? 0 : getSongId().hashCode());
        result = prime * result + ((getSingerNameOne() == null) ? 0 : getSingerNameOne().hashCode());
        result = prime * result + ((getSingerNameTwo() == null) ? 0 : getSingerNameTwo().hashCode());
        result = prime * result + ((getSingerNameThree() == null) ? 0 : getSingerNameThree().hashCode());
        result = prime * result + ((getSingerIdOne() == null) ? 0 : getSingerIdOne().hashCode());
        result = prime * result + ((getSingerIdTwo() == null) ? 0 : getSingerIdTwo().hashCode());
        result = prime * result + ((getSingerIdThree() == null) ? 0 : getSingerIdThree().hashCode());
        result = prime * result + ((getPrefixPath() == null) ? 0 : getPrefixPath().hashCode());
        result = prime * result + ((getServerUrl() == null) ? 0 : getServerUrl().hashCode());
        return result;
    }
}