package com.audio.electric.service;

import com.audio.electric.util.annotation.UserPage;

import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:03
 */
public interface ISearchService {

    @UserPage
    List<Map> searchAttentionUser(String keyword);

    List<Map> searchFriends(String keyword);

    List<Map> searchDynamic(String keyword);

    List<Map> searchSong(String keyword);

}
