package com.enter.controller;

import com.enter.entity.Trolley;
import com.enter.service.ITrolleyService;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/23 0023 9:31
 */
@Controller
@RequestMapping("/trolley")
public class TrolleyController {

    @Autowired
    ITrolleyService trolleyService;


    @ResponseBody
    @RequestMapping("/productCountFromTrolley")
    public Object productCountFromTrolley(){
        int num = trolleyService.productCountFromTrolley();
        return BodyUtil.sucess(num, DataType.Object);
    }


    @ResponseBody
    @RequestMapping("/ajaxToMyTrolley")
    public Object ajaxToMyTrolley(){
        List<Trolley> trolleyList = trolleyService.listMyTrolley();
        return BodyUtil.sucess(trolleyList, DataType.Array);
    }

    @RequestMapping("/listMyTrolley")
    public String listMyTrolley(Model model){
        List<Trolley> trolleyList = trolleyService.listMyTrolley();
        model.addAttribute("trolleyList",trolleyList);
        return "/trolley/shop_cart";
    }

    @RequestMapping("/addToTrolley")
    @ResponseBody
    public Object addToTrolley(Long productId,Integer count){
        //加一件就要加数量上
        trolleyService.addToTrolley(productId,count);
        return BodyUtil.result(1);
    }

    @RequestMapping("/deleteFromTrolley")
    public Object deleteFromTrolley(Long productId,Integer count){
        //删除一件和全部删除
         trolleyService.deleteFromTrolley(productId,count);
         return null;
    }
}
