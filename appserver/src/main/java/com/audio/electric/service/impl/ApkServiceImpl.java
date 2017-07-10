package com.audio.electric.service.impl;

import com.audio.electric.domain.Apk;
import com.audio.electric.mapper.ApkMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IApkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 11:35
 */
@Component
public class ApkServiceImpl extends BaseService implements IApkService{

    @Autowired
    private ApkMapper apkMapper;
    @Override
    public Apk checkApk() {
        return apkMapper.checkApk();
    }
}
