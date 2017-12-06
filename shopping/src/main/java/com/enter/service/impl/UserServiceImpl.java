package com.enter.service.impl;

import com.enter.annotations.LoginVerifyPage;
import com.enter.entity.User;
import com.enter.exception.ShoppingException;
import com.enter.repository.UserRepository;
import com.enter.service.IUserService;
import com.enter.util.*;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @LoginVerifyPage
    public User accountInfo() {
        //判断是否登录
        User user = CheckUserLogin.getloginuser();
        user = userRepository.getUserByEmail(user.getEmail());
        return user;
    }

    @LoginVerifyPage
    @Override
    public User modifyPwd(String oldPassword,String password){
        User loginUser = CheckUserLogin.getloginuser();
        if (password == null || oldPassword == null)
            throw new ShoppingException(RetCode.PARAMETER_ERROR);

        if (loginUser == null) {
            throw new ShoppingException(RetCode.UNLOGINED);
        }
        if(!Function.EncoderByMd5UTF8(oldPassword).equals(loginUser.getPassword()))
            throw new ShoppingException(RetCode.ERROR_PASSWORD);
        //修改密码
        password = Function.EncoderByMd5UTF8(password);
        if (password != null)
            loginUser.setPassword(password);
        loginUser = userRepository.save(loginUser);
        CheckUserLogin.doLogin(loginUser);
        return loginUser;
    }

    @Override
    public User modifyEmail(String email,String validCode) {
        User loginUser = CheckUserLogin.getloginuser();
        if (email == null || !FormatVerify.isEmail(email) || validCode == null)
            throw new ShoppingException(RetCode.PARAMETER_ERROR);
        if(validCode.equals(SessionUtil.getSessionAttribute(Constant.EMAIL_VALIDCODE)))
            throw new ShoppingException(RetCode.UTIL_AUTHCODE);
        if (loginUser == null) {
            throw new ShoppingException(RetCode.UNLOGINED);
        }
        loginUser.setEmail(email);
        loginUser = userRepository.save(loginUser);
        CheckUserLogin.doLogin(loginUser);
        return loginUser;
    }

    @Override
    public void modifyTel(String tel,String validCode) {
        if (!RegExpValidatorUtils.IsHandset(tel))
            throw new ShoppingException(RetCode.REG_FORMAT_ERROR_PHONENUM);
        if (validCode == null)
            throw new ShoppingException(RetCode.DXCODEISNULL);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String origalCode = (String) session.getAttribute(Constant.DXCODE);
        if (!validCode.equals(origalCode))
            throw new ShoppingException(RetCode.DXCODEMISTAKE);
        User userSession = CheckUserLogin.getloginuser();
        User user = userRepository.findOne(userSession.getId());
        user.setTel(tel);
        userRepository.save(user);
    }

    @Override
    public User editUserName(String name) {
        User loginUser = CheckUserLogin.getloginuser();
        if (name == null)
            throw new ShoppingException(RetCode.PARAMETER_ERROR);
        if (loginUser == null) {
            throw new ShoppingException(RetCode.UNLOGINED);
        }
        //修改昵称
        if (name != null)
            loginUser.setName(name);
        loginUser = userRepository.save(loginUser);
        CheckUserLogin.doLogin(loginUser);
        return loginUser;
    }
}
