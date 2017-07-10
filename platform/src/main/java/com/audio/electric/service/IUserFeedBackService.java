package com.audio.electric.service;

import com.audio.electric.domain.UserFeedback;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/12 0012 15:56
 */
public interface IUserFeedBackService {
    List<UserFeedback> listUserFeedBack(UserFeedback userFeedBack);
}
