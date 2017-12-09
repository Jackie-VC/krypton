package com.assignment.cryptocurrency.util;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailUtil {

  public static void sendSimpleMail(String to, String content) throws Exception {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("longestar@sina.com");
    message.setTo(to);
    message.setSubject("Verify user");
    message.setText(content);
    mailSender.setDefaultEncoding("utf-8");
    mailSender.setHost("smtp.sina.com");
    mailSender.setPort(25);
    mailSender.setProtocol("smtp");
    mailSender.setUsername("longestar@sina.com");
    mailSender.setPassword("123456");
    mailSender.send(message);
  }

}