package com.audio.electric.domain;

import com.audio.electric.util.excelUtil.ExcelResources;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/12 0012 15:52
 */
public class SongExcel {
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

    private Integer songZs;

    private String singerName;

    private String tvProgramEnter;

    private String programVersion;//节目版本

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

}
