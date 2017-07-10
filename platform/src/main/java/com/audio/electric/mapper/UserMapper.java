package com.audio.electric.mapper;

import com.audio.electric.domain.User;
import com.audio.electric.domain.UserExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int countByExample(UserExample example)throws SQLException;

    int deleteByExample(UserExample example)throws SQLException;

    int deleteByPrimaryKey(Long id)throws SQLException;

    int insert(User record)throws SQLException;

    int insertSelective(User record)throws SQLException;

    List<User> selectByExample(UserExample example)throws SQLException;

    User selectByPrimaryKey(Long id)throws SQLException;

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example)throws SQLException;

    int updateByExample(@Param("record") User record, @Param("example") UserExample example)throws SQLException;

    int updateByPrimaryKeySelective(User record)throws SQLException;

    int updateByPrimaryKey(User record)throws SQLException;
}