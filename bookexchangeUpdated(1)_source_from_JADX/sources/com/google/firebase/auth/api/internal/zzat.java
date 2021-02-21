package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzat implements Continuation<ResultT, Task<ResultT>> {
    private final /* synthetic */ zzap zza;
    private final /* synthetic */ zzau zzb;

    zzat(zzau zzau, zzap zzap) {
        this.zzb = zzau;
        this.zza = zzap;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (task.getException() instanceof UnsupportedApiCallException) {
            return this.zzb.zza(this.zza.zzc());
        }
        return task;
    }
}
