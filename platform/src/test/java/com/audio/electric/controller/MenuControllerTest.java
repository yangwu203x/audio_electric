package com.audio.electric.controller;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.Menu;
import com.audio.electric.service.IMenuService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/26 0026 21:07
 */
public class MenuControllerTest extends PlatformApplicationTests{
    private final static Logger logger = LoggerFactory.getLogger(MenuControllerTest.class);
    @Autowired
    private IMenuService menuService;
    @Test
    public void listMenu() throws Exception {
        List<Menu> menuList = menuService.listMenu(new Menu());
        PageInfo pagehepler = new PageInfo(menuList);
        logger.info("pagenum={}",pagehepler.getPageNum());
        logger.info("pages={}",pagehepler.getPages());
        logger.info("pagesize={}",pagehepler.getPageSize());
        logger.info("total={}",pagehepler.getTotal());
        logger.info("page={}",pagehepler.toString());
        for (Menu menu : menuList)
            System.out.println(menu);
    }

}