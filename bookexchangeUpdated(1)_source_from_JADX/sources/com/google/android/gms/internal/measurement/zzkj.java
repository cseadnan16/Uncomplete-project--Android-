package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzkj implements zzkk {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Long> zzb;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzcr.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0);
    }
}
