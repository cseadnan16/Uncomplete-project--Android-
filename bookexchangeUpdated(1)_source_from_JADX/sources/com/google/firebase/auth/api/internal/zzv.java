package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzeu;
import com.google.android.gms.internal.firebase_auth.zzev;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzv implements zzfp<zzff> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzeg zzb;
    final /* synthetic */ zza zzc;

    zzv(zza zza2, String str, zzeg zzeg) {
        this.zzc = zza2;
        this.zza = str;
        this.zzb = zzeg;
    }

    public final void zza(String str) {
        this.zzb.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzff zzff = (zzff) obj;
        this.zzc.zzb.zza(new zzev(zzff.zzd()), (zzfp<zzeu>) new zzy(this, this, zzff));
    }
}
