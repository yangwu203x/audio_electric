package com.enter.service.impl;

import com.enter.annotations.LoginVerifyJson;
import com.enter.annotations.LoginVerifyPage;
import com.enter.entity.Address;
import com.enter.entity.User;
import com.enter.exception.ShoppingException;
import com.enter.repository.AddressRepository;
import com.enter.service.IAddressService;
import com.enter.util.CheckUserLogin;
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
    public Address addAddress(Address address) {
        //判断是否登录
        User user = CheckUserLogin.getloginuser();
        if (user == null)
            throw new ShoppingException(RetCode.UNLOGINED);
        address.setUser(user);
        //设置完整地址
        address.setAbsoluteAddress(address.getProvince()+address.getCity()+address.getArea()+address.getDetailPosition());
        address = addressRepository.save(address);
        if ("1".equals(address.getSelected()))
            setDefaultAddress(user,address);
        return address;
    }


    @Override
    public Address findAddressById(Long addressId) {
        User user = CheckUserLogin.getloginuser();
        if (user == null)
            throw new ShoppingException(RetCode.UNLOGINED);
        return addressRepository.findOne(addressId);
    }

    @LoginVerifyPage
    @Override
    public List<Address> listMyAddress() {
        User user = CheckUserLogin.getloginuser();
        return addressRepository.findAddressByUserId(user.getId());
    }

    @LoginVerifyJson
    @Override
    public void editAddress(Address address) {
        User user = CheckUserLogin.getloginuser();
        Address perAddress = addressRepository.findAddressByUserAndId(user,address.getId());
        perAddress.setName(address.getName());
        perAddress.setTel(address.getTel());
        perAddress.setSelected(address.getSelected());
        perAddress.setAbsoluteAddress(address.getProvince()+address.getCity()+address.getArea()+address.getDetailPosition());
        addressRepository.save(perAddress);
        if ("1".equals(address.getSelected()))
            setDefaultAddress(user,address);
    }


    @Override
    public Address findAddressByUserAndSelected(User user, String selected) {
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

    @LoginVerifyJson
    @Override
    public Address setDefaultAddress(Long addressId) {
        User user = CheckUserLogin.getloginuser();
        Address address = addressRepository.findAddressByUserAndId(user,addressId);
        setDefaultAddress(user,address);
        return address;
    }


    public void setDefaultAddress(User user, Address address) {
        addressRepository.updateAllSelected(user);
        addressRepository.updateSelectedByUserAndId(user,address.getId());
        CheckUserLogin.setDefaultAddress(address);
    }


}
