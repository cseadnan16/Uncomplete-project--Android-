package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzgi;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzr implements zzfp<zzgi> {
    private final /* synthetic */ zzfp zza;
    private final /* synthetic */ zzs zzb;

    zzr(zzs zzs, zzfp zzfp) {
        this.zzb = zzs;
        this.zza = zzfp;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzgi zzgi = (zzgi) obj;
        if (!TextUtils.isEmpty(zzgi.zzf())) {
            this.zzb.zza.zza(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zza(zzgi.zzg(), zzgi.zzf()));
            return;
        }
        this.zzb.zzb.zza(new zzff(zzgi.zzc(), zzgi.zzb(), Long.valueOf(zzgi.zzd()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzgi.zze()), (zzc) null, this.zzb.zza, this.zza);
    }
}
