package com.enter.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/9/8 0008 15:48
 */

@Path("/hello/")
public class HelloController {

    @Get("world")
    public String index() {
        return "@hello world";
    }
}
