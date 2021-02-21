package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzfh implements zzfl {
    private final /* synthetic */ PhoneAuthCredential zza;

    zzfh(zzfg zzfg, PhoneAuthCredential phoneAuthCredential) {
        this.zza = phoneAuthCredential;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zza);
    }
}
