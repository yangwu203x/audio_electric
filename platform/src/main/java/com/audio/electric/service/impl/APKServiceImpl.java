package com.audio.electric.service.impl;

import com.audio.electric.domain.Apk;
import com.audio.electric.domain.ApkExample;
import com.audio.electric.mapper.ApkMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IApkService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/3 0003 10:20
 */
@Component
public class APKServiceImpl extends BaseService implements IApkService {

    @Autowired
    private ApkMapper apkMapper;

    @UsePage
    @Override
    public List<Apk> listApk(Apk apk) {
        ApkExample apkExample = new ApkExample();
        ApkExample.Criteria criteria = apkExample.or();
        if (StringUtils.isNotNull(apk.getType()))
            criteria.andTypeEqualTo(apk.getType());
        List<Apk> apkList = null;
        try {
            apkList = apkMapper.selectByExample(apkExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apkList;
    }

    @Override
    public int addApkHistory(Apk apk) {
        int result = RetCode.FAILED.getCode();
        try {
            result = apkMapper.insertSelective(apk);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteApk(String ids) {
        int result = RetCode.FAILED.getCode();
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            String[] arr = ids.split(",");
            if (arr == null)
                throw new PlatException(RetCode.PARAMETER_ERROR);
            List<Integer> idList = new ArrayList<>();
            for(String str : arr)
                idList.add(Integer.parseInt(str));
            ApkExample apkExample = new ApkExample();
            apkExample.or().andIdIn(idList);
            result = apkMapper.deleteByExample(apkExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
