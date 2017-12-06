package com.audio.electric.service;

import com.audio.electric.domain.Product;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/29 0029 15:17
 */
public interface IProductService {
    Product getExpiryDateBySerialNo(String serialNo);
}
