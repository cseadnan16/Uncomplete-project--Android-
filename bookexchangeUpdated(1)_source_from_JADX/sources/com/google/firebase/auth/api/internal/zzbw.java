package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzc;
import com.google.firebase.auth.internal.zzn;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbw extends zzfe<Void, zza> {
    private final zzdj zza;

    public zzbw(AuthCredential authCredential, String str) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zza = new zzdj(zzc.zza(authCredential, str).zza(false));
    }

    public final String zza() {
        return "reauthenticateWithCredential";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzbv(this)).build();
    }

    public final void zze() {
        zzn zza2 = zzau.zza(this.zzd, this.zzl);
        if (this.zze.getUid().equalsIgnoreCase(zza2.getUid())) {
            ((zza) this.zzf).zza(this.zzk, zza2);
            zzb(null);
            return;
        }
        zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        if (this.zzu) {
            zzef.zza().zza(this.zza.zza(), (zzeo) this.zzc);
        } else {
            zzef.zza().zza(this.zza, (zzeo) this.zzc);
        }
    }
}
