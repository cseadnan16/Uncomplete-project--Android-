package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzay implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzaz zza;

    zzay(zzaz zzaz) {
        this.zza = zzaz;
    }

    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            boolean unused = this.zza.zzc = true;
            this.zza.zza();
            return;
        }
        boolean unused2 = this.zza.zzc = false;
        if (this.zza.zzb()) {
            this.zza.zzb.zza();
        }
    }
}
