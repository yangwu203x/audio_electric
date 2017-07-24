package com.audio.electric.service;


import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 13:29
 */
public interface IDynamicService {

    List<Map<String , String>> listDynamicInfo(String type);

    Map<String,String> getPortfolioInfo(Long portfolio_id);

    List<Map<String,String>> getCommentsById(Long id);
}
