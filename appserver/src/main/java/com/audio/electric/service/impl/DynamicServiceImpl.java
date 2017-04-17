package com.audio.electric.service.impl;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.mapper.DynamicMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IDynamicService;
import com.audio.electric.util.annotation.UserPage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.tool.CheckUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 14:13
 */
@Component
public class DynamicServiceImpl extends BaseService implements IDynamicService{
    @Autowired
    private DynamicMapper dynamicMapper;

    @UserPage
    @Override
    public List<Map<String, String>> listDynamicInfo(String type) {
        CookieUser user = CheckUserLogin.getloginuser();
        List<Map<String, String>> listMap = null;
        if("0".equals(type)){
            //关注的人
            try {
                listMap = dynamicMapper.listAttention(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if ("1".equals(type)){
            //推荐的人
            try {
                listMap = dynamicMapper.listRecommendDynamic(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            throw new AppException(RetCode.PARAMETER_ERROR);
        }
        wrapAll(listMap,user.getId());
        return listMap;
    }

    @Override
    public Map<String, String> getPortfolioInfo(Long portfolio_id) {
        Map<String, String> map = null;
        try {
            //动态详情
            map = dynamicMapper.getPortfolioInfo(portfolio_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @UserPage
    @Override
    public List<Map<String, String>> getCommentsById(Long id) {
        List<Map<String, String>> list = null;
        try {
            list = dynamicMapper.getCommentsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
