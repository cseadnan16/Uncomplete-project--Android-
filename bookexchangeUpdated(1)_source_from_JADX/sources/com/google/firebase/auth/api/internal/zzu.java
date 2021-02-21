package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.internal.firebase_auth.zzga;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzu implements zzfp<zzff> {
    final /* synthetic */ zzeg zza;
    final /* synthetic */ zza zzb;
    private final /* synthetic */ zzfy zzc;

    zzu(zza zza2, zzfy zzfy, zzeg zzeg) {
        this.zzb = zza2;
        this.zzc = zzfy;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzff zzff = (zzff) obj;
        if (this.zzb.zzc.zza()) {
            this.zzc.zzc(true);
        }
        this.zzc.zza(zzff.zzd());
        this.zzb.zzb.zza((Context) null, this.zzc, (zzfp<zzga>) new zzt(this, this));
    }
}
