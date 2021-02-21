package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzet {
    public static final Api<zzeu> zza = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzc, zzb);
    private static final Api.ClientKey<zzef> zzb = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzef, zzeu> zzc = new zzev();

    public static zzau zza(Context context, zzeu zzeu) {
        return new zzau(context, zzeu);
    }
}
