package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final /* synthetic */ class zzcv implements RemoteCall {
    private final zzcw zza;

    zzcv(zzcw zzcw) {
        this.zza = zzcw;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza((zzef) obj, (TaskCompletionSource) obj2);
    }
}
