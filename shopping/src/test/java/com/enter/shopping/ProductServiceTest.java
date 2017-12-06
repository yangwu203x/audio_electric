package com.enter.shopping;

import com.enter.entity.Parts;
import com.enter.entity.Product;
import com.enter.repository.PartsRepository;
import com.enter.repository.ProductRepository;
import com.enter.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private IProductService productService;
    @Autowired
    private PartsRepository partsRepository;
    @Autowired
    private ProductRepository productRepository;

    /**
     * 添加配件
     */
    @Test
    public void addParts(){
        Parts parts = new Parts();
        parts.setName("充电器");
        parts.setPicUrl("/images/pro-acc-3.jpg");
        Parts parts2 = new Parts();
        parts2.setName("U盘");
        parts2.setPicUrl("/images/pro-acc-7.jpg");
        Parts parts3 = new Parts();
        parts3.setName("usb数据线");
        parts3.setPicUrl("/images/pro-acc-4.jpg");
        partsRepository.save(parts);
        partsRepository.save(parts2);
        partsRepository.save(parts3);
    }

    /**
     * 添加产品
     */
    @Test
    public void addProduct(){

        List<Parts> partsList = partsRepository.findAll();
        Set<Parts> partsSet = new HashSet<>();
        partsSet.addAll(partsList);
        Product product = new Product();
        product.setPartsSet(partsSet);
        product.setName("magic sing");
        product.setThumbnail("/images/ktv2.jpg");
        product.setCategoryId(2);
        productRepository.save(product);
    }

    @Test
    public void contextLoads() {
        List<Product> product = productService.findProductByCategoryId(1);
        Iterator<Product> it =  product.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }

    @Test
    public void getProductById() {
        Product product = productService.findOne(5l);
        System.out.println(product);
    }

    @Test
    public void findAll(){
        Pageable pageable = new PageRequest(0,5);
        Page<Product> productList = productService.findAll(pageable);
        for (Product product : productList)
            System.out.println(product);
    }

}
