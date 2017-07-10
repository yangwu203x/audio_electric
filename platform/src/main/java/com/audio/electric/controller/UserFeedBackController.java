package com.audio.electric.controller;

import com.audio.electric.domain.UserFeedback;
import com.audio.electric.service.IUserFeedBackService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/12 0012 15:05
 */
@Controller
@RequestMapping("/user_feedback")
public class UserFeedBackController {
    @Autowired
    private IUserFeedBackService userFeedBackService;

    @RequestMapping("/listUserFeedBack")
    public String listLog(UserFeedback userFeedBack, Model model){
        List<UserFeedback> userFeedBackList = userFeedBackService.listUserFeedBack(userFeedBack);
        PageInfo pagehelper = new PageInfo(userFeedBackList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("userFeedBackList",userFeedBackList);
        return "user_feedback/user_feedback_list";
    }
}
