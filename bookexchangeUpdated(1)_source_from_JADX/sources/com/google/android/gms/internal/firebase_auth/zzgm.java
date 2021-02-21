package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzgm;
import com.google.android.gms.internal.firebase_auth.zzgn;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public abstract class zzgm<MessageType extends zzgn<MessageType, BuilderType>, BuilderType extends zzgm<MessageType, BuilderType>> implements zzjq {
    /* renamed from: zza */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public final /* synthetic */ zzjq zza(zzjn zzjn) {
        if (mo12169h_().getClass().isInstance(zzjn)) {
            return zza((zzgn) zzjn);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
