package com.enter.controller;

import com.enter.entity.User;
import com.enter.service.IAccountService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/16 0016 17:55
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/logout")
    public String logout(){
        accountService.logout();
        return "redirect:/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String email,String password){
        return accountService.login(email,password).toString();
    }

    @RequestMapping("/checkValidCode")
    @ResponseBody
    public String checkValidCode(String email,String validCode){
        return accountService.checkValidCode(email,validCode).toString();
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(User user){
        return accountService.doReg(user).toString();
    }

    @RequestMapping("/sendValidCode")
    @ResponseBody
    public String sendValidCode(User user){
        return accountService.sendValidCode(user).toString();
    }
}
