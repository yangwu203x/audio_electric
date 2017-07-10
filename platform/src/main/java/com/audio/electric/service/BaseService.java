package com.audio.electric.service;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.OperationLog;
import com.audio.electric.domain.Role;
import com.audio.electric.mapper.BaseMapper;
import com.audio.electric.mapper.OperationLogMapper;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 15:57
 */
@Component
public class BaseService {
    protected final static Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected BaseMapper baseMapper;
    @Autowired
    private OperationLogMapper operationLogMapper;

    public int saveOperation(OperationLog operationlog) {
        try {
            return operationLogMapper.insertSelective(operationlog);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    public List<Long> getIdListLong(String ids) {
        String[] arr = ids.split(",");
        if (arr == null)
            throw new PlatException(RetCode.PARAMETER_ERROR);
        List<Long> idList = new ArrayList<>();
        for(String str : arr)
            idList.add(Long.parseLong(str));
        return idList;
    }

    public List<Integer> getIdListInt(String ids) {
        String[] arr = ids.split(",");
        if (arr == null)
            throw new PlatException(RetCode.PARAMETER_ERROR);
        List<Integer> idList = new ArrayList<>();
        for(String str : arr)
            idList.add(Integer.parseInt(str));
        return idList;
    }

    public Role getRoleByAccount(Account account){
        Role role = null;
        try {
            role = baseMapper.getRoleByAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (role == null){
            role = new Role();
            role.setRoleName("游客");
        }
        return role;
    }

    @UsePage
    public List<Account> listAccountByRoledel(String username, Integer role_id) {
        return baseMapper.listAccountByRoledel(username,role_id);
    }

    @UsePage
    public List<Account> listAccountByRoleadd(String username, Integer role_id) {
        return baseMapper.listAccountByRoleadd(username,role_id);
    }

    public List<Map> listAccountOfRole() {
        return baseMapper.listAccountOfRole();
    }
}
