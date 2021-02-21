package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzag;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzk implements zza, zzag {
    private final /* synthetic */ FirebaseAuth zza;

    zzk(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzff zzff, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzff, true, true);
    }

    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
