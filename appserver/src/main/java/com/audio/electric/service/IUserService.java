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


    public int save(User user);


    public int delete(User user);


    public List<Map<String , String>> getAttention(long id, int pageNum, int pageSize);

    public List<Map<String , String>> recommendDynamic(long id, int pageNum, int pageSize);

    public Map<String,String> getPortfolioInfo(Long id);

    List<Map<String,String>> getCommentsById(Long id, int pageNum, int pageSize);
}
