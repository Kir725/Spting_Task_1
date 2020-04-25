package com.kolmikra.controller;

import com.kolmikra.model.EmailPage;
import com.kolmikra.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class EmailPageController {

    @Autowired
    EmailSender emailSender;

    @PostMapping("/send")
    public String sendEmail(@Valid EmailPage emailPage, BindingResult result){
        if (result.hasErrors()){
            return "emailPage";
        }
        emailSender.sendEmail(emailPage);
        return "emailResult";
    }
}
