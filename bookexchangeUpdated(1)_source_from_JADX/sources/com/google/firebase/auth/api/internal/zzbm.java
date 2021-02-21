package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzar;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbm extends zzfe<GetTokenResult, zza> {
    private final zzcn zza;

    public zzbm(String str) {
        super(1);
        Preconditions.checkNotEmpty(str, "refresh token cannot be null");
        this.zza = new zzcn(str);
    }

    public final String zza() {
        return "getAccessToken";
    }

    public final TaskApiCall<zzef, GetTokenResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzbl(this)).build();
    }

    public final void zze() {
        if (TextUtils.isEmpty(this.zzk.zzc())) {
            this.zzk.zza(this.zza.zza());
        }
        ((zza) this.zzf).zza(this.zzk, this.zze);
        zzb(zzar.zza(this.zzk.zzd()));
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
