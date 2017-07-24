package com.audio.electric.controller;

import com.audio.electric.domain.FeedBack;
import com.audio.electric.domain.PortfolioComments;
import com.audio.electric.domain.Shield;
import com.audio.electric.domain.SongLack;
import com.audio.electric.service.IBehaviorService;
import com.audio.electric.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户行为控制类
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:15
 */
@RestController
@RequestMapping("/behavior")
public class BehaviorController {
    @Autowired
    private IBehaviorService behaviorService;

    //=======================================对人的操作==================================================
    /**
     * 关注或取消关注
     * @param be_user_id 用户id
     * @param type 0:取消关注，1：关注
     * @return
     */
    @GetMapping("/attention")
    public String attention(String be_user_id,String type){
        int result = behaviorService.attention(be_user_id,type);
        return BodyUtil.result(result).toString();
    }

    //=======================================对作品的操作==================================================
    /**
     * 点赞或取消点赞
     * @param portfolio_id 作品id
     * @param type 0:取消点赞，1：点赞
     * @return
     */
    @GetMapping("/goods")
    public String goods(String portfolio_id,String type){
        int result = behaviorService.goods(type,portfolio_id);
        return BodyUtil.result(result).toString();
    }
    /**
     * 收藏或取消收藏
     * @param portfolio_id 作品id
     * @param type 0:取消收藏，1：收藏
     * @return
     */
    @GetMapping("/collection")
    public String collection(String portfolio_id,String type){
        int result = behaviorService.collection(type,portfolio_id);
        return BodyUtil.result(result).toString();
    }

    /**
     * 作品评论
     * @param portfolioComments 评论内容
     * @param be_user_id 评论对象id
     * @return
     */
    public Object comment(PortfolioComments portfolioComments,String be_user_id){
        int result = behaviorService.comments(portfolioComments);
        return BodyUtil.result(result);
    }

    public Object shield(Shield shield){
        int result = behaviorService.shield(shield);
        return BodyUtil.result(result);
    }

    /**
     * 送礼
     * @param portfolio_id 作品id
     * @param gift_id 礼物类型
     * @param amount 礼物数量
     * @return
     */
    @GetMapping("/sendGift")
    public String sendGift(String portfolio_id,String gift_id,int amount){
        int result = behaviorService.givingGift(portfolio_id,gift_id,amount);
        return BodyUtil.result(result).toString();
    }

    /**
     * 缺歌反馈
     */
    @PostMapping("/songLack")
    public Object songLack(SongLack songLack){
        int result = behaviorService.saveSongLack(songLack);
        return BodyUtil.result(result).toString();
    }


    @PostMapping("/feedBack")
    public Object feedBack(FeedBack feedBack){
        int result = behaviorService.saveFeedback(feedBack);
        return  BodyUtil.result(result).toString();
    }

    //=======================================对歌曲的操作==================================================

}
