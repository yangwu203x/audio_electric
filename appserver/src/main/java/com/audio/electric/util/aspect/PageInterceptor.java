package com.audio.electric.util.aspect;

import com.audio.electric.util.tool.StringUtils;
import com.github.pagehelper.PageHelper;
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
 * Created by yangwu on 2017/3/31 0031.
 */
@Aspect
@Component
public class PageInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

    @Pointcut("@annotation(com.audio.electric.util.annotation.UserPage)")
    public void pageAspect(){

    }

    @Before("pageAspect()")
    public void doBefore(){
        logger.info("============================================");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String pageStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");

        //默认取第一页，取10条
        int pageNum = 1,pageSize = 10;
        if (StringUtils.isNumeric(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        if (StringUtils.isNumeric(pageStr)){
            pageNum = Integer.parseInt(pageStr);
        }

        PageHelper.startPage(pageNum,pageSize);
    }

}
