package com.tenement.controller;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * Created by LXPENG on 2016/4/24.
 */
@Service
public class MyEmail{
    @Resource(name = "mailSender")
    JavaMailSenderImpl mailSender;

    public void sendMial(String data) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            //发件人
            messageHelper.setFrom("1292002150@qq.com");
            //设置收件人
            messageHelper.setTo("1292002150@qq.com");
            // 设置主题
            messageHelper.setSubject("测试邮件！");
            //内容
            messageHelper.setText(data);
            mailSender.send(message);
        } catch (Exception e) {
            throw new Exception("发送失败");
        }
    }

}
