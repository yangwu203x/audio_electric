package com.audio.electric.service.impl;

import com.audio.electric.mapper.SearchMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/15 0015 10:03
 */
@Component
public class SearchServiceImpl extends BaseService implements ISearchService{
    @Autowired
    private SearchMapper searchMapper;
}
