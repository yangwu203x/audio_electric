package com.audio.electric.service.impl;

import com.audio.electric.domain.RoleMenu;
import com.audio.electric.domain.RoleMenuExample;
import com.audio.electric.mapper.RoleMenuMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IRoleMenuService;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.tool.DateStyle;
import com.audio.electric.util.tool.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/5 0005 13:34
 */
@Component
public class RoleMenuServiceImpl extends BaseService implements IRoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Override
    public int givePrivilege(Integer role_id, String menuNo) {
        try {
            String[] menusNo=menuNo.split(",");
            for (String menuId : menusNo){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(role_id);
                roleMenu.setMenuId(Integer.parseInt(menuId));
                roleMenu.setCreateDate(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
                roleMenuMapper.insertSelective(roleMenu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return RetCode.FAILED.getCode();
        }

        return RetCode.SUCCESS.getCode();
    }

    @Override
    public int cancelPrivilege(Integer role_id, String menuNo) {
        try {
            String[] menusNo=menuNo.split(",");
            for (String menuId : menusNo){
                RoleMenuExample roleMenuExample = new RoleMenuExample();
                RoleMenuExample.Criteria criteria = roleMenuExample.or();
                criteria.andRoleIdEqualTo(role_id);
                criteria.andMenuIdEqualTo(Integer.parseInt(menuId));
                roleMenuMapper.deleteByExample(roleMenuExample);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return RetCode.FAILED.getCode();
        }

        return RetCode.SUCCESS.getCode();
    }
}
