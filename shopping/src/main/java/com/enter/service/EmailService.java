package com.enter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/17 0017 13:44
 */
@Component
public class EmailService {
//    @Autowired
//    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String userName; //读取配置文件中的参数
    @Value("${spring.mail.password}")
    private String password;

    /**
     * 发送注册邮件
     * @param email
     * @param validCode
     */
    public void sendRegisterEmail(String email,String validCode){
        try {
            //文本部分
            //主题
            String subject = "音特电子";
            MimeBodyPart textPart = new MimeBodyPart();
            //内容
            StringBuffer sb = new StringBuffer("您好，");
            sb.append(validCode);
            sb.append("是您校验身份的验证码，用于验证身份修改密码密保等。\n音特帐户团队");
            textPart.setContent(sb.toString(), "text/html;charset=UTF-8");
            MimeMultipart mmp1 = new MimeMultipart();
            mmp1.addBodyPart(textPart);
            mmp1.setSubType("related");
            MimeBodyPart textImagePart = new MimeBodyPart();
            textImagePart.setContent(mmp1);
            MimeMultipart mmp2 = new MimeMultipart();
            mmp2.addBodyPart(textImagePart);
            mmp2.setSubType("mixed");
            Map<String ,Object> params = new HashMap<>();
            params.put("email",email);
            params.put("subject",subject);
            params.put("mmp",mmp2);
            sendSSLEmail(params);
        }catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送带附件图片的邮件
     * @param content
     * @param imageFile
     * @param attachFile
     * @param email
     * @param subject
     */
    public void sendSSLEmailAddFile(String content,File imageFile,File attachFile,String email,String subject){
        try {
            //内容
            content = content + "/r/n<img src='cid:myimg'/>";
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(content, "text/html;charset=UTF-8");
            //内嵌图片部分
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setDataHandler(new DataHandler(new FileDataSource(imageFile)));//图片路径
            imagePart.setContentID("myimg");
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataHandler dh = new DataHandler(new FileDataSource(attachFile));//文件路径
            String fileName = dh.getName();
            attachmentPart.setDataHandler(dh);
            attachmentPart.setFileName(fileName);
            //图文整合，关联关系
            MimeMultipart mmp1 = new MimeMultipart();
            mmp1.addBodyPart(textPart);
            mmp1.addBodyPart(imagePart);
            mmp1.setSubType("related");
            MimeBodyPart textImagePart = new MimeBodyPart();
            textImagePart.setContent(mmp1);
//            图文和附件整合，复杂关系
            MimeMultipart mmp2 = new MimeMultipart();
            mmp2.addBodyPart(textImagePart);
            mmp2.addBodyPart(attachmentPart);
            mmp2.setSubType("mixed");
            Map<String ,Object> params = new HashMap<>();
            params.put("email",email);
            params.put("subject",subject);
            params.put("mmp",mmp2);
            sendSSLEmail(params);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



    public void sendSSLEmail(Map<String,Object> params) {
        Session session = null;
        try {
            String email = (String) params.get("email");
            String subject = (String) params.get("subject");
            MimeMultipart mmp = (MimeMultipart) params.get("mmp");
            //设置SSL连接、邮件环境
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", port);
            props.setProperty("mail.smtp.socketFactory.port", port);
            props.setProperty("mail.smtp.auth", "true");
            //建立邮件会话
            session = Session.getInstance(props, new Authenticator() {
                //身份认证
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });
            session = Session.getDefaultInstance(props, new Authenticator() {
                //身份认证
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });
            //建立邮件对象
            MimeMessage message = new MimeMessage(session);
            //设置邮件的发件人、收件人、主题
            //附带发件人名字
//            message.setFrom(new InternetAddress("from_mail@qq.com", "optional-personal"));
            message.setFrom(new InternetAddress(userName,"音特电子（有限）公司"));
            message.setRecipients(Message.RecipientType.TO, email);
            message.setSubject(subject);
            message.setContent(mmp);
            message.saveChanges();
            //发送邮件
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null){
            }
        }
    }

    /**
     * 25端口
     * @param email
     * @param validCode
     */
//    public void sendSimpleMail(String email,String validCode)  {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(Sender);
//        message.setTo(email); //自己给自己发送邮件
//        StringBuffer sb = new StringBuffer("您好，");
//        sb.append(validCode);
//        sb.append("是您校验身份的验证码，用于验证身份修改密码密保等。\n音特帐户团队");
//        message.setSubject("音特电子");
//        message.setText(sb.toString());
//        mailSender.send(message);
//    }
}
