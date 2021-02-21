package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbm<E> extends zzbg<E> {
    static final zzbg<Object> zza = new zzbm(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzbm(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    public final E get(int i) {
        zzav.zza(i, this.zzc);
        return this.zzb[i];
    }
}
