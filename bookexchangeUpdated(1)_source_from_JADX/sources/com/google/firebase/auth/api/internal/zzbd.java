package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzch;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final /* synthetic */ class zzbd implements RemoteCall {
    private final zzbe zza;

    zzbd(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final void accept(Object obj, Object obj2) {
        zzbe zzbe = this.zza;
        zzef zzef = (zzef) obj;
        zzbe.zzh = new zzfo(zzbe, (TaskCompletionSource) obj2);
        if (zzbe.zzu) {
            zzef.zza().zzg(zzbe.zze.zzf(), zzbe.zzc);
        } else {
            zzef.zza().zza(new zzch(zzbe.zze.zzf()), (zzeo) zzbe.zzc);
        }
    }
}
