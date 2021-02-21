package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzev extends Api.AbstractClientBuilder<zzef, zzeu> {
    zzev() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzei(context, looper, clientSettings, (zzeu) obj, connectionCallbacks, onConnectionFailedListener);
    }
}
