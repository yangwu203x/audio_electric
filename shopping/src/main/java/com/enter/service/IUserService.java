package com.enter.service;

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

    User editUserName(String name);

    User modifyPwd(String oldPassword,String password);

    User modifyEmail(String email,String validCode);

    void modifyTel(String tel,String validCode);
}
