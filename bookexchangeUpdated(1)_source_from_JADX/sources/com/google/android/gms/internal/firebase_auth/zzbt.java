package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzbt extends zzbg<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzbt(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzav.zza(i, this.zzc);
        return this.zza[(i * 2) + this.zzb];
    }

    public final int size() {
        return this.zzc;
    }
}
