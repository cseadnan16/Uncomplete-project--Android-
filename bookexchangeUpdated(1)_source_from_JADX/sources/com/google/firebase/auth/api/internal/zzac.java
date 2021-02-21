package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzeo;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzac implements zzfp<zzff> {
    final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zzac(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zzb.zza(new zzeo(((zzff) obj).zzd()), (zzfp<Void>) new zzab(this, this));
    }
}
