package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbo<K, V> extends zzbn<Map.Entry<K, V>> {
    private final transient zzbl<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    private final transient int zzc = 0;
    /* access modifiers changed from: private */
    public final transient int zzd;

    zzbo(zzbl<K, V> zzbl, Object[] objArr, int i, int i2) {
        this.zza = zzbl;
        this.zzb = objArr;
        this.zzd = i2;
    }

    public final zzbv<Map.Entry<K, V>> zzb() {
        return (zzbv) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final zzbg<Map.Entry<K, V>> zza() {
        return new zzbr(this);
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (value == null || !value.equals(this.zza.get(key))) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zzd;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
