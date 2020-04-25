package com.kolmikra.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmailPage {

    @NotEmpty
    @Email
    private String email;
    private String subject = "";
    private String textEmail = "";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(String textEmail) {
        this.textEmail = textEmail;
    }

    @Override
    public String toString() {
        return "EmailPage{" +
                "email='" + email + '\'' +
                ", topic='" + subject + '\'' +
                ", textEmail='" + textEmail + '\'' +
                '}';
    }
}
