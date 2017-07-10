package com.audio.electric.controller;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.ExportPrivilege;
import com.audio.electric.domain.Role;
import com.audio.electric.service.IRoleAccountService;
import com.audio.electric.service.IRoleService;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.protocol.BodyUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/26 0026 15:00
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
    @Autowired
    private IRoleService roleService;
    @Autowired
    IRoleAccountService roleAccountService;

    @GetMapping("/listRole")
    public String listRole(Role role, Model model){
        List<Role> roleList = roleService.listRole(role);
        PageInfo pagehelper = new PageInfo(roleList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("roleList",roleList);
        return "role/role_list";
    }

    @RequestMapping("/getAccountOfRole")
    @ResponseBody
    public Object getAccountOfRole(){
        return baseService.listAccountOfRole();
    }

    @RequestMapping("/roleToAccount")
    public String roleToAccount(String username, Integer role_id, Model model, String operateType){
        //设置视图
        String viewName = "role/role_to_account";
        List<Account> accountList;
        if("1".equals(operateType)){
            accountList = baseService.listAccountByRoledel(username,role_id);
            model.addAttribute("logo","<i class=\"Hui-iconfont\">&#xe6e2;</i> 批量删除");
        }else if("2".equals(operateType)){
            accountList = baseService.listAccountByRoleadd(username,role_id);
            model.addAttribute("logo","<i class=\"Hui-iconfont\">&#xe600;</i> 批量添加");
        }else {
            throw new PlatException(RetCode.PARAMETER_ERROR);
        }
        PageInfo pagehelper = new PageInfo(accountList);
        model.addAttribute("username",username);
        model.addAttribute("operateType",operateType);
        model.addAttribute("role_id",role_id);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("accountList",accountList);
        model.addAttribute("requestUrl","/role/addRoleToAccount");
        return viewName;
    }

    @ResponseBody
    @RequestMapping("/modifthAccountToRole")
    public Object modifthAccountToRole(String account_ids,Integer role_id,String operateType){
        int result;
        if ("2".equals(operateType)){
            //增加
            result = roleAccountService.addAccountToRole(account_ids,role_id);
        }else if ("1".equals(operateType)){
            //删除
            result = roleAccountService.delAccountToRole(account_ids,role_id);
        }else {
            throw new PlatException(RetCode.PARAMETER_ERROR);
        }
        return BodyUtil.result(result);
    }

    @RequestMapping("/showRole")
    public String showRole(Role role , Model model, String operateType){
        String viewName = "role/role_edit";
        //获取要访问的视图
        if(("1").equals(operateType)){
            //添加
            model.addAttribute("requestUrl","/role/addRole");
            return viewName;
        }else if(("2").equals(operateType)){
            //修改
            role = roleService.getRole(role);
            model.addAttribute("role",role);
            model.addAttribute("requestUrl","/role/modifyRole");
            return viewName;
        }
        //设置视图
        return "404";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public Object addRole(Role role){
        int result = roleService.addRole(role);
        return BodyUtil.result(result);
    }

    @RequestMapping("/modifyRole")
    @ResponseBody
    public Object modifyRole(Role role , HttpServletRequest request){
        int result = roleService.modifyRole(role);
        return BodyUtil.result(result);
    }

    @ResponseBody
    @RequestMapping("/deleteRole")
    public Object deleteRole(String ids){

        return BodyUtil.result(roleService.deleteRole(ids));
    }

    @RequestMapping("/toExportPwd")
    public String toExportPwd(){
        return "role/export_pwd_set";
    }

    @RequestMapping("/exportPwdSet")
    public Object exportPwdSet(ExportPrivilege exportPrivilege){
        return BodyUtil.result(0);
    }
}
