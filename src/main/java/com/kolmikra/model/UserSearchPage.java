package com.kolmikra.model;

import javax.validation.constraints.Pattern;

public class UserSearchPage {

    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Wrong name.")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Wrong second name.")
    private String secondName;

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

    @Override
    public String toString() {
        return "UserSearchPage{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
