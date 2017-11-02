package com.enter.shopping;

import com.enter.entity.Product;
import com.enter.entity.OrderDetail;
import com.enter.entity.Orders;
import com.enter.entity.Trolley;
import com.enter.service.IOrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private IOrdersService ordersService;


    @Test
    public void generateOrder(){
        //订单生成
        Orders order = new Orders();
        order.setAddress("");//地址
        order.setDelivery("");//收件人
        Set<Product> product = new HashSet<>();
        Product product1 = new Product();
        product1.setId(1l);
        Product product2 = new Product();
        product2.setId(2l);
        Product product3 = new Product();
        product3.setId(3l);
        OrderDetail orderDetail1 = new OrderDetail();
        OrderDetail orderDetail2 = new OrderDetail();
        OrderDetail orderDetail3 = new OrderDetail();
        Set<OrderDetail> orderDetails = new HashSet<>();
        orderDetails.add(orderDetail1);
        orderDetails.add(orderDetail2);
        orderDetails.add(orderDetail3);
        order.setOrderDetails(orderDetails);
        Orders persisent = ordersService.saveOrders(order);
        System.out.println(persisent);
    }

    @Test
    public void getOrderById(){
        Orders orders = ordersService.getOrdersById(5l);
        System.out.println(orders);
    }
}
