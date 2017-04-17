package com.audio.electric.mapper;

import org.apache.ibatis.annotations.Select;
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
    @Select("select distinct portfolio_id from comments where user_id = #{user_id}")
    public Set getCommentsById(Long user_id) throws SQLException;

    /**
     * 所有关注的人的id
     * @param user_id
     * @return
     */
    @Select("select portfolio_id from attention where user_id = #{user_id}")
    public Set getAttentionById(Long user_id) throws SQLException;

    /**
     * 所有送过礼物的作品id
     * @param user_id
     * @return
     */
    @Select("select distinct portfolio_id from gift_giving where user_id = #{user_id}")
    public Set getGiftById(Long user_id) throws SQLException;

    /**
     * 所有点赞过的作品id
     * @param user_id
     * @return
     */
    @Select("select portfolio_id from goods where user_id = #{user_id}")
    public Set<Integer> getGoodsById(Long user_id) throws SQLException;

    /**
     * 所有收藏过的作品id
     * @param user_id
     * @return
     */
    @Select("select portfolio_id from collection where user_id = #{user_id}")
    public Set<Integer> getCollectionsById(Long user_id) throws SQLException;
}
