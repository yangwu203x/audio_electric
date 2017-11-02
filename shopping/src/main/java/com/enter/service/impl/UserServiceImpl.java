package com.enter.service.impl;

import com.enter.annotations.LoginVerify;
import com.enter.entity.User;
import com.enter.exception.PageException;
import com.enter.exception.ShoppingException;
import com.enter.repository.UserRepository;
import com.enter.service.IUserService;
import com.enter.util.CheckUserLogin;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 9:10
 */
@Component
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @LoginVerify
    public User accountInfo() {
        //判断是否登录
        User user = CheckUserLogin.getloginuser();
        user = userRepository.getUserByEmail(user.getEmail());
        return user;
    }
}
