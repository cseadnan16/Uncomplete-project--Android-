package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzer;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzd implements zzfp<zzff> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ zzeg zzb;
    private final /* synthetic */ zza zzc;

    zzd(zza zza2, EmailAuthCredential emailAuthCredential, zzeg zzeg) {
        this.zzc = zza2;
        this.zza = emailAuthCredential;
        this.zzb = zzeg;
    }

    public final void zza(String str) {
        this.zzb.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzc.zza(new zzer(this.zza, ((zzff) obj).zzd()), this.zzb);
    }
}
