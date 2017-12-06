package com.enter.shopping;

import com.enter.entity.*;
import com.enter.repository.AddressRepository;
import com.enter.service.IAddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;



/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 18:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private IAddressService addressService;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    @Transactional
    public void updateSelected(){
        User user  = new User();
        user.setId(1l);
        addressRepository.updateAllSelected(user);
    }

    @Test
    public void saveAddress(){
        Address address = new Address();
        address.setAbsoluteAddress("00000");
        address.setDetailPosition("dsdfdsdf");
        address.setProvinceId("440000");
        address.setCityId("440300");
        address.setAreaId("440306");
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
        addressService.addAddress(address);
    }

}
