package com.jovialway.bookexchange.loginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("token")
    @Expose
    private Token token;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("user_information")
    @Expose
    private UserInformation userInformation;

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId2) {
        this.userId = userId2;
    }

    public UserInformation getUserInformation() {
        return this.userInformation;
    }

    public void setUserInformation(UserInformation userInformation2) {
        this.userInformation = userInformation2;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status2) {
        this.status = status2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        this.message = message2;
    }

    public Token getToken() {
        return this.token;
    }

    public void setToken(Token token2) {
        this.token = token2;
    }
}
