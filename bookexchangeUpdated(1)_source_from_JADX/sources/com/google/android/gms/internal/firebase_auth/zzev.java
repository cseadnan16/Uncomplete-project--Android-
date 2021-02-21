package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfw;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzev implements zzfw<zzp.zzf> {
    private String zza;

    public zzev(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzjn zza() {
        return (zzp.zzf) ((zzif) zzp.zzf.zza().zza(this.zza).zzg());
    }
}
