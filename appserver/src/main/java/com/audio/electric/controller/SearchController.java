package com.audio.electric.controller;

import com.audio.electric.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搜索控制类
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:01
 */
@RestController("/search")
public class SearchController {
    @Autowired
    private ISearchService searchService;


    /**
     * 搜索已关注用户
     * 模糊查询
     * 分页
     * @param keyword
     * @return
     */
    @PostMapping("/searchAttentionUser")
    @ResponseBody
    public String searchAttentionUser(String keyword){
        //TODO
        return null;
    }

    /**
     * 查找朋友
     * 模糊查询
     * 分页
     * @param keyword
     * @return
     */
    @PostMapping("/searchFriends")
    @ResponseBody
    public String searchFriends(String keyword){
        //TODO
        return null;
    }

    /**
     * 搜索动态
     * 模糊查询
     * @param keyword 作品名或者作者昵称或备注来搜索动态
     * @return
     */
    @PostMapping("/searchDynamic")
    @ResponseBody
    public String searchDynamic(String keyword){
        //TODO
        return null;
    }


    /**
     * 搜索歌曲（模糊查询）
     * 分页
     * @return
     */
    @PostMapping("/searchSong")
    @ResponseBody
    public String searchSong(String keyword){
        //TODO
        return null;
    }

    /**
     * 搜索聊天信息
     * @return
     */
    public String searchChat(){
        //TODO
        return null;
    }
}
