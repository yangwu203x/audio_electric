package com.audio.electric.controller;

import com.audio.electric.domain.User;
import com.audio.electric.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/25 0025 17:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private IUserService userService;
    @Test
    public void userInfo() throws Exception {
        User user = new User();
        user.setId(2l);
        user.setUsername("hehe");
        int result = userService.userInfo(user);

    }

}