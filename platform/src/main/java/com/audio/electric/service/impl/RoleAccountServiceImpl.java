package com.audio.electric.service.impl;

import com.audio.electric.domain.RoleAccount;
import com.audio.electric.domain.RoleAccountExample;
import com.audio.electric.mapper.RoleAccountMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IRoleAccountService;
import com.audio.electric.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/15 0015 14:11
 */
@Component
public class RoleAccountServiceImpl extends BaseService implements IRoleAccountService {

    @Autowired
    private RoleAccountMapper roleAccountMapper;
    @Override
    public int addAccountToRole(String account_ids, Integer role_id) {
        try {
            List<Integer> ids = getIdListInt(account_ids);
            for (Integer account_id: ids){
                RoleAccount roleAccount = new RoleAccount();
                roleAccount.setRoleId(role_id);
                roleAccount.setAccountId(account_id);
                roleAccountMapper.insertSelective(roleAccount);
            }
            return RetCode.SUCCESS.getCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int delAccountToRole(String account_ids, Integer role_id) {
        try {
            List<Integer> ids = getIdListInt(account_ids);
            RoleAccountExample roleAccountExample = new RoleAccountExample();
            RoleAccountExample.Criteria criteria = roleAccountExample.or();
            criteria.andAccountIdIn(ids);
            criteria.andRoleIdEqualTo(role_id);
            return roleAccountMapper.deleteByExample(roleAccountExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }
}
