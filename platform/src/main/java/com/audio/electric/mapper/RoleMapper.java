package com.audio.electric.mapper;

import com.audio.electric.domain.Role;
import com.audio.electric.domain.RoleExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoleMapper {
    int countByExample(RoleExample example)throws SQLException;

    int deleteByExample(RoleExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(Role record)throws SQLException;

    int insertSelective(Role record)throws SQLException;

    List<Role> selectByExample(RoleExample example)throws SQLException;

    Role selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example)throws SQLException;

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example)throws SQLException;

    int updateByPrimaryKeySelective(Role record)throws SQLException;

    int updateByPrimaryKey(Role record)throws SQLException;
}