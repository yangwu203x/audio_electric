package com.audio.electric.util.aspect;

import com.alibaba.fastjson.JSONObject;
import com.audio.electric.domain.Account;
import com.audio.electric.domain.OperationLog;
import com.audio.electric.service.BaseService;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.tool.CheckUserLogin;
import com.audio.electric.util.tool.DateStyle;
import com.audio.electric.util.tool.DateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志记录切面
 * 2017-03-15 12:31
 */
@Aspect
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private BaseService baseService;
    private static OperationLog operationlog = new OperationLog();

    @Pointcut("execution(public * com.audio.electric.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

        operationlog.setUrl(request.getRequestURL().toString());
        operationlog.setMethod(request.getMethod().toString());
        operationlog.setIp(request.getRemoteAddr().toString());
        operationlog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        operationlog.setParameter(joinPoint.getArgs().toString());
        operationlog.setCreateDate(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS_CN.getValue()));
        operationlog.setWay(Constant.PLATACCOUNTLOG);
    }

    @After("log()")
    public void doAfter() {
        Account account = CheckUserLogin.getloginuser();
        if (account != null){
//            operationlog.setAccountId(account.getId().toString());
//            baseService.saveOperation(operationlog);
        }
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        if (object != null)
        logger.info("response={}", object.toString());
    }

}
