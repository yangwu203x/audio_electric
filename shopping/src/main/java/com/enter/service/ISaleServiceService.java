package com.enter.service;

import com.enter.entity.SaleService;
import com.enter.entity.StateCount;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/13 0013 10:54
 */
public interface ISaleServiceService {

    List<SaleService> findSaleServiceByUser();

    SaleService findOne(Long id);

    List<StateCount> getServiceStateCount();

    List<SaleService> findSaleServiceByUserAndState(String state);

    SaleService addSaleService(SaleService saleService);

    SaleService findSaleServiceByOrderId(Long orderNum);

    void cancerSaleService(Long id);
}
