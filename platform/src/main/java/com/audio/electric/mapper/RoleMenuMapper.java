package com.audio.electric.mapper;

import com.audio.electric.domain.RoleMenu;
import com.audio.electric.domain.RoleMenuExample;
import com.audio.electric.domain.RoleMenuKey;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoleMenuMapper {
    int countByExample(RoleMenuExample example)throws SQLException;

    int deleteByExample(RoleMenuExample example)throws SQLException;

    int deleteByPrimaryKey(RoleMenuKey key)throws SQLException;

    int insert(RoleMenu record)throws SQLException;

    int insertSelective(RoleMenu record)throws SQLException;

    List<RoleMenu> selectByExample(RoleMenuExample example)throws SQLException;

    RoleMenu selectByPrimaryKey(RoleMenuKey key)throws SQLException;

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example)throws SQLException;

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example)throws SQLException;

    int updateByPrimaryKeySelective(RoleMenu record)throws SQLException;

    int updateByPrimaryKey(RoleMenu record)throws SQLException;
}