package com.enter.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class SendEmail {
    public static final String HOST = "smtp.sina.com";
    public static final String PROTOCOL = "smtp";
    public static final int PORT = 25;
    public static final String FROM = "yangwu_leo123@sina.com";//发件人的email
    public static final String PWD = "yangwu123456";//发件人密码

    /**
     * 获取Session
     * @return
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置服务器地址
        props.put("mail.store.protocol" , PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.smtp.auth" , true);

        Authenticator authenticator = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }

        };
        Session session = Session.getDefaultInstance(props , authenticator);


        return session;
    }

    /**
     * 发送注册邮件
     * @param email
     */
    public static void sendRegisterMail(String email,String validCode) throws Exception {
        ///发送注册邮件
        StringBuffer sb = new StringBuffer("音特电子（深圳）有限公司帐号验证码： ");
        sb.append(validCode);
        sb.append(" 【勿向任何人泄露此验证码】【特电子】");
        //发送激活邮箱
        SendEmail.send(email, sb.toString(), "Please validate your account");
    }

    public static void sendFindPwdMail(String email,String mac) throws Exception {
        String serverUrl = Tools.propertiesFileResolve(Constant.SERVERURL);
        ///发送注册邮件
        StringBuffer sb = new StringBuffer("Welcome to AudioElectric<br/>");
        sb.append("To get started, please click on the href below to confirm your account:<br/>");
        sb.append(serverUrl + "/login/toChangePwd?email=");
        sb.append(email);
        sb.append("&mac=");
        sb.append(mac);
        //发送激活邮箱
        SendEmail.send(email, sb.toString(), "Please validate your account");
    }


    /**
     * 发送邮件
     * @param toEmail
     * @param content
     * @param title
     */
    public static void send(String toEmail , String content, String title) {
        Session session = getSession();
        try {
            System.out.println("--send--"+content);
            // Instantiate a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(title);
            msg.setSentDate(new Date());
            msg.setContent(content , "text/html;charset=utf-8");
            //Send the message
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void main(String[] args){
        SendEmail.send("125667528@qq.com","hello","快来222注册啊！");
    }

}
