package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public abstract class ActionCodeEmailInfo extends ActionCodeInfo {
    public abstract String getPreviousEmail();

    public String getEmail() {
        return super.getEmail();
    }
}
