package com.enter.controller;

import com.enter.entity.News;
import com.enter.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/7 0007 14:51
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @RequestMapping("/listNews")
    public String listNews(Model model){
        List<News> newsList = newsService.listNews();
        model.addAttribute("newsList",newsList);
        return "/news/news";
    }
}
