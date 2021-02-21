package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final /* synthetic */ class zzbb implements RemoteCall {
    private final zzbc zza;

    zzbb(zzbc zzbc) {
        this.zza = zzbc;
    }

    public final void accept(Object obj, Object obj2) {
        zzbc zzbc = this.zza;
        zzef zzef = (zzef) obj;
        zzbc.zzh = new zzfo(zzbc, (TaskCompletionSource) obj2);
        if (zzbc.zzu) {
            zzef.zza().zzc(zzbc.zza.zza(), zzbc.zza.zzb(), (zzeo) zzbc.zzc);
        } else {
            zzef.zza().zza(zzbc.zza, (zzeo) zzbc.zzc);
        }
    }
}
