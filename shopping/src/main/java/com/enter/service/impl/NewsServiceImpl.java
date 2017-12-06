package com.enter.service.impl;

import com.enter.entity.News;
import com.enter.repository.NewsRepository;
import com.enter.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/7 0007 14:52
 */
@Component
@Transactional
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> listNews() {
        return newsRepository.findAll();
    }
}
