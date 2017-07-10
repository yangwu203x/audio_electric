package com.audio.electric.service.impl;

import com.audio.electric.domain.Song;
import com.audio.electric.domain.User;
import com.audio.electric.mapper.CountMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.ICountService;
import com.audio.electric.util.annotation.UsePage;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/6 0006 9:33
 */
@Component
public class CountServiceImpl extends BaseService implements ICountService{
    @Autowired
    private CountMapper countMapper;

    @UsePage
    @Override
    public List<Song> songRank(Song song) {
        List<Song> songList = null;
        try {
            songList = countMapper.songRank(song);
            PageInfo<Song> pagehelper = new PageInfo<>(songList);
            int pageNum = pagehelper.getPageNum();
            int pageSize = pagehelper.getPageSize();
            int i = 1;
            for (Song temp : songList){
                temp.setRank((pageNum-1)*pageSize + i++);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    @Override
    public List<User> listUserOnline() {
        try {
            return countMapper.listUserOnline();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Song> songCollection(Song song) {
        List<Song> songList = null;
        try {
            songList = countMapper.songCollection(song);
            PageInfo<Song> pagehelper = new PageInfo<>(songList);
            int pageNum = pagehelper.getPageNum();
            int pageSize = pagehelper.getPageSize();
            int i = 1;
            for (Song temp : songList){
                temp.setRank((pageNum-1)*pageSize + i++);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }
}
