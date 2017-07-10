package com.audio.electric.service.impl;

import com.audio.electric.domain.User;
import com.audio.electric.domain.UserExample;
import com.audio.electric.mapper.UserMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IUserService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/21 0021 14:15
 */
@Component
public class UserServiceImpl extends BaseService implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @UsePage
    @Override
    public List<User> listUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        if (StringUtils.isNotNull(user.getName()))
            criteria.andNameLike(user.getName());
        try {
            return userMapper.selectByExample(userExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(User user) {
        try {
            if (user.getId() == null)
                throw new PlatException(RetCode.PARAMETER_ERROR);
            return userMapper.selectByPrimaryKey(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int saveUser(User user) {
        try {
            return userMapper.insertSelective(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int editUser(User user) {
        try {
            UserExample userExample = new UserExample();
            userExample.or().andIdEqualTo(user.getId());
            return userMapper.updateByExampleSelective(user,userExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int deleteUser(String ids) {
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            List<Long> idList = getIdListLong(ids);
            UserExample userExample = new UserExample();
            userExample.or().andIdIn(idList);
            return userMapper.deleteByExample(userExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public List<String> autoSearch(User user) {
        List<String> keywords = new ArrayList<>();
        List<User> userList;
        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.or();
            if (StringUtils.isNotNull(user.getName())){
                criteria.andNameLike('%'+user.getName()+'%');
                userList = userMapper.selectByExample(userExample);
                for (User temp:userList){
                    keywords.add(temp.getName());
                }
            }
            if (StringUtils.isNotNull(user.getEmail())){
                criteria.andEmailLike("%"+user.getEmail()+"%");
                userList = userMapper.selectByExample(userExample);
                for (User temp:userList){
                    keywords.add(temp.getEmail());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keywords;
    }

}
