package com.audio.electric.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/9 0009 14:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseMapperTest {
    @Autowired
    private BaseMapper baseMapper;
    @Test
    public void listMapByTitle() throws Exception {
        List<Map> list = baseMapper.listMapByTitle("tvProgram");
        Map<String,String> mapd = new HashMap<>();
        for (Map map :list)
            mapd.put(map.get("name")+"",map.get("id")+"");
        System.out.println(mapd.toString());
    }

}