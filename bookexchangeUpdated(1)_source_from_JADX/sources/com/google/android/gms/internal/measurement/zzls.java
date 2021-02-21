package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzls implements zzlp {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Long> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false);
        zzb = zzcr.zza("measurement.id.referrer.enable_logging_install_referrer_cmp_from_apk", 0);
    }
}
