package com.sendEmail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendEmail {
    public void sendEmail(String receive, String send, String userpass) {
        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.qq.com");

        // 发送服务器需要身份验证
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf;

        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
        } catch (GeneralSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(receive, "……"); //发件人邮件用户名、密码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(receive));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receive));

            // Set Subject: 头部头字段，即邮件标题
            message.setSubject("Hern商城密码找回");

            // 设置消息体，即邮件内容
            /*message.setText("HelloWord!");
             */

            //设置文件正文即邮件内容，这样可以不用使用message.setText
            String info = "<h3>您的密码是：</h3>"+"<h4>"+userpass+"</h4>";
            message.setContent(info, "text/html;charset=UTF-8");

            // 发送消息
            Transport.send(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
