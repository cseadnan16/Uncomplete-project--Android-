package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzlz implements zzma {
    private static final zzcl<Long> zza;
    private static final zzcl<Long> zzb;

    public final boolean zza() {
        return true;
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.id.max_bundles_per_iteration", 0);
        zzb = zzcr.zza("measurement.max_bundles_per_iteration", 1);
    }
}
