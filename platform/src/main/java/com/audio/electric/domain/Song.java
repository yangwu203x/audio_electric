package com.audio.electric.domain;

import com.audio.electric.util.excelUtil.ExcelResources;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
@Alias("Song")
public class Song implements Serializable {
    private Integer id;

    private String mrsId;

    private String midiId;

    private String vodId;

    private String songName;

    private String fileFormat;

    private String spell;

    private String langId;

    private String newSong;

    private String hotSong;

    private String classicSong;

    private String themeSong;

    private String tvProgram;

    private String scene;

    private String songYears;

    private String enterSelected;

    private String updateDate;

    private String headerPath;

    private String prefixPath;

    private String serverUrl;

    private Integer songZs;

    private String songNo;

    private Integer status;

    private String singerId;

    private String singerName;

    private String tvProgramEnter;

    private Integer rank;//歌曲排行

    private String programVersion;//节目版本

    private static final long serialVersionUID = 1L;

    public Song(String mrsId,String midiId,String vodId,String songName,String singerName,String singerId,String fileFormat,Integer songZs,
                String spell,String langId,String newSong,String hotSong,String classicSongs,String themeSong,
                String tvProgram,String tvProgramEnter,String scene,String songYears,String enterSelected,String updateDate){
        this.mrsId = mrsId;
        this.midiId = midiId;
        this.vodId = vodId;
        this.songName = songName;
        this.singerName = singerName;
        this.singerId = singerId;
        this.fileFormat = fileFormat;
        this.songZs = songZs;
        this.spell = spell;
        this.langId = langId;
        this.newSong = newSong;
        this.hotSong = hotSong;
        this.classicSong = classicSongs;
        this.themeSong = themeSong;
        this.tvProgram = tvProgram;
        this.tvProgramEnter = tvProgramEnter;
        this.scene = scene;
        this.songYears = songYears;
        this.enterSelected = enterSelected;
        this.updateDate = updateDate;
    }

    public Song(Integer id, String mrsId, String midiId, String vodId, String songName, String fileFormat, String spell, String langId, String newSong, String hotSong, String classicSong, String themeSong, String tvProgram, String scene, String songYears, String enterSelected, String updateDate, String headerPath, String prefixPath, String serverUrl, Integer songZs, String songNo, Integer status, String singerId, String singerName, String tvProgramEnter) {
        this.id = id;
        this.mrsId = mrsId;
        this.midiId = midiId;
        this.vodId = vodId;
        this.songName = songName;
        this.fileFormat = fileFormat;
        this.spell = spell;
        this.langId = langId;
        this.newSong = newSong;
        this.hotSong = hotSong;
        this.classicSong = classicSong;
        this.themeSong = themeSong;
        this.tvProgram = tvProgram;
        this.scene = scene;
        this.songYears = songYears;
        this.enterSelected = enterSelected;
        this.updateDate = updateDate;
        this.headerPath = headerPath;
        this.prefixPath = prefixPath;
        this.serverUrl = serverUrl;
        this.songZs = songZs;
        this.songNo = songNo;
        this.status = status;
        this.singerId = singerId;
        this.singerName = singerName;
        this.tvProgramEnter = tvProgramEnter;
    }

