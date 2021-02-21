package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzeu;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzz implements zzfp<zzeu> {
    private final /* synthetic */ zzfp zza;
    private final /* synthetic */ zzff zzb;
    private final /* synthetic */ zzaa zzc;

    zzz(zzaa zzaa, zzfp zzfp, zzff zzff) {
        this.zzc = zzaa;
        this.zza = zzfp;
        this.zzb = zzff;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzew> zzb2 = ((zzeu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zza(this.zzb, zzb2.get(0));
        }
    }
}
