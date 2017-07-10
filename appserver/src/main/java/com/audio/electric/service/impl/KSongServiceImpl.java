package com.audio.electric.service.impl;

import com.audio.electric.service.BaseService;
import com.audio.electric.service.IKSongService;
import com.audio.electric.mapper.KSongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/28 0028 16:29
 */
@Component
public class KSongServiceImpl extends BaseService implements IKSongService {

    @Autowired
    private KSongMapper kSongMapper;
    @Override
    public Object kBySinger(String singerName) {
        return null;
    }
}
