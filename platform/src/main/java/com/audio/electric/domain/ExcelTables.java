package com.audio.electric.domain;

import com.audio.electric.util.excelUtil.ExcelResources;
import com.audio.electric.util.tool.ReadExcel;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/7 0007 10:19
 */
public class ExcelTables implements Serializable{

    public static void main(String[] args){
        String fileName = "enter.xlsx";
        String realPath = "C:\\Users\\Administrator\\Desktop\\"+fileName;
        InputStream str = null;
        int nums = 10;
        try {
            str = new FileInputStream(realPath);
            List<Map<Integer,Object>> list = ReadExcel.parseSuccexx(str, fileName, nums);
            //拿到所以歌手

            //插入歌手并拿到所有歌手名字和id

            //拿到所有歌曲

            //插入歌曲


           for (int i = 2;i < nums ;i ++){
                String mrs_id = "" +  list.get(i).get(0);
                String midi_id = "" + list.get(i).get(1);
                String vod_id = "" +  list.get(i).get(2);
                String song_name = "" +  list.get(i).get(3);
                String singer_name = "" +  list.get(i).get(4);
                String file_format = "" +  list.get(i).get(5);
                String song_zs = "" +  list.get(i).get(6);
                String spell = "" +  list.get(i).get(7);
                String lang_id = "" +  list.get(i).get(8);
                String new_song = "" +  list.get(i).get(9);
                String hot_song = "" +  list.get(i).get(10);
                String classic_songs = "" +  list.get(i).get(11);
                String theme_song = "" +  list.get(i).get(12);
                String tv_program = "" +  list.get(i).get(13);
                String program_version = "" +  list.get(i).get(14);
                String tv_program_enter = "" +  list.get(i).get(15);
                String scene = "" +  list.get(i).get(16);
                String song_years = "" +  list.get(i).get(17);
                String enter_selected = "" +  list.get(i).get(18);
                String update_date = "" +  list.get(i).get(19);
                ExcelTables excelTables = new ExcelTables(mrs_id, midi_id, vod_id, song_name, singer_name, file_format, song_zs, spell, lang_id, new_song, hot_song, classic_songs, theme_song, tv_program, program_version, tv_program_enter, scene, song_years, enter_selected, update_date);
                System.out.println(excelTables);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private String mrs_id;
    private String midi_id;
    private String vod_id;
    private String song_name;
    private String singer_name;
    private String file_format;
    private String song_zs;
    private String spell;
    private String lang_id;
    private String new_song;
    private String hot_song;
    private String classic_songs;
    private String theme_song;
    private String tv_program;
    private String program_version;
    private String tv_program_enter;
    private String scene;
    private String song_years;
    private String enter_selected;
    private String update_date;

    //default constructor
    public ExcelTables() {
    }

    //full constructor
    public ExcelTables(String mrs_id, String midi_id, String vod_id, String song_name, String singer_name, String file_format, String song_zs, String spell, String lang_id, String new_song, String hot_song, String classic_songs, String theme_song, String tv_program, String program_version, String tv_program_enter, String scene, String song_years, String enter_selected, String update_date) {
        this.mrs_id = mrs_id;
        this.midi_id = midi_id;
        this.vod_id = vod_id;
        this.song_name = song_name;
        this.singer_name = singer_name;
        this.file_format = file_format;
        this.song_zs = song_zs;
        this.spell = spell;
        this.lang_id = lang_id;
        this.new_song = new_song;
        this.hot_song = hot_song;
        this.classic_songs = classic_songs;
        this.theme_song = theme_song;
        this.tv_program = tv_program;
        this.program_version = program_version;
        this.tv_program_enter = tv_program_enter;
        this.scene = scene;
        this.song_years = song_years;
        this.enter_selected = enter_selected;
        this.update_date = update_date;
    }

    //toString
    @Override
    public String toString() {
        return "ExcelTables{" +
                "mrs_id='" + mrs_id + '\'' +
                ", midi_id='" + midi_id + '\'' +
                ", vod_id='" + vod_id + '\'' +
                ", song_name='" + song_name + '\'' +
                ", singer_name='" + singer_name + '\'' +
                ", file_format='" + file_format + '\'' +
                ", song_zs='" + song_zs + '\'' +
                ", spell='" + spell + '\'' +
                ", lang_id='" + lang_id + '\'' +
                ", new_song='" + new_song + '\'' +
                ", hot_song='" + hot_song + '\'' +
                ", classic_songs='" + classic_songs + '\'' +
                ", theme_song='" + theme_song + '\'' +
                ", tv_program='" + tv_program + '\'' +
                ", program_version='" + program_version + '\'' +
                ", tv_program_enter='" + tv_program_enter + '\'' +
                ", scene='" + scene + '\'' +
                ", song_years='" + song_years + '\'' +
                ", enter_selected='" + enter_selected + '\'' +
                ", update_date='" + update_date + '\'' +
                '}';
    }

    @ExcelResources(title="MRS_ID",order=1)
    public String getMrs_id() {
        return mrs_id;
    }

    @ExcelResources(title="MIDI_ID",order=2)
    public String getMidi_id() {
        return midi_id;
    }

    @ExcelResources(title="VOD_ID",order=3)
    public String getVod_id() {
        return vod_id;
    }

    @ExcelResources(title="song_name",order=4)
    public String getSong_name() {
        return song_name;
    }

    @ExcelResources(title="singer_name",order=5)
    public String getSinger_name() {
        return singer_name;
    }

    @ExcelResources(title="file_format",order=6)
    public String getFile_format() {
        return file_format;
    }

    @ExcelResources(title="song_zs",order=7)
    public String getSong_zs() {
        return song_zs;
    }

    @ExcelResources(title="spell",order=8)
    public String getSpell() {
        return spell;
    }

    @ExcelResources(title="lang_id",order=8)
    public String getLang_id() {
        return lang_id;
    }

    @ExcelResources(title="new_song",order=9)
    public String getNew_song() {
        return new_song;
    }

    @ExcelResources(title="hot_song",order=10)
    public String getHot_song() {
        return hot_song;
    }

    @ExcelResources(title="classic_songs",order=11)
    public String getClassic_songs() {
        return classic_songs;
    }

    @ExcelResources(title="theme_song",order=12)
    public String getTheme_song() {
        return theme_song;
    }

    @ExcelResources(title="tv_program" ,order=13)
    public String getTv_program() {
        return tv_program;
    }

    @ExcelResources(title="program_version",order=14)
    public String getProgram_version() {
        return program_version;
    }

    @ExcelResources(title="tv_program_enter",order=15)
    public String getTv_program_enter() {
        return tv_program_enter;
    }

    @ExcelResources(title="scene",order=16)
    public String getScene() {
        return scene;
    }

    @ExcelResources(title="song_years",order=17)
    public String getSong_years() {
        return song_years;
    }

    @ExcelResources(title="enter_selected",order=18)
    public String getEnter_selected() {
        return enter_selected;
    }

    @ExcelResources(title="update_date",order=19)
    public String getUpdate_date() {
        return update_date;
    }

    public void setMrs_id(String mrs_id) {
        this.mrs_id = mrs_id;
    }

    public void setMidi_id(String midi_id) {
        this.midi_id = midi_id;
    }

    public void setVod_id(String vod_id) {
        this.vod_id = vod_id;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public void setFile_format(String file_format) {
        this.file_format = file_format;
    }

    public void setSong_zs(String song_zs) {
        this.song_zs = song_zs;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public void setLang_id(String lang_id) {
        this.lang_id = lang_id;
    }

    public void setNew_song(String new_song) {
        this.new_song = new_song;
    }

    public void setHot_song(String hot_song) {
        this.hot_song = hot_song;
    }

    public void setClassic_songs(String classic_songs) {
        this.classic_songs = classic_songs;
    }

    public void setTheme_song(String theme_song) {
        this.theme_song = theme_song;
    }

    public void setTv_program(String tv_program) {
        this.tv_program_enter = tv_program;
    }

    public void setProgram_version(String program_version) {
        this.program_version = program_version;
    }

    public void setTv_program_enter(String tv_program_enter) {
        this.tv_program_enter = tv_program_enter;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public void setSong_years(String song_years) {
        this.song_years = song_years;
    }

    public void setEnter_selected(String enter_selected) {
        this.enter_selected = enter_selected;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
}
