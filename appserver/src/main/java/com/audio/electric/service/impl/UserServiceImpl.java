package com.audio.electric.service.impl;

import com.audio.electric.domain.User;
import com.audio.electric.mapper.UserMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IUserService;
import com.audio.electric.util.constants.Constant;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.protocol.Body;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.Function;
import com.audio.electric.util.tool.RegExpValidatorUtils;
import com.audio.electric.util.tool.SendEmail;
import com.audio.electric.util.tool.StringUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wuyang on 2017/3/15.
 */
@Component
public class UserServiceImpl extends BaseService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        try {
            return userMapper.save(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }



    @Override
    public int delete(User user) {
        try {
            return userMapper.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<Map<String , String>> getAttention(long id ,int pageNum , int pageSize){

        try {
            return userMapper.getAttention(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Map<String , String>> recommendDynamic(long id,int pageNum , int pageSize){
        try {
            return userMapper.recommendDynamic(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String,String> getPortfolioInfo(Long id){
        try {
            return userMapper.getPortfolioInfo(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Map<String,String>> getCommentsById(Long id ,int pageNum ,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        try {
            return userMapper.getCommentsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int userInfo(User user) {
        try {
            return userMapper.userInfo(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }
}
