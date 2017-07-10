package com.audio.electric.mapper;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.domain.Role;
import com.audio.electric.domain.RoleExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/27 0027 16:32
 */
public class RoleMapperTest extends PlatformApplicationTests{
    @Autowired
    private RoleMapper roleMapper;
    @Test
    public void insert() throws Exception {

    }

    @Test
    public void insertSelective() throws Exception {
        Role role = new Role();
        role.setRoleName("呵呵");
        System.out.println(roleMapper.insertSelective(role));
    }

}