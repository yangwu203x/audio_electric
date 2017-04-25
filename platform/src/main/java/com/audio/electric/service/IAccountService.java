package com.audio.electric.service;

import com.audio.electric.domain.Account;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 10:27
 */
public interface IAccountService {

    public Account login(Account account ,String authCode);

    public int logout();
}
