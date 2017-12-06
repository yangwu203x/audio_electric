package com.enter.service.impl;

import com.enter.annotations.LoginVerifyJson;
import com.enter.annotations.LoginVerifyPage;
import com.enter.entity.*;
import com.enter.exception.PageException;
import com.enter.exception.ShoppingException;
import com.enter.repository.OrdersRepository;
import com.enter.repository.ProductRepository;
import com.enter.repository.PropertyRepository;
import com.enter.repository.TrolleyRepository;
import com.enter.service.IAddressService;
import com.enter.service.IOrdersService;
import com.enter.util.*;
import com.enter.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.DateUtils;

import java.util.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/19 0019 16:41
 */
@Transactional
@Component
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private TrolleyRepository trolleyRepository;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Orders saveOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrdersById(Long ordersId) {
        return ordersRepository.getOrdersById(ordersId);
    }


    @LoginVerifyPage
    @Override
    public List<Trolley> addAllToOrderDetail(String trolleyIds) {
        User user = CheckUserLogin.getloginuser();
        List<Long> trolleyIdList = getLongs(trolleyIds);
        //挑出需要添加的购物车状态
        List<Trolley> trolleys = trolleyRepository.findTrolleyByIdInAndUserIdAndStatus(trolleyIdList,user.getId(), TrolleyState.NORELATED);
        for (Trolley trolley:trolleys){
            trolley.setStatus(TrolleyState.RELATEDSHOW);
            trolleyRepository.save(trolley);
        }
        trolleys = trolleyRepository.findTrolleyByIdInAndUserIdAndStatus(trolleyIdList,user.getId(), TrolleyState.RELATEDSHOW);
        return trolleys;
    }

    private List<Long> getLongs(String trolleyIds) {
        List<Long> trolleyIdList =  new ArrayList<>();
        String[] trolleyIdArr = trolleyIds.split(",");
        for(String trolleyId : trolleyIdArr){
            trolleyIdList.add(Long.parseLong(trolleyId));
        }
        return trolleyIdList;
    }

    @LoginVerifyPage
    @Override
    public List<Orders> listMyOrder(String orderState) {
        User user = CheckUserLogin.getloginuser();
        if (orderState == null){
            //默认是待付款
            orderState = OrdersState.UNPAID;
        }
        //查询全部
        if (OrdersState.ALL.equals(orderState)){
            return ordersRepository.findOrderByUserOrderByOrderStateAsc(user);
        }else if(OrdersState.PAID.equals(orderState)){
            //查询2-4的状态
            return ordersRepository.findOrderByUserAndOrderStateIn(user,Arrays.asList(OrdersState.PAID,OrdersState.CHECKED,OrdersState.SEND_OUT));
        }
        List<Orders> orders = ordersRepository.findOrderByUserAndOrderState(user,orderState);
        return orders;
    }

    @LoginVerifyPage
    @Override
    public List<Trolley> listMyTrolleyTrolleyId(String trolleyIds) {
        User user = CheckUserLogin.getloginuser();
        List<Long> trolleyIdList = getLongs(trolleyIds);
        List<Trolley> trolleyList = trolleyRepository.findTrolleyByIdInAndUserIdAndStatusIn(trolleyIdList,user.getId(),new ArrayList<>(Arrays.asList(TrolleyState.RELATEDSHOW,TrolleyState.RELATEDHIDE)));
        return trolleyList;
    }

    @LoginVerifyPage
    @Override
    public Orders generatedTotalOrder(String trolleyIds, Long addressId) {
        User user = CheckUserLogin.getloginuser();
        List<Long> trolleyIdList = getLongs(trolleyIds);
        List<Integer> status = new ArrayList<>(Arrays.asList(TrolleyState.NORELATED,TrolleyState.RELATEDSHOW,TrolleyState.RELATEDHIDE));
        Set<Trolley> trolleySet = trolleyRepository.findTrolleyByIdInAndStatusIn(trolleyIdList,status);
        Address address = addressService.findAddressById(addressId);
        Double price = new Double(0);
        for (Trolley trolley : trolleySet){
            price += trolley.getSubTotal();
            trolley.setStatus(TrolleyState.RELATEDORDERS);
            trolleyRepository.save(trolley);
        }
        Orders orders = generatedOrders(user, trolleySet, address, price);
        return ordersRepository.save(orders);
    }

    private Orders generatedOrders(User user, Set<Trolley> trolleySet, Address address, Double price) {
        //遍历检查每样东西库存是否足够
        List<Long> propertyIdList = new ArrayList<>();
        Map<Long,Integer> map = new HashMap<>();
        for (Trolley trolley:trolleySet){
            propertyIdList.add(trolley.getPropertyId());
            map.put(trolley.getPropertyId(),trolley.getCount());
        }

        Set<Property> propertySet = propertyRepository.findPropertyByIdIn(propertyIdList);

        for (Property property:propertySet){
            if (map.get(property.getId()) > property.getNum()){
                throw new ShoppingException(RetCode.PRODUCTNOTENOUGH,"颜色为："+property.getColorName()+"产品id为"+property.getProductId()+"库存不够");
            }
        }

        Orders orders = new Orders();
        orders.setGenerateTime(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
        orders.setSimpleAddress(address.getDetailPosition());
        orders.setPrice(price);
        orders.setTel(address.getTel());
        orders.setProvinceId(address.getProvinceId());
        orders.setCityId(address.getCityId());
        orders.setAreaId(address.getAreaId());
        orders.setUser(user);
        orders.setLeftTime(System.currentTimeMillis()+72*60*60*1000);
        orders.setRecipients(address.getName());
        //订单编号：ddyyyyMMddHHmmss+userId+6位随机数
        String ordersNum = DateUtil.getCurDate("dd"+DateStyle.YYYYMMDDHHMMSS.getValue()) + user.getId() + StringUtils.getRandom(6);
        orders.setOrderNum(ordersNum);
        orders.setOrderState(OrdersState.UNPAID);
        orders.setAddress(address.getAbsoluteAddress());
        orders.setTrolleys(trolleySet);
        return orders;
    }

    @Override
    @LoginVerifyPage
    public Orders findOrdersByOrderNum(String ordersId) {
        User user = CheckUserLogin.getloginuser();
        Orders orders = ordersRepository.findOrdersByOrderNumAndUser(ordersId,user);
        if (orders==null)
            throw new PageException(RetCode.ORDERNUMNOTEXIST);
        return orders;

    }

    @LoginVerifyPage
    @Override
    public Orders findOrderById(Long orderId) {
        User user = CheckUserLogin.getloginuser();
        return ordersRepository.findOrdersByIdAndUser(orderId,user);
    }


    @LoginVerifyPage
    @Override
    public List<StateCount> getOrdersStateCount(){
        User user = CheckUserLogin.getloginuser();
        return ordersRepository.getOrdersStateCount(user);
    }

    @Override
    @LoginVerifyJson
    public void cancerOrders(String orderNum) {
        User user = CheckUserLogin.getloginuser();
        Orders orders = ordersRepository.findOrdersByUserAndOrderNumAndOrderState(user,orderNum,OrdersState.UNPAID);
        String closeTime = DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
        orders.setCloseTime(closeTime);
        orders.setOrderState(OrdersState.CLOSED);
        ordersRepository.save(orders);
    }

    @Override
    @LoginVerifyJson
    public Trolley nowBuy(Long productId,Integer count,String colorNo,String series) {
        if (productId == null || count == null || colorNo == null || series == null)
            throw new ShoppingException(RetCode.PARAMETER_ERROR);
        User user = CheckUserLogin.getloginuser();
        Property property = propertyRepository.findPropertyByProductIdAndColorNo(productId,colorNo);
        Product product = productRepository.findOne(productId);
        //判断产品id对应的产品是否存在
        if (property == null || product == null)
            throw new ShoppingException(RetCode.PRODUCTNOTEXIST);
        //判断库存是否足够
        if (property.getNum() < count)
            throw new ShoppingException(RetCode.PRODUCTNOTENOUGH);
        //看看购物车中有没有
        Trolley trolley = trolleyRepository.findTrolleyByUserAndProductAndStatus(user,product,TrolleyState.RELATEDHIDE);
        if (trolley == null){
            //加入购物车
            trolley = new Trolley();
            trolley.setSeries(series);
            trolley.setPropertyId(property.getId());
            trolley.setColorName(property.getColorName());
            trolley.setCount(count);
            trolley.setSubTotal(product.getPriceSale()*count);
            trolley.setProduct(product);
            trolley.setStatus(TrolleyState.RELATEDHIDE);
            trolley.setDateStr(DateUtil.getCurDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
            trolley.setUser(user);
            trolley = trolleyRepository.save(trolley);
            return  trolley;
        }
        trolley.setSeries(series);
        //不为空
        return trolley;
    }
}
