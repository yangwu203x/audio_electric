package com.audio.electric.service;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.Menu;
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
    public void obtainAccountMenu() throws Exception {
        List<Menu> menuList = menuService.obtainAccountMenu("1");
        for (Menu menu : menuList){
            System.out.println(menu.toString());
        }
    }

}