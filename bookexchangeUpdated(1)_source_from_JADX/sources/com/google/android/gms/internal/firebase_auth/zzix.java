package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
abstract class zzix {
    private static final zzix zza = new zziz();
    private static final zzix zzb = new zzjc();

    private zzix() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzix zza() {
        return zza;
    }

    static zzix zzb() {
        return zzb;
    }
}
