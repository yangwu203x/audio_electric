package com.audio.electric.mapper;

import com.audio.electric.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/7 0007 9:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginMapperTest {
    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void reg() throws Exception {
        for (int i =0;i<100000;i++){
            User user = new User();
            user.setUsername(i+"222");
            user.setEmail(i+"22@qq.com");
            loginMapper.reg(user);
        }
    }

}