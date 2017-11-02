package com.enter.service;

import com.enter.annotations.LoginVerify;
import com.enter.entity.User;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 9:10
 */
public interface IUserService {
    /**
     * 账户信息
     * @return
     */
    User accountInfo();
}
