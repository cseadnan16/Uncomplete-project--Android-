package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbj<E> extends zzbc<E> {
    private final zzbg<E> zza;

    zzbj(zzbg<E> zzbg, int i) {
        super(zzbg.size(), i);
        this.zza = zzbg;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
