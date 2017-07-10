package com.audio.electric.service;

import com.audio.electric.domain.Singer;

import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/3 0003 10:12
 */
public interface ISingerService {

    List<Singer> listSinger(Singer singer);

    Singer getSinger(Singer singer);

    int addSinger(Singer singer);

    int updateSinger(Singer singer);

    int deleteSinger(String ids);

    int updateStatus(Singer singer);

    List<String> autoSearch(Singer singer);

    List<Map<String,String>> findIdByName(Singer singer);

    List<Map<String,String>> findIdById(String ids);
}
