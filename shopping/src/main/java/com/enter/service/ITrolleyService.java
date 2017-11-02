package com.enter.service;

import com.enter.annotations.LoginVerify;
import com.enter.entity.Trolley;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/23 0023 9:32
 */
public interface ITrolleyService {

    Trolley addToTrolley(Long productId,Integer count);

    void deleteFromTrolley(Long productId,Integer count);

    Trolley findOne(Long trolleyId);

    List<Trolley> findTrolleyByIdIn(List<Long> trolleyIds);

    List<Trolley> listMyTrolley();

    int productCountFromTrolley();
}
