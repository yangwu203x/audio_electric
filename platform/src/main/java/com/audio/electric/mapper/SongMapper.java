package com.audio.electric.mapper;

import com.audio.electric.domain.Song;
import com.audio.electric.domain.SongExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SongMapper {
    int countByExample(SongExample example)throws SQLException;

    int deleteByExample(SongExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(Song record)throws SQLException;

    int insertSelective(Song record)throws SQLException;

    List<Song> selectByExample(SongExample example)throws SQLException;

    Song selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") Song record, @Param("example") SongExample example)throws SQLException;

    int updateByExample(@Param("record") Song record, @Param("example") SongExample example)throws SQLException;

    int updateByPrimaryKeySelective(Song record)throws SQLException;

    int updateByPrimaryKey(Song record)throws SQLException;
}