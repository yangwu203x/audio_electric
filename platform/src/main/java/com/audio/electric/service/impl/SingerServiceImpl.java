package com.audio.electric.service.impl;

import com.audio.electric.domain.Singer;
import com.audio.electric.domain.SingerExample;
import com.audio.electric.mapper.SingerMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.ISingerService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/3 0003 10:20
 */
@Component
public class SingerServiceImpl extends BaseService implements ISingerService{
    @Autowired
    private SingerMapper singerMapper;
    @UsePage
    @Override
    public List<Singer> listSinger(Singer singer) {
        SingerExample singerExample = new SingerExample();
        SingerExample.Criteria criteria = singerExample.or();
        if (StringUtils.isNotNull(singer.getSingerName()))
            criteria.andSingerNameLike("%"+singer.getSingerName()+"%");
        if (singer.getSingerType() != null && singer.getSingerType() != "-1")
            criteria.andSingerTypeEqualTo(singer.getSingerType());
        List<Singer> singerList = null;
        try {
            singerList = singerMapper.selectByExample(singerExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singerList;
    }

    @Override
    public Singer getSinger(Singer singer) {
        try {
            singer = singerMapper.selectByPrimaryKey(singer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singer;
    }

    @Override
    public int addSinger(Singer singer) {
        int result = RetCode.FAILED.getCode();
        try {
            result = singerMapper.insertSelective(singer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateSinger(Singer singer) {
        int result = RetCode.FAILED.getCode();
        SingerExample singerExample = new SingerExample();
        singerExample.or().andIdEqualTo(singer.getId());
        try {
            result = singerMapper.updateByExampleSelective(singer,singerExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteSinger(String ids) {
        int result = RetCode.FAILED.getCode();
        try {
            SingerExample singerExample = new SingerExample();
            SingerExample.Criteria criteria = singerExample.or();
            criteria.andIdIn(getIdListInt(ids));
            result = singerMapper.deleteByExample(singerExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateStatus(Singer singer) {
        int result = RetCode.FAILED.getCode();
        try {
            SingerExample singerExample = new SingerExample();
            singerExample.or().andIdEqualTo(singer.getId());
            singer.setStatus("1");
            result = singerMapper.updateByExampleSelective(singer,singerExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> autoSearch(Singer singer) {
        List<Singer> singerList = null;
        List<String> nameList= new ArrayList<>();
        try {
            SingerExample singerExample = new SingerExample();
            SingerExample.Criteria criteria = singerExample.or();
            criteria.andSingerNameLike("%"+singer.getSingerName()+"%");
            singerList = singerMapper.selectByExample(singerExample);
            for (Singer temp : singerList)
                nameList.add(temp.getSingerName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameList;
    }

    @Override
    public List<Map<String,String>> findIdByName(Singer singer) {
        List<Map<String,String>> idList = new ArrayList<>();
        SingerExample singerExample = new SingerExample();
        SingerExample.Criteria criteria = singerExample.or();

        criteria.andSingerNameLike("%"+singer.getSingerName()+"%");
        SingerExample.Criteria criteria2 = singerExample.or();
        try {
            List<Singer> singerList = singerMapper.selectByExample(singerExample);

            wrapSingerJson(idList, singerList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }

    @Override
    public List<Map<String,String>> findIdById(String ids) {
        List<Map<String,String>> idList = new ArrayList<>();
        SingerExample singerExample = new SingerExample();
        SingerExample.Criteria criteria = singerExample.or();
        List<Integer> list = getIdListInt(ids);
        criteria.andIdIn(list);
        SingerExample.Criteria criteria2 = singerExample.or();
        try {
            List<Singer> singerList = singerMapper.selectByExample(singerExample);

            wrapSingerJson(idList, singerList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }

    @Override
    public void addOrUpdateSinger(Singer singer) {
        System.out.println(singer.toString());
        SingerExample singerExample = new SingerExample();
        singerExample.or().andSingerNameEqualTo(singer.getSingerName());
        try {
            List<Singer> singerList = singerMapper.selectByExample(singerExample);
            if (singerList != null && singerList.size() == 1){
                singer.setId(singerList.get(0).getId());
                singerMapper.updateByPrimaryKey(singer);
            }else{
                singerMapper.insertSelective(singer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多选标签
     * @param idList
     * @param singerList
     */
    private void wrapSingerJson(List<Map<String, String>> idList, List<Singer> singerList) {
        for (Singer temp : singerList){
            Map<String,String> map = new HashMap<>();
            map.put("id",temp.getId().toString());
            map.put("text",temp.getSingerName()+"/");//加上"/"便于传值
            idList.add(map);
        }
    }
}
