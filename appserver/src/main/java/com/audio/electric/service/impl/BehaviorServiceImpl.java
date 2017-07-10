package com.audio.electric.service.impl;

import com.audio.electric.domain.*;
import com.audio.electric.mapper.BehaviorMapper;
import com.audio.electric.mapper.CommonMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IBehaviorService;
import com.audio.electric.util.annotation.Remind;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.tool.CheckUserLogin;
import com.audio.electric.util.tool.DateStyle;
import com.audio.electric.util.tool.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:17
 */
@Component
public class BehaviorServiceImpl extends BaseService implements IBehaviorService {

    @Autowired
    private BehaviorMapper behaviorMapper;
    @Autowired
    private CommonMapper commonMapper;

    @Remind
    @Override
    public int attention(String be_user_id,String type) {
        try {
            User user = commonMapper.getUserById(be_user_id);
            if (user == null)
                throw new AppException(RetCode.USERNOTEXIST);
            //判断是否登录
            CookieUser cookieUser = CheckUserLogin.getloginuser();
            if (cookieUser == null)
                throw new AppException(RetCode.UNLOGINED);
            String dateStr = DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
            Attention attention = new Attention();
            attention.setBeUserId(user.getId());
            attention.setUserId(cookieUser.getUserId());
            attention.setCreateDate(dateStr);
            Set<Long> set = commonMapper.getAttentionById(cookieUser.getId());
            if ("1".equals(type)){
                if(set.contains(attention.getBeUserId()))
                    throw new AppException(RetCode.ATTENDTIONALREADY);
                //关注
                return behaviorMapper.attention(attention);
            }else if("0".equals(type)){
                if(!set.contains(attention.getBeUserId()))
                    throw new AppException(RetCode.ATTENDTIONNOT);
                //取消关注
                return behaviorMapper.canceAttention(attention);
            }else{
                throw new AppException(RetCode.PARAMETER_ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Remind
    @Override
    public int goods(String type,String portfolio_id){
        try {
            Portfolio portfolio = commonMapper.getPortfolioById(portfolio_id);
            if (portfolio == null)
                throw new AppException(RetCode.PORTFOLIIONOTEXIST);
            //判断是否登录
            CookieUser cookieUser = CheckUserLogin.getloginuser();
            if (cookieUser == null)
                throw new AppException(RetCode.UNLOGINED);
            String dateStr = DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
            Goods goods = new Goods();
            goods.setPortfolioId(portfolio.getId());
            goods.setCreateDate(dateStr);
            goods.setUserId(cookieUser.getUserId());
            Set<Long> set = commonMapper.getGoodsById(cookieUser.getId());
            if ("1".equals(type)){
                logger.info(goods.getPortfolioId() + "" + portfolio_id);
                //点赞
                if(set.contains(goods.getPortfolioId()))
                    throw new AppException(RetCode.GOODSALREADY);
                return behaviorMapper.goods(goods);
            }else if("0".equals(type)){
                if(!set.contains(goods.getPortfolioId()))
                    throw new AppException(RetCode.GOODSNOT);
                //取消点赞
                return behaviorMapper.canceGoods(goods);
            }else{
                throw new AppException(RetCode.PARAMETER_ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Remind
    @Override
    public int collection(String type, String portfolio_id) {
        try {
            Portfolio portfolio = commonMapper.getPortfolioById(portfolio_id);
            if (portfolio == null)
                throw new AppException(RetCode.PORTFOLIIONOTEXIST);
            //判断是否登录
            CookieUser cookieUser = CheckUserLogin.getloginuser();
            if (cookieUser == null) {
                throw new AppException(RetCode.UNLOGINED);
            }
            String dateStr = DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
            Collections collections = new Collections();
            collections.setUserId(cookieUser.getUserId());
            collections.setCreateDate(dateStr);
            collections.setPortfolioId(portfolio.getId());
            Set<Long> set = commonMapper.getCollectionsById(cookieUser.getId());
            if ("1".equals(type)){
                if(!set.contains(collections.getPortfolioId()))
                    throw new AppException(RetCode.COLLECTIONALREADY);
                //收藏
                return behaviorMapper.collection(collections);
            }else if("0".equals(type)){
                if(!set.contains(collections.getPortfolioId()))
                    throw new AppException(RetCode.COLLECTIONNOT);
                //取消收藏
                return behaviorMapper.canceCollection(collections);
            }else{
                throw new AppException(RetCode.PARAMETER_ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Remind
    @Override
    public int givingGift(String portfolio_id,String gift_id,int amount) {
        int result = RetCode.FAILED.getCode();
        try {
            Portfolio portfolio = commonMapper.getPortfolioById(portfolio_id);
            if (portfolio == null)
                throw new AppException(RetCode.PORTFOLIIONOTEXIST);
            //判断是否登录
            CookieUser cookieUser = CheckUserLogin.getloginuser();
            if (cookieUser == null) {
                throw new AppException(RetCode.UNLOGINED);
            }
            Gift gift = commonMapper.getGiftById(gift_id);
            if(gift == null)
                throw new AppException(RetCode.GIFTNOTENOUGH);
            //判断是否有足够的礼物
            MyGift myGift = new MyGift();
            myGift.setGiftId(gift.getId());
            myGift.setUserId(cookieUser.getUserId());
            myGift.setAmount(amount);
            myGift = commonMapper.getMyGiftAmount(myGift);
            if (myGift == null || myGift.getAmount() < amount)
                throw new AppException(RetCode.GIFTNOTENOUGH);
            else
                myGift.setAmount(0-amount);//设置为负数
            String dateStr = DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
            GiftGiving giftGiving = new GiftGiving();
            giftGiving.setUserId(cookieUser.getUserId());
            giftGiving.setCreateDate(dateStr);
            giftGiving.setPortfolioId(portfolio.getId());
            giftGiving.setGiftId(gift.getId());
            giftGiving.setAmount(amount);
            //送礼
             result = behaviorMapper.givingGift(giftGiving);
             if(result > 0)
                 //扣除礼物
                result = behaviorMapper.deductMyGift(myGift);
      } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int saveSongLack(SongLack songLack) {
        try {
            songLack.setUserId("1");
            return behaviorMapper.saveSongLack(songLack);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int saveFeedback(FeedBack feedBack) {
        try {
            feedBack.setUserId(1);
            return behaviorMapper.saveFeedback(feedBack);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int comments(PortfolioComments portfolioComments) {
        try {
            CookieUser cookieUser = CheckUserLogin.getloginuser();
            if (cookieUser == null) {
                throw new AppException(RetCode.UNLOGINED);
            }
            portfolioComments.setUserId(cookieUser.getId());
            return behaviorMapper.comments(portfolioComments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int shield(Shield shield) {
        try {
            CookieUser cookieUser = CheckUserLogin.getloginuser();
            if (cookieUser == null) {
                throw new AppException(RetCode.UNLOGINED);
            }
            shield.setUserId(cookieUser.getId());
            return behaviorMapper.shield(shield);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    /**
     * 检查参数
     * @param user_id
     * @param type
     * @throws SQLException
     */
    private void checkParamter(String user_id,String type) throws SQLException {

    }
}
