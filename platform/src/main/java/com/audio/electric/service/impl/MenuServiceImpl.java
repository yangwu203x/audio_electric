package com.audio.electric.service.impl;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.Menu;
import com.audio.electric.domain.MenuExample;
import com.audio.electric.domain.Role;
import com.audio.electric.mapper.MenuMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IMenuService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.tool.StringUtils;
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
public class MenuServiceImpl extends BaseService implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> obtainAllMenu() {
        MenuExample menuExample = new MenuExample();
        List<Menu> menuList = null;
        try {
            menuList = menuMapper.selectByExample(menuExample);
            menuList = resolveMenu(menuList,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public List<Menu> listMenuByRole(Role role) {
        List<Menu> menuList = null;
        try {
            MenuExample menuExample = new MenuExample();
            menuList = baseMapper.listMenuByRole(role);
            menuList = resolveMenu(menuList,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public List<Integer> listMenuIdByRole(Role role) {
        List<Integer> idsList = new ArrayList<>();
        List<Menu> menuList = null;
        try {
            MenuExample menuExample = new MenuExample();
            menuList = baseMapper.listMenuByRole(role);
            for (Menu menu : menuList)
                idsList.add(menu.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idsList;
    }

    @Override
    public List<Menu> listMenuByAccount(Account account) {
        List<Menu> menuList = null;
        try {
            MenuExample menuExample = new MenuExample();
            menuList = baseMapper.listMenuByAccount(account);
            menuList = resolveMenu(menuList,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @UsePage
    @Override
    public List<Menu> listMenu(Menu menu) {
        MenuExample menuExample = new MenuExample();

        MenuExample.Criteria criteria = menuExample.or();
        if (StringUtils.isNotNull(menu.getName()))
            criteria.andNameLike('%'+menu.getName()+'%');
        List<Menu> menuList = null;
        try {
            menuList = menuMapper.selectByExample(menuExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public Menu getMenu(Menu menu) {
        try {
            menu = menuMapper.selectByPrimaryKey(menu.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public int addMenu(Menu menu) {
        int result = RetCode.FAILED.getCode();
        try {
            result = menuMapper.insertSelective(menu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyMenu(Menu menu) {
        logger.info(menu.toString());
        int result = RetCode.FAILED.getCode();
        try {
            MenuExample menuExample = new MenuExample();
            MenuExample.Criteria criteria = menuExample.or();
            criteria.andIdEqualTo(menu.getId());
            result = menuMapper.updateByExampleSelective(menu,menuExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int deleteMenu(String ids) {
        int result = RetCode.FAILED.getCode();
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);


            List<Integer> idList = getIdListInt(ids);
            MenuExample menuExample = new MenuExample();
            menuExample.or().andParentMenuIdIn(idList);

            //判断是否有子菜单
            int count = menuMapper.countByExample(menuExample);
            if(count > 0){
                return result;
            }else{
                menuExample.clear();
                menuExample.or().andIdIn(idList);
                result = menuMapper.deleteByExample(menuExample);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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
