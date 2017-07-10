package com.audio.electric.service;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/5 0005 13:34
 */
public interface IRoleMenuService {
    int givePrivilege(Integer role_id, String menuNo);

    int cancelPrivilege(Integer role_id, String menuNo);
}
