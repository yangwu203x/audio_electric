package com.audio.electric.service.impl;

import com.audio.electric.PlatformApplicationTests;
import com.audio.electric.service.IRoleMenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/5 0005 13:58
 */
public class RoleMenuServiceImplTest extends PlatformApplicationTests
{
    @Autowired
    private IRoleMenuService roleMenuService;
    @Test
    public void givePrivilege() throws Exception {
        roleMenuService.givePrivilege(1,"13,14");
    }

    @Test
    public void cancelPrivilege() throws Exception {
        roleMenuService.cancelPrivilege(1,"13,14");
    }

}