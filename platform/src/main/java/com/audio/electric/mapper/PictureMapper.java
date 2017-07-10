package com.audio.electric.mapper;

import com.audio.electric.domain.Picture;
import com.audio.electric.domain.PictureExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PictureMapper {
    int countByExample(PictureExample example)throws SQLException;

    int deleteByExample(PictureExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(Picture record)throws SQLException;

    int insertSelective(Picture record)throws SQLException;

    List<Picture> selectByExample(PictureExample example)throws SQLException;

    Picture selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example)throws SQLException;

    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example)throws SQLException;

    int updateByPrimaryKeySelective(Picture record)throws SQLException;

    int updateByPrimaryKey(Picture record)throws SQLException;
}