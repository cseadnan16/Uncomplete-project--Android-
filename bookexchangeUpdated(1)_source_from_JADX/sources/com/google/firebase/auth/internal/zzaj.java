package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzaj implements OnSuccessListener<AuthResult> {
    private final /* synthetic */ TaskCompletionSource zza;

    zzaj(zzaf zzaf, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zza.setResult((AuthResult) obj);
        zzaf.zzb();
    }
}
