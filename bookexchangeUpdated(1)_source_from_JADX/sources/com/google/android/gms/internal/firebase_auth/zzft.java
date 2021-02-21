package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzel;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzft implements zzel<zzft, zzp.zzm> {
    private String zza;

    public final String zzb() {
        return this.zza;
    }

    public final zzjx<zzp.zzm> zza() {
        return zzp.zzm.zzb();
    }

    public final /* synthetic */ zzel zza(zzjn zzjn) {
        if (zzjn instanceof zzp.zzm) {
            this.zza = ((zzp.zzm) zzjn).zza();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of SendVerificationCodeResponse.");
    }
}
