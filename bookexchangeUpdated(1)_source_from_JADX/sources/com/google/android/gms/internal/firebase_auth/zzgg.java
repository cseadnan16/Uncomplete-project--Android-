package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfw;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzgg implements zzfw<zzp.zzx> {
    private boolean zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private boolean zzg;

    private zzgg() {
    }

    public static zzgg zza(String str, String str2, boolean z) {
        zzgg zzgg = new zzgg();
        zzgg.zza = false;
        zzgg.zzc = Preconditions.checkNotEmpty(str);
        zzgg.zzd = Preconditions.checkNotEmpty(str2);
        zzgg.zzg = z;
        return zzgg;
    }

    public static zzgg zzb(String str, String str2, boolean z) {
        zzgg zzgg = new zzgg();
        zzgg.zza = false;
        zzgg.zzb = Preconditions.checkNotEmpty(str);
        zzgg.zze = Preconditions.checkNotEmpty(str2);
        zzgg.zzg = z;
        return zzgg;
    }

    public final void zza(String str) {
        this.zzf = str;
    }

    public final /* synthetic */ zzjn zza() {
        zzp.zzx.zza zza2 = zzp.zzx.zza();
        if (!TextUtils.isEmpty(this.zze)) {
            zza2.zzd(this.zze).zzb(this.zzb);
        } else {
            zza2.zza(this.zzc).zzc(this.zzd);
        }
        String str = this.zzf;
        if (str != null) {
            zza2.zze(str);
        }
        if (!this.zzg) {
            zza2.zza(zzaa.REAUTH);
        }
        return (zzp.zzx) ((zzif) zza2.zzg());
    }
}
