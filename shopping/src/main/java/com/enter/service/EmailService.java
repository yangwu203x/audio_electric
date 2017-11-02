package com.enter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/17 0017 13:44
 */
@Component
public class EmailService {
    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    public void sendSimpleMail(String email,String validCode)  {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(email); //自己给自己发送邮件
        StringBuffer sb = new StringBuffer("音特电子（深圳）有限公司帐号验证码： ");
        sb.append(validCode);
        sb.append(" 【勿向任何人泄露此验证码】【特电子】");
        message.setSubject("主题：音特电子（深圳）有限公司商城注册验证码");
        message.setText(sb.toString());
        mailSender.send(message);
    }
}
