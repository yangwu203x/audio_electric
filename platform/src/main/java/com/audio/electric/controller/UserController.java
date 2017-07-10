package com.audio.electric.controller;

import com.audio.electric.domain.User;
import com.audio.electric.service.IUserService;
import com.audio.electric.util.protocol.BodyUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/21 0021 15:09
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping("/listUser")
    public String listUser(User user, Model model){
        List<User> userList = userService.listUser(user);
        PageInfo pagehelper = new PageInfo(userList);
        model.addAttribute("userList",userList);
        model.addAttribute("pagehelper",pagehelper);
        return "user/user_list";
    }

    /**
     * 跳到增加或修改热门歌曲信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/showUserEdit")
    public String showUserEdit(String operateType ,Model model ,User user) throws Exception {
        String viewName = "user/user_edit";
        // 如果请求是前往编辑歌曲页面
        if (("2").equals(operateType)) {
            // 执行数据库操作
            user = userService.getUserById(user);
            model.addAttribute("user", user);
            model.addAttribute("edit","edit");
            model.addAttribute("requestUrl", "/user/editUser");
        } else {
            model.addAttribute("requestUrl", "/user/addUser");
        }
        // 设置视图
        return viewName;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Object addUser(User user){
        int result = userService.saveUser(user);
        return BodyUtil.result(result);
    }

    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(User user){
        int result = userService.editUser(user);
        return BodyUtil.result(result);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Object deleteUser(String ids){
        int result = userService.deleteUser(ids);
        return BodyUtil.result(result);
    }

    @RequestMapping("/autoSearch")
    @ResponseBody
    public Object autoSearch(User user){
        List<String> autoString = userService.autoSearch(user);
        return autoString;
    }
    
}
