package com.enter.controller;

import com.enter.entity.Trolley;
import com.enter.service.ITrolleyService;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/23 0023 9:31
 */
@Controller
@RequestMapping("/user/trolley")
public class TrolleyController {

    @Autowired
    ITrolleyService trolleyService;


    @ResponseBody
    @GetMapping("/totalCount")
    public Object productCountFromTrolley(){
        String num = trolleyService.getTrolleyNum();
        if (num == null)
            num = "0";
        return BodyUtil.success(num, DataType.Object);
    }


    @ResponseBody
    @GetMapping("/ajax/view")
    public Object ajaxToMyTrolley(){
        List<Trolley> trolleyList = trolleyService.listMyTrolley();
        return BodyUtil.success(trolleyList, DataType.Array);
    }

    @GetMapping("/view")
    public String listMyTrolley(Model model){
        List<Trolley> trolleyList = trolleyService.listMyTrolley();
        model.addAttribute("trolleyList",trolleyList);
        return "/trolley/shop_cart";
    }

    @PostMapping("/add")
    @ResponseBody
    public Object addToTrolley(Long productId,Integer count,String colorNo,String series){
        //加一件就要加数量上
        trolleyService.addToTrolley(productId,count,colorNo,series);
        return BodyUtil.result(1);
    }

    @DeleteMapping("/delete/id/{trolleyId}")
    @ResponseBody
    public Object deleteFromTrolley(@PathVariable("trolleyId") Long trolleyId){
         trolleyService.deleteFromTrolley(trolleyId);
         return BodyUtil.success();
    }

    @DeleteMapping("/delete/bacth/ids/{trolleyIds}")
    @ResponseBody
    public Object bacthDeleteFromTrolley(@PathVariable("trolleyIds") String trolleyIds){
        trolleyService.bacthDeleteFromTrolley(trolleyIds);
        return BodyUtil.success();
    }


}
