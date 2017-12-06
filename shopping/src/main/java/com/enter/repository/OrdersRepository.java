package com.enter.repository;

import com.enter.entity.StateCount;
import com.enter.entity.Orders;
import com.enter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/19 0019 15:08
 */
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    Orders save(Orders orders);

    Orders findOrdersByUserAndIdAndOrderState(User user,Long orderId,String orderState);

    Orders getOrdersById(Long ordersId);

    List<Orders> findOrderByUserOrderByOrderStateAsc(User user);

    List<Orders> findOrderByUserAndOrderState(User user,String orderState);

    List<Orders> findOrderByUserAndOrderStateIn(User user,List<String> orderStates);

    @Query("select new com.enter.entity.StateCount(o.orderState ,count(o.orderState)) from Orders o where o.user=:user group by o.orderState")
    List<StateCount> getOrdersStateCount(@Param("user")User user);

    Orders findOrdersByOrderNumAndUser(String orderNum,User user);

    Orders findOrdersByIdAndUser(Long orderId, User user);

    Orders findOrdersByUserAndOrderNumAndOrderState(User user,String orderNum,String orderState);

//    @Modifying @Query("update  Orders o set o.orderState = ?1,o.closeTime=?2 where o.user=?3 and o.orderNum=?4")
//    int cancerOrders(String closeTime,User user, String orderNum);
}
