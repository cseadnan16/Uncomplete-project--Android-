package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final /* synthetic */ class zzkf implements Runnable {
    private final zzkd zza;

    zzkf(zzkd zzkd) {
        this.zza = zzkd;
    }

    public final void run() {
        zzkd zzkd = this.zza;
        zzkd.zza.zzd();
        zzkd.zza.zzr().zzw().zza("Application backgrounded");
        zzkd.zza.zzf().zzb("auto", "_ab", new Bundle());
    }
}
