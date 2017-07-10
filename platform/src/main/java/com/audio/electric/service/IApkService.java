package com.audio.electric.service;

import com.audio.electric.domain.Apk;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/3 0003 10:12
 */
public interface IApkService {
    List<Apk> listApk(Apk apk);

    int addApkHistory(Apk apk);

    int deleteApk(String ids);
}
