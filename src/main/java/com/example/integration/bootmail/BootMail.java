package com.example.integration.bootmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootMail {
	@Autowired
    private JavaMailSender mailSender;
    @GetMapping("/send")
    private void send(){
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("179813964@qq.com");
        // 收件人
        message.setTo("2425990981@qq.com");
        // 邮件标题
        message.setSubject("Java发送邮件第二弹");
        // 邮件内容
        message.setText("你好，这是一条用于测试Spring Boot邮件发送功能的邮件！哈哈哈~~~");
        // 抄送人
       // message.setCc("xxx@qq.com");
        mailSender.send(message);
    }

}
