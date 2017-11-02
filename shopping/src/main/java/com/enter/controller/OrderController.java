package com.enter.controller;

import com.enter.entity.Address;
import com.enter.entity.OrderDetail;
import com.enter.entity.Orders;
import com.enter.service.IAddressService;
import com.enter.service.IOrdersService;
import com.enter.util.Constant;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/24 0024 17:14
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IAddressService addressService;

    @RequestMapping("/listMyOrder")
    public String listMyOrder(Model model){
        List<Orders> ordersList = ordersService.listMyOrder();
        model.addAttribute("ordersList",ordersList);
        return "/account/my_orders";
    }

    /**
     * 购物车生成
     * @param trolleyId
     * @return
     */
    @RequestMapping("/addToOrder")
    public String addToOrder(Long trolleyId){
        //根据购物车id生成子订单
        ordersService.addToOrderDetail(trolleyId);
        return "";
    }

    @ResponseBody
    @RequestMapping("/generatedTotalOrder")
    public Object generatedTotalOrder(String trolleyIds,Long addressId){
        //根据购物车id生成子订单
        Orders order = ordersService.generatedTotalOrder(trolleyIds,addressId);
        return BodyUtil.sucess(order,DataType.Object);
    }

    @RequestMapping("/onlinePay")
    public String onlinePay(String orderNum,Model model){
        Orders orders = ordersService.findOrdersByOrderNum(orderNum);
        model.addAttribute("orders",orders);
        return "/orders/online_pay";
    }

    /**
     * 批量添加子订单
     * @return
     */
    @RequestMapping("/addALLToOrder")
    @ResponseBody
    public Object addALLToOrder(String trolleyIds){
        List<OrderDetail> orderDetailList = ordersService.addAllToOrderDetail(trolleyIds);
        //拼接地址
        return BodyUtil.sucess("/order/generatedOrder?trolleyIds="+trolleyIds, DataType.Object);
    }

    /**
     * @param trolleyIds
     * @return
     */
    @RequestMapping("/generatedOrder")
    public String generatedOrder(String trolleyIds, Model model){
        //地址
        List<Address> addressList = addressService.listMyAddress();
        //订单详情列表
        List<OrderDetail> orderDetails = ordersService.listMyOrderDetailByTrolleyId(trolleyIds);
        Double priceTotal = 0d;
        for (OrderDetail orderDetail:orderDetails){
            priceTotal += orderDetail.getTrolley().getSubTotal();
        }
        model.addAttribute("orderDetails",orderDetails);
        model.addAttribute("addressList",addressList);
        model.addAttribute("priceTotal",priceTotal);
        model.addAttribute("trolleyIds",trolleyIds);

        return "/orders/order_confirm";
    }

    @RequestMapping("/modifyOrderAddress")
    @ResponseBody
    public Object modifyOrderAddress(Long addressId,HttpServletRequest request){
        Address address = addressService.findAddressById(addressId);
        request.getSession().setAttribute(Constant.DEFAULTADDRESS,address);
        return BodyUtil.sucess(address,DataType.Object);
    }

    @RequestMapping("/afterService")
    public String afterService(){
        return "/sale_services/service_after";
    }

}
