package com.audio.electric.controller;

import com.audio.electric.domain.FeedBack;
import com.audio.electric.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/4 0004 19:15
 */
@Controller
@RequestMapping("/feedBack")
public class FeedBackController extends BaseController {

    @Autowired
    private IFeedBackService feedBackService;

    public String listFeedBack(FeedBack feedBack){
        List<FeedBack> feedBackList = feedBackService.listFeedBack(feedBack);
        return "feedBack_list";
    }
}
