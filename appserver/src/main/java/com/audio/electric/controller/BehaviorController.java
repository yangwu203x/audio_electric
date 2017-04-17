package com.audio.electric.controller;

import com.audio.electric.service.IBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户行为控制类
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:15
 */
@RestController("/behavior")
public class BehaviorController {
    @Autowired
    private IBehaviorService behaviorService;

    //=======================================对人的操作==================================================
    /**
     * 关注或取消关注
     * @param user_id 用户id
     * @param type 0:取消关注，1：关注
     * @return
     */
    @GetMapping("/attention")
    @ResponseBody
    public String attention(String user_id,String type){
        //TODO
        return null;
    }

    //=======================================对作品的操作==================================================
    /**
     * 点赞或取消点赞
     * @param portfolio_id 作品id
     * @param type 0:取消点赞，1：点赞
     * @return
     */
    @GetMapping("/goods")
    @ResponseBody
    public String goods(String portfolio_id,String type){
        //TODO
        return null;
    }

    /**
     * 收藏或取消收藏
     * @param portfolio_id 作品id
     * @param type 0:取消收藏，1：收藏
     * @return
     */
    @GetMapping("/collection")
    @ResponseBody
    public String collection(String portfolio_id,String type){
        //TODO
        return null;
    }

    /**
     * 送礼
     * @param portfolio_id 作品id
     * @param type 礼物类型
     * @return
     */
    @GetMapping("/sendGift")
    @ResponseBody
    public String sendGift(String portfolio_id,String type){
        //TODO
        return null;
    }

    //=======================================对歌曲的操作==================================================

}
