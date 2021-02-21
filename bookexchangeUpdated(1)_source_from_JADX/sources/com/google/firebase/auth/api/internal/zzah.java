package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzah implements zzfp<zzff> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzeg zzb;
    private final /* synthetic */ zza zzc;

    zzah(zza zza2, String str, zzeg zzeg) {
        this.zzc = zza2;
        this.zza = str;
        this.zzb = zzeg;
    }

    public final void zza(String str) {
        this.zzb.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzff zzff = (zzff) obj;
        String zzd = zzff.zzd();
        zzfs zzfs = new zzfs();
        zzfs.zzb(zzd).zzd(this.zza);
        this.zzc.zza(this.zzb, zzff, zzfs, (zzfq) this);
    }
}
