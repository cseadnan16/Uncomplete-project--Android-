package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzu implements Continuation<GetTokenResult, Task<MultiFactorSession>> {
    zzu(zzr zzr) {
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(task.getException());
        }
        return Tasks.forResult(zzy.zza(((GetTokenResult) task.getResult()).getToken()));
    }
}
