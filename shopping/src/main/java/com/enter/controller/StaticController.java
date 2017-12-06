package com.enter.controller;

import com.enter.entity.Banner;
import com.enter.entity.Product;
import com.enter.entity.User;
import com.enter.exception.PageException;
import com.enter.service.IBannerService;
import com.enter.service.IProductService;
import com.enter.util.CheckUserLogin;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Product> flyProduct = productService.findProductByCategoryId(2);
        List<Product> ktvProduct = productService.findProductByPosition(1);
        List<Banner> banners = bannerService.findBannerByCategory("index");
        model.addAttribute("flyProduct",flyProduct.get(0));
        model.addAttribute("ktvProduct",ktvProduct);
        model.addAttribute("banners",banners);
        return "/index";
    }

    @RequestMapping("/about")
    public String about(){
        return "/about/about";
    }

    @RequestMapping("/deliveryInfo")
    public String deliveryInfo(){
        return "/delivery/delivery_info";
    }

    @RequestMapping("/songs")
    public String songs(){
        return "/songs/songs";
    }

    @RequestMapping("/music")
    public String music(){
        return "/music/music";
    }

    @RequestMapping("/media")
    public String media(){
        return "/media/media";
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
        User user = CheckUserLogin.getloginuser();
        if (user == null)
            throw new PageException(RetCode.UNLOGINED);
        return "/coupon/discount";
    }
}
