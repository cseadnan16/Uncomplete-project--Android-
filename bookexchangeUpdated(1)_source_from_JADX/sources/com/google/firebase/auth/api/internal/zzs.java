package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzgg;
import com.google.android.gms.internal.firebase_auth.zzgi;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzs implements zzfp<zzff> {
    final /* synthetic */ zzeg zza;
    final /* synthetic */ zza zzb;
    private final /* synthetic */ zzgg zzc;
    private final /* synthetic */ Context zzd = null;

    zzs(zza zza2, zzgg zzgg, Context context, zzeg zzeg) {
        this.zzb = zza2;
        this.zzc = zzgg;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzc.zza(((zzff) obj).zzd());
        this.zzb.zzb.zza(this.zzd, this.zzc, (zzfp<zzgi>) new zzr(this, this));
    }
}
