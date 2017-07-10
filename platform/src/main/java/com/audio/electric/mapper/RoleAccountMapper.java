package com.audio.electric.mapper;

import com.audio.electric.domain.RoleAccount;
import com.audio.electric.domain.RoleAccountExample;
import com.audio.electric.domain.RoleAccountKey;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoleAccountMapper {
    int countByExample(RoleAccountExample example)throws SQLException;

    int deleteByExample(RoleAccountExample example)throws SQLException;

    int deleteByPrimaryKey(RoleAccountKey key)throws SQLException;

    int insert(RoleAccount record)throws SQLException;

    int insertSelective(RoleAccount record)throws SQLException;

    List<RoleAccount> selectByExample(RoleAccountExample example)throws SQLException;

    RoleAccount selectByPrimaryKey(RoleAccountKey key)throws SQLException;

    int updateByExampleSelective(@Param("record") RoleAccount record, @Param("example") RoleAccountExample example)throws SQLException;

    int updateByExample(@Param("record") RoleAccount record, @Param("example") RoleAccountExample example)throws SQLException;

    int updateByPrimaryKeySelective(RoleAccount record)throws SQLException;

    int updateByPrimaryKey(RoleAccount record)throws SQLException;
}