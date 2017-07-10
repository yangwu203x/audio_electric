package com.audio.electric.controller;

import com.audio.electric.service.ISongService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/23 0023 17:04
 */
@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    //全部歌曲列表
    @GetMapping("/getSong")
    public Object getSong(){
        Map data = songService.getSong(null);
        return Tools.encode(BodyUtil.sucess(data, DataType.Object).toString());
    }

    @GetMapping("/updateSong")
    public Object updateSong(String date){
        Map data = songService.getSong(date);
        return Tools.encode(BodyUtil.sucess(data, DataType.Object).toString());
    }

    //
}
