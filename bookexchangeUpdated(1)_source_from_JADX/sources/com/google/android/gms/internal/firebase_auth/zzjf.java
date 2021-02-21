package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzjf<K, V> {
    static <K, V> void zza(zzhm zzhm, zzji<K, V> zzji, K k, V v) throws IOException {
        zzhv.zza(zzhm, zzji.zza, 1, k);
        zzhv.zza(zzhm, zzji.zzc, 2, v);
    }

    static <K, V> int zza(zzji<K, V> zzji, K k, V v) {
        return zzhv.zza(zzji.zza, 1, k) + zzhv.zza(zzji.zzc, 2, v);
    }
}
