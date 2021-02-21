package com.jovialway.bookexchange.SessionClass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.jovialway.bookexchange.Activity.Login;
import com.jovialway.bookexchange.Model.SessionData;

/* renamed from: com.jovialway.bookexchange.SessionClass.SessionClass */
public class C1220SessionClass {
    private static final String KEY_ADDRESS = "keyeaddress";
    private static final String KEY_EMAIL = "keyeemail";
    private static final String KEY_ID = "keyid";
    private static final String KEY_MOBILE = "keyemobile";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_PROFILE_IMAGE = "keyeprofileimage";
    private static final String KEY_TOKEN = "keytoken";
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static Context mCtx;
    private static C1220SessionClass mInstance;

    private C1220SessionClass(Context context) {
        mCtx = context;
    }

    public static synchronized C1220SessionClass getInstance(Context context) {
        C1220SessionClass sessionClass;
        synchronized (C1220SessionClass.class) {
            if (mInstance == null) {
                mInstance = new C1220SessionClass(context);
            }
            sessionClass = mInstance;
        }
        return sessionClass;
    }

    public void userLogin(SessionData sessionData) {
        SharedPreferences.Editor editor = mCtx.getSharedPreferences(SHARED_PREF_NAME, 0).edit();
        editor.putInt(KEY_ID, sessionData.getId());
        editor.putString(KEY_TOKEN, sessionData.getToken());
        editor.putString(KEY_NAME, sessionData.getName());
        editor.putString(KEY_EMAIL, sessionData.getEmail());
        editor.putString(KEY_ADDRESS, sessionData.getAddress());
        editor.putString(KEY_MOBILE, sessionData.getMobile());
        editor.putString(KEY_PROFILE_IMAGE, sessionData.getProfile_image());
        editor.apply();
    }

    public boolean isLoggedIn() {
        if (mCtx.getSharedPreferences(SHARED_PREF_NAME, 0).getString(KEY_TOKEN, (String) null) != null) {
            return true;
        }
        return false;
    }

    public SessionData getUser() {
        return new SessionData(mCtx.getSharedPreferences(SHARED_PREF_NAME, 0).getString(KEY_ID, (String) null));
    }

    public void logout() {
        SharedPreferences.Editor editor = mCtx.getSharedPreferences(SHARED_PREF_NAME, 0).edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, Login.class));
    }
}