    public Song() {
        super();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    @ExcelResources(title="MRS编号",order=1)
    public String getMrsId() {
        return mrsId;
    }

    @ExcelResources(title="MIDI编号",order=2)
    public String getMidiId() {
        return midiId;
    }

    @ExcelResources(title="VOD编号",order=3)
    public String getVodId() {
        return vodId;
    }

    @ExcelResources(title="songName歌名",order=4)
    public String getSongName() {
        return songName;
    }

    @ExcelResources(title="singerName歌星",order=5)
    public String getSingerName() {
        return singerName;
    }

    @ExcelResources(title="fileFormat版本",order=6)
    public String getFileFormat() {
        return fileFormat;
    }

    @ExcelResources(title="songZs字数",order=7)
    public Integer getSongZs() {
        return songZs;
    }

    @ExcelResources(title="spell拼音",order=8)
    public String getSpell() {
        return spell;
    }

    @ExcelResources(title="langId语种",order=9)
    public String getLangId() {
        return langId;
    }

    @ExcelResources(title="newSong新歌推荐",order=10)
    public String getNewSong() {
        return newSong;
    }

    @ExcelResources(title="hotSong热门金曲",order=11)
    public String getHotSong() {
        return hotSong;
    }

    @ExcelResources(title="classicSong经典歌曲",order=12)
    public String getClassicSong() {
        return classicSong;
    }

    @ExcelResources(title="themeSong主题",order=13)
    public String getThemeSong() {
        return themeSong;
    }

    @ExcelResources(title="tvProgram节目",order=14)
    public String getTvProgram() {
        return tvProgram;
    }

    @ExcelResources(title="programVersion节目版本",order=15)
    public String getProgramVersion() {
        return programVersion;
    }

    @ExcelResources(title="tvProgramEnter节目（ENTER）",order=16)
    public String getTvProgramEnter() {
        return tvProgramEnter;
    }

    @ExcelResources(title="scene风格",order=17)
    public String getScene() {
        return scene;
    }

    @ExcelResources(title="songYears发行年代",order=18)
    public String getSongYears() {
        return songYears;
    }

    @ExcelResources(title="enterSelectedENTER精选",order=19)
    public String getEnterSelected() {
        return enterSelected;
    }

    @ExcelResources(title="updateDate更新日期",order=20)
    public String getUpdateDate() {
        return updateDate;
    }

    public String getHeaderPath() {
        return headerPath;
    }

    public String getPrefixPath() {
        return prefixPath;
    }

    public String getServerUrl() {
        return serverUrl;
    }



    public String getSongNo() {
        return songNo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getSingerId() {
        return singerId;
    }
//===========================================================
    public void setId(Integer id) {
        this.id = id;
    }

    public void setMrsId(String mrsId) {
        this.mrsId = mrsId;
    }

    public void setMidiId(String midiId) {
        this.midiId = midiId;
    }

    public void setVodId(String vodId) {
        this.vodId = vodId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public void setNewSong(String newSong) {
        this.newSong = newSong;
    }

    public void setHotSong(String hotSong) {
        this.hotSong = hotSong;
    }

    public void setClassicSong(String classicSong) {
        this.classicSong = classicSong;
    }

    public void setThemeSong(String themeSong) {
        this.themeSong = themeSong;
    }

    public void setTvProgram(String tvProgram) {
        this.tvProgram = tvProgram;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public void setSongYears(String songYears) {
        this.songYears = songYears;
    }

    public void setEnterSelected(String enterSelected) {
        this.enterSelected = enterSelected;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setHeaderPath(String headerPath) {
        this.headerPath = headerPath;
    }

    public void setPrefixPath(String prefixPath) {
        this.prefixPath = prefixPath;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void setSongZs(Integer songZs) {
        this.songZs = songZs;
    }

    public void setSongNo(String songNo) {
        this.songNo = songNo;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
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
            && (this.getMrsId() == null ? other.getMrsId() == null : this.getMrsId().equals(other.getMrsId()))
            && (this.getMidiId() == null ? other.getMidiId() == null : this.getMidiId().equals(other.getMidiId()))
            && (this.getVodId() == null ? other.getVodId() == null : this.getVodId().equals(other.getVodId()))
            && (this.getSongName() == null ? other.getSongName() == null : this.getSongName().equals(other.getSongName()))
            && (this.getFileFormat() == null ? other.getFileFormat() == null : this.getFileFormat().equals(other.getFileFormat()))
            && (this.getSpell() == null ? other.getSpell() == null : this.getSpell().equals(other.getSpell()))
            && (this.getLangId() == null ? other.getLangId() == null : this.getLangId().equals(other.getLangId()))
            && (this.getNewSong() == null ? other.getNewSong() == null : this.getNewSong().equals(other.getNewSong()))
            && (this.getHotSong() == null ? other.getHotSong() == null : this.getHotSong().equals(other.getHotSong()))
            && (this.getClassicSong() == null ? other.getClassicSong() == null : this.getClassicSong().equals(other.getClassicSong()))
            && (this.getThemeSong() == null ? other.getThemeSong() == null : this.getThemeSong().equals(other.getThemeSong()))
            && (this.getTvProgram() == null ? other.getTvProgram() == null : this.getTvProgram().equals(other.getTvProgram()))
            && (this.getScene() == null ? other.getScene() == null : this.getScene().equals(other.getScene()))
            && (this.getSongYears() == null ? other.getSongYears() == null : this.getSongYears().equals(other.getSongYears()))
            && (this.getEnterSelected() == null ? other.getEnterSelected() == null : this.getEnterSelected().equals(other.getEnterSelected()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getHeaderPath() == null ? other.getHeaderPath() == null : this.getHeaderPath().equals(other.getHeaderPath()))
            && (this.getPrefixPath() == null ? other.getPrefixPath() == null : this.getPrefixPath().equals(other.getPrefixPath()))
            && (this.getServerUrl() == null ? other.getServerUrl() == null : this.getServerUrl().equals(other.getServerUrl()))
            && (this.getSongZs() == null ? other.getSongZs() == null : this.getSongZs().equals(other.getSongZs()))
            && (this.getSongNo() == null ? other.getSongNo() == null : this.getSongNo().equals(other.getSongNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSingerId() == null ? other.getSingerId() == null : this.getSingerId().equals(other.getSingerId()))
            && (this.getSingerName() == null ? other.getSingerName() == null : this.getSingerName().equals(other.getSingerName()))
            && (this.getTvProgramEnter() == null ? other.getTvProgramEnter() == null : this.getTvProgramEnter().equals(other.getTvProgramEnter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMrsId() == null) ? 0 : getMrsId().hashCode());
        result = prime * result + ((getMidiId() == null) ? 0 : getMidiId().hashCode());
        result = prime * result + ((getVodId() == null) ? 0 : getVodId().hashCode());
        result = prime * result + ((getSongName() == null) ? 0 : getSongName().hashCode());
        result = prime * result + ((getFileFormat() == null) ? 0 : getFileFormat().hashCode());
        result = prime * result + ((getSpell() == null) ? 0 : getSpell().hashCode());
        result = prime * result + ((getLangId() == null) ? 0 : getLangId().hashCode());
        result = prime * result + ((getNewSong() == null) ? 0 : getNewSong().hashCode());
        result = prime * result + ((getHotSong() == null) ? 0 : getHotSong().hashCode());
        result = prime * result + ((getClassicSong() == null) ? 0 : getClassicSong().hashCode());
        result = prime * result + ((getThemeSong() == null) ? 0 : getThemeSong().hashCode());
        result = prime * result + ((getTvProgram() == null) ? 0 : getTvProgram().hashCode());
        result = prime * result + ((getScene() == null) ? 0 : getScene().hashCode());
        result = prime * result + ((getSongYears() == null) ? 0 : getSongYears().hashCode());
        result = prime * result + ((getEnterSelected() == null) ? 0 : getEnterSelected().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getHeaderPath() == null) ? 0 : getHeaderPath().hashCode());
        result = prime * result + ((getPrefixPath() == null) ? 0 : getPrefixPath().hashCode());
        result = prime * result + ((getServerUrl() == null) ? 0 : getServerUrl().hashCode());
        result = prime * result + ((getSongZs() == null) ? 0 : getSongZs().hashCode());
        result = prime * result + ((getSongNo() == null) ? 0 : getSongNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSingerId() == null) ? 0 : getSingerId().hashCode());
        result = prime * result + ((getSingerName() == null) ? 0 : getSingerName().hashCode());
        result = prime * result + ((getTvProgramEnter() == null) ? 0 : getTvProgramEnter().hashCode());
        return result;
    }
}