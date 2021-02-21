package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzj implements Runnable {
    private final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzj(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzb = firebaseAuth;
        this.zza = authStateListener;
    }

    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
