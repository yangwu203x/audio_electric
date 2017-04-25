package com.audio.electric.mapper;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.AccountExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AccountMapper {
    int countByExample(AccountExample example)throws SQLException;

    int deleteByExample(AccountExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(Account record)throws SQLException;

    int insertSelective(Account record)throws SQLException;

    List<Account> selectByExample(AccountExample example)throws SQLException;

    Account selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example)throws SQLException;

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example)throws SQLException;

    int updateByPrimaryKeySelective(Account record)throws SQLException;

    int updateByPrimaryKey(Account record)throws SQLException;
}