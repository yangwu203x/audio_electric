package com.audio.electric.mapper;

import com.audio.electric.domain.EnumValue;
import com.audio.electric.domain.EnumValueExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EnumValueMapper {
    int countByExample(EnumValueExample example)throws SQLException;

    int deleteByExample(EnumValueExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(EnumValue record)throws SQLException;

    int insertSelective(EnumValue record)throws SQLException;

    List<EnumValue> selectByExample(EnumValueExample example)throws SQLException;

    EnumValue selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") EnumValue record, @Param("example") EnumValueExample example)throws SQLException;

    int updateByExample(@Param("record") EnumValue record, @Param("example") EnumValueExample example)throws SQLException;

    int updateByPrimaryKeySelective(EnumValue record)throws SQLException;

    int updateByPrimaryKey(EnumValue record)throws SQLException;
}