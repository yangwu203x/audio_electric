package com.audio.electric.service;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/15 0015 14:11
 */
public interface IRoleAccountService {

    int addAccountToRole(String account_ids, Integer role_id);

    int delAccountToRole(String account_ids, Integer role_id);
}
