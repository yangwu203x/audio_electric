package com.audio.electric.mapper;

import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.EnumTypeExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EnumTypeMapper {
    int countByExample(EnumTypeExample example)throws SQLException;

    int deleteByExample(EnumTypeExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(EnumType record)throws SQLException;

    int insertSelective(EnumType record)throws SQLException;

    List<EnumType> selectByExample(EnumTypeExample example)throws SQLException;

    EnumType selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") EnumType record, @Param("example") EnumTypeExample example)throws SQLException;

    int updateByExample(@Param("record") EnumType record, @Param("example") EnumTypeExample example)throws SQLException;

    int updateByPrimaryKeySelective(EnumType record)throws SQLException;

    int updateByPrimaryKey(EnumType record)throws SQLException;
}