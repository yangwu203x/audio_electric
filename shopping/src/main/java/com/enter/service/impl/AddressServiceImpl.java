package com.enter.service.impl;

import com.enter.annotations.LoginVerify;
import com.enter.entity.Address;
import com.enter.entity.User;
import com.enter.exception.PageException;
import com.enter.exception.ShoppingException;
import com.enter.repository.AddressRepository;
import com.enter.service.IAddressService;
import com.enter.util.CheckUserLogin;
import com.enter.util.Constant;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/21 0021 9:42
 */
@Transactional
@Component
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @LoginVerify
    public Address addAddress(Address address) {
        //判断是否登录
        User user = CheckUserLogin.getloginuser();
        address.setUser(user);
        return addressRepository.save(address);
    }

    @LoginVerify
    @Override
    public Address findAddressById(Long addressId) {
        return addressRepository.findOne(addressId);
    }

    @LoginVerify
    @Override
    public List<Address> listMyAddress() {
        User user = CheckUserLogin.getloginuser();
        return addressRepository.findAddressByUserId(user.getId());
    }

    @LoginVerify
    @Override
    public void editAddress(Address address) {
        User user = CheckUserLogin.getloginuser();
        Address perAddress = addressRepository.findAddressByUserAndId(user,address.getId());
        if (perAddress == null)
            throw new PageException(RetCode.UNKNOWN_ERROR);
        perAddress.setName(address.getName());
        perAddress.setTel(address.getTel());
        perAddress.setAddressInfo(address.getAddressInfo());
        addressRepository.save(perAddress);
    }


    @Override
    public Address findAddressByUserAndSelected(User user, Integer selected) {
        return addressRepository.findAddressByUserAndSelected(user,selected);
    }

    @Override
    public void delAddress(Long addressId) {
        try{
            addressRepository.delete(addressId);
        }catch (ShoppingException e){
            throw new ShoppingException(RetCode.UNKNOWN_ERROR);
        }
    }
}
