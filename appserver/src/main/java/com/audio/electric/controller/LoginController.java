package com.audio.electric.controller;

import com.audio.electric.domain.User;
import com.audio.electric.service.ILoginService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.protocol.BodyUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginController extends BaseController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;


    /**
     * 描述 退出
     *
     * @throws IOException
     */
    @GetMapping("/logout")
    @ResponseBody
    public String logout( HttpServletResponse response) throws IOException {
        return loginService.loginOut().toString();
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(User user) throws IOException {
        user = loginService.login(user);
        return BodyUtil.sucess(user, DataType.Object).toString();
    }


    /**
     * 邮件注册账户
     * @param user
     * @throws IOException
     */
    @PostMapping("/regByMail")
    @ResponseBody
    public String regByMail(User user) throws IOException {
        return loginService.doReg(user).toString();
    }


    /**
     * 激活
     * @param user
     * @throws IOException
     */
    @GetMapping("/active")
    @ResponseBody
    public String active(User user) throws  IOException {
        return loginService.active(user).toString();
    }

    /**
     * 描述 登录登出处理
     *
     * @param user
     * @param loginDate
     * @param status 判断是登录还是登出
     */
    private void loginLog(User user, String loginDate, String status ) {
        //TODO
//        UserOnline logLogin = new UserOnline(user.getId(),loginDate, status);
//        commonService.insertUserOnline(logLogin);
//        // session cookie 处理
//        CookieUser cookieUser = CheckUserLogin.putCookieUser(user);
    }





}
