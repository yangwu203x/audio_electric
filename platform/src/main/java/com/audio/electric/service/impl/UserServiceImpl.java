package com.audio.electric.service.impl;

import com.audio.electric.domain.User;
import com.audio.electric.mapper.UserMapper;
import com.audio.electric.service.IUserService;
import com.audio.electric.util.annotation.UserPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/21 0021 14:15
 */
@Component
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @UserPage
    @Override
    public List<User> listUser() {
        return userMapper.selectByExample(null);
    }

}
