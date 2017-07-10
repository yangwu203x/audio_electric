package com.audio.electric.util.filter;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.CheckUserLogin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截所有的请求
 * @Author leo_Yang【音特】
 * @Date 2017/4/19 0019 10:41
 */
//@WebFilter(filterName="loginFilter",urlPatterns="/*")
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
//      request.setCharacterEncoding("utf-8");
        String url=request.getServletPath();
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
