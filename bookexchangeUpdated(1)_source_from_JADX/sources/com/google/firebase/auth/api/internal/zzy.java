package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzeu;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.firebase.auth.internal.zzaa;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzy implements zzfp<zzeu> {
    private final /* synthetic */ zzfp zza;
    private final /* synthetic */ zzff zzb;
    private final /* synthetic */ zzv zzc;

    zzy(zzv zzv, zzfp zzfp, zzff zzff) {
        this.zzc = zzv;
        this.zza = zzfp;
        this.zzb = zzff;
    }

    public final void zza(String str) {
        this.zzc.zzb.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzew> zzb2 = ((zzeu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzfs zzfs = new zzfs();
        zzfs.zzb(this.zzb.zzd()).zzg(this.zzc.zza);
        this.zzc.zzc.zza(this.zzc.zzb, this.zzb, zzb2.get(0), zzfs, (zzfq) this.zza);
    }
}
