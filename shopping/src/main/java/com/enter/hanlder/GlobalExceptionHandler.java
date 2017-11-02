package com.enter.hanlder;

import com.enter.exception.PageException;
import com.enter.exception.ShoppingException;
import com.enter.util.enums.RetCode;
import com.enter.util.protocol.Body;
import com.enter.util.protocol.BodyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 捕获返回全局异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 返回错误页面
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = PageException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, PageException e) throws Exception {
        ModelAndView mav = new ModelAndView();
        if (e.getCode() == RetCode.UNLOGINED.getCode()){
            mav.setViewName("/reg/login");
        }else{
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName("/public/error");
        }


        return mav;
    }



    @ExceptionHandler(value = ShoppingException.class)
    @ResponseBody
    public Object defaultErrorHandlerBody(HttpServletRequest req, Exception e) throws Exception {
        if(e instanceof ShoppingException){
            ShoppingException appException = (ShoppingException) e;
            return BodyUtil.exception(appException.getCode(),appException.getMessage());
        }else{
            logger.info(e.getMessage());
            return BodyUtil.exception(RetCode.UNKNOWN_ERROR.getCode(),RetCode.UNKNOWN_ERROR.getMsg());
        }
    }

}

