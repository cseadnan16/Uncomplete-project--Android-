package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final /* synthetic */ class zzcl implements RemoteCall {
    private final zzcm zza;

    zzcl(zzcm zzcm) {
        this.zza = zzcm;
    }

    public final void accept(Object obj, Object obj2) {
        zzcm zzcm = this.zza;
        zzef zzef = (zzef) obj;
        zzcm.zzh = new zzfo(zzcm, (TaskCompletionSource) obj2);
        if (zzcm.zzu) {
            zzef.zza().zzf(zzcm.zze.zzf(), zzcm.zzc);
        } else {
            zzef.zza().zza(new zzcx(zzcm.zze.zzf()), (zzeo) zzcm.zzc);
        }
    }
}
