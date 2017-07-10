package com.audio.electric.service.impl;

import com.audio.electric.domain.Product;
import com.audio.electric.mapper.UpdateMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 16:29
 */
@Component
public class UpdateServiceImpl extends BaseService implements IUpdateService {
    @Autowired
    private UpdateMapper updateMapper;
    @Override
    public Product getExpiryDate(String mac) {
        Product product = updateMapper.getExpiryDate(mac);
        return product;
    }
}
