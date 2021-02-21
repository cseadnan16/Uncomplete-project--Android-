package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.android.gms.internal.firebase_auth.zzfv;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzi implements zzfp<zzfv> {
    private final /* synthetic */ zzfs zza;
    private final /* synthetic */ zzew zzb;
    private final /* synthetic */ zzeg zzc;
    private final /* synthetic */ zzff zzd;
    private final /* synthetic */ zzfq zze;
    private final /* synthetic */ zza zzf;

    zzi(zza zza2, zzfs zzfs, zzew zzew, zzeg zzeg, zzff zzff, zzfq zzfq) {
        this.zzf = zza2;
        this.zza = zzfs;
        this.zzb = zzew;
        this.zzc = zzeg;
        this.zzd = zzff;
        this.zze = zzfq;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzfv zzfv = (zzfv) obj;
        if (this.zza.zza("EMAIL")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zza("DISPLAY_NAME")) {
            this.zzb.zzb((String) null);
        } else if (this.zza.zzd() != null) {
            this.zzb.zzb(this.zza.zzd());
        }
        if (this.zza.zza("PHOTO_URL")) {
            this.zzb.zzc((String) null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzc(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzc())) {
            this.zzb.zzd(Base64Utils.encode("redacted".getBytes()));
        }
        List zzf2 = zzfv.zzf();
        if (zzf2 == null) {
            zzf2 = new ArrayList();
        }
        this.zzb.zza((List<zzfj>) zzf2);
        this.zzc.zza(zza.zza(this.zzd, zzfv), this.zzb);
    }
}
