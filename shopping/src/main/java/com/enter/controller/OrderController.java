package com.enter.controller;

import com.enter.entity.*;
import com.enter.service.IAddressService;
import com.enter.service.IOrdersService;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/24 0024 17:14
 */
@Controller
@RequestMapping("/user/orders")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IAddressService addressService;

    @GetMapping("/view/orderNo/{orderNum}")
    public String findOrderById(@PathVariable("orderNum") Long orderId, Model model){
        Orders orders = ordersService.findOrderById(orderId);
        model.addAttribute("orders",orders);
        return "/orders/order_detail";
    }

    /**
     * 查询所有订单
     * @param model
     * @return
     */
    @GetMapping("/view")
    public String listMyOrder(Model model){

        List<StateCount> orderStates = ordersService.getOrdersStateCount();
        List<Orders> ordersList = ordersService.listMyOrder("0");
        model.addAttribute("ordersList",ordersList);
        for (StateCount orderState1:orderStates)
        model.addAttribute("orderState"+orderState1.getState(),orderState1.getNum());
        model.addAttribute("orderStateActive","0");
        return "/account/my_orders";
    }

    /**
     * 根据订单状态来查询订单
     * @param model
     * @param orderState
     * @return
     */
    @GetMapping("/status/{orderState}")
    public String listMyOrderByStatus(Model model,@PathVariable("orderState") String orderState){
        List<StateCount> orderStates = ordersService.getOrdersStateCount();
        List<Orders> ordersList = ordersService.listMyOrder(orderState);
        model.addAttribute("ordersList",ordersList);
        for (StateCount orderState1:orderStates)
            model.addAttribute("orderState"+orderState1.getState(),orderState1.getNum());
        model.addAttribute("orderStateActive",orderState);
        return "/account/my_orders";
    }

    /**
     * 立即购买
     * @return
     */
    @PostMapping("/nowBuy")
    @ResponseBody
    public Object nowBuy(Long productId,Integer count,String colorNo,String series){
        //添加到购物车
        Trolley trolley = ordersService.nowBuy(productId,count,colorNo,series);
        return BodyUtil.success(null,DataType.Object,"/user/orders/generate/two/trolleyIds/"+trolley.getId());
    }

    /**
     * 批量生成子订单
     * @return
     */
    @PostMapping("/generate/one")
    @ResponseBody
    public Object addALLToOrder(String trolleyIds){
        List<Trolley> trolleyList = ordersService.addAllToOrderDetail(trolleyIds);
        //拼接地址
        return BodyUtil.success("/user/orders/generate/two/trolleyIds/"+trolleyIds, DataType.Object);
    }


    /**
     * 提交订单页面预览
     * @param trolleyIds
     * @return
     */
    @GetMapping("/generate/two/trolleyIds/{trolleyIds}")
    public String generatedOrder(@PathVariable("trolleyIds") String trolleyIds, Model model){
        //地址
        List<Address> addressList = addressService.listMyAddress();
        //订单详情列表
        List<Trolley> trolleyList = ordersService.listMyTrolleyTrolleyId(trolleyIds);
        Double priceTotal = 0d;
        for (Trolley trolley:trolleyList){
            priceTotal += trolley.getSubTotal();
        }
        model.addAttribute("trolleyList",trolleyList);
        model.addAttribute("addressList",addressList);
        model.addAttribute("priceTotal",priceTotal);
        model.addAttribute("trolleyIds",trolleyIds);

        return "/orders/order_confirm";
    }


    /**
     * 生成订单
     * @param trolleyIds
     * @param addressId
     * @return
     */
    @ResponseBody
    @PostMapping("/generate/three")
    public Object generatedTotalOrder(String trolleyIds, Long addressId){
        Orders order = ordersService.generatedTotalOrder(trolleyIds,addressId);
        return BodyUtil.success(order,DataType.Object);
    }


    /**
     * 在线支付页面
     * @param orderNum
     * @param model
     * @return
     */
    @GetMapping("/onlinePay/view/{orderNum}")
    public String onlinePay(@PathVariable("orderNum") String orderNum,Model model){
        Orders orders = ordersService.findOrdersByOrderNum(orderNum);
        model.addAttribute("orders",orders);
        return "/orders/online_pay";
    }

    /**
     * 取消订单
     * @param orderNum
     * @return
     */
    @PutMapping("/cancer/{orderNum}")
    @ResponseBody
    public Object cancerOrders(@PathVariable("orderNum")String orderNum){
        ordersService.cancerOrders(orderNum);
        return BodyUtil.success();
    }


}
