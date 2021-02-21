package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzeu;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfs;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzf implements zzfp<zzeu> {
    private final /* synthetic */ zzfq zza;
    private final /* synthetic */ zzeg zzb;
    private final /* synthetic */ zzff zzc;
    private final /* synthetic */ zzfs zzd;
    private final /* synthetic */ zza zze;

    zzf(zza zza2, zzfq zzfq, zzeg zzeg, zzff zzff, zzfs zzfs) {
        this.zze = zza2;
        this.zza = zzfq;
        this.zzb = zzeg;
        this.zzc = zzff;
        this.zzd = zzfs;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzew> zzb2 = ((zzeu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zze.zza(this.zzb, this.zzc, zzb2.get(0), this.zzd, this.zza);
        }
    }
}
