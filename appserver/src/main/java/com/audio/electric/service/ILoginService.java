package com.audio.electric.service;

import com.audio.electric.domain.User;
import com.audio.electric.util.protocol.Body;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
@Service("loginService")
public interface ILoginService {

    /**
     * 注册账户
     * @param user
     * @return
     */
    Body doReg(User user);

    List<User> getUserByEmail(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    int modifyPwd(User user);

    /**
     * 激活
     * @param user
     * @return
     */
    Body active(User user);

    User getUserByEmailandMac(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    Body loginOut();
}
