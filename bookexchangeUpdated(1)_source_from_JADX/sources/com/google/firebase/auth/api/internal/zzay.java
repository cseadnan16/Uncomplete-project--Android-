package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcb;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzg;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzay extends zzfe<ActionCodeResult, zza> {
    private final zzcb zza;

    public zzay(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = new zzcb(str, str2);
    }

    public final String zza() {
        return "checkActionCode";
    }

    public final TaskApiCall<zzef, ActionCodeResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzax(this)).build();
    }

    public final void zze() {
        zzb(new zzg(this.zzn));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        if (this.zzu) {
            zzef.zza().zzi(this.zza.zza(), this.zzc);
        } else {
            zzef.zza().zza(this.zza, (zzeo) this.zzc);
        }
    }
}
