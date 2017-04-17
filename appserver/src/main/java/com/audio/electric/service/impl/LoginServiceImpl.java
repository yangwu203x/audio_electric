package com.audio.electric.service.impl;

import com.audio.electric.domain.CookieUser;
import com.audio.electric.domain.User;
import com.audio.electric.mapper.LoginMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.ILoginService;
import com.audio.electric.util.constants.Constant;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.protocol.Body;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
@Component
public class LoginServiceImpl extends BaseService implements ILoginService {
    @Autowired
    private LoginMapper loginMapper;
    
    @Override
    public Body doReg(User user) {
        int result = RetCode.FAILED.getCode();
        String email = user.getEmail();//邮箱
        checkEmail(email);
        String password = user.getPassword();//密码
        if (StringUtils.isNull(password))
            throw new AppException(RetCode.REG_EMPTY_PASSWORD);
        //密码加密
        password = Function.EncoderByMd5UTF8(password);
        List<User> userList = getUserByEmail(user);
        String mac = UUID.randomUUID().toString();
        //设置账户状态为未激活
        //判断邮箱是否注册并且激活过
        if(userList != null && userList.size() > 1){
            throw new AppException(RetCode.REG_EMAIL_MORETHANONE);
        }else if(userList.size() == 1){
            if (!Constant.UNACTIVESTATUS.equals(userList.get(0).getStatus())){
                //注册已经激活过
                throw new AppException(RetCode.REG_EXIST_EMAIL);
            }else{
                //注册但没有激活，再次发送注册邮箱，并修改密码
                User existUser = userList.get(0);
                existUser.setMac(mac);
                existUser.setPassword(password);
                result =  modifyPwd(existUser);
            }
        }else{
            //从没注册过
            user.setUsername(email);
            user.setPassword(password);
            user.setRegitserWay(Constant.REGISTERBYMAIL);
            user.setMac(mac);
            user.setStatus(Constant.UNACTIVESTATUS);
            try {
                result = loginMapper.reg(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //发送注册邮件
        SendEmail.sendRegisterMail(email , mac);
        return BodyUtil.result(result);
    }

    public List<User> getUserByEmail(User user){
        try {
            return loginMapper.getUserByEmail(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int modifyPwd(User user) {
        try {
            return loginMapper.modifyPwd(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getUserByEmailandMac(User user){
        try {
            return loginMapper.getUserByEmailandMac(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User login(User user) {
        String username = user.getUsername();
        if (StringUtils.isNull(username))
            throw new AppException(RetCode.REG_EMPTY_USER_NAME);
        String password = user.getPassword();
        if (StringUtils.isNull(password)) {
            throw new AppException(RetCode.REG_EMPTY_PASSWORD);
        }
        user.setPassword(Function.EncoderByMd5UTF8(password));
        user = loginMapper.login(user);
        if (user != null){
            if (Constant.ACTIVEDSTATUS.equals(user.getStatus())){
                //成功登录
                CheckUserLogin.doLogin(user);
                return user;
            }else if (Constant.UNACTIVESTATUS.equals(user.getStatus())){
                throw new AppException(RetCode.UNACTIVED);
            }else{
                throw new AppException(RetCode.STATUSEXCEPTION);
            }
        }else{
            throw new AppException(RetCode.LOG_USERNAME_OR_PASSWOLD_ERROR);
        }
    }

    @Override
    public Body loginOut() {
        CookieUser cookieUser = CheckUserLogin.getloginuser();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().removeAttribute(Constant.CURRENT_LOGIN_USER);
        return BodyUtil.sucess(null, DataType.Constant);
    }

    @Override
    public Body active(User user) {
        int result = RetCode.FAILED.getCode();
        //校验邮箱
        checkEmail(user.getEmail());
        //校验验证码
        String validateCode = user.getMac();
        if(StringUtils.isNull(validateCode))
            throw new AppException(RetCode.REG_EMPTY_AUTHENTICATED_CODE);
        List<User> userList = getUserByEmail(user);
        user = getUserByEmailandMac(user);

        if (userList == null || userList.size() == 0){
            //用户没有注册
            throw new AppException(RetCode.REG_EMAIL_IS_NOT_REGISTER);
        }if (userList.size() >1){
            //存在多个相同邮箱的账户
            throw new AppException(RetCode.REG_EMAIL_MORETHANONE);
        }else if (userList.size() == 1 && user != null){
            //激活成功， //并更新用户的激活状态，为已激活
            user.setStatus(Constant.ACTIVEDSTATUS);//把状态改为激活
            try {
                result = loginMapper.active(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(userList.size() == 1 && user == null){
            //验证码不正确
            throw new AppException(RetCode.REG_MISTAKE_ACTIVATION);
        }
        return BodyUtil.result(result);
    }

    private void checkEmail(String email) {
        if(StringUtils.isNull(email))//不为空
            throw new AppException(RetCode.REG_EMPTY_EMAIL);
        if(!RegExpValidatorUtils.isEmail(email))//校验格式
            throw new AppException(RetCode.REG_EMAIL_IS_MISTAKE);
    }

}
