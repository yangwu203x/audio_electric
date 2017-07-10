package com.audio.electric.controller;

import com.audio.electric.domain.Product;
import com.audio.electric.domain.User;
import com.audio.electric.service.IUpdateService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 16:26
 */
@RestController
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    private IUpdateService updateService;
    public Object getExpiryDate(String mac){
        Product product = updateService.getExpiryDate(mac);
        return BodyUtil.sucess(product, DataType.Object);
    }
}
