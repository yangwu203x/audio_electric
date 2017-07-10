package com.audio.electric.service;

import com.audio.electric.domain.Account;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 10:27
 */
public interface IAccountService {

    Account login(Account account , String authCode);

    int logout();

    List<Account> listAccount(Account account);

    Account getAccount(Account account);

    int addAccount(Account account);

    int modifyAccount(Account account);

    int deleteAccount(String ids);

    int isAccountExist(Account account);

    Object accountOpen(Account account);

    Object accountForbid(Account account);

    List<Account> listAccountName();
}
