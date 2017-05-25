package com.yfkj.bms.common.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import com.yfkj.bms.common.constants.WXConstants;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSender {

        public static boolean send(String toEmail,String content){
                try {
                        String host = "smtp.exmail.qq.com";
                        int port = 25;
                        String username = WXConstants.EMAIL_USER_NAME;
                        String password = WXConstants.EMAIL_USER_PASSWORD;
                        Properties javaMailProperties = new Properties();
                        javaMailProperties.put("mail.smtp.auth", true);
                        javaMailProperties.put("mail.smtp.starttls.enable", true);
                        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
                        mailSender.setHost(host);
                        mailSender.setPort(port);
                        mailSender.setUsername(username);
                        mailSender.setPassword(password);
                        mailSender.setJavaMailProperties(javaMailProperties);
                        String email = toEmail;
                        MimeMessage message = mailSender.createMimeMessage();
                        MimeMessageHelper help = new MimeMessageHelper(message, true, "UTF-8");
                        help.setFrom(username);
                        help.setTo(new String[]{email});
                        help.setSubject("测试发个邮件");
                        help.setText(content, true);
                        mailSender.send(message);
                        return true;
                }catch (Exception e){
                        e.printStackTrace();
                        return false;
                }
       }

        public static void main(String[] args) {
                MailSender.send(WXConstants.EMAIL_CUSTOM,WXConstants.EMAIL_MSG);
        }
}


