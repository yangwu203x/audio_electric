package com.audio.electric.util.tool;

import com.audio.electric.domain.Account;
import com.audio.electric.util.constant.Constant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 16:06
 */
public class CheckUserLogin {

    public static Account getloginuser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //判断用户是否已经登陆
        Account account =(Account) request.getSession().getAttribute(Constant.CURRENT_LOGIN_ACCOUNT);
        return account;
    }
}
