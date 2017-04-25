package com.audio.electric.service.impl;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.AccountExample;
import com.audio.electric.mapper.AccountMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IAccountService;
import com.audio.electric.util.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 10:27
 */
@Component
public class AccountServiceImpl extends BaseService implements IAccountService{

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Account login(Account account ,String authCode) {
        //TODO 1.校验验证码 2.加密 3.异常抛出

        List<Account> accountList = null;
        try {
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria =  accountExample.or();
            criteria.andPasswordEqualTo(account.getPassword());
            criteria.andUsernameEqualTo(account.getUsername());
            accountList = accountMapper.selectByExample(accountExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(accountList != null && accountList.size() > 0){
            doLogin(accountList.get(0));
            return accountList.get(0);
        }
            else
        return null;
    }

    @Override
    public int logout() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(Constant.CURRENT_LOGIN_USER);
        return 0;
    }

    /**
     * 描述 登录成功处理
     * @param account
     */
    public static void doLogin(Account account) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        logger.info("login------------------------------------------------"+ session.getId());
        session.setAttribute(Constant.CURRENT_LOGIN_USER,account);
    }
}
