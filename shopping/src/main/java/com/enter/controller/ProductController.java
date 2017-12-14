package com.enter.controller;

import com.enter.entity.Product;
import com.enter.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 17:33
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/view/id/{productId}")
    public String findProductById(Model model, @PathVariable("productId") Long productId){

        Product product = productService.findOne(productId);
        model.addAttribute("product", product);
        if(product.getName().contains("E5")){
            model.addAttribute("proDetail","/product/e5/proDetail");
            model.addAttribute("spec","/product/e5/spec");
            model.addAttribute("askQ","/product/e5/askQ");
        }else if(product.getName().contains("MP30")){
            model.addAttribute("proDetail","/product/MP30/proDetail");
            model.addAttribute("spec","/product/MP30/spec");
            model.addAttribute("askQ","/product/MP30/askQ");
        }else{
            model.addAttribute("proDetail","/product/no/proDetail");
            model.addAttribute("spec","/product/no/spec");
            model.addAttribute("askQ","/product/no/askQ");
        }
        return "/product/page";
    }

    @GetMapping("/view")
    public String listMall(Model model){
        Map<String,Object> map = productService.listMall();
        model.addAttribute("mall",map);
        return "/product/product";
    }
}
