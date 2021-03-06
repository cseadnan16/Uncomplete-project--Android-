package com.example.myapplication.Model;

public class SessionData {

        private int id;
        private String name;
        private String email;
        private String mobile;
        private String address;
        private String token;

    public SessionData() {
        this.id = id;
        this.token = token;
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
    }

    public SessionData(String token) {
        this.token = token;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getToken() {
        return token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
