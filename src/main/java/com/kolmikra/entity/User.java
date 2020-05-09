package com.kolmikra.entity;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class User {
    private String name;

    private String secondName;

    private String middleName;

    private String email;

    private double salary;

    private String job;

    public User(String name, String secondName, String middleName, String email, double salary, String job) {
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.email = email;
        this.salary = salary;
        this.job = job;
    }

    public User(String userString){
        List<String> user = Arrays.stream(userString.split(" ")).collect(Collectors.toList());
        new User(user.get(0),user.get(1),user.get(2),user.get(3),Double.parseDouble(user.get(4)),user.get(5));
    }
}
