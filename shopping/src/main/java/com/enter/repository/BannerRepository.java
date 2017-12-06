package com.enter.repository;

import com.enter.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 14:56
 */
public interface BannerRepository extends JpaRepository<Banner,Long> {

    List<Banner> findAll();

    List<Banner> findBannerByCategory(String category);
}
