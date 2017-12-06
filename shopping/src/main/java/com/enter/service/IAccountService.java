package com.enter.service;

import com.enter.entity.User;
import com.enter.util.protocol.Body;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/17 0017 10:28
 */
public interface IAccountService {

    /**
     * 发送验证码
     * @param email
     * @return
     */
    void sendValidCode(String email,String type);

    void checkValidCode(String email,String validCode,String type);

    void doReg(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    int modifyPwd(User user);

    /**
     * 激活
     * @param user
     * @return
     */
    Object active(User user);

    User getUserByEmailandMac(User user);

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    User login(String email,String password);

    Object loginOut();

    Object findPwd(User user);

    void logout();

//    void modifyTel(String tel, String msgCode);

    void sendDxCode(String tel);

    User changePwd(User user);
}
