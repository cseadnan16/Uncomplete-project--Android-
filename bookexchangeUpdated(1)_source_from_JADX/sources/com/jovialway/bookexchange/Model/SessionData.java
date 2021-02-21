package com.jovialway.bookexchange.Model;

public class SessionData {
    private String address;
    private String email;

    /* renamed from: id */
    private int f125id;
    private String mobile;
    private String name;
    private String profile_image;
    private String token;

    public SessionData() {
        this.f125id = this.f125id;
        this.token = this.token;
        this.name = this.name;
        this.email = this.email;
        this.address = this.address;
        this.mobile = this.mobile;
        this.profile_image = this.profile_image;
    }

    public SessionData(String token2) {
        this.token = token2;
    }

    public int getId() {
        return this.f125id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getAddress() {
        return this.address;
    }

    public String getProfile_image() {
        return this.profile_image;
    }

    public String getToken() {
        return this.token;
    }

    public void setId(int id) {
        this.f125id = id;
    }

    public void setToken(String token2) {
        this.token = token2;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public void setEmail(String email2) {
        this.email = email2;
    }

    public void setMobile(String mobile2) {
        this.mobile = mobile2;
    }

    public void setAddress(String address2) {
        this.address = address2;
    }

    public void setProfile_image(String profile_image2) {
        this.profile_image = profile_image2;
    }
}
