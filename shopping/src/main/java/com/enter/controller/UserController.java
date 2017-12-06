package com.enter.controller;

import com.enter.entity.User;
import com.enter.repository.UserRepository;
import com.enter.service.IBannerService;
import com.enter.service.IProductService;
import com.enter.service.IUserService;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 17:21
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserService userService;

    @GetMapping("/overView")
    public String accountInfo(Model model){
        User user = userService.accountInfo();
        model.addAttribute("account",user);
        return "/account/account_info";
    }

    @PutMapping("/modify/email")
    @ResponseBody
    public Object modifyEmail(String email,String validCode){
        User user = userService.modifyEmail(email,validCode);
        return BodyUtil.success();
    }

    @PutMapping("/modifyPwd")
    @ResponseBody
    public Object modifyPwd(String oldPassword,String password){
        User user = userService.modifyPwd(oldPassword,password);
        return BodyUtil.success();
    }

    @PutMapping("/modify/userName")
    @ResponseBody
    public Object editUserName(String name){
            User user = userService.editUserName(name);
        return BodyUtil.success();
    }

    @PutMapping("/tel/modify/")
    @ResponseBody
    public Object modifyTel(String tel,String validCode){
        userService.modifyTel(tel,validCode);
        return BodyUtil.success();
    }
}
