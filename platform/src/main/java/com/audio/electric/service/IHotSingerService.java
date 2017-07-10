package com.audio.electric.service;

import com.audio.electric.domain.HotSinger;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/10 0010 11:37
 */
public interface IHotSingerService {

    List<HotSinger> listHotSinger();

    int saveHotSinger(HotSinger hotSinger);

    int editHotSinger(HotSinger hotSinger);

    int deleteHotSinger(String ids);

    HotSinger getHotSingerById(HotSinger hotSinger);
}
