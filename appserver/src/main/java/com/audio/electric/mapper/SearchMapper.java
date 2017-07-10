package com.audio.electric.mapper;

import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.EnumValue;
import com.audio.electric.domain.SongResponse;
import com.audio.electric.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:02
 */
@Component
public interface SearchMapper {

    /**
     * 条件搜索关注的人
     * @param user
     * @return
     * @throws SQLException
     */
    List<Map> searchAttentionUser(User user)throws SQLException;

    /**
     * 条件搜索朋友
     * @param user
     * @return
     */
    List<Map> searchFriends(User user)throws SQLException;

    /**
     * 条件搜索动态
     * @param map
     * @return
     */
    List<Map> searchDynamic(Map<String, String> map)throws SQLException;

    /**
     * 条件搜索歌曲
     * @param map
     * @return
     */
    List<Map> searchSong(Map<String, String> map)throws SQLException;

    List<Map> getSongType(String date);

    List<SongResponse> getSong(@Param("date")String date);

    List<Integer> getClassicSong(@Param("date")String date);

    List<Integer> getHotSong(@Param("date")String date);

    List<Integer> getChildSong(@Param("date") String date,@Param("enumValueId") Integer enumValueId);

    List<EnumValue> getSongTheme(@Param("songtheme")String songtheme);
}
