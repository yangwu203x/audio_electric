package com.audio.electric.service;

import com.audio.electric.domain.OperationLog;

/**
 * 日志纪录类
 * @Author leo_Yang【音特】
 * @Date 2017/4/19 0019 11:34
 */
public interface ILogService {

    int save(OperationLog log);
}
