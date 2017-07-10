package com.audio.electric.mapper;

import com.audio.electric.domain.Apk;
import com.audio.electric.domain.ApkExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ApkMapper {
    int countByExample(ApkExample example)throws SQLException;

    int deleteByExample(ApkExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(Apk record)throws SQLException;

    int insertSelective(Apk record)throws SQLException;

    List<Apk> selectByExample(ApkExample example)throws SQLException;

    Apk selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") Apk record, @Param("example") ApkExample example)throws SQLException;

    int updateByExample(@Param("record") Apk record, @Param("example") ApkExample example)throws SQLException;

    int updateByPrimaryKeySelective(Apk record)throws SQLException;

    int updateByPrimaryKey(Apk record)throws SQLException;
}