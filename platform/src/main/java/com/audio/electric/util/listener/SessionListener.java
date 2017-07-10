package com.audio.electric.util.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/2 0002 9:52
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.info("创建了");
        HttpSession session = event.getSession();// 获得Session对象
        // 通过Session获得servletcontext对象
        ServletContext servletContext = session.getServletContext();
        /**
         * 1.获取num值
         * 2.加1
         * 3.存入servletcontext
         */
        Object object = servletContext.getAttribute("num");
        if (object == null) {
            servletContext.setAttribute("num", 1);
        } else {
            Object num = servletContext.getAttribute("num");
            int num1 = (int) num;
            servletContext.setAttribute("num", num1 + 1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info("销毁了");
        HttpSession session = event.getSession();// 获得Session对象
        // 通过Session获得servletcontext对象
        ServletContext servletContext = session.getServletContext();
        /**
         *  1.获取num值
         *  2.减1
         *  3.存入servletcontext
         */
//        servletContext.setAttribute("num", (long) servletContext.getAttribute("num") - 1);
    }

}
