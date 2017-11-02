package com.enter.shopping;

import com.enter.entity.*;
import com.enter.service.IAddressService;
import com.enter.service.IOrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private IAddressService addressService;

    @Test
    public void saveAddress(){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setProvinceId("440000");
        addressInfo.setProvince("北京");
        addressInfo.setCityId("440300");
        addressInfo.setCity("北京");
        addressInfo.setAreaId("440306");
        addressInfo.setArea("丰台区");
        addressInfo.setDetailPosition("叮叮当但");
        Address address = new Address();
        address.setAddressInfo(addressInfo);
        User user = new User();
        user.setId(1l);
        address.setUser(user);
        address.setName("曾敏");
        address.setTel("1314554525");
        addressService.addAddress(address);
    }

    @Test
    public void updateAddress(){
        Address address = addressService.findAddressById(2l);
        AddressInfo addressInfo = address.getAddressInfo();
        addressInfo.setArea("宝安区");
        addressInfo.setAreaId("440306");
        address.setAddressInfo(addressInfo);
        addressService.addAddress(address);
    }

}
