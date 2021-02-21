package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzjz {
    private static final zzjz zza = new zzjz();
    private final zzkg zzb = new zzje();
    private final ConcurrentMap<Class<?>, zzkd<?>> zzc = new ConcurrentHashMap();

    public static zzjz zza() {
        return zza;
    }

    public final <T> zzkd<T> zza(Class<T> cls) {
        zzii.zza(cls, "messageType");
        zzkd<T> zzkd = (zzkd) this.zzc.get(cls);
        if (zzkd != null) {
            return zzkd;
        }
        zzkd<T> zza2 = this.zzb.zza(cls);
        zzii.zza(cls, "messageType");
        zzii.zza(zza2, "schema");
        zzkd<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return zza2;
    }

    public final <T> zzkd<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzjz() {
    }
}
