package com.google.firebase.auth.internal;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzap implements Runnable {
    private final /* synthetic */ FederatedSignInActivity zza;

    zzap(FederatedSignInActivity federatedSignInActivity) {
        this.zza = federatedSignInActivity;
    }

    public final void run() {
        this.zza.zza();
        Runnable unused = FederatedSignInActivity.zze = null;
    }
}
