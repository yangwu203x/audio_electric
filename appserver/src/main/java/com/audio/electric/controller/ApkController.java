package com.audio.electric.controller;

import com.audio.electric.domain.Apk;
import com.audio.electric.service.IApkService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 11:31
 */
@RestController
@RequestMapping("/apk")
public class ApkController extends BaseController{

    @Autowired
    private IApkService apkService;
    /**
     * 获取最新apk,返回下载地址
     * @return
     */
    @RequestMapping("/checkApk")
    public Object checkApk(){
        Apk apk =  apkService.checkApk();
        System.out.println(BodyUtil.sucess(apk, DataType.Object).toString());
        return BodyUtil.sucess(apk, DataType.Object).toString();
    }
}
