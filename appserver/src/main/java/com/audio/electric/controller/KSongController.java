package com.audio.electric.controller;

import com.audio.electric.service.IKSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * k歌
 * @Author leo_Yang【音特】
 * @Date 2017/6/28 0028 9:23
 */
@RestController
@RequestMapping("/ksong")
public class KSongController {

    @Autowired
    private IKSongService kSongService;
    /**
     * 首页
     */
    @RequestMapping("/getIndex")
    public Object getIndex(){

        return null;
    }

    /**
     * 歌星点歌
     * @return
     */
    @RequestMapping("/kBySinger")
    public Object kBySinger(String singerName){
        return kSongService.kBySinger(singerName);
    }
}
