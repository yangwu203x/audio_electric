package com.audio.electric.service.impl;

import com.audio.electric.domain.*;
import com.audio.electric.mapper.EnumValueMapper;
import com.audio.electric.mapper.SingerMapper;
import com.audio.electric.mapper.SongMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.ISongService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.tool.ReadExcel;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/3 0003 10:20
 */
@Component
public class SongServiceImpl extends BaseService implements ISongService {
    @Autowired
    private SongMapper songMapper;
    @Autowired
    private SingerMapper singerMapper;
    @Autowired
    private EnumValueMapper enumValueMapper;
    @Override
    public Song findSingleSong(Song song) {
        try {
            song = songMapper.selectByPrimaryKey(song.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return song;
    }

    @Override
    public int updateSong(Song song) {
        int result = RetCode.FAILED.getCode();
        try {
            SongExample songExample = new SongExample();
            SongExample.Criteria criteria = songExample.or();
            if (song.getId() != null)
                criteria.andIdEqualTo(song.getId());
            result = songMapper.updateByExampleSelective(song,songExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addSong(Song song) {
        int result = RetCode.FAILED.getCode();
        try {
            result = songMapper.insertSelective(song);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Song> rankList() {
        return null;
    }

    @Override
    public int deleteSong(String ids) {
        int result = RetCode.FAILED.getCode();
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            List<Integer> idList = getIdListInt(ids);
            SongExample songExample = new SongExample();
            songExample.or().andIdIn(idList);
            result = songMapper.deleteByExample(songExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateStatus(Song song) {
        int result = RetCode.FAILED.getCode();
        try {
            SongExample songExample = new SongExample();
            songExample.or().andIdEqualTo(song.getId());
            song.setStatus(1);
            result = songMapper.updateByExampleSelective(song,songExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> autoSearch(Song song) {
        List<String> nameList = new ArrayList<>();
        try {
            SongExample songExample = new SongExample();
            if (StringUtils.isNotNull(song.getSongName()))
                songExample.or().andSongNameLike("%"+song.getSongName()+"%");
            List<Song> songList = songMapper.selectByExample(songExample);
            for (Song temp : songList)
                nameList.add(temp.getSongName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameList;
    }

    @Override
    public List<String> obtainSongIdByName(Song song) {
        List<String> idList = new ArrayList<>();
        SongExample songExample = new SongExample();
        SongExample.Criteria criteria = songExample.or();
        criteria.andSongNameLike("%"+song.getSongName()+"%");
        try {
            List<Song> songList = songMapper.selectByExample(songExample);
            for (Song temp : songList)
                idList.add(temp.getId().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }

    @UsePage
    @Override
    public List<Song> listSong(Song song) {
        List<Song> songList = null;
        try {
            SongExample songExample = new SongExample();
            SongExample.Criteria criteria = songExample.or();
            if (StringUtils.isNotNull(song.getSongName()))
                criteria.andSongNameLike("%" + song.getSongName() + "%");
            songList = songMapper.selectByExample(songExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public List<Song> listAllSong() {
        List<Song> songList = null;
        try {
            songList = songMapper.selectByExample(new SongExample());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public Object addSongList(MultipartFile excelFile) {
        int result = RetCode.FAILED.getCode();
        try {
            List<Map<Integer,Object>> dataList =  ReadExcel.parseSuccexx(excelFile.getInputStream(),excelFile.getOriginalFilename() ,-1);
            for(int i=2; i<dataList.size()+1; i++) {
                String mrs_id = "" +  dataList.get(i).get(0);
                if (StringUtils.isNotNull(mrs_id))
                    mrs_id = Double.valueOf(mrs_id).intValue()+"";
                String midi_id = "" + dataList.get(i).get(1);
                if (StringUtils.isNotNull(midi_id))
                    midi_id = Double.valueOf(midi_id).intValue()+"";
                String vod_id = "" +  dataList.get(i).get(2);
                if (StringUtils.isNotNull(vod_id))
                    vod_id = Double.valueOf(vod_id).intValue()+"";
                String song_name = "" +  dataList.get(i).get(3);
                String file_format = "" +  dataList.get(i).get(5);
                String song_zs = "" +  dataList.get(i).get(6);
                if (StringUtils.isNotNull(song_zs))
                    song_zs = Double.valueOf(song_zs).intValue()+"";
                String spell = "" +  dataList.get(i).get(7);
                String new_song = "" +  dataList.get(i).get(9);
                String hot_song = "" +  dataList.get(i).get(10);
                String classic_songs = "" +  dataList.get(i).get(11);
                //String program_version = "" +  dataList.get(i).get(14);
                String scene = "" +  dataList.get(i).get(16);
                String song_years = "" +  dataList.get(i).get(17);
                String enter_selected = "" +  dataList.get(i).get(18);
                String update_date = "" +  dataList.get(i).get(19);
                int songZs = Integer.parseInt(song_zs);
                String singer_name = "" +  dataList.get(i).get(4);//歌星名
                String singerId  = getSingerIdBySingerName( singer_name);
                String lang_id = "" +  dataList.get(i).get(8);
                lang_id = getIdByName(lang_id,Constant.SONGLANGS);
                String theme_song = "" +  dataList.get(i).get(12);//主题
                theme_song = getIdByName(theme_song,Constant.SONGTHEMES);
                String tv_program = "" +  dataList.get(i).get(13);//节目
                tv_program = getIdByName(tv_program,Constant.TVPROGRAM);
                String tv_program_enter = "" +  dataList.get(i).get(15);//本地节目
                tv_program_enter = getIdByName(tv_program_enter,Constant.TVPROGRAMENTER);

                Song song = new Song(mrs_id,midi_id,vod_id,song_name,singer_name, singerId,file_format,songZs,spell,lang_id,new_song,hot_song,classic_songs,
                        theme_song,tv_program,tv_program_enter,scene,song_years,enter_selected,update_date);
                result = songMapper.insertSelective(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void exportSong(OutputStream output) {
        //获取要导出的数据
        try{
            List<Song> songs = baseMapper.listAllSong();
            // 获取流
            OutputStreamWriter osw = new OutputStreamWriter(output);
            BufferedWriter buff = new BufferedWriter(osw);
            buff.write("MRS_ID\tMIDI_ID\tVOD_ID\tsong_name\tsinger_name\tfile_format\tsong_zs\tspell\tlang_id\thot_song\tnew_song\tclassic_songs\ttheme_song\tTV_program\tprogram_version\tTV_program（enter）\tscene\tsong_years\tenter_selected\tupdate_date");
            buff.write("\r\n");//换行
            buff.write("MRS编号\tMIDI编号\tVOD编号\t歌名\t歌星\t版本\t字数\t拼音\t语种\t新歌推荐\t热门金曲\t经典歌曲\t主题\t节目\t节目版本\t节目（enter）\t风格\t发行年代\tENTER精选\t更新日期\t备注");
            buff.write("\r\n");//换行
            //插入5万条记录
            for (Song temp : songs) {
                StringBuffer sb = new StringBuffer("");
                sb.append(temp.getMrsId()).append("\t")
                        .append(temp.getMidiId()).append("\t")
                        .append(temp.getVodId()).append("\t")
                        .append(temp.getSongName()).append("\t")
                        .append(temp.getSingerName()).append("\t")
                        .append(temp.getFileFormat()).append("\t")
                        .append(temp.getSongZs()).append("\t")
                        .append(temp.getSpell()).append("\t")
                        .append(temp.getLangId()).append("\t")
                        .append(temp.getNewSong()).append("\t")
                        .append(temp.getHotSong()).append("\t")
                        .append(temp.getClassicSong()).append("\t")
                        .append(temp.getThemeSong()).append("\t")
                        .append(temp.getTvProgram()).append("\t")
                        .append(temp.getProgramVersion()).append("\t")
                        .append(temp.getTvProgramEnter()).append("\t")
                        .append(temp.getScene()).append("\t")
                        .append(temp.getSongYears()).append("\t")
                        .append(temp.getEnterSelected()).append("\t")
                        .append(temp.getUpdateDate()).append("\t");
                buff.write(sb.toString());
                buff.write("\r\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据歌手名获得歌手id，如果没有存在的歌手，则添加之后再返回
     * @param singer_name
     * @return
     * @throws SQLException
     */
    public String getSingerIdBySingerName( String singer_name) throws SQLException {
        if(StringUtils.isNull(singer_name)){
            singer_name = "佚名";
        }
        StringBuffer singer_id = new StringBuffer("");
        String[] singerArr = singer_name.split("/");
        for(int j = 0;j < singerArr.length ; j++){
            if (j > 0)
                singer_id.append(",");
            SingerExample singerExample = new SingerExample();
            singerExample.or().andSingerNameEqualTo(singerArr[j]);
            List<Singer> singerList = singerMapper.selectByExample(singerExample);
            if (singerList != null && singerList.size() > 0){
                singer_id.append(singerList.get(0).getId());
            }else{
                Singer singer = new Singer();
                singer.setSingerName(singerArr[j]);
                singer.setSingerZs(singerArr[j].length());
                singerMapper.insertSelective(singer);
                singer_id.append(singer.getId());
            }
        }
        return singer_id.toString();
    }

    /**
     * 根据数据字典中的内容，将类型转化为对应的id值，如果没有则添加之后返回
     * @param theme_song
     * @param enumTypeId
     * @return
     * @throws SQLException
     */
    public String getIdByName(String theme_song,String enumTypeId) throws SQLException {

        Integer themeId;List<EnumValue> theme_songList = baseMapper.listEnumValueByTitle(enumTypeId);
        Map<String,Integer> themeMap = new HashMap<>();
        for (EnumValue temp :theme_songList){
            themeMap.put("enumTypeId",temp.getEnumTypeId());
            themeMap.put(temp.getName(),temp.getId());
        }
        if (StringUtils.isNull(theme_song)){
            themeId = themeMap.get("其他");
        }else{
            themeId = themeMap.get(theme_song);
        }

        if (themeId == null){
            //添加枚举类型
            EnumValue enumValue = new EnumValue();
            enumValue.setName(theme_song);
            enumValue.setEnumTypeId(themeMap.get("enumTypeId"));
            enumValueMapper.insertSelective(enumValue);
            themeId = enumValue.getId();
        }
        return themeId+"";
    }
}
