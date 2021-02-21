package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzp implements zzfp<zzff> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzeg zzc;
    private final /* synthetic */ zza zzd;

    zzp(zza zza2, String str, String str2, zzeg zzeg) {
        this.zzd = zza2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzeg;
    }

    public final void zza(String str) {
        this.zzc.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzff zzff = (zzff) obj;
        zzfs zzfs = new zzfs();
        zzfs.zzb(zzff.zzd()).zzc(this.zza).zzd(this.zzb);
        this.zzd.zza(this.zzc, zzff, zzfs, (zzfq) this);
    }
}
