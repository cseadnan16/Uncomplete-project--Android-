package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzp {

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zza extends zzif<zza, C1247zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zza zzs;
        private static volatile zzjx<zza> zzt;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private zzio<zzl> zzq = zzac();
        private String zzr = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class C1247zza extends zzif.zza<zza, C1247zza> implements zzjp {
            private C1247zza() {
                super(zza.zzs);
            }

            public final C1247zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C1247zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(str);
                return this;
            }

            public final C1247zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ C1247zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzr = str;
        }

        public static C1247zza zza() {
            return (C1247zza) zzs.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C1247zza((zzo) null);
                case 3:
                    return zza((zzjn) zzs, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\u001b\u000f\b\r", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzl.class, "zzr"});
                case 4:
                    return zzs;
                case 5:
                    zzjx<zza> zzjx = zzt;
                    if (zzjx == null) {
                        synchronized (zza.class) {
                            zzjx = zzt;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzs);
                                zzt = zzjx;
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
            zza zza = new zza();
            zzs = zza;
            zzif.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzb extends zzif<zzb, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzb zzn;
        private static volatile zzjx<zzb> zzo;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private zzio<String> zzf = zzif.zzac();
        private boolean zzg;
        private String zzh = "";
        private boolean zzi;
        private boolean zzj;
        private String zzk = "";
        private zzio<String> zzl = zzif.zzac();
        private byte zzm = 2;

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzb, zza> implements zzjp {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final List<String> zzb() {
            return this.zzf;
        }

        public final int zzc() {
            return this.zzf.size();
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final List<String> zzg() {
            return this.zzl;
        }

        /* renamed from: a_ */
        public final int mo12375a_() {
            return this.zzl.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\u001a\u0004\u0007\u0002\u0005\b\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\b\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
                case 4:
                    return zzn;
                case 5:
                    zzjx<zzb> zzjx = zzo;
                    if (zzjx == null) {
                        synchronized (zzb.class) {
                            zzjx = zzo;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzn);
                                zzo = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzm);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzm = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzb> zzi() {
            return (zzjx) zzn.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzb zzb = new zzb();
            zzn = zzb;
            zzif.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzc extends zzif<zzc, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzc zzg;
        private static volatile zzjx<zzc> zzh;
        private int zzc;
        private String zzd = "";
        private long zze;
        private String zzf = "";

        private zzc() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzc, zza> implements zzjp {
            private zza() {
                super(zzc.zzg);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        public static zza zza() {
            return (zza) zzg.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzjx<zzc> zzjx = zzh;
                    if (zzjx == null) {
                        synchronized (zzc.class) {
                            zzjx = zzh;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzg);
                                zzh = zzjx;
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
            zzc zzc2 = new zzc();
            zzg = zzc2;
            zzif.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzd extends zzif<zzd, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzd zzh;
        private static volatile zzjx<zzd> zzi;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";

        private zzd() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzd, zza> implements zzjp {
            private zza() {
                super(zzd.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzd(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        public static zza zza() {
            return (zza) zzh.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzh, "\u0001\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0006\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjx<zzd> zzjx = zzi;
                    if (zzjx == null) {
                        synchronized (zzd.class) {
                            zzjx = zzi;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzh);
                                zzi = zzjx;
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
            zzd zzd2 = new zzd();
            zzh = zzd2;
            zzif.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zze extends zzif<zze, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zze zzn;
        private static volatile zzjx<zze> zzo;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private long zzh;
        private String zzi = "";
        private boolean zzj;
        private String zzk = "";
        private zzio<zzr> zzl = zzac();
        private byte zzm = 2;

        private zze() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zze, zza> implements zzjp {
            private zza() {
                super(zze.zzn);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final long zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzi;
        }

        public final boolean zzf() {
            return this.zzj;
        }

        public final String zzg() {
            return this.zzk;
        }

        /* renamed from: c_ */
        public final List<zzr> mo12388c_() {
            return this.zzl;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0002\u0004\u0006\b\u0005\u0007\u0007\u0006\b\b\u0007\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzr.class});
                case 4:
                    return zzn;
                case 5:
                    zzjx<zze> zzjx = zzo;
                    if (zzjx == null) {
                        synchronized (zze.class) {
                            zzjx = zzo;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzn);
                                zzo = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzm);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzm = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zze> zzi() {
            return (zzjx) zzn.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zze zze2 = new zze();
            zzn = zze2;
            zzif.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzf extends zzif<zzf, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzf zzh;
        private static volatile zzjx<zzf> zzi;
        private int zzc;
        private String zzd = "";
        private zzio<String> zze = zzif.zzac();
        private zzio<String> zzf = zzif.zzac();
        private long zzg;

        private zzf() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzf, zza> implements zzjp {
            private zza() {
                super(zzf.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public static zza zza() {
            return (zza) zzh.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\b\u0000\u0002\u001a\u0003\u001a\u0004\u0002\u0001", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjx<zzf> zzjx = zzi;
                    if (zzjx == null) {
                        synchronized (zzf.class) {
                            zzjx = zzi;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzh);
                                zzi = zzjx;
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
            zzf zzf2 = new zzf();
            zzh = zzf2;
            zzif.zza(zzf.class, zzf2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzg extends zzif<zzg, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzg zzg;
        private static volatile zzjx<zzg> zzh;
        private int zzc;
        private String zzd = "";
        private zzio<zzz> zze = zzac();
        private byte zzf = 2;

        private zzg() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzg, zza> implements zzjp {
            private zza() {
                super(zzg.zzg);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final int zza() {
            return this.zze.size();
        }

        public final zzz zza(int i) {
            return (zzz) this.zze.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", zzz.class});
                case 4:
                    return zzg;
                case 5:
                    zzjx<zzg> zzjx = zzh;
                    if (zzjx == null) {
                        synchronized (zzg.class) {
                            zzjx = zzh;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzg);
                                zzh = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzf);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzf = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzg> zzb() {
            return (zzjx) zzg.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzg zzg2 = new zzg();
            zzg = zzg2;
            zzif.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzh extends zzif<zzh, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzh zzu;
        private static volatile zzjx<zzh> zzv;
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private boolean zzo;
        private String zzp = "";
        private boolean zzq;
        private String zzr = "";
        private String zzs = "";
        private boolean zzt;

        private zzh() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzh, zza> implements zzjp {
            private zza() {
                super(zzh.zzu);
            }

            public final zza zza(zzgj zzgj) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza(zzgj);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzg(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza(z);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzh(str);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzb(z);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzi(str);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzj(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzgj zzgj) {
            this.zzd = zzgj.zza();
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 32;
            this.zzi = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzj = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzk = str;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzl = str;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzm = str;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 1024;
            this.zzn = str;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 2048;
            this.zzo = z;
        }

        /* access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzp = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8192;
            this.zzq = z;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzc |= 16384;
            this.zzr = str;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzc |= 32768;
            this.zzs = str;
        }

        public static zza zza() {
            return (zza) zzu.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzu, "\u0001\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\u0007\u000b\r\b\f\u000e\u0007\r\u000f\b\u000e\u0012\b\u000f\u0013\u0007\u0010", new Object[]{"zzc", "zzd", zzgj.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
                case 4:
                    return zzu;
                case 5:
                    zzjx<zzh> zzjx = zzv;
                    if (zzjx == null) {
                        synchronized (zzh.class) {
                            zzjx = zzv;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzu);
                                zzv = zzjx;
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
            zzh zzh2 = new zzh();
            zzu = zzh2;
            zzif.zza(zzh.class, zzh2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzi extends zzif<zzi, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzi zzi;
        private static volatile zzjx<zzi> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private byte zzh = 2;

        private zzi() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzi, zza> implements zzjp {
            private zza() {
                super(zzi.zzi);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzi;
                case 5:
                    zzjx<zzi> zzjx = zzj;
                    if (zzjx == null) {
                        synchronized (zzi.class) {
                            zzjx = zzj;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzi);
                                zzj = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzh);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzh = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzi> zza() {
            return (zzjx) zzi.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzi zzi2 = new zzi();
            zzi = zzi2;
            zzif.zza(zzi.class, zzi2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzj extends zzif<zzj, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzj zzi;
        private static volatile zzjx<zzj> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        private zzj() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzj, zza> implements zzjp {
            private zza() {
                super(zzj.zzi);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        public static zza zza() {
            return (zza) zzi.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzi, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0006\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjx<zzj> zzjx = zzj;
                    if (zzjx == null) {
                        synchronized (zzj.class) {
                            zzjx = zzj;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzi);
                                zzj = zzjx;
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
            zzj zzj2 = new zzj();
            zzi = zzj2;
            zzif.zza(zzj.class, zzj2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzk extends zzif<zzk, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzk zzj;
        private static volatile zzjx<zzk> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private int zzg;
        private zzr zzh;
        private byte zzi = 2;

        private zzk() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzk, zza> implements zzjp {
            private zza() {
                super(zzk.zzj);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final zzgj zzc() {
            zzgj zza2 = zzgj.zza(this.zzg);
            return zza2 == null ? zzgj.OOB_REQ_TYPE_UNSPECIFIED : zza2;
        }

        public final boolean zzd() {
            return (this.zzc & 16) != 0;
        }

        public final zzr zze() {
            zzr zzr = this.zzh;
            return zzr == null ? zzr.zzf() : zzr;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\f\u0003\u0005\t\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzgj.zzb(), "zzh"});
                case 4:
                    return zzj;
                case 5:
                    zzjx<zzk> zzjx = zzk;
                    if (zzjx == null) {
                        synchronized (zzk.class) {
                            zzjx = zzk;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzj);
                                zzk = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzi);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzi = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzk> zzf() {
            return (zzjx) zzj.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzif.zza(zzk.class, zzk2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzl extends zzif<zzl, zzb> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzl zzj;
        private static volatile zzjx<zzl> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private zza zzi;

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif<zza, C1248zza> implements zzjp {
            /* access modifiers changed from: private */
            public static final zza zze;
            private static volatile zzjx<zza> zzf;
            private int zzc;
            private String zzd = "";

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzl$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
            public static final class C1248zza extends zzif.zza<zza, C1248zza> implements zzjp {
                private C1248zza() {
                    super(zza.zze);
                }

                /* synthetic */ C1248zza(zzo zzo) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzo.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C1248zza((zzo) null);
                    case 3:
                        return zza((zzjn) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzjx<zza> zzjx = zzf;
                        if (zzjx == null) {
                            synchronized (zza.class) {
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

            static {
                zza zza = new zza();
                zze = zza;
                zzif.zza(zza.class, zza);
            }
        }

        private zzl() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zzb extends zzif.zza<zzl, zzb> implements zzjp {
            private zzb() {
                super(zzl.zzj);
            }

            public final zzb zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzl) this.zza).zza(str);
                return this;
            }

            public final zzb zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzl) this.zza).zzb(str);
                return this;
            }

            public final zzb zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzl) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zzb(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        public static zzb zza() {
            return (zzb) zzj.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zzb((zzo) null);
                case 3:
                    return zza((zzjn) zzj, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0007\t\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjx<zzl> zzjx = zzk;
                    if (zzjx == null) {
                        synchronized (zzl.class) {
                            zzjx = zzk;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzj);
                                zzk = zzjx;
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
            zzl zzl = new zzl();
            zzj = zzl;
            zzif.zza(zzl.class, zzl);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzm extends zzif<zzm, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzm zze;
        private static volatile zzjx<zzm> zzf;
        private int zzc;
        private String zzd = "";

        private zzm() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzm, zza> implements zzjp {
            private zza() {
                super(zzm.zze);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzjx<zzm> zzjx = zzf;
                    if (zzjx == null) {
                        synchronized (zzm.class) {
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

        public static zzjx<zzm> zzb() {
            return (zzjx) zze.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzm zzm = new zzm();
            zze = zzm;
            zzif.zza(zzm.class, zzm);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzn extends zzif<zzn, zzb> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzn zzab;
        private static volatile zzjx<zzn> zzac;
        private static final zzil<Integer, zzv> zzu = new zzq();
        private zza zzaa;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private zzio<String> zzi = zzif.zzac();
        private String zzj = "";
        private boolean zzk;
        private boolean zzl;
        private String zzm = "";
        private String zzn = "";
        private zzkw zzo;
        private boolean zzp;
        private String zzq = "";
        private long zzr;
        private String zzs = "";
        private zzim zzt = zzab();
        private boolean zzv;
        private zzio<String> zzw = zzif.zzac();
        private long zzx;
        private long zzy;
        private String zzz = "";

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif<zza, C1249zza> implements zzjp {
            /* access modifiers changed from: private */
            public static final zza zzd;
            private static volatile zzjx<zza> zze;
            private zzio<zzr> zzc = zzac();

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzn$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
            public static final class C1249zza extends zzif.zza<zza, C1249zza> implements zzjp {
                private C1249zza() {
                    super(zza.zzd);
                }

                /* synthetic */ C1249zza(zzo zzo) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzo.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C1249zza((zzo) null);
                    case 3:
                        return zza((zzjn) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzr.class});
                    case 4:
                        return zzd;
                    case 5:
                        zzjx<zza> zzjx = zze;
                        if (zzjx == null) {
                            synchronized (zza.class) {
                                zzjx = zze;
                                if (zzjx == null) {
                                    zzjx = new zzif.zzc<>(zzd);
                                    zze = zzjx;
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
                zza zza = new zza();
                zzd = zza;
                zzif.zza(zza.class, zza);
            }
        }

        private zzn() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zzb extends zzif.zza<zzn, zzb> implements zzjp {
            private zzb() {
                super(zzn.zzab);
            }

            public final zzb zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(str);
                return this;
            }

            public final zzb zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzb(str);
                return this;
            }

            public final zzb zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzc(str);
                return this;
            }

            public final zzb zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzd(str);
                return this;
            }

            public final zzb zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zze(str);
                return this;
            }

            public final zzb zzf(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzf(str);
                return this;
            }

            public final zzb zza(Iterable<? extends zzv> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(iterable);
                return this;
            }

            public final zzb zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(z);
                return this;
            }

            public final zzb zzb(Iterable<String> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzb(iterable);
                return this;
            }

            public final zzb zzg(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzg(str);
                return this;
            }

            /* synthetic */ zzb(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 32;
            this.zzj = str;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 16384;
            this.zzs = str;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzv> iterable) {
            if (!this.zzt.zza()) {
                zzim zzim = this.zzt;
                int size = zzim.size();
                this.zzt = zzim.zzb(size == 0 ? 10 : size << 1);
            }
            for (zzv zza2 : iterable) {
                this.zzt.zzd(zza2.zza());
            }
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 32768;
            this.zzv = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<String> iterable) {
            if (!this.zzw.zza()) {
                zzio<String> zzio = this.zzw;
                int size = zzio.size();
                this.zzw = zzio.zza(size == 0 ? 10 : size << 1);
            }
            zzgn.zza(iterable, this.zzw);
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzz = str;
        }

        public static zzb zza() {
            return (zzb) zzab.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zzb((zzo) null);
                case 3:
                    return zza((zzjn) zzab, "\u0001\u0017\u0000\u0001\u0002\u001c\u0017\u0000\u0003\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u001a\b\b\u0005\t\u0007\u0006\n\u0007\u0007\u000b\b\b\f\b\t\r\t\n\u000e\u0007\u000b\u000f\b\f\u0010\u0002\r\u0011\b\u000e\u0012\u001e\u0013\u0007\u000f\u0014\u001a\u0015\u0002\u0010\u0016\u0002\u0011\u0019\b\u0012\u001c\t\u0013", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", zzv.zzb(), "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa"});
                case 4:
                    return zzab;
                case 5:
                    zzjx<zzn> zzjx = zzac;
                    if (zzjx == null) {
                        synchronized (zzn.class) {
                            zzjx = zzac;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzab);
                                zzac = zzjx;
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
            zzn zzn2 = new zzn();
            zzab = zzn2;
            zzif.zza(zzn.class, zzn2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzo extends zzif<zzo, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzo zzr;
        private static volatile zzjx<zzo> zzs;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private zzio<String> zzh = zzif.zzac();
        private String zzi = "";
        private zzio<zzu> zzj = zzac();
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private long zzn;
        private String zzo = "";
        private boolean zzp;
        private byte zzq = 2;

        private zzo() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzo, zza> implements zzjp {
            private zza() {
                super(zzo.zzr);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        @Deprecated
        public final String zza() {
            return this.zzf;
        }

        @Deprecated
        public final String zzb() {
            return this.zzg;
        }

        public final String zzc() {
            return this.zzi;
        }

        @Deprecated
        public final List<zzu> zzd() {
            return this.zzj;
        }

        @Deprecated
        public final String zze() {
            return this.zzl;
        }

        public final String zzf() {
            return this.zzm;
        }

        public final long zzg() {
            return this.zzn;
        }

        /* renamed from: d_ */
        public final String mo12434d_() {
            return this.zzo;
        }

        public final boolean zzi() {
            return this.zzp;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzr, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u001a\u0006\b\u0004\u0007\u001b\b\b\u0005\t\b\u0006\n\b\u0007\u000b\u0002\b\f\b\t\r\u0007\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzu.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
                case 4:
                    return zzr;
                case 5:
                    zzjx<zzo> zzjx = zzs;
                    if (zzjx == null) {
                        synchronized (zzo.class) {
                            zzjx = zzs;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzr);
                                zzs = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzq);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzq = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzo> zzj() {
            return (zzjx) zzr.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzo zzo2 = new zzo();
            zzr = zzo2;
            zzif.zza(zzo.class, zzo2);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzp  reason: collision with other inner class name */
    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class C1250zzp extends zzif<C1250zzp, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final C1250zzp zzo;
        private static volatile zzjx<C1250zzp> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private boolean zzk;
        private String zzl = "";
        private boolean zzm;
        private String zzn = "";

        private C1250zzp() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzp$zza */
        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<C1250zzp, zza> implements zzjp {
            private zza() {
                super(C1250zzp.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((C1250zzp) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((C1250zzp) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((C1250zzp) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 1024;
            this.zzn = str;
        }

        public static zza zza() {
            return (zza) zzo.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new C1250zzp();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzo, "\u0001\u000b\u0000\u0001\u0001\r\u000b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0007\u0007\t\b\b\n\u0007\t\r\b\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzjx<C1250zzp> zzjx = zzp;
                    if (zzjx == null) {
                        synchronized (C1250zzp.class) {
                            zzjx = zzp;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzo);
                                zzp = zzjx;
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
            C1250zzp zzp2 = new C1250zzp();
            zzo = zzp2;
            zzif.zza(C1250zzp.class, zzp2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzq extends zzif<zzq, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzq zzl;
        private static volatile zzjx<zzq> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private long zzi;
        private String zzj = "";
        private byte zzk = 2;

        private zzq() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzq, zza> implements zzjp {
            private zza() {
                super(zzq.zzl);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final long zze() {
            return this.zzi;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzl, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005\b\b\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzl;
                case 5:
                    zzjx<zzq> zzjx = zzm;
                    if (zzjx == null) {
                        synchronized (zzq.class) {
                            zzjx = zzm;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzl);
                                zzm = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzk);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzk = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzq> zzf() {
            return (zzjx) zzl.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzq zzq = new zzq();
            zzl = zzq;
            zzif.zza(zzq.class, zzq);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzr extends zzif<zzr, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzr zzq;
        private static volatile zzjx<zzr> zzr;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private boolean zzg;
        private String zzh = "";
        private String zzi = "";
        private long zzj;
        private String zzk = "";
        private boolean zzl;
        private boolean zzm;
        private boolean zzn = true;
        private String zzo = "";
        private String zzp = "";

        private zzr() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzr, zza> implements zzjp {
            private zza() {
                super(zzr.zzq);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzd(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zza(z);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzc(z);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzf(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzk = str;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 256;
            this.zzl = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 512;
            this.zzm = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzc |= 1024;
            this.zzn = z;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzo = str;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzp = str;
        }

        public static zza zza() {
            return (zza) zzq.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzq, "\u0001\r\u0000\u0001\u0001\u000f\r\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\u0002\u0006\b\b\u0007\t\u0007\b\n\u0007\t\u000b\u0007\n\r\b\u000b\u000f\b\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
                case 4:
                    return zzq;
                case 5:
                    zzjx<zzr> zzjx = zzr;
                    if (zzjx == null) {
                        synchronized (zzr.class) {
                            zzjx = zzr;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzq);
                                zzr = zzjx;
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
            zzr zzr2 = new zzr();
            zzq = zzr2;
            zzif.zza(zzr.class, zzr2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzs extends zzif<zzs, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzs zzau;
        private static volatile zzjx<zzs> zzav;
        private zzio<String> zzaa = zzif.zzac();
        private boolean zzab;
        private String zzac = "";
        private String zzad = "";
        private String zzae = "";
        private long zzaf;
        private String zzag = "";
        private boolean zzah;
        private String zzai = "";
        private String zzaj = "";
        private long zzak;
        private String zzal = "";
        private String zzam = "";
        private String zzan = "";
        private String zzao = "";
        private boolean zzap;
        private String zzaq = "";
        private String zzar = "";
        private String zzas = "";
        private zzio<zzr> zzat = zzac();
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private boolean zzh;
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private String zzu = "";
        private boolean zzv;
        private String zzw = "";
        private String zzx = "";
        private String zzy = "";
        private String zzz = "";

        private zzs() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzs, zza> implements zzjp {
            private zza() {
                super(zzs.zzau);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zzf;
        }

        public final String zzb() {
            return this.zzg;
        }

        public final String zzc() {
            return this.zzo;
        }

        public final String zzd() {
            return this.zzu;
        }

        public final String zze() {
            return this.zzw;
        }

        public final String zzf() {
            return this.zzx;
        }

        public final boolean zzg() {
            return this.zzab;
        }

        /* renamed from: e_ */
        public final String mo12460e_() {
            return this.zzad;
        }

        public final boolean zzi() {
            return this.zzah;
        }

        public final String zzj() {
            return this.zzai;
        }

        public final String zzk() {
            return this.zzaj;
        }

        public final long zzl() {
            return this.zzak;
        }

        public final String zzm() {
            return this.zzal;
        }

        public final String zzn() {
            return this.zzan;
        }

        public final String zzo() {
            return this.zzao;
        }

        public final boolean zzp() {
            return this.zzap;
        }

        public final String zzq() {
            return this.zzaq;
        }

        public final String zzr() {
            return this.zzar;
        }

        public final String zzs() {
            return this.zzas;
        }

        public final List<zzr> zzt() {
            return this.zzat;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzau, "\u0001*\u0000\u0002\u0001-*\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\b\r\u000f\b\u000e\u0010\b\u000f\u0011\b\u0010\u0012\u0007\u0011\u0013\b\u0012\u0014\b\u0013\u0015\b\u0014\u0017\b\u0015\u0018\u001a\u0019\u0007\u0016\u001a\b\u0017\u001c\b\u0018\u001d\b\u0019\u001e\u0002\u001a\u001f\b\u001b \u0007\u001c!\b\u001d\"\b\u001e#\u0002\u001f$\b %\b!&\b\"'\b#(\u0007$*\b%+\b&,\b'-\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", zzr.class});
                case 4:
                    return zzau;
                case 5:
                    zzjx<zzs> zzjx = zzav;
                    if (zzjx == null) {
                        synchronized (zzs.class) {
                            zzjx = zzav;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzau);
                                zzav = zzjx;
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

        public static zzjx<zzs> zzu() {
            return (zzjx) zzau.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzs zzs2 = new zzs();
            zzau = zzs2;
            zzif.zza(zzs.class, zzs2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzt extends zzif<zzt, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzt zzi;
        private static volatile zzjx<zzt> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private boolean zzf;
        private long zzg;
        private String zzh = "";

        private zzt() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzt, zza> implements zzjp {
            private zza() {
                super(zzt.zzi);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzt) this.zza).zza(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzt) this.zza).zza(true);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzt) this.zza).zzb(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 4;
            this.zzf = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        public static zza zza() {
            return (zza) zzi.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u0002\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjx<zzt> zzjx = zzj;
                    if (zzjx == null) {
                        synchronized (zzt.class) {
                            zzjx = zzj;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzi);
                                zzj = zzjx;
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
            zzt zzt = new zzt();
            zzi = zzt;
            zzif.zza(zzt.class, zzt);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzu extends zzif<zzu, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzu zzj;
        private static volatile zzjx<zzu> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private boolean zzh;
        private byte zzi = 2;

        private zzu() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzu, zza> implements zzjp {
            private zza() {
                super(zzu.zzj);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final long zzc() {
            return this.zzg;
        }

        public final boolean zzd() {
            return this.zzh;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzj;
                case 5:
                    zzjx<zzu> zzjx = zzk;
                    if (zzjx == null) {
                        synchronized (zzu.class) {
                            zzjx = zzk;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzj);
                                zzk = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzi);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzi = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzu> zze() {
            return (zzjx) zzj.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzu zzu = new zzu();
            zzj = zzu;
            zzif.zza(zzu.class, zzu);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzv extends zzif<zzv, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzv zzo;
        private static volatile zzjx<zzv> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private long zzk;
        private String zzl = "";
        private boolean zzm;
        private String zzn = "";

        private zzv() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzv, zza> implements zzjp {
            private zza() {
                super(zzv.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zzb(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zza(z);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 512;
            this.zzm = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 1024;
            this.zzn = str;
        }

        public static zza zza() {
            return (zza) zzo.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0007\t\u000b\b\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzjx<zzv> zzjx = zzp;
                    if (zzjx == null) {
                        synchronized (zzv.class) {
                            zzjx = zzp;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzo);
                                zzp = zzjx;
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
            zzv zzv = new zzv();
            zzo = zzv;
            zzif.zza(zzv.class, zzv);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzw extends zzif<zzw, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzw zzs;
        private static volatile zzjx<zzw> zzt;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private boolean zzi;
        private String zzj = "";
        private String zzk = "";
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private long zzo;
        private String zzp = "";
        private zzio<zzr> zzq = zzac();
        private byte zzr = 2;

        private zzw() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzw, zza> implements zzjp {
            private zza() {
                super(zzw.zzs);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzj;
        }

        public final String zzf() {
            return this.zzn;
        }

        public final long zzg() {
            return this.zzo;
        }

        /* renamed from: f_ */
        public final String mo12491f_() {
            return this.zzp;
        }

        public final List<zzr> zzi() {
            return this.zzq;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzs, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0007\u0005\u0007\b\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u0002\u000b\u000e\b\f\u000f\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzr.class});
                case 4:
                    return zzs;
                case 5:
                    zzjx<zzw> zzjx = zzt;
                    if (zzjx == null) {
                        synchronized (zzw.class) {
                            zzjx = zzt;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzs);
                                zzt = zzjx;
                            }
                        }
                    }
                    return zzjx;
                case 6:
                    return Byte.valueOf(this.zzr);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzr = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjx<zzw> zzj() {
            return (zzjx) zzs.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzw zzw = new zzw();
            zzs = zzw;
            zzif.zza(zzw.class, zzw);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzx extends zzif<zzx, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzx zzl;
        private static volatile zzjx<zzx> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private int zzj;
        private String zzk = "";

        private zzx() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzx, zza> implements zzjp {
            private zza() {
                super(zzx.zzl);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zze(str);
                return this;
            }

            public final zza zza(zzaa zzaa) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zza(zzaa);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 32;
            this.zzi = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzaa zzaa) {
            this.zzj = zzaa.zza();
            this.zzc |= 64;
        }

        public static zza zza() {
            return (zza) zzl.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\f\u0006\b\b\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzaa.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzjx<zzx> zzjx = zzm;
                    if (zzjx == null) {
                        synchronized (zzx.class) {
                            zzjx = zzm;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzl);
                                zzm = zzjx;
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
            zzx zzx = new zzx();
            zzl = zzx;
            zzif.zza(zzx.class, zzx);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzy extends zzif<zzy, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzy zzn;
        private static volatile zzjx<zzy> zzo;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private String zzg = "";
        private boolean zzh;
        private String zzi = "";
        private String zzj = "";
        private long zzk;
        private String zzl = "";
        private long zzm;

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzy, zza> implements zzjp {
            private zza() {
                super(zzy.zzn);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        static {
            zzy zzy = new zzy();
            zzn = zzy;
            zzif.zza(zzy.class, zzy);
        }

        private zzy() {
        }

        /* renamed from: g_ */
        public final long mo12506g_() {
            return this.zzk;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjn) zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\b\u0003\u0005\u0007\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0002\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzn;
                case 5:
                    zzjx<zzy> zzjx = zzo;
                    if (zzjx == null) {
                        synchronized (zzy.class) {
                            zzjx = zzo;
                            if (zzjx == null) {
                                zzjx = new zzif.zzc<>(zzn);
                                zzo = zzjx;
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

        public final String zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final String zzf() {
            return this.zzi;
        }

        public final String zzg() {
            return this.zzj;
        }

        public final String zzi() {
            return this.zzl;
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        public final long zzc() {
            return this.zzf;
        }

        public static zzjx<zzy> zzj() {
            return (zzjx) zzn.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }
    }
}
