package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbq<K> extends zzbn<K> {
    private final transient zzbl<K, ?> zza;
    private final transient zzbg<K> zzb;

    zzbq(zzbl<K, ?> zzbl, zzbg<K> zzbg) {
        this.zza = zzbl;
        this.zzb = zzbg;
    }

    public final zzbv<K> zzb() {
        return (zzbv) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    public final zzbg<K> zzc() {
        return this.zzb;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
