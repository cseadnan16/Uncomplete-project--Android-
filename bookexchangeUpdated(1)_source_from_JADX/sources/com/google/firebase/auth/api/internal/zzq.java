package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzgi;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzq implements zzfp<zzgi> {
    private final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zzq(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzgi zzgi = (zzgi) obj;
        this.zzb.zza(new zzff(zzgi.zzc(), zzgi.zzb(), Long.valueOf(zzgi.zzd()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzgi.zze()), (zzc) null, this.zza, this);
    }
}
