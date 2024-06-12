package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("FilterBean")
public class FilterBean {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;

    public FilterBean(String name, String email, String phone, String address, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
