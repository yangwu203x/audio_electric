package com.enter.shopping;

import com.enter.entity.Product;
import com.enter.entity.Trolley;
import com.enter.entity.User;
import com.enter.repository.TrolleyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TrolleyServiceTest {

    @Autowired
    private TrolleyRepository trolleyRepository;

    @Test
    public void findTrolleyByIdIn(){
        List<Long> trolleyIds = new ArrayList<>();
        trolleyIds.add(1l);
        trolleyIds.add(2l);
        trolleyIds.add(3l);
    }

    @Test
    public void addProductToTrolley(){
        Product product = new Product();
        product.setId(15);
        Trolley trolley = new Trolley();
        trolley.setCount(20);
        User user = new User();
        user.setId(1l);
        trolley.setUser(user);
        trolley.setProduct(product);
        trolleyRepository.save(trolley);
    }

    @Test
    public void deleteTrolley(){
        Long trolleyId = 32l;
        User user = new User() ;
        user.setId(1l);
        int result =  trolleyRepository.deleteTrolleyByIdAndUser(trolleyId,user);
        System.out.println(result);
    }

    @Test
    public void getTrolleyNum(){
        User user = new User() ;
        user.setId(1l);
        System.out.println(trolleyRepository.getTrolleyNum(user));
    }
}
