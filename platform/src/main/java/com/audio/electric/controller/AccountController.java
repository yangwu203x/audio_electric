package com.audio.electric.controller;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.Menu;
import com.audio.electric.service.IAccountService;
import com.audio.electric.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 10:26
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IMenuService menuService;

    @PostMapping("/login")
    public String login(Account account ,String authCode, Model model){
        //TODO 加上验证码
        account = accountService.login(account ,authCode);
        if (account != null) {

            List<Menu> menuList = menuService.obtainAllMenu();
            model.addAttribute("menuList", menuList);
            return "index";
        }else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        accountService.logout();
        return "login";
    }
}
