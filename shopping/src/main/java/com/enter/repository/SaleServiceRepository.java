package com.enter.repository;

import com.enter.entity.Orders;
import com.enter.entity.SaleService;
import com.enter.entity.StateCount;
import com.enter.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/13 0013 11:02
 */
public interface SaleServiceRepository extends Repository<SaleService,Long>{

    SaleService findOne(Long id);

    SaleService save(SaleService saleService);

    @Query("select ss from SaleService ss where ss.orders.user =:user")
    List<SaleService> findSaleServiceByUser(@Param("user") User user);

    @Query("select ss from SaleService ss where ss.orders.user =:user and ss.state >=:state1 and ss.state <=:state2")
    List<SaleService> findSaleServiceByUserAndState(@Param("user") User user,@Param("state1") String state1,@Param("state2")String state2);

    @Query("select ss from SaleService ss where ss.orders.user =:user and ss.state =:state")
    List<SaleService> findSaleServiceByUserAndState(@Param("user") User user,@Param("state") String state);

    @Query("select new com.enter.entity.StateCount(ss.state ,count(ss.state)) from SaleService ss where ss.orders.user=:user group by ss.state")
    List<StateCount> getServiceStateCount(@Param("user")User user);

    @Query("select ss from SaleService ss where ss.orders.id =:orderId and ss.orders.user.id=:userId")
    SaleService findSaleServiceByOrdersAndUser(@Param("orderId")Long orderId,@Param("userId")Long userId);

    @Query("select ss from SaleService ss where ss.id =:id and ss.orders.user.id=:userId")
    SaleService findSaleServiceByIdAndUser(@Param("id")Long id,@Param("userId")Long userId);

    @Modifying
    @Query("update  SaleService ss set ss.state = 6 where  ss.id=?1 ")
    int cancerSaleService(Long id);
}
