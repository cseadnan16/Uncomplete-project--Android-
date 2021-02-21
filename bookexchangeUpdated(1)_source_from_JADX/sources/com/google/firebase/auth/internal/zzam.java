package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzam implements OnFailureListener {
    private final /* synthetic */ TaskCompletionSource zza;

    zzam(zzaf zzaf, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onFailure(Exception exc) {
        this.zza.setException(exc);
        zzaf.zzb();
    }
}
