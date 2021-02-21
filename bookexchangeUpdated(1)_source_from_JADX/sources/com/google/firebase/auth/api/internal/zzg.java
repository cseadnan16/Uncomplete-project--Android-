package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzg implements zzfp<zzeq> {
    private final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zzg(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzeq zzeq = (zzeq) obj;
        if (!zzeq.zzh()) {
            this.zzb.zza(new zzff(zzeq.zzc(), zzeq.zzb(), Long.valueOf(zzeq.zze()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzeq.zzd()), (zzc) null, this.zza, this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new zzej(zzeq.zzg(), zzeq.zzf(), (zzc) null));
        } else {
            zza.zza.mo11213e("Need to do multi-factor auth, but either the SDK does not support it, or the flag is disabled.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
