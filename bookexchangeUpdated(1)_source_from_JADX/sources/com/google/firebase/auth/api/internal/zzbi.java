package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.internal.zza;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbi extends zzfe<Void, zza> {
    private final zzcj zza;

    public zzbi(PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, String str2) {
        super(2);
        Preconditions.checkNotNull(phoneMultiFactorAssertion);
        Preconditions.checkNotEmpty(str);
        this.zza = new zzcj(phoneMultiFactorAssertion.zza(), str, str2);
    }

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setFeatures(zze.zzb).setAutoResolveMissingFeatures(false).run(new zzbh(this)).build();
    }

    public final void zze() {
        ((zza) this.zzf).zza(this.zzk, zzau.zza(this.zzd, this.zzl));
        zzb(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        zzef.zza().zza(this.zza, (zzeo) this.zzc);
    }
}
