package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzw implements zzfp<zzff> {
    private final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zzw(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzff zzff = (zzff) obj;
        zzfs zzfs = new zzfs();
        zzfs.zzb(zzff.zzd()).zzc((String) null).zzd((String) null);
        this.zzb.zza(this.zza, zzff, zzfs, (zzfq) this);
    }
}
