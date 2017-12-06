package com.enter.shopping;

import com.enter.entity.Orders;
import com.enter.entity.SaleService;
import com.enter.entity.User;
import com.enter.repository.SaleServiceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SaleServiceServiceTest {

    @Autowired
    private SaleServiceRepository saleServiceRepository;

    @Test
    public void findSaleServiceByUserAndState(){
        User user = new User();
        user.setId(1l);
        saleServiceRepository.findSaleServiceByUserAndState(user,"3","4");
    }

    @Test
    public void cancerSaleService(){
        saleServiceRepository.cancerSaleService(6l);
    }

    @Test
    public void findSaleServiceByOrderId(){
        SaleService saleService = saleServiceRepository.findSaleServiceByOrdersAndUser(16l,1l);
        System.out.println(saleService.getOrders().getAddress());
    }

    @Test
    public void findSaleServiceByUser(){
        User user = new User();
        user.setId(1l);
        List<SaleService> saleServiceList = saleServiceRepository.findSaleServiceByUser(user);
    }

    @Test
    public void getServiceStateCount(){
        User user = new User();
        user.setId(1l);
        saleServiceRepository.getServiceStateCount(user);
    }


}
