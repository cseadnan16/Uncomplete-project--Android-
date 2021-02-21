package com.jovialway.bookexchange.loginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Original {
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;
    @SerializedName("token_type")
    @Expose
    private String tokenType;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken2) {
        this.accessToken = accessToken2;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String tokenType2) {
        this.tokenType = tokenType2;
    }

    public Integer getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(Integer expiresIn2) {
        this.expiresIn = expiresIn2;
    }
}
