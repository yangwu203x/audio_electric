package com.audio.electric.service;

import com.audio.electric.domain.FeedBack;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/4 0004 19:19
 */
public interface IFeedBackService {
    List<FeedBack> listFeedBack(FeedBack feedBack);
}
