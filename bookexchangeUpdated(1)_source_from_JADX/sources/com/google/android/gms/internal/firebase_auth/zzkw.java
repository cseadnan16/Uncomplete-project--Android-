package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzkw extends zzif<zzkw, zza> implements zzjp {
    /* access modifiers changed from: private */
    public static final zzkw zze;
    private static volatile zzjx<zzkw> zzf;
    private long zzc;
    private int zzd;

    private zzkw() {
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zza extends zzif.zza<zzkw, zza> implements zzjp {
        private zza() {
            super(zzkw.zze);
        }

        /* synthetic */ zza(zzkv zzkv) {
            this();
        }
    }

    public final long zza() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzkv.zza[i - 1]) {
            case 1:
                return new zzkw();
            case 2:
                return new zza((zzkv) null);
            case 3:
                return zza((zzjn) zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzc", "zzd"});
            case 4:
                return zze;
            case 5:
                zzjx<zzkw> zzjx = zzf;
                if (zzjx == null) {
                    synchronized (zzkw.class) {
                        zzjx = zzf;
                        if (zzjx == null) {
                            zzjx = new zzif.zzc<>(zze);
                            zzf = zzjx;
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

    public static zzkw zzb() {
        return zze;
    }

    static {
        zzkw zzkw = new zzkw();
        zze = zzkw;
        zzif.zza(zzkw.class, zzkw);
    }
}
