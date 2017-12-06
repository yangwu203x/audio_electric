package com.audio.electric.controller;

import com.audio.electric.domain.Account;
import com.audio.electric.domain.Role;
import com.audio.electric.service.IAccountService;
import com.audio.electric.service.IMenuService;
import com.audio.electric.util.authCode.CreateImageCode;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.protocol.BodyUtil;
import com.audio.electric.util.tool.Function;
import com.audio.electric.util.tool.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 10:26
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IMenuService menuService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(Account account ,String authCode,HttpServletRequest request){
        String sessionAuthCode = (String) request.getSession().getAttribute(Constant.CURRENT_USER_VALIDATE_CODE_KEY);
        logger.info("authCode="+authCode+",sessionAuthCode="+sessionAuthCode);
        if(StringUtils.isNull(sessionAuthCode))
            throw new PlatException(RetCode.PAST_AUTHCODE);
        if (!sessionAuthCode.equalsIgnoreCase(authCode))
            throw new PlatException(RetCode.UTIL_AUTHCODE);
        String password = account.getPassword();
        if (StringUtils.isNull(password)) {
            throw new PlatException(RetCode.REG_EMPTY_PASSWORD);
        }
        account.setPassword(Function.EncoderByMd5UTF8(password));
        account = accountService.login(account ,authCode);
        if (account != null && 1 == account.getStatus()) {
            request.getSession().setAttribute(Constant.CURRENT_LOGIN_ACCOUNT,account);
            Role role = baseService.getRoleByAccount(account);
            if (Constant.ADMINISTRATOR.equals(account.getUsername())){
                role.setRoleName("系统管理员");
                role.setRoleAdd(1);
                role.setRoleDel(1);
                role.setRoleUpdate(1);
                role.setRoleCheck(1);
            }
            request.getSession().setAttribute(Constant.CURRENT_ACCOUNT_ROLE,role);
            return BodyUtil.result(RetCode.SUCCESS.getCode());
        }else if(account != null && 1 != account.getStatus()){
            return BodyUtil.error(RetCode.UNACTIVED);
        }else{
            return BodyUtil.error(RetCode.LOG_USERNAME_OR_PASSWOLD_ERROR);
        }
    }

    /**
     * 获取验证码
     */
    @GetMapping(value = "/captcha")
    public void validateImages(HttpServletResponse response ,HttpServletRequest request) throws IOException {
        Random random = new Random();
        int codeType = (random.nextInt(3)+1)%3 + 1;
        CreateImageCode vCode = new CreateImageCode(146,42,4,10,codeType);
        BufferedImage image = vCode.getBuffImg();
        String validateCode = vCode.getCode();
        request.getSession().setAttribute(Constant.CURRENT_USER_VALIDATE_CODE_KEY, validateCode);
        response.setCharacterEncoding("utf-8");
        ImageIO.write(image, "png", response.getOutputStream());
    }

    @GetMapping("/logout")
    public String logout(){
        accountService.logout();
        return "login";
    }

    @GetMapping("/listAccount")
    public String listAccount(Account account , Model model){
        List<Account> accountList = accountService.listAccount(account);
        PageInfo pagehelper = new PageInfo(accountList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("accountList",accountList);
        return "account/account_list";
    }

    @GetMapping("/showAccount")
    public String showAccount(Account account, Model model , String operateType){
        String viewName = "account/account_edit";
        //获取要访问的视图
        if(("1").equals(operateType)){
            //添加
            model.addAttribute("requestUrl","/account/addAccount");
            return viewName;
        }else if(("2").equals(operateType)){
            //修改
            account = accountService.getAccount(account);
            model.addAttribute("account",account);
            model.addAttribute("requestUrl","/account/modifyAccount");
            return viewName;
        }
        //设置视图
        return "404";
    }

    /**
     * 增加菜单
     * @param account
     * @return
     */
    @PostMapping("/addAccount")
    @ResponseBody
    public String addAccount(Account account){
        String password = account.getPassword();
        if (StringUtils.isNull(password)) {
            throw new PlatException(RetCode.REG_EMPTY_PASSWORD);
        }
        account.setPassword(Function.EncoderByMd5UTF8(password));
        int result = accountService.addAccount(account);
        return result+"";
    }

    /**
     * 修改账户
     * @param account
     * @return
     */
    @RequestMapping("/modifyAccount")
    @ResponseBody
    public String modifyAccount(Account account,HttpServletRequest request){
        String password = account.getPassword();
        account.setPassword(Function.EncoderByMd5UTF8(password));
        int result = accountService.modifyAccount(account);
        return result+"";
    }

    /**
     * 删除/批量账户
     * @param ids
     * @return
     */
    @PostMapping("/deleteAccount")
    @ResponseBody
    public Object deleteAccount(String ids){
        int result = accountService.deleteAccount(ids);
        return BodyUtil.result(result);
    }

    @GetMapping("/isAccountExist")
    @ResponseBody
    public Object isAccountExist(Account account){
        return accountService.isAccountExist(account);
    }

    @RequestMapping("/accountOpen")
    @ResponseBody
    public Object accountOpen(Account account){
        return accountService.accountOpen(account);
    }

    @RequestMapping("/accountForbid")
    @ResponseBody
    public Object accountForbid(Account account){
        return accountService.accountForbid(account);
    }

    @RequestMapping("/listAccountName")
    @ResponseBody
    public Object listAccountName(){
        List<Account> userNameList = accountService.listAccountName();
        return userNameList;
    }

}
