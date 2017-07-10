package com.audio.electric.util.config;

import com.audio.electric.util.intercepter.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/20 0020 10:05
 */
@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private LoginIntercepter loginIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercepter).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
