package com.securtime.reports.EmailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Component
public class EmailSender {

    @Autowired
    public JavaMailSender emailSender;

    // ----------->>>>>>>>Send Email With Attachment<<<<<<<<<-----------------//
    public void sendMailWithAttachment(String to, String subject,String body, File attachment, String fileName)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = emailSender.createMimeMessage();
        message.setFrom(new InternetAddress("from", "SecurTime"));
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true);
        helper.addAttachment(fileName, attachment);
        emailSender.send(message);


    }


}
