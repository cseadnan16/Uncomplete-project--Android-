package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzab implements Runnable {
    final /* synthetic */ zzac zza;
    private final String zzb;

    zzab(zzac zzac, String str) {
        this.zza = zzac;
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public final void run() {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
        if (instance.getCurrentUser() != null) {
            Task<GetTokenResult> accessToken = instance.getAccessToken(true);
            zzac.zzc.mo11216v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzae(this));
        }
    }
}
