package com.enter.service;

import com.enter.entity.Banner;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:55
 */
public interface IBannerService {

    List<Banner> findAll();

    Banner addBanner(Banner banner);
}
