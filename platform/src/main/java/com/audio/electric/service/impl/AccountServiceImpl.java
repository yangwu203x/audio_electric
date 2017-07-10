package com.audio.electric.service.impl;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.AccountExample;
import com.audio.electric.mapper.AccountMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IAccountService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.tool.DateStyle;
import com.audio.electric.util.tool.DateUtil;
import com.audio.electric.util.tool.IPUtil;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
            //修改登录时间、ip

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(accountList != null && accountList.size() > 0){
            account.setLastLoginTime(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
            account.setLastLoginIp(IPUtil.getRemoteIP());
            account.setId(accountList.get(0).getId());
            modifyAccount(account);
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
        session.removeAttribute(Constant.CURRENT_LOGIN_ACCOUNT);
        return RetCode.SUCCESS.getCode();
    }

    @UsePage
    @Override
    public List<Account> listAccount(Account account) {
        AccountExample menuExample = new AccountExample();

        AccountExample.Criteria criteria = menuExample.or();
        if (StringUtils.isNotNull(account.getUsername()))
            criteria.andUsernameLike(account.getUsername());
        List<Account> accountList = null;
        try {
            accountList = accountMapper.selectByExample(menuExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public Account getAccount(Account account) {
        try {
            account = accountMapper.selectByPrimaryKey(account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public int addAccount(Account account) {
        int result = RetCode.FAILED.getCode();
        try {
            //先判断有没有存在的登录名
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.or();
            criteria.andUsernameEqualTo(account.getUsername());
            List<Account> temp = accountMapper.selectByExample(accountExample);
            if (temp != null && temp.size() > 0)
                throw  new PlatException(RetCode.USERNAMEEXIST);
            result = accountMapper.insertSelective(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyAccount(Account account) {
        logger.info(account.toString());
        int result = RetCode.FAILED.getCode();
        try {
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.or();
            criteria.andIdEqualTo(account.getId());
            result = accountMapper.updateByExampleSelective(account,accountExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteAccount(String ids) {
        int result = RetCode.FAILED.getCode();
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            String[] arr = ids.split(",");
            if (arr == null)
                throw new PlatException(RetCode.PARAMETER_ERROR);
            List<Integer> idList = new ArrayList<>();
            for(String str : arr)
                idList.add(Integer.parseInt(str));
            AccountExample accountExample = new AccountExample();
            accountExample.or().andIdIn(idList);
            result = accountMapper.deleteByExample(accountExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int isAccountExist(Account account) {
        AccountExample accountExample = new AccountExample();
        accountExample.or().andUsernameEqualTo(account.getUsername());
        try {
            return accountMapper.countByExample(accountExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public Object accountOpen(Account account) {
        account.setStatus(1);
        AccountExample accountExample = new AccountExample();
        accountExample.or().andIdEqualTo(account.getId());
        try {
            return accountMapper.updateByExampleSelective(account,accountExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public Object accountForbid(Account account) {
        account.setStatus(0);
        AccountExample accountExample = new AccountExample();
        accountExample.or().andIdEqualTo(account.getId());
        try {
            return accountMapper.updateByExampleSelective(account,accountExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public List<Account> listAccountName() {
        List<String> usernameList = new ArrayList<>();
        try {
            List<Account> accountList = accountMapper.selectByExample(new AccountExample());
            Iterator<Account> it = accountList.iterator();
            while (it.hasNext())
                it.next().setPassword(null);
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 描述 登录成功处理
     * @param account
     */
    public static void doLogin(Account account) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        logger.info("login------------------------------------------------"+ session.getId());
        session.setAttribute(Constant.CURRENT_LOGIN_ACCOUNT,account);
    }
}
