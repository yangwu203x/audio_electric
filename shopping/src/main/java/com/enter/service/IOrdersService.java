package com.enter.service;

import com.enter.entity.OrderDetail;
import com.enter.entity.Orders;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/19 0019 16:41
 */
public interface IOrdersService {

    Orders saveOrders(Orders orders);

    Orders getOrdersById(Long ordersId);

    /**
     * 添加单个子订单
     * @param trolleyId
     * @return
     */
    OrderDetail addToOrderDetail(Long trolleyId);

    List<OrderDetail> addAllToOrderDetail(String trolleyIds);

    List<Orders> listMyOrder();

    List<OrderDetail> listMyOrderDetailByTrolleyId(String trolleyIds);

    Orders generatedTotalOrder(String trolleyIds, Long addressId);

    Orders findOrdersByOrderNum(String orderNum);
}
