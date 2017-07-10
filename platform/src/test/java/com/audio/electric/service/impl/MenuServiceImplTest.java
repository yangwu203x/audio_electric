package com.audio.electric.service.impl;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.Menu;
import com.audio.electric.service.IMenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/27 0027 15:21
 */
public class MenuServiceImplTest extends PlatformApplicationTests{
    @Autowired
    private IMenuService menuService;
    @Test
    public void obtainAllMenu() throws Exception {
    }

    @Test
    public void obtainRoleMenu() throws Exception {
    }

    @Test
    public void listMenu() throws Exception {
    }

//    @Test
//    public void getMenu() throws Exception {
//        Menu menu = new Menu();
//        menu.setId(15);
//        menu = menuService.getMenu(menu);
//        System.out.println(menu.getParentMenuId());
//        System.out.println(menu.getUrl());
//        System.out.println(menu.getName());
//        System.out.println(menu.getId());
//    }
//
//    @Test
//    public void addMenu() throws Exception {
//        Menu menu = new Menu();
//        menu.setName("图片管理");
//        menu.setUrl("picture");
//        menu.setParentMenuId(1);
//        menu.setId(5);
//        int result = menuService.addMenu(menu);
//        System.out.println(result);
//    }
//    @Test
//    public void modifyMenu() throws Exception {
//        Menu menu = new Menu();
//        menu.setId(13);
//        menu.setUrl("#");
//        int result = menuService.modifyMenu(menu);
//    }
//
//    @Test
//    public void deleteMenu() throws Exception {
//        int result = menuService.deleteMenu("1,2,3,4");
//    }


}