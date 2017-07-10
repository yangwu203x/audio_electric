package com.audio.electric.controller;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.HotSong;
import com.audio.electric.service.IHotSongService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/10 0010 13:49
 */
public class HotSongControllerTest extends PlatformApplicationTests{
    private Logger logger = LoggerFactory.getLogger(HotSongControllerTest.class);
    @Autowired
    private IHotSongService hotSongService;
    @Test
    public void test()throws Exception {
        HotSong hotSong1 = new HotSong(1,1);
        HotSong hotSong2 = new HotSong(2,2);
        HotSong hotSong3 = new HotSong(3,3);
        hotSongService.saveHotSong(hotSong1);
        hotSongService.saveHotSong(hotSong2);
        hotSongService.saveHotSong(hotSong3);
        List<HotSong> hotSongList = hotSongService.listHotSong();
        logger.info("size="+hotSongList.size());
        HotSong temp = new HotSong();
        temp.setId(1);
        temp = hotSongService.getHotSongById(temp);
        logger.info(temp.getId()+"="+temp.getRank()+"<>"+temp.getSongId());
        temp.setSongId(4);
        temp.setRank(4);
        logger.info(temp.getId()+"="+temp.getRank()+"<>"+temp.getSongId());
        hotSongService.editHotSong(temp);
        temp = hotSongService.getHotSongById(temp);
        logger.info(temp.getId()+"="+temp.getRank()+"<>"+temp.getSongId());
        hotSongService.deleteHotSong(temp.getId().toString());
        hotSongList = hotSongService.listHotSong();
        logger.info("size="+hotSongList.size());
    }

}