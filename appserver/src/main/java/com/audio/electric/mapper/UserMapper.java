package com.audio.electric.mapper;


import com.audio.electric.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by wuyang on 2017/3/15.
 */
@Component
public interface UserMapper {

     int save(User user)throws SQLException;

     int deleteUser(User user)throws SQLException;


     User login(User user) throws SQLException;

     User getUserByUserName(User user) throws SQLException;


     //动态
     List<Map<String , String>> getAttention(long id) throws SQLException;

     //推荐动态
     List<Map<String , String>> recommendDynamic(long id) throws SQLException;

     Map<String,String> getPortfolioInfo(Long id) throws SQLException;

     List<Map<String,String>> getCommentsById(Long id) throws SQLException;

    int userInfo(User user)throws SQLException;
}
