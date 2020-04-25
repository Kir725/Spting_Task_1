package com.kolmikra.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

public class MainPage {

    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Wrong name")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Wrong second name")
    private String secondName;

    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Wrong middle name")
    private String middleName;

    @NotEmpty
    @Email
    private String email;

    private double salary;

    @Pattern(regexp = "^[a-zA-Z]{4,20}$", message = "Wrong job")
    private String job;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "MainPage{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }
}
