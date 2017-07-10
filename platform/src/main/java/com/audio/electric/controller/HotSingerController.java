package com.audio.electric.controller;

import com.audio.electric.domain.HotSinger;
import com.audio.electric.service.IHotSingerService;
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
@RequestMapping("/hot_singer")
public class HotSingerController extends BaseController{
    @Autowired
    private IHotSingerService hotSingerService;

    /**
     * 显示歌曲信息列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/listHotSinger")
    public String listHotSinger(Model model){
        List<HotSinger> hotSingerList = hotSingerService.listHotSinger();
        PageInfo pagehelper = new PageInfo(hotSingerList);
        model.addAttribute("pagehelper",pagehelper);
        // 添加模型数据
        model.addAttribute("hotSingerList", hotSingerList);
        return "hot_singer/hot_singer_list";
    }

    /**
     * 跳到增加或修改热门歌曲信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/showHotSingerEdit")
    public String showHotSingerEdit(String operateType ,Model model ,HotSinger hotSinger) throws Exception {
        String viewName = "hot_singer/hot_singer_edit";
        // 如果请求是前往编辑歌曲页面
        if (("2").equals(operateType)) {
            // 执行数据库操作
            hotSinger = hotSingerService.getHotSingerById(hotSinger);
            model.addAttribute("hotSinger", hotSinger);
            model.addAttribute("edit","edit");
            model.addAttribute("requestUrl", "/hot_singer/editHotSinger");
        } else {
            model.addAttribute("requestUrl", "/hot_singer/addHotSinger");
        }
        // 设置视图
        return viewName;
    }

    @RequestMapping("/addHotSinger")
    @ResponseBody
    public Object addHotSinger(HotSinger hotSinger){
        int result = hotSingerService.saveHotSinger(hotSinger);
        return BodyUtil.result(result);
    }

    @RequestMapping("/editHotSinger")
    @ResponseBody
    public Object editHotSinger(HotSinger hotSinger){
        int result = hotSingerService.editHotSinger(hotSinger);
        return BodyUtil.result(result);
    }

    @RequestMapping("/deleteHotSinger")
    @ResponseBody
    public Object deleteHotSinger(String ids){
        int result = hotSingerService.deleteHotSinger(ids);
        return BodyUtil.result(result);
    }
}
