package com.audio.electric.service.impl;

import com.audio.electric.domain.EnumValue;
import com.audio.electric.domain.Singer;
import com.audio.electric.domain.SingerExample;
import com.audio.electric.domain.Song;
import com.audio.electric.mapper.BaseMapper;
import com.audio.electric.mapper.EnumValueMapper;
import com.audio.electric.mapper.SingerMapper;
import com.audio.electric.mapper.SongMapper;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.tool.ReadExcel;
import com.audio.electric.util.tool.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/9 0009 15:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SongServiceImplTest {
    @Autowired
    private SongServiceImpl songService;
    @Autowired
    private SongMapper songMapper;
    @Autowired
    private SingerMapper singerMapper;
    @Autowired
    private BaseMapper baseMapper;
    @Autowired
    private EnumValueMapper enumValueMapper;

    @Test
    public void insertSong() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
//        int size = 100000;
//        int num = size / Constant.SIZE ;
//        for (int i = 0 ;i < num ; i++)
//        {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    int n = 0;
//                    while(n++ < 100000)
//                        System.out.println(Thread.currentThread().getName()+": 线程名！");
//                }
//            });
//            t.start();
//        }
//        System.out.println("num = " + num);
    }

    public void addSong(String pathName){
        File file = new File(pathName);
        try {
            FileInputStream fis = new FileInputStream(file);
            List<Map<Integer,Object>> dataList =  ReadExcel.parseSuccexx(fis,file.getName() ,-1);
            int size = dataList.size();
            int num = size / Constant.SIZE ;
            System.out.println("num =" + num);
            if (size%Constant.SIZE == 0){
            }
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
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
                String singerId  = getSingerIdBySingerName(singer_name);
                String lang_id = "" +  dataList.get(i).get(8);
                lang_id = getIdByName(lang_id, Constant.SONGLANGS);
                String theme_song = "" +  dataList.get(i).get(12);//主题
                theme_song = getIdByName(theme_song,Constant.SONGTHEMES);
                String tv_program = "" +  dataList.get(i).get(13);//节目
                tv_program = getIdByName(tv_program,Constant.TVPROGRAM);
                String tv_program_enter = "" +  dataList.get(i).get(15);//本地节目
                tv_program_enter = getIdByName(tv_program_enter,Constant.TVPROGRAMENTER);

                Song song = new Song(mrs_id,midi_id,vod_id,song_name,singer_name, singerId,file_format,songZs,spell,lang_id,new_song,hot_song,classic_songs,
                        theme_song,tv_program,tv_program_enter,scene,song_years,enter_selected,update_date);
                songMapper.insertSelective(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
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