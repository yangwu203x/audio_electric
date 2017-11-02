package com.enter.repository;

import com.enter.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/19 0019 15:08
 */
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    Orders save(Orders orders);

    Orders getOrdersById(Long ordersId);

    List<Orders> findOrderByUserId(long id);

    Orders findOrdersByOrderNum(String orderNum);
}
