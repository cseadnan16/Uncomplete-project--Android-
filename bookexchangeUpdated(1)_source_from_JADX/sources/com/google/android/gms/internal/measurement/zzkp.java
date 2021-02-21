package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzkp implements zzkq {
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
        zza = zzcr.zza("measurement.service.fix_gmp_version", false);
        zzb = zzcr.zza("measurement.id.service.fix_gmp_version", 0);
    }
}
