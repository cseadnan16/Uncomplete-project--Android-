package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzlc implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.iterator();
    private final /* synthetic */ zzla zzb;

    zzlc(zzla zzla) {
        this.zzb = zzla;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }
}
