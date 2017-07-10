package com.audio.electric.controller;

import com.audio.electric.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/5 0005 13:33
 */
@Controller
@RequestMapping("/role_menu")
public class RoleMenuController extends BaseController{
    @Autowired
    private IRoleMenuService iRoleMenuService;

    @ResponseBody
    @RequestMapping("/givePrivilege")
    public Object givePrivilege(Integer role_id, String menuNo){
        return iRoleMenuService.givePrivilege(role_id,menuNo);
    }


    @ResponseBody
    @RequestMapping("/cancelPrivilege")
    public Object cancelPrivilege(Integer role_id , String menuNo){
        return iRoleMenuService.cancelPrivilege(role_id,menuNo);
    }
}
