package com.google.android.gms.internal.firebase_auth;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzgx implements Comparator<zzgv> {
    zzgx() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgv zzgv = (zzgv) obj;
        zzgv zzgv2 = (zzgv) obj2;
        zzha zzha = (zzha) zzgv.iterator();
        zzha zzha2 = (zzha) zzgv2.iterator();
        while (zzha.hasNext() && zzha2.hasNext()) {
            int compare = Integer.compare(zzgv.zzb(zzha.zza()), zzgv.zzb(zzha2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgv.zza(), zzgv2.zza());
    }
}
