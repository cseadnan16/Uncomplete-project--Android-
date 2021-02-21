package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzgc;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzl implements zzfp<zzgc> {
    private final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zzl(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzgc zzgc = (zzgc) obj;
        this.zzb.zza(new zzff(zzgc.zzc(), zzgc.zzb(), Long.valueOf(zzgc.zzd()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzgc.zze()), (zzc) null, this.zza, this);
    }
}
