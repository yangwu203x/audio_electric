package com.audio.electric.service.impl;

import com.audio.electric.domain.*;
import com.audio.electric.mapper.EnumTypeMapper;
import com.audio.electric.mapper.EnumValueMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IDictService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/2 0002 17:39
 */
@Component
public class DictServiceImpl extends BaseService implements IDictService{
    @Autowired
    private EnumTypeMapper enumTypeMapper;
    @Autowired
    private EnumValueMapper enumValueMapper;

    @Override
    public int addEnumType(EnumType enumType) {
        int result = RetCode.FAILED.getCode();
        try {
            if (StringUtils.isNull(enumType.getName())||StringUtils.isNull(enumType.getTypeName()))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            result = enumTypeMapper.insertSelective(enumType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyEnumType(EnumType enumType) {
        int result = RetCode.FAILED.getCode();
        try {
            EnumTypeExample enumTypeExample = new EnumTypeExample();
            EnumTypeExample.Criteria criteria = enumTypeExample.or().andTypeNameEqualTo(enumType.getTypeName());
            result = enumTypeMapper.updateByExampleSelective(enumType,enumTypeExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteEnumType(String ids) {
        try {
            if (StringUtils.isNull(ids) )
                throw new PlatException(RetCode.PARAMETER_ERROR);
            List<Integer> idList = getIdListInt(ids);
            EnumTypeExample enumTypeExample = new EnumTypeExample();
            EnumTypeExample.Criteria criteria = enumTypeExample.or();
            criteria.andIdIn(idList);
            return enumTypeMapper.deleteByExample(enumTypeExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int addEnumValue(EnumValue enumValue) {
        int result = RetCode.FAILED.getCode();
        try {
            result = enumValueMapper.insertSelective(enumValue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @UsePage
    @Override
    public List<EnumType> listEnumType(EnumType enumType) {
        List<EnumType> enumTypeList = null;
        try {
            EnumTypeExample enumTypeExample = new EnumTypeExample();
            EnumTypeExample.Criteria criteria = enumTypeExample.or();
            if (StringUtils.isNotNull(enumType.getName()))
                criteria.andNameLike("%" + enumType.getName() + "%");
            if (StringUtils.isNotNull(enumType.getTypeName()))
                criteria.andNameLike("%" + enumType.getTypeName() + "%");
            enumTypeList = enumTypeMapper.selectByExample(enumTypeExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enumTypeList;
    }

    @Override
    public EnumValue getEnumValue(EnumValue enumValue) {
        try {
            enumValue = enumValueMapper.selectByPrimaryKey(enumValue.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enumValue;
    }

    @Override
    public List<EnumValue> listEnumValueByTitle(String title) {
        List<EnumValue> enumValueList = null;
        try {
            enumValueList = baseMapper.listEnumValueByTitle(title);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enumValueList;
    }


    @UsePage
    @Override
    public List<EnumValue> listEValuePageByTypeId(Integer enumTypeId) {
        List<EnumValue> enumValueList = null;
        try {
            EnumValueExample enumValueExample = new EnumValueExample();
            EnumValueExample.Criteria criteria = enumValueExample.or();
            enumValueExample.setOrderByClause("id asc");
            criteria.andEnumTypeIdEqualTo(enumTypeId);
            enumValueList = enumValueMapper.selectByExample(enumValueExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enumValueList;
    }

    @Override
    public int modifyEnumValue(EnumValue enumValue) {
        try {
            return enumValueMapper.updateByPrimaryKey(enumValue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int deleteEnumValue(String ids) {
        try {
            if (StringUtils.isNull(ids) || StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            List<Integer> idList = getIdListInt(ids);
            EnumValueExample enumValueExample = new EnumValueExample();
            EnumValueExample.Criteria criteria = enumValueExample.or();
            criteria.andIdIn(idList);
            return enumValueMapper.deleteByExample(enumValueExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }
}
