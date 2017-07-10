package com.audio.electric.mapper;

import com.audio.electric.domain.HotSinger;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface HotSingerMapper {

    List<HotSinger> listHotSinger()throws SQLException;

    int saveHotSinger(HotSinger hotSinger)throws SQLException;

    int editHotSinger(HotSinger hotSinger)throws SQLException;

    int deleteHotSinger(@Param("ids") String ids)throws SQLException;

    HotSinger getHotSingerById(HotSinger hotSinger)throws SQLException;
}