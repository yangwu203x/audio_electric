package com.enter.controller;

import com.enter.entity.Address;
import com.enter.service.IAddressService;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/23 0023 15:36
 */
@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("/addAddress")
    public String addAddress(Address address, HttpServletRequest request){
        addressService.addAddress(address);
        return "redirect:listMyAddress";
    }

    @RequestMapping("/editAddress")
    public String editAddress(Address address, HttpServletRequest request){
        addressService.editAddress(address);
        return "redirect:listMyAddress";
    }

    /**
     * 地址管理
     * @return
     */
    @RequestMapping("/listMyAddress")

    public Object listMyAddress(Model model){
        List<Address> addressList = addressService.listMyAddress();
        model.addAttribute("addressList",addressList);
        return "/account/address";
    }

    @RequestMapping("/findAddressById")
    @ResponseBody
    public Object findAddressById(Long addressId){
        Address address = addressService.findAddressById(addressId);
        return BodyUtil.sucess(address,DataType.Object);
    }

    @RequestMapping("/ajaxMyAddress")
    @ResponseBody
    public Object ajaxMyAddress(){
        List<Address> addressList = addressService.listMyAddress();
        return BodyUtil.sucess(addressList, DataType.Array);
    }

    @RequestMapping("/delAddress")
    @ResponseBody
    public Object delAddress(Long addressId){
        addressService.delAddress(addressId);
        return BodyUtil.result(1);
    }
}
