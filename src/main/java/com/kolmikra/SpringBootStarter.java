package com.kolmikra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class SpringBootStarter {

    public static void main(String[] args){
        SpringApplication.run(SpringBootStarter.class, args);
    }

}
