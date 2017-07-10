package com.audio.electric.mapper;

import com.audio.electric.domain.Gift;
import com.audio.electric.domain.MyGift;
import com.audio.electric.domain.Portfolio;
import com.audio.electric.domain.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 15:37
 */
@Component
public interface CommonMapper {

    /**
     * 所有评论过的作品id
     * @param user_id
     * @return
     */
//    @Select("select distinct portfolio_id as portfolioId from comments where user_id = #{user_id}")
    Set<Long> getCommentsById(Long user_id) throws SQLException;

    /**
     * 所有关注的人的id
     * @param user_id
     * @return
     */
//    @Select("select be_user_id as beUserId from attention where user_id = #{user_id}")
    Set<Long> getAttentionById(Long user_id) throws SQLException;

    /**
     * 所有送过礼物的作品id
     * @param user_id
     * @return
     */
//    @Select("select distinct portfolio_id as portfolioId from gift_giving where user_id = #{user_id}")
    Set<Long> getGiftGivingById(Long user_id) throws SQLException;

    /**
     * 所有点赞过的作品id
     * @param user_id
     * @return
     */
//    @Select("select portfolio_id as portfolioId from goods where user_id = #{user_id}")
    Set<Long> getGoodsById(Long user_id) throws SQLException;

    /**
     * 所有收藏过的作品id
     * @param user_id
     * @return
     */
//    @Select("select portfolio_id as portfolioId from collection where user_id = #{user_id}")
    Set<Long> getCollectionsById(Long user_id) throws SQLException;

    /**
     * 所有收藏过的歌曲id
     * @param user_id
     * @return
     */
//    @Select("select song_id as songId from song_collections where user_id = #{user_id}")
    Set<Long> getSongCollectionsById(Long user_id) throws SQLException;

//    @Select("select id from user where id = #{_paramter}")
    User getUserById(String user_id)throws SQLException;

//    @Select("select id from portfolio where id = #{_paramter}")
    Portfolio getPortfolioById(String portfolio_id)throws SQLException;

//    @Select("select id from gift where id = #{_paramter}")
    Gift getGiftById(String gift_id)throws SQLException;

//    @Select("select sum(amount) as amount,gift_id as giftId,user_id as userId from mygift where user_id=#{userId} and gift_id=#{giftId}")
    MyGift getMyGiftAmount(MyGift myGift)throws SQLException;
}
