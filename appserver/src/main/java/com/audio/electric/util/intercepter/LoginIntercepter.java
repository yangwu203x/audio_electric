package com.audio.electric.util.intercepter;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.CheckUserLogin;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/20 0020 9:42
 */
@Component
public class LoginIntercepter extends HandlerInterceptorAdapter {

    /**
     * 进行身份认证，在handler执行之前执行,在请求被处理器处理之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //判断是否为公开地址
//        String url = request.getRequestURL().toString();
//        if(url.contains("/login/") || url.contains("/error")) {
//            return true;//是公开地址则放行
//        }
//        CookieUser cookieUser = CheckUserLogin.getloginuser();
//        if (cookieUser == null){
//            response.getWriter().println(BodyUtil.error(RetCode.UNLOGINED));
//            return false;
//        }else{
//            return true;
//        }
        return true;
    }



}
