package com.audio.electric.service;

import com.alibaba.fastjson.JSON;
import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.EnumValue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/4 0004 17:21
 */
public class BaseServiceTest extends PlatformApplicationTests{
    @Autowired
    private BaseService baseService;
    @Autowired
    private IDictService dictService;
    @Test
    public void listEnumTypeByType() throws Exception {
        EnumType enumType = new EnumType();
        enumType.setTypeName("education");
        List<EnumType> list = dictService.listEnumType(enumType);
        for (EnumType temp : list){
            System.out.println(temp.getDescription()+"<>"+temp.getName()+"<>" );
            for (EnumValue enumValue : temp.getEnumValueList())
                System.out.println(enumValue.getName() + "?????");
        }
        EnumValue value = new EnumValue();
    }

    @Test
    public void getEnumValue(){
        EnumValue enumValue = new EnumValue();
        enumValue = dictService.getEnumValue(enumValue);
        System.out.println(JSON.toJSON(enumValue));
    }
}