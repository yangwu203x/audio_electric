package com.enter.controller;

import com.enter.entity.Address;
import com.enter.entity.Delivery;
import com.enter.entity.DeliveryMap;
import com.enter.service.IAddressService;
import com.enter.util.CheckUserLogin;
import com.enter.util.Constant;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/23 0023 15:36
 */
@Controller
@RequestMapping("/user/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    /** ================================================add=============================================================*/
    @PostMapping("/add")
    @ResponseBody
    public Object addAddress(Address address){
        address = addressService.addAddress(address);
        return BodyUtil.success(address,DataType.Object);
    }

    /** ================================================del=============================================================*/
    @DeleteMapping("/delete/id/{addressId}")
    @ResponseBody
    public Object delAddress(@PathVariable("addressId") Long addressId){
        addressService.delAddress(addressId);
        return BodyUtil.result(1);
    }

    /** ================================================search=============================================================*/
    /**
     * 地址管理
     * @return
     */
    @GetMapping("/view")
    public Object listMyAddress(Model model){
        List<Address> addressList = addressService.listMyAddress();
        model.addAttribute("addressList",addressList);
        return "/address/address";
    }

    @GetMapping("/view/id/{addressId}")
    @ResponseBody
    public Object findAddressById(@PathVariable("addressId") Long addressId){
        Address address = addressService.findAddressById(addressId);
        return BodyUtil.success(address,DataType.Object);
    }

    /**
     * 设置临时地址
     * @param addressId
     * @return
     */
    @GetMapping("/temporaryAddress/set/id/{addressId}")
    @ResponseBody
    public Object setTemporaryAddress(@PathVariable("addressId")Long addressId){
        Address address = addressService.findAddressById(addressId);
        CheckUserLogin.setDefaultAddress(address);
        return BodyUtil.success(address,DataType.Object);
    }

    /** ================================================modify=============================================================*/
    /**
     * 修改地址
     * @param addressId
     * @param request
     * @return
     */
    @PutMapping("/defaultAddress/modify/id/{addressId}")
    @ResponseBody
    public Object setDefaultAddress(@PathVariable("addressId") Long addressId,HttpServletRequest request){
        Address address = addressService.setDefaultAddress(addressId);
        return BodyUtil.success(address,DataType.Object);
    }

    /**
     * 修改默认地址
     * @param address
     * @param request
     * @return
     */
    @PutMapping("/modify")
    @ResponseBody
    public Object editAddress( Address address,HttpServletRequest request){
        addressService.editAddress(address);
        return BodyUtil.success();
    }

    @GetMapping("/deliveryId/{deliveryId}")
    public String getDeliveryInfo(@PathVariable("deliveryId") String deliveryId,Model model){

        List<Delivery> deliveryList = new ArrayList<>();
        DeliveryMap deliveryMap1 = new DeliveryMap("2017-09-19","15:07:32" ,"深圳市【深圳西乡分部】，【郭太松】正在派件");
        DeliveryMap deliveryMap2 = new DeliveryMap("2017-09-19","15:07:32" ,"深圳市【深圳转运中心】，正发往【深圳西乡分部】");
        DeliveryMap deliveryMap3 = new DeliveryMap("2017-09-19","15:07:32" ," 到深圳市【深圳转运中心】");
        DeliveryMap deliveryMap4 = new DeliveryMap("2017-09-19","15:07:32" ," 到深圳市【深圳转运中心】");
        Delivery delivery1 = new Delivery("2017-09-19", "周二" );
        delivery1.getDeliveryMaps().add(deliveryMap1);
        delivery1.getDeliveryMaps().add(deliveryMap2);
        delivery1.getDeliveryMaps().add(deliveryMap3);
        delivery1.getDeliveryMaps().add(deliveryMap4);
        DeliveryMap deliveryMap21 = new DeliveryMap("2017-09-18","15:07:32" ,"深圳市【深圳西乡分部】，【郭太松】正在派件");
        DeliveryMap deliveryMap22 = new DeliveryMap("2017-09-18","15:07:32" ,"深圳市【深圳转运中心】，正发往【深圳西乡分部】");
        DeliveryMap deliveryMap23 = new DeliveryMap("2017-09-18","15:07:32" ," 到深圳市【深圳转运中心】");
        DeliveryMap deliveryMap24 = new DeliveryMap("2017-09-18","15:07:32" ," 到深圳市【深圳转运中心】");
        Delivery delivery2 = new Delivery("2017-09-18", "周三" );
        delivery2.getDeliveryMaps().add(deliveryMap21);
        delivery2.getDeliveryMaps().add(deliveryMap22);
        delivery2.getDeliveryMaps().add(deliveryMap23);
        delivery2.getDeliveryMaps().add(deliveryMap24);
        deliveryList.add(delivery1);
        deliveryList.add(delivery2);
        Map map = new HashMap();
        map.put("deliveryNo","70091320298476");
        map.put("deliveryName","顺丰快递");
        map.put("deliveryList",deliveryList);
        model.addAttribute("map",map);
        return "/delivery/delivery_info";
    }

}
