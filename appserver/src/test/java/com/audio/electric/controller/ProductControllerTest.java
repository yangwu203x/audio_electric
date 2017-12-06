package com.audio.electric.controller;

import com.audio.electric.domain.Product;
import com.audio.electric.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/31 0031 9:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private IProductService productService;
    @Test
    public void getExpirydate(){
        Product product = productService.getExpiryDateBySerialNo("111");
        System.out.println(product.getExpirydate());
    }
}
