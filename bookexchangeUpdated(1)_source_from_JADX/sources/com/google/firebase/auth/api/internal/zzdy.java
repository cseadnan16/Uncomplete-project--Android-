package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.internal.firebase_auth.zzef;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzdy extends zzfe<Void, Void> {
    private final zzef zza;

    public zzdy(String str, String str2, ActionCodeSettings actionCodeSettings) {
        super(6);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        this.zza = new zzef(str, str2, actionCodeSettings);
    }

    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    public final TaskApiCall<zzef, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(zze.zzb).run(new zzdx(this)).build();
    }

    public final void zze() {
        zzb(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfo(this, taskCompletionSource);
        zzef.zza().zza(this.zza, (zzeo) this.zzc);
    }
}
