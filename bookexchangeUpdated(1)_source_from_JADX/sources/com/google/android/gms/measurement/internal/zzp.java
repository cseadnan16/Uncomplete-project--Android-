package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzmv;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzp {
    private String zza;
    private boolean zzb;
    private zzbr.zzi zzc;
    /* access modifiers changed from: private */
    public BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzn zzh;

    private zzp(zzn zzn, String str) {
        this.zzh = zzn;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzp(zzn zzn, String str, zzbr.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzn;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer next : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(next));
                this.zzg.put(next, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzi;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzu zzu) {
        int zza2 = zzu.zza();
        if (zzu.zzc != null) {
            this.zze.set(zza2, zzu.zzc.booleanValue());
        }
        if (zzu.zzd != null) {
            this.zzd.set(zza2, zzu.zzd.booleanValue());
        }
        if (zzu.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzu.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzu.zzf != null) {
            List list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzmv.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbt) && zzu.zzb()) {
                list.clear();
            }
            if (zzkb.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbx) && zzu.zzc()) {
                list.clear();
            }
            if (!zzkb.zzb() || !this.zzh.zzt().zzd(this.zza, zzap.zzbx)) {
                list.add(Long.valueOf(zzu.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzu.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f5, code lost:
        if (r0.zzh.zzt().zzd(r0.zza, com.google.android.gms.measurement.internal.zzap.zzbt) == false) goto L_0x00f7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzbr.zza zza(int r18, java.util.List<java.lang.Integer> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            com.google.android.gms.internal.measurement.zzbr$zza$zza r2 = com.google.android.gms.internal.measurement.zzbr.zza.zzh()
            r3 = r18
            r2.zza((int) r3)
            boolean r3 = r0.zzb
            r2.zza((boolean) r3)
            com.google.android.gms.internal.measurement.zzbr$zzi r3 = r0.zzc
            if (r3 == 0) goto L_0x0019
            r2.zza((com.google.android.gms.internal.measurement.zzbr.zzi) r3)
        L_0x0019:
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r3 = com.google.android.gms.internal.measurement.zzbr.zzi.zzi()
            java.util.BitSet r4 = r0.zzd
            java.util.List r4 = com.google.android.gms.measurement.internal.zzkw.zza((java.util.BitSet) r4)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r3 = r3.zzb((java.lang.Iterable<? extends java.lang.Long>) r4)
            java.util.BitSet r4 = r0.zze
            java.util.List r4 = com.google.android.gms.measurement.internal.zzkw.zza((java.util.BitSet) r4)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r3 = r3.zza((java.lang.Iterable<? extends java.lang.Long>) r4)
            java.util.Map<java.lang.Integer, java.lang.Long> r4 = r0.zzf
            r5 = 0
            if (r4 != 0) goto L_0x0039
            r4 = r5
            goto L_0x0088
        L_0x0039:
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.Map<java.lang.Integer, java.lang.Long> r6 = r0.zzf
            int r6 = r6.size()
            r4.<init>(r6)
            java.util.Map<java.lang.Integer, java.lang.Long> r6 = r0.zzf
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x004e:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0087
            java.lang.Object r7 = r6.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            com.google.android.gms.internal.measurement.zzbr$zzb$zza r8 = com.google.android.gms.internal.measurement.zzbr.zzb.zze()
            com.google.android.gms.internal.measurement.zzbr$zzb$zza r8 = r8.zza((int) r7)
            java.util.Map<java.lang.Integer, java.lang.Long> r9 = r0.zzf
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r7 = r9.get(r7)
            java.lang.Long r7 = (java.lang.Long) r7
            long r9 = r7.longValue()
            com.google.android.gms.internal.measurement.zzbr$zzb$zza r7 = r8.zza((long) r9)
            com.google.android.gms.internal.measurement.zzgo r7 = r7.zzu()
            com.google.android.gms.internal.measurement.zzfd r7 = (com.google.android.gms.internal.measurement.zzfd) r7
            com.google.android.gms.internal.measurement.zzbr$zzb r7 = (com.google.android.gms.internal.measurement.zzbr.zzb) r7
            r4.add(r7)
            goto L_0x004e
        L_0x0087:
        L_0x0088:
            r3.zzc(r4)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r4 = r0.zzg
            if (r4 != 0) goto L_0x0096
            java.util.List r4 = java.util.Collections.emptyList()
            goto L_0x00e0
        L_0x0096:
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r6 = r0.zzg
            int r6 = r6.size()
            r4.<init>(r6)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r6 = r0.zzg
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x00ab:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00df
            java.lang.Object r7 = r6.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r8 = com.google.android.gms.internal.measurement.zzbr.zzj.zze()
            int r9 = r7.intValue()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r8 = r8.zza((int) r9)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.Long>> r9 = r0.zzg
            java.lang.Object r7 = r9.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x00d3
            java.util.Collections.sort(r7)
            r8.zza((java.lang.Iterable<? extends java.lang.Long>) r7)
        L_0x00d3:
            com.google.android.gms.internal.measurement.zzgo r7 = r8.zzu()
            com.google.android.gms.internal.measurement.zzfd r7 = (com.google.android.gms.internal.measurement.zzfd) r7
            com.google.android.gms.internal.measurement.zzbr$zzj r7 = (com.google.android.gms.internal.measurement.zzbr.zzj) r7
            r4.add(r7)
            goto L_0x00ab
        L_0x00df:
        L_0x00e0:
            boolean r6 = com.google.android.gms.internal.measurement.zzmv.zzb()
            if (r6 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzn r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()
            java.lang.String r7 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzap.zzbt
            boolean r6 = r6.zzd(r7, r8)
            if (r6 != 0) goto L_0x01fd
        L_0x00f7:
            boolean r6 = r2.zza()
            if (r6 == 0) goto L_0x01fd
            com.google.android.gms.internal.measurement.zzbr$zzi r6 = r2.zzb()
            java.util.List r6 = r6.zzg()
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x010f
            goto L_0x01fd
        L_0x010f:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r4)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x011d:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0150
            java.lang.Object r8 = r6.next()
            com.google.android.gms.internal.measurement.zzbr$zzj r8 = (com.google.android.gms.internal.measurement.zzbr.zzj) r8
            boolean r9 = r8.zza()
            if (r9 == 0) goto L_0x014f
            int r9 = r8.zzd()
            if (r9 <= 0) goto L_0x014f
            int r9 = r8.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r10 = r8.zzd()
            int r10 = r10 + -1
            long r10 = r8.zza((int) r10)
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
            r4.put(r9, r8)
        L_0x014f:
            goto L_0x011d
        L_0x0150:
            r6 = 0
            r8 = 0
        L_0x0152:
            int r9 = r7.size()
            if (r8 >= r9) goto L_0x01c1
            java.lang.Object r9 = r7.get(r8)
            com.google.android.gms.internal.measurement.zzbr$zzj r9 = (com.google.android.gms.internal.measurement.zzbr.zzj) r9
            boolean r10 = r9.zza()
            if (r10 == 0) goto L_0x016e
            int r10 = r9.zzb()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x016f
        L_0x016e:
            r10 = r5
        L_0x016f:
            java.lang.Object r10 = r4.remove(r10)
            java.lang.Long r10 = (java.lang.Long) r10
            if (r10 == 0) goto L_0x01be
            if (r1 == 0) goto L_0x0187
            int r11 = r9.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r1.contains(r11)
            if (r11 != 0) goto L_0x01be
        L_0x0187:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            long r12 = r10.longValue()
            long r14 = r9.zza((int) r6)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x019b
            r11.add(r10)
        L_0x019b:
            java.util.List r10 = r9.zzc()
            r11.addAll(r10)
            com.google.android.gms.internal.measurement.zzfd$zzb r9 = r9.zzbm()
            com.google.android.gms.internal.measurement.zzfd$zzb r9 = (com.google.android.gms.internal.measurement.zzfd.zzb) r9
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r9 = (com.google.android.gms.internal.measurement.zzbr.zzj.zza) r9
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r9 = r9.zza()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r9 = r9.zza((java.lang.Iterable<? extends java.lang.Long>) r11)
            com.google.android.gms.internal.measurement.zzgo r9 = r9.zzu()
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9
            com.google.android.gms.internal.measurement.zzbr$zzj r9 = (com.google.android.gms.internal.measurement.zzbr.zzj) r9
            r7.set(r8, r9)
        L_0x01be:
            int r8 = r8 + 1
            goto L_0x0152
        L_0x01c1:
            java.util.Set r1 = r4.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x01c9:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x01fc
            java.lang.Object r5 = r1.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r6 = com.google.android.gms.internal.measurement.zzbr.zzj.zze()
            int r8 = r5.intValue()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r6 = r6.zza((int) r8)
            java.lang.Object r5 = r4.get(r5)
            java.lang.Long r5 = (java.lang.Long) r5
            long r8 = r5.longValue()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r5 = r6.zza((long) r8)
            com.google.android.gms.internal.measurement.zzgo r5 = r5.zzu()
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5
            com.google.android.gms.internal.measurement.zzbr$zzj r5 = (com.google.android.gms.internal.measurement.zzbr.zzj) r5
            r7.add(r5)
            goto L_0x01c9
        L_0x01fc:
            r4 = r7
        L_0x01fd:
            r3.zzd(r4)
            r2.zza((com.google.android.gms.internal.measurement.zzbr.zzi.zza) r3)
            com.google.android.gms.internal.measurement.zzgo r1 = r2.zzu()
            com.google.android.gms.internal.measurement.zzfd r1 = (com.google.android.gms.internal.measurement.zzfd) r1
            com.google.android.gms.internal.measurement.zzbr$zza r1 = (com.google.android.gms.internal.measurement.zzbr.zza) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzp.zza(int, java.util.List):com.google.android.gms.internal.measurement.zzbr$zza");
    }

    /* synthetic */ zzp(zzn zzn, String str, zzbr.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzq) {
        this(zzn, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzp(zzn zzn, String str, zzq zzq) {
        this(zzn, str);
    }
}
