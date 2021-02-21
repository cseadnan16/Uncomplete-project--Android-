package com.jovialway.bookexchange.loginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("exception")
    @Expose
    private Object exception;
    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("original")
    @Expose
    private Original original;

    public Headers getHeaders() {
        return this.headers;
    }

    public void setHeaders(Headers headers2) {
        this.headers = headers2;
    }

    public Original getOriginal() {
        return this.original;
    }

    public void setOriginal(Original original2) {
        this.original = original2;
    }

    public Object getException() {
        return this.exception;
    }

    public void setException(Object exception2) {
        this.exception = exception2;
    }
}
