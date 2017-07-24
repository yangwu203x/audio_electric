package com.audio.electric.controller;

import com.audio.electric.service.ISearchService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 搜索控制类
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:01
 */
@RestController
@RequestMapping("/search")
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
    @GetMapping(value="/searchAttentionUser")
    @ResponseBody
    public String searchAttentionUser(String keyword){
        List<Map> data = searchService.searchAttentionUser(keyword);
        return BodyUtil.sucess(data, DataType.Array).toString();
    }

    /**
     * 查找朋友
     * 模糊查询
     * 分页
     * @param keyword
     * @return
     */
    @GetMapping("/searchFriends")
    @ResponseBody
    public String searchFriends(String keyword){
        List<Map> data = searchService.searchFriends(keyword);
        return BodyUtil.sucess(data, DataType.Array).toString();
    }

    /**
     * 搜索动态
     * 模糊查询
     * @param keyword 作品名或者作者昵称或备注来搜索动态
     * @return
     */
    @GetMapping("/searchDynamic")
    @ResponseBody
    public String searchDynamic(String keyword){
        List<Map> data = searchService.searchDynamic(keyword);
        return BodyUtil.sucess(data, DataType.Array).toString();
    }


    /**
     * 搜索歌曲（模糊查询）
     * 分页
     * @return
     */
    @PostMapping(value = "/searchSong")
    @ResponseBody
    public String searchSong(String keyword, HttpServletResponse response){
        List<Map> data = searchService.searchSong(keyword);
        return BodyUtil.sucess(data,DataType.Array).toString();
    }


    /**
     * 搜索歌曲名，歌星名，首字母
     * @return
     */
    @RequestMapping("/searchByKeyWord")
    public Object searchByKeyWord(String keyWord){
        //TODO
        List<Map> data = searchService.searchByKeyWord(keyWord);
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
