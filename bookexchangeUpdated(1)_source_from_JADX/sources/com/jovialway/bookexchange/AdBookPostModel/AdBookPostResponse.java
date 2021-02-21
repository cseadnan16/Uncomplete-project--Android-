package com.jovialway.bookexchange.AdBookPostModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdBookPostResponse {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("userAdBook")
    @Expose
    private UserAdBook userAdBook;

    public String getSuccess() {
        return this.success;
    }

    public void setSuccess(String success2) {
        this.success = success2;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status2) {
        this.status = status2;
    }

    public UserAdBook getUserAdBook() {
        return this.userAdBook;
    }

    public void setUserAdBook(UserAdBook userAdBook2) {
        this.userAdBook = userAdBook2;
    }
}
