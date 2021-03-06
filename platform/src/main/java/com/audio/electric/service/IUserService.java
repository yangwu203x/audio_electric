package com.audio.electric.service;

import com.audio.electric.domain.User;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/21 0021 14:14
 */
public interface IUserService {
    List<User> listUser(User user);

    User getUserById(User user);

    int saveUser(User user);

    int editUser(User user);

    int deleteUser(String ids);

    List<String> autoSearch(User user);
}
