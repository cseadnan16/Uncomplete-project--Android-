package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfw;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzfu implements zzfw<zzp.C1250zzp> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;

    public zzfu(String str) {
        this.zzd = str;
    }

    public zzfu(String str, String str2, String str3, String str4) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = null;
        this.zzd = str4;
    }

    public final /* synthetic */ zzjn zza() {
        zzp.C1250zzp.zza zza2 = zzp.C1250zzp.zza();
        String str = this.zza;
        if (str != null) {
            zza2.zza(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zza2.zzb(str2);
        }
        String str3 = this.zzd;
        if (str3 != null) {
            zza2.zzc(str3);
        }
        return (zzp.C1250zzp) ((zzif) zza2.zzg());
    }
}
