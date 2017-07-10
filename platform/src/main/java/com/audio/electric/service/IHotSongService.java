package com.audio.electric.service;

import com.audio.electric.domain.HotSong;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/10 0010 11:13
 */
public interface IHotSongService {
    List<HotSong> listHotSong();

    int saveHotSong(HotSong hotSong);

    int editHotSong(HotSong hotSong);

    int deleteHotSong(String ids);

    HotSong getHotSongById(HotSong hotSong);
}
