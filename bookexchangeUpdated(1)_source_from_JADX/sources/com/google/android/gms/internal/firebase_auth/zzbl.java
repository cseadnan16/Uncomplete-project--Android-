package com.google.android.gms.internal.firebase_auth;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public abstract class zzbl<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zza = new Map.Entry[0];
    private transient zzbn<Map.Entry<K, V>> zzb;
    private transient zzbn<K> zzc;
    private transient zzbh<V> zzd;

    public static <K, V> zzbl<K, V> zza() {
        return zzbp.zza;
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzbn<Map.Entry<K, V>> zzb();

    /* access modifiers changed from: package-private */
    public abstract zzbn<K> zzc();

    /* access modifiers changed from: package-private */
    public abstract zzbh<V> zzd();

    zzbl() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzbh) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return zzbs.zza((zzbn) entrySet());
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf("size").length() + 40);
        sb2.append("size");
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public /* synthetic */ Set entrySet() {
        zzbn<Map.Entry<K, V>> zzbn = this.zzb;
        if (zzbn != null) {
            return zzbn;
        }
        zzbn<Map.Entry<K, V>> zzb2 = zzb();
        this.zzb = zzb2;
        return zzb2;
    }

    public /* synthetic */ Collection values() {
        zzbh<V> zzbh = this.zzd;
        if (zzbh != null) {
            return zzbh;
        }
        zzbh<V> zzd2 = zzd();
        this.zzd = zzd2;
        return zzd2;
    }

    public /* synthetic */ Set keySet() {
        zzbn<K> zzbn = this.zzc;
        if (zzbn != null) {
            return zzbn;
        }
        zzbn<K> zzc2 = zzc();
        this.zzc = zzc2;
        return zzc2;
    }
}
