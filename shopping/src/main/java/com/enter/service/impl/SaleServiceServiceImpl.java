package com.enter.service.impl;

import com.enter.annotations.LoginVerifyJson;
import com.enter.annotations.LoginVerifyPage;
import com.enter.entity.Orders;
import com.enter.entity.SaleService;
import com.enter.entity.StateCount;
import com.enter.entity.User;
import com.enter.exception.PageException;
import com.enter.exception.ShoppingException;
import com.enter.repository.OrdersRepository;
import com.enter.repository.SaleServiceRepository;
import com.enter.service.ISaleServiceService;
import com.enter.util.*;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/13 0013 10:55
 */
@Transactional
@Component
public class SaleServiceServiceImpl implements ISaleServiceService {


    @Autowired
    private SaleServiceRepository saleServiceRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @LoginVerifyPage
    @Override
    public List<SaleService> findSaleServiceByUser() {
        User user = CheckUserLogin.getloginuser();
        List<SaleService> saleServiceList = saleServiceRepository.findSaleServiceByUser(user);
        return saleServiceList;
    }

    @LoginVerifyPage
    @Override
    public SaleService findOne(Long id) {
        return saleServiceRepository.findOne(id);
    }

    @Override
    @LoginVerifyPage
    public List<StateCount> getServiceStateCount() {
        User user = CheckUserLogin.getloginuser();
        return saleServiceRepository.getServiceStateCount(user);
    }

    @Override
    @LoginVerifyPage
    public List<SaleService> findSaleServiceByUserAndState(String state) {
        User user = CheckUserLogin.getloginuser();
        List<SaleService> saleServiceList = null;
        if (SaleServiceState.RECEIVER.equals(state))
            return saleServiceRepository.findSaleServiceByUserAndState(user,SaleServiceState.RECEIVER,SaleServiceState.HANLDE);
        else
            return saleServiceRepository.findSaleServiceByUserAndState(user,state);
    }

    @Override
    @LoginVerifyJson
    public SaleService addSaleService(SaleService saleService) {
        User user = CheckUserLogin.getloginuser();
        Orders orders = ordersRepository.findOrdersByUserAndIdAndOrderState(user,saleService.getOrders().getId(), OrdersState.SUCCESS);
        if (orders == null)
            throw new ShoppingException(RetCode.ORDERNUMNOTEXIST);
        orders.setOrderState(OrdersState.CLOSED);
        ordersRepository.save(orders);
        saleService.setState(SaleServiceState.UNCHECK);
//        String saleServiceNum = DateUtil.getCurDate("sh"+DateStyle.YYYYMMDDHHMMSS.getValue()) + user.getId() + StringUtils.getRandom(6);
        saleService.setSubmitTime(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
        return saleServiceRepository.save(saleService);
    }

    @Override
    @LoginVerifyPage
    public SaleService findSaleServiceByOrderId(Long orderId) {
        User user = CheckUserLogin.getloginuser();
        return saleServiceRepository.findSaleServiceByOrdersAndUser(orderId,user.getId());
    }

    @Override
    @LoginVerifyJson
    public void cancerSaleService(Long id) {
        User user = CheckUserLogin.getloginuser();
        SaleService saleService = saleServiceRepository.findSaleServiceByIdAndUser(id,user.getId());
        if (saleService == null)
            throw new ShoppingException(RetCode.SERVICECANCERFAILED);
        saleService.setState("6");
        saleService.setSuccessTime(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
        saleServiceRepository.save(saleService);
    }
}
