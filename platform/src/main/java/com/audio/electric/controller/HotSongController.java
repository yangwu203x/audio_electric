package com.audio.electric.controller;

import com.audio.electric.domain.HotSong;
import com.audio.electric.service.IHotSongService;
import com.audio.electric.util.protocol.BodyUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/10 0010 11:12
 */
@Controller
@RequestMapping("/hot_song")
public class HotSongController extends BaseController{
    @Autowired
    private IHotSongService hotSongService;

    /**
     * 显示歌曲信息列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/listHotSong")
    public String listHotSong(Model model) {
        List<HotSong> hotSongList = hotSongService.listHotSong();
        PageInfo pagehelper = new PageInfo(hotSongList);
        model.addAttribute("pagehelper",pagehelper);
        // 添加模型数据
        model.addAttribute("hotSongList", hotSongList);
        return "hot_song/hot_song_list";
    }

    /**
     * 跳到增加或修改热门歌曲信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/showHotSongEdit")
    public String showHotSongEdit(String operateType ,Model model ,HotSong hotSong) throws Exception {
        String viewName = "hot_song/hot_song_edit";
        // 如果请求是前往编辑歌曲页面
        if (("2").equals(operateType)) {
            // 执行数据库操作
            hotSong = hotSongService.getHotSongById(hotSong);
            model.addAttribute("hotSong", hotSong);
            model.addAttribute("edit","edit");
            model.addAttribute("requestUrl", "/hot_song/editHotSong");
        } else {
            model.addAttribute("requestUrl", "/hot_song/addHotSong");
        }
        // 设置视图
        return viewName;
    }

    @RequestMapping("/addHotSong")
    @ResponseBody
    public Object addHotSong(HotSong hotSong){
        int result = hotSongService.saveHotSong(hotSong);
        return BodyUtil.result(result);
    }

    @RequestMapping("/editHotSong")
    @ResponseBody
    public Object editHotSong(HotSong hotSong){
        int result = hotSongService.editHotSong(hotSong);
        return BodyUtil.result(result);
    }

    @RequestMapping("/deleteHotSong")
    @ResponseBody
    public Object deleteHotSong(String ids){
        int result = hotSongService.deleteHotSong(ids);
        return BodyUtil.result(result);
    }
}
