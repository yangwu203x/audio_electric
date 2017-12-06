package com.audio.electric.service.impl;

import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.EnumValue;
import com.audio.electric.domain.SongResponse;
import com.audio.electric.domain.SongType;
import com.audio.electric.mapper.SearchMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.ISongService;
import com.audio.electric.util.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/23 0023 17:07
 */
@Component
public class SongServiceImpl extends BaseService implements ISongService{
    @Autowired
    private SearchMapper searchMapper;

    @Override
    public Map getSong(String date) {
        Map data = new HashMap();
        //查询歌曲类型，含歌曲id
        List<SongType> songTypes = getSongTypes(date);
        //查一下歌曲最后更新时间
        String lastUpdateDate = searchMapper.getLastUpdateDate();
        //查询所有歌曲
        List<SongResponse> songs = searchMapper.getSong(date);
        wrapSongCollections(songs,1l);
        data.put("lastUpdateDate",lastUpdateDate);
        data.put("songType",songTypes);
        data.put("songs",songs);
        return data;
    }


    private List<SongType> getSongTypes(String date) {
        List<SongType> songTypes = new ArrayList<>();

        //经典老歌
        List<Integer> classicSongs = searchMapper.getClassicSong(date);
        SongType classicSong = new SongType("classic","经典歌曲",classicSongs);
        songTypes.add(classicSong);
        //热门金曲
        List<Integer> hostSongs = searchMapper.getHotSong(date);
        SongType hotSong = new SongType("hotSong","热门歌曲",hostSongs);
        songTypes.add(hotSong);
        //歌曲主题
        List<EnumValue> enumTypeList = searchMapper.getSongTheme(Constant.SONGTHEME);
        for (EnumValue enumValue : enumTypeList){
            List<Integer> themeSongs = searchMapper.getChildSong(date,enumValue.getId());
            SongType childSong = new SongType(enumValue.getEname(),enumValue.getName(),themeSongs);
            childSong.setTypeName(enumValue.getEname());
            songTypes.add(childSong);
        }
        return songTypes;
    }


}
