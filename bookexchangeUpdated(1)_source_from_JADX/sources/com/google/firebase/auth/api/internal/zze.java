package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzgh;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zze implements zzfp<zzgh> {
    private final /* synthetic */ zzeg zza;
    private final /* synthetic */ zza zzb;

    zze(zza zza2, zzeg zzeg) {
        this.zzb = zza2;
        this.zza = zzeg;
    }

    public final void zza(String str) {
        this.zza.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzgh zzgh = (zzgh) obj;
        if (!zzgh.zzg()) {
            this.zzb.zza(new zzff(zzgh.zzc(), zzgh.zzb(), Long.valueOf(zzgh.zzd()), "Bearer"), (String) null, (String) null, false, (zzc) null, this.zza, this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new zzej(zzgh.zzf(), zzgh.zze(), (zzc) null));
        } else {
            zza.zza.mo11213e("Need to do multi-factor auth, but SDK does not support it.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
