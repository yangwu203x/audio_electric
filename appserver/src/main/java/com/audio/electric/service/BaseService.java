package com.audio.electric.service;

import com.audio.electric.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/14 0014 14:27
 */
public class BaseService {
    @Autowired
    private CommonMapper commonMapper;

    /**
     * 包裹点赞、收藏和送礼
     * @param obj
     * @param user_id
     */
    protected void wrapAll(Object obj,Long user_id){
        this.wrapGoods(obj,user_id);
        this.wrapCollections(obj,user_id);
        this.wrapGifts(obj,user_id);
    }

    /**
     * 加上是否点赞
     * @param obj
     * @param user_id
     */
    protected void wrapGoods(Object obj,Long user_id){
        String key = "portfolio_id";
        String name = "goods";
        try {
            Set<Integer> goodsSet = commonMapper.getGoodsById(user_id);
            wrapObj(obj,goodsSet,key,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加上是否收藏
     * @param obj
     * @param user_id
     */
    protected void wrapCollections(Object obj,Long user_id){
        String key = "portfolio_id";
        String name = "collections";
        try {
            Set<Integer> collectionsSet = commonMapper.getCollectionsById(user_id);
            wrapObj(obj,collectionsSet,key,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加上是否送过礼物
     * @param obj
     * @param user_id
     */
    protected void wrapGifts(Object obj,Long user_id){
        String key = "portfolio_id";
        String name = "gifts";
        try {
            Set<Integer> giftsSet = commonMapper.getCollectionsById(user_id);
            wrapObj(obj,giftsSet,key,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 包裹对象
     * @param obj
     * @param set
     * @param name
     */
    private void wrapObj(Object obj,Set set,String key ,String name){
        if(obj instanceof List){
            List<Map> list = (List) obj;
            for (Map temp : list) {
                wrapMap(set,temp,key,name);
            }
        }else if(obj instanceof Map){
            Map temp = (Map) obj;
            wrapMap(set,temp,name,key);
        }
    }

    /**
     * 包裹map
     * @param set
     * @param map
     * @param name
     */
    private void wrapMap(Set set, Map map,String key ,String name){
        if (set.contains(map.get(key)))
            map.put(name, "1");
        else
            map.put(name, "0");
    }


}
