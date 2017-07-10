package com.audio.electric.service;

import com.audio.electric.domain.User;
import com.audio.electric.util.protocol.Body;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by wuyang on 2017/3/15.
 */
public interface IUserService {


     int save(User user);


     int delete(User user);


     List<Map<String , String>> getAttention(long id, int pageNum, int pageSize);

     List<Map<String , String>> recommendDynamic(long id, int pageNum, int pageSize);

     Map<String,String> getPortfolioInfo(Long id);

    List<Map<String,String>> getCommentsById(Long id, int pageNum, int pageSize);

    int userInfo(User user);
}
