package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzz;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbg extends zzfe<SignInMethodQueryResult, zza> {
    private final zzcp zza;

    public zzbg(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new zzcp(str, str2);
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final TaskApiCall<zzef, SignInMethodQueryResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzbf(this)).build();
    }

    public final void zze() {
        zzb(new zzz(this.zzm.zzb()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        if (this.zzu) {
            zzef.zza().zzc(this.zza.zza(), this.zzc);
        } else {
            zzef.zza().zza(this.zza, (zzeo) this.zzc);
        }
    }
}
