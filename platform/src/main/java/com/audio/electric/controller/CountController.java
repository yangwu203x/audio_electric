package com.audio.electric.controller;

import com.audio.electric.domain.Song;
import com.audio.electric.domain.User;
import com.audio.electric.service.ICountService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/4 0004 14:27
 */
@Controller
@RequestMapping("/count")
public class CountController {
    @Autowired
    private ICountService countService;

    @RequestMapping("/songRank")
    public String songRank(Song song, Model model){
        List<Song> songList = countService.songRank(song);
        PageInfo<Song> pagehelper = new PageInfo<>(songList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("songList",songList);
        return "count/song_rank_list";
    }

    @RequestMapping("/songCollection")
    public String songCollection(Song song,Model model){
        List<Song> songList = countService.songCollection(song);
        PageInfo<Song> pagehelper = new PageInfo<>(songList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("songList",songList);
        return "count/song_collection_list";
    }

    @RequestMapping("/onlineUser")
    public String onlineUserCount(Model model){
        List<User> userList = countService.listUserOnline();
        PageInfo<User> pagehelper = new PageInfo<>(userList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("userList",userList);
        return "count/online_count/online_user_list";
    }

    @RequestMapping("/saleRecord")
    public String saleRecord(){

        return "count/sale_list";
    }
}
