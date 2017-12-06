package com.enter.service.impl;

import com.enter.annotations.LoginVerifyJson;
import com.enter.entity.Address;
import com.enter.entity.User;
import com.enter.exception.ShoppingException;
import com.enter.repository.UserRepository;
import com.enter.service.EmailService;
import com.enter.service.IAccountService;
import com.enter.service.IAddressService;
import com.enter.util.*;
import com.enter.util.enums.DataType;
import com.enter.util.enums.RetCode;
import com.enter.util.protocol.Body;
import com.enter.util.protocol.BodyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/17 0017 10:29
 */
@Component
@Transactional
public class AccountServiceImpl implements IAccountService {
    private final static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private IAddressService addressService;

    public void checkValidCode(String email,String validCode,String type){
        checkEmail(email);
        //判断验证码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String tempCode = (String) request.getSession().getAttribute(email + type);
        if (tempCode ==null || !tempCode.equalsIgnoreCase(validCode))
            throw new ShoppingException(RetCode.UTIL_AUTHCODE);
        request.getSession().setAttribute(email+type,Constant.MODIFYPWD);

    }

    public void doReg(User user){
        String email = user.getEmail();//邮箱
        checkEmail(email);
        String password = user.getPassword();//密码
        if (StringUtils.isNull(password))
            throw new ShoppingException(RetCode.REG_EMPTY_PASSWORD);
        //判断验证码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String flagStr = (String) request.getSession().getAttribute(email+Constant.REGISTER);
        if (!Constant.MODIFYPWD.equals(flagStr))
            throw new ShoppingException(RetCode.PLEASE_SEND_VALID);
        //密码加密
        password = Function.EncoderByMd5UTF8(password);
        user.setPassword(password);
        User loginUser = userRepository.save(user);
        CheckUserLogin.doLogin(loginUser);
    }

    @Override
    public void sendValidCode(String email,String type) {
        checkEmail(email);
        User persistent = userRepository.getUserByEmail(email);
        if(Constant.REGISTER.equals(type)){
            //type == register 注册验证码
            if(persistent != null){
                throw new ShoppingException(RetCode.REG_EXIST_EMAIL);
            }
        }else if(Constant.FORGETPWD.equals(type)){
            //type == forgetPwd 忘记密码验证码
            if(persistent == null){
                throw new ShoppingException(RetCode.REG_EMAIL_IS_NOT_REGISTER);
            }
        }
            //生成验证码
        String validCode = RandomUtils.generateString(6);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute(email + type,validCode);
        logger.info("validCode=" + validCode);
        //发送注册邮件
        emailService.sendRegisterEmail(email,validCode);
    }


    @Override
    public int modifyPwd(User user) {
        return 0;
    }

    @Override
    public Object active(User user) {
        return null;
    }

    @Override
    public User getUserByEmailandMac(User user) {
        return null;
    }

    @Override
    public User login(String email,String password) {
        checkEmail(email);
        if (StringUtils.isNull(password))
            throw new ShoppingException(RetCode.REG_EMPTY_PASSWORD);
        //密码加密
        password = Function.EncoderByMd5UTF8(password);
        User user = userRepository.getUserByEmailAndPassword(email,password);
        if(user == null)
            throw new ShoppingException(RetCode.LOG_USERNAME_OR_PASSWOLD_ERROR);
        Address address = addressService.findAddressByUserAndSelected(user,"1");
        CheckUserLogin.doLogin(user,address);

        return user;
    }

    @Override
    public Object loginOut() {
        return null;
    }

    @Override
    public Object findPwd(User user) {
        return null;
    }

    @Override
    public void logout() {
        User user = CheckUserLogin.getloginuser();
        CheckUserLogin.doLogout();
    }

//    @Override
//    @LoginVerifyJson
//    public void modifyTel(String tel, String msgCode) {
//        if (!RegExpValidatorUtils.IsHandset(tel))
//            throw new ShoppingException(RetCode.REG_FORMAT_ERROR_PHONENUM);
//        if (msgCode == null)
//            throw new ShoppingException(RetCode.DXCODEISNULL);
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        String origalCode = (String) session.getAttribute(Constant.DXCODE);
//        if (!msgCode.equals(origalCode))
//            throw new ShoppingException(RetCode.DXCODEMISTAKE);
//        User userSession = CheckUserLogin.getloginuser();
//        User user = userRepository.findOne(userSession.getId());
//        user.setTel(tel);
//        userRepository.save(user);
//    }

    @Override
    public void sendDxCode(String tel) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //TODO 发送短信验证码
        session.setAttribute(Constant.DXCODE,"1235");
    }

    @Override
    public User changePwd(User user) {
        String email = user.getEmail();//邮箱
        checkEmail(email);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String flagStr = (String) request.getSession().getAttribute(email+Constant.FORGETPWD);
        //判断验证码
        if (!Constant.MODIFYPWD.equals(flagStr))
            throw new ShoppingException(RetCode.PLEASE_SEND_VALID);
        User perUser = userRepository.getUserByEmail(email);
        if(perUser == null){
            throw new ShoppingException(RetCode.REG_EMAIL_IS_NOT_REGISTER);
        }
        String password = user.getPassword();//密码
        if (StringUtils.isNull(password))
            throw new ShoppingException(RetCode.REG_EMPTY_PASSWORD);

        //密码加密
        password = Function.EncoderByMd5UTF8(password);
        perUser.setPassword(password);
        user = userRepository.save(perUser);
        return user;
    }

    private void checkEmail(String email) {
        if(StringUtils.isNull(email))//不为空
            throw new ShoppingException(RetCode.REG_EMPTY_EMAIL);
        if(!RegExpValidatorUtils.isEmail(email))//校验格式
            throw new ShoppingException(RetCode.REG_EMAIL_IS_MISTAKE);
    }
}
