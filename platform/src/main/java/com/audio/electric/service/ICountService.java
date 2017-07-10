package com.audio.electric.service;

import com.audio.electric.domain.Song;
import com.audio.electric.domain.User;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/6 0006 9:33
 */
public interface ICountService {
    List<Song> songRank(Song song);

    List<User> listUserOnline();

    List<Song> songCollection(Song song);
}
