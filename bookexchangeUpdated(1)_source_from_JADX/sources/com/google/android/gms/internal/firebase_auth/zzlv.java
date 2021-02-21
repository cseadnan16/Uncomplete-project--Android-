package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzlv {

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zza extends zzif<zza, C1246zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zza zzl;
        private static volatile zzjx<zza> zzm;
        private String zzc = "";
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private zzio<String> zzg = zzif.zzac();
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzlv$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class C1246zza extends zzif.zza<zza, C1246zza> implements zzjp {
            private C1246zza() {
                super(zza.zzl);
            }

            public final C1246zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C1246zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(str);
                return this;
            }

            /* synthetic */ C1246zza(zzlu zzlu) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze = str;
        }

        public static C1246zza zza() {
            return (C1246zza) zzl.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzlu.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C1246zza((zzlu) null);
                case 3:
                    return zza((zzjn) zzl, "\u0000\t\u0000\u0000\u0001\u000b\t\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0006Ȉ\u0007Ț\bȈ\tȈ\nȈ\u000bȈ", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzjx<zza> zzjx = zzm;
                    if (zzjx == null) {
                        synchronized (zza.class) {
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
            zza zza = new zza();
            zzl = zza;
            zzif.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzb extends zzif<zzb, zza> implements zzjp {
        /* access modifiers changed from: private */
        public static final zzb zzk;
        private static volatile zzjx<zzb> zzl;
        private String zzc = "";
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private long zzi;
        private String zzj = "";

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
        public static final class zza extends zzif.zza<zzb, zza> implements zzjp {
            private zza() {
                super(zzb.zzk);
            }

            /* synthetic */ zza(zzlu zzlu) {
                this();
            }
        }

        public final String zza() {
            return this.zzc;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzd() {
            return this.zze;
        }

        public final String zze() {
            return this.zzf;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzlu.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzlu) null);
                case 3:
                    return zza((zzjn) zzk, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\bȈ", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzjx<zzb> zzjx = zzl;
                    if (zzjx == null) {
                        synchronized (zzb.class) {
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

        public static zzjx<zzb> zzf() {
            return (zzjx) zzk.zza(zzif.zzf.zzg, (Object) null, (Object) null);
        }

        static {
            zzb zzb = new zzb();
            zzk = zzb;
            zzif.zza(zzb.class, zzb);
        }
    }
}
