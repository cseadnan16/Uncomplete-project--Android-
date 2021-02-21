package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzn;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzde extends zzfe<AuthResult, zza> {
    private final zzdr zza;

    public zzde(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential);
        this.zza = new zzdr(phoneAuthCredential, str);
    }

    public final String zza() {
        return "signInWithPhoneNumber";
    }

    public final TaskApiCall<zzef, AuthResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzdd(this)).build();
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
            zzef.zza().zza(this.zza.zza(), (zzeo) this.zzc);
        } else {
            zzef.zza().zza(this.zza, (zzeo) this.zzc);
        }
    }
}
