package com.audio.electric.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/28 0028 9:44
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    /**
     * 获取所有上传的录音
     * @return
     */
    @RequestMapping("/getRecords")
    public Object listRecord(){

        return null;
    }

    /**
     * 发布录音
     * @return
     */
    @RequestMapping("/putRecord")
    public Object releaseRecord(){

        return null;
    }

    /**
     * 删除录音
     * @return
     */
    @RequestMapping("/deleteRecord")
    public Object deleteRecord(@RequestParam MultipartFile recordFile){

        return null;
    }
}
