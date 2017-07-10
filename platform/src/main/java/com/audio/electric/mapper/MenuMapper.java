package com.audio.electric.mapper;

import com.audio.electric.domain.Menu;
import com.audio.electric.domain.MenuExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MenuMapper {
    int countByExample(MenuExample example) throws SQLException;

    int deleteByExample(MenuExample example) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;

    int insert(Menu record) throws SQLException;

    int insertSelective(Menu record) throws SQLException;

    List<Menu> selectByExample(MenuExample example) throws SQLException;

    Menu selectByPrimaryKey(Integer id) throws SQLException;

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example) throws SQLException;

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example) throws SQLException;

    int updateByPrimaryKeySelective(Menu record) throws SQLException;

    int updateByPrimaryKey(Menu record) throws SQLException;
}