package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzdn;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzn;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzce extends zzfe<Void, zza> {
    private final zzdn zza;

    public zzce(String str, String str2, String str3) {
        super(2);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        Preconditions.checkNotEmpty(str2, "password cannot be null or empty");
        this.zza = new zzdn(str, str2, str3);
    }

    public final String zza() {
        return "reauthenticateWithEmailPassword";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzcd(this)).build();
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
            zzef.zza().zzd(this.zza.zza(), this.zza.zzb(), this.zzc);
        } else {
            zzef.zza().zza(this.zza, (zzeo) this.zzc);
        }
    }
}
