package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzme implements zzmb {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.personalized_ads_signals_collection_enabled", true);
        zzb = zzcr.zza("measurement.personalized_ads_property_translation_enabled", true);
    }
}
