package com.audio.electric.service.impl;

import com.audio.electric.mapper.BehaviorMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:17
 */
@Component
public class BehaviorServiceImpl extends BaseService implements IBehaviorService {
    @Autowired
    private BehaviorMapper behaviorMapper;
}
