package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final /* synthetic */ class zzbr implements RemoteCall {
    private final zzbs zza;

    zzbr(zzbs zzbs) {
        this.zza = zzbs;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza((zzef) obj, (TaskCompletionSource) obj2);
    }
}
