package com.audio.electric.mapper;

import com.audio.electric.domain.Song;
import com.audio.electric.domain.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/6 0006 9:39
 */
@Component
public interface CountMapper {
    List<Song> songRank(Song song) throws SQLException;

    List<User> listUserOnline()throws SQLException;

    List<Song> songCollection(Song song)throws SQLException;
}
