package com.enter.repository;

import com.enter.entity.News;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/7 0007 14:53
 */
public interface NewsRepository extends Repository<News,Long>{
     List<News> findAll();
}
