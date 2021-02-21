package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzkj extends zzkp {
    private final /* synthetic */ zzki zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzkj(zzki zzki) {
        super(zzki, (zzkh) null);
        this.zza = zzki;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzkk(this.zza, (zzkh) null);
    }

    /* synthetic */ zzkj(zzki zzki, zzkh zzkh) {
        this(zzki);
    }
}
