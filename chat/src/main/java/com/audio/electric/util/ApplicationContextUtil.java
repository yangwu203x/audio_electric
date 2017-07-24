package com.audio.electric.util;

import org.springframework.context.ApplicationContext;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/20 0020 11:15
 */
public class ApplicationContextUtil {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }
    public static Object getBean(Class<?> entity){
        if(applicationContext == null)
            return null;
        return applicationContext.getBean(entity);
    }


}
