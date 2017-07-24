package com.audio.electric.controller;

import Ice.InitializationData;
import com.audio.electric.service.MessageService;
import com.audio.electric.service.impl.MessageServiceImpl;
import com.audio.electric.util.ApplicationContextUtil;
import general.Message;
import ice.client.Client2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/20 0020 19:01
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/chat")
    public String hello(String srcUserId){
        if(srcUserId == null)
            return "mistakeparameter";
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Client2.main(new String[]{srcUserId});
            }
        });
        t.start();

        return "hello world";
    }
}
