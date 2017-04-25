package com.audio.electric.service.impl;

import com.audio.electric.domain.Menu;
import com.audio.electric.domain.MenuExample;
import com.audio.electric.mapper.MenuMapper;
import com.audio.electric.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 14:22
 */
@Component
public class MenuServiceImpl implements IMenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> obtainAllMenu() {
        MenuExample menuExample = new MenuExample();

        List<Menu> menuList = menuMapper.selectByExample(menuExample);
        menuList = resolveMenu(menuList,0);
        return menuList;
    }

    @Override
    public List<Menu> obtainAccountMenu(String accountNo) {
        List<Menu> menuList = null;
        try {
            menuList = menuMapper.listMenuByUserId("1");
            menuList = resolveMenu(menuList,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    /**
     * 递归解析菜单
     */
    private List<Menu> resolveMenu(List<Menu> menuList,int parentMenuId){
        List<Menu> subMenuList=new ArrayList<Menu>();
        for (int i = 0; i < menuList.size(); i++) {
            Menu subMenu=menuList.get(i);
            if(subMenu.getParentMenuId()==parentMenuId){
                //递归解析菜单
                List<Menu> menus=resolveMenu(menuList, subMenu.getId());
                //保存已经解析的子菜单
                subMenu.setSubMenuList(menus);
                //保存父菜单
                subMenuList.add(subMenu);
            }
        }
        return subMenuList;
    }
}
