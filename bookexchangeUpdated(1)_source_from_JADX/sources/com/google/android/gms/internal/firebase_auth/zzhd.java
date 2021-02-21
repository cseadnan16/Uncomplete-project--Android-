package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzhd {
    private final zzhm zza;
    private final byte[] zzb;

    private zzhd(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzhm.zza(bArr);
    }

    public final zzgv zza() {
        this.zza.zzb();
        return new zzhf(this.zzb);
    }

    public final zzhm zzb() {
        return this.zza;
    }

    /* synthetic */ zzhd(int i, zzgu zzgu) {
        this(i);
    }
}
