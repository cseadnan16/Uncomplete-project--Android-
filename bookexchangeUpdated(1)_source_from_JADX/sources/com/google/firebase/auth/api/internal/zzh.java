package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzeu;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.android.gms.internal.firebase_auth.zzfl;
import com.google.firebase.auth.zzc;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzh implements zzfp<zzeu> {
    private final /* synthetic */ zzfq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ zzc zze;
    private final /* synthetic */ zzeg zzf;
    private final /* synthetic */ zzff zzg;

    zzh(zza zza2, zzfq zzfq, String str, String str2, Boolean bool, zzc zzc2, zzeg zzeg, zzff zzff) {
        this.zza = zzfq;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzc2;
        this.zzf = zzeg;
        this.zzg = zzff;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzew> zzb2 = ((zzeu) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        boolean z = false;
        zzew zzew = zzb2.get(0);
        zzfl zzk = zzew.zzk();
        List<zzfj> zza2 = zzk != null ? zzk.zza() : null;
        if (zza2 != null && !zza2.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                int i = 0;
                while (true) {
                    if (i >= zza2.size()) {
                        break;
                    } else if (zza2.get(i).zzd().equals(this.zzb)) {
                        zza2.get(i).zza(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                zza2.get(0).zza(this.zzc);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzew.zza(bool.booleanValue());
        } else {
            if (zzew.zzh() - zzew.zzg() < 1000) {
                z = true;
            }
            zzew.zza(z);
        }
        zzew.zza(this.zze);
        this.zzf.zza(this.zzg, zzew);
    }
}
