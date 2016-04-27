package com.tenement.service.serviceImplements.common;

import com.tenement.common.util.ClassUtil;
import com.tenement.mapper.CaptchaCodeMapper;
import com.tenement.model.CaptchaCode;
import com.tenement.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.UUID;

/**
 * Created by LXPENG on 2016/4/25.
 */
@Service
public class mailService {
    @Resource(name = "mailSender")
    JavaMailSenderImpl mailSender;

    @Autowired
    CaptchaCodeMapper captchaCodeMapper;

    @Autowired
    UserService userService;


    public void sendMial(String account) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();

        if (userService.checkAccount(account)) {
            throw new Exception("用户不存在");
        }

        String secreKey = UUID.randomUUID().toString();
        //创建时间
        Date createDate = new Date();
        //过期时间 10分钟后
        Date invalidTime = new Date(createDate.getTime() + 10 * 60 * 1000);
        String key = account + "_" + invalidTime + "_" + secreKey;
        //MD5加密
        String keyMD5 = DigestUtils.md5Hex(key);


        CaptchaCode captchaCode = new CaptchaCode(keyMD5, createDate, invalidTime, account, account, false);
        ClassUtil.setDefaultValues(captchaCode);
        int result = captchaCodeMapper.insert(captchaCode);
        if (result < 1) {
            throw new Exception("发送失败");
        }

        String resetPassHref = "http://localhost:8080/" + "home/checkLink?sid="
                + keyMD5;

        String emailContent  = "请勿回复本邮件.点击下面的链接,重设密码 <br/><a href='"
                + resetPassHref + "' target='_BLANK'>" + resetPassHref
                + "</a>"
                + "<br/>本邮件超过10分钟,链接将会失效";
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            //发件人
            messageHelper.setFrom("1292002150@qq.com");
            //设置收件人
            messageHelper.setTo("1292002150@qq.com");
            // 设置主题
            messageHelper.setSubject("测试邮件！");
            //内容 发送html格式内容
            messageHelper.setText(emailContent, true);
            mailSender.send(message);
        } catch (Exception e) {
            throw new Exception("发送失败");
        }
    }
}
