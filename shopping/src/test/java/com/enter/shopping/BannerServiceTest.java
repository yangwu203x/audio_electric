package com.enter.shopping;

import com.enter.entity.Banner;
import com.enter.service.IBannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BannerServiceTest {

    @Autowired
    private IBannerService bannerService;

    @Test
    public void addBanner(){
        Banner banner = new Banner();
        banner.setPicUrl("/images/banner2.jpg");
        Banner banner1 = bannerService.addBanner(banner);
    }

    @Test
    public void findAll() {
        List<Banner> banners = bannerService.findAll();
        for(Banner banner : banners)
            System.out.println(banner);
    }

}
