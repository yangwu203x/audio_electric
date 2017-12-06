package com.enter.shopping;

import com.alibaba.fastjson.JSONObject;
import com.enter.entity.*;
import com.enter.repository.OrdersRepository;
import com.enter.service.IOrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    public void getOrderStateCount(){
        User user = new User();
        user.setId(1);
        List<StateCount> list = ordersRepository.getOrdersStateCount(user);

        for (StateCount map : list){
           System.out.println(JSONObject.toJSON(map));
        }

    }

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
        Orders persisent = ordersService.saveOrders(order);
        System.out.println(persisent);
    }

    @Test
    public void getOrderById(){
        Orders orders = ordersService.getOrdersById(5l);
        System.out.println(orders);
    }
}
