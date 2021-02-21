package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzr extends zzu {
    private zzbj.zzb zzg;
    private final /* synthetic */ zzn zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzr(zzn zzn, String str, int i, zzbj.zzb zzb) {
        super(str, i);
        this.zzh = zzn;
        this.zzg = zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return this.zzg.zzf();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0139, code lost:
        if (r8.booleanValue() == false) goto L_0x03e0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03f8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.Long r18, java.lang.Long r19, com.google.android.gms.internal.measurement.zzbr.zzc r20, long r21, com.google.android.gms.measurement.internal.zzaj r23, boolean r24) {
        /*
            r17 = this;
            r0 = r17
            com.google.android.gms.measurement.internal.zzn r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r1 = r1.zzt()
            java.lang.String r2 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzbm
            boolean r1 = r1.zzd(r2, r3)
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzt()
            java.lang.String r3 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzbn
            boolean r2 = r2.zzd(r3, r4)
            boolean r3 = com.google.android.gms.internal.measurement.zzkb.zzb()
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r6 = 0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            if (r3 == 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzn r3 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()
            java.lang.String r8 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzbx
            boolean r3 = r3.zzd(r8, r9)
            if (r3 == 0) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x0042:
            r3 = 0
        L_0x0043:
            if (r2 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x0055
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            boolean r2 = r2.zzk()
            if (r2 == 0) goto L_0x0055
            r2 = r23
            long r8 = r2.zze
            goto L_0x0057
        L_0x0055:
            r8 = r21
        L_0x0057:
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            r10 = 2
            boolean r2 = r2.zza((int) r10)
            r10 = 0
            if (r2 == 0) goto L_0x00b9
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()
            int r11 = r0.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            com.google.android.gms.internal.measurement.zzbj$zzb r12 = r0.zzg
            boolean r12 = r12.zza()
            if (r12 == 0) goto L_0x0088
            com.google.android.gms.internal.measurement.zzbj$zzb r12 = r0.zzg
            int r12 = r12.zzb()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0089
        L_0x0088:
            r12 = r10
        L_0x0089:
            com.google.android.gms.measurement.internal.zzn r13 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r13 = r13.zzo()
            com.google.android.gms.internal.measurement.zzbj$zzb r14 = r0.zzg
            java.lang.String r14 = r14.zzc()
            java.lang.String r13 = r13.zza((java.lang.String) r14)
            java.lang.String r14 = "Evaluating filter. audience, filter, event"
            r2.zza(r14, r11, r12, r13)
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()
            com.google.android.gms.measurement.internal.zzn r11 = r0.zzh
            com.google.android.gms.measurement.internal.zzkw r11 = r11.zzg()
            com.google.android.gms.internal.measurement.zzbj$zzb r12 = r0.zzg
            java.lang.String r11 = r11.zza((com.google.android.gms.internal.measurement.zzbj.zzb) r12)
            java.lang.String r12 = "Filter definition"
            r2.zza(r12, r11)
        L_0x00b9:
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x043b
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            int r2 = r2.zzb()
            r11 = 256(0x100, float:3.59E-43)
            if (r2 <= r11) goto L_0x00cd
            goto L_0x043b
        L_0x00cd:
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            boolean r2 = r2.zzh()
            com.google.android.gms.internal.measurement.zzbj$zzb r11 = r0.zzg
            boolean r11 = r11.zzi()
            if (r1 == 0) goto L_0x00e5
            com.google.android.gms.internal.measurement.zzbj$zzb r1 = r0.zzg
            boolean r1 = r1.zzk()
            if (r1 == 0) goto L_0x00e5
            r1 = 1
            goto L_0x00e6
        L_0x00e5:
            r1 = 0
        L_0x00e6:
            if (r2 != 0) goto L_0x00ef
            if (r11 != 0) goto L_0x00ef
            if (r1 == 0) goto L_0x00ed
            goto L_0x00ef
        L_0x00ed:
            r1 = 0
            goto L_0x00f0
        L_0x00ef:
            r1 = 1
        L_0x00f0:
            if (r24 == 0) goto L_0x011c
            if (r1 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzn r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()
            int r2 = r0.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzbj$zzb r3 = r0.zzg
            boolean r3 = r3.zza()
            if (r3 == 0) goto L_0x0116
            com.google.android.gms.internal.measurement.zzbj$zzb r3 = r0.zzg
            int r3 = r3.zzb()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
        L_0x0116:
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zza(r3, r2, r10)
            return r4
        L_0x011c:
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            java.lang.String r11 = r20.zzc()
            boolean r12 = r2.zzf()
            if (r12 == 0) goto L_0x013d
            com.google.android.gms.internal.measurement.zzbj$zzd r12 = r2.zzg()
            java.lang.Boolean r8 = zza((long) r8, (com.google.android.gms.internal.measurement.zzbj.zzd) r12)
            if (r8 != 0) goto L_0x0135
            r7 = r10
            goto L_0x03e0
        L_0x0135:
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x013d
            goto L_0x03e0
        L_0x013d:
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            java.util.List r9 = r2.zzd()
            java.util.Iterator r9 = r9.iterator()
        L_0x014a:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x0184
            java.lang.Object r12 = r9.next()
            com.google.android.gms.internal.measurement.zzbj$zzc r12 = (com.google.android.gms.internal.measurement.zzbj.zzc) r12
            java.lang.String r13 = r12.zzh()
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x017c
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            java.lang.String r8 = "null or empty param name in filter. event"
            r2.zza(r8, r7)
            r7 = r10
            goto L_0x03e0
        L_0x017c:
            java.lang.String r12 = r12.zzh()
            r8.add(r12)
            goto L_0x014a
        L_0x0184:
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            java.util.List r12 = r20.zza()
            java.util.Iterator r12 = r12.iterator()
        L_0x0191:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0222
            java.lang.Object r13 = r12.next()
            com.google.android.gms.internal.measurement.zzbr$zze r13 = (com.google.android.gms.internal.measurement.zzbr.zze) r13
            java.lang.String r14 = r13.zzb()
            boolean r14 = r8.contains(r14)
            if (r14 == 0) goto L_0x0220
            boolean r14 = r13.zze()
            if (r14 == 0) goto L_0x01c5
            java.lang.String r14 = r13.zzb()
            boolean r15 = r13.zze()
            if (r15 == 0) goto L_0x01c0
            long r15 = r13.zzf()
            java.lang.Long r13 = java.lang.Long.valueOf(r15)
            goto L_0x01c1
        L_0x01c0:
            r13 = r10
        L_0x01c1:
            r9.put(r14, r13)
            goto L_0x0191
        L_0x01c5:
            boolean r14 = r13.zzg()
            if (r14 == 0) goto L_0x01e4
            java.lang.String r14 = r13.zzb()
            boolean r15 = r13.zzg()
            if (r15 == 0) goto L_0x01df
            double r15 = r13.zzh()
            java.lang.Double r13 = java.lang.Double.valueOf(r15)
            goto L_0x01e0
        L_0x01df:
            r13 = r10
        L_0x01e0:
            r9.put(r14, r13)
            goto L_0x0191
        L_0x01e4:
            boolean r14 = r13.zzc()
            if (r14 == 0) goto L_0x01f6
            java.lang.String r14 = r13.zzb()
            java.lang.String r13 = r13.zzd()
            r9.put(r14, r13)
            goto L_0x0191
        L_0x01f6:
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzn r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzo()
            java.lang.String r9 = r13.zzb()
            java.lang.String r8 = r8.zzb(r9)
            java.lang.String r9 = "Unknown value for param. event, param"
            r2.zza(r9, r7, r8)
            r7 = r10
            goto L_0x03e0
        L_0x0220:
            goto L_0x0191
        L_0x0222:
            java.util.List r2 = r2.zzd()
            java.util.Iterator r2 = r2.iterator()
        L_0x022a:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x03df
            java.lang.Object r8 = r2.next()
            com.google.android.gms.internal.measurement.zzbj$zzc r8 = (com.google.android.gms.internal.measurement.zzbj.zzc) r8
            boolean r12 = r8.zze()
            if (r12 == 0) goto L_0x0244
            boolean r12 = r8.zzf()
            if (r12 == 0) goto L_0x0244
            r12 = 1
            goto L_0x0245
        L_0x0244:
            r12 = 0
        L_0x0245:
            java.lang.String r13 = r8.zzh()
            boolean r14 = r13.isEmpty()
            if (r14 == 0) goto L_0x026b
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            java.lang.String r8 = "Event has empty param name. event"
            r2.zza(r8, r7)
            r7 = r10
            goto L_0x03e0
        L_0x026b:
            java.lang.Object r14 = r9.get(r13)
            boolean r15 = r14 instanceof java.lang.Long
            if (r15 == 0) goto L_0x02bc
            boolean r15 = r8.zzc()
            if (r15 != 0) goto L_0x029f
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzn r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzo()
            java.lang.String r8 = r8.zzb(r13)
            java.lang.String r9 = "No number filter for long param. event, param"
            r2.zza(r9, r7, r8)
            r7 = r10
            goto L_0x03e0
        L_0x029f:
            java.lang.Long r14 = (java.lang.Long) r14
            long r13 = r14.longValue()
            com.google.android.gms.internal.measurement.zzbj$zzd r8 = r8.zzd()
            java.lang.Boolean r8 = zza((long) r13, (com.google.android.gms.internal.measurement.zzbj.zzd) r8)
            if (r8 != 0) goto L_0x02b2
            r7 = r10
            goto L_0x03e0
        L_0x02b2:
            boolean r8 = r8.booleanValue()
            if (r8 != r12) goto L_0x02ba
            goto L_0x03e0
        L_0x02ba:
            goto L_0x022a
        L_0x02bc:
            boolean r15 = r14 instanceof java.lang.Double
            if (r15 == 0) goto L_0x0309
            boolean r15 = r8.zzc()
            if (r15 != 0) goto L_0x02ec
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzn r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzo()
            java.lang.String r8 = r8.zzb(r13)
            java.lang.String r9 = "No number filter for double param. event, param"
            r2.zza(r9, r7, r8)
            r7 = r10
            goto L_0x03e0
        L_0x02ec:
            java.lang.Double r14 = (java.lang.Double) r14
            double r13 = r14.doubleValue()
            com.google.android.gms.internal.measurement.zzbj$zzd r8 = r8.zzd()
            java.lang.Boolean r8 = zza((double) r13, (com.google.android.gms.internal.measurement.zzbj.zzd) r8)
            if (r8 != 0) goto L_0x02ff
            r7 = r10
            goto L_0x03e0
        L_0x02ff:
            boolean r8 = r8.booleanValue()
            if (r8 != r12) goto L_0x0307
            goto L_0x03e0
        L_0x0307:
            goto L_0x022a
        L_0x0309:
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x0394
            boolean r15 = r8.zza()
            if (r15 == 0) goto L_0x0324
            java.lang.String r14 = (java.lang.String) r14
            com.google.android.gms.internal.measurement.zzbj$zzf r8 = r8.zzb()
            com.google.android.gms.measurement.internal.zzn r13 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r13 = r13.zzr()
            java.lang.Boolean r8 = zza((java.lang.String) r14, (com.google.android.gms.internal.measurement.zzbj.zzf) r8, (com.google.android.gms.measurement.internal.zzfk) r13)
            goto L_0x033a
        L_0x0324:
            boolean r15 = r8.zzc()
            if (r15 == 0) goto L_0x036f
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = com.google.android.gms.measurement.internal.zzkw.zza((java.lang.String) r14)
            if (r15 == 0) goto L_0x0349
            com.google.android.gms.internal.measurement.zzbj$zzd r8 = r8.zzd()
            java.lang.Boolean r8 = zza((java.lang.String) r14, (com.google.android.gms.internal.measurement.zzbj.zzd) r8)
        L_0x033a:
            if (r8 != 0) goto L_0x033f
            r7 = r10
            goto L_0x03e0
        L_0x033f:
            boolean r8 = r8.booleanValue()
            if (r8 != r12) goto L_0x0347
            goto L_0x03e0
        L_0x0347:
            goto L_0x022a
        L_0x0349:
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzn r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzo()
            java.lang.String r8 = r8.zzb(r13)
            java.lang.String r9 = "Invalid param value for number filter. event, param"
            r2.zza(r9, r7, r8)
            r7 = r10
            goto L_0x03e0
        L_0x036f:
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzn r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzo()
            java.lang.String r8 = r8.zzb(r13)
            java.lang.String r9 = "No filter for String param. event, param"
            r2.zza(r9, r7, r8)
            r7 = r10
            goto L_0x03e0
        L_0x0394:
            if (r14 != 0) goto L_0x03ba
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()
            com.google.android.gms.measurement.internal.zzn r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzo()
            java.lang.String r8 = r8.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzn r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r9 = r9.zzo()
            java.lang.String r9 = r9.zzb(r13)
            java.lang.String r10 = "Missing param for filter. event, param"
            r2.zza(r10, r8, r9)
            goto L_0x03e0
        L_0x03ba:
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzn r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzo()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzn r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzo()
            java.lang.String r8 = r8.zzb(r13)
            java.lang.String r9 = "Unknown param type. event, param"
            r2.zza(r9, r7, r8)
            r7 = r10
            goto L_0x03e0
        L_0x03df:
            r7 = r5
        L_0x03e0:
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()
            if (r7 != 0) goto L_0x03f0
            java.lang.String r8 = "null"
            goto L_0x03f1
        L_0x03f0:
            r8 = r7
        L_0x03f1:
            java.lang.String r9 = "Event filter result"
            r2.zza(r9, r8)
            if (r7 != 0) goto L_0x03f9
            return r6
        L_0x03f9:
            r0.zzc = r5
            boolean r2 = r7.booleanValue()
            if (r2 != 0) goto L_0x0402
            return r4
        L_0x0402:
            r0.zzd = r5
            if (r1 == 0) goto L_0x043a
            boolean r1 = r20.zzd()
            if (r1 == 0) goto L_0x043a
            long r1 = r20.zze()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x042c
            if (r3 == 0) goto L_0x0429
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            boolean r2 = r2.zzf()
            if (r2 == 0) goto L_0x0429
            r1 = r18
        L_0x0429:
            r0.zzf = r1
            goto L_0x043a
        L_0x042c:
            if (r3 == 0) goto L_0x0438
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = r0.zzg
            boolean r2 = r2.zzf()
            if (r2 == 0) goto L_0x0438
            r1 = r19
        L_0x0438:
            r0.zze = r1
        L_0x043a:
            return r4
        L_0x043b:
            com.google.android.gms.measurement.internal.zzn r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzi()
            java.lang.String r2 = r0.zza
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfk.zza((java.lang.String) r2)
            com.google.android.gms.internal.measurement.zzbj$zzb r3 = r0.zzg
            boolean r3 = r3.zza()
            if (r3 == 0) goto L_0x045d
            com.google.android.gms.internal.measurement.zzbj$zzb r3 = r0.zzg
            int r3 = r3.zzb()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
        L_0x045d:
            java.lang.String r3 = java.lang.String.valueOf(r10)
            java.lang.String r5 = "Invalid event filter ID. appId, id"
            r1.zza(r5, r2, r3)
            com.google.android.gms.measurement.internal.zzn r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r1 = r1.zzt()
            java.lang.String r2 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzbu
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L_0x0477
            return r6
        L_0x0477:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzr.zza(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzbr$zzc, long, com.google.android.gms.measurement.internal.zzaj, boolean):boolean");
    }
}
