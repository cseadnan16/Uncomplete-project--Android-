package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzae implements OnFailureListener {
    private final /* synthetic */ zzab zza;

    zzae(zzab zzab) {
        this.zza = zzab;
    }

    public final void onFailure(Exception exc) {
        if (exc instanceof FirebaseNetworkException) {
            zzac.zzc.mo11216v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zza.zza.zzb();
        }
    }
}
