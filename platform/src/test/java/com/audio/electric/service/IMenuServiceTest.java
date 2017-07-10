package com.audio.electric.service;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.Account;
import com.audio.electric.domain.Menu;
import com.audio.electric.domain.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 14:37
 */
public class IMenuServiceTest extends PlatformApplicationTests{
    @Autowired
    private IMenuService menuService;
    @Test
    public void obtainAllMenu() throws Exception {
        List<Menu> menuList = menuService.obtainAllMenu();
        for (Menu menu : menuList){
            System.out.println(menu.toString());
        }
    }

    @Test
    public void listMenuByAccount() throws Exception {
        Account account = new Account();
        account.setId(1);
        List<Menu> menuList = menuService.listMenuByAccount(account);
        for (Menu menu : menuList){
            System.out.println(menu.toString());
        }
    }

    @Test
    public void obtainRoleMenu() throws Exception {
        Role role = new Role();
        role.setId(1);
        List<Menu> menuList = menuService.listMenuByRole(role);
        for (Menu menu : menuList){
            System.out.println(menu.toString());
        }
    }

}