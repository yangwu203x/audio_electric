package com.audio.electric.service.impl;

import com.audio.electric.domain.HotSong;
import com.audio.electric.mapper.HotSongMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IHotSongService;
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
 * @Date 2017/5/10 0010 11:15
 */
@Component
public class HotSongServiceImpl extends BaseService implements IHotSongService{

    @Autowired
    private HotSongMapper hotSongMapper;

    @UsePage
    @Override
    public List<HotSong> listHotSong() {
        List<HotSong> hotSongList = null;
        try {
            hotSongList = hotSongMapper.listHotSong();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotSongList;
    }

    @Override
    public int saveHotSong(HotSong hotSong) {
        try {
            return hotSongMapper.saveHotSong(hotSong);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int editHotSong(HotSong hotSong) {
        try {
            return hotSongMapper.editHotSong(hotSong);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public int deleteHotSong(String ids) {
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            return hotSongMapper.deleteHotSong(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public HotSong getHotSongById(HotSong hotSong) {
        try {
            hotSong = hotSongMapper.getHotSongById(hotSong);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotSong;
    }
}
