package com.audio.electric.util.tool;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.domain.User;
import com.audio.electric.domain.UserOnline;
import com.audio.electric.service.IUserService;
import com.audio.electric.util.constants.Constant;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.protocol.Body;
import com.audio.electric.util.protocol.BodyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;


/**
 * Created by yangwu on 2017/3/22 0023.
 */
public class CheckUserLogin {

    private static final Logger logger = LoggerFactory.getLogger(CheckUserLogin.class);

    public static CookieUser getloginuser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	//判断用户是否已经登陆
    	CookieUser user =(CookieUser) request.getSession().getAttribute(Constant.CURRENT_LOGIN_USER);
    	if(user == null)
    	    throw new AppException(RetCode.UNLOGINED);
    	return user;
   }



    /**
     * 描述 登录成功处理
     * @param user
     */
    public static void doLogin(User user) {
        CookieUser cookieUser = putCookieUser(user);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        logger.info("login------------------------------------------------"+ session.getId());
        session.setAttribute(Constant.CURRENT_LOGIN_USER,cookieUser);
    }



    /**
     * 设置cookieUser
     * @param user
     * @return
     */
    public static CookieUser putCookieUser(User user){
        CookieUser cookieUser = new CookieUser();
        cookieUser.setId(user.getId());
        cookieUser.setUserId(user.getId());
        cookieUser.setUsername(user.getUsername());
        cookieUser.setNickname(user.getNickname());
        cookieUser.setPhoto(user.getPhoto());
        cookieUser.setLevel(user.getLevel());
        return cookieUser;
    }
}