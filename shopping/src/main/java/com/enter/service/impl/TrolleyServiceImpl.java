package com.enter.service.impl;

import com.enter.annotations.LoginVerify;
import com.enter.entity.Product;
import com.enter.entity.Trolley;
import com.enter.entity.User;
import com.enter.exception.PageException;
import com.enter.exception.ShoppingException;
import com.enter.repository.TrolleyRepository;
import com.enter.service.IProductService;
import com.enter.service.ITrolleyService;
import com.enter.util.CheckUserLogin;
import com.enter.util.Constant;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/23 0023 9:33
 */
@Transactional
@Component
public class TrolleyServiceImpl implements ITrolleyService {
    @Autowired
    private TrolleyRepository trolleyRepository;
    @Autowired
    private IProductService productService;
    private List<Integer> status = new ArrayList<>(Arrays.asList(Constant.TROLLEYONE,Constant.TROLLEYTWO));

    @Override
    public Trolley addToTrolley(Long productId,Integer count) {
        User user = CheckUserLogin.getloginuser();
        if (user == null)
            throw new ShoppingException(RetCode.UNLOGINED);
        Product product = productService.findOne(productId);
        Trolley trolley = trolleyRepository.findTrolleyByUserIdAndProductAndStatusIn(user.getId(),product,status);
        if (trolley == null){
            trolley = new Trolley();
            trolley.setCount(count);
            trolley.setSubTotal(product.getPriceSale()*count);
            trolley.setProduct(product);
            trolley.setUser(user);
        }else{
            trolley.setCount(count + trolley.getCount());
            trolley.setSubTotal((count+trolley.getCount()) * product.getPriceSale());
        }

        return trolleyRepository.save(trolley);
    }

    @LoginVerify
    @Override
    public void deleteFromTrolley(Long productId,Integer count) {
        Product product = productService.findOne(productId);
        Trolley trolley = new Trolley();
        trolley.setProduct(product);
        trolley.setCount(count);
        trolleyRepository.delete(trolley);
    }

    @Override
    public Trolley findOne(Long trolleyId) {
        return trolleyRepository.findOne(trolleyId);
    }

    @LoginVerify
    @Override
    public List<Trolley> findTrolleyByIdIn(List<Long> trolleyIds) {
        User user = CheckUserLogin.getloginuser();
        return trolleyRepository.findTrolleyByIdInAndUserIdAndStatusIn(trolleyIds,user.getId(),new ArrayList<>(Arrays.asList(Constant.TROLLEYONE,Constant.TROLLEYTWO)));
    }

    @LoginVerify
    @Override
    public List<Trolley> listMyTrolley() {
        User user = CheckUserLogin.getloginuser();
        return trolleyRepository.findTrolleyByUserIdAndStatusIn(user.getId(),status);
    }

    @LoginVerify
    @Override
    public int productCountFromTrolley() {
        User user = CheckUserLogin.getloginuser();
        List<Trolley> trolleyList = trolleyRepository.findTrolleyByUserIdAndStatusIn(user.getId(),status);
        int num = 0;
        for(Trolley trolley : trolleyList)
            num += trolley.getCount();
        return num;
    }
}
