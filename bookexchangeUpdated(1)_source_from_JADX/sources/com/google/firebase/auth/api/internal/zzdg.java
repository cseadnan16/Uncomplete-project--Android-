package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzdg extends zzfe<Void, zza> {
    private final zzdt zza;

    public zzdg(zzy zzy, String str, String str2, long j, boolean z, boolean z2) {
        super(8);
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotEmpty(str);
        this.zza = new zzdt(zzy.zza(), str, str2, j, z, z2);
    }

    public final String zza() {
        return "startMfaEnrollmentWithPhoneNumber";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setFeatures(zze.zzb).setAutoResolveMissingFeatures(false).run(new zzdf(this)).build();
    }

    public final void zze() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        zzef.zza().zza(this.zza, (zzeo) this.zzc);
    }
}
