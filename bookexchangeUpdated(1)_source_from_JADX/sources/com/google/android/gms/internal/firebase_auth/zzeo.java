package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfw;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzeo implements zzfw<zzp.zzc> {
    private String zza;

    public zzeo(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzjn zza() {
        return (zzp.zzc) ((zzif) zzp.zzc.zza().zza(this.zza).zzg());
    }
}
