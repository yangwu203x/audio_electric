package com.enter.service.impl;

import com.enter.annotations.LoginVerify;
import com.enter.entity.*;
import com.enter.exception.PageException;
import com.enter.exception.ShoppingException;
import com.enter.repository.OrderDetailRepository;
import com.enter.repository.OrdersRepository;
import com.enter.repository.TrolleyRepository;
import com.enter.service.IAddressService;
import com.enter.service.IOrdersService;
import com.enter.service.ITrolleyService;
import com.enter.util.CheckUserLogin;
import com.enter.util.Constant;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/19 0019 16:41
 */
@Transactional
@Component
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private TrolleyRepository trolleyRepository;
    @Autowired
    private IAddressService addressService;

    @Override
    public Orders saveOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrdersById(Long ordersId) {
        return ordersRepository.getOrdersById(ordersId);
    }

    @LoginVerify
    @Override
    public OrderDetail addToOrderDetail(Long trolleyId) {
        Trolley trolley = trolleyRepository.findOne(trolleyId);
        if (trolley == null)
            throw new PageException(RetCode.TROLLEYISNOTEXIST);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setTrolley(trolley);
        return orderDetailRepository.save(orderDetail);
    }

    @LoginVerify
    @Override
    public List<OrderDetail> addAllToOrderDetail(String trolleyIds) {
        User user = CheckUserLogin.getloginuser();
        List<Long> trolleyIdList = getLongs(trolleyIds);
        //挑出需要添加的购物车状态
        List<Trolley> trolleys = trolleyRepository.findTrolleyByIdInAndUserIdAndStatus(trolleyIdList,user.getId(), Constant.TROLLEYONE);
        for (Trolley trolley:trolleys){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setTrolley(trolley);
            orderDetailRepository.save(orderDetail);
            trolley.setStatus(Constant.TROLLEYTWO);
            trolleyRepository.save(trolley);
        }
        trolleys = trolleyRepository.findTrolleyByIdInAndUserIdAndStatus(trolleyIdList,user.getId(), Constant.TROLLEYTWO);
        return orderDetailRepository.findOrderDetailByTrolleyIn(trolleys);
    }

    private List<Long> getLongs(String trolleyIds) {
        List<Long> trolleyIdList =  new ArrayList<>();
        String[] trolleyIdArr = trolleyIds.split(",");
        for(String trolleyId : trolleyIdArr){
            trolleyIdList.add(Long.parseLong(trolleyId));
        }
        return trolleyIdList;
    }

    @LoginVerify
    @Override
    public List<Orders> listMyOrder() {
        User user = CheckUserLogin.getloginuser();
        return ordersRepository.findOrderByUserId(user.getId());
    }

    @LoginVerify
    @Override
    public List<OrderDetail> listMyOrderDetailByTrolleyId(String trolleyIds) {
        User user = CheckUserLogin.getloginuser();
        List<Long> trolleyIdList = getLongs(trolleyIds);
        List<Trolley> trolleyList = new ArrayList<>();
        for (Long trolleyId : trolleyIdList){
            Trolley trolley = new Trolley();
            trolley.setId(trolleyId);
            trolleyList.add(trolley);
        }
        List<OrderDetail> orderDetailList = orderDetailRepository.findOrderDetailByTrolleyIn(trolleyList);
        return orderDetailList;
    }

    @LoginVerify
    @Override
    public Orders generatedTotalOrder(String trolleyIds, Long addressId) {
        try{
            User user = CheckUserLogin.getloginuser();
            List<Long> trolleyIdList = getLongs(trolleyIds);
            List<Integer> status = new ArrayList<>(Arrays.asList(Constant.TROLLEYONE,Constant.TROLLEYTWO));
            List<Trolley> trolleyList = trolleyRepository.findTrolleyByIdInAndStatusIn(trolleyIdList,status);
            Address address = addressService.findAddressById(addressId);
            List<OrderDetail> orderDetails  = orderDetailRepository.findOrderDetailByTrolleyIn(trolleyList);
            Double price = new Double(0);
            for (Trolley trolley : trolleyList){
                price += trolley.getSubTotal();
                trolley.setStatus(Constant.TROLLEYTHREE);
                trolleyRepository.save(trolley);
            }
            Orders orders = new Orders();
            orders.setPrice(price);
            orders.setTel(address.getTel());
            orders.setUser(user);
            orders.setRecipients(address.getName());
            orders.setOrderNum(UUID.randomUUID().toString());
            AddressInfo addressInfo = address.getAddressInfo();
            orders.setAddress(addressInfo.getProvince()+addressInfo.getCity()+addressInfo.getArea()+addressInfo.getDetailPosition());
            Set<OrderDetail> orderDetails1Set=new HashSet<>();
            orderDetails1Set.addAll(orderDetails);
            orders.setOrderDetails(orderDetails1Set);
            return ordersRepository.save(orders);
        }catch (Exception e){
            throw new ShoppingException(RetCode.UNKNOWN_ERROR);
        }

    }

    @Override
    public Orders findOrdersByOrderNum(String ordersId) {
        return ordersRepository.findOrdersByOrderNum(ordersId);
    }
}
