package com.audio.electric.controller;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.HotSinger;
import com.audio.electric.service.IHotSingerService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/10 0010 13:49
 */
public class HotSingerControllerTest extends PlatformApplicationTests{
    private Logger logger = LoggerFactory.getLogger(HotSingerControllerTest.class);
    @Autowired
    private IHotSingerService hotSingerService;
    @Test
    public void test()throws Exception {
//        HotSinger hotSinger1 = new HotSinger(1,1);
//        HotSinger hotSinger2 = new HotSinger(2,2);
//        HotSinger hotSinger3 = new HotSinger(3,3);
//        hotSingerService.saveHotSinger(hotSinger1);
//        hotSingerService.saveHotSinger(hotSinger2);
//        hotSingerService.saveHotSinger(hotSinger3);
        List<HotSinger> hotSingerList = hotSingerService.listHotSinger();
        logger.info("size="+hotSingerList.size());
        HotSinger temp = new HotSinger();
        //id要谨慎，对照数据库设置
        temp.setId(5);
        temp = hotSingerService.getHotSingerById(temp);
        logger.info(temp.getId()+"="+temp.getRank()+"<>"+temp.getSingerId());
        temp.setSingerId(4);
        temp.setRank(4);
        logger.info(temp.getId()+"="+temp.getRank()+"<>"+temp.getSingerId());
        hotSingerService.editHotSinger(temp);
        temp = hotSingerService.getHotSingerById(temp);
        logger.info(temp.getId()+"="+temp.getRank()+"<>"+temp.getSingerId());
        hotSingerService.deleteHotSinger(temp.getId().toString());
        hotSingerList = hotSingerService.listHotSinger();
        logger.info("size="+hotSingerList.size());
    }

}