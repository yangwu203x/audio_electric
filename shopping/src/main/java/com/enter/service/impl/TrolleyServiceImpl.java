package com.enter.service.impl;

import com.enter.annotations.LoginVerifyJson;
import com.enter.annotations.LoginVerifyPage;
import com.enter.entity.Product;
import com.enter.entity.Property;
import com.enter.entity.Trolley;
import com.enter.entity.User;
import com.enter.exception.ShoppingException;
import com.enter.repository.ProductRepository;
import com.enter.repository.PropertyRepository;
import com.enter.repository.TrolleyRepository;
import com.enter.service.IProductService;
import com.enter.service.ITrolleyService;
import com.enter.util.*;
import com.enter.util.enums.RetCode;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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
    private ProductRepository productRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    @LoginVerifyJson
    public Trolley addToTrolley(Long productId,Integer count,String colorNo,String series) {
        if (productId == null || count == null || colorNo == null)
            throw new ShoppingException(RetCode.PARAMETER_ERROR);
        User user = CheckUserLogin.getloginuser();
        //判断库存够不够
        Property property = propertyRepository.findPropertyByProductIdAndColorNo(productId,colorNo);
        Product product = productRepository.findOne(productId);
        //判断产品id对应的产品是否存在
        if (property == null || product == null)
            throw new ShoppingException(RetCode.PRODUCTNOTEXIST);
        //判断库存是否足够
        if (property.getNum() < count)
            throw new ShoppingException(RetCode.PRODUCTNOTENOUGH);
        Trolley trolley = trolleyRepository.findTrolleyByUserIdAndProductAndStatusIn(user.getId(),product,Arrays.asList(TrolleyState.NORELATED,TrolleyState.RELATEDSHOW));
        if (trolley == null){
            if (series == null)
                throw new ShoppingException(RetCode.PARAMETER_ERROR,RetCode.PARAMETER_ERROR+",套餐不能为空");
            trolley = new Trolley();
            trolley.setSeries(series);
            trolley.setColorName(property.getColorName());
            trolley.setPropertyId(property.getId());
            trolley.setCount(count);
            trolley.setSubTotal(product.getPriceSale()*count);
            trolley.setProduct(product);
            trolley.setUser(user);
            trolley.setDateStr(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
        }else{
            trolley.setCount(count + trolley.getCount());
            trolley.setSubTotal(trolley.getCount() * product.getPriceSale());
        }

        return trolleyRepository.save(trolley);
    }

    @LoginVerifyJson
    @Override
    public void deleteFromTrolley(Long trolleyId) {
        User user = CheckUserLogin.getloginuser();
        int result = trolleyRepository.deleteTrolleyByIdAndUser(trolleyId,user);
        if (result < 1)
            throw new ShoppingException(RetCode.UNKNOWN_ERROR);
    }

    @Override
    public Trolley findOne(Long trolleyId) {
        return trolleyRepository.findOne(trolleyId);
    }

    @LoginVerifyPage
    @Override
    public List<Trolley> findTrolleyByIdIn(List<Long> trolleyIds) {
        User user = CheckUserLogin.getloginuser();
        return trolleyRepository.findTrolleyByIdInAndUserIdAndStatusIn(trolleyIds,user.getId(),Arrays.asList(TrolleyState.NORELATED,TrolleyState.RELATEDSHOW));
    }

    @LoginVerifyPage
    @Override
    public List<Trolley> listMyTrolley() {
        User user = CheckUserLogin.getloginuser();
        return trolleyRepository.findTrolleyByUserIdAndStatusIn(user.getId(),Arrays.asList(TrolleyState.NORELATED,TrolleyState.RELATEDSHOW));
    }

    @LoginVerifyJson
    @Override
    public String getTrolleyNum() {
        User user = CheckUserLogin.getloginuser();
        return trolleyRepository.getTrolleyNum(user);
    }

    @Override
    @LoginVerifyJson
    public void bacthDeleteFromTrolley(String trolleyIds) {
        User user = CheckUserLogin.getloginuser();
        List<Long> trolleyIdList = getLongs(trolleyIds);
        for (Long trolleyId: trolleyIdList){
            int result = trolleyRepository.deleteTrolleyByIdAndUser(trolleyId,user);
            if (result < 1)
                throw new ShoppingException(RetCode.UNKNOWN_ERROR);
        }
    }

    private List<Long> getLongs(String trolleyIds) {
        List<Long> trolleyIdList =  new ArrayList<>();
        String[] trolleyIdArr = trolleyIds.split(",");
        for(String trolleyId : trolleyIdArr){
            trolleyIdList.add(Long.parseLong(trolleyId));
        }
        return trolleyIdList;
    }
}
