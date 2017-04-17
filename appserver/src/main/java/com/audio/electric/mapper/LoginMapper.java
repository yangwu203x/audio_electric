package com.audio.electric.mapper;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 9:42
 */
@Component
public interface LoginMapper {

    @Select("select id,email,status,password from user where email = #{email}")
    List<User> getUserByEmail(User user) throws SQLException;

    @Update(value = "insert into user(username,email, password, register_way,mac,status)" +
            " values(#{username},#{email},#{password},#{regitserWay},#{mac},#{status})")
    int reg(User user) throws SQLException;

    @Update(" update user set  password = #{password} ,mac = #{mac} where id = #{id}")
    int modifyPwd(User user) throws SQLException;


    /**
     * 激活
     * @param user
     * @return
     */
    @Update("update user set status = #{status} where id = #{id} and mac = #{mac}")
    int active(User user) throws SQLException;

    @Select("select id,email,status,mac from user where email = #{email} and mac = #{mac}")
    User getUserByEmailandMac(User user) throws SQLException;

    @Select("select id ,nickname ,photo ,username,level,status  from user where username = #{username} and password = #{password}")
    User login(User user);
}
