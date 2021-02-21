package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public class zziw {
    private static final zzhs zza = zzhs.zza();
    private zzgv zzb;
    private volatile zzjn zzc;
    private volatile zzgv zzd;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zziw)) {
            return false;
        }
        zziw zziw = (zziw) obj;
        zzjn zzjn = this.zzc;
        zzjn zzjn2 = zziw.zzc;
        if (zzjn == null && zzjn2 == null) {
            return zzc().equals(zziw.zzc());
        }
        if (zzjn != null && zzjn2 != null) {
            return zzjn.equals(zzjn2);
        }
        if (zzjn != null) {
            return zzjn.equals(zziw.zzb(zzjn.mo12169h_()));
        }
        return zzb(zzjn2.mo12169h_()).equals(zzjn2);
    }

    public int hashCode() {
        return 1;
    }

    private final zzjn zzb(zzjn zzjn) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzjn;
                        this.zzd = zzgv.zza;
                    } catch (zzin e) {
                        this.zzc = zzjn;
                        this.zzd = zzgv.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzjn zza(zzjn zzjn) {
        zzjn zzjn2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjn;
        return zzjn2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzaa();
        }
        return 0;
    }

    public final zzgv zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzgv zzgv = this.zzd;
                return zzgv;
            }
            if (this.zzc == null) {
                this.zzd = zzgv.zza;
            } else {
                this.zzd = this.zzc.zzw();
            }
            zzgv zzgv2 = this.zzd;
            return zzgv2;
        }
    }
}
