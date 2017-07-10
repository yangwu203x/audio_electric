package com.audio.electric.mapper;

import com.audio.electric.domain.Apk;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 11:36
 */
@Component
public interface ApkMapper {
    Apk checkApk();
}
