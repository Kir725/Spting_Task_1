package com.kolmikra.service;

import com.kolmikra.model.EmailPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailPage emailPage){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailPage.getEmail());
        msg.setSubject(emailPage.getSubject());
        msg.setText(emailPage.getTextEmail());
        javaMailSender.send(msg);
    }
}
