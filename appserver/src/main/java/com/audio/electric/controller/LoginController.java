package com.audio.electric.controller;

import com.audio.electric.domain.Token;
import com.audio.electric.domain.User;
import com.audio.electric.repository.TokenRepostitory;
import com.audio.electric.service.ILoginService;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.AppException;
import com.audio.electric.util.key.RSA;
import com.audio.electric.util.protocol.Body;
import com.audio.electric.util.protocol.BodyUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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

    @Autowired
    private TokenRepostitory tokenRepostitory;

    /**
     * 描述 退出
     *
     * @throws IOException
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout( HttpServletResponse response) throws IOException {
        return loginService.loginOut().toString();
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(User user) throws IOException {

        user = loginService.login(user);

        return BodyUtil.sucess(user, DataType.Object).toString();
    }

    @RequestMapping("/getKey")
    @ResponseBody
    public Body getKey(HttpServletRequest request) throws Exception {
        Map<String ,String > mapKey = RSA.generateKeyPair();
        String sessionId = request.getSession().getId();
        logger.info("sessionId="+sessionId);
        Token token = new Token();
        token.setSessionId(sessionId);
        token.setPrivateKey(mapKey.get("privateKey"));
        tokenRepostitory.save(token);
        return BodyUtil.sucess(mapKey.get("publicKey"), DataType.Object);
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
     * 根据邮箱找回密码
     * @param user 传邮箱
     * @return
     */
    @GetMapping("/put/findPwd")
    @ResponseBody
    public Object findPwd(User user){
        return loginService.findPwd(user);
    }

    /**
     * 跳到重置密码页面
     * @param user
     * @param model
     * @return
     */
    @GetMapping("/toChangePwd")
    public String toChangePwd(User user,Model model){
        user = loginService.getUserByEmailandMac(user);
        if (user == null)
            throw new AppException(RetCode.PARAMETER_ERROR);
        model.addAttribute("user",user);
        model.addAttribute("requestUrl","");
        return "changePwd";
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @GetMapping("/modifyPwd")
    @ResponseBody
    public Object toChangePwd(User user){
        user = loginService.getUserByEmailandMac(user);
        if (user == null)
            throw new AppException(RetCode.PARAMETER_ERROR);
        int result = loginService.modifyPwd(user);
        return BodyUtil.result(result);
    }

    /**
     * 描述 登录登出处理
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
