package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzbx;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zza;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzdq extends zzfe<Void, zza> {
    private final String zza;

    public zzdq(String str) {
        super(2);
        this.zza = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
    }

    public final String zza() {
        return "updateEmail";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzdp(this)).build();
    }

    public final void zze() {
        ((zza) this.zzf).zza(this.zzk, zzau.zza(this.zzd, this.zzl));
        zzb(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        if (this.zzu) {
            zzef.zza().zza(this.zze.zzf(), this.zza, (zzeo) this.zzc);
        } else {
            zzef.zza().zza(new zzbx(this.zze.zzf(), this.zza), (zzeo) this.zzc);
        }
    }
}
