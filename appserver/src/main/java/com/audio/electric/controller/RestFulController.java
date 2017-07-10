package com.audio.electric.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/31 0031 15:51
 */
@RestController
@RequestMapping("/restful")
public class RestFulController {

    @GetMapping("/get")
    public String getResource(){
        return "getting";
    }

    @PostMapping("/post")
    public String postResource(){
        return "post";
    }

    @PutMapping("/put")
    public String putResource(){
        return "putting";
    }

    @DeleteMapping("/delete")
    public String delResource(){
        return "delete";
    }


}
