package com.audio.electric.mapper;

import com.audio.electric.domain.Singer;
import com.audio.electric.domain.SingerExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SingerMapper {
    int countByExample(SingerExample example)throws SQLException;

    int deleteByExample(SingerExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(Singer record)throws SQLException;

    int insertSelective(Singer record)throws SQLException;

    List<Singer> selectByExample(SingerExample example)throws SQLException;

    Singer selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") Singer record, @Param("example") SingerExample example)throws SQLException;

    int updateByExample(@Param("record") Singer record, @Param("example") SingerExample example)throws SQLException;

    int updateByPrimaryKeySelective(Singer record)throws SQLException;

    int updateByPrimaryKey(Singer record)throws SQLException;
}