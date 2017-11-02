package com.enter.util;

import com.enter.entity.Address;
import com.enter.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by yangwu on 2017/3/22 0023.
 */
public class CheckUserLogin {

    private static final Logger logger = LoggerFactory.getLogger(CheckUserLogin.class);

    public static User getloginuser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	//判断用户是否已经登陆
        User user =(User) request.getSession().getAttribute(Constant.CURRENT_LOGIN_USER);
    	return user;
   }

    public static void doLogout() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        logger.info("logout------------------------------------------------"+ session.getId());
        session.removeAttribute(Constant.CURRENT_LOGIN_USER);
    }

    /**
     * 描述 登录成功处理
     * @param user
     */
    public static void doLogin(User user) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        logger.info("login------------------------------------------------"+ session.getId());
        session.setAttribute(Constant.CURRENT_LOGIN_USER,user);
    }


    public static void doLogin(User user, Address address) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        logger.info("login------------------------------------------------"+ session.getId());
        session.setAttribute(Constant.CURRENT_LOGIN_USER,user);
        session.setAttribute(Constant.DEFAULTADDRESS,address);
    }
}