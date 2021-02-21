package com.jovialway.bookexchange.Conectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityReceiver extends BroadcastReceiver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static ConnectivityReceiverListener connectivityReceiverListener;

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean z);
    }

    public void onReceive(Context context, Intent arg1) {
        NetworkInfo activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        ConnectivityReceiverListener connectivityReceiverListener2 = connectivityReceiverListener;
        if (connectivityReceiverListener2 != null) {
            connectivityReceiverListener2.onNetworkConnectionChanged(isConnected);
        }
    }

    public static boolean isConnected() {
        NetworkInfo activeNetwork = ((ConnectivityManager) MyApplication.getInstance().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
