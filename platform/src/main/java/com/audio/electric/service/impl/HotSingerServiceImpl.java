package com.audio.electric.service.impl;

import com.audio.electric.domain.HotSinger;
import com.audio.electric.mapper.HotSingerMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IHotSingerService;
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
 * @Date 2017/5/10 0010 11:38
 */
@Component
public class HotSingerServiceImpl extends BaseService implements IHotSingerService {
    @Autowired
    private HotSingerMapper hotSingerMapper;

    @UsePage
    @Override
    public List<HotSinger> listHotSinger() {
        List<HotSinger> hotSingerList = null;
        try {
            hotSingerList = hotSingerMapper.listHotSinger();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotSingerList;
    }

    @Override
    public int saveHotSinger(HotSinger hotSinger) {
        try {
            return hotSingerMapper.saveHotSinger(hotSinger);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int editHotSinger(HotSinger hotSinger) {
        try {
            return hotSingerMapper.editHotSinger(hotSinger);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int deleteHotSinger(String ids) {
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            return hotSingerMapper.deleteHotSinger(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public HotSinger getHotSingerById(HotSinger hotSinger) {
        try {
            hotSinger = hotSingerMapper.getHotSingerById(hotSinger);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotSinger;
    }
}
