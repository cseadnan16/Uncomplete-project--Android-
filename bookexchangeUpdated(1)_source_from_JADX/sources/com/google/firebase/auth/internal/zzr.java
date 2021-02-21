package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzr extends MultiFactor {
    private final zzn zza;

    public zzr(zzn zzn) {
        Preconditions.checkNotNull(zzn);
        this.zza = zzn;
    }

    public final Task<MultiFactorSession> getSession() {
        return this.zza.getIdToken(false).continueWithTask(new zzu(this));
    }

    public final Task<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(multiFactorAssertion);
        zzn zzn = this.zza;
        return FirebaseAuth.getInstance(zzn.zzc()).zza((FirebaseUser) zzn, multiFactorAssertion, str);
    }

    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzk();
    }

    public final Task<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        Preconditions.checkNotNull(multiFactorInfo);
        return unenroll(multiFactorInfo.getUid());
    }

    public final Task<Void> unenroll(String str) {
        Preconditions.checkNotEmpty(str);
        zzn zzn = this.zza;
        return FirebaseAuth.getInstance(zzn.zzc()).zzd(zzn, str);
    }
}
