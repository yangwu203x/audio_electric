package com.audio.electric.service.impl;

import com.audio.electric.domain.OperationLog;
import com.audio.electric.mapper.LogMapper;
import com.audio.electric.service.ILogService;
import com.audio.electric.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/19 0019 11:35
 */
@Component
public class LogServiceImpl implements ILogService{
    @Autowired
    private LogMapper logMapper;
    @Override
    public int save(OperationLog log) {
        try {
            return logMapper.save(log);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.UNKNOWN_ERROR.getCode();
    }
}
