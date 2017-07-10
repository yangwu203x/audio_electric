package com.audio.electric.service.impl;

import com.audio.electric.domain.OperationLog;
import com.audio.electric.domain.OperationLogExample;
import com.audio.electric.mapper.OperationLogMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IOperationLogService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/12 0012 15:04
 */
@Component
public class OperationLogServiceImpl extends BaseService implements IOperationLogService{

    @Autowired
    private OperationLogMapper operationLogMapper;

    @UsePage
    @Override
    public List<OperationLog> listLog(OperationLog operationLog) {
        OperationLogExample operationLogExample = new OperationLogExample();
        if (StringUtils.isNotNull(operationLog.getWay()))
            operationLogExample.or().andWayEqualTo(operationLog.getWay());
        try {
            return operationLogMapper.selectByExample(operationLogExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
