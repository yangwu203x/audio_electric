package com.enter.controller;

import com.enter.entity.Orders;
import com.enter.entity.SaleService;
import com.enter.entity.StateCount;
import com.enter.service.IOrdersService;
import com.enter.service.ISaleServiceService;
import com.enter.util.SaleServiceState;
import com.enter.util.enums.DataType;
import com.enter.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/11/13 0013 10:52
 */
@Controller
@RequestMapping("/user/service")
public class SaleServiceController {
    @Autowired
    private ISaleServiceService saleServiceService;
    @Autowired
    private IOrdersService ordersService;

    @GetMapping("/view")
    public String findSaleServiceByUser(Model model){
        List<SaleService> saleServices = saleServiceService.findSaleServiceByUser();
        List<StateCount> stateCounts = saleServiceService.getServiceStateCount();
        int dealing = 0;
        for (StateCount stateCount:stateCounts){
            if (SaleServiceState.RECEIVER.equals(stateCount.getState()) || SaleServiceState.HANLDE.equals(stateCount.getState())){
                dealing += stateCount.getNum();
            }else{
                model.addAttribute("saleServiceState"+stateCount.getState(),stateCount.getNum());
            }
        }
        if (dealing != 0)
            model.addAttribute("dealing",dealing);
        model.addAttribute("saleServices",saleServices);
        model.addAttribute("serviceActive","0");
        return "/sale_services/service_after";
    }

    @GetMapping("/view/status/{state}")
    public String findSaleServiceByUserAndState(Model model, @PathVariable("state") String state){
        List<SaleService> saleServices = saleServiceService.findSaleServiceByUserAndState(state);
        List<StateCount> stateCounts = saleServiceService.getServiceStateCount();
        int handling = 0;
        for (StateCount stateCount:stateCounts){
            if (SaleServiceState.RECEIVER.equals(stateCount.getState()) || SaleServiceState.HANLDE.equals(stateCount.getState())){
                handling += stateCount.getNum();
            }else{
                model.addAttribute("saleServiceState"+stateCount.getState(),stateCount.getNum());
            }
        }
        if (handling != 0)
            model.addAttribute("handling",handling);
        model.addAttribute("saleServices",saleServices);
        model.addAttribute("serviceActive",state);
        return "/sale_services/service_after";
    }

    @GetMapping("/view/id/{id}")
    public String getSaleServiceById(@PathVariable("id")Long id,Model model){
        SaleService saleService = saleServiceService.findOne(id);
        model.addAttribute("saleService",saleService);
        return "/sale_services/service_detail";
    }

    @GetMapping("/apply/{orderNum}")
    public String applyForSaleService(@PathVariable("orderNum")String orderNum,Model model){
        Orders orders = ordersService.findOrdersByOrderNum(orderNum);
        model.addAttribute("orders",orders);
        return "/sale_services/apply_service";
    }

    @GetMapping("/view/orderId/{orderId}")
    public String findSaleServiceByOrderId(@PathVariable("orderId")Long orderId,Model model){
        SaleService saleService = saleServiceService.findSaleServiceByOrderId(orderId);
        model.addAttribute("saleService",saleService);
        return "/sale_services/service_detail";
    }

    @PutMapping("/cancer")
    @ResponseBody
    public Object cancerSaleService(Long id){
        saleServiceService.cancerSaleService(id);
        return BodyUtil.success();
    }

    @PostMapping("/add")
    @ResponseBody
    public Object addSaleService(SaleService saleService){
        saleService = saleServiceService.addSaleService(saleService);
        return BodyUtil.success(saleService, DataType.Object,"/user/service/tip/success");
    }

    @GetMapping("/tip/success")
    public String applySuccess(){
        return "/sale_services/apply_success";
    }
}
