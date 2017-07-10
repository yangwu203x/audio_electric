package com.audio.electric.service.impl;

import com.audio.electric.domain.UserFeedback;
import com.audio.electric.domain.UserFeedbackExample;
import com.audio.electric.mapper.UserFeedbackMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IUserFeedBackService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/12 0012 15:57
 */
@Component
public class UserFeedBackServiceImpl extends BaseService implements IUserFeedBackService{
    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    @UsePage
    @Override
    public List<UserFeedback> listUserFeedBack(UserFeedback userFeedBack) {
        try {
            UserFeedbackExample userFeedbackExample = new UserFeedbackExample();
            UserFeedbackExample.Criteria criteria = userFeedbackExample.or();
            if (StringUtils.isNotNull(userFeedBack.getStatus()))
                criteria.andStatusEqualTo(userFeedBack.getStatus());
            return userFeedbackMapper.selectByExample(userFeedbackExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
