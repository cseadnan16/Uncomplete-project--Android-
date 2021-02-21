package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.firebase.auth.internal.zza;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzcm extends zzfe<Void, zza> {
    public zzcm() {
        super(2);
    }

    public final String zza() {
        return "reload";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzcl(this)).build();
    }

    public final void zze() {
        ((zza) this.zzf).zza(this.zzk, zzau.zza(this.zzd, this.zzl));
        zzb(null);
    }
}
