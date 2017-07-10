package com.audio.electric.mapper;

import com.audio.electric.domain.FeedBack;
import com.audio.electric.domain.FeedBackExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface FeedBackMapper {
    int countByExample(FeedBackExample example)throws SQLException;

    int deleteByExample(FeedBackExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(FeedBack record)throws SQLException;

    int insertSelective(FeedBack record)throws SQLException;

    List<FeedBack> selectByExample(FeedBackExample example)throws SQLException;

    FeedBack selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") FeedBack record, @Param("example") FeedBackExample example)throws SQLException;

    int updateByExample(@Param("record") FeedBack record, @Param("example") FeedBackExample example)throws SQLException;

    int updateByPrimaryKeySelective(FeedBack record)throws SQLException;

    int updateByPrimaryKey(FeedBack record)throws SQLException;
}