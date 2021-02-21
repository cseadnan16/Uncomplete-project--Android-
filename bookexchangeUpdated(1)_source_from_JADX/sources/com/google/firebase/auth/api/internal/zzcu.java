package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.firebase_auth.zzdh;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzn;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzcu extends zzfe<AuthResult, zza> {
    private final zzdh zza;

    public zzcu(String str) {
        super(2);
        this.zza = new zzdh(str);
    }

    public final String zza() {
        return "signInAnonymously";
    }

    public final TaskApiCall<zzef, AuthResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzct(this)).build();
    }

    public final void zze() {
        zzn zza2 = zzau.zza(this.zzd, this.zzl);
        ((zza) this.zzf).zza(this.zzk, zza2);
        zzb(new zzh(zza2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        if (this.zzu) {
            zzef.zza().zza(this.zzc);
        } else {
            zzef.zza().zza(this.zza, (zzeo) this.zzc);
        }
    }
}
