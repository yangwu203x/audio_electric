package com.audio.electric.service.impl;

import com.audio.electric.domain.Product;
import com.audio.electric.mapper.ProductMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/29 0029 15:18
 */
@Component
public class ProductServiceImpl extends BaseService implements IProductService{
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getExpiryDateBySerialNo(String serialNo) {
        try {
            return productMapper.getExpiryDateBySerialNo(serialNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
