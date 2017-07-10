package com.audio.electric.mapper;

import com.audio.electric.domain.UserFeedback;
import com.audio.electric.domain.UserFeedbackExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserFeedbackMapper {
    int countByExample(UserFeedbackExample example)throws SQLException;

    int deleteByExample(UserFeedbackExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(UserFeedback record)throws SQLException;

    int insertSelective(UserFeedback record)throws SQLException;

    List<UserFeedback> selectByExample(UserFeedbackExample example)throws SQLException;

    UserFeedback selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") UserFeedback record, @Param("example") UserFeedbackExample example)throws SQLException;

    int updateByExample(@Param("record") UserFeedback record, @Param("example") UserFeedbackExample example)throws SQLException;

    int updateByPrimaryKeySelective(UserFeedback record)throws SQLException;

    int updateByPrimaryKey(UserFeedback record)throws SQLException;
}