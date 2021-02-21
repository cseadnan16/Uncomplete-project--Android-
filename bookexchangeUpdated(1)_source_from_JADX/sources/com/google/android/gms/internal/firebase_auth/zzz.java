package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzz extends zzif<zzz, zza> implements zzjp {
    /* access modifiers changed from: private */
    public static final zzz zzac;
    private static volatile zzjx<zzz> zzad;
    private zzio<zzr> zzaa = zzac();
    private zzkw zzab;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private zzio<String> zzg = zzif.zzac();
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private zzgv zzl = zzgv.zza;
    private zzgv zzm = zzgv.zza;
    private int zzn;
    private boolean zzo;
    private long zzp;
    private zzio<zzu> zzq = zzac();
    private long zzr;
    private boolean zzs;
    private long zzt;
    private long zzu;
    private String zzv = "";
    private boolean zzw;
    private String zzx = "";
    private String zzy = "";
    private String zzz = "";

    private zzz() {
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zza extends zzif.zza<zzz, zza> implements zzjp {
        private zza() {
            super(zzz.zzac);
        }

        /* synthetic */ zza(zzy zzy) {
            this();
        }
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final boolean zze() {
        return this.zzo;
    }

    public final List<zzu> zzf() {
        return this.zzq;
    }

    public final long zzg() {
        return this.zzt;
    }

    public final long zzh() {
        return this.zzu;
    }

    public final String zzi() {
        return this.zzx;
    }

    public final String zzj() {
        return this.zzy;
    }

    public final List<zzr> zzk() {
        return this.zzaa;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzy.zza[i - 1]) {
            case 1:
                return new zzz();
            case 2:
                return new zza((zzy) null);
            case 3:
                return zza((zzjn) zzac, "\u0001\u0019\u0000\u0001\u0001\u001c\u0019\u0000\u0003\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u001a\u0005\b\u0003\u0006\b\u0004\u0007\b\u0005\b\b\u0006\t\n\u0007\n\n\b\u000b\u0004\t\f\u0007\n\r\u0002\u000b\u000e\u001b\u000f\u0002\f\u0010\u0007\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\b\u0013\u0019\b\u0014\u001a\u001b\u001c\t\u0015", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzu.class, "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", zzr.class, "zzab"});
            case 4:
                return zzac;
            case 5:
                zzjx<zzz> zzjx = zzad;
                if (zzjx == null) {
                    synchronized (zzz.class) {
                        zzjx = zzad;
                        if (zzjx == null) {
                            zzjx = new zzif.zzc<>(zzac);
                            zzad = zzjx;
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

    static {
        zzz zzz2 = new zzz();
        zzac = zzz2;
        zzif.zza(zzz.class, zzz2);
    }
}
