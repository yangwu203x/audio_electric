package com.audio.electric.service.impl;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.domain.User;
import com.audio.electric.mapper.SearchMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.ISearchService;
import com.audio.electric.util.annotation.UserPage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.tool.CheckUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:03
 */
@Component
public class SearchServiceImpl extends BaseService implements ISearchService{
    @Autowired
    private SearchMapper searchMapper;

    @UserPage
    @Override
    public List<Map> searchAttentionUser(String keyword) {
        CookieUser cookieUser = CheckUserLogin.getloginuser();
        if (cookieUser == null)
            throw new AppException(RetCode.UNLOGINED);
        try {
            User user = new User();
            user.setId(cookieUser.getId());
            user.setUsername(keyword);
            user.setNickname(keyword);
            user.setName(keyword);
            return searchMapper.searchAttentionUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @UserPage
    @Override
    public List<Map> searchFriends(String keyword) {
        CookieUser cookieUser = CheckUserLogin.getloginuser();
        if (cookieUser == null)
            throw new AppException(RetCode.UNLOGINED);
        try {
            User user = new User();
            user.setId(cookieUser.getId());
            user.setUsername(keyword);
            user.setNickname(keyword);
            user.setName(keyword);
            List<Map> list = searchMapper.searchFriends(user);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @UserPage
    @Override
    public List<Map> searchDynamic(String keyword) {
        CookieUser cookieUser = CheckUserLogin.getloginuser();
        if (cookieUser == null)
            throw new AppException(RetCode.UNLOGINED);
        try {
            //作品名或者作者昵称或备注来搜索动态
            Map<String ,String > map = new HashMap<>();
            map.put("user_id",cookieUser.getUserId().toString());
            map.put("keyword",keyword);
            return searchMapper.searchDynamic(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @UserPage
    @Override
    public List<Map> searchSong(String keyword) {
        CookieUser cookieUser = CheckUserLogin.getloginuser();
        if (cookieUser == null)
            throw new AppException(RetCode.UNLOGINED);
        try {
            //歌曲名或歌手名来搜索歌曲
            Map<String ,String > map = new HashMap<>();
            map.put("singerName",cookieUser.getUserId().toString());
            map.put("keyword",keyword);
            return searchMapper.searchSong(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map> searchByKeyWord(String keyWord) {
        //歌星
        List<Map> dataSinger = searchMapper.searchSingerByKeyWord(keyWord);
        //歌曲
        List<Map> dataSong = searchMapper.searchSongByKeyWord(keyWord);
        return null;
    }


}
