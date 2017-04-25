package com.audio.electric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 16:17
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
