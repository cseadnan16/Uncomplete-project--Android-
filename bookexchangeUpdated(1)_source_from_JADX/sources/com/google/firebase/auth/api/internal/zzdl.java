package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final /* synthetic */ class zzdl implements RemoteCall {
    private final zzdm zza;

    zzdl(zzdm zzdm) {
        this.zza = zzdm;
    }

    public final void accept(Object obj, Object obj2) {
        zzdm zzdm = this.zza;
        zzef zzef = (zzef) obj;
        zzdm.zzh = new zzfo(zzdm, (TaskCompletionSource) obj2);
        if (zzdm.zzu) {
            zzef.zza().zze(zzdm.zze.zzf(), zzdm.zzc);
        } else {
            zzef.zza().zza(new zzdz(zzdm.zze.zzf()), (zzeo) zzdm.zzc);
        }
    }
}
