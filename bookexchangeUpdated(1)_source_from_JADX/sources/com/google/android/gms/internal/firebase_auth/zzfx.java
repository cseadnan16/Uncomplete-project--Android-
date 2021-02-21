package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzel;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzfx implements zzel<zzfx, zzp.zzq> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private long zze;

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zze;
    }

    public final zzjx<zzp.zzq> zza() {
        return zzp.zzq.zzf();
    }

    public final /* synthetic */ zzel zza(zzjn zzjn) {
        if (zzjn instanceof zzp.zzq) {
            zzp.zzq zzq = (zzp.zzq) zzjn;
            this.zza = Strings.emptyToNull(zzq.zza());
            this.zzb = Strings.emptyToNull(zzq.zzb());
            this.zzc = Strings.emptyToNull(zzq.zzc());
            this.zzd = Strings.emptyToNull(zzq.zzd());
            this.zze = zzq.zze();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of SignUpNewUserResponse.");
    }
}
