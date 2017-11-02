package com.enter.controller;

import com.enter.entity.Product;
import com.enter.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 17:33
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/findProductById")
    public String findProductById(Model model, Long productId){

        Product product = productService.findOne(productId);
        model.addAttribute("product", product);
        return "/product/page";
    }
}
