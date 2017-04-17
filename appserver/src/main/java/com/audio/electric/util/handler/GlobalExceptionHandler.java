package com.audio.electric.util.handler;

import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.protocol.Body;
import com.audio.electric.util.protocol.BodyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 捕获返回全局异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //不能同时存在两个 @ExceptionHandler(value = Exception.class)异常
//    /**
//     * 返回错误页面
//     * @param req
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("error");
//        return mav;
//    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Body defaultErrorHandlerBody(HttpServletRequest req, Exception e) throws Exception {
        if(e instanceof AppException){
            AppException appException = (AppException) e;
            return BodyUtil.exception(appException.getCode(),appException.getMessage());
        }else{
            logger.info(e.getLocalizedMessage());
            return BodyUtil.exception(RetCode.UNKNOWN_ERROR.getCode(),e.getMessage());
        }
    }

}

