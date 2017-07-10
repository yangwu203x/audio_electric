package com.audio.electric.controller;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.EnumValue;
import com.audio.electric.service.IDictService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/5 0005 15:35
 */
public class EnumControllerTest extends PlatformApplicationTests{
    @Autowired
    private IDictService dictService;
    @Test
    public void addEnumType() throws Exception {
        EnumType enumType = new EnumType();
        enumType.setName("背景版本画质");
        enumType.setTypeName("songPixel");
        int result = dictService.addEnumType(enumType);
        Assert.assertEquals(1,result);
    }

    @Test
    public void addEnumValue() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("480p");
        list.add("720p");
        list.add("1080p");
        list.add("1080p以上");
        EnumValue enumValue = new EnumValue();
        int index = 1;
        for (String name : list){
            enumValue.setName(name);
            dictService.addEnumValue(enumValue);
        }
    }

}