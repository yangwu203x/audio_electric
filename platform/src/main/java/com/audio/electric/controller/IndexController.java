package com.audio.electric.controller;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.Menu;
import com.audio.electric.service.IDictService;
import com.audio.electric.service.IMenuService;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.tool.CheckUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 16:17
 */
@Controller
public class IndexController extends BaseController{
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IDictService dictService;

    @RequestMapping("/")
    public String login1() {
        Account account = CheckUserLogin.getloginuser();
        if (account == null){
            return "login";
        }else{
            return "redirect:/index";
        }
    }

    @RequestMapping("/login")
    public String login() {
        Account account = CheckUserLogin.getloginuser();
        if (account == null){
            return "login";
        }else{
            return "redirect:/index";
        }
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model){
        Account account = CheckUserLogin.getloginuser();
        if (account == null){
            return "/login";
        }else{
            if (Constant.ADMINISTRATOR.equals(account.getUsername())){
                //系统管理员
                List<Menu> menuList = menuService.obtainAllMenu();
                model.addAttribute("menuList", menuList);
            }else{
                //普通用户
                List<Menu> menuList = menuService.listMenuByAccount(account);
                model.addAttribute("menuList", menuList);
            }
            List<EnumType> dictList = dictService.listEnumType(new EnumType());
            List<Menu> enumList = new ArrayList<>();
            for (EnumType enumType : dictList){
                Menu menu = new Menu();
                menu.setName(enumType.getName());
                menu.setUrl("/enum/listEnumValue?enumTypeId="+enumType.getId()+"&title="+enumType.getName());
                enumList.add(menu);
            }
            Menu menu = new Menu();
            menu.setName("字典类型查询");
            menu.setUrl("/enum/listEnumTypeByPage");
            enumList.add(menu);
            model.addAttribute("enumList",enumList);
            return "index";
        }
    }
}
