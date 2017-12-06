package com.audio.electric.util.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/12 0012 14:59
 */
@Configuration
@MapperScan(basePackages = {"com.audio.electric.mapper"})
public class MybatisConfig {
}
