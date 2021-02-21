package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public abstract class zzbn<E> extends zzbh<E> implements Set<E> {
    @NullableDecl
    private transient zzbg<E> zza;

    zzbn() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzbs.zza(this, obj);
    }

    public int hashCode() {
        return zzbs.zza(this);
    }

    public zzbg<E> zzc() {
        zzbg<E> zzbg = this.zza;
        if (zzbg != null) {
            return zzbg;
        }
        zzbg<E> zza2 = zza();
        this.zza = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public zzbg<E> zza() {
        return zzbg.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
