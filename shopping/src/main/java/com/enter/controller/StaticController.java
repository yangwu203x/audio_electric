package com.enter.controller;

import com.enter.entity.Banner;
import com.enter.entity.Product;
import com.enter.service.IBannerService;
import com.enter.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/26 0026 16:04
 */
@Controller
public class StaticController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IBannerService bannerService;

    @RequestMapping("/")
    public String index(Model model){
        List<Product> flyProduct = productService.findProductByCategoryId(1l);
        List<Product> ktvProduct = productService.findProductByCategoryId(2l);
        List<Banner> banners = bannerService.findAll();
        model.addAttribute("flyProduct",flyProduct.get(0));
        model.addAttribute("ktvProduct",ktvProduct);
        model.addAttribute("banners",banners);
        return "index";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "/about/contact";
    }

    @RequestMapping("/news")
    public String news(){
        return "/news/news";
    }

    @RequestMapping("/activity")
    public String activity(){
        return "/activity/activity";
    }

    @RequestMapping("/login")
    public String login(){
        return "/reg/login";
    }

    @RequestMapping("/discount")
    public String discount(){
        return "/coupon/discount";
    }
}
