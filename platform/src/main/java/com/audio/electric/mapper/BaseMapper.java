package com.audio.electric.mapper;

import com.audio.electric.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/26 0026 16:52
 */
@Component
public interface BaseMapper {
    List<Menu> listMenuByRole(Role role) throws SQLException;

    List<Menu> listMenuByAccount(Account account) throws SQLException;

    Role getRoleByAccount(Account account) throws SQLException;

    List<Account> listAccountByRoledel(@Param("username") String accountName, @Param("role_id")Integer role_id);

    List<Account> listAccountByRoleadd(@Param("username") String accountName, @Param("role_id")Integer role_id);

    List<Map> listAccountOfRole();

    List<EnumValue> listEnumValueByTitle(String title)throws SQLException;

    List<Song> listAllSong()throws SQLException;

    List<Map> listMapByTitle(String title)throws SQLException;
}
