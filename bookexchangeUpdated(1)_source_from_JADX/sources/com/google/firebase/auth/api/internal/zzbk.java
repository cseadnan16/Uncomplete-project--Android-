package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcl;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzn;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbk extends zzfe<AuthResult, zza> {
    private final zzcl zza;

    public zzbk(PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str) {
        super(2);
        Preconditions.checkNotNull(phoneMultiFactorAssertion);
        Preconditions.checkNotEmpty(str);
        this.zza = new zzcl(phoneMultiFactorAssertion.zza(), str);
    }

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public final TaskApiCall<zzef, AuthResult> zzb() {
        return TaskApiCall.builder().setFeatures(zze.zzb).setAutoResolveMissingFeatures(false).run(new zzbj(this)).build();
    }

    public final void zze() {
        zzn zza2 = zzau.zza(this.zzd, this.zzl);
        if (this.zze == null || this.zze.getUid().equalsIgnoreCase(zza2.getUid())) {
            ((zza) this.zzf).zza(this.zzk, zza2);
            zzb(new zzh(zza2));
            return;
        }
        zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        zzef.zza().zza(this.zza, (zzeo) this.zzc);
    }
}
