package com.audio.electric.mapper;


import com.audio.electric.domain.HotSong;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
@Component
public interface HotSongMapper {

    List<HotSong> listHotSong()throws SQLException;

    int saveHotSong(HotSong hotSong)throws SQLException;

    int editHotSong(HotSong hotSong)throws SQLException;

    int deleteHotSong(@Param("ids") String ids)throws SQLException;

    HotSong getHotSongById(HotSong hotSong)throws SQLException;
}