package com.enter.service;

import com.enter.entity.Address;
import com.enter.entity.User;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/21 0021 9:42
 */
public interface IAddressService {

    Address addAddress(Address address);

    Address findAddressById(Long addressId);

    List<Address> listMyAddress();

    void editAddress(Address address);


    Address findAddressByUserAndSelected(User user, Integer selected);

    void delAddress(Long addressId);
}
