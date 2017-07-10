package com.audio.electric.service.impl;

import com.audio.electric.domain.FeedBack;
import com.audio.electric.domain.FeedBackExample;
import com.audio.electric.mapper.FeedBackMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IFeedBackService;
import com.audio.electric.util.annotation.UsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/4 0004 19:19
 */
@Component
public class FeedBackServiceImpl extends BaseService implements IFeedBackService {
    @Autowired
    private FeedBackMapper feedBackMapper;

    @UsePage
    @Override
    public List<FeedBack> listFeedBack(FeedBack feedBack) {
        List<FeedBack> feedBackList = null;
        try {
            FeedBackExample feedBackExample = new FeedBackExample();
            FeedBackExample.Criteria criteria = feedBackExample.or();
            if (feedBack.getStatus() != null)
                criteria.andStatusEqualTo(feedBack.getStatus());
            feedBackList = feedBackMapper.selectByExample(feedBackExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedBackList;
    }
}
