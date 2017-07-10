package com.audio.electric.service;

import com.audio.electric.domain.OperationLog;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/12 0012 15:03
 */
public interface IOperationLogService {

    List<OperationLog> listLog(OperationLog operationLog);
}
