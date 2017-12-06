package com.audio.electric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/12 0012 9:40
 */
@Controller
public class UeditorController {

    @RequestMapping("/toUeditorPage")
    public String toUeditorPage(){
        return "information/index";
    }
}
