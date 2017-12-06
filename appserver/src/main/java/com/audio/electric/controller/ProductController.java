package com.audio.electric.controller;

import com.audio.electric.domain.Product;
import com.audio.electric.service.IProductService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/29 0029 15:16
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/getExpiryDateBySerialNo",produces = {"application/json;charset=utf-8"})
    public Object getExpiryDateBySerialNo(String serialNo){
        Product product = productService.getExpiryDateBySerialNo(serialNo);
        return BodyUtil.sucess(product, DataType.Object);
    }
}
