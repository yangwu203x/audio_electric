package com.audio.electric.controller;

import com.audio.electric.domain.User;
import com.audio.electric.service.IUserService;
import com.audio.electric.util.tool.CheckUserLogin;
import com.audio.electric.domain.CookieUser;
import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.protocol.BodyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by yangwu on 2017/3/15.
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;





}
