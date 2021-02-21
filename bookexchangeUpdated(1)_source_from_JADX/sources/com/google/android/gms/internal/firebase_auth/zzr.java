package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzr extends zzif<zzr, zza> implements zzjp {
    /* access modifiers changed from: private */
    public static final zzr zzk;
    private static volatile zzjx<zzr> zzl;
    private int zzc;
    private int zzd = 0;
    private Object zze;
    private int zzf = 0;
    private Object zzg;
    private String zzh = "";
    private String zzi = "";
    private zzkw zzj;

    private zzr() {
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zza extends zzif.zza<zzr, zza> implements zzjp {
        private zza() {
            super(zzr.zzk);
        }

        /* synthetic */ zza(zzs zzs) {
            this();
        }
    }

    public final String zza() {
        if (this.zzd == 1) {
            return (String) this.zze;
        }
        return "";
    }

    public final String zzb() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zzi;
    }

    public final zzkw zzd() {
        zzkw zzkw = this.zzj;
        return zzkw == null ? zzkw.zzb() : zzkw;
    }

    public final String zze() {
        if (this.zzf == 5) {
            return (String) this.zzg;
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzs.zza[i - 1]) {
            case 1:
                return new zzr();
            case 2:
                return new zza((zzs) null);
            case 3:
                return zza((zzjn) zzk, "\u0001\u0005\u0002\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001;\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003\u0005;\u0001", new Object[]{"zze", "zzd", "zzg", "zzf", "zzc", "zzh", "zzi", "zzj"});
            case 4:
                return zzk;
            case 5:
                zzjx<zzr> zzjx = zzl;
                if (zzjx == null) {
                    synchronized (zzr.class) {
                        zzjx = zzl;
                        if (zzjx == null) {
                            zzjx = new zzif.zzc<>(zzk);
                            zzl = zzjx;
                        }
                    }
                }
                return zzjx;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzr zzf() {
        return zzk;
    }

    static {
        zzr zzr = new zzr();
        zzk = zzr;
        zzif.zza(zzr.class, zzr);
    }
}
