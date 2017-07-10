package com.audio.electric.mapper;

import com.audio.electric.domain.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:18
 */
@Component
public interface BehaviorMapper {
    //关注
//    @Insert("insert into attention (user_id,be_user_id,modify_date) values (#{userId},#{beUserId},#{createDate})")
    int attention(Attention attention)throws SQLException;
    //取消关注
//    @Delete("delete from attention where user_id = #{userId} and be_user_id = #{beUserId}")
    int canceAttention(Attention attention)throws SQLException;
    //点赞
//    @Insert("insert into goods(user_id,portfolio_id,modify_date) values (#{userId},#{portfolioId},#{createDate})")
    int goods(Goods goods)throws SQLException;
    //取消点赞
//    @Delete("delete from goods where user_id = #{userId} and portfolio_id = #{portfolioId}")
    int canceGoods(Goods goods)throws SQLException;
    //收藏
//    @Insert("insert into collection(user_id,portfolio_id,modify_date) values (#{userId},#{portfolioId},#{createDate})")
    int collection(Collections collections)throws SQLException;
    //取消收藏
//    @Delete("delete from collection where user_id = #{userId} and portfolio_id = #{portfolioId}")
    int canceCollection(Collections collections)throws SQLException;
    //送礼
//    @Insert("insert into gift_giving (user_id,gift_id,portfolio_id,amount,create_date) values (#{userId},#{giftId},#{portfolioId},#{amount},#{createDate})")
    int givingGift(GiftGiving giftGiving)throws SQLException;
    //送礼扣除/或充值
//    @Insert("insert into mygift(gift_id,amount,user_id,create_date) values (#{giftId},#{amount},#{userId},#{createDate})")
    int deductMyGift(MyGift myGift)throws SQLException;

    int saveSongLack(SongLack songLack)throws SQLException;

    int saveFeedback(FeedBack feedBack)throws SQLException;

    int comments(PortfolioComments portfolioComments)throws SQLException;

    int shield(Shield shield)throws SQLException;
}
