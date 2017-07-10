package com.audio.electric.util.aspect;

import com.audio.electric.util.constants.Constant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 消息提醒切面
 * 2017-03-15 12:31
 */
@Aspect
@Component
public class RemindAspect {

    private final static Logger logger = LoggerFactory.getLogger(RemindAspect.class);


    @Pointcut("@annotation(com.audio.electric.util.annotation.Remind)")
    public void remind() {
    }

    @Before("remind()")
    public void doBefore(JoinPoint joinPoint) {
    }

    @After("remind()")
    public void doAfter() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String user_id = (String) request.getSession().getAttribute(Constant.IMTOUSERID);
        request.getParameter("user_id");
        logger.info("发送消息给对方");
    }

//    @AfterReturning(returning = "object", pointcut = "remind()")
//    public void doAfterReturning(Object object) {
//        logger.info("response={}", object.toString());
//    }

}
