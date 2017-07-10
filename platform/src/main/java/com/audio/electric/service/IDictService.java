package com.audio.electric.service;


import com.audio.electric.domain.EnumType;
import com.audio.electric.domain.EnumValue;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/2 0002 17:38
 */
public interface IDictService {

    int addEnumType(EnumType enumType);

    int modifyEnumType(EnumType enumType);

    int deleteEnumType(String ids);

    int addEnumValue(EnumValue enumValue);

    List<EnumType> listEnumType(EnumType enumType);

    EnumValue getEnumValue(EnumValue enumValue);

    List<EnumValue> listEnumValueByTitle(String title);


    int modifyEnumValue(EnumValue enumValue);

    int deleteEnumValue(String ids);

    List<EnumValue> listEValuePageByTypeId(Integer enumTypeId);
}
