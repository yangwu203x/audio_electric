package com.audio.electric.service;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.Menu;
import com.audio.electric.domain.Role;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 14:22
 */
public interface IMenuService {

    List<Menu> obtainAllMenu();

    List<Menu> listMenuByRole(Role role);

    List<Menu> listMenuByAccount(Account account);

    List<Menu> listMenu(Menu menu);

    Menu getMenu(Menu menu);

    int addMenu(Menu menu);

    int modifyMenu(Menu menu);

    int deleteMenu(String ids);

    List<Integer> listMenuIdByRole(Role role);
}
