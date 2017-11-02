package com.enter.controller;

import com.enter.entity.Banner;
import com.enter.entity.Product;
import com.enter.entity.User;
import com.enter.repository.UserRepository;
import com.enter.service.IBannerService;
import com.enter.service.IProductService;
import com.enter.service.IUserService;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/13 0013 17:21
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IBannerService bannerService;


    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(User user){

        return BodyUtil.result(1);
    }

    @RequestMapping("/getUserById/{Id}")
    public String getUserById(@PathVariable("Id") Long id){
        User user = userRepository.getUserById(id);
        return user.toString();
    }

    @RequestMapping("/accountInfo")
    public String accountInfo(Model model){
        User user = userService.accountInfo();
        model.addAttribute("account",user);
        return "/account/account_info";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public String toPage(Model model){
        List<Product> flyProduct = productService.findProductByCategoryId(1l);
        List<Product> ktvProduct = productService.findProductByCategoryId(2l);
        List<Banner> banners = bannerService.findAll();
        model.addAttribute("flyProduct",flyProduct.get(0));
        model.addAttribute("ktvProduct",ktvProduct);
        model.addAttribute("banners",banners);
        return "index";
    }

    @RequestMapping("/{path}/{name}")
    public String toPage(@PathVariable("path")String path,@PathVariable("name")String name){
        return "/"+path+"/"+name;
    }


    @RequestMapping("/reqXML")
    public String reqXML(Model model){
        return null;
    }
}
