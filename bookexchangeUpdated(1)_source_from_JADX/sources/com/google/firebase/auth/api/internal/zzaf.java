package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzaf implements zzfp<zzff> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzeg zzb;
    private final /* synthetic */ zza zzc;

    zzaf(zza zza2, UserProfileChangeRequest userProfileChangeRequest, zzeg zzeg) {
        this.zzc = zza2;
        this.zza = userProfileChangeRequest;
        this.zzb = zzeg;
    }

    public final void zza(String str) {
        this.zzb.zza(zzaa.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzff zzff = (zzff) obj;
        zzfs zzfs = new zzfs();
        zzfs.zzb(zzff.zzd());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzfs.zze(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzfs.zzf(this.zza.zza());
        }
        this.zzc.zza(this.zzb, zzff, zzfs, (zzfq) this);
    }
}
