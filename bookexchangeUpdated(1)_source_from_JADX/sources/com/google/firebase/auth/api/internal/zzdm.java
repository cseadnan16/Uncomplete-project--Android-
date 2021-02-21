package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzn;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzdm extends zzfe<AuthResult, zza> {
    public zzdm() {
        super(2);
    }

    public final String zza() {
        return "unlinkEmailCredential";
    }

    public final TaskApiCall<zzef, AuthResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzdl(this)).build();
    }

    public final void zze() {
        zzn zza = zzau.zza(this.zzd, this.zzl);
        ((zza) this.zzf).zza(this.zzk, zza);
        zzb(new zzh(zza));
    }
}
