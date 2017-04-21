package com.audio.electric.controller;

import com.audio.electric.domain.User;
import com.audio.electric.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/21 0021 15:09
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/listUser")
    @ResponseBody
    public List<User> listUser(){
        List<User> userList = userService.listUser();
        for (User user : userList)
            System.out.println(user);
        return userList;
    }

    
}
