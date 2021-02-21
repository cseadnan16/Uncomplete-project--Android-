package com.google.firebase.auth.internal;

import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzz implements SignInMethodQueryResult {
    private final List<String> zza;

    public zzz(List<String> list) {
        this.zza = list;
    }

    public final List<String> getSignInMethods() {
        return this.zza;
    }
}
