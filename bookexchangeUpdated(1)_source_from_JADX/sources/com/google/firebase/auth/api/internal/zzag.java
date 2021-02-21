package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfx;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzag implements zzfp<zzfx> {
    private final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zzag(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzfx zzfx = (zzfx) obj;
        this.zzb.zza(new zzff(zzfx.zzc(), zzfx.zzb(), Long.valueOf(zzfx.zzd()), "Bearer"), (String) null, (String) null, true, (zzc) null, this.zza, this);
    }
}
