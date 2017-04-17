package com.audio.electric.controller;

import com.audio.electric.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangwu on 2017/3/31 0031.
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String say(){
        return "hello World" + 123;
    }

}
