package com.google.firebase.auth.api.internal;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzfm implements Runnable {
    private final /* synthetic */ zzfl zza;
    private final /* synthetic */ zzfg zzb;

    zzfm(zzfg zzfg, zzfl zzfl) {
        this.zzb = zzfg;
        this.zza = zzfl;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzi) {
            if (!this.zzb.zza.zzi.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzi.get(0), new Object[0]);
            }
        }
    }
}
