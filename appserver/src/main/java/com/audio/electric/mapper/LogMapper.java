package com.audio.electric.mapper;

import com.audio.electric.domain.OperationLog;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/19 0019 11:36
 */
@Component
public interface LogMapper {

    int save(OperationLog log)throws SQLException;
}
