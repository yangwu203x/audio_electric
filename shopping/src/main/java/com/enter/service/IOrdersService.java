package com.enter.service;

import com.enter.entity.StateCount;
import com.enter.entity.Orders;
import com.enter.entity.Trolley;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/19 0019 16:41
 */
public interface IOrdersService {

    Orders saveOrders(Orders orders);

    Orders getOrdersById(Long ordersId);


    List<Trolley> addAllToOrderDetail(String trolleyIds);

    List<Orders> listMyOrder(String orderState);

    List<Trolley> listMyTrolleyTrolleyId(String trolleyIds);

    Orders generatedTotalOrder(String trolleyIds, Long addressId);

    Orders findOrdersByOrderNum(String orderNum);

    Orders findOrderById(Long orderId);


    List<StateCount> getOrdersStateCount();

    void cancerOrders(String orderNum);

    Trolley nowBuy(Long productId,Integer count,String colorNo,String series);
}
