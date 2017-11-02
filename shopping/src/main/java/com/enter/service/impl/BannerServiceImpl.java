package com.enter.service.impl;

import com.enter.entity.Banner;
import com.enter.repository.BannerRepository;
import com.enter.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:55
 */
@Component
@Transactional
public class BannerServiceImpl implements IBannerService {
    @Autowired
    private BannerRepository bannerRepository;
    @Override
    public List<Banner> findAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner addBanner(Banner banner) {
        return bannerRepository.save(banner);
    }
}
