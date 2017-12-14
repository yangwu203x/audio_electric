package com.enter;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/9/8 0008 15:43
 */
@Path("/")
public class TestController {
    @Get("hello")
    public String test(){
        return "@a";
    }
}
