package com.enter.aspect;

import com.enter.entity.User;
import com.enter.exception.PageException;
import com.enter.util.Constant;
import com.enter.util.enums.RetCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/27 0027 16:34
 */
@Aspect
@Component
public class IsLoginAspectPage {

    private final static Logger logger = LoggerFactory.getLogger(IsLoginAspectPage.class);


    @Pointcut("@annotation(com.enter.annotations.LoginVerifyPage)")
    public void loginVerify() {
    }

    @Before("loginVerify()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user =(User) request.getSession().getAttribute(Constant.CURRENT_LOGIN_USER);
        if(user == null)
            throw new PageException(RetCode.UNLOGINED);
    }

    @After("loginVerify()")
    public void doAfter() {
    }
}
