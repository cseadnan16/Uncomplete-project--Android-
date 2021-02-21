package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzhw {
    private static final zzhu<?> zza = new zzht();
    private static final zzhu<?> zzb = zzc();

    private static zzhu<?> zzc() {
        try {
            return (zzhu) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static zzhu<?> zza() {
        return zza;
    }

    static zzhu<?> zzb() {
        zzhu<?> zzhu = zzb;
        if (zzhu != null) {
            return zzhu;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
