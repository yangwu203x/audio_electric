package com.audio.electric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/21 0021 16:02
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }

    @RequestMapping("/product")
    public String product(){
        return "product-brand";
    }
}
