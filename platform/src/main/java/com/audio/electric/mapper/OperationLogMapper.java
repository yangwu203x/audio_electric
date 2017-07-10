package com.audio.electric.mapper;

import com.audio.electric.domain.OperationLog;
import com.audio.electric.domain.OperationLogExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OperationLogMapper {
    int countByExample(OperationLogExample example)throws SQLException;

    int deleteByExample(OperationLogExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(OperationLog record)throws SQLException;

    int insertSelective(OperationLog record)throws SQLException;

    List<OperationLog> selectByExample(OperationLogExample example)throws SQLException;

    OperationLog selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") OperationLog record, @Param("example") OperationLogExample example)throws SQLException;

    int updateByExample(@Param("record") OperationLog record, @Param("example") OperationLogExample example)throws SQLException;

    int updateByPrimaryKeySelective(OperationLog record)throws SQLException;

    int updateByPrimaryKey(OperationLog record)throws SQLException;
}