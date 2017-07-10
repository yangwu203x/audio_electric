package com.audio.electric.mapper;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/21 0021 14:09
 */
public class UserMapperTest extends PlatformApplicationTests{
    @Autowired
    private UserMapper userMapper;
    @Test
    public void countByExample() throws Exception {
        System.out.println(userMapper.countByExample(null));
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        for (int i = 0 ; i < 20; i++){
            User user = new User();
            user.setName("张李" + i);
            user.setAge(i);
            user.setId((long) i);
            userMapper.insert(user);
        }
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
        System.out.println(userMapper.selectByExample(null));
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }



}