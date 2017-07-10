package com.audio.electric.mapper;

import com.audio.electric.domain.ExportPrivilege;
import com.audio.electric.domain.ExportPrivilegeExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ExportPrivilegeMapper {
    int countByExample(ExportPrivilegeExample example)throws SQLException;

    int deleteByExample(ExportPrivilegeExample example)throws SQLException;

    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(ExportPrivilege record)throws SQLException;

    int insertSelective(ExportPrivilege record)throws SQLException;

    List<ExportPrivilege> selectByExample(ExportPrivilegeExample example)throws SQLException;

    ExportPrivilege selectByPrimaryKey(Integer id)throws SQLException;

    int updateByExampleSelective(@Param("record") ExportPrivilege record, @Param("example") ExportPrivilegeExample example)throws SQLException;

    int updateByExample(@Param("record") ExportPrivilege record, @Param("example") ExportPrivilegeExample example)throws SQLException;

    int updateByPrimaryKeySelective(ExportPrivilege record)throws SQLException;

    int updateByPrimaryKey(ExportPrivilege record)throws SQLException;
}