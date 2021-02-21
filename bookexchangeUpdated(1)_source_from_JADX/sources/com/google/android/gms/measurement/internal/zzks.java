package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzky;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zzv;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
public class zzks implements zzhh {
    private static volatile zzks zza;
    private zzgi zzb;
    private zzfo zzc;
    private zzac zzd;
    private zzfr zze;
    private zzko zzf;
    private zzn zzg;
    private final zzkw zzh;
    private zzir zzi;
    private final zzgo zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
    class zza implements zzae {
        zzbr.zzg zza;
        List<Long> zzb;
        List<zzbr.zzc> zzc;
        private long zzd;

        private zza() {
        }

        public final void zza(zzbr.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public final boolean zza(long j, zzbr.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbn = this.zzd + ((long) zzc2.zzbn());
            if (zzbn >= ((long) Math.max(0, zzap.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbn;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzap.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbr.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzks zzks, zzkr zzkr) {
            this();
        }
    }

    public static zzks zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzks.class) {
                if (zza == null) {
                    zza = new zzks(new zzkx(context));
                }
            }
        }
        return zza;
    }

    private zzks(zzkx zzkx) {
        this(zzkx, (zzgo) null);
    }

    private zzks(zzkx zzkx, zzgo zzgo) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkx);
        this.zzj = zzgo.zza(zzkx.zza, (zzv) null);
        this.zzx = -1;
        zzkw zzkw = new zzkw(this);
        zzkw.zzal();
        this.zzh = zzkw;
        zzfo zzfo = new zzfo(this);
        zzfo.zzal();
        this.zzc = zzfo;
        zzgi zzgi = new zzgi(this);
        zzgi.zzal();
        this.zzb = zzgi;
        this.zzj.zzq().zza((Runnable) new zzkr(this, zzkx));
    }

    /* access modifiers changed from: private */
    public final void zza(zzkx zzkx) {
        this.zzj.zzq().zzd();
        zzac zzac = new zzac(this);
        zzac.zzal();
        this.zzd = zzac;
        this.zzj.zzb().zza((zzz) this.zzb);
        zzn zzn2 = new zzn(this);
        zzn2.zzal();
        this.zzg = zzn2;
        zzir zzir = new zzir(this);
        zzir.zzal();
        this.zzi = zzir;
        zzko zzko = new zzko(this);
        zzko.zzal();
        this.zzf = zzko;
        this.zze = new zzfr(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    public final zzw zzu() {
        return this.zzj.zzu();
    }

    public final zzx zzb() {
        return this.zzj.zzb();
    }

    public final zzfk zzr() {
        return this.zzj.zzr();
    }

    public final zzgh zzq() {
        return this.zzj.zzq();
    }

    public final zzgi zzc() {
        zzb((zzkp) this.zzb);
        return this.zzb;
    }

    public final zzfo zzd() {
        zzb((zzkp) this.zzc);
        return this.zzc;
    }

    public final zzac zze() {
        zzb((zzkp) this.zzd);
        return this.zzd;
    }

    private final zzfr zzt() {
        zzfr zzfr = this.zze;
        if (zzfr != null) {
            return zzfr;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzko zzv() {
        zzb((zzkp) this.zzf);
        return this.zzf;
    }

    public final zzn zzf() {
        zzb((zzkp) this.zzg);
        return this.zzg;
    }

    public final zzir zzg() {
        zzb((zzkp) this.zzi);
        return this.zzi;
    }

    public final zzkw zzh() {
        zzb((zzkp) this.zzh);
        return this.zzh;
    }

    public final zzfi zzi() {
        return this.zzj.zzj();
    }

    public final Context zzn() {
        return this.zzj.zzn();
    }

    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzla zzj() {
        return this.zzj.zzi();
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzkp zzkp) {
        if (zzkp == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkp.zzaj()) {
            String valueOf = String.valueOf(zzkp.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzft zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzan zzan, String str) {
        String str2;
        zzan zzan2 = zzan;
        zzg zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzan2.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzfk.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzfk.zza(str));
            return;
        }
        String zze2 = zzb2.zze();
        String zzl2 = zzb2.zzl();
        long zzm2 = zzb2.zzm();
        String zzn2 = zzb2.zzn();
        long zzo2 = zzb2.zzo();
        long zzp2 = zzb2.zzp();
        boolean zzr2 = zzb2.zzr();
        String zzi2 = zzb2.zzi();
        long zzae = zzb2.zzae();
        boolean zzaf = zzb2.zzaf();
        boolean zzag = zzb2.zzag();
        String zzf2 = zzb2.zzf();
        Boolean zzah = zzb2.zzah();
        long zzq2 = zzb2.zzq();
        List<String> zzai = zzb2.zzai();
        if (!zzll.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzap.zzch)) {
            str2 = null;
        } else {
            str2 = zzb2.zzg();
        }
        zzm zzm3 = r2;
        zzm zzm4 = new zzm(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, zzr2, false, zzi2, zzae, 0, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2);
        zza(zzan2, zzm3);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0140 A[Catch:{ all -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0222 A[Catch:{ all -> 0x03a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzan r20, com.google.android.gms.measurement.internal.zzm r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r21)
            java.lang.String r3 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            r19.zzw()
            r19.zzk()
            java.lang.String r3 = r2.zza
            long r11 = r0.zzd
            com.google.android.gms.measurement.internal.zzkw r4 = r19.zzh()
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzan) r0, (com.google.android.gms.measurement.internal.zzm) r2)
            if (r4 != 0) goto L_0x0023
            return
        L_0x0023:
            boolean r4 = r2.zzh
            if (r4 != 0) goto L_0x002b
            r1.zzc(r2)
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzbl
            boolean r4 = r4.zze(r3, r5)
            if (r4 == 0) goto L_0x0081
            java.util.List<java.lang.String> r4 = r2.zzu
            if (r4 == 0) goto L_0x0081
            java.util.List<java.lang.String> r4 = r2.zzu
            java.lang.String r5 = r0.zza
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzam r4 = r0.zzb
            android.os.Bundle r4 = r4.zzb()
            r5 = 1
            java.lang.String r7 = "ga_safelisted"
            r4.putLong(r7, r5)
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan
            java.lang.String r14 = r0.zza
            com.google.android.gms.measurement.internal.zzam r15 = new com.google.android.gms.measurement.internal.zzam
            r15.<init>(r4)
            java.lang.String r4 = r0.zzc
            long r6 = r0.zzd
            r13 = r5
            r16 = r4
            r17 = r6
            r13.<init>(r14, r15, r16, r17)
            r0 = r5
            goto L_0x0081
        L_0x006c:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzw()
            java.lang.String r4 = r0.zza
            java.lang.String r0 = r0.zzc
            java.lang.String r5 = "Dropping non-safelisted event. appId, event name, origin"
            r2.zza(r5, r3, r4, r0)
            return
        L_0x0081:
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()
            r4.zzf()
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x03a2 }
            r4.zzd()     // Catch:{ all -> 0x03a2 }
            r4.zzak()     // Catch:{ all -> 0x03a2 }
            r5 = 0
            r7 = 2
            r13 = 0
            r14 = 1
            int r8 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b9
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x03a2 }
            java.lang.String r5 = "Invalid time querying timed out conditional properties"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r3)     // Catch:{ all -> 0x03a2 }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x03a2 }
            r4.zza(r5, r6, r9)     // Catch:{ all -> 0x03a2 }
            java.util.List r4 = java.util.Collections.emptyList()     // Catch:{ all -> 0x03a2 }
            goto L_0x00c9
        L_0x00b9:
            java.lang.String r5 = "active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout"
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ all -> 0x03a2 }
            r6[r13] = r3     // Catch:{ all -> 0x03a2 }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x03a2 }
            r6[r14] = r9     // Catch:{ all -> 0x03a2 }
            java.util.List r4 = r4.zza((java.lang.String) r5, (java.lang.String[]) r6)     // Catch:{ all -> 0x03a2 }
        L_0x00c9:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x03a2 }
        L_0x00cd:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x03a2 }
            if (r5 == 0) goto L_0x015b
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzv r5 = (com.google.android.gms.measurement.internal.zzv) r5     // Catch:{ all -> 0x03a2 }
            if (r5 == 0) goto L_0x0158
            boolean r6 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x03a2 }
            java.lang.String r9 = "User property timed out"
            if (r6 == 0) goto L_0x0118
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzb()     // Catch:{ all -> 0x03a2 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x03a2 }
            boolean r6 = r6.zze(r10, r15)     // Catch:{ all -> 0x03a2 }
            if (r6 == 0) goto L_0x0118
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzx()     // Catch:{ all -> 0x03a2 }
            java.lang.String r10 = r5.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzgo r15 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r15 = r15.zzj()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r14 = r5.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r14 = r14.zza     // Catch:{ all -> 0x03a2 }
            java.lang.String r14 = r15.zzc(r14)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r15 = r5.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x03a2 }
            r6.zza(r9, r10, r14, r15)     // Catch:{ all -> 0x03a2 }
            goto L_0x013c
        L_0x0118:
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzw()     // Catch:{ all -> 0x03a2 }
            java.lang.String r10 = r5.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzgo r14 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r14 = r14.zzj()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r15 = r5.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r15 = r15.zza     // Catch:{ all -> 0x03a2 }
            java.lang.String r14 = r14.zzc(r15)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r15 = r5.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x03a2 }
            r6.zza(r9, r10, r14, r15)     // Catch:{ all -> 0x03a2 }
        L_0x013c:
            com.google.android.gms.measurement.internal.zzan r6 = r5.zzg     // Catch:{ all -> 0x03a2 }
            if (r6 == 0) goto L_0x014a
            com.google.android.gms.measurement.internal.zzan r6 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzan r9 = r5.zzg     // Catch:{ all -> 0x03a2 }
            r6.<init>(r9, r11)     // Catch:{ all -> 0x03a2 }
            r1.zzb((com.google.android.gms.measurement.internal.zzan) r6, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x03a2 }
        L_0x014a:
            com.google.android.gms.measurement.internal.zzac r6 = r19.zze()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r5 = r5.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x03a2 }
            r6.zze(r3, r5)     // Catch:{ all -> 0x03a2 }
            r14 = 1
            goto L_0x00cd
        L_0x0158:
            r14 = 1
            goto L_0x00cd
        L_0x015b:
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x03a2 }
            r4.zzd()     // Catch:{ all -> 0x03a2 }
            r4.zzak()     // Catch:{ all -> 0x03a2 }
            if (r8 >= 0) goto L_0x0185
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x03a2 }
            java.lang.String r5 = "Invalid time querying expired conditional properties"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r3)     // Catch:{ all -> 0x03a2 }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x03a2 }
            r4.zza(r5, r6, r9)     // Catch:{ all -> 0x03a2 }
            java.util.List r4 = java.util.Collections.emptyList()     // Catch:{ all -> 0x03a2 }
            goto L_0x0196
        L_0x0185:
            java.lang.String r5 = "active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live"
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ all -> 0x03a2 }
            r6[r13] = r3     // Catch:{ all -> 0x03a2 }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x03a2 }
            r10 = 1
            r6[r10] = r9     // Catch:{ all -> 0x03a2 }
            java.util.List r4 = r4.zza((java.lang.String) r5, (java.lang.String[]) r6)     // Catch:{ all -> 0x03a2 }
        L_0x0196:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x03a2 }
            int r6 = r4.size()     // Catch:{ all -> 0x03a2 }
            r5.<init>(r6)     // Catch:{ all -> 0x03a2 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x03a2 }
        L_0x01a4:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x03a2 }
            if (r6 == 0) goto L_0x0238
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzv r6 = (com.google.android.gms.measurement.internal.zzv) r6     // Catch:{ all -> 0x03a2 }
            if (r6 == 0) goto L_0x0235
            boolean r9 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x03a2 }
            java.lang.String r10 = "User property expired"
            if (r9 == 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzx r9 = r9.zzb()     // Catch:{ all -> 0x03a2 }
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x03a2 }
            boolean r9 = r9.zze(r14, r15)     // Catch:{ all -> 0x03a2 }
            if (r9 == 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzx()     // Catch:{ all -> 0x03a2 }
            java.lang.String r14 = r6.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzgo r15 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r15 = r15.zzj()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r7 = r6.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r7 = r7.zza     // Catch:{ all -> 0x03a2 }
            java.lang.String r7 = r15.zzc(r7)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r15 = r6.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x03a2 }
            r9.zza(r10, r14, r7, r15)     // Catch:{ all -> 0x03a2 }
            goto L_0x0213
        L_0x01ef:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzw()     // Catch:{ all -> 0x03a2 }
            java.lang.String r9 = r6.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzgo r14 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r14 = r14.zzj()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r15 = r6.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r15 = r15.zza     // Catch:{ all -> 0x03a2 }
            java.lang.String r14 = r14.zzc(r15)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r15 = r6.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x03a2 }
            r7.zza(r10, r9, r14, r15)     // Catch:{ all -> 0x03a2 }
        L_0x0213:
            com.google.android.gms.measurement.internal.zzac r7 = r19.zze()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r9 = r6.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r9 = r9.zza     // Catch:{ all -> 0x03a2 }
            r7.zzb((java.lang.String) r3, (java.lang.String) r9)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzan r7 = r6.zzk     // Catch:{ all -> 0x03a2 }
            if (r7 == 0) goto L_0x0227
            com.google.android.gms.measurement.internal.zzan r7 = r6.zzk     // Catch:{ all -> 0x03a2 }
            r5.add(r7)     // Catch:{ all -> 0x03a2 }
        L_0x0227:
            com.google.android.gms.measurement.internal.zzac r7 = r19.zze()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzkz r6 = r6.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r6 = r6.zza     // Catch:{ all -> 0x03a2 }
            r7.zze(r3, r6)     // Catch:{ all -> 0x03a2 }
            r7 = 2
            goto L_0x01a4
        L_0x0235:
            r7 = 2
            goto L_0x01a4
        L_0x0238:
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x03a2 }
            int r4 = r5.size()     // Catch:{ all -> 0x03a2 }
            r6 = 0
        L_0x023f:
            if (r6 >= r4) goto L_0x0252
            java.lang.Object r7 = r5.get(r6)     // Catch:{ all -> 0x03a2 }
            int r6 = r6 + 1
            com.google.android.gms.measurement.internal.zzan r7 = (com.google.android.gms.measurement.internal.zzan) r7     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzan r9 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x03a2 }
            r9.<init>(r7, r11)     // Catch:{ all -> 0x03a2 }
            r1.zzb((com.google.android.gms.measurement.internal.zzan) r9, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x03a2 }
            goto L_0x023f
        L_0x0252:
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x03a2 }
            java.lang.String r5 = r0.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x03a2 }
            r4.zzd()     // Catch:{ all -> 0x03a2 }
            r4.zzak()     // Catch:{ all -> 0x03a2 }
            if (r8 >= 0) goto L_0x0289
            com.google.android.gms.measurement.internal.zzfk r6 = r4.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzi()     // Catch:{ all -> 0x03a2 }
            java.lang.String r7 = "Invalid time querying triggered conditional properties"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r3)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r4 = r4.zzo()     // Catch:{ all -> 0x03a2 }
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x03a2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x03a2 }
            r6.zza(r7, r3, r4, r5)     // Catch:{ all -> 0x03a2 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x03a2 }
            goto L_0x029e
        L_0x0289:
            java.lang.String r6 = "active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout"
            r7 = 3
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x03a2 }
            r7[r13] = r3     // Catch:{ all -> 0x03a2 }
            r3 = 1
            r7[r3] = r5     // Catch:{ all -> 0x03a2 }
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x03a2 }
            r5 = 2
            r7[r5] = r3     // Catch:{ all -> 0x03a2 }
            java.util.List r3 = r4.zza((java.lang.String) r6, (java.lang.String[]) r7)     // Catch:{ all -> 0x03a2 }
        L_0x029e:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x03a2 }
            int r4 = r3.size()     // Catch:{ all -> 0x03a2 }
            r14.<init>(r4)     // Catch:{ all -> 0x03a2 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x03a2 }
        L_0x02ac:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x03a2 }
            if (r4 == 0) goto L_0x0376
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x03a2 }
            r15 = r4
            com.google.android.gms.measurement.internal.zzv r15 = (com.google.android.gms.measurement.internal.zzv) r15     // Catch:{ all -> 0x03a2 }
            if (r15 == 0) goto L_0x0372
            com.google.android.gms.measurement.internal.zzkz r4 = r15.zzc     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzlb r10 = new com.google.android.gms.measurement.internal.zzlb     // Catch:{ all -> 0x03a2 }
            java.lang.String r5 = r15.zza     // Catch:{ all -> 0x03a2 }
            java.lang.String r6 = r15.zzb     // Catch:{ all -> 0x03a2 }
            java.lang.String r7 = r4.zza     // Catch:{ all -> 0x03a2 }
            java.lang.Object r16 = r4.zza()     // Catch:{ all -> 0x03a2 }
            r4 = r10
            r8 = r11
            r13 = r10
            r10 = r16
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x03a2 }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzlb) r13)     // Catch:{ all -> 0x03a2 }
            if (r4 == 0) goto L_0x0331
            boolean r4 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x03a2 }
            java.lang.String r5 = "User property triggered"
            if (r4 == 0) goto L_0x0312
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()     // Catch:{ all -> 0x03a2 }
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x03a2 }
            boolean r4 = r4.zze(r6, r7)     // Catch:{ all -> 0x03a2 }
            if (r4 == 0) goto L_0x0312
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzx()     // Catch:{ all -> 0x03a2 }
            java.lang.String r6 = r15.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzj()     // Catch:{ all -> 0x03a2 }
            java.lang.String r8 = r13.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r7 = r7.zzc(r8)     // Catch:{ all -> 0x03a2 }
            java.lang.Object r8 = r13.zze     // Catch:{ all -> 0x03a2 }
            r4.zza(r5, r6, r7, r8)     // Catch:{ all -> 0x03a2 }
            goto L_0x0355
        L_0x0312:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzw()     // Catch:{ all -> 0x03a2 }
            java.lang.String r6 = r15.zza     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzj()     // Catch:{ all -> 0x03a2 }
            java.lang.String r8 = r13.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r7 = r7.zzc(r8)     // Catch:{ all -> 0x03a2 }
            java.lang.Object r8 = r13.zze     // Catch:{ all -> 0x03a2 }
            r4.zza(r5, r6, r7, r8)     // Catch:{ all -> 0x03a2 }
            goto L_0x0355
        L_0x0331:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()     // Catch:{ all -> 0x03a2 }
            java.lang.String r5 = "Too many active user properties, ignoring"
            java.lang.String r6 = r15.zza     // Catch:{ all -> 0x03a2 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r6)     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzj()     // Catch:{ all -> 0x03a2 }
            java.lang.String r8 = r13.zzc     // Catch:{ all -> 0x03a2 }
            java.lang.String r7 = r7.zzc(r8)     // Catch:{ all -> 0x03a2 }
            java.lang.Object r8 = r13.zze     // Catch:{ all -> 0x03a2 }
            r4.zza(r5, r6, r7, r8)     // Catch:{ all -> 0x03a2 }
        L_0x0355:
            com.google.android.gms.measurement.internal.zzan r4 = r15.zzi     // Catch:{ all -> 0x03a2 }
            if (r4 == 0) goto L_0x035e
            com.google.android.gms.measurement.internal.zzan r4 = r15.zzi     // Catch:{ all -> 0x03a2 }
            r14.add(r4)     // Catch:{ all -> 0x03a2 }
        L_0x035e:
            com.google.android.gms.measurement.internal.zzkz r4 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x03a2 }
            r4.<init>(r13)     // Catch:{ all -> 0x03a2 }
            r15.zzc = r4     // Catch:{ all -> 0x03a2 }
            r4 = 1
            r15.zze = r4     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzac r5 = r19.zze()     // Catch:{ all -> 0x03a2 }
            r5.zza((com.google.android.gms.measurement.internal.zzv) r15)     // Catch:{ all -> 0x03a2 }
            r13 = 0
            goto L_0x02ac
        L_0x0372:
            r4 = 1
            r13 = 0
            goto L_0x02ac
        L_0x0376:
            r1.zzb((com.google.android.gms.measurement.internal.zzan) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x03a2 }
            java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x03a2 }
            int r0 = r14.size()     // Catch:{ all -> 0x03a2 }
            r13 = 0
        L_0x0380:
            if (r13 >= r0) goto L_0x0393
            java.lang.Object r3 = r14.get(r13)     // Catch:{ all -> 0x03a2 }
            int r13 = r13 + 1
            com.google.android.gms.measurement.internal.zzan r3 = (com.google.android.gms.measurement.internal.zzan) r3     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzan r4 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x03a2 }
            r4.<init>(r3, r11)     // Catch:{ all -> 0x03a2 }
            r1.zzb((com.google.android.gms.measurement.internal.zzan) r4, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x03a2 }
            goto L_0x0380
        L_0x0393:
            com.google.android.gms.measurement.internal.zzac r0 = r19.zze()     // Catch:{ all -> 0x03a2 }
            r0.mo13671b_()     // Catch:{ all -> 0x03a2 }
            com.google.android.gms.measurement.internal.zzac r0 = r19.zze()
            r0.zzh()
            return
        L_0x03a2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzac r2 = r19.zze()
            r2.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02cc A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0309 A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0340 A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0350 A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0385 A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0952 A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0157 A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f A[Catch:{ SQLiteException -> 0x0292, all -> 0x09e2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.measurement.internal.zzan r26, com.google.android.gms.measurement.internal.zzm r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            java.lang.String r4 = "_s"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r25.zzw()
            r25.zzk()
            java.lang.String r15 = r3.zza
            com.google.android.gms.measurement.internal.zzkw r7 = r25.zzh()
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzan) r2, (com.google.android.gms.measurement.internal.zzm) r3)
            if (r7 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002f
            r1.zzc(r3)
            return
        L_0x002f:
            com.google.android.gms.measurement.internal.zzgi r7 = r25.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzi()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzfi r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzgi r3 = r25.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzgi r3 = r25.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r3 = 0
            goto L_0x0077
        L_0x0076:
            r3 = 1
        L_0x0077:
            if (r3 != 0) goto L_0x0093
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzla r7 = r4.zzi()
            r9 = 11
            java.lang.String r11 = r2.zza
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)
        L_0x0093:
            if (r3 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00df
            long r3 = r2.zzu()
            long r5 = r2.zzt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzm()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzap.zzy
            java.lang.Object r5 = r5.zza(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzw()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza((com.google.android.gms.measurement.internal.zzg) r2)
        L_0x00df:
            return
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()
            r10 = 2
            boolean r7 = r7.zza((int) r10)
            if (r7 == 0) goto L_0x0108
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzj()
            java.lang.String r8 = r8.zza((com.google.android.gms.measurement.internal.zzan) r2)
            java.lang.String r9 = "Logging event"
            r7.zza(r9, r8)
        L_0x0108:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()
            r7.zzf()
            r1.zzc(r3)     // Catch:{ all -> 0x09e2 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjp.zzb()     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzap.zzdf     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r8)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0128
            r7 = 1
            goto L_0x0129
        L_0x0128:
            r7 = 0
        L_0x0129:
            java.lang.String r8 = "ecommerce_purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = "refund"
            if (r8 != 0) goto L_0x014c
            if (r7 == 0) goto L_0x014a
            java.lang.String r7 = "purchase"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x014c
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r7 = 0
            goto L_0x014d
        L_0x014c:
            r7 = 1
        L_0x014d:
            java.lang.String r8 = "_iap"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x09e2 }
            if (r8 != 0) goto L_0x015c
            if (r7 == 0) goto L_0x015a
            goto L_0x015c
        L_0x015a:
            r8 = 0
            goto L_0x015d
        L_0x015c:
            r8 = 1
        L_0x015d:
            if (r8 == 0) goto L_0x0318
            com.google.android.gms.measurement.internal.zzam r8 = r2.zzb     // Catch:{ all -> 0x09e2 }
            java.lang.String r10 = "currency"
            java.lang.String r8 = r8.zzd(r10)     // Catch:{ all -> 0x09e2 }
            java.lang.String r10 = "value"
            if (r7 == 0) goto L_0x01de
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09e2 }
            java.lang.Double r7 = r7.zzc(r10)     // Catch:{ all -> 0x09e2 }
            double r17 = r7.doubleValue()     // Catch:{ all -> 0x09e2 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r7 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r7 != 0) goto L_0x0191
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09e2 }
            java.lang.Long r7 = r7.zzb(r10)     // Catch:{ all -> 0x09e2 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x09e2 }
            double r10 = (double) r11     // Catch:{ all -> 0x09e2 }
            double r17 = r10 * r19
        L_0x0191:
            r10 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r7 > 0) goto L_0x01c0
            r10 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x01c0
            long r10 = java.lang.Math.round(r17)     // Catch:{ all -> 0x09e2 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjp.zzb()     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x01bf
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzap.zzdf     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x01bf
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x01bf
            long r10 = -r10
            goto L_0x01e8
        L_0x01bf:
            goto L_0x01e8
        L_0x01c0:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r15)     // Catch:{ all -> 0x09e2 }
            java.lang.Double r10 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x09e2 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x09e2 }
            r23 = r5
            r5 = 0
            r11 = 0
            goto L_0x0307
        L_0x01de:
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09e2 }
            java.lang.Long r7 = r7.zzb(r10)     // Catch:{ all -> 0x09e2 }
            long r10 = r7.longValue()     // Catch:{ all -> 0x09e2 }
        L_0x01e8:
            boolean r7 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x0303
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = r8.toUpperCase(r7)     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "[A-Z]{3}"
            boolean r8 = r7.matches(r8)     // Catch:{ all -> 0x09e2 }
            if (r8 == 0) goto L_0x02ff
            java.lang.String r8 = "_ltv_"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x09e2 }
            int r9 = r7.length()     // Catch:{ all -> 0x09e2 }
            if (r9 == 0) goto L_0x0211
            java.lang.String r7 = r8.concat(r7)     // Catch:{ all -> 0x09e2 }
            goto L_0x0216
        L_0x0211:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x09e2 }
            r7.<init>(r8)     // Catch:{ all -> 0x09e2 }
        L_0x0216:
            r12 = r7
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzlb r7 = r7.zzc((java.lang.String) r15, (java.lang.String) r12)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0258
            java.lang.Object r8 = r7.zze     // Catch:{ all -> 0x09e2 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x09e2 }
            if (r8 != 0) goto L_0x022c
            r23 = r5
            r5 = 0
            r6 = 1
            goto L_0x025c
        L_0x022c:
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x09e2 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x09e2 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzlb r17 = new com.google.android.gms.measurement.internal.zzlb     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r13 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.common.util.Clock r13 = r13.zzm()     // Catch:{ all -> 0x09e2 }
            long r19 = r13.currentTimeMillis()     // Catch:{ all -> 0x09e2 }
            long r7 = r7 + r10
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09e2 }
            r7 = r17
            r8 = r15
            r11 = 2
            r10 = r12
            r23 = r5
            r5 = 0
            r6 = 1
            r11 = r19
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09e2 }
            r6 = r17
            goto L_0x02c2
        L_0x0258:
            r23 = r5
            r5 = 0
            r6 = 1
        L_0x025c:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r8 = r8.zzb()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzap.zzad     // Catch:{ all -> 0x09e2 }
            int r8 = r8.zzb(r15, r9)     // Catch:{ all -> 0x09e2 }
            int r8 = r8 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x09e2 }
            r7.zzd()     // Catch:{ all -> 0x09e2 }
            r7.zzak()     // Catch:{ all -> 0x09e2 }
            android.database.sqlite.SQLiteDatabase r9 = r7.mo13672c_()     // Catch:{ SQLiteException -> 0x0292 }
            java.lang.String r13 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0292 }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x0292 }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x0292 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0292 }
            r16 = 2
            r6[r16] = r8     // Catch:{ SQLiteException -> 0x0292 }
            r9.execSQL(r13, r6)     // Catch:{ SQLiteException -> 0x0292 }
            goto L_0x02a5
        L_0x0292:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r15)     // Catch:{ all -> 0x09e2 }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x09e2 }
        L_0x02a5:
            com.google.android.gms.measurement.internal.zzlb r17 = new com.google.android.gms.measurement.internal.zzlb     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.common.util.Clock r6 = r6.zzm()     // Catch:{ all -> 0x09e2 }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x09e2 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x09e2 }
            r7 = r17
            r8 = r15
            r10 = r12
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09e2 }
            r6 = r17
        L_0x02c2:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzlb) r6)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x0306
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r15)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzj()     // Catch:{ all -> 0x09e2 }
            java.lang.String r11 = r6.zzc     // Catch:{ all -> 0x09e2 }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x09e2 }
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x09e2 }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r7 = r6.zzi()     // Catch:{ all -> 0x09e2 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x09e2 }
            goto L_0x0306
        L_0x02ff:
            r23 = r5
            r5 = 0
            goto L_0x0306
        L_0x0303:
            r23 = r5
            r5 = 0
        L_0x0306:
            r11 = 1
        L_0x0307:
            if (r11 != 0) goto L_0x031b
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x09e2 }
            r2.mo13671b_()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzh()
            return
        L_0x0318:
            r23 = r5
            r5 = 0
        L_0x031b:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r6 = com.google.android.gms.measurement.internal.zzla.zza((java.lang.String) r6)     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r18 = r14.equals(r7)     // Catch:{ all -> 0x09e2 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjp.zzb()     // Catch:{ all -> 0x09e2 }
            r19 = 1
            if (r7 == 0) goto L_0x0350
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzdb     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0350
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            r7.zzi()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09e2 }
            long r7 = com.google.android.gms.measurement.internal.zzla.zza((com.google.android.gms.measurement.internal.zzam) r7)     // Catch:{ all -> 0x09e2 }
            long r7 = r7 + r19
            r11 = r7
            goto L_0x0352
        L_0x0350:
            r11 = r19
        L_0x0352:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            long r8 = r25.zzx()     // Catch:{ all -> 0x09e2 }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r21 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x09e2 }
            long r8 = r7.zzb     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzap.zzj     // Catch:{ all -> 0x09e2 }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x09e2 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x09e2 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x09e2 }
            long r10 = (long) r10     // Catch:{ all -> 0x09e2 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x03b3
            long r8 = r8 % r10
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x03a4
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x09e2 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r21)     // Catch:{ all -> 0x09e2 }
            long r5 = r7.zzb     // Catch:{ all -> 0x09e2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09e2 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09e2 }
        L_0x03a4:
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x09e2 }
            r2.mo13671b_()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzh()
            return
        L_0x03b3:
            if (r6 == 0) goto L_0x040a
            long r8 = r7.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzap.zzl     // Catch:{ all -> 0x09e2 }
            java.lang.Object r15 = r15.zza(r14)     // Catch:{ all -> 0x09e2 }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ all -> 0x09e2 }
            int r15 = r15.intValue()     // Catch:{ all -> 0x09e2 }
            long r14 = (long) r15     // Catch:{ all -> 0x09e2 }
            long r8 = r8 - r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x040a
            long r8 = r8 % r10
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x03e8
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzf()     // Catch:{ all -> 0x09e2 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r21)     // Catch:{ all -> 0x09e2 }
            long r6 = r7.zza     // Catch:{ all -> 0x09e2 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x09e2 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x09e2 }
        L_0x03e8:
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r7 = r3.zzi()     // Catch:{ all -> 0x09e2 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x09e2 }
            r12 = 0
            r8 = r21
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x09e2 }
            r2.mo13671b_()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzh()
            return
        L_0x040a:
            if (r18 == 0) goto L_0x045a
            long r8 = r7.zzd     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r10 = r10.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzap.zzk     // Catch:{ all -> 0x09e2 }
            int r10 = r10.zzb(r11, r14)     // Catch:{ all -> 0x09e2 }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x09e2 }
            int r10 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x09e2 }
            long r10 = (long) r10     // Catch:{ all -> 0x09e2 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x045a
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x044b
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x09e2 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r21)     // Catch:{ all -> 0x09e2 }
            long r5 = r7.zzd     // Catch:{ all -> 0x09e2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09e2 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09e2 }
        L_0x044b:
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x09e2 }
            r2.mo13671b_()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzh()
            return
        L_0x045a:
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x09e2 }
            android.os.Bundle r14 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09e2 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            r15 = r21
            boolean r7 = r7.zzf(r15)     // Catch:{ all -> 0x09e2 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x049d
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09e2 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09e2 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r11, (java.lang.Object) r8)     // Catch:{ all -> 0x09e2 }
        L_0x049d:
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "_sno"
            if (r7 == 0) goto L_0x04d6
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzap.zzas     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zze(r9, r10)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x04d6
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzlb r7 = r7.zzc((java.lang.String) r9, (java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x04d6
            java.lang.Object r9 = r7.zze     // Catch:{ all -> 0x09e2 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x09e2 }
            if (r9 == 0) goto L_0x04d6
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r9 = r9.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x09e2 }
            r9.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x09e2 }
        L_0x04d6:
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09e2 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x09e2 }
            if (r4 == 0) goto L_0x050e
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzaw     // Catch:{ all -> 0x09e2 }
            boolean r4 = r4.zze(r7, r9)     // Catch:{ all -> 0x09e2 }
            if (r4 == 0) goto L_0x050c
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzas     // Catch:{ all -> 0x09e2 }
            boolean r4 = r4.zze(r7, r9)     // Catch:{ all -> 0x09e2 }
            if (r4 != 0) goto L_0x050a
            com.google.android.gms.measurement.internal.zzkz r4 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x09e2 }
            r10 = 0
            r4.<init>(r8, r12, r10)     // Catch:{ all -> 0x09e2 }
            r1.zzb((com.google.android.gms.measurement.internal.zzkz) r4, (com.google.android.gms.measurement.internal.zzm) r3)     // Catch:{ all -> 0x09e2 }
            goto L_0x050f
        L_0x050a:
            r10 = 0
            goto L_0x050f
        L_0x050c:
            r10 = 0
            goto L_0x050f
        L_0x050e:
            r10 = 0
        L_0x050f:
            com.google.android.gms.measurement.internal.zzac r4 = r25.zze()     // Catch:{ all -> 0x09e2 }
            long r7 = r4.zzc(r15)     // Catch:{ all -> 0x09e2 }
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x0533
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r15)     // Catch:{ all -> 0x09e2 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09e2 }
            r4.zza(r9, r5, r7)     // Catch:{ all -> 0x09e2 }
        L_0x0533:
            com.google.android.gms.measurement.internal.zzak r4 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09e2 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x09e2 }
            long r12 = r2.zzd     // Catch:{ all -> 0x09e2 }
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r15
            r2 = r11
            r11 = r5
            r16 = r14
            r5 = r15
            r26 = 0
            r14 = r18
            r7.<init>((com.google.android.gms.measurement.internal.zzgo) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r4.zzb     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzaj r7 = r7.zza((java.lang.String) r5, (java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x05d4
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            long r7 = r7.zzh(r5)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r9 = r9.zzb()     // Catch:{ all -> 0x09e2 }
            int r9 = r9.zza((java.lang.String) r5)     // Catch:{ all -> 0x09e2 }
            long r9 = (long) r9     // Catch:{ all -> 0x09e2 }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x05ba
            if (r6 == 0) goto L_0x05ba
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x09e2 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r5)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzj()     // Catch:{ all -> 0x09e2 }
            java.lang.String r4 = r4.zzb     // Catch:{ all -> 0x09e2 }
            java.lang.String r4 = r7.zza((java.lang.String) r4)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            int r7 = r7.zza((java.lang.String) r5)     // Catch:{ all -> 0x09e2 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x09e2 }
            r2.zza(r3, r6, r4, r7)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r7 = r2.zzi()     // Catch:{ all -> 0x09e2 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r5
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzh()
            return
        L_0x05ba:
            com.google.android.gms.measurement.internal.zzaj r6 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x09e2 }
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x09e2 }
            r10 = 0
            r12 = 0
            long r14 = r4.zzc     // Catch:{ all -> 0x09e2 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r6
            r8 = r5
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x09e2 }
            goto L_0x05e2
        L_0x05d4:
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x09e2 }
            long r8 = r7.zzf     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzak r4 = r4.zza(r5, r8)     // Catch:{ all -> 0x09e2 }
            long r5 = r4.zzc     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzaj r6 = r7.zza(r5)     // Catch:{ all -> 0x09e2 }
        L_0x05e2:
            com.google.android.gms.measurement.internal.zzac r5 = r25.zze()     // Catch:{ all -> 0x09e2 }
            r5.zza((com.google.android.gms.measurement.internal.zzaj) r6)     // Catch:{ all -> 0x09e2 }
            r25.zzw()     // Catch:{ all -> 0x09e2 }
            r25.zzk()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)     // Catch:{ all -> 0x09e2 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x09e2 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x09e2 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x09e2 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r5 = com.google.android.gms.internal.measurement.zzbr.zzg.zzbf()     // Catch:{ all -> 0x09e2 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r5 = r5.zza((int) r6)     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r5 = r5.zza((java.lang.String) r7)     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x0622
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09e2 }
            r5.zzf((java.lang.String) r7)     // Catch:{ all -> 0x09e2 }
        L_0x0622:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x062f
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09e2 }
            r5.zze((java.lang.String) r7)     // Catch:{ all -> 0x09e2 }
        L_0x062f:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x063c
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09e2 }
            r5.zzg((java.lang.String) r7)     // Catch:{ all -> 0x09e2 }
        L_0x063c:
            long r7 = r3.zzj     // Catch:{ all -> 0x09e2 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x064b
            long r7 = r3.zzj     // Catch:{ all -> 0x09e2 }
            int r8 = (int) r7     // Catch:{ all -> 0x09e2 }
            r5.zzh((int) r8)     // Catch:{ all -> 0x09e2 }
        L_0x064b:
            long r7 = r3.zze     // Catch:{ all -> 0x09e2 }
            r5.zzf((long) r7)     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x065d
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09e2 }
            r5.zzk((java.lang.String) r7)     // Catch:{ all -> 0x09e2 }
        L_0x065d:
            boolean r7 = com.google.android.gms.internal.measurement.zzll.zzb()     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x06ac
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzch     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x06ac
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x068a
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x068a
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09e2 }
            r5.zzp(r7)     // Catch:{ all -> 0x09e2 }
        L_0x068a:
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x06e0
            java.lang.String r7 = r5.zzo()     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x06e0
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x06e0
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09e2 }
            r5.zzo(r7)     // Catch:{ all -> 0x09e2 }
            goto L_0x06e0
        L_0x06ac:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzap.zzbh     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r8)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x06d3
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x06e0
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x06e0
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09e2 }
            r5.zzo(r7)     // Catch:{ all -> 0x09e2 }
            goto L_0x06e0
        L_0x06d3:
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x06e0
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09e2 }
            r5.zzo(r7)     // Catch:{ all -> 0x09e2 }
        L_0x06e0:
            long r7 = r3.zzf     // Catch:{ all -> 0x09e2 }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x06ed
            long r7 = r3.zzf     // Catch:{ all -> 0x09e2 }
            r5.zzh((long) r7)     // Catch:{ all -> 0x09e2 }
        L_0x06ed:
            long r7 = r3.zzt     // Catch:{ all -> 0x09e2 }
            r5.zzk((long) r7)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzap.zzbe     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zze(r8, r11)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0710
            com.google.android.gms.measurement.internal.zzkw r7 = r25.zzh()     // Catch:{ all -> 0x09e2 }
            java.util.List r7 = r7.zzf()     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0710
            r5.zzd((java.lang.Iterable<? extends java.lang.Integer>) r7)     // Catch:{ all -> 0x09e2 }
        L_0x0710:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzc()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09e2 }
            android.util.Pair r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0744
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x09e2 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x09e2 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09e2 }
            if (r8 != 0) goto L_0x0744
            boolean r8 = r3.zzo     // Catch:{ all -> 0x09e2 }
            if (r8 == 0) goto L_0x07ab
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x09e2 }
            r5.zzh((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            java.lang.Object r8 = r7.second     // Catch:{ all -> 0x09e2 }
            if (r8 == 0) goto L_0x07ab
            java.lang.Object r7 = r7.second     // Catch:{ all -> 0x09e2 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x09e2 }
            r5.zza((boolean) r7)     // Catch:{ all -> 0x09e2 }
            goto L_0x07ab
        L_0x0744:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzah r7 = r7.zzx()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            android.content.Context r8 = r8.zzn()     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zza(r8)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x07ab
            boolean r7 = r3.zzp     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x07ab
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            android.content.Context r7 = r7.zzn()     // Catch:{ all -> 0x09e2 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x078a
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = "null secure ID. appId"
            java.lang.String r11 = r5.zzj()     // Catch:{ all -> 0x09e2 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r11)     // Catch:{ all -> 0x09e2 }
            r7.zza(r8, r11)     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = "null"
            goto L_0x07a8
        L_0x078a:
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x09e2 }
            if (r8 == 0) goto L_0x07a8
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r5.zzj()     // Catch:{ all -> 0x09e2 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r12)     // Catch:{ all -> 0x09e2 }
            r8.zza(r11, r12)     // Catch:{ all -> 0x09e2 }
        L_0x07a8:
            r5.zzm(r7)     // Catch:{ all -> 0x09e2 }
        L_0x07ab:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzah r7 = r7.zzx()     // Catch:{ all -> 0x09e2 }
            r7.zzaa()     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r5.zzc((java.lang.String) r7)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzx()     // Catch:{ all -> 0x09e2 }
            r8.zzaa()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzx()     // Catch:{ all -> 0x09e2 }
            long r11 = r8.zzf()     // Catch:{ all -> 0x09e2 }
            int r8 = (int) r11     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r7.zzf((int) r8)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzx()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r7.zzd((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            long r11 = r3.zzl     // Catch:{ all -> 0x09e2 }
            r7.zzj((long) r11)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x09e2 }
            boolean r7 = r7.zzab()     // Catch:{ all -> 0x09e2 }
            if (r7 == 0) goto L_0x0802
            r5.zzj()     // Catch:{ all -> 0x09e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r26)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x0802
            r7 = r26
            r5.zzn(r7)     // Catch:{ all -> 0x09e2 }
        L_0x0802:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)     // Catch:{ all -> 0x09e2 }
            if (r7 != 0) goto L_0x0877
            com.google.android.gms.measurement.internal.zzg r7 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09e2 }
            r7.<init>(r8, r11)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzla r8 = r8.zzi()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r8.zzk()     // Catch:{ all -> 0x09e2 }
            r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zzk     // Catch:{ all -> 0x09e2 }
            r7.zzf((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x09e2 }
            r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzft r8 = r8.zzc()     // Catch:{ all -> 0x09e2 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r8.zzb((java.lang.String) r11)     // Catch:{ all -> 0x09e2 }
            r7.zze((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            r7.zzg((long) r9)     // Catch:{ all -> 0x09e2 }
            r7.zza((long) r9)     // Catch:{ all -> 0x09e2 }
            r7.zzb((long) r9)     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x09e2 }
            r7.zzg((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            long r11 = r3.zzj     // Catch:{ all -> 0x09e2 }
            r7.zzc((long) r11)     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x09e2 }
            r7.zzh((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            long r11 = r3.zze     // Catch:{ all -> 0x09e2 }
            r7.zzd((long) r11)     // Catch:{ all -> 0x09e2 }
            long r11 = r3.zzf     // Catch:{ all -> 0x09e2 }
            r7.zze((long) r11)     // Catch:{ all -> 0x09e2 }
            boolean r8 = r3.zzh     // Catch:{ all -> 0x09e2 }
            r7.zza((boolean) r8)     // Catch:{ all -> 0x09e2 }
            long r11 = r3.zzl     // Catch:{ all -> 0x09e2 }
            r7.zzp(r11)     // Catch:{ all -> 0x09e2 }
            long r11 = r3.zzt     // Catch:{ all -> 0x09e2 }
            r7.zzf((long) r11)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r8 = r25.zze()     // Catch:{ all -> 0x09e2 }
            r8.zza((com.google.android.gms.measurement.internal.zzg) r7)     // Catch:{ all -> 0x09e2 }
        L_0x0877:
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x09e2 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09e2 }
            if (r8 != 0) goto L_0x0888
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x09e2 }
            r5.zzi((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
        L_0x0888:
            java.lang.String r8 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09e2 }
            if (r8 != 0) goto L_0x0899
            java.lang.String r7 = r7.zzi()     // Catch:{ all -> 0x09e2 }
            r5.zzl((java.lang.String) r7)     // Catch:{ all -> 0x09e2 }
        L_0x0899:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ all -> 0x09e2 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09e2 }
            java.util.List r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09e2 }
            r11 = 0
        L_0x08a4:
            int r8 = r7.size()     // Catch:{ all -> 0x09e2 }
            if (r11 >= r8) goto L_0x08db
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r8 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj()     // Catch:{ all -> 0x09e2 }
            java.lang.Object r12 = r7.get(r11)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzlb r12 = (com.google.android.gms.measurement.internal.zzlb) r12     // Catch:{ all -> 0x09e2 }
            java.lang.String r12 = r12.zzc     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r8 = r8.zza((java.lang.String) r12)     // Catch:{ all -> 0x09e2 }
            java.lang.Object r12 = r7.get(r11)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzlb r12 = (com.google.android.gms.measurement.internal.zzlb) r12     // Catch:{ all -> 0x09e2 }
            long r12 = r12.zzd     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r8 = r8.zza((long) r12)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzkw r12 = r25.zzh()     // Catch:{ all -> 0x09e2 }
            java.lang.Object r13 = r7.get(r11)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzlb r13 = (com.google.android.gms.measurement.internal.zzlb) r13     // Catch:{ all -> 0x09e2 }
            java.lang.Object r13 = r13.zze     // Catch:{ all -> 0x09e2 }
            r12.zza((com.google.android.gms.internal.measurement.zzbr.zzk.zza) r8, (java.lang.Object) r13)     // Catch:{ all -> 0x09e2 }
            r5.zza((com.google.android.gms.internal.measurement.zzbr.zzk.zza) r8)     // Catch:{ all -> 0x09e2 }
            int r11 = r11 + 1
            goto L_0x08a4
        L_0x08db:
            com.google.android.gms.measurement.internal.zzac r7 = r25.zze()     // Catch:{ IOException -> 0x0955 }
            com.google.android.gms.internal.measurement.zzgo r8 = r5.zzu()     // Catch:{ IOException -> 0x0955 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ IOException -> 0x0955 }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = (com.google.android.gms.internal.measurement.zzbr.zzg) r8     // Catch:{ IOException -> 0x0955 }
            long r7 = r7.zza((com.google.android.gms.internal.measurement.zzbr.zzg) r8)     // Catch:{ IOException -> 0x0955 }
            com.google.android.gms.measurement.internal.zzac r5 = r25.zze()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzam r11 = r4.zze     // Catch:{ all -> 0x09e2 }
            if (r11 == 0) goto L_0x094b
            com.google.android.gms.measurement.internal.zzam r11 = r4.zze     // Catch:{ all -> 0x09e2 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x09e2 }
        L_0x08fb:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x09e2 }
            if (r12 == 0) goto L_0x0910
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x09e2 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x09e2 }
            boolean r12 = r2.equals(r12)     // Catch:{ all -> 0x09e2 }
            if (r12 == 0) goto L_0x090f
            r11 = 1
            goto L_0x094c
        L_0x090f:
            goto L_0x08fb
        L_0x0910:
            com.google.android.gms.measurement.internal.zzgi r2 = r25.zzc()     // Catch:{ all -> 0x09e2 }
            java.lang.String r11 = r4.zza     // Catch:{ all -> 0x09e2 }
            java.lang.String r12 = r4.zzb     // Catch:{ all -> 0x09e2 }
            boolean r2 = r2.zzc(r11, r12)     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzac r11 = r25.zze()     // Catch:{ all -> 0x09e2 }
            long r12 = r25.zzx()     // Catch:{ all -> 0x09e2 }
            java.lang.String r14 = r4.zza     // Catch:{ all -> 0x09e2 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza(r12, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x09e2 }
            if (r2 == 0) goto L_0x094b
            long r11 = r11.zze     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r13 = r4.zza     // Catch:{ all -> 0x09e2 }
            int r2 = r2.zzb(r13)     // Catch:{ all -> 0x09e2 }
            long r13 = (long) r2     // Catch:{ all -> 0x09e2 }
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x094b
            r11 = 1
            goto L_0x094c
        L_0x094b:
            r11 = 0
        L_0x094c:
            boolean r2 = r5.zza((com.google.android.gms.measurement.internal.zzak) r4, (long) r7, (boolean) r11)     // Catch:{ all -> 0x09e2 }
            if (r2 == 0) goto L_0x0970
            r1.zzm = r9     // Catch:{ all -> 0x09e2 }
            goto L_0x0970
        L_0x0955:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzf()     // Catch:{ all -> 0x09e2 }
            java.lang.String r7 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r5 = r5.zzj()     // Catch:{ all -> 0x09e2 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r5)     // Catch:{ all -> 0x09e2 }
            r6.zza(r7, r5, r2)     // Catch:{ all -> 0x09e2 }
        L_0x0970:
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()     // Catch:{ all -> 0x09e2 }
            r2.mo13671b_()     // Catch:{ all -> 0x09e2 }
            boolean r2 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x09e2 }
            if (r2 == 0) goto L_0x098d
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x09e2 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x09e2 }
            boolean r2 = r2.zze(r3, r5)     // Catch:{ all -> 0x09e2 }
            if (r2 != 0) goto L_0x09b4
        L_0x098d:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x09e2 }
            r3 = 2
            boolean r2 = r2.zza((int) r3)     // Catch:{ all -> 0x09e2 }
            if (r2 == 0) goto L_0x09b4
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()     // Catch:{ all -> 0x09e2 }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x09e2 }
            com.google.android.gms.measurement.internal.zzfi r5 = r5.zzj()     // Catch:{ all -> 0x09e2 }
            java.lang.String r4 = r5.zza((com.google.android.gms.measurement.internal.zzak) r4)     // Catch:{ all -> 0x09e2 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x09e2 }
        L_0x09b4:
            com.google.android.gms.measurement.internal.zzac r2 = r25.zze()
            r2.zzh()
            r25.zzz()
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x09e2:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzac r3 = r25.zze()
            r3.zzh()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        int i;
        String d_;
        zzg zzb2;
        String str;
        String str2;
        String zza2;
        zzw();
        zzk();
        this.zzs = true;
        try {
            this.zzj.zzu();
            Boolean zzag = this.zzj.zzw().zzag();
            if (zzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
                this.zzs = false;
                zzaa();
            } else if (zzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                this.zzs = false;
                zzaa();
            } else if (this.zzm > 0) {
                zzz();
                this.zzs = false;
                zzaa();
            } else {
                zzw();
                if (this.zzv != null) {
                    this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                    this.zzs = false;
                    zzaa();
                } else if (!zzd().zzf()) {
                    this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                    zzz();
                    this.zzs = false;
                    zzaa();
                } else {
                    long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
                    if (zzlx.zzb()) {
                        i = this.zzj.zzb().zzb((String) null, zzap.zzao);
                    } else {
                        i = 1;
                    }
                    if (i > 1) {
                        long zzk2 = currentTimeMillis - zzx.zzk();
                        for (int i2 = 0; i2 < i && zza((String) null, zzk2); i2++) {
                        }
                    } else {
                        zza((String) null, currentTimeMillis - zzx.zzk());
                    }
                    long zza3 = this.zzj.zzc().zzc.zza();
                    if (zza3 != 0) {
                        this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza3)));
                    }
                    d_ = zze().mo13673d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzx == -1) {
                            this.zzx = zze().zzaa();
                        }
                        List<Pair<zzbr.zzg, Long>> zza4 = zze().zza(d_, this.zzj.zzb().zzb(d_, zzap.zzf), Math.max(0, this.zzj.zzb().zzb(d_, zzap.zzg)));
                        if (!zza4.isEmpty()) {
                            Iterator<Pair<zzbr.zzg, Long>> it = zza4.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzbr.zzg zzg2 = (zzbr.zzg) it.next().first;
                                if (!TextUtils.isEmpty(zzg2.zzad())) {
                                    str = zzg2.zzad();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= zza4.size()) {
                                        break;
                                    }
                                    zzbr.zzg zzg3 = (zzbr.zzg) zza4.get(i3).first;
                                    if (!TextUtils.isEmpty(zzg3.zzad()) && !zzg3.zzad().equals(str)) {
                                        zza4 = zza4.subList(0, i3);
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            zzbr.zzf.zza zzb3 = zzbr.zzf.zzb();
                            int size = zza4.size();
                            ArrayList arrayList = new ArrayList(zza4.size());
                            boolean zzf2 = this.zzj.zzb().zzf(d_);
                            for (int i4 = 0; i4 < size; i4++) {
                                zzbr.zzg.zza zza5 = (zzbr.zzg.zza) ((zzbr.zzg) zza4.get(i4).first).zzbm();
                                arrayList.add((Long) zza4.get(i4).second);
                                zzbr.zzg.zza zza6 = zza5.zzg(this.zzj.zzb().zze()).zza(currentTimeMillis);
                                this.zzj.zzu();
                                zza6.zzb(false);
                                if (!zzf2) {
                                    zza5.zzn();
                                }
                                if (this.zzj.zzb().zze(d_, zzap.zzbg)) {
                                    zza5.zzl(zzh().zza(((zzbr.zzg) ((zzfd) zza5.zzu())).zzbi()));
                                }
                                zzb3.zza(zza5);
                            }
                            if (this.zzj.zzr().zza(2)) {
                                str2 = zzh().zza((zzbr.zzf) ((zzfd) zzb3.zzu()));
                            } else {
                                str2 = null;
                            }
                            zzh();
                            byte[] zzbi = ((zzbr.zzf) ((zzfd) zzb3.zzu())).zzbi();
                            zza2 = zzap.zzp.zza(null);
                            URL url = new URL(zza2);
                            Preconditions.checkArgument(!arrayList.isEmpty());
                            if (this.zzv != null) {
                                this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzv = new ArrayList(arrayList);
                            }
                            this.zzj.zzc().zzd.zza(currentTimeMillis);
                            String str3 = "?";
                            if (size > 0) {
                                str3 = zzb3.zza(0).zzx();
                            }
                            this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", str3, Integer.valueOf(zzbi.length), str2);
                            this.zzr = true;
                            zzfo zzd2 = zzd();
                            zzku zzku = new zzku(this, d_);
                            zzd2.zzd();
                            zzd2.zzak();
                            Preconditions.checkNotNull(url);
                            Preconditions.checkNotNull(zzbi);
                            Preconditions.checkNotNull(zzku);
                            zzd2.zzq().zzb((Runnable) new zzfs(zzd2, d_, url, zzbi, (Map<String, String>) null, zzku));
                        }
                    } else {
                        this.zzx = -1;
                        String zza7 = zze().zza(currentTimeMillis - zzx.zzk());
                        if (!TextUtils.isEmpty(zza7) && (zzb2 = zze().zzb(zza7)) != null) {
                            zza(zzb2);
                        }
                    }
                    this.zzs = false;
                    zzaa();
                }
            }
        } catch (MalformedURLException e) {
            this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzfk.zza(d_), zza2);
        } catch (Throwable th) {
            this.zzs = false;
            zzaa();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0265 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0273 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03c7 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03c9 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03cc A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03cd A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x05e5 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x06b5 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x06cc A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x07f7 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0811 A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x082c A[Catch:{ IOException -> 0x0222, all -> 0x1028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:588:0x1010 A[SYNTHETIC, Splitter:B:588:0x1010] */
    /* JADX WARNING: Removed duplicated region for block: B:595:0x1024 A[SYNTHETIC, Splitter:B:595:0x1024] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r58, long r59) {
        /*
            r57 = this;
            r1 = r57
            java.lang.String r2 = "_npa"
            com.google.android.gms.measurement.internal.zzac r3 = r57.zze()
            r3.zzf()
            com.google.android.gms.measurement.internal.zzks$zza r3 = new com.google.android.gms.measurement.internal.zzks$zza     // Catch:{ all -> 0x1028 }
            r4 = 0
            r3.<init>(r1, r4)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzac r5 = r57.zze()     // Catch:{ all -> 0x1028 }
            long r6 = r1.zzx     // Catch:{ all -> 0x1028 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x1028 }
            r5.zzd()     // Catch:{ all -> 0x1028 }
            r5.zzak()     // Catch:{ all -> 0x1028 }
            r9 = -1
            r11 = 2
            r12 = 0
            r13 = 1
            android.database.sqlite.SQLiteDatabase r15 = r5.mo13672c_()     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            boolean r14 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r16 = ""
            if (r14 == 0) goto L_0x0097
            int r14 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x004b
            java.lang.String[] r8 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0046 }
            java.lang.String r17 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0046 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0046 }
            java.lang.String r17 = java.lang.String.valueOf(r59)     // Catch:{ SQLiteException -> 0x0046 }
            r8[r13] = r17     // Catch:{ SQLiteException -> 0x0046 }
            goto L_0x0053
        L_0x0046:
            r0 = move-exception
            r6 = r0
            r8 = r4
            goto L_0x024a
        L_0x004b:
            java.lang.String[] r8 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r17 = java.lang.String.valueOf(r59)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
        L_0x0053:
            if (r14 == 0) goto L_0x0058
            java.lang.String r16 = "rowid <= ? and "
        L_0x0058:
            r14 = r16
            java.lang.String r16 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            int r4 = r16.length()     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            int r4 = r4 + 148
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            r11.<init>(r4)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where "
            r11.append(r4)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            r11.append(r14)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r4 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r11.append(r4)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r4 = r11.toString()     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            android.database.Cursor r4 = r15.rawQuery(r4, r8)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x023e }
            if (r8 != 0) goto L_0x008b
            if (r4 == 0) goto L_0x0089
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x0089:
            goto L_0x0260
        L_0x008b:
            java.lang.String r8 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x023e }
            java.lang.String r11 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x023b }
            r4.close()     // Catch:{ SQLiteException -> 0x023b }
            goto L_0x00ed
        L_0x0097:
            int r4 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x00a8
            r8 = 2
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            r8 = 0
            r11[r12] = r8     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            r11[r13] = r8     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            goto L_0x00ad
        L_0x00a8:
            r8 = 0
            java.lang.String[] r11 = new java.lang.String[]{r8}     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
        L_0x00ad:
            if (r4 == 0) goto L_0x00b2
            java.lang.String r16 = " and rowid <= ?"
        L_0x00b2:
            r4 = r16
            java.lang.String r8 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            int r8 = r8.length()     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            int r8 = r8 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            r14.<init>(r8)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r8 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r8)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            r14.append(r4)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r4 = " order by rowid limit 1;"
            r14.append(r4)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            java.lang.String r4 = r14.toString()     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            android.database.Cursor r4 = r15.rawQuery(r4, r11)     // Catch:{ SQLiteException -> 0x0246, all -> 0x0241 }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x023e }
            if (r8 != 0) goto L_0x00e5
            if (r4 == 0) goto L_0x00e3
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x00e3:
            goto L_0x0260
        L_0x00e5:
            java.lang.String r11 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x023e }
            r4.close()     // Catch:{ SQLiteException -> 0x023e }
            r8 = 0
        L_0x00ed:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r14 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r14}     // Catch:{ SQLiteException -> 0x023b }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r14 = 2
            java.lang.String[] r9 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x023b }
            r9[r12] = r8     // Catch:{ SQLiteException -> 0x023b }
            r9[r13] = r11     // Catch:{ SQLiteException -> 0x023b }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "2"
            r14 = r15
            r10 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r9
            android.database.Cursor r4 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x023b }
            boolean r9 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x023b }
            if (r9 != 0) goto L_0x0132
            com.google.android.gms.measurement.internal.zzfk r6 = r5.zzr()     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzf()     // Catch:{ SQLiteException -> 0x023b }
            java.lang.String r7 = "Raw event metadata record is missing. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x023b }
            r6.zza(r7, r9)     // Catch:{ SQLiteException -> 0x023b }
            if (r4 == 0) goto L_0x0130
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x0130:
            goto L_0x0260
        L_0x0132:
            byte[] r9 = r4.getBlob(r12)     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r14 = com.google.android.gms.internal.measurement.zzbr.zzg.zzbf()     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzgn r9 = com.google.android.gms.measurement.internal.zzkw.zza(r14, (byte[]) r9)     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r9 = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzgo r9 = r9.zzu()     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = (com.google.android.gms.internal.measurement.zzbr.zzg) r9     // Catch:{ IOException -> 0x0222 }
            boolean r14 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x023b }
            if (r14 == 0) goto L_0x0160
            com.google.android.gms.measurement.internal.zzfk r14 = r5.zzr()     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.measurement.internal.zzfm r14 = r14.zzi()     // Catch:{ SQLiteException -> 0x023b }
            java.lang.String r15 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x023b }
            r14.zza(r15, r13)     // Catch:{ SQLiteException -> 0x023b }
        L_0x0160:
            r4.close()     // Catch:{ SQLiteException -> 0x023b }
            r3.zza(r9)     // Catch:{ SQLiteException -> 0x023b }
            r13 = -1
            int r9 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x0182
            java.lang.String r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x023b }
            r14[r12] = r8     // Catch:{ SQLiteException -> 0x023b }
            r13 = 1
            r14[r13] = r11     // Catch:{ SQLiteException -> 0x023b }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x023b }
            r7 = 2
            r14[r7] = r6     // Catch:{ SQLiteException -> 0x023b }
            r17 = r9
            r18 = r14
            goto L_0x0190
        L_0x0182:
            java.lang.String r6 = "app_id = ? and metadata_fingerprint = ?"
            r7 = 2
            java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x023b }
            r9[r12] = r8     // Catch:{ SQLiteException -> 0x023b }
            r7 = 1
            r9[r7] = r11     // Catch:{ SQLiteException -> 0x023b }
            r17 = r6
            r18 = r9
        L_0x0190:
            java.lang.String r15 = "raw_events"
            java.lang.String r6 = "rowid"
            java.lang.String r7 = "name"
            java.lang.String r9 = "timestamp"
            java.lang.String r11 = "data"
            java.lang.String[] r16 = new java.lang.String[]{r6, r7, r9, r11}     // Catch:{ SQLiteException -> 0x023b }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            r22 = 0
            r14 = r10
            android.database.Cursor r4 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x023b }
            boolean r6 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x023b }
            if (r6 != 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzfk r6 = r5.zzr()     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzi()     // Catch:{ SQLiteException -> 0x023b }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x023b }
            r6.zza(r7, r9)     // Catch:{ SQLiteException -> 0x023b }
            if (r4 == 0) goto L_0x01c7
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x01c7:
            goto L_0x0260
        L_0x01c9:
            long r6 = r4.getLong(r12)     // Catch:{ SQLiteException -> 0x023b }
            r9 = 3
            byte[] r10 = r4.getBlob(r9)     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r9 = com.google.android.gms.internal.measurement.zzbr.zzc.zzj()     // Catch:{ IOException -> 0x0202 }
            com.google.android.gms.internal.measurement.zzgn r9 = com.google.android.gms.measurement.internal.zzkw.zza(r9, (byte[]) r10)     // Catch:{ IOException -> 0x0202 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r9     // Catch:{ IOException -> 0x0202 }
            r10 = 1
            java.lang.String r11 = r4.getString(r10)     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r10 = r9.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x023b }
            r11 = 2
            long r13 = r4.getLong(r11)     // Catch:{ SQLiteException -> 0x023b }
            r10.zza((long) r13)     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.internal.measurement.zzgo r9 = r9.zzu()     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.internal.measurement.zzbr$zzc r9 = (com.google.android.gms.internal.measurement.zzbr.zzc) r9     // Catch:{ SQLiteException -> 0x023b }
            boolean r6 = r3.zza(r6, r9)     // Catch:{ SQLiteException -> 0x023b }
            if (r6 != 0) goto L_0x0216
            if (r4 == 0) goto L_0x0201
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x0201:
            goto L_0x0260
        L_0x0202:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfk r7 = r5.zzr()     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x023b }
            java.lang.String r9 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x023b }
            r7.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x023b }
        L_0x0216:
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x023b }
            if (r6 != 0) goto L_0x01c9
            if (r4 == 0) goto L_0x0260
            r4.close()     // Catch:{ all -> 0x1028 }
            goto L_0x0260
        L_0x0222:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfk r7 = r5.zzr()     // Catch:{ SQLiteException -> 0x023b }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x023b }
            java.lang.String r9 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x023b }
            r7.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x023b }
            if (r4 == 0) goto L_0x023a
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x023a:
            goto L_0x0260
        L_0x023b:
            r0 = move-exception
            r6 = r0
            goto L_0x024a
        L_0x023e:
            r0 = move-exception
            r6 = r0
            goto L_0x0249
        L_0x0241:
            r0 = move-exception
            r2 = r0
            r4 = 0
            goto L_0x1022
        L_0x0246:
            r0 = move-exception
            r6 = r0
            r4 = 0
        L_0x0249:
            r8 = 0
        L_0x024a:
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzr()     // Catch:{ all -> 0x1020 }
            com.google.android.gms.measurement.internal.zzfm r5 = r5.zzf()     // Catch:{ all -> 0x1020 }
            java.lang.String r7 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r8)     // Catch:{ all -> 0x1020 }
            r5.zza(r7, r8, r6)     // Catch:{ all -> 0x1020 }
            if (r4 == 0) goto L_0x0260
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x0260:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r4 = r3.zzc     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0270
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r4 = r3.zzc     // Catch:{ all -> 0x1028 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x026e
            goto L_0x0270
        L_0x026e:
            r4 = 0
            goto L_0x0271
        L_0x0270:
            r4 = 1
        L_0x0271:
            if (r4 != 0) goto L_0x1010
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = r4.zzbm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = (com.google.android.gms.internal.measurement.zzfd.zzb) r4     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r4 = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) r4     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r4 = r4.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r5 = r5.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzap.zzbb     // Catch:{ all -> 0x1028 }
            boolean r5 = r5.zze(r6, r7)     // Catch:{ all -> 0x1028 }
            r6 = -1
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = 0
            r14 = 0
            r16 = 0
        L_0x02a5:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r7 = r3.zzc     // Catch:{ all -> 0x1028 }
            int r7 = r7.size()     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = "_fr"
            r19 = r13
            java.lang.String r13 = "_e"
            r20 = r2
            java.lang.String r2 = "_et"
            r21 = r14
            if (r11 >= r7) goto L_0x0885
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r7 = r3.zzc     // Catch:{ all -> 0x1028 }
            java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r7 = (com.google.android.gms.internal.measurement.zzbr.zzc) r7     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = r7.zzbm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = (com.google.android.gms.internal.measurement.zzfd.zzb) r7     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgi r14 = r57.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r15 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x1028 }
            r23 = r11
            java.lang.String r11 = r7.zzd()     // Catch:{ all -> 0x1028 }
            boolean r11 = r14.zzb(r15, r11)     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = "_err"
            if (r11 == 0) goto L_0x0365
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgo r13 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfi r13 = r13.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r7.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.String r13 = r13.zza((java.lang.String) r15)     // Catch:{ all -> 0x1028 }
            r2.zza(r8, r11, r13)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgi r2 = r57.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zzg(r8)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x032e
            com.google.android.gms.measurement.internal.zzgi r2 = r57.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zzh(r8)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x032c
            goto L_0x032e
        L_0x032c:
            r2 = 0
            goto L_0x032f
        L_0x032e:
            r2 = 1
        L_0x032f:
            if (r2 != 0) goto L_0x0355
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r14.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x0355
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzla r24 = r2.zzi()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r25 = r2.zzx()     // Catch:{ all -> 0x1028 }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r7.zzd()     // Catch:{ all -> 0x1028 }
            r29 = 0
            r24.zza((java.lang.String) r25, (int) r26, (java.lang.String) r27, (java.lang.String) r28, (int) r29)     // Catch:{ all -> 0x1028 }
        L_0x0355:
            r24 = r5
            r26 = r9
            r8 = r12
            r13 = r19
            r14 = r21
            r11 = r23
            r12 = 3
            r9 = r4
            r4 = -1
            goto L_0x0879
        L_0x0365:
            com.google.android.gms.measurement.internal.zzgi r11 = r57.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r15 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x1028 }
            r24 = r5
            java.lang.String r5 = r7.zzd()     // Catch:{ all -> 0x1028 }
            boolean r5 = r11.zzc(r15, r5)     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = "_c"
            if (r5 != 0) goto L_0x03d7
            r57.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r7.zzd()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x1028 }
            r25 = r12
            int r12 = r15.hashCode()     // Catch:{ all -> 0x1028 }
            r26 = r9
            r9 = 94660(0x171c4, float:1.32647E-40)
            if (r12 == r9) goto L_0x03b4
            r9 = 95025(0x17331, float:1.33158E-40)
            if (r12 == r9) goto L_0x03aa
            r9 = 95027(0x17333, float:1.33161E-40)
            if (r12 == r9) goto L_0x03a0
        L_0x039f:
            goto L_0x03be
        L_0x03a0:
            java.lang.String r9 = "_ui"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x039f
            r9 = 1
            goto L_0x03bf
        L_0x03aa:
            java.lang.String r9 = "_ug"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x039f
            r9 = 2
            goto L_0x03bf
        L_0x03b4:
            java.lang.String r9 = "_in"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x1028 }
            if (r9 == 0) goto L_0x039f
            r9 = 0
            goto L_0x03bf
        L_0x03be:
            r9 = -1
        L_0x03bf:
            if (r9 == 0) goto L_0x03c9
            r12 = 1
            if (r9 == r12) goto L_0x03c9
            r12 = 2
            if (r9 == r12) goto L_0x03c9
            r9 = 0
            goto L_0x03ca
        L_0x03c9:
            r9 = 1
        L_0x03ca:
            if (r9 == 0) goto L_0x03cd
            goto L_0x03db
        L_0x03cd:
            r27 = r2
            r28 = r4
            r29 = r13
            r13 = r19
            goto L_0x05e3
        L_0x03d7:
            r26 = r9
            r25 = r12
        L_0x03db:
            r9 = 0
            r12 = 0
            r15 = 0
        L_0x03e0:
            r27 = r2
            int r2 = r7.zzb()     // Catch:{ all -> 0x1028 }
            r28 = r4
            java.lang.String r4 = "_r"
            if (r9 >= r2) goto L_0x045f
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza((int) r9)     // Catch:{ all -> 0x1028 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x041f
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza((int) r9)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = r2.zzbm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r2     // Catch:{ all -> 0x1028 }
            r29 = r13
            r12 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((long) r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x1028 }
            r7.zza((int) r9, (com.google.android.gms.internal.measurement.zzbr.zze) r2)     // Catch:{ all -> 0x1028 }
            r30 = r14
            r12 = 1
            goto L_0x0454
        L_0x041f:
            r29 = r13
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza((int) r9)     // Catch:{ all -> 0x1028 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0452
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza((int) r9)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = r2.zzbm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r2     // Catch:{ all -> 0x1028 }
            r30 = r14
            r13 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((long) r13)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x1028 }
            r7.zza((int) r9, (com.google.android.gms.internal.measurement.zzbr.zze) r2)     // Catch:{ all -> 0x1028 }
            r15 = 1
            goto L_0x0454
        L_0x0452:
            r30 = r14
        L_0x0454:
            int r9 = r9 + 1
            r2 = r27
            r4 = r28
            r13 = r29
            r14 = r30
            goto L_0x03e0
        L_0x045f:
            r29 = r13
            r30 = r14
            if (r12 != 0) goto L_0x0497
            if (r5 == 0) goto L_0x0497
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfi r12 = r12.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r13 = r7.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zza((java.lang.String) r13)     // Catch:{ all -> 0x1028 }
            r2.zza(r9, r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = com.google.android.gms.internal.measurement.zzbr.zze.zzk()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((long) r12)     // Catch:{ all -> 0x1028 }
            r7.zza((com.google.android.gms.internal.measurement.zzbr.zze.zza) r2)     // Catch:{ all -> 0x1028 }
        L_0x0497:
            if (r15 != 0) goto L_0x04c9
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfi r12 = r12.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r13 = r7.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zza((java.lang.String) r13)     // Catch:{ all -> 0x1028 }
            r2.zza(r9, r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = com.google.android.gms.internal.measurement.zzbr.zze.zzk()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((java.lang.String) r4)     // Catch:{ all -> 0x1028 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((long) r12)     // Catch:{ all -> 0x1028 }
            r7.zza((com.google.android.gms.internal.measurement.zzbr.zze.zza) r2)     // Catch:{ all -> 0x1028 }
        L_0x04c9:
            com.google.android.gms.measurement.internal.zzac r31 = r57.zze()     // Catch:{ all -> 0x1028 }
            long r32 = r57.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r34 = r2.zzx()     // Catch:{ all -> 0x1028 }
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 1
            com.google.android.gms.measurement.internal.zzab r2 = r31.zza(r32, r34, r35, r36, r37, r38, r39)     // Catch:{ all -> 0x1028 }
            long r12 = r2.zze     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x1028 }
            int r2 = r2.zzb(r9)     // Catch:{ all -> 0x1028 }
            long r14 = (long) r2     // Catch:{ all -> 0x1028 }
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x0502
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r4)     // Catch:{ all -> 0x1028 }
            goto L_0x0504
        L_0x0502:
            r19 = 1
        L_0x0504:
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = com.google.android.gms.measurement.internal.zzla.zza((java.lang.String) r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x05e1
            if (r5 == 0) goto L_0x05e1
            com.google.android.gms.measurement.internal.zzac r31 = r57.zze()     // Catch:{ all -> 0x1028 }
            long r32 = r57.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r34 = r2.zzx()     // Catch:{ all -> 0x1028 }
            r35 = 0
            r36 = 0
            r37 = 1
            r38 = 0
            r39 = 0
            com.google.android.gms.measurement.internal.zzab r2 = r31.zza(r32, r34, r35, r36, r37, r38, r39)     // Catch:{ all -> 0x1028 }
            long r12 = r2.zzc     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzap.zzm     // Catch:{ all -> 0x1028 }
            int r2 = r2.zzb(r4, r9)     // Catch:{ all -> 0x1028 }
            long r14 = (long) r2     // Catch:{ all -> 0x1028 }
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x05e1
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r9)     // Catch:{ all -> 0x1028 }
            r2.zza(r4, r9)     // Catch:{ all -> 0x1028 }
            r2 = 0
            r4 = -1
            r9 = 0
            r12 = 0
        L_0x0567:
            int r13 = r7.zzb()     // Catch:{ all -> 0x1028 }
            if (r2 >= r13) goto L_0x059b
            com.google.android.gms.internal.measurement.zzbr$zze r13 = r7.zza((int) r2)     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = r13.zzb()     // Catch:{ all -> 0x1028 }
            boolean r14 = r11.equals(r14)     // Catch:{ all -> 0x1028 }
            if (r14 == 0) goto L_0x0589
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = r13.zzbm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = (com.google.android.gms.internal.measurement.zzfd.zzb) r4     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r4     // Catch:{ all -> 0x1028 }
            r9 = r4
            r14 = r30
            r4 = r2
            goto L_0x0596
        L_0x0589:
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x1028 }
            r14 = r30
            boolean r13 = r14.equals(r13)     // Catch:{ all -> 0x1028 }
            if (r13 == 0) goto L_0x0596
            r12 = 1
        L_0x0596:
            int r2 = r2 + 1
            r30 = r14
            goto L_0x0567
        L_0x059b:
            r14 = r30
            if (r12 == 0) goto L_0x05a6
            if (r9 == 0) goto L_0x05a6
            r7.zzb((int) r4)     // Catch:{ all -> 0x1028 }
            goto L_0x05e1
        L_0x05a6:
            if (r9 == 0) goto L_0x05c7
            java.lang.Object r2 = r9.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((java.lang.String) r14)     // Catch:{ all -> 0x1028 }
            r12 = 10
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza((long) r12)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x1028 }
            r7.zza((int) r4, (com.google.android.gms.internal.measurement.zzbr.zze) r2)     // Catch:{ all -> 0x1028 }
            goto L_0x05e1
        L_0x05c7:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r9)     // Catch:{ all -> 0x1028 }
            r2.zza(r4, r9)     // Catch:{ all -> 0x1028 }
        L_0x05e1:
            r13 = r19
        L_0x05e3:
            if (r5 == 0) goto L_0x06b5
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x1028 }
            java.util.List r4 = r7.zza()     // Catch:{ all -> 0x1028 }
            r2.<init>(r4)     // Catch:{ all -> 0x1028 }
            r4 = 0
            r5 = -1
            r9 = -1
        L_0x05f4:
            int r12 = r2.size()     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = "currency"
            java.lang.String r15 = "value"
            if (r4 >= r12) goto L_0x0625
            java.lang.Object r12 = r2.get(r4)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzb()     // Catch:{ all -> 0x1028 }
            boolean r12 = r15.equals(r12)     // Catch:{ all -> 0x1028 }
            if (r12 == 0) goto L_0x0611
            r5 = r4
            goto L_0x0622
        L_0x0611:
            java.lang.Object r12 = r2.get(r4)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzb()     // Catch:{ all -> 0x1028 }
            boolean r12 = r14.equals(r12)     // Catch:{ all -> 0x1028 }
            if (r12 == 0) goto L_0x0622
            r9 = r4
        L_0x0622:
            int r4 = r4 + 1
            goto L_0x05f4
        L_0x0625:
            r4 = -1
            if (r5 == r4) goto L_0x06b3
            java.lang.Object r4 = r2.get(r5)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r4 = (com.google.android.gms.internal.measurement.zzbr.zze) r4     // Catch:{ all -> 0x1028 }
            boolean r4 = r4.zze()     // Catch:{ all -> 0x1028 }
            if (r4 != 0) goto L_0x065f
            java.lang.Object r4 = r2.get(r5)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r4 = (com.google.android.gms.internal.measurement.zzbr.zze) r4     // Catch:{ all -> 0x1028 }
            boolean r4 = r4.zzg()     // Catch:{ all -> 0x1028 }
            if (r4 != 0) goto L_0x065f
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzk()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = "Value must be specified with a numeric type."
            r2.zza(r4)     // Catch:{ all -> 0x1028 }
            r7.zzb((int) r5)     // Catch:{ all -> 0x1028 }
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            r2 = 18
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (int) r2, (java.lang.String) r15)     // Catch:{ all -> 0x1028 }
            r4 = -1
            r12 = 3
            goto L_0x06b7
        L_0x065f:
            r4 = -1
            if (r9 != r4) goto L_0x0666
            r2 = 1
            r12 = 3
            goto L_0x0694
        L_0x0666:
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x1028 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x1028 }
            int r9 = r2.length()     // Catch:{ all -> 0x1028 }
            r12 = 3
            if (r9 == r12) goto L_0x0679
            r2 = 1
            goto L_0x0694
        L_0x0679:
            r9 = 0
        L_0x067a:
            int r15 = r2.length()     // Catch:{ all -> 0x1028 }
            if (r9 >= r15) goto L_0x0693
            int r15 = r2.codePointAt(r9)     // Catch:{ all -> 0x1028 }
            boolean r18 = java.lang.Character.isLetter(r15)     // Catch:{ all -> 0x1028 }
            if (r18 != 0) goto L_0x068d
            r2 = 1
            goto L_0x0694
        L_0x068d:
            int r15 = java.lang.Character.charCount(r15)     // Catch:{ all -> 0x1028 }
            int r9 = r9 + r15
            goto L_0x067a
        L_0x0693:
            r2 = 0
        L_0x0694:
            if (r2 == 0) goto L_0x06b7
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzk()     // Catch:{ all -> 0x1028 }
            java.lang.String r9 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r9)     // Catch:{ all -> 0x1028 }
            r7.zzb((int) r5)     // Catch:{ all -> 0x1028 }
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            r2 = 19
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (int) r2, (java.lang.String) r14)     // Catch:{ all -> 0x1028 }
            goto L_0x06b7
        L_0x06b3:
            r12 = 3
            goto L_0x06b7
        L_0x06b5:
            r4 = -1
            r12 = 3
        L_0x06b7:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r5, r9)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x07f7
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x1028 }
            r5 = r29
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0737
            r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r2 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = (com.google.android.gms.internal.measurement.zzbr.zzc) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r2, (java.lang.String) r8)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x072f
            if (r10 == 0) goto L_0x0723
            long r8 = r10.zzf()     // Catch:{ all -> 0x1028 }
            long r14 = r7.zzf()     // Catch:{ all -> 0x1028 }
            long r8 = r8 - r14
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x1028 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r2 > 0) goto L_0x0720
            java.lang.Object r2 = r10.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2     // Catch:{ all -> 0x1028 }
            boolean r8 = r1.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2)     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x071c
            r9 = r28
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2)     // Catch:{ all -> 0x1028 }
            r8 = r25
            r11 = r27
            r10 = 0
            r26 = 0
            goto L_0x07ff
        L_0x071c:
            r9 = r28
            goto L_0x0727
        L_0x0720:
            r9 = r28
            goto L_0x0725
        L_0x0723:
            r9 = r28
        L_0x0725:
        L_0x0727:
            r26 = r7
            r8 = r16
            r11 = r27
            goto L_0x07ff
        L_0x072f:
            r9 = r28
            r8 = r25
            r11 = r27
            goto L_0x07ff
        L_0x0737:
            r9 = r28
            java.lang.String r2 = "_vs"
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x079a
            r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r2 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = (com.google.android.gms.internal.measurement.zzbr.zzc) r2     // Catch:{ all -> 0x1028 }
            r11 = r27
            com.google.android.gms.internal.measurement.zzbr$zze r2 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r2, (java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x0797
            if (r26 == 0) goto L_0x078f
            long r14 = r26.zzf()     // Catch:{ all -> 0x1028 }
            long r18 = r7.zzf()     // Catch:{ all -> 0x1028 }
            long r14 = r14 - r18
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1028 }
            r18 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r2 > 0) goto L_0x078c
            java.lang.Object r2 = r26.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2     // Catch:{ all -> 0x1028 }
            boolean r8 = r1.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0788
            r8 = r25
            r9.zza((int) r8, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2)     // Catch:{ all -> 0x1028 }
            r10 = 0
            r26 = 0
            goto L_0x07ff
        L_0x0788:
            r8 = r25
            goto L_0x0793
        L_0x078c:
            r8 = r25
            goto L_0x0791
        L_0x078f:
            r8 = r25
        L_0x0791:
        L_0x0793:
            r10 = r7
            r6 = r16
            goto L_0x07ff
        L_0x0797:
            r8 = r25
            goto L_0x07ff
        L_0x079a:
            r8 = r25
            r11 = r27
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r14 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r14 = r14.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcl     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r14, r15)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x07ff
            java.lang.String r2 = "_ab"
            java.lang.String r14 = r7.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.equals(r14)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x07ff
            r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r2 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = (com.google.android.gms.internal.measurement.zzbr.zzc) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r2, (java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x07ff
            if (r26 == 0) goto L_0x07ff
            long r14 = r26.zzf()     // Catch:{ all -> 0x1028 }
            long r18 = r7.zzf()     // Catch:{ all -> 0x1028 }
            long r14 = r14 - r18
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1028 }
            r18 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r2 > 0) goto L_0x07ff
            java.lang.Object r2 = r26.clone()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2     // Catch:{ all -> 0x1028 }
            r1.zzb((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x1028 }
            r9.zza((int) r8, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2)     // Catch:{ all -> 0x1028 }
            r26 = 0
            goto L_0x07ff
        L_0x07f7:
            r8 = r25
            r11 = r27
            r9 = r28
            r5 = r29
        L_0x07ff:
            if (r24 != 0) goto L_0x0863
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x1028 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0863
            int r2 = r7.zzb()     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x082c
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            r2.zza(r5, r11)     // Catch:{ all -> 0x1028 }
            goto L_0x0863
        L_0x082c:
            com.google.android.gms.measurement.internal.zzkw r2 = r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r5 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = (com.google.android.gms.internal.measurement.zzbr.zzc) r5     // Catch:{ all -> 0x1028 }
            java.lang.Object r2 = r2.zzb(r5, r11)     // Catch:{ all -> 0x1028 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x085c
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            r2.zza(r5, r11)     // Catch:{ all -> 0x1028 }
            goto L_0x0863
        L_0x085c:
            long r14 = r2.longValue()     // Catch:{ all -> 0x1028 }
            long r14 = r21 + r14
            goto L_0x0865
        L_0x0863:
            r14 = r21
        L_0x0865:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r2 = r3.zzc     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r5 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = (com.google.android.gms.internal.measurement.zzbr.zzc) r5     // Catch:{ all -> 0x1028 }
            r11 = r23
            r2.set(r11, r5)     // Catch:{ all -> 0x1028 }
            int r16 = r16 + 1
            r9.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x1028 }
        L_0x0879:
            int r11 = r11 + 1
            r12 = r8
            r4 = r9
            r2 = r20
            r5 = r24
            r9 = r26
            goto L_0x02a5
        L_0x0885:
            r11 = r2
            r9 = r4
            r24 = r5
            r5 = r13
            if (r24 == 0) goto L_0x08e0
            r2 = r16
            r14 = r21
            r4 = 0
        L_0x0891:
            if (r4 >= r2) goto L_0x08e2
            com.google.android.gms.internal.measurement.zzbr$zzc r6 = r9.zzb((int) r4)     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = r6.zzc()     // Catch:{ all -> 0x1028 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x08b2
            r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r7 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r6, (java.lang.String) r8)     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x08b2
            r9.zzc((int) r4)     // Catch:{ all -> 0x1028 }
            int r2 = r2 + -1
            int r4 = r4 + -1
            goto L_0x08dd
        L_0x08b2:
            r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r6 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r6, (java.lang.String) r11)     // Catch:{ all -> 0x1028 }
            if (r6 == 0) goto L_0x08dd
            boolean r7 = r6.zze()     // Catch:{ all -> 0x1028 }
            if (r7 == 0) goto L_0x08cb
            long r6 = r6.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x1028 }
            goto L_0x08cc
        L_0x08cb:
            r6 = 0
        L_0x08cc:
            if (r6 == 0) goto L_0x08dd
            long r12 = r6.longValue()     // Catch:{ all -> 0x1028 }
            r21 = 0
            int r7 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r7 <= 0) goto L_0x08dd
            long r6 = r6.longValue()     // Catch:{ all -> 0x1028 }
            long r14 = r14 + r6
        L_0x08dd:
            r6 = 1
            int r4 = r4 + r6
            goto L_0x0891
        L_0x08e0:
            r14 = r21
        L_0x08e2:
            r2 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9, (long) r14, (boolean) r2)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzbo     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = "_se"
            if (r2 == 0) goto L_0x09b1
            java.util.List r2 = r9.zza()     // Catch:{ all -> 0x1028 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x1028 }
        L_0x0904:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x1028 }
            if (r5 == 0) goto L_0x0920
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = (com.google.android.gms.internal.measurement.zzbr.zzc) r5     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = "_s"
            java.lang.String r5 = r5.zzc()     // Catch:{ all -> 0x1028 }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x1028 }
            if (r5 == 0) goto L_0x091f
            r2 = 1
            goto L_0x0921
        L_0x091f:
            goto L_0x0904
        L_0x0920:
            r2 = 0
        L_0x0921:
            if (r2 == 0) goto L_0x092e
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x1028 }
            r2.zzb((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ all -> 0x1028 }
        L_0x092e:
            boolean r2 = com.google.android.gms.internal.measurement.zzmv.zzb()     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x09ac
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzbp     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x09ac
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9, (java.lang.String) r2)     // Catch:{ all -> 0x1028 }
            if (r2 < 0) goto L_0x0951
            r2 = 1
            goto L_0x0952
        L_0x0951:
            r2 = 0
        L_0x0952:
            if (r2 != 0) goto L_0x09ac
            int r2 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9, (java.lang.String) r4)     // Catch:{ all -> 0x1028 }
            if (r2 < 0) goto L_0x09ab
            r9.zze((int) r2)     // Catch:{ all -> 0x1028 }
            boolean r2 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = "Session engagement user property is in the bundle without session ID. appId"
            if (r2 == 0) goto L_0x0993
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0993
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r5)     // Catch:{ all -> 0x1028 }
            r2.zza(r4, r5)     // Catch:{ all -> 0x1028 }
            goto L_0x09d0
        L_0x0993:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r5)     // Catch:{ all -> 0x1028 }
            r2.zza(r4, r5)     // Catch:{ all -> 0x1028 }
        L_0x09ab:
            goto L_0x09d0
        L_0x09ac:
            r2 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9, (long) r14, (boolean) r2)     // Catch:{ all -> 0x1028 }
            goto L_0x09d0
        L_0x09b1:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzbr     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x09d0
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x1028 }
            r2.zzb((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ all -> 0x1028 }
        L_0x09d0:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzbc     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0a77
            com.google.android.gms.measurement.internal.zzkw r2 = r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r4 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r4.zza(r5)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgi r4 = r2.zzj()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x1028 }
            boolean r4 = r4.zze(r5)     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0a77
            com.google.android.gms.measurement.internal.zzac r4 = r2.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzb(r5)     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0a77
            boolean r4 = r4.zzaf()     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0a77
            com.google.android.gms.measurement.internal.zzah r4 = r2.zzl()     // Catch:{ all -> 0x1028 }
            boolean r4 = r4.zzj()     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0a77
            com.google.android.gms.measurement.internal.zzfk r4 = r2.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzw()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r4.zza(r5)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r4 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj()     // Catch:{ all -> 0x1028 }
            r5 = r20
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzah r2 = r2.zzl()     // Catch:{ all -> 0x1028 }
            long r6 = r2.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r2 = r4.zza((long) r6)     // Catch:{ all -> 0x1028 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r2 = r2.zzb((long) r6)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzk r2 = (com.google.android.gms.internal.measurement.zzbr.zzk) r2     // Catch:{ all -> 0x1028 }
            r4 = 0
        L_0x0a53:
            int r6 = r9.zze()     // Catch:{ all -> 0x1028 }
            if (r4 >= r6) goto L_0x0a71
            com.google.android.gms.internal.measurement.zzbr$zzk r6 = r9.zzd((int) r4)     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzc()     // Catch:{ all -> 0x1028 }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x1028 }
            if (r6 == 0) goto L_0x0a6e
            r9.zza((int) r4, (com.google.android.gms.internal.measurement.zzbr.zzk) r2)     // Catch:{ all -> 0x1028 }
            r4 = 1
            goto L_0x0a72
        L_0x0a6e:
            int r4 = r4 + 1
            goto L_0x0a53
        L_0x0a71:
            r4 = 0
        L_0x0a72:
            if (r4 != 0) goto L_0x0a77
            r9.zza((com.google.android.gms.internal.measurement.zzbr.zzk) r2)     // Catch:{ all -> 0x1028 }
        L_0x0a77:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzcg     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0a8e
            zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9)     // Catch:{ all -> 0x1028 }
        L_0x0a8e:
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r2 = r9.zzm()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzn r10 = r57.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = r9.zzj()     // Catch:{ all -> 0x1028 }
            java.util.List r12 = r9.zza()     // Catch:{ all -> 0x1028 }
            java.util.List r13 = r9.zzd()     // Catch:{ all -> 0x1028 }
            long r4 = r9.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.Long r14 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x1028 }
            long r4 = r9.zzg()     // Catch:{ all -> 0x1028 }
            java.lang.Long r15 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x1028 }
            java.util.List r4 = r10.zza(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x1028 }
            r2.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbr.zza>) r4)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zzg(r4)     // Catch:{ all -> 0x1028 }
            if (r2 == 0) goto L_0x0e65
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0e60 }
            r2.<init>()     // Catch:{ all -> 0x0e60 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0e60 }
            r4.<init>()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzla r5 = r5.zzi()     // Catch:{ all -> 0x0e60 }
            java.security.SecureRandom r5 = r5.zzh()     // Catch:{ all -> 0x0e60 }
            r6 = 0
        L_0x0ae4:
            int r7 = r9.zzb()     // Catch:{ all -> 0x0e60 }
            if (r6 >= r7) goto L_0x0e2c
            com.google.android.gms.internal.measurement.zzbr$zzc r7 = r9.zzb((int) r6)     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = r7.zzbm()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = (com.google.android.gms.internal.measurement.zzfd.zzb) r7     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7     // Catch:{ all -> 0x0e60 }
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0e60 }
            java.lang.String r10 = "_ep"
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x0e60 }
            java.lang.String r10 = "_sr"
            if (r8 == 0) goto L_0x0b7b
            com.google.android.gms.measurement.internal.zzkw r8 = r57.zzh()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r11 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r11 = (com.google.android.gms.internal.measurement.zzfd) r11     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r11 = (com.google.android.gms.internal.measurement.zzbr.zzc) r11     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = "_en"
            java.lang.Object r8 = r8.zzb(r11, r12)     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x1028 }
            java.lang.Object r11 = r2.get(r8)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzaj r11 = (com.google.android.gms.measurement.internal.zzaj) r11     // Catch:{ all -> 0x1028 }
            if (r11 != 0) goto L_0x0b33
            com.google.android.gms.measurement.internal.zzac r11 = r57.zze()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza((java.lang.String) r12, (java.lang.String) r8)     // Catch:{ all -> 0x1028 }
            r2.put(r8, r11)     // Catch:{ all -> 0x1028 }
        L_0x0b33:
            java.lang.Long r8 = r11.zzi     // Catch:{ all -> 0x1028 }
            if (r8 != 0) goto L_0x0b72
            java.lang.Long r8 = r11.zzj     // Catch:{ all -> 0x1028 }
            long r12 = r8.longValue()     // Catch:{ all -> 0x1028 }
            r14 = 1
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x0b4c
            com.google.android.gms.measurement.internal.zzkw r8 = r57.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.Long r12 = r11.zzj     // Catch:{ all -> 0x1028 }
            r8.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r12)     // Catch:{ all -> 0x1028 }
        L_0x0b4c:
            java.lang.Boolean r8 = r11.zzk     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0b67
            java.lang.Boolean r8 = r11.zzk     // Catch:{ all -> 0x1028 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0b67
            com.google.android.gms.measurement.internal.zzkw r8 = r57.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.String r10 = "_efs"
            r11 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1028 }
            r8.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r13)     // Catch:{ all -> 0x1028 }
        L_0x0b67:
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x1028 }
            r4.add(r8)     // Catch:{ all -> 0x1028 }
        L_0x0b72:
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x1028 }
            r58 = r5
            r1 = r6
            r5 = r2
            goto L_0x0e23
        L_0x0b7b:
            com.google.android.gms.measurement.internal.zzgi r8 = r57.zzc()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x0e60 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0e60 }
            long r11 = r8.zzf(r11)     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0e60 }
            r8.zzi()     // Catch:{ all -> 0x0e60 }
            long r13 = r7.zzf()     // Catch:{ all -> 0x0e60 }
            long r13 = com.google.android.gms.measurement.internal.zzla.zza((long) r13, (long) r11)     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x0e60 }
            java.lang.String r15 = "_dbg"
            r23 = r11
            r20 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0e60 }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0e60 }
            if (r12 != 0) goto L_0x0c10
            if (r11 != 0) goto L_0x0bb4
            goto L_0x0c10
        L_0x0bb4:
            java.util.List r8 = r8.zza()     // Catch:{ all -> 0x1028 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x1028 }
        L_0x0bbc:
            boolean r12 = r8.hasNext()     // Catch:{ all -> 0x1028 }
            if (r12 == 0) goto L_0x0c0e
            java.lang.Object r12 = r8.next()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x1028 }
            r58 = r8
            java.lang.String r8 = r12.zzb()     // Catch:{ all -> 0x1028 }
            boolean r8 = r15.equals(r8)     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0c0b
            boolean r8 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0be6
            long r15 = r12.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.Long r8 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x1028 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x1028 }
            if (r8 != 0) goto L_0x0c06
        L_0x0be6:
            boolean r8 = r11 instanceof java.lang.String     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0bf4
            java.lang.String r8 = r12.zzd()     // Catch:{ all -> 0x1028 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x1028 }
            if (r8 != 0) goto L_0x0c06
        L_0x0bf4:
            boolean r8 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0c08
            double r15 = r12.zzh()     // Catch:{ all -> 0x1028 }
            java.lang.Double r8 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x1028 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0c08
        L_0x0c06:
            r8 = 1
            goto L_0x0c11
        L_0x0c08:
            r8 = 0
            goto L_0x0c11
        L_0x0c0b:
            r8 = r58
            goto L_0x0bbc
        L_0x0c0e:
            r8 = 0
            goto L_0x0c11
        L_0x0c10:
            r8 = 0
        L_0x0c11:
            if (r8 != 0) goto L_0x0c27
            com.google.android.gms.measurement.internal.zzgi r8 = r57.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r7.zzd()     // Catch:{ all -> 0x1028 }
            int r8 = r8.zzd(r11, r12)     // Catch:{ all -> 0x1028 }
            goto L_0x0c28
        L_0x0c27:
            r8 = 1
        L_0x0c28:
            if (r8 > 0) goto L_0x0c56
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r10 = r10.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r10 = r10.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r7.zzd()     // Catch:{ all -> 0x1028 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x1028 }
            r10.zza(r11, r12, r8)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x1028 }
            r4.add(r8)     // Catch:{ all -> 0x1028 }
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x1028 }
            r58 = r5
            r1 = r6
            r5 = r2
            goto L_0x0e23
        L_0x0c56:
            java.lang.String r11 = r7.zzd()     // Catch:{ all -> 0x0e60 }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzaj r11 = (com.google.android.gms.measurement.internal.zzaj) r11     // Catch:{ all -> 0x0e60 }
            if (r11 != 0) goto L_0x0cf5
            com.google.android.gms.measurement.internal.zzac r11 = r57.zze()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r7.zzd()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza((java.lang.String) r12, (java.lang.String) r15)     // Catch:{ all -> 0x1028 }
            if (r11 != 0) goto L_0x0cf2
            com.google.android.gms.measurement.internal.zzgo r11 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r11 = r11.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbr$zzg r15 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x1028 }
            r20 = r13
            java.lang.String r13 = r7.zzd()     // Catch:{ all -> 0x1028 }
            r11.zza(r12, r15, r13)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgo r11 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r11 = r11.zzb()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzap.zzbn     // Catch:{ all -> 0x1028 }
            boolean r11 = r11.zze(r12, r13)     // Catch:{ all -> 0x1028 }
            if (r11 == 0) goto L_0x0cce
            com.google.android.gms.measurement.internal.zzaj r11 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r26 = r12.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r27 = r7.zzd()     // Catch:{ all -> 0x1028 }
            r28 = 1
            r30 = 1
            r32 = 1
            long r34 = r7.zzf()     // Catch:{ all -> 0x1028 }
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r25 = r11
            r25.<init>(r26, r27, r28, r30, r32, r34, r36, r38, r39, r40, r41)     // Catch:{ all -> 0x1028 }
            goto L_0x0cf7
        L_0x0cce:
            com.google.android.gms.measurement.internal.zzaj r11 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r43 = r12.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.String r44 = r7.zzd()     // Catch:{ all -> 0x1028 }
            r45 = 1
            r47 = 1
            long r49 = r7.zzf()     // Catch:{ all -> 0x1028 }
            r51 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r42 = r11
            r42.<init>(r43, r44, r45, r47, r49, r51, r53, r54, r55, r56)     // Catch:{ all -> 0x1028 }
            goto L_0x0cf7
        L_0x0cf2:
            r20 = r13
            goto L_0x0cf7
        L_0x0cf5:
            r20 = r13
        L_0x0cf7:
            com.google.android.gms.measurement.internal.zzkw r12 = r57.zzh()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzgo r13 = r7.zzu()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzfd r13 = (com.google.android.gms.internal.measurement.zzfd) r13     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzbr$zzc r13 = (com.google.android.gms.internal.measurement.zzbr.zzc) r13     // Catch:{ all -> 0x0e60 }
            java.lang.String r14 = "_eid"
            java.lang.Object r12 = r12.zzb(r13, r14)     // Catch:{ all -> 0x0e60 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0e60 }
            if (r12 == 0) goto L_0x0d10
            r13 = 1
            goto L_0x0d11
        L_0x0d10:
            r13 = 0
        L_0x0d11:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0e60 }
            r14 = 1
            if (r8 != r14) goto L_0x0d4a
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x1028 }
            r4.add(r8)     // Catch:{ all -> 0x1028 }
            boolean r8 = r13.booleanValue()     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0d41
            java.lang.Long r8 = r11.zzi     // Catch:{ all -> 0x1028 }
            if (r8 != 0) goto L_0x0d35
            java.lang.Long r8 = r11.zzj     // Catch:{ all -> 0x1028 }
            if (r8 != 0) goto L_0x0d35
            java.lang.Boolean r8 = r11.zzk     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0d41
        L_0x0d35:
            r8 = 0
            com.google.android.gms.measurement.internal.zzaj r10 = r11.zza(r8, r8, r8)     // Catch:{ all -> 0x1028 }
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x1028 }
            r2.put(r8, r10)     // Catch:{ all -> 0x1028 }
        L_0x0d41:
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x1028 }
            r58 = r5
            r1 = r6
            r5 = r2
            goto L_0x0e23
        L_0x0d4a:
            int r14 = r5.nextInt(r8)     // Catch:{ all -> 0x0e60 }
            if (r14 != 0) goto L_0x0d90
            com.google.android.gms.measurement.internal.zzkw r12 = r57.zzh()     // Catch:{ all -> 0x1028 }
            long r14 = (long) r8     // Catch:{ all -> 0x1028 }
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x1028 }
            r12.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r8)     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x1028 }
            r4.add(r8)     // Catch:{ all -> 0x1028 }
            boolean r8 = r13.booleanValue()     // Catch:{ all -> 0x1028 }
            if (r8 == 0) goto L_0x0d77
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x1028 }
            r10 = 0
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza(r10, r8, r10)     // Catch:{ all -> 0x1028 }
        L_0x0d77:
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x1028 }
            long r12 = r7.zzf()     // Catch:{ all -> 0x1028 }
            r14 = r20
            com.google.android.gms.measurement.internal.zzaj r10 = r11.zza(r12, r14)     // Catch:{ all -> 0x1028 }
            r2.put(r8, r10)     // Catch:{ all -> 0x1028 }
            r58 = r5
            r16 = r6
            r5 = r2
            goto L_0x0e1e
        L_0x0d90:
            r14 = r20
            r58 = r5
            java.lang.Long r5 = r11.zzh     // Catch:{ all -> 0x0e60 }
            if (r5 == 0) goto L_0x0da3
            java.lang.Long r5 = r11.zzh     // Catch:{ all -> 0x1028 }
            long r20 = r5.longValue()     // Catch:{ all -> 0x1028 }
            r18 = r2
            r16 = r6
            goto L_0x0db7
        L_0x0da3:
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x0e60 }
            r5.zzi()     // Catch:{ all -> 0x0e60 }
            r16 = r6
            long r5 = r7.zzg()     // Catch:{ all -> 0x0e60 }
            r18 = r2
            r1 = r23
            long r20 = com.google.android.gms.measurement.internal.zzla.zza((long) r5, (long) r1)     // Catch:{ all -> 0x0e60 }
        L_0x0db7:
            int r1 = (r20 > r14 ? 1 : (r20 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x0e09
            com.google.android.gms.measurement.internal.zzkw r1 = r57.zzh()     // Catch:{ all -> 0x0e60 }
            java.lang.String r2 = "_efs"
            r5 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e60 }
            r1.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r2, (java.lang.Object) r12)     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzkw r1 = r57.zzh()     // Catch:{ all -> 0x0e60 }
            long r5 = (long) r8     // Catch:{ all -> 0x0e60 }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e60 }
            r1.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r2)     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzgo r1 = r7.zzu()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzfd r1 = (com.google.android.gms.internal.measurement.zzfd) r1     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.internal.measurement.zzbr$zzc r1 = (com.google.android.gms.internal.measurement.zzbr.zzc) r1     // Catch:{ all -> 0x0e60 }
            r4.add(r1)     // Catch:{ all -> 0x0e60 }
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0e60 }
            if (r1 == 0) goto L_0x0df6
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e60 }
            r2 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e60 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza(r2, r1, r5)     // Catch:{ all -> 0x0e60 }
        L_0x0df6:
            java.lang.String r1 = r7.zzd()     // Catch:{ all -> 0x0e60 }
            long r5 = r7.zzf()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzaj r2 = r11.zza(r5, r14)     // Catch:{ all -> 0x0e60 }
            r5 = r18
            r5.put(r1, r2)     // Catch:{ all -> 0x0e60 }
            goto L_0x0e1e
        L_0x0e09:
            r5 = r18
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0e60 }
            if (r1 == 0) goto L_0x0e1e
            java.lang.String r1 = r7.zzd()     // Catch:{ all -> 0x0e60 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzaj r6 = r11.zza(r12, r2, r2)     // Catch:{ all -> 0x0e60 }
            r5.put(r1, r6)     // Catch:{ all -> 0x0e60 }
        L_0x0e1e:
            r1 = r16
            r9.zza((int) r1, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0e60 }
        L_0x0e23:
            int r6 = r1 + 1
            r1 = r57
            r2 = r5
            r5 = r58
            goto L_0x0ae4
        L_0x0e2c:
            r5 = r2
            int r1 = r4.size()     // Catch:{ all -> 0x0e60 }
            int r2 = r9.zzb()     // Catch:{ all -> 0x0e60 }
            if (r1 >= r2) goto L_0x0e3e
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r1 = r9.zzc()     // Catch:{ all -> 0x0e60 }
            r1.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbr.zzc>) r4)     // Catch:{ all -> 0x0e60 }
        L_0x0e3e:
            java.util.Set r1 = r5.entrySet()     // Catch:{ all -> 0x0e60 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0e60 }
        L_0x0e46:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0e60 }
            if (r2 == 0) goto L_0x0e65
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0e60 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x0e60 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0e60 }
            com.google.android.gms.measurement.internal.zzaj r2 = (com.google.android.gms.measurement.internal.zzaj) r2     // Catch:{ all -> 0x0e60 }
            r4.zza((com.google.android.gms.measurement.internal.zzaj) r2)     // Catch:{ all -> 0x0e60 }
            goto L_0x0e46
        L_0x0e60:
            r0 = move-exception
            r1 = r57
            goto L_0x1029
        L_0x0e65:
            r1 = r57
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzcg     // Catch:{ all -> 0x1028 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x1028 }
            if (r2 != 0) goto L_0x0e7e
            zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9)     // Catch:{ all -> 0x1028 }
        L_0x0e7e:
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzb(r2)     // Catch:{ all -> 0x1028 }
            if (r4 != 0) goto L_0x0ea9
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r6)     // Catch:{ all -> 0x1028 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x1028 }
            goto L_0x0f04
        L_0x0ea9:
            int r5 = r9.zzb()     // Catch:{ all -> 0x1028 }
            if (r5 <= 0) goto L_0x0f04
            long r5 = r4.zzk()     // Catch:{ all -> 0x1028 }
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x0ebd
            r9.zze((long) r5)     // Catch:{ all -> 0x1028 }
            goto L_0x0ec0
        L_0x0ebd:
            r9.zzi()     // Catch:{ all -> 0x1028 }
        L_0x0ec0:
            long r7 = r4.zzj()     // Catch:{ all -> 0x1028 }
            r10 = 0
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0ecb
            goto L_0x0ecc
        L_0x0ecb:
            r5 = r7
        L_0x0ecc:
            int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x0ed4
            r9.zzd((long) r5)     // Catch:{ all -> 0x1028 }
            goto L_0x0ed7
        L_0x0ed4:
            r9.zzh()     // Catch:{ all -> 0x1028 }
        L_0x0ed7:
            r4.zzv()     // Catch:{ all -> 0x1028 }
            long r5 = r4.zzs()     // Catch:{ all -> 0x1028 }
            int r6 = (int) r5     // Catch:{ all -> 0x1028 }
            r9.zzg((int) r6)     // Catch:{ all -> 0x1028 }
            long r5 = r9.zzf()     // Catch:{ all -> 0x1028 }
            r4.zza((long) r5)     // Catch:{ all -> 0x1028 }
            long r5 = r9.zzg()     // Catch:{ all -> 0x1028 }
            r4.zzb((long) r5)     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r4.zzad()     // Catch:{ all -> 0x1028 }
            if (r5 == 0) goto L_0x0efa
            r9.zzj((java.lang.String) r5)     // Catch:{ all -> 0x1028 }
            goto L_0x0efd
        L_0x0efa:
            r9.zzk()     // Catch:{ all -> 0x1028 }
        L_0x0efd:
            com.google.android.gms.measurement.internal.zzac r5 = r57.zze()     // Catch:{ all -> 0x1028 }
            r5.zza((com.google.android.gms.measurement.internal.zzg) r4)     // Catch:{ all -> 0x1028 }
        L_0x0f04:
            int r4 = r9.zzb()     // Catch:{ all -> 0x1028 }
            if (r4 <= 0) goto L_0x0f6f
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x1028 }
            r4.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzgi r4 = r57.zzc()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbo$zzb r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0f32
            boolean r5 = r4.zza()     // Catch:{ all -> 0x1028 }
            if (r5 != 0) goto L_0x0f2a
            goto L_0x0f32
        L_0x0f2a:
            long r4 = r4.zzb()     // Catch:{ all -> 0x1028 }
            r9.zzi((long) r4)     // Catch:{ all -> 0x1028 }
            goto L_0x0f5e
        L_0x0f32:
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r4 = r4.zzam()     // Catch:{ all -> 0x1028 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x1028 }
            if (r4 == 0) goto L_0x0f44
            r4 = -1
            r9.zzi((long) r4)     // Catch:{ all -> 0x1028 }
            goto L_0x0f5e
        L_0x0f44:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r3.zza     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1028 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r6)     // Catch:{ all -> 0x1028 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x1028 }
        L_0x0f5e:
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzgo r5 = r9.zzu()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5     // Catch:{ all -> 0x1028 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = (com.google.android.gms.internal.measurement.zzbr.zzg) r5     // Catch:{ all -> 0x1028 }
            r12 = r19
            r4.zza((com.google.android.gms.internal.measurement.zzbr.zzg) r5, (boolean) r12)     // Catch:{ all -> 0x1028 }
        L_0x0f6f:
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x1028 }
            java.util.List<java.lang.Long> r3 = r3.zzb     // Catch:{ all -> 0x1028 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x1028 }
            r4.zzd()     // Catch:{ all -> 0x1028 }
            r4.zzak()     // Catch:{ all -> 0x1028 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x1028 }
            r6 = 0
        L_0x0f86:
            int r7 = r3.size()     // Catch:{ all -> 0x1028 }
            if (r6 >= r7) goto L_0x0fa3
            if (r6 == 0) goto L_0x0f93
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x1028 }
        L_0x0f93:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x1028 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x1028 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x1028 }
            r5.append(r7)     // Catch:{ all -> 0x1028 }
            int r6 = r6 + 1
            goto L_0x0f86
        L_0x0fa3:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x1028 }
            android.database.sqlite.SQLiteDatabase r6 = r4.mo13672c_()     // Catch:{ all -> 0x1028 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x1028 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x1028 }
            int r6 = r3.size()     // Catch:{ all -> 0x1028 }
            if (r5 == r6) goto L_0x0fd6
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x1028 }
            int r3 = r3.size()     // Catch:{ all -> 0x1028 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x1028 }
            r4.zza(r6, r5, r3)     // Catch:{ all -> 0x1028 }
        L_0x0fd6:
            com.google.android.gms.measurement.internal.zzac r3 = r57.zze()     // Catch:{ all -> 0x1028 }
            android.database.sqlite.SQLiteDatabase r4 = r3.mo13672c_()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0fed }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0fed }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0fed }
            r4.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0fed }
            goto L_0x1000
        L_0x0fed:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzf()     // Catch:{ all -> 0x1028 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r2)     // Catch:{ all -> 0x1028 }
            r3.zza(r5, r2, r4)     // Catch:{ all -> 0x1028 }
        L_0x1000:
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x1028 }
            r2.mo13671b_()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()
            r2.zzh()
            r2 = 1
            return r2
        L_0x1010:
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x1028 }
            r2.mo13671b_()     // Catch:{ all -> 0x1028 }
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()
            r2.zzh()
            r2 = 0
            return r2
        L_0x1020:
            r0 = move-exception
            r2 = r0
        L_0x1022:
            if (r4 == 0) goto L_0x1027
            r4.close()     // Catch:{ all -> 0x1028 }
        L_0x1027:
            throw r2     // Catch:{ all -> 0x1028 }
        L_0x1028:
            r0 = move-exception
        L_0x1029:
            r2 = r0
            com.google.android.gms.measurement.internal.zzac r3 = r57.zze()
            r3.zzh()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(java.lang.String, long):boolean");
    }

    private static void zza(zzbr.zzg.zza zza2) {
        zza2.zzb((long) LongCompanionObject.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzbr.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    private final void zza(zzbr.zzg.zza zza2, long j, boolean z) {
        String str;
        zzlb zzlb;
        String str2;
        if (z) {
            str = "_se";
        } else {
            str = "_lte";
        }
        zzlb zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzlb = new zzlb(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzlb = new zzlb(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzbr.zzk zzk2 = (zzbr.zzk) ((zzfd) zzbr.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzlb.zze).longValue()).zzu());
        boolean z2 = false;
        int zza3 = zzkw.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzlb);
            if (z) {
                str2 = "session-scoped";
            } else {
                str2 = "lifetime";
            }
            if (!zzky.zzb() || !this.zzj.zzb().zze(zza2.zzj(), zzap.zzcz)) {
                this.zzj.zzr().zzw().zza("Updated engagement user property. scope, value", str2, zzlb.zze);
            } else {
                this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", str2, zzlb.zze);
            }
        }
    }

    private final boolean zza(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbr.zze zza4 = zzkw.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_sc");
        String str = null;
        String zzd2 = zza4 == null ? null : zza4.zzd();
        zzh();
        zzbr.zze zza5 = zzkw.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_pc");
        if (zza5 != null) {
            str = zza5.zzd();
        }
        if (str == null || !str.equals(zzd2)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    private final void zzb(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbr.zze zza4 = zzkw.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzbr.zze zza5 = zzkw.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", (Object) Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    private static void zza(zzbr.zzc.zza zza2, String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzbr.zzc.zza zza2, int i, String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzbr.zze) ((zzfd) zzbr.zze.zzk().zza("_err").zza(Long.valueOf((long) i).longValue()).zzu())).zza((zzbr.zze) ((zzfd) zzbr.zze.zzk().zza("_ev").zzb(str).zzu()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzac zze2;
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            if (zze2.mo13672c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzw == null || !this.zzw.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().mo13671b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().mo13673d_());
    }

    private final void zza(zzg zzg2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzll.zzb() || !this.zzj.zzb().zze(zzg2.zzc(), zzap.zzch)) {
            if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzf())) {
                zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzg()) && TextUtils.isEmpty(zzg2.zzf())) {
            zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzg2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzg2.zzc());
            zzbo.zzb zza3 = zzc().zza(zzg2.zzc());
            String zzb2 = zzc().zzb(zzg2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfo zzd2 = zzd();
            String zzc2 = zzg2.zzc();
            zzkt zzkt = new zzkt(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkt);
            zzd2.zzq().zzb((Runnable) new zzfs(zzd2, zzc2, url, (byte[]) null, arrayMap, zzkt));
        } catch (MalformedURLException e) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzfk.zza(zzg2.zzc()), zza2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0152 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017b A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x017f A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzw()
            r6.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x01a1 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzgo r1 = r6.zzj     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x01a1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01a1 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzac r1 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r1.zzf()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzac r1 = r6.zze()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzb(r7)     // Catch:{ all -> 0x0198 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003f
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003f
            if (r8 != r3) goto L_0x0043
        L_0x003f:
            if (r9 != 0) goto L_0x0043
            r2 = 1
            goto L_0x0044
        L_0x0043:
            r2 = 0
        L_0x0044:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzi()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r7)     // Catch:{ all -> 0x0198 }
            r8.zza(r9, r7)     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00d0
            if (r8 != r5) goto L_0x0063
            goto L_0x00d0
        L_0x0063:
            com.google.android.gms.measurement.internal.zzgo r10 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r10 = r10.zzm()     // Catch:{ all -> 0x0198 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r1.zzi((long) r10)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzac r10 = r6.zze()     // Catch:{ all -> 0x0198 }
            r10.zza((com.google.android.gms.measurement.internal.zzg) r1)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzgo r10 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfk r10 = r10.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfm r10 = r10.zzx()     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0198 }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzgi r9 = r6.zzc()     // Catch:{ all -> 0x0198 }
            r9.zzc(r7)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzc()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzd     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzgo r9 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x0198 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r7.zza(r9)     // Catch:{ all -> 0x0198 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00b3
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            if (r4 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzc()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zze     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r8 = r8.zzm()     // Catch:{ all -> 0x0198 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r7.zza(r8)     // Catch:{ all -> 0x0198 }
        L_0x00cb:
            r6.zzz()     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x00d0:
            r9 = 0
            if (r11 == 0) goto L_0x00dc
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x0198 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0198 }
            goto L_0x00dd
        L_0x00dc:
            r11 = r9
        L_0x00dd:
            if (r11 == 0) goto L_0x00ec
            int r2 = r11.size()     // Catch:{ all -> 0x0198 }
            if (r2 <= 0) goto L_0x00ec
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0198 }
            goto L_0x00ed
        L_0x00ec:
            r11 = r9
        L_0x00ed:
            if (r8 == r5) goto L_0x0109
            if (r8 != r3) goto L_0x00f2
            goto L_0x0109
        L_0x00f2:
            com.google.android.gms.measurement.internal.zzgi r9 = r6.zzc()     // Catch:{ all -> 0x0198 }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x0198 }
            if (r9 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r7.zzh()     // Catch:{ all -> 0x01a1 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0109:
            com.google.android.gms.measurement.internal.zzgi r11 = r6.zzc()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.internal.measurement.zzbo$zzb r11 = r11.zza((java.lang.String) r7)     // Catch:{ all -> 0x0198 }
            if (r11 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzgi r11 = r6.zzc()     // Catch:{ all -> 0x0198 }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x0198 }
            if (r9 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r7.zzh()     // Catch:{ all -> 0x01a1 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x012a:
            com.google.android.gms.measurement.internal.zzgo r9 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x0198 }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r1.zzh((long) r2)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzac r9 = r6.zze()     // Catch:{ all -> 0x0198 }
            r9.zza((com.google.android.gms.measurement.internal.zzg) r1)     // Catch:{ all -> 0x0198 }
            if (r8 != r5) goto L_0x0152
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzk()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x0198 }
            goto L_0x016b
        L_0x0152:
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzx()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0198 }
            int r10 = r10.length     // Catch:{ all -> 0x0198 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0198 }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x0198 }
        L_0x016b:
            com.google.android.gms.measurement.internal.zzfo r7 = r6.zzd()     // Catch:{ all -> 0x0198 }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x017f
            boolean r7 = r6.zzy()     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x017f
            r6.zzl()     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x017f:
            r6.zzz()     // Catch:{ all -> 0x0198 }
        L_0x0183:
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0198 }
            r7.mo13671b_()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r7.zzh()     // Catch:{ all -> 0x01a1 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0198:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzac r8 = r6.zze()     // Catch:{ all -> 0x01a1 }
            r8.zzh()     // Catch:{ all -> 0x01a1 }
            throw r7     // Catch:{ all -> 0x01a1 }
        L_0x01a1:
            r7 = move-exception
            r6.zzq = r0
            r6.zzaa()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    private final void zzz() {
        long j;
        long j2;
        zzw();
        zzk();
        if (this.zzm > 0) {
            long abs = 3600000 - Math.abs(this.zzj.zzm().elapsedRealtime() - this.zzm);
            if (abs > 0) {
                this.zzj.zzr().zzx().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzt().zzb();
                zzv().zzf();
                return;
            }
            this.zzm = 0;
        }
        if (!this.zzj.zzah() || !zzy()) {
            this.zzj.zzr().zzx().zza("Nothing to upload or uploading impossible");
            zzt().zzb();
            zzv().zzf();
            return;
        }
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        long max = Math.max(0, zzap.zzz.zza(null).longValue());
        boolean z = zze().zzz() || zze().zzk();
        if (z) {
            String zzv2 = this.zzj.zzb().zzv();
            if (TextUtils.isEmpty(zzv2) || ".none.".equals(zzv2)) {
                j = Math.max(0, zzap.zzt.zza(null).longValue());
            } else {
                j = Math.max(0, zzap.zzu.zza(null).longValue());
            }
        } else {
            j = Math.max(0, zzap.zzs.zza(null).longValue());
        }
        long zza2 = this.zzj.zzc().zzc.zza();
        long zza3 = this.zzj.zzc().zzd.zza();
        long j3 = j;
        long j4 = max;
        long max2 = Math.max(zze().zzw(), zze().zzx());
        if (max2 == 0) {
            j2 = 0;
        } else {
            long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza3 - currentTimeMillis);
            long max3 = Math.max(abs3, abs4);
            j2 = abs2 + j4;
            if (z && max3 > 0) {
                j2 = Math.min(abs2, max3) + j3;
            }
            long j5 = j3;
            if (!zzh().zza(max3, j5)) {
                j2 = max3 + j5;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i = 0;
                while (true) {
                    if (i >= Math.min(20, Math.max(0, zzap.zzab.zza(null).intValue()))) {
                        j2 = 0;
                        break;
                    }
                    j2 += Math.max(0, zzap.zzaa.zza(null).longValue()) * (1 << i);
                    if (j2 > abs4) {
                        break;
                    }
                    i++;
                }
            }
        }
        if (j2 == 0) {
            this.zzj.zzr().zzx().zza("Next upload time is 0");
            zzt().zzb();
            zzv().zzf();
        } else if (!zzd().zzf()) {
            this.zzj.zzr().zzx().zza("No network");
            zzt().zza();
            zzv().zzf();
        } else {
            long zza4 = this.zzj.zzc().zze.zza();
            long max4 = Math.max(0, zzap.zzq.zza(null).longValue());
            if (!zzh().zza(zza4, max4)) {
                j2 = Math.max(j2, zza4 + max4);
            }
            zzt().zzb();
            long currentTimeMillis2 = j2 - this.zzj.zzm().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                currentTimeMillis2 = Math.max(0, zzap.zzv.zza(null).longValue());
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
            }
            this.zzj.zzr().zzx().zza("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            zzv().zza(currentTimeMillis2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzn.clear();
        }
    }

    private final Boolean zzb(zzg zzg2) {
        try {
            if (zzg2.zzm() != -2147483648L) {
                if (zzg2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionName;
                if (zzg2.zzl() != null && zzg2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 >= zzaf) {
                } else {
                    if (zza(zzaf, this.zzu)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
    }

    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzap.zzcf) || (fileLock = this.zzt) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = channel;
                FileLock tryLock = channel.tryLock();
                this.zzt = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.zzj.zzb().zza(zzap.zzcu) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzm zzm2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzac zze2 = zze();
        String str = zzm2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.mo13672c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzfk.zza(str), e);
        }
        if (!zzkn.zzb() || !this.zzj.zzb().zza(zzap.zzcm)) {
            zzm zza2 = zza(this.zzj.zzn(), zzm2.zza, zzm2.zzb, zzm2.zzh, zzm2.zzo, zzm2.zzp, zzm2.zzm, zzm2.zzr, zzm2.zzv);
            if (zzm2.zzh) {
                zzb(zza2);
            }
        } else if (zzm2.zzh) {
            zzb(zzm2);
        }
    }

    private final zzm zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        int i;
        String str8 = str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzr().zzf().zza("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str5 = packageManager.getInstallerPackageName(str8);
        } catch (IllegalArgumentException e) {
            this.zzj.zzr().zzf().zza("Error retrieving installer package name. appId", zzfk.zza(str));
            str5 = "Unknown";
        }
        if (str5 == null) {
            str6 = "manual_install";
        } else if ("com.android.vending".equals(str5)) {
            str6 = "";
        } else {
            str6 = str5;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str8, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str8);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                str7 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                i = Integer.MIN_VALUE;
                str7 = "Unknown";
            }
            return new zzm(str, str2, str7, (long) i, str6, this.zzj.zzb().zze(), this.zzj.zzi().zza(context, str8), (String) null, z, false, "", 0, j, 0, z2, z3, false, str3, (Boolean) null, 0, (List<String>) null, (!zzll.zzb() || !this.zzj.zzb().zze(str8, zzap.zzch)) ? null : str4);
        } catch (PackageManager.NameNotFoundException e2) {
            this.zzj.zzr().zzf().zza("Error retrieving newly installed package info. appId, appName", zzfk.zza(str), "Unknown");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkz zzkz, zzm zzm2) {
        zzaj zza2;
        int i;
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkz.zza);
            if (zzc2 != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzm2.zza, zzc2, "_ev", zzla.zza(zzkz.zza, 24, true), zzkz.zza != null ? zzkz.zza.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkz.zza, zzkz.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza3 = zzla.zza(zzkz.zza, 24, true);
                Object zza4 = zzkz.zza();
                if (zza4 == null || (!(zza4 instanceof String) && !(zza4 instanceof CharSequence))) {
                    i = 0;
                } else {
                    i = String.valueOf(zza4).length();
                }
                this.zzj.zzi().zza(zzm2.zza, zzb2, "_ev", zza3, i);
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkz.zza, zzkz.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkz.zza) && this.zzj.zzb().zze(zzm2.zza, zzap.zzas)) {
                    long j = zzkz.zzb;
                    String str = zzkz.zze;
                    long j2 = 0;
                    zzlb zzc4 = zze().zzc(zzm2.zza, "_sno");
                    if (zzc4 == null || !(zzc4.zze instanceof Long)) {
                        if (zzc4 != null) {
                            this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                        }
                        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzav) && (zza2 = zze().zza(zzm2.zza, "_s")) != null) {
                            j2 = zza2.zzc;
                            this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc4.zze).longValue();
                    }
                    zza(new zzkz("_sno", j, Long.valueOf(j2 + 1), str), zzm2);
                }
                zzlb zzlb = new zzlb(zzm2.zza, zzkz.zze, zzkz.zza, zzkz.zzb, zzc3);
                if (!zzky.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcz)) {
                    this.zzj.zzr().zzw().zza("Setting user property", this.zzj.zzj().zzc(zzlb.zzc), zzc3);
                } else {
                    this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzlb.zzc), zzc3);
                }
                zze().zzf();
                try {
                    zzc(zzm2);
                    boolean zza5 = zze().zza(zzlb);
                    zze().mo13671b_();
                    if (!zza5) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                        this.zzj.zzi().zza(zzm2.zza, 9, (String) null, (String) null, 0);
                    } else if (!zzky.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcz)) {
                        this.zzj.zzr().zzw().zza("User property set", this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkz zzkz, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
            } else if (!this.zzj.zzb().zze(zzm2.zza, zzap.zzbc)) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkz.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkz.zza);
                    zze().mo13671b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkz.zza));
                } finally {
                    zze().zzh();
                }
            } else if (!"_npa".equals(zzkz.zza) || zzm2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkz.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkz.zza);
                    zze().mo13671b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkz.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkz("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzm2.zzs.booleanValue() ? 1 : 0), "auto"), zzm2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkp zzkp) {
        this.zzo++;
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final zzgo zzs() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022d A[Catch:{ SQLiteException -> 0x01e2, all -> 0x0503 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022f A[Catch:{ SQLiteException -> 0x01e2, all -> 0x0503 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0233 A[Catch:{ SQLiteException -> 0x01e2, all -> 0x0503 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzw()
            r21.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zze(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.zzac r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.zzh((long) r8)
            com.google.android.gms.measurement.internal.zzac r10 = r21.zze()
            r10.zza((com.google.android.gms.measurement.internal.zzg) r7)
            com.google.android.gms.measurement.internal.zzgi r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.zzd(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.zzc(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.common.util.Clock r7 = r7.zzm()
            long r10 = r7.currentTimeMillis()
        L_0x006f:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()
            java.lang.String r12 = r2.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzap.zzbc
            boolean r7 = r7.zze(r12, r13)
            if (r7 == 0) goto L_0x008a
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzah r7 = r7.zzx()
            r7.zzi()
        L_0x008a:
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x00ac
            if (r7 == r15) goto L_0x00ac
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzi()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x00ac:
            com.google.android.gms.measurement.internal.zzac r12 = r21.zze()
            r12.zzf()
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzx r12 = r12.zzb()     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzap.zzbc     // Catch:{ all -> 0x0503 }
            boolean r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x0503 }
            if (r12 == 0) goto L_0x0135
            com.google.android.gms.measurement.internal.zzac r12 = r21.zze()     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0503 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzlb r14 = r12.zzc((java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x0503 }
            if (r14 == 0) goto L_0x00e2
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.zzb     // Catch:{ all -> 0x0503 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0503 }
            if (r12 == 0) goto L_0x00de
            goto L_0x00e2
        L_0x00de:
            r18 = r3
            r3 = 1
            goto L_0x0138
        L_0x00e2:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x0503 }
            if (r12 == 0) goto L_0x011d
            com.google.android.gms.measurement.internal.zzkz r13 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x0503 }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x0503 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0503 }
            if (r12 == 0) goto L_0x00f5
            r19 = 1
            goto L_0x00f7
        L_0x00f5:
            r19 = r8
        L_0x00f7:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0503 }
            java.lang.String r20 = "auto"
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = 1
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x0503 }
            if (r9 == 0) goto L_0x0119
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0503 }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x0503 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x0503 }
            if (r9 != 0) goto L_0x0134
        L_0x0119:
            r1.zza((com.google.android.gms.measurement.internal.zzkz) r8, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x0134
        L_0x011d:
            r18 = r3
            r9 = r14
            r3 = 1
            if (r9 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzkz r8 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x0503 }
            r1.zzb((com.google.android.gms.measurement.internal.zzkz) r8, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x0138
        L_0x0134:
            goto L_0x0138
        L_0x0135:
            r18 = r3
            r3 = 1
        L_0x0138:
            com.google.android.gms.measurement.internal.zzac r8 = r21.zze()     // Catch:{ all -> 0x0503 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzb(r9)     // Catch:{ all -> 0x0503 }
            if (r8 == 0) goto L_0x01f5
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x0503 }
            r12.zzi()     // Catch:{ all -> 0x0503 }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = r8.zze()     // Catch:{ all -> 0x0503 }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x0503 }
            java.lang.String r15 = r8.zzf()     // Catch:{ all -> 0x0503 }
            boolean r12 = com.google.android.gms.measurement.internal.zzla.zza((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x0503 }
            if (r12 == 0) goto L_0x01f5
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzi()     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.zzc()     // Catch:{ all -> 0x0503 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r14)     // Catch:{ all -> 0x0503 }
            r12.zza(r13, r14)     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzac r12 = r21.zze()     // Catch:{ all -> 0x0503 }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x0503 }
            r12.zzak()     // Catch:{ all -> 0x0503 }
            r12.zzd()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0503 }
            android.database.sqlite.SQLiteDatabase r13 = r12.mo13672c_()     // Catch:{ SQLiteException -> 0x01e2 }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01e2 }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01e2 }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01e2 }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01e1
            com.google.android.gms.measurement.internal.zzfk r0 = r12.zzr()     // Catch:{ SQLiteException -> 0x01e2 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()     // Catch:{ SQLiteException -> 0x01e2 }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01e2 }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01e2 }
        L_0x01e1:
            goto L_0x01f4
        L_0x01e2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfk r9 = r12.zzr()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzf()     // Catch:{ all -> 0x0503 }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r8)     // Catch:{ all -> 0x0503 }
            r9.zza(r12, r8, r0)     // Catch:{ all -> 0x0503 }
        L_0x01f4:
            r8 = 0
        L_0x01f5:
            if (r8 == 0) goto L_0x0256
            long r12 = r8.zzm()     // Catch:{ all -> 0x0503 }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0210
            long r12 = r8.zzm()     // Catch:{ all -> 0x0503 }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x0503 }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0211
            r0 = 1
            goto L_0x0212
        L_0x0210:
            r9 = r4
        L_0x0211:
            r0 = 0
        L_0x0212:
            long r3 = r8.zzm()     // Catch:{ all -> 0x0503 }
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x022f
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x0503 }
            if (r3 == 0) goto L_0x022f
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x0503 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0503 }
            if (r3 != 0) goto L_0x022f
            r14 = 1
            goto L_0x0230
        L_0x022f:
            r14 = 0
        L_0x0230:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0257
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0503 }
            r0.<init>()     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzl()     // Catch:{ all -> 0x0503 }
            r0.putString(r3, r4)     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0503 }
            r14.<init>(r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzan) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x0257
        L_0x0256:
            r9 = r4
        L_0x0257:
            r21.zzc(r22)     // Catch:{ all -> 0x0503 }
            if (r7 != 0) goto L_0x026b
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzaj r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0503 }
            goto L_0x027d
        L_0x026b:
            r3 = 1
            if (r7 != r3) goto L_0x027c
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzaj r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0503 }
            goto L_0x027d
        L_0x027c:
            r0 = 0
        L_0x027d:
            if (r0 != 0) goto L_0x04d4
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x042c
            com.google.android.gms.measurement.internal.zzkz r7 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x0503 }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0503 }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzkz) r7, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0503 }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzap.zzaq     // Catch:{ all -> 0x0503 }
            boolean r7 = r7.zze(r12, r13)     // Catch:{ all -> 0x0503 }
            if (r7 == 0) goto L_0x02c6
            r21.zzw()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfz r7 = r7.zzf()     // Catch:{ all -> 0x0503 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0503 }
            r7.zza(r12)     // Catch:{ all -> 0x0503 }
        L_0x02c6:
            r21.zzw()     // Catch:{ all -> 0x0503 }
            r21.zzk()     // Catch:{ all -> 0x0503 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x0503 }
            r7.<init>()     // Catch:{ all -> 0x0503 }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x0503 }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x0503 }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x0503 }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x0503 }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x0503 }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzb()     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x0503 }
            boolean r3 = r3.zze(r4, r12)     // Catch:{ all -> 0x0503 }
            if (r3 == 0) goto L_0x0300
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x0503 }
        L_0x0300:
            boolean r3 = r2.zzq     // Catch:{ all -> 0x0503 }
            if (r3 == 0) goto L_0x0309
            r3 = 1
            r7.putLong(r0, r3)     // Catch:{ all -> 0x0503 }
        L_0x0309:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0503 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0503 }
            r0.zzd()     // Catch:{ all -> 0x0503 }
            r0.zzak()     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzh(r3, r4)     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x0503 }
            android.content.Context r0 = r0.zzn()     // Catch:{ all -> 0x0503 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0503 }
            if (r0 != 0) goto L_0x0344
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0503 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r9)     // Catch:{ all -> 0x0503 }
            r0.zza(r6, r9)     // Catch:{ all -> 0x0503 }
            goto L_0x040e
        L_0x0344:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0358 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x0358 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0358 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0358 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0358 }
            goto L_0x0370
        L_0x0358:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzf()     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x0503 }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r15)     // Catch:{ all -> 0x0503 }
            r12.zza(r13, r15, r0)     // Catch:{ all -> 0x0503 }
            r0 = 0
        L_0x0370:
            if (r0 == 0) goto L_0x03c9
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x0503 }
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x03c7
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x0503 }
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x0503 }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x03aa
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzb()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzap.zzcn     // Catch:{ all -> 0x0503 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r12)     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x03a3
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x03a0
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x0503 }
            goto L_0x03a8
        L_0x03a0:
            r12 = 1
            goto L_0x03a8
        L_0x03a3:
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x0503 }
        L_0x03a8:
            r14 = 0
            goto L_0x03ab
        L_0x03aa:
            r14 = 1
        L_0x03ab:
            com.google.android.gms.measurement.internal.zzkz r0 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x03b4
            r14 = 1
            goto L_0x03b6
        L_0x03b4:
            r14 = 0
        L_0x03b6:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0503 }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzkz) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x03ca
        L_0x03c7:
            r6 = r14
            goto L_0x03ca
        L_0x03c9:
            r6 = r14
        L_0x03ca:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x03de }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x03de }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03de }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x03de }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x03de }
            goto L_0x03f6
        L_0x03de:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzf()     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x0503 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r14)     // Catch:{ all -> 0x0503 }
            r12.zza(r13, r14, r0)     // Catch:{ all -> 0x0503 }
            r0 = 0
        L_0x03f6:
            if (r0 == 0) goto L_0x040e
            int r12 = r0.flags     // Catch:{ all -> 0x0503 }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x0403
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x0503 }
        L_0x0403:
            int r0 = r0.flags     // Catch:{ all -> 0x0503 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x040e
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x0503 }
        L_0x040e:
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x0417
            r7.putLong(r5, r3)     // Catch:{ all -> 0x0503 }
        L_0x0417:
            com.google.android.gms.measurement.internal.zzan r0 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0503 }
            r14.<init>(r7)     // Catch:{ all -> 0x0503 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzan) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x048a
        L_0x042c:
            r5 = 1
            if (r7 != r5) goto L_0x048a
            com.google.android.gms.measurement.internal.zzkz r5 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0503 }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzkz) r5, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            r21.zzw()     // Catch:{ all -> 0x0503 }
            r21.zzk()     // Catch:{ all -> 0x0503 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x0503 }
            r5.<init>()     // Catch:{ all -> 0x0503 }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x0503 }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzb()     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x0503 }
            boolean r3 = r3.zze(r4, r6)     // Catch:{ all -> 0x0503 }
            if (r3 == 0) goto L_0x046c
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x0503 }
        L_0x046c:
            boolean r3 = r2.zzq     // Catch:{ all -> 0x0503 }
            if (r3 == 0) goto L_0x0475
            r3 = 1
            r5.putLong(r0, r3)     // Catch:{ all -> 0x0503 }
        L_0x0475:
            com.google.android.gms.measurement.internal.zzan r0 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0503 }
            r14.<init>(r5)     // Catch:{ all -> 0x0503 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzan) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x048b
        L_0x048a:
        L_0x048b:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzb()     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzbb     // Catch:{ all -> 0x0503 }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x0503 }
            if (r0 != 0) goto L_0x04f3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0503 }
            r0.<init>()     // Catch:{ all -> 0x0503 }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzb()     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x0503 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0503 }
            if (r3 == 0) goto L_0x04bf
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x0503 }
        L_0x04bf:
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0503 }
            r14.<init>(r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzan) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x04f3
        L_0x04d4:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x04f3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0503 }
            r0.<init>()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0503 }
            r14.<init>(r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x0503 }
            r1.zza((com.google.android.gms.measurement.internal.zzan) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x0503 }
            goto L_0x04f4
        L_0x04f3:
        L_0x04f4:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x0503 }
            r0.mo13671b_()     // Catch:{ all -> 0x0503 }
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()
            r0.zzh()
            return
        L_0x0503:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzac r2 = r21.zze()
            r2.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzb(com.google.android.gms.measurement.internal.zzm):void");
    }

    private final zzm zza(String str) {
        String str2;
        String str3 = str;
        zzg zzb2 = zze().zzb(str3);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str3);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            String zze2 = zzb2.zze();
            String zzl2 = zzb2.zzl();
            long zzm2 = zzb2.zzm();
            String zzn2 = zzb2.zzn();
            long zzo2 = zzb2.zzo();
            long zzp2 = zzb2.zzp();
            boolean zzr2 = zzb2.zzr();
            String zzi2 = zzb2.zzi();
            long zzae = zzb2.zzae();
            boolean zzaf = zzb2.zzaf();
            boolean zzag = zzb2.zzag();
            String zzf2 = zzb2.zzf();
            Boolean zzah = zzb2.zzah();
            long zzq2 = zzb2.zzq();
            List<String> zzai = zzb2.zzai();
            if (!zzll.zzb() || !this.zzj.zzb().zze(str3, zzap.zzch)) {
                str2 = null;
            } else {
                str2 = zzb2.zzg();
            }
            return new zzm(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, zzr2, false, zzi2, zzae, 0, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2);
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzfk.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zza(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2, zzm zzm2) {
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzb);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zzv zzv3 = new zzv(zzv2);
            boolean z = false;
            zzv3.zze = false;
            zze().zzf();
            try {
                zzv zzd2 = zze().zzd(zzv3.zza, zzv3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzv3.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzv3.zzb = zzd2.zzb;
                    zzv3.zzd = zzd2.zzd;
                    zzv3.zzh = zzd2.zzh;
                    zzv3.zzf = zzd2.zzf;
                    zzv3.zzi = zzd2.zzi;
                    zzv3.zze = zzd2.zze;
                    zzv3.zzc = new zzkz(zzv3.zzc.zza, zzd2.zzc.zzb, zzv3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzv3.zzf)) {
                    zzv3.zzc = new zzkz(zzv3.zzc.zza, zzv3.zzd, zzv3.zzc.zza(), zzv3.zzc.zze);
                    zzv3.zze = true;
                    z = true;
                }
                if (zzv3.zze) {
                    zzkz zzkz = zzv3.zzc;
                    zzlb zzlb = new zzlb(zzv3.zza, zzv3.zzb, zzkz.zza, zzkz.zzb, zzkz.zza());
                    if (zze().zza(zzlb)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzv3.zza, this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzfk.zza(zzv3.zza), this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    }
                    if (z && zzv3.zzi != null) {
                        zzb(new zzan(zzv3.zzi, zzv3.zzd), zzm2);
                    }
                }
                if (zze().zza(zzv3)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzv3.zza, this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzfk.zza(zzv3.zza), this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                }
                zze().mo13671b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zzb(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2, zzm zzm2) {
        Bundle bundle;
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzm2);
                zzv zzd2 = zze().zzd(zzv2.zza, zzv2.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzv2.zza, this.zzj.zzj().zzc(zzv2.zzc.zza));
                    zze().zze(zzv2.zza, zzv2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzv2.zza, zzv2.zzc.zza);
                    }
                    if (zzv2.zzk != null) {
                        if (zzv2.zzk.zzb != null) {
                            bundle = zzv2.zzk.zzb.zzb();
                        } else {
                            bundle = null;
                        }
                        zzb(this.zzj.zzi().zza(zzv2.zza, zzv2.zzk.zza, bundle, zzd2.zzb, zzv2.zzk.zzd, true, false), zzm2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzfk.zza(zzv2.zza), this.zzj.zzj().zzc(zzv2.zzc.zza));
                }
                zze().mo13671b_();
            } finally {
                zze().zzh();
            }
        }
    }

    private final zzg zza(zzm zzm2, zzg zzg2, String str) {
        boolean z;
        boolean z2 = true;
        if (zzg2 == null) {
            zzg2 = new zzg(this.zzj, zzm2.zza);
            zzg2.zza(this.zzj.zzi().zzk());
            zzg2.zze(str);
            z = true;
        } else if (!str.equals(zzg2.zzh())) {
            zzg2.zze(str);
            zzg2.zza(this.zzj.zzi().zzk());
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(zzm2.zzb, zzg2.zze())) {
            zzg2.zzb(zzm2.zzb);
            z = true;
        }
        if (!TextUtils.equals(zzm2.zzr, zzg2.zzf())) {
            zzg2.zzc(zzm2.zzr);
            z = true;
        }
        if (zzll.zzb() && this.zzj.zzb().zze(zzg2.zzc(), zzap.zzch) && !TextUtils.equals(zzm2.zzv, zzg2.zzg())) {
            zzg2.zzd(zzm2.zzv);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzk) && !zzm2.zzk.equals(zzg2.zzi())) {
            zzg2.zzf(zzm2.zzk);
            z = true;
        }
        if (!(zzm2.zze == 0 || zzm2.zze == zzg2.zzo())) {
            zzg2.zzd(zzm2.zze);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzc) && !zzm2.zzc.equals(zzg2.zzl())) {
            zzg2.zzg(zzm2.zzc);
            z = true;
        }
        if (zzm2.zzj != zzg2.zzm()) {
            zzg2.zzc(zzm2.zzj);
            z = true;
        }
        if (zzm2.zzd != null && !zzm2.zzd.equals(zzg2.zzn())) {
            zzg2.zzh(zzm2.zzd);
            z = true;
        }
        if (zzm2.zzf != zzg2.zzp()) {
            zzg2.zze(zzm2.zzf);
            z = true;
        }
        if (zzm2.zzh != zzg2.zzr()) {
            zzg2.zza(zzm2.zzh);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzg) && !zzm2.zzg.equals(zzg2.zzac())) {
            zzg2.zzi(zzm2.zzg);
            z = true;
        }
        if (zzm2.zzl != zzg2.zzae()) {
            zzg2.zzp(zzm2.zzl);
            z = true;
        }
        if (zzm2.zzo != zzg2.zzaf()) {
            zzg2.zzb(zzm2.zzo);
            z = true;
        }
        if (zzm2.zzp != zzg2.zzag()) {
            zzg2.zzc(zzm2.zzp);
            z = true;
        }
        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzbc) && zzm2.zzs != zzg2.zzah()) {
            zzg2.zza(zzm2.zzs);
            z = true;
        }
        if (zzm2.zzt == 0 || zzm2.zzt == zzg2.zzq()) {
            z2 = z;
        } else {
            zzg2.zzf(zzm2.zzt);
        }
        if (z2) {
            zze().zza(zzg2);
        }
        return zzg2;
    }

    /* access modifiers changed from: package-private */
    public final zzg zzc(zzm zzm2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        zzg zzb2 = zze().zzb(zzm2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzm2.zza);
        if (!com.google.android.gms.internal.measurement.zzks.zzb() || !this.zzj.zzb().zza(zzap.zzcp)) {
            return zza(zzm2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzg(this.zzj, zzm2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzm2.zzb);
        zzb2.zzc(zzm2.zzr);
        if (zzll.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzap.zzch)) {
            zzb2.zzd(zzm2.zzv);
        }
        if (!TextUtils.isEmpty(zzm2.zzk)) {
            zzb2.zzf(zzm2.zzk);
        }
        if (zzm2.zze != 0) {
            zzb2.zzd(zzm2.zze);
        }
        if (!TextUtils.isEmpty(zzm2.zzc)) {
            zzb2.zzg(zzm2.zzc);
        }
        zzb2.zzc(zzm2.zzj);
        if (zzm2.zzd != null) {
            zzb2.zzh(zzm2.zzd);
        }
        zzb2.zze(zzm2.zzf);
        zzb2.zza(zzm2.zzh);
        if (!TextUtils.isEmpty(zzm2.zzg)) {
            zzb2.zzi(zzm2.zzg);
        }
        zzb2.zzp(zzm2.zzl);
        zzb2.zzb(zzm2.zzo);
        zzb2.zzc(zzm2.zzp);
        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzbc)) {
            zzb2.zza(zzm2.zzs);
        }
        zzb2.zzf(zzm2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzm zzm2) {
        try {
            return (String) this.zzj.zzq().zza(new zzkv(this, zzm2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzfk.zza(zzm2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }

    private final boolean zze(zzm zzm2) {
        return (!zzll.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzch)) ? !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzr) : !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzv) || !TextUtils.isEmpty(zzm2.zzr);
    }
}
