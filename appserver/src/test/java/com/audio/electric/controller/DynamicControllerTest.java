package com.audio.electric.controller;

import com.alibaba.fastjson.JSONObject;
import com.audio.electric.AppserverApplicationTests;
import com.audio.electric.domain.User;
import com.audio.electric.service.IDynamicService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.CheckUserLogin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 14:07
 */
public class DynamicControllerTest extends AppserverApplicationTests{

    @Test
    public void getPortfolioInfo() throws Exception {
        Long portfolio_id = 1l;
        Map<String,String> portfolio = dynamicService.getPortfolioInfo(portfolio_id);
        System.out.println(BodyUtil.sucess(portfolio, DataType.Array).toString());
    }

    @Test
    public void getCommentsById() throws Exception {
        Long portfolio_id = 1l;
        List<Map<String, String>> listComments = dynamicService.getCommentsById(portfolio_id);
        System.out.println(BodyUtil.sucess(listComments, DataType.Array).toString());
    }

    @Autowired
    private IDynamicService dynamicService;

    @Test
    public void dynamicInfo() throws Exception {
        User u = new User();
        u.setId(1l);
        u.setLevel(1);
        CheckUserLogin.doLogin(u);
        String type = "0";
        List<Map<String, String>> listDynamic = dynamicService.listDynamicInfo(type);
        System.out.println("<>" + JSONObject.toJSON(listDynamic).toString());
        System.out.println(BodyUtil.sucess(listDynamic, DataType.Array).toString());
    }

    @Test
    public void portfolioInfo() throws Exception {
        Map map = dynamicService.getPortfolioInfo(1l);
        System.out.println("<>" + JSONObject.toJSON(map).toString());
    }

}