package com.audio.electric.controller;

import com.audio.electric.service.IDynamicService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 动态controller类
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 13:28
 */
@RestController
public class DynamicController extends BaseController{
    @Autowired
    private IDynamicService dynamicService;

    /**
     * 动态主页信息
     * @param type 0:关注的人的动态；1：推荐的人的动态
     * @throws IOException
     */
    @RequestMapping("/dynamicInfo")
    @ResponseBody
    public String dynamicInfo(String type) throws IOException {
        List<Map<String, String>> listDynamic = dynamicService.listDynamicInfo(type);
        return BodyUtil.sucess(listDynamic,DataType.Array).toString();
    }

    /**
     * 单个作品信息
     * @param portfolio_id
     * @throws IOException
     */
    @GetMapping("/getPortfolioInfo")
    @ResponseBody
    public String getPortfolioInfo(Long portfolio_id)  {
        Map<String,String> portfolio = dynamicService.getPortfolioInfo(portfolio_id);
        return BodyUtil.sucess(portfolio,DataType.Object).toString();
    }

    /**
     * 根据作品id查询作品的评论信息
     * @param portfolio_id
     * @return
     */
    public String getCommentsById(Long portfolio_id){
        List<Map<String, String>> listComments = dynamicService.getCommentsById(portfolio_id);
        return BodyUtil.sucess(listComments,DataType.Array).toString();
    }
}
