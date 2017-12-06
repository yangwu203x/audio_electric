package com.enter.controller;

import com.enter.entity.User;
import com.enter.service.IAccountService;
import com.enter.util.CheckUserLogin;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/16 0016 17:55
 */
@Controller
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/logout")
    public String logout(){
        accountService.logout();
        return "redirect:/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(String email,String password){
        User user = accountService.login(email,password);
        String retUrl= CheckUserLogin.getRefenceUrl();
        return BodyUtil.success(null, DataType.Object,retUrl);
    }

    @GetMapping("/checkValidCode")
    @ResponseBody
    public Object checkValidCode(String email,String validCode,String type){
        accountService.checkValidCode(email,validCode,type);
        return BodyUtil.success();
    }

    @GetMapping("/validCode/email")
    @ResponseBody
    public Object sendValidCode(String email,String type){
        accountService.sendValidCode(email,type);
        return BodyUtil.success();
    }

    @GetMapping("/validCode/message/{tel}")
    @ResponseBody
    public Object sendDxCode(@PathVariable("tel")String tel){
        //TODO  发送短信
        accountService.sendDxCode(tel);
        return BodyUtil.success();
    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(User user){
        accountService.doReg(user);
        return BodyUtil.success(null,DataType.Object,"/");
    }

    @PostMapping("/changePwd")
    @ResponseBody
    public Object changePwd(User user){
        accountService.changePwd(user);
        return BodyUtil.success(null,DataType.Object,"/login");
    }

}
