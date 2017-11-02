package com.enter.repository;

import com.enter.entity.OrderDetail;
import com.enter.entity.Trolley;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/19 0019 17:24
 */
public interface OrderDetailRepository  extends JpaRepository<OrderDetail,Long> {

    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> findOrderDetailByTrolleyIn(List<Trolley> trolleys);
}
