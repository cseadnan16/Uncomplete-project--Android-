package com.jovialway.bookexchange.Conectivity;

import android.app.Application;
import com.jovialway.bookexchange.Conectivity.ConnectivityReceiver;

public class MyApplication extends Application {
    private static MyApplication mInstance;

    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        MyApplication myApplication;
        synchronized (MyApplication.class) {
            myApplication = mInstance;
        }
        return myApplication;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
