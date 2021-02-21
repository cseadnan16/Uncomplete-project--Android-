package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzgs<T> implements zzhd<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzib.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgo zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgw zzo;
    private final zzfy zzp;
    private final zzhv<?, ?> zzq;
    private final zzes<?> zzr;
    private final zzgh zzs;

    private zzgs(int[] iArr, Object[] objArr, int i, int i2, zzgo zzgo, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgw zzgw, zzfy zzfy, zzhv<?, ?> zzhv, zzes<?> zzes, zzgh zzgh) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgo instanceof zzfd;
        this.zzj = z;
        this.zzh = zzes != null && zzes.zza(zzgo);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgw;
        this.zzp = zzfy;
        this.zzq = zzhv;
        this.zzr = zzes;
        this.zzg = zzgo;
        this.zzs = zzgh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:163:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzgs<T> zza(java.lang.Class<T> r36, com.google.android.gms.internal.measurement.zzgm r37, com.google.android.gms.internal.measurement.zzgw r38, com.google.android.gms.internal.measurement.zzfy r39, com.google.android.gms.internal.measurement.zzhv<?, ?> r40, com.google.android.gms.internal.measurement.zzes<?> r41, com.google.android.gms.internal.measurement.zzgh r42) {
        /*
            r0 = r37
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzhb
            if (r1 == 0) goto L_0x0451
            com.google.android.gms.internal.measurement.zzhb r0 = (com.google.android.gms.internal.measurement.zzhb) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.measurement.zzfd.zze.zzi
            r3 = 0
            if (r1 != r2) goto L_0x0013
            r11 = 1
            goto L_0x0014
        L_0x0013:
            r11 = 0
        L_0x0014:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r7) goto L_0x003e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = 1
            r9 = 13
        L_0x002b:
            int r10 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x003b
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r5 = r5 | r8
            int r9 = r9 + 13
            r8 = r10
            goto L_0x002b
        L_0x003b:
            int r8 = r8 << r9
            r5 = r5 | r8
            goto L_0x003f
        L_0x003e:
            r10 = 1
        L_0x003f:
            int r8 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r7) goto L_0x005f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x004c:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x005c
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x004c
        L_0x005c:
            int r8 = r8 << r10
            r9 = r9 | r8
            r8 = r12
        L_0x005f:
            if (r9 != 0) goto L_0x0073
            int[] r9 = zza
            r14 = r9
            r6 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            goto L_0x019b
        L_0x0073:
            int r9 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x007f:
            int r12 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r7) goto L_0x008f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r8 = r8 | r9
            int r10 = r10 + 13
            r9 = r12
            goto L_0x007f
        L_0x008f:
            int r9 = r9 << r10
            r8 = r8 | r9
            r9 = r12
        L_0x0092:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r7) goto L_0x00b2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x009f:
            int r13 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r7) goto L_0x00af
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r12
            r9 = r9 | r10
            int r12 = r12 + 13
            r10 = r13
            goto L_0x009f
        L_0x00af:
            int r10 = r10 << r12
            r9 = r9 | r10
            r10 = r13
        L_0x00b2:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r7) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00bf:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r7) goto L_0x00cf
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r10 = r10 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00bf
        L_0x00cf:
            int r12 = r12 << r13
            r10 = r10 | r12
            r12 = r14
        L_0x00d2:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r7) goto L_0x00f2
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00df:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r7) goto L_0x00ef
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00df
        L_0x00ef:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f2:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r7) goto L_0x0114
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00ff:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r7) goto L_0x0110
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x00ff
        L_0x0110:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0114:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r7) goto L_0x0138
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0121:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0133
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0121
        L_0x0133:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0138:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x015f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r3 = r16
            r16 = 13
        L_0x0147:
            int r17 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0159
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r16
            r15 = r15 | r3
            int r16 = r16 + 13
            r3 = r17
            goto L_0x0147
        L_0x0159:
            int r3 = r3 << r16
            r15 = r15 | r3
            r3 = r17
            goto L_0x0161
        L_0x015f:
            r3 = r16
        L_0x0161:
            int r16 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0187
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r6 = r16
            r16 = 13
        L_0x0170:
            int r17 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r7) goto L_0x0182
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r16
            r3 = r3 | r6
            int r16 = r16 + 13
            r6 = r17
            goto L_0x0170
        L_0x0182:
            int r6 = r6 << r16
            r3 = r3 | r6
            r16 = r17
        L_0x0187:
            int r6 = r3 + r14
            int r6 = r6 + r15
            int[] r6 = new int[r6]
            int r15 = r8 << 1
            int r15 = r15 + r9
            r9 = r12
            r12 = r15
            r15 = r3
            r3 = r8
            r8 = r16
            r35 = r14
            r14 = r6
            r6 = r35
        L_0x019b:
            sun.misc.Unsafe r7 = zzb
            java.lang.Object[] r17 = r0.zze()
            com.google.android.gms.internal.measurement.zzgo r18 = r0.zzc()
            java.lang.Class r4 = r18.getClass()
            r18 = r8
            int r8 = r13 * 3
            int[] r8 = new int[r8]
            r19 = 1
            int r13 = r13 << 1
            java.lang.Object[] r13 = new java.lang.Object[r13]
            int r20 = r15 + r6
            r22 = r15
            r6 = r18
            r23 = r20
            r18 = 0
            r21 = 0
        L_0x01c3:
            if (r6 >= r2) goto L_0x0428
            int r24 = r6 + 1
            char r6 = r1.charAt(r6)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r2) goto L_0x01f7
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x01d8:
            int r26 = r2 + 1
            char r2 = r1.charAt(r2)
            r27 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r15) goto L_0x01f1
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r6 = r6 | r2
            int r24 = r24 + 13
            r2 = r26
            r15 = r27
            goto L_0x01d8
        L_0x01f1:
            int r2 = r2 << r24
            r6 = r6 | r2
            r2 = r26
            goto L_0x01fb
        L_0x01f7:
            r27 = r15
            r2 = r24
        L_0x01fb:
            int r15 = r2 + 1
            char r2 = r1.charAt(r2)
            r24 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r15) goto L_0x022e
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r15 = r24
            r24 = 13
        L_0x020f:
            int r26 = r15 + 1
            char r15 = r1.charAt(r15)
            r28 = r11
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r11) goto L_0x0228
            r11 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r24
            r2 = r2 | r11
            int r24 = r24 + 13
            r15 = r26
            r11 = r28
            goto L_0x020f
        L_0x0228:
            int r11 = r15 << r24
            r2 = r2 | r11
            r15 = r26
            goto L_0x0232
        L_0x022e:
            r28 = r11
            r15 = r24
        L_0x0232:
            r11 = r2 & 255(0xff, float:3.57E-43)
            r24 = r9
            r9 = r2 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0241
            int r9 = r18 + 1
            r14[r18] = r21
            r18 = r9
        L_0x0241:
            r9 = 51
            r30 = r10
            if (r11 < r9) goto L_0x02ea
            int r9 = r15 + 1
            char r15 = r1.charAt(r15)
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x0270
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x0256:
            int r33 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r10) goto L_0x026b
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r32
            r15 = r15 | r9
            int r32 = r32 + 13
            r9 = r33
            r10 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0256
        L_0x026b:
            int r9 = r9 << r32
            r15 = r15 | r9
            r9 = r33
        L_0x0270:
            int r10 = r11 + -51
            r32 = r9
            r9 = 9
            if (r10 == r9) goto L_0x0296
            r9 = 17
            if (r10 != r9) goto L_0x027e
            goto L_0x0296
        L_0x027e:
            r9 = 12
            if (r10 != r9) goto L_0x0294
            r9 = r5 & 1
            r10 = 1
            if (r9 != r10) goto L_0x0294
            int r9 = r21 / 3
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r10 = r12 + 1
            r12 = r17[r12]
            r13[r9] = r12
            r12 = r10
            r10 = 1
            goto L_0x02a3
        L_0x0294:
            r10 = 1
            goto L_0x02a3
        L_0x0296:
            int r9 = r21 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r19 = r12 + 1
            r12 = r17[r12]
            r13[r9] = r12
            r12 = r19
        L_0x02a3:
            int r9 = r15 << 1
            r10 = r17[r9]
            boolean r15 = r10 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x02ae
            java.lang.reflect.Field r10 = (java.lang.reflect.Field) r10
            goto L_0x02b6
        L_0x02ae:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zza((java.lang.Class<?>) r4, (java.lang.String) r10)
            r17[r9] = r10
        L_0x02b6:
            r33 = r0
            r34 = r1
            long r0 = r7.objectFieldOffset(r10)
            int r1 = (int) r0
            int r9 = r9 + 1
            r0 = r17[r9]
            boolean r10 = r0 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x02ca
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            goto L_0x02d2
        L_0x02ca:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.reflect.Field r0 = zza((java.lang.Class<?>) r4, (java.lang.String) r0)
            r17[r9] = r0
        L_0x02d2:
            long r9 = r7.objectFieldOffset(r0)
            int r0 = (int) r9
            r19 = r4
            r31 = r12
            r15 = r32
            r10 = r34
            r12 = 0
            r16 = 1
            r4 = r0
            r0 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03ef
        L_0x02ea:
            r33 = r0
            r34 = r1
            int r0 = r12 + 1
            r1 = r17[r12]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.reflect.Field r1 = zza((java.lang.Class<?>) r4, (java.lang.String) r1)
            r9 = 49
            r10 = 9
            if (r11 == r10) goto L_0x0367
            r10 = 17
            if (r11 != r10) goto L_0x0305
            r12 = 1
            goto L_0x0368
        L_0x0305:
            r10 = 27
            if (r11 == r10) goto L_0x0359
            if (r11 != r9) goto L_0x030c
            goto L_0x0359
        L_0x030c:
            r10 = 12
            if (r11 == r10) goto L_0x0345
            r10 = 30
            if (r11 == r10) goto L_0x0345
            r10 = 44
            if (r11 != r10) goto L_0x0319
            goto L_0x0345
        L_0x0319:
            r10 = 50
            if (r11 != r10) goto L_0x0343
            int r10 = r22 + 1
            r14[r22] = r21
            int r12 = r21 / 3
            r19 = 1
            int r12 = r12 << 1
            int r22 = r0 + 1
            r0 = r17[r0]
            r13[r12] = r0
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x033d
            int r12 = r12 + 1
            int r0 = r22 + 1
            r22 = r17[r22]
            r13[r12] = r22
            r22 = r10
            r12 = 1
            goto L_0x0372
        L_0x033d:
            r0 = r22
            r12 = 1
            r22 = r10
            goto L_0x0372
        L_0x0343:
            r12 = 1
            goto L_0x0372
        L_0x0345:
            r10 = r5 & 1
            r12 = 1
            if (r10 != r12) goto L_0x0357
            int r10 = r21 / 3
            int r10 = r10 << r12
            int r10 = r10 + r12
            int r12 = r0 + 1
            r0 = r17[r0]
            r13[r10] = r0
            r0 = r12
            r12 = 1
            goto L_0x0372
        L_0x0357:
            r12 = 1
            goto L_0x0372
        L_0x0359:
            int r10 = r21 / 3
            r12 = 1
            int r10 = r10 << r12
            int r10 = r10 + r12
            int r19 = r0 + 1
            r0 = r17[r0]
            r13[r10] = r0
            r0 = r19
            goto L_0x0372
        L_0x0367:
            r12 = 1
        L_0x0368:
            int r10 = r21 / 3
            int r10 = r10 << r12
            int r10 = r10 + r12
            java.lang.Class r19 = r1.getType()
            r13[r10] = r19
        L_0x0372:
            long r9 = r7.objectFieldOffset(r1)
            int r1 = (int) r9
            r9 = r5 & 1
            if (r9 != r12) goto L_0x03d2
            r9 = 17
            if (r11 > r9) goto L_0x03d2
            int r9 = r15 + 1
            r10 = r34
            char r12 = r10.charAt(r15)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r12 < r15) goto L_0x03a7
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0390:
            int r29 = r9 + 1
            char r9 = r10.charAt(r9)
            if (r9 < r15) goto L_0x03a2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r16
            r12 = r12 | r9
            int r16 = r16 + 13
            r9 = r29
            goto L_0x0390
        L_0x03a2:
            int r9 = r9 << r16
            r12 = r12 | r9
            r9 = r29
        L_0x03a7:
            r16 = 1
            int r19 = r3 << 1
            int r29 = r12 / 32
            int r19 = r19 + r29
            r15 = r17[r19]
            r31 = r0
            boolean r0 = r15 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x03bb
            java.lang.reflect.Field r15 = (java.lang.reflect.Field) r15
            goto L_0x03c3
        L_0x03bb:
            java.lang.String r15 = (java.lang.String) r15
            java.lang.reflect.Field r15 = zza((java.lang.Class<?>) r4, (java.lang.String) r15)
            r17[r19] = r15
        L_0x03c3:
            r0 = r3
            r19 = r4
            long r3 = r7.objectFieldOffset(r15)
            int r4 = (int) r3
            int r12 = r12 % 32
            r15 = r9
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03e1
        L_0x03d2:
            r31 = r0
            r0 = r3
            r19 = r4
            r10 = r34
            r3 = 55296(0xd800, float:7.7486E-41)
            r16 = 1
            r4 = 0
            r12 = 0
        L_0x03e1:
            r9 = 18
            if (r11 < r9) goto L_0x03ef
            r9 = 49
            if (r11 > r9) goto L_0x03ef
            int r9 = r23 + 1
            r14[r23] = r1
            r23 = r9
        L_0x03ef:
            int r9 = r21 + 1
            r8[r21] = r6
            int r6 = r9 + 1
            r3 = r2 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x03fc
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03fd
        L_0x03fc:
            r3 = 0
        L_0x03fd:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0404
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0405
        L_0x0404:
            r2 = 0
        L_0x0405:
            r2 = r2 | r3
            int r3 = r11 << 20
            r2 = r2 | r3
            r1 = r1 | r2
            r8[r9] = r1
            int r21 = r6 + 1
            int r1 = r12 << 20
            r1 = r1 | r4
            r8[r6] = r1
            r3 = r0
            r1 = r10
            r6 = r15
            r4 = r19
            r9 = r24
            r2 = r25
            r15 = r27
            r11 = r28
            r10 = r30
            r12 = r31
            r0 = r33
            goto L_0x01c3
        L_0x0428:
            r33 = r0
            r24 = r9
            r30 = r10
            r28 = r11
            r27 = r15
            com.google.android.gms.internal.measurement.zzgs r0 = new com.google.android.gms.internal.measurement.zzgs
            com.google.android.gms.internal.measurement.zzgo r10 = r33.zzc()
            r12 = 0
            r5 = r0
            r6 = r8
            r7 = r13
            r8 = r30
            r13 = r14
            r14 = r27
            r15 = r20
            r16 = r38
            r17 = r39
            r18 = r40
            r19 = r41
            r20 = r42
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0451:
            com.google.android.gms.internal.measurement.zzhs r0 = (com.google.android.gms.internal.measurement.zzhs) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.measurement.zzfd.zze.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzgm, com.google.android.gms.internal.measurement.zzgw, com.google.android.gms.internal.measurement.zzfy, com.google.android.gms.internal.measurement.zzhv, com.google.android.gms.internal.measurement.zzes, com.google.android.gms.internal.measurement.zzgh):com.google.android.gms.internal.measurement.zzgs");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzd2 = zzd(i);
                long j = (long) (zzd2 & 1048575);
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzib.zze(t, j)) != Double.doubleToLongBits(zzib.zze(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzib.zzd(t, j)) != Float.floatToIntBits(zzib.zzd(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzib.zzc(t, j) != zzib.zzc(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzib.zza((Object) t, j) != zzib.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j));
                        break;
                    case 50:
                        z = zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zze2 = (long) (zze(i) & 1048575);
                        if (zzib.zza((Object) t, zze2) != zzib.zza((Object) t2, zze2) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzq.zzb(t).equals(this.zzq.zzb(t2))) {
                return false;
            } else {
                if (this.zzh) {
                    return this.zzr.zza((Object) t).equals(this.zzr.zza((Object) t2));
                }
                return true;
            }
        }
    }

    public final int zza(T t) {
        int length = this.zzc.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzd2 = zzd(i2);
            int i3 = this.zzc[i2];
            long j = (long) (1048575 & zzd2);
            int i4 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzff.zza(Double.doubleToLongBits(zzib.zze(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzib.zzd(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + zzff.zza(zzib.zzc(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzib.zzf(t, j)).hashCode();
                    break;
                case 9:
                    Object zzf2 = zzib.zzf(t, j);
                    if (zzf2 != null) {
                        i4 = zzf2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzib.zzf(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 12:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzib.zza((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + zzff.zza(zzib.zzb(t, j));
                    break;
                case 17:
                    Object zzf3 = zzib.zzf(t, j);
                    if (zzf3 != null) {
                        i4 = zzf3.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzib.zzf(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzib.zzf(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(Double.doubleToLongBits(zzb(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzc(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zzf(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zzib.zzf(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzib.zzf(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzib.zzf(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 66:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 67:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzff.zza(zze(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzib.zzf(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzq.zzb(t).hashCode();
        if (this.zzh) {
            return (hashCode * 53) + this.zzr.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzhf.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzhf.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzhf.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzib.zzf(t, zzd2);
            Object zzf3 = zzib.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzib.zza((Object) t, zzd2, zzff.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzib.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzib.zzf(t, j);
            Object zzf3 = zzib.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzib.zza((Object) t, j, zzff.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzib.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    public final int zzb(T t) {
        int i;
        int i2;
        long j;
        int i3;
        T t2 = t;
        int i4 = 267386880;
        int i5 = 1;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.zzc.length) {
                int zzd2 = zzd(i6);
                int i8 = (zzd2 & i4) >>> 20;
                int i9 = this.zzc[i6];
                long j2 = (long) (zzd2 & 1048575);
                if (i8 < zzex.DOUBLE_LIST_PACKED.zza() || i8 > zzex.SINT64_LIST_PACKED.zza()) {
                    i3 = 0;
                } else {
                    i3 = this.zzc[i6 + 2] & 1048575;
                }
                switch (i8) {
                    case 0:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzd(i9, zzib.zzb(t2, j2));
                            break;
                        }
                    case 3:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zze(i9, zzib.zzb(t2, j2));
                            break;
                        }
                    case 4:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 5:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, 0);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzi(i9, 0);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, true);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            Object zzf2 = zzib.zzf(t2, j2);
                            if (!(zzf2 instanceof zzdu)) {
                                i7 += zzen.zzb(i9, (String) zzf2);
                                break;
                            } else {
                                i7 += zzen.zzc(i9, (zzdu) zzf2);
                                break;
                            }
                        }
                    case 9:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhf.zza(i9, zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 10:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzdu) zzib.zzf(t2, j2));
                            break;
                        }
                    case 11:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 12:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzk(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 13:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzj(i9, 0);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, 0);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, zzib.zza((Object) t2, j2));
                            break;
                        }
                    case 16:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zzib.zzb(t2, j2));
                            break;
                        }
                    case 17:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzgo) zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 18:
                        i7 += zzhf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 19:
                        i7 += zzhf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 20:
                        i7 += zzhf.zza(i9, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 21:
                        i7 += zzhf.zzb(i9, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 22:
                        i7 += zzhf.zze(i9, zza((Object) t2, j2), false);
                        break;
                    case 23:
                        i7 += zzhf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 24:
                        i7 += zzhf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 25:
                        i7 += zzhf.zzj(i9, zza((Object) t2, j2), false);
                        break;
                    case 26:
                        i7 += zzhf.zza(i9, zza((Object) t2, j2));
                        break;
                    case 27:
                        i7 += zzhf.zza(i9, zza((Object) t2, j2), zza(i6));
                        break;
                    case 28:
                        i7 += zzhf.zzb(i9, zza((Object) t2, j2));
                        break;
                    case 29:
                        i7 += zzhf.zzf(i9, zza((Object) t2, j2), false);
                        break;
                    case 30:
                        i7 += zzhf.zzd(i9, zza((Object) t2, j2), false);
                        break;
                    case 31:
                        i7 += zzhf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 32:
                        i7 += zzhf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 33:
                        i7 += zzhf.zzg(i9, zza((Object) t2, j2), false);
                        break;
                    case 34:
                        i7 += zzhf.zzc(i9, zza((Object) t2, j2), false);
                        break;
                    case 35:
                        int zzi2 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzi2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzi2) + zzi2;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int zzh2 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzh2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzh2) + zzh2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int zza2 = zzhf.zza((List<Long>) (List) unsafe.getObject(t2, j2));
                        if (zza2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zza2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zza2) + zza2;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int zzb2 = zzhf.zzb((List) unsafe.getObject(t2, j2));
                        if (zzb2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzb2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzb2) + zzb2;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int zze2 = zzhf.zze((List) unsafe.getObject(t2, j2));
                        if (zze2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zze2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zze2) + zze2;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int zzi3 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzi3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzi3) + zzi3;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int zzh3 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzh3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzh3) + zzh3;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int zzj2 = zzhf.zzj((List) unsafe.getObject(t2, j2));
                        if (zzj2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzj2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzj2) + zzj2;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int zzf3 = zzhf.zzf((List) unsafe.getObject(t2, j2));
                        if (zzf3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzf3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzf3) + zzf3;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int zzd3 = zzhf.zzd((List) unsafe.getObject(t2, j2));
                        if (zzd3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzd3);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzd3) + zzd3;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int zzh4 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzh4);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzh4) + zzh4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int zzi4 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzi4);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzi4) + zzi4;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int zzg2 = zzhf.zzg((List) unsafe.getObject(t2, j2));
                        if (zzg2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzg2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzg2) + zzg2;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzc2 = zzhf.zzc((List) unsafe.getObject(t2, j2));
                        if (zzc2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzc2);
                            }
                            i7 += zzen.zze(i9) + zzen.zzg(zzc2) + zzc2;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i7 += zzhf.zzb(i9, (List<zzgo>) zza((Object) t2, j2), zza(i6));
                        break;
                    case 50:
                        i7 += this.zzs.zza(i9, zzib.zzf(t2, j2), zzb(i6));
                        break;
                    case 51:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzd(i9, zze(t2, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zze(i9, zze(t2, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zzd(t2, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzi(i9, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzb(i9, true);
                            break;
                        }
                    case 59:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            Object zzf4 = zzib.zzf(t2, j2);
                            if (!(zzf4 instanceof zzdu)) {
                                i7 += zzen.zzb(i9, (String) zzf4);
                                break;
                            } else {
                                i7 += zzen.zzc(i9, (zzdu) zzf4);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhf.zza(i9, zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 61:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzdu) zzib.zzf(t2, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzg(i9, zzd(t2, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzk(i9, zzd(t2, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzj(i9, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzh(i9, zzd(t2, j2));
                            break;
                        }
                    case 67:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzf(i9, zze(t2, j2));
                            break;
                        }
                    case 68:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzen.zzc(i9, (zzgo) zzib.zzf(t2, j2), zza(i6));
                            break;
                        }
                }
                i6 += 3;
                i4 = 267386880;
            }
            return i7 + zza(this.zzq, t2);
        }
        Unsafe unsafe2 = zzb;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < this.zzc.length) {
            int zzd4 = zzd(i11);
            int[] iArr = this.zzc;
            int i14 = iArr[i11];
            int i15 = (zzd4 & 267386880) >>> 20;
            if (i15 <= 17) {
                int i16 = iArr[i11 + 2];
                int i17 = i16 & 1048575;
                i = i5 << (i16 >>> 20);
                if (i17 != i10) {
                    i13 = unsafe2.getInt(t2, (long) i17);
                    i10 = i17;
                }
                i2 = i16;
            } else if (!this.zzk || i15 < zzex.DOUBLE_LIST_PACKED.zza() || i15 > zzex.SINT64_LIST_PACKED.zza()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzc[i11 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzd4 & 1048575);
            switch (i15) {
                case 0:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzen.zzb(i14, 0.0d);
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzen.zzb(i14, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzen.zzd(i14, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzen.zze(i14, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzen.zzf(i14, unsafe2.getInt(t2, j3));
                        break;
                    }
                case 5:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        i12 += zzen.zzg(i14, 0);
                        break;
                    }
                case 6:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzi(i14, 0);
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzb(i14, true);
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j3);
                        if (!(object instanceof zzdu)) {
                            i12 += zzen.zzb(i14, (String) object);
                            j = 0;
                            break;
                        } else {
                            i12 += zzen.zzc(i14, (zzdu) object);
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhf.zza(i14, unsafe2.getObject(t2, j3), zza(i11));
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzc(i14, (zzdu) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzg(i14, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzk(i14, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzj(i14, 0);
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzh(i14, 0);
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzh(i14, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzf(i14, unsafe2.getLong(t2, j3));
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzc(i14, (zzgo) unsafe2.getObject(t2, j3), zza(i11));
                        j = 0;
                        break;
                    }
                case 18:
                    i12 += zzhf.zzi(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 19:
                    i12 += zzhf.zzh(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 20:
                    i12 += zzhf.zza(i14, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 21:
                    i12 += zzhf.zzb(i14, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 22:
                    i12 += zzhf.zze(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 23:
                    i12 += zzhf.zzi(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 24:
                    i12 += zzhf.zzh(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 25:
                    i12 += zzhf.zzj(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 26:
                    i12 += zzhf.zza(i14, (List<?>) (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 27:
                    i12 += zzhf.zza(i14, (List<?>) (List) unsafe2.getObject(t2, j3), zza(i11));
                    j = 0;
                    break;
                case 28:
                    i12 += zzhf.zzb(i14, (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 29:
                    i12 += zzhf.zzf(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 30:
                    i12 += zzhf.zzd(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 31:
                    i12 += zzhf.zzh(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 32:
                    i12 += zzhf.zzi(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 33:
                    i12 += zzhf.zzg(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 34:
                    i12 += zzhf.zzc(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 35:
                    int zzi5 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi5);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzi5) + zzi5;
                        j = 0;
                        break;
                    }
                case 36:
                    int zzh5 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh5);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzh5) + zzh5;
                        j = 0;
                        break;
                    }
                case 37:
                    int zza3 = zzhf.zza((List<Long>) (List) unsafe2.getObject(t2, j3));
                    if (zza3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zza3);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zza3) + zza3;
                        j = 0;
                        break;
                    }
                case 38:
                    int zzb3 = zzhf.zzb((List) unsafe2.getObject(t2, j3));
                    if (zzb3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzb3);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzb3) + zzb3;
                        j = 0;
                        break;
                    }
                case 39:
                    int zze3 = zzhf.zze((List) unsafe2.getObject(t2, j3));
                    if (zze3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zze3);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zze3) + zze3;
                        j = 0;
                        break;
                    }
                case 40:
                    int zzi6 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi6);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzi6) + zzi6;
                        j = 0;
                        break;
                    }
                case 41:
                    int zzh6 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh6);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzh6) + zzh6;
                        j = 0;
                        break;
                    }
                case 42:
                    int zzj3 = zzhf.zzj((List) unsafe2.getObject(t2, j3));
                    if (zzj3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzj3);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzj3) + zzj3;
                        j = 0;
                        break;
                    }
                case 43:
                    int zzf5 = zzhf.zzf((List) unsafe2.getObject(t2, j3));
                    if (zzf5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzf5);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzf5) + zzf5;
                        j = 0;
                        break;
                    }
                case 44:
                    int zzd5 = zzhf.zzd((List) unsafe2.getObject(t2, j3));
                    if (zzd5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzd5);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzd5) + zzd5;
                        j = 0;
                        break;
                    }
                case 45:
                    int zzh7 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh7 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh7);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzh7) + zzh7;
                        j = 0;
                        break;
                    }
                case 46:
                    int zzi7 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi7 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi7);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzi7) + zzi7;
                        j = 0;
                        break;
                    }
                case 47:
                    int zzg3 = zzhf.zzg((List) unsafe2.getObject(t2, j3));
                    if (zzg3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzg3);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzg3) + zzg3;
                        j = 0;
                        break;
                    }
                case 48:
                    int zzc3 = zzhf.zzc((List) unsafe2.getObject(t2, j3));
                    if (zzc3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzc3);
                        }
                        i12 += zzen.zze(i14) + zzen.zzg(zzc3) + zzc3;
                        j = 0;
                        break;
                    }
                case 49:
                    i12 += zzhf.zzb(i14, (List<zzgo>) (List) unsafe2.getObject(t2, j3), zza(i11));
                    j = 0;
                    break;
                case 50:
                    i12 += this.zzs.zza(i14, unsafe2.getObject(t2, j3), zzb(i11));
                    j = 0;
                    break;
                case 51:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzb(i14, 0.0d);
                        j = 0;
                        break;
                    }
                case 52:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzb(i14, 0.0f);
                        j = 0;
                        break;
                    }
                case 53:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzd(i14, zze(t2, j3));
                        j = 0;
                        break;
                    }
                case 54:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zze(i14, zze(t2, j3));
                        j = 0;
                        break;
                    }
                case 55:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzf(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 56:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzg(i14, 0);
                        j = 0;
                        break;
                    }
                case 57:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzi(i14, 0);
                        j = 0;
                        break;
                    }
                case 58:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzb(i14, true);
                        j = 0;
                        break;
                    }
                case 59:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (!(object2 instanceof zzdu)) {
                            i12 += zzen.zzb(i14, (String) object2);
                            j = 0;
                            break;
                        } else {
                            i12 += zzen.zzc(i14, (zzdu) object2);
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhf.zza(i14, unsafe2.getObject(t2, j3), zza(i11));
                        j = 0;
                        break;
                    }
                case 61:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzc(i14, (zzdu) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 62:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzg(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 63:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzk(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 64:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzj(i14, 0);
                        j = 0;
                        break;
                    }
                case 65:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzh(i14, 0);
                        j = 0;
                        break;
                    }
                case 66:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzh(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 67:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzf(i14, zze(t2, j3));
                        j = 0;
                        break;
                    }
                case 68:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzen.zzc(i14, (zzgo) unsafe2.getObject(t2, j3), zza(i11));
                        j = 0;
                        break;
                    }
                default:
                    j = 0;
                    break;
            }
            i11 += 3;
            long j4 = j;
            i5 = 1;
        }
        int i18 = 0;
        int zza4 = i12 + zza(this.zzq, t2);
        if (!this.zzh) {
            return zza4;
        }
        zzew<?> zza5 = this.zzr.zza((Object) t2);
        for (int i19 = 0; i19 < zza5.zza.zzc(); i19++) {
            Map.Entry<T, Object> zzb4 = zza5.zza.zzb(i19);
            i18 += zzew.zza((zzey<?>) (zzey) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry next : zza5.zza.zzd()) {
            i18 += zzew.zza((zzey<?>) (zzey) next.getKey(), next.getValue());
        }
        return zza4 + i18;
    }

    private static <UT, UB> int zza(zzhv<UT, UB> zzhv, T t) {
        return zzhv.zzf(zzhv.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzib.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b5e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzis r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.measurement.zzfd.zze.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x05c3
            com.google.android.gms.internal.measurement.zzhv<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzis) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0036
            com.google.android.gms.internal.measurement.zzes<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzew r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzhi<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0036
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0038
        L_0x0036:
            r0 = r3
            r1 = r0
        L_0x0038:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x003d:
            if (r7 < 0) goto L_0x05ab
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0049:
            if (r1 == 0) goto L_0x0067
            com.google.android.gms.internal.measurement.zzes<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0067
            com.google.android.gms.internal.measurement.zzes<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0065
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0049
        L_0x0065:
            r1 = r3
            goto L_0x0049
        L_0x0067:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0596;
                case 1: goto L_0x0584;
                case 2: goto L_0x0572;
                case 3: goto L_0x0560;
                case 4: goto L_0x054e;
                case 5: goto L_0x053c;
                case 6: goto L_0x052a;
                case 7: goto L_0x0517;
                case 8: goto L_0x0505;
                case 9: goto L_0x04ef;
                case 10: goto L_0x04db;
                case 11: goto L_0x04c8;
                case 12: goto L_0x04b5;
                case 13: goto L_0x04a2;
                case 14: goto L_0x048f;
                case 15: goto L_0x047c;
                case 16: goto L_0x0469;
                case 17: goto L_0x0453;
                case 18: goto L_0x043f;
                case 19: goto L_0x042b;
                case 20: goto L_0x0417;
                case 21: goto L_0x0403;
                case 22: goto L_0x03ef;
                case 23: goto L_0x03db;
                case 24: goto L_0x03c7;
                case 25: goto L_0x03b3;
                case 26: goto L_0x039f;
                case 27: goto L_0x0387;
                case 28: goto L_0x0373;
                case 29: goto L_0x035f;
                case 30: goto L_0x034b;
                case 31: goto L_0x0337;
                case 32: goto L_0x0323;
                case 33: goto L_0x030f;
                case 34: goto L_0x02fb;
                case 35: goto L_0x02e7;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02bf;
                case 38: goto L_0x02ab;
                case 39: goto L_0x0297;
                case 40: goto L_0x0283;
                case 41: goto L_0x026f;
                case 42: goto L_0x025b;
                case 43: goto L_0x0247;
                case 44: goto L_0x0233;
                case 45: goto L_0x021f;
                case 46: goto L_0x020b;
                case 47: goto L_0x01f7;
                case 48: goto L_0x01e3;
                case 49: goto L_0x01cb;
                case 50: goto L_0x01bf;
                case 51: goto L_0x01ad;
                case 52: goto L_0x019b;
                case 53: goto L_0x0189;
                case 54: goto L_0x0177;
                case 55: goto L_0x0165;
                case 56: goto L_0x0153;
                case 57: goto L_0x0141;
                case 58: goto L_0x012f;
                case 59: goto L_0x011d;
                case 60: goto L_0x0107;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00cf;
                case 64: goto L_0x00bd;
                case 65: goto L_0x00ab;
                case 66: goto L_0x0099;
                case 67: goto L_0x0087;
                case 68: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x05a7
        L_0x0071:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhd) r10)
            goto L_0x05a7
        L_0x0087:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0099:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x05a7
        L_0x00ab:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a7
        L_0x00bd:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00cf:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00e1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00f3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzdu r8 = (com.google.android.gms.internal.measurement.zzdu) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzdu) r8)
            goto L_0x05a7
        L_0x0107:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhd) r10)
            goto L_0x05a7
        L_0x011d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x05a7
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x05a7
        L_0x0141:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0153:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0165:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0177:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0189:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a7
        L_0x019b:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a7
        L_0x01ad:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x05a7
        L_0x01bf:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.measurement.zzis) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x05a7
        L_0x01cb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzis) r15, (com.google.android.gms.internal.measurement.zzhd) r10)
            goto L_0x05a7
        L_0x01e3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zze(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x01f7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzj(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x020b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzg(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x021f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzl(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0233:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzm(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0247:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzi(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x025b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzn(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x026f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzk(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0283:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzf(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0297:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzh(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02ab:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzd(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02bf:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzc(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02d3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02fb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zze(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x030f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzj(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0323:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzg(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0337:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzl(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x034b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzm(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x035f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzi(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r9, (java.util.List<com.google.android.gms.internal.measurement.zzdu>) r8, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x05a7
        L_0x0387:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzhf.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzis) r15, (com.google.android.gms.internal.measurement.zzhd) r10)
            goto L_0x05a7
        L_0x039f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x05a7
        L_0x03b3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzn(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03c7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzk(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03db:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzf(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03ef:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzh(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0403:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzd(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0417:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzc(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x042b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r5)
            goto L_0x05a7
        L_0x043f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r5)
            goto L_0x05a7
        L_0x0453:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhd) r10)
            goto L_0x05a7
        L_0x0469:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x05a7
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x05a7
        L_0x048f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a7
        L_0x04a2:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04b5:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04c8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04db:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzdu r8 = (com.google.android.gms.internal.measurement.zzdu) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzdu) r8)
            goto L_0x05a7
        L_0x04ef:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhd) r10)
            goto L_0x05a7
        L_0x0505:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x05a7
        L_0x0517:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzib.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x05a7
        L_0x052a:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x05a7
        L_0x053c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x05a7
        L_0x054e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0560:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0572:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0584:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzib.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a7
        L_0x0596:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzib.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x05a7:
            int r7 = r7 + -3
            goto L_0x003d
        L_0x05ab:
            if (r1 == 0) goto L_0x05c2
            com.google.android.gms.internal.measurement.zzes<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x05c0
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x05ab
        L_0x05c0:
            r1 = r3
            goto L_0x05ab
        L_0x05c2:
            return
        L_0x05c3:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0b78
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x05e8
            com.google.android.gms.internal.measurement.zzes<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzew r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzhi<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x05e8
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x05ea
        L_0x05e8:
            r0 = r3
            r1 = r0
        L_0x05ea:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = 0
        L_0x05ee:
            if (r8 >= r7) goto L_0x0b5c
            int r9 = r13.zzd((int) r8)
            int[] r10 = r13.zzc
            r10 = r10[r8]
        L_0x05fa:
            if (r1 == 0) goto L_0x0618
            com.google.android.gms.internal.measurement.zzes<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0618
            com.google.android.gms.internal.measurement.zzes<?> r11 = r13.zzr
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0616
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x05fa
        L_0x0616:
            r1 = r3
            goto L_0x05fa
        L_0x0618:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0b47;
                case 1: goto L_0x0b35;
                case 2: goto L_0x0b23;
                case 3: goto L_0x0b11;
                case 4: goto L_0x0aff;
                case 5: goto L_0x0aed;
                case 6: goto L_0x0adb;
                case 7: goto L_0x0ac8;
                case 8: goto L_0x0ab6;
                case 9: goto L_0x0aa0;
                case 10: goto L_0x0a8c;
                case 11: goto L_0x0a79;
                case 12: goto L_0x0a66;
                case 13: goto L_0x0a53;
                case 14: goto L_0x0a40;
                case 15: goto L_0x0a2d;
                case 16: goto L_0x0a1a;
                case 17: goto L_0x0a04;
                case 18: goto L_0x09f0;
                case 19: goto L_0x09dc;
                case 20: goto L_0x09c8;
                case 21: goto L_0x09b4;
                case 22: goto L_0x09a0;
                case 23: goto L_0x098c;
                case 24: goto L_0x0978;
                case 25: goto L_0x0964;
                case 26: goto L_0x0950;
                case 27: goto L_0x0938;
                case 28: goto L_0x0924;
                case 29: goto L_0x0910;
                case 30: goto L_0x08fc;
                case 31: goto L_0x08e8;
                case 32: goto L_0x08d4;
                case 33: goto L_0x08c0;
                case 34: goto L_0x08ac;
                case 35: goto L_0x0898;
                case 36: goto L_0x0884;
                case 37: goto L_0x0870;
                case 38: goto L_0x085c;
                case 39: goto L_0x0848;
                case 40: goto L_0x0834;
                case 41: goto L_0x0820;
                case 42: goto L_0x080c;
                case 43: goto L_0x07f8;
                case 44: goto L_0x07e4;
                case 45: goto L_0x07d0;
                case 46: goto L_0x07bc;
                case 47: goto L_0x07a8;
                case 48: goto L_0x0794;
                case 49: goto L_0x077c;
                case 50: goto L_0x0770;
                case 51: goto L_0x075e;
                case 52: goto L_0x074c;
                case 53: goto L_0x073a;
                case 54: goto L_0x0728;
                case 55: goto L_0x0716;
                case 56: goto L_0x0704;
                case 57: goto L_0x06f2;
                case 58: goto L_0x06e0;
                case 59: goto L_0x06ce;
                case 60: goto L_0x06b8;
                case 61: goto L_0x06a4;
                case 62: goto L_0x0692;
                case 63: goto L_0x0680;
                case 64: goto L_0x066e;
                case 65: goto L_0x065c;
                case 66: goto L_0x064a;
                case 67: goto L_0x0638;
                case 68: goto L_0x0622;
                default: goto L_0x0620;
            }
        L_0x0620:
            goto L_0x0b58
        L_0x0622:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhd) r11)
            goto L_0x0b58
        L_0x0638:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0b58
        L_0x064a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0b58
        L_0x065c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b58
        L_0x066e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0680:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0692:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0b58
        L_0x06a4:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzdu r9 = (com.google.android.gms.internal.measurement.zzdu) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzdu) r9)
            goto L_0x0b58
        L_0x06b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhd) r11)
            goto L_0x0b58
        L_0x06ce:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x0b58
        L_0x06e0:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0b58
        L_0x06f2:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0704:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0716:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0728:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0b58
        L_0x073a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b58
        L_0x074c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b58
        L_0x075e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0b58
        L_0x0770:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.measurement.zzis) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0b58
        L_0x077c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza((int) r8)
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzis) r15, (com.google.android.gms.internal.measurement.zzhd) r11)
            goto L_0x0b58
        L_0x0794:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zze(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07a8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzj(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07bc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzg(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07d0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzl(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07e4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzm(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07f8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzi(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x080c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzn(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0820:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzk(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0834:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzf(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0848:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzh(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x085c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzd(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0870:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzc(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0884:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r4)
            goto L_0x0b58
        L_0x0898:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r4)
            goto L_0x0b58
        L_0x08ac:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zze(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08c0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzj(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08d4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzg(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08e8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzl(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08fc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzm(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0910:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzi(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0924:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r10, (java.util.List<com.google.android.gms.internal.measurement.zzdu>) r9, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x0b58
        L_0x0938:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza((int) r8)
            com.google.android.gms.internal.measurement.zzhf.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzis) r15, (com.google.android.gms.internal.measurement.zzhd) r11)
            goto L_0x0b58
        L_0x0950:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x0b58
        L_0x0964:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzn(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0978:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzk(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x098c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzf(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09a0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzh(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09b4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzd(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09c8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzc(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09dc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r5)
            goto L_0x0b58
        L_0x09f0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzis) r15, (boolean) r5)
            goto L_0x0b58
        L_0x0a04:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhd) r11)
            goto L_0x0b58
        L_0x0a1a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0a2d:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0b58
        L_0x0a40:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0a53:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a66:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a79:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a8c:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzdu r9 = (com.google.android.gms.internal.measurement.zzdu) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzdu) r9)
            goto L_0x0b58
        L_0x0aa0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhd) r11)
            goto L_0x0b58
        L_0x0ab6:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzis) r15)
            goto L_0x0b58
        L_0x0ac8:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzib.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0b58
        L_0x0adb:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0aed:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0aff:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0b11:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0b23:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0b35:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzib.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b58
        L_0x0b47:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzib.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0b58:
            int r8 = r8 + 3
            goto L_0x05ee
        L_0x0b5c:
            if (r1 == 0) goto L_0x0b72
            com.google.android.gms.internal.measurement.zzes<?> r2 = r13.zzr
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0b70
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0b5c
        L_0x0b70:
            r1 = r3
            goto L_0x0b5c
        L_0x0b72:
            com.google.android.gms.internal.measurement.zzhv<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzis) r15)
            return
        L_0x0b78:
            r13.zzb(r14, (com.google.android.gms.internal.measurement.zzis) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.measurement.zzis r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0025
            com.google.android.gms.internal.measurement.zzes<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzew r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.measurement.zzhi<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0025
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0027
        L_0x0025:
            r3 = 0
            r5 = 0
        L_0x0027:
            r6 = -1
            int[] r7 = r0.zzc
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzb
            r10 = 0
            r11 = 0
        L_0x0030:
            if (r10 >= r7) goto L_0x05c5
            int r12 = r0.zzd((int) r10)
            int[] r13 = r0.zzc
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzj
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0069
            r4 = 17
            if (r15 > r4) goto L_0x0069
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r6) goto L_0x0061
            r17 = r10
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
            goto L_0x0063
        L_0x0061:
            r17 = r10
        L_0x0063:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x006c
        L_0x0069:
            r17 = r10
            r4 = 0
        L_0x006c:
            if (r5 == 0) goto L_0x008a
            com.google.android.gms.internal.measurement.zzes<?> r9 = r0.zzr
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r5)
            if (r9 > r14) goto L_0x008a
            com.google.android.gms.internal.measurement.zzes<?> r9 = r0.zzr
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0088
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x006c
        L_0x0088:
            r5 = 0
            goto L_0x006c
        L_0x008a:
            r9 = r12 & r16
            long r9 = (long) r9
            switch(r15) {
                case 0: goto L_0x05b3;
                case 1: goto L_0x05a4;
                case 2: goto L_0x0596;
                case 3: goto L_0x0588;
                case 4: goto L_0x057a;
                case 5: goto L_0x056c;
                case 6: goto L_0x055e;
                case 7: goto L_0x054e;
                case 8: goto L_0x053f;
                case 9: goto L_0x052c;
                case 10: goto L_0x051b;
                case 11: goto L_0x050c;
                case 12: goto L_0x04fd;
                case 13: goto L_0x04ee;
                case 14: goto L_0x04df;
                case 15: goto L_0x04d0;
                case 16: goto L_0x04c1;
                case 17: goto L_0x04ad;
                case 18: goto L_0x049a;
                case 19: goto L_0x0486;
                case 20: goto L_0x0472;
                case 21: goto L_0x045e;
                case 22: goto L_0x044a;
                case 23: goto L_0x0436;
                case 24: goto L_0x0422;
                case 25: goto L_0x040e;
                case 26: goto L_0x03fb;
                case 27: goto L_0x03e3;
                case 28: goto L_0x03d0;
                case 29: goto L_0x03bc;
                case 30: goto L_0x03a8;
                case 31: goto L_0x0394;
                case 32: goto L_0x0380;
                case 33: goto L_0x036c;
                case 34: goto L_0x0358;
                case 35: goto L_0x0344;
                case 36: goto L_0x0330;
                case 37: goto L_0x031c;
                case 38: goto L_0x0308;
                case 39: goto L_0x02f4;
                case 40: goto L_0x02e0;
                case 41: goto L_0x02cc;
                case 42: goto L_0x02b8;
                case 43: goto L_0x02a4;
                case 44: goto L_0x0290;
                case 45: goto L_0x027c;
                case 46: goto L_0x0268;
                case 47: goto L_0x0254;
                case 48: goto L_0x0240;
                case 49: goto L_0x0228;
                case 50: goto L_0x021c;
                case 51: goto L_0x0207;
                case 52: goto L_0x01f2;
                case 53: goto L_0x01dd;
                case 54: goto L_0x01c8;
                case 55: goto L_0x01b3;
                case 56: goto L_0x019e;
                case 57: goto L_0x0189;
                case 58: goto L_0x0174;
                case 59: goto L_0x015f;
                case 60: goto L_0x0146;
                case 61: goto L_0x012f;
                case 62: goto L_0x011a;
                case 63: goto L_0x0105;
                case 64: goto L_0x00f0;
                case 65: goto L_0x00db;
                case 66: goto L_0x00c6;
                case 67: goto L_0x00b1;
                case 68: goto L_0x0097;
                default: goto L_0x0092;
            }
        L_0x0092:
            r12 = r17
            r13 = 0
            goto L_0x05c1
        L_0x0097:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00ae
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza((int) r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhd) r9)
            r13 = 0
            goto L_0x05c1
        L_0x00ae:
            r13 = 0
            goto L_0x05c1
        L_0x00b1:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00c3
            long r9 = zze(r1, r9)
            r2.zze((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x00c3:
            r13 = 0
            goto L_0x05c1
        L_0x00c6:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00d8
            int r4 = zzd(r1, r9)
            r2.zzf(r14, r4)
            r13 = 0
            goto L_0x05c1
        L_0x00d8:
            r13 = 0
            goto L_0x05c1
        L_0x00db:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00ed
            long r9 = zze(r1, r9)
            r2.zzb((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x00ed:
            r13 = 0
            goto L_0x05c1
        L_0x00f0:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0102
            int r4 = zzd(r1, r9)
            r2.zza((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0102:
            r13 = 0
            goto L_0x05c1
        L_0x0105:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0117
            int r4 = zzd(r1, r9)
            r2.zzb((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0117:
            r13 = 0
            goto L_0x05c1
        L_0x011a:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x012c
            int r4 = zzd(r1, r9)
            r2.zze((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x012c:
            r13 = 0
            goto L_0x05c1
        L_0x012f:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0143
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzdu r4 = (com.google.android.gms.internal.measurement.zzdu) r4
            r2.zza((int) r14, (com.google.android.gms.internal.measurement.zzdu) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0143:
            r13 = 0
            goto L_0x05c1
        L_0x0146:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x015c
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza((int) r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhd) r9)
            r13 = 0
            goto L_0x05c1
        L_0x015c:
            r13 = 0
            goto L_0x05c1
        L_0x015f:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0171
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzis) r2)
            r13 = 0
            goto L_0x05c1
        L_0x0171:
            r13 = 0
            goto L_0x05c1
        L_0x0174:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0186
            boolean r4 = zzf(r1, r9)
            r2.zza((int) r14, (boolean) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0186:
            r13 = 0
            goto L_0x05c1
        L_0x0189:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x019b
            int r4 = zzd(r1, r9)
            r2.zzd((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x019b:
            r13 = 0
            goto L_0x05c1
        L_0x019e:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01b0
            long r9 = zze(r1, r9)
            r2.zzd((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x01b0:
            r13 = 0
            goto L_0x05c1
        L_0x01b3:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01c5
            int r4 = zzd(r1, r9)
            r2.zzc((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x01c5:
            r13 = 0
            goto L_0x05c1
        L_0x01c8:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01da
            long r9 = zze(r1, r9)
            r2.zzc((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x01da:
            r13 = 0
            goto L_0x05c1
        L_0x01dd:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01ef
            long r9 = zze(r1, r9)
            r2.zza((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x01ef:
            r13 = 0
            goto L_0x05c1
        L_0x01f2:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0204
            float r4 = zzc(r1, r9)
            r2.zza((int) r14, (float) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0204:
            r13 = 0
            goto L_0x05c1
        L_0x0207:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0219
            double r9 = zzb(r1, (long) r9)
            r2.zza((int) r14, (double) r9)
            r13 = 0
            goto L_0x05c1
        L_0x0219:
            r13 = 0
            goto L_0x05c1
        L_0x021c:
            r12 = r17
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza((com.google.android.gms.internal.measurement.zzis) r2, (int) r14, (java.lang.Object) r4, (int) r12)
            r13 = 0
            goto L_0x05c1
        L_0x0228:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r10 = r0.zza((int) r12)
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzis) r2, (com.google.android.gms.internal.measurement.zzhd) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0240:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zze(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0254:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzj(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0268:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzg(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x027c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzl(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0290:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzm(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02a4:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzi(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02b8:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzn(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02cc:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzk(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02e0:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzf(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02f4:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzh(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0308:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzd(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x031c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzc(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0330:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzis) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0344:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.measurement.zzhf.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzis) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0358:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zze(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x036c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzj(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0380:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzg(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0394:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzl(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03a8:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzm(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03bc:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzi(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03d0:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzdu>) r9, (com.google.android.gms.internal.measurement.zzis) r2)
            r13 = 0
            goto L_0x05c1
        L_0x03e3:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r10 = r0.zza((int) r12)
            com.google.android.gms.internal.measurement.zzhf.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzis) r2, (com.google.android.gms.internal.measurement.zzhd) r10)
            r13 = 0
            goto L_0x05c1
        L_0x03fb:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzis) r2)
            r13 = 0
            goto L_0x05c1
        L_0x040e:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzn(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0422:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzk(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0436:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzf(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x044a:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzh(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x045e:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzd(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0472:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzc(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0486:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.measurement.zzhf.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzis) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x049a:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.measurement.zzhf.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzis) r2, (boolean) r13)
            goto L_0x05c1
        L_0x04ad:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza((int) r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhd) r9)
            goto L_0x05c1
        L_0x04c1:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zze((int) r14, (long) r9)
            goto L_0x05c1
        L_0x04d0:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x05c1
        L_0x04df:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zzb((int) r14, (long) r9)
            goto L_0x05c1
        L_0x04ee:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zza((int) r14, (int) r4)
            goto L_0x05c1
        L_0x04fd:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzb((int) r14, (int) r4)
            goto L_0x05c1
        L_0x050c:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zze((int) r14, (int) r4)
            goto L_0x05c1
        L_0x051b:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzdu r4 = (com.google.android.gms.internal.measurement.zzdu) r4
            r2.zza((int) r14, (com.google.android.gms.internal.measurement.zzdu) r4)
            goto L_0x05c1
        L_0x052c:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza((int) r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhd) r9)
            goto L_0x05c1
        L_0x053f:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzis) r2)
            goto L_0x05c1
        L_0x054e:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            boolean r4 = com.google.android.gms.internal.measurement.zzib.zzc(r1, r9)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x05c1
        L_0x055e:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzd((int) r14, (int) r4)
            goto L_0x05c1
        L_0x056c:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zzd((int) r14, (long) r9)
            goto L_0x05c1
        L_0x057a:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzc((int) r14, (int) r4)
            goto L_0x05c1
        L_0x0588:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zzc((int) r14, (long) r9)
            goto L_0x05c1
        L_0x0596:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zza((int) r14, (long) r9)
            goto L_0x05c1
        L_0x05a4:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            float r4 = com.google.android.gms.internal.measurement.zzib.zzd(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x05c1
        L_0x05b3:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            double r9 = com.google.android.gms.internal.measurement.zzib.zze(r1, r9)
            r2.zza((int) r14, (double) r9)
        L_0x05c1:
            int r10 = r12 + 3
            goto L_0x0030
        L_0x05c5:
            if (r5 == 0) goto L_0x05dc
            com.google.android.gms.internal.measurement.zzes<?> r4 = r0.zzr
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x05da
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x05c5
        L_0x05da:
            r5 = 0
            goto L_0x05c5
        L_0x05dc:
            com.google.android.gms.internal.measurement.zzhv<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.measurement.zzis) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void");
    }

    private final <K, V> void zza(zzis zzis, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzis.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzhv<UT, UB> zzhv, T t, zzis zzis) throws IOException {
        zzhv.zza(zzhv.zzb(t), zzis);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzhe r14, com.google.android.gms.internal.measurement.zzeq r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x0623
            com.google.android.gms.internal.measurement.zzhv<?, ?> r8 = r12.zzq
            com.google.android.gms.internal.measurement.zzes<?> r9 = r12.zzr
            r1 = r0
            r10 = r1
        L_0x000a:
            int r2 = r14.zza()     // Catch:{ all -> 0x060b }
            int r3 = r12.zzg(r2)     // Catch:{ all -> 0x060b }
            if (r3 >= 0) goto L_0x007b
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x0030
            int r14 = r12.zzm
        L_0x001b:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x002a
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x002a:
            if (r10 == 0) goto L_0x002f
            r8.zzb((java.lang.Object) r13, r10)
        L_0x002f:
            return
        L_0x0030:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x060b }
            if (r3 != 0) goto L_0x0036
            r3 = r0
            goto L_0x003d
        L_0x0036:
            com.google.android.gms.internal.measurement.zzgo r3 = r12.zzg     // Catch:{ all -> 0x060b }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x060b }
            r3 = r2
        L_0x003d:
            if (r3 == 0) goto L_0x0055
            if (r1 != 0) goto L_0x0047
            com.google.android.gms.internal.measurement.zzew r1 = r9.zzb(r13)     // Catch:{ all -> 0x060b }
            r11 = r1
            goto L_0x0048
        L_0x0047:
            r11 = r1
        L_0x0048:
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x060b }
            r1 = r11
            goto L_0x000a
        L_0x0055:
            r8.zza((com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r10 != 0) goto L_0x005e
            java.lang.Object r10 = r8.zzc(r13)     // Catch:{ all -> 0x060b }
        L_0x005e:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r2 != 0) goto L_0x000a
            int r14 = r12.zzm
        L_0x0066:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0075
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0066
        L_0x0075:
            if (r10 == 0) goto L_0x007a
            r8.zzb((java.lang.Object) r13, r10)
        L_0x007a:
            return
        L_0x007b:
            int r4 = r12.zzd((int) r3)     // Catch:{ all -> 0x060b }
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x05b2;
                case 1: goto L_0x05a2;
                case 2: goto L_0x0592;
                case 3: goto L_0x0582;
                case 4: goto L_0x0572;
                case 5: goto L_0x0562;
                case 6: goto L_0x0552;
                case 7: goto L_0x0542;
                case 8: goto L_0x053a;
                case 9: goto L_0x0504;
                case 10: goto L_0x04f4;
                case 11: goto L_0x04e4;
                case 12: goto L_0x04c0;
                case 13: goto L_0x04b0;
                case 14: goto L_0x04a0;
                case 15: goto L_0x0490;
                case 16: goto L_0x0480;
                case 17: goto L_0x044a;
                case 18: goto L_0x043c;
                case 19: goto L_0x042e;
                case 20: goto L_0x0420;
                case 21: goto L_0x0412;
                case 22: goto L_0x0404;
                case 23: goto L_0x03f6;
                case 24: goto L_0x03e8;
                case 25: goto L_0x03da;
                case 26: goto L_0x03b7;
                case 27: goto L_0x03a1;
                case 28: goto L_0x0393;
                case 29: goto L_0x0385;
                case 30: goto L_0x036f;
                case 31: goto L_0x0361;
                case 32: goto L_0x0353;
                case 33: goto L_0x0345;
                case 34: goto L_0x0337;
                case 35: goto L_0x0329;
                case 36: goto L_0x031b;
                case 37: goto L_0x030d;
                case 38: goto L_0x02ff;
                case 39: goto L_0x02f1;
                case 40: goto L_0x02e3;
                case 41: goto L_0x02d5;
                case 42: goto L_0x02c7;
                case 43: goto L_0x02b9;
                case 44: goto L_0x02a3;
                case 45: goto L_0x0295;
                case 46: goto L_0x0287;
                case 47: goto L_0x0279;
                case 48: goto L_0x026b;
                case 49: goto L_0x0256;
                case 50: goto L_0x0212;
                case 51: goto L_0x01ff;
                case 52: goto L_0x01ec;
                case 53: goto L_0x01d9;
                case 54: goto L_0x01c6;
                case 55: goto L_0x01b3;
                case 56: goto L_0x01a0;
                case 57: goto L_0x018d;
                case 58: goto L_0x017a;
                case 59: goto L_0x0172;
                case 60: goto L_0x013c;
                case 61: goto L_0x012d;
                case 62: goto L_0x011a;
                case 63: goto L_0x00f3;
                case 64: goto L_0x00e0;
                case 65: goto L_0x00cd;
                case 66: goto L_0x00ba;
                case 67: goto L_0x00a7;
                case 68: goto L_0x0093;
                default: goto L_0x008b;
            }
        L_0x008b:
            if (r10 != 0) goto L_0x05c2
            java.lang.Object r10 = r8.zza()     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x05c2
        L_0x0093:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r6 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00a7:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzt()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00ba:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzs()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00cd:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzr()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00e0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzq()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x00f3:
            int r5 = r14.zzp()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r7 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x010b
            boolean r7 = r7.zza(r5)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x0104
            goto L_0x010b
        L_0x0104:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x010b:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r6, (java.lang.Object) r4)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x011a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzo()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x012d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzdu r6 = r14.zzn()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x013c:
            boolean r5 = r12.zza(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r5 == 0) goto L_0x015b
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r7 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x016d
        L_0x015b:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r6 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
        L_0x016d:
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0172:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x017a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            boolean r6 = r14.zzk()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x018d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzj()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01a0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzi()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01b3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            int r6 = r14.zzh()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01c6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzf()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01d9:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzg()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01ec:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            float r6 = r14.zze()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x01ff:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            double r6 = r14.zzd()     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0212:
            java.lang.Object r2 = r12.zzb((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            int r3 = r12.zzd((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r5 != 0) goto L_0x022d
            com.google.android.gms.internal.measurement.zzgh r5 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r5 = r5.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x0245
        L_0x022d:
            com.google.android.gms.internal.measurement.zzgh r6 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            boolean r6 = r6.zzc(r5)     // Catch:{ zzfn -> 0x05e1 }
            if (r6 == 0) goto L_0x0245
            com.google.android.gms.internal.measurement.zzgh r6 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r6 = r6.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzgh r7 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            r7.zza(r6, r5)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r6)     // Catch:{ zzfn -> 0x05e1 }
            r5 = r6
        L_0x0245:
            com.google.android.gms.internal.measurement.zzgh r3 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            java.util.Map r3 = r3.zza(r5)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzgh r4 = r12.zzs     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzgf r2 = r4.zzf(r2)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzeq) r15)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0256:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfy r3 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzb(r3, r2, r15)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x026b:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzq(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0279:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzp(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0287:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzo(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0295:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzn(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02a3:
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzm(r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r3 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r4, r3, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02b9:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzl(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02c7:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzh(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02d5:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzg(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02e3:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzf(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02f1:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x02ff:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzc(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x030d:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzd(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x031b:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzb(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0329:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0337:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzq(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0345:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzp(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0353:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzo(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0361:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzn(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x036f:
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzm(r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r3 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r4, r3, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0385:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzl(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0393:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzk(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03a1:
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r3, r2, (com.google.android.gms.internal.measurement.zzeq) r15)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03b7:
            boolean r2 = zzf(r4)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 == 0) goto L_0x03cc
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzj(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03cc:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzi(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03da:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzh(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03e8:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzg(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x03f6:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzf(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0404:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zze(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0412:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzc(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0420:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzd(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x042e:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zzb(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x043c:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x05e1 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x05e1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x05e1 }
            r14.zza(r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x044a:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 == 0) goto L_0x046b
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r3 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x046b:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0480:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzt()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0490:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzs()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04a0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzr()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04b0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzq()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04c0:
            int r5 = r14.zzp()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzfk r7 = r12.zzc((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x04d8
            boolean r7 = r7.zza(r5)     // Catch:{ zzfn -> 0x05e1 }
            if (r7 == 0) goto L_0x04d1
            goto L_0x04d8
        L_0x04d1:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04d8:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r6, (int) r5)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04e4:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzo()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x04f4:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzdu r2 = r14.zzn()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0504:
            boolean r2 = r12.zza(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 == 0) goto L_0x0525
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r3 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0525:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza((int) r3)     // Catch:{ zzfn -> 0x05e1 }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x053a:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0542:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            boolean r2 = r14.zzk()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (boolean) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0552:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzj()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0562:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzi()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0572:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            int r2 = r14.zzh()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0582:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzf()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x0592:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            long r6 = r14.zzg()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x05a2:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            float r2 = r14.zze()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (float) r2)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x05b2:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x05e1 }
            double r6 = r14.zzd()     // Catch:{ zzfn -> 0x05e1 }
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r13, (long) r4, (double) r6)     // Catch:{ zzfn -> 0x05e1 }
            r12.zzb(r13, (int) r3)     // Catch:{ zzfn -> 0x05e1 }
            goto L_0x000a
        L_0x05c2:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ zzfn -> 0x05e1 }
            if (r2 != 0) goto L_0x05df
            int r14 = r12.zzm
        L_0x05ca:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x05d9
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05ca
        L_0x05d9:
            if (r10 == 0) goto L_0x05de
            r8.zzb((java.lang.Object) r13, r10)
        L_0x05de:
            return
        L_0x05df:
            goto L_0x000a
        L_0x05e1:
            r2 = move-exception
            r8.zza((com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r10 != 0) goto L_0x05ec
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x060b }
            r10 = r2
        L_0x05ec:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.measurement.zzhe) r14)     // Catch:{ all -> 0x060b }
            if (r2 != 0) goto L_0x0609
            int r14 = r12.zzm
        L_0x05f4:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0603
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05f4
        L_0x0603:
            if (r10 == 0) goto L_0x0608
            r8.zzb((java.lang.Object) r13, r10)
        L_0x0608:
            return
        L_0x0609:
            goto L_0x000a
        L_0x060b:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x060e:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x061d
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x060e
        L_0x061d:
            if (r10 == 0) goto L_0x0622
            r8.zzb((java.lang.Object) r13, r10)
        L_0x0622:
            throw r14
        L_0x0623:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhe, com.google.android.gms.internal.measurement.zzeq):void");
    }

    private static zzhy zze(Object obj) {
        zzfd zzfd = (zzfd) obj;
        zzhy zzhy = zzfd.zzb;
        if (zzhy != zzhy.zza()) {
            return zzhy;
        }
        zzhy zzb2 = zzhy.zzb();
        zzfd.zzb = zzb2;
        return zzb2;
    }

    private static int zza(byte[] bArr, int i, int i2, zzim zzim, Class<?> cls, zzdt zzdt) throws IOException {
        switch (zzgr.zza[zzim.ordinal()]) {
            case 1:
                int zzb2 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Boolean.valueOf(zzdt.zzb != 0);
                return zzb2;
            case 2:
                return zzdq.zze(bArr, i, zzdt);
            case 3:
                zzdt.zzc = Double.valueOf(zzdq.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzdt.zzc = Integer.valueOf(zzdq.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzdt.zzc = Long.valueOf(zzdq.zzb(bArr, i));
                return i + 8;
            case 8:
                zzdt.zzc = Float.valueOf(zzdq.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzdq.zza(bArr, i, zzdt);
                zzdt.zzc = Integer.valueOf(zzdt.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Long.valueOf(zzdt.zzb);
                return zzb3;
            case 14:
                return zzdq.zza((zzhd) zzgz.zza().zza(cls), bArr, i, i2, zzdt);
            case 15:
                int zza3 = zzdq.zza(bArr, i, zzdt);
                zzdt.zzc = Integer.valueOf(zzeg.zze(zzdt.zza));
                return zza3;
            case 16:
                int zzb4 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Long.valueOf(zzeg.zza(zzdt.zzb));
                return zzb4;
            case 17:
                return zzdq.zzd(bArr, i, zzdt);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzdt zzdt) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i5;
        int i16 = i6;
        long j3 = j2;
        zzdt zzdt2 = zzdt;
        zzfl zzfl = (zzfl) zzb.getObject(t2, j3);
        if (!zzfl.zza()) {
            int size = zzfl.size();
            zzfl = zzfl.zza(size == 0 ? 10 : size << 1);
            zzb.putObject(t2, j3, zzfl);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i15 == 2) {
                    zzeo zzeo = (zzeo) zzfl;
                    int zza2 = zzdq.zza(bArr2, i12, zzdt2);
                    int i17 = zzdt2.zza + zza2;
                    while (zza2 < i17) {
                        zzeo.zza(zzdq.zzc(bArr2, zza2));
                        zza2 += 8;
                    }
                    if (zza2 == i17) {
                        return zza2;
                    }
                    throw zzfo.zza();
                } else if (i15 == 1) {
                    zzeo zzeo2 = (zzeo) zzfl;
                    zzeo2.zza(zzdq.zzc(bArr, i));
                    int i18 = i12 + 8;
                    while (i18 < i13) {
                        int zza3 = zzdq.zza(bArr2, i18, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i18;
                        }
                        zzeo2.zza(zzdq.zzc(bArr2, zza3));
                        i18 = zza3 + 8;
                    }
                    return i18;
                }
                break;
            case 19:
            case 36:
                if (i15 == 2) {
                    zzfc zzfc = (zzfc) zzfl;
                    int zza4 = zzdq.zza(bArr2, i12, zzdt2);
                    int i19 = zzdt2.zza + zza4;
                    while (zza4 < i19) {
                        zzfc.zza(zzdq.zzd(bArr2, zza4));
                        zza4 += 4;
                    }
                    if (zza4 == i19) {
                        return zza4;
                    }
                    throw zzfo.zza();
                } else if (i15 == 5) {
                    zzfc zzfc2 = (zzfc) zzfl;
                    zzfc2.zza(zzdq.zzd(bArr, i));
                    int i20 = i12 + 4;
                    while (i20 < i13) {
                        int zza5 = zzdq.zza(bArr2, i20, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i20;
                        }
                        zzfc2.zza(zzdq.zzd(bArr2, zza5));
                        i20 = zza5 + 4;
                    }
                    return i20;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    zzgc zzgc = (zzgc) zzfl;
                    int zza6 = zzdq.zza(bArr2, i12, zzdt2);
                    int i21 = zzdt2.zza + zza6;
                    while (zza6 < i21) {
                        zza6 = zzdq.zzb(bArr2, zza6, zzdt2);
                        zzgc.zza(zzdt2.zzb);
                    }
                    if (zza6 == i21) {
                        return zza6;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzgc zzgc2 = (zzgc) zzfl;
                    int zzb2 = zzdq.zzb(bArr2, i12, zzdt2);
                    zzgc2.zza(zzdt2.zzb);
                    while (zzb2 < i13) {
                        int zza7 = zzdq.zza(bArr2, zzb2, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zzb2;
                        }
                        zzb2 = zzdq.zzb(bArr2, zza7, zzdt2);
                        zzgc2.zza(zzdt2.zzb);
                    }
                    return zzb2;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i15 == 2) {
                    return zzdq.zza(bArr2, i12, (zzfl<?>) zzfl, zzdt2);
                }
                if (i15 == 0) {
                    return zzdq.zza(i3, bArr, i, i2, (zzfl<?>) zzfl, zzdt);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i15 == 2) {
                    zzgc zzgc3 = (zzgc) zzfl;
                    int zza8 = zzdq.zza(bArr2, i12, zzdt2);
                    int i22 = zzdt2.zza + zza8;
                    while (zza8 < i22) {
                        zzgc3.zza(zzdq.zzb(bArr2, zza8));
                        zza8 += 8;
                    }
                    if (zza8 == i22) {
                        return zza8;
                    }
                    throw zzfo.zza();
                } else if (i15 == 1) {
                    zzgc zzgc4 = (zzgc) zzfl;
                    zzgc4.zza(zzdq.zzb(bArr, i));
                    int i23 = i12 + 8;
                    while (i23 < i13) {
                        int zza9 = zzdq.zza(bArr2, i23, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i23;
                        }
                        zzgc4.zza(zzdq.zzb(bArr2, zza9));
                        i23 = zza9 + 8;
                    }
                    return i23;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i15 == 2) {
                    zzfg zzfg = (zzfg) zzfl;
                    int zza10 = zzdq.zza(bArr2, i12, zzdt2);
                    int i24 = zzdt2.zza + zza10;
                    while (zza10 < i24) {
                        zzfg.zzd(zzdq.zza(bArr2, zza10));
                        zza10 += 4;
                    }
                    if (zza10 == i24) {
                        return zza10;
                    }
                    throw zzfo.zza();
                } else if (i15 == 5) {
                    zzfg zzfg2 = (zzfg) zzfl;
                    zzfg2.zzd(zzdq.zza(bArr, i));
                    int i25 = i12 + 4;
                    while (i25 < i13) {
                        int zza11 = zzdq.zza(bArr2, i25, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return i25;
                        }
                        zzfg2.zzd(zzdq.zza(bArr2, zza11));
                        i25 = zza11 + 4;
                    }
                    return i25;
                }
                break;
            case 25:
            case 42:
                if (i15 == 2) {
                    zzds zzds = (zzds) zzfl;
                    int zza12 = zzdq.zza(bArr2, i12, zzdt2);
                    int i26 = zzdt2.zza + zza12;
                    while (zza12 < i26) {
                        zza12 = zzdq.zzb(bArr2, zza12, zzdt2);
                        zzds.zza(zzdt2.zzb != 0);
                    }
                    if (zza12 == i26) {
                        return zza12;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzds zzds2 = (zzds) zzfl;
                    int zzb3 = zzdq.zzb(bArr2, i12, zzdt2);
                    zzds2.zza(zzdt2.zzb != 0);
                    while (zzb3 < i13) {
                        int zza13 = zzdq.zza(bArr2, zzb3, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zzb3;
                        }
                        zzb3 = zzdq.zzb(bArr2, zza13, zzdt2);
                        zzds2.zza(zzdt2.zzb != 0);
                    }
                    return zzb3;
                }
                break;
            case 26:
                if (i15 == 2) {
                    if ((j & 536870912) == 0) {
                        int zza14 = zzdq.zza(bArr2, i12, zzdt2);
                        int i27 = zzdt2.zza;
                        if (i27 >= 0) {
                            if (i27 == 0) {
                                zzfl.add("");
                            } else {
                                zzfl.add(new String(bArr2, zza14, i27, zzff.zza));
                                zza14 += i27;
                            }
                            while (i9 < i13) {
                                int zza15 = zzdq.zza(bArr2, i9, zzdt2);
                                if (i14 != zzdt2.zza) {
                                    return i9;
                                }
                                i9 = zzdq.zza(bArr2, zza15, zzdt2);
                                int i28 = zzdt2.zza;
                                if (i28 < 0) {
                                    throw zzfo.zzb();
                                } else if (i28 == 0) {
                                    zzfl.add("");
                                } else {
                                    zzfl.add(new String(bArr2, i9, i28, zzff.zza));
                                    i9 += i28;
                                }
                            }
                            return i9;
                        }
                        throw zzfo.zzb();
                    }
                    int zza16 = zzdq.zza(bArr2, i12, zzdt2);
                    int i29 = zzdt2.zza;
                    if (i29 >= 0) {
                        if (i29 == 0) {
                            zzfl.add("");
                        } else {
                            int i30 = zza16 + i29;
                            if (zzie.zza(bArr2, zza16, i30)) {
                                zzfl.add(new String(bArr2, zza16, i29, zzff.zza));
                                zza16 = i30;
                            } else {
                                throw zzfo.zzh();
                            }
                        }
                        while (i8 < i13) {
                            int zza17 = zzdq.zza(bArr2, i8, zzdt2);
                            if (i14 != zzdt2.zza) {
                                return i8;
                            }
                            i8 = zzdq.zza(bArr2, zza17, zzdt2);
                            int i31 = zzdt2.zza;
                            if (i31 < 0) {
                                throw zzfo.zzb();
                            } else if (i31 == 0) {
                                zzfl.add("");
                            } else {
                                int i32 = i8 + i31;
                                if (zzie.zza(bArr2, i8, i32)) {
                                    zzfl.add(new String(bArr2, i8, i31, zzff.zza));
                                    i8 = i32;
                                } else {
                                    throw zzfo.zzh();
                                }
                            }
                        }
                        return i8;
                    }
                    throw zzfo.zzb();
                }
                break;
            case 27:
                if (i15 == 2) {
                    return zzdq.zza(zza(i16), i3, bArr, i, i2, zzfl, zzdt);
                }
                break;
            case 28:
                if (i15 == 2) {
                    int zza18 = zzdq.zza(bArr2, i12, zzdt2);
                    int i33 = zzdt2.zza;
                    if (i33 < 0) {
                        throw zzfo.zzb();
                    } else if (i33 <= bArr2.length - zza18) {
                        if (i33 == 0) {
                            zzfl.add(zzdu.zza);
                        } else {
                            zzfl.add(zzdu.zza(bArr2, zza18, i33));
                            zza18 += i33;
                        }
                        while (i10 < i13) {
                            int zza19 = zzdq.zza(bArr2, i10, zzdt2);
                            if (i14 != zzdt2.zza) {
                                return i10;
                            }
                            i10 = zzdq.zza(bArr2, zza19, zzdt2);
                            int i34 = zzdt2.zza;
                            if (i34 < 0) {
                                throw zzfo.zzb();
                            } else if (i34 > bArr2.length - i10) {
                                throw zzfo.zza();
                            } else if (i34 == 0) {
                                zzfl.add(zzdu.zza);
                            } else {
                                zzfl.add(zzdu.zza(bArr2, i10, i34));
                                i10 += i34;
                            }
                        }
                        return i10;
                    } else {
                        throw zzfo.zza();
                    }
                }
                break;
            case 30:
            case 44:
                if (i15 == 2) {
                    i11 = zzdq.zza(bArr2, i12, (zzfl<?>) zzfl, zzdt2);
                } else if (i15 == 0) {
                    i11 = zzdq.zza(i3, bArr, i, i2, (zzfl<?>) zzfl, zzdt);
                }
                zzfd zzfd = (zzfd) t2;
                zzhy zzhy = zzfd.zzb;
                if (zzhy == zzhy.zza()) {
                    zzhy = null;
                }
                zzhy zzhy2 = (zzhy) zzhf.zza(i4, zzfl, zzc(i16), zzhy, this.zzq);
                if (zzhy2 != null) {
                    zzfd.zzb = zzhy2;
                }
                return i11;
            case 33:
            case 47:
                if (i15 == 2) {
                    zzfg zzfg3 = (zzfg) zzfl;
                    int zza20 = zzdq.zza(bArr2, i12, zzdt2);
                    int i35 = zzdt2.zza + zza20;
                    while (zza20 < i35) {
                        zza20 = zzdq.zza(bArr2, zza20, zzdt2);
                        zzfg3.zzd(zzeg.zze(zzdt2.zza));
                    }
                    if (zza20 == i35) {
                        return zza20;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzfg zzfg4 = (zzfg) zzfl;
                    int zza21 = zzdq.zza(bArr2, i12, zzdt2);
                    zzfg4.zzd(zzeg.zze(zzdt2.zza));
                    while (zza21 < i13) {
                        int zza22 = zzdq.zza(bArr2, zza21, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zza21;
                        }
                        zza21 = zzdq.zza(bArr2, zza22, zzdt2);
                        zzfg4.zzd(zzeg.zze(zzdt2.zza));
                    }
                    return zza21;
                }
                break;
            case 34:
            case 48:
                if (i15 == 2) {
                    zzgc zzgc5 = (zzgc) zzfl;
                    int zza23 = zzdq.zza(bArr2, i12, zzdt2);
                    int i36 = zzdt2.zza + zza23;
                    while (zza23 < i36) {
                        zza23 = zzdq.zzb(bArr2, zza23, zzdt2);
                        zzgc5.zza(zzeg.zza(zzdt2.zzb));
                    }
                    if (zza23 == i36) {
                        return zza23;
                    }
                    throw zzfo.zza();
                } else if (i15 == 0) {
                    zzgc zzgc6 = (zzgc) zzfl;
                    int zzb4 = zzdq.zzb(bArr2, i12, zzdt2);
                    zzgc6.zza(zzeg.zza(zzdt2.zzb));
                    while (zzb4 < i13) {
                        int zza24 = zzdq.zza(bArr2, zzb4, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zzb4;
                        }
                        zzb4 = zzdq.zzb(bArr2, zza24, zzdt2);
                        zzgc6.zza(zzeg.zza(zzdt2.zzb));
                    }
                    return zzb4;
                }
                break;
            case 49:
                if (i15 == 3) {
                    zzhd zza25 = zza(i16);
                    int i37 = (i14 & -8) | 4;
                    int zza26 = zzdq.zza(zza25, bArr, i, i2, i37, zzdt);
                    zzfl.add(zzdt2.zzc);
                    while (zza26 < i13) {
                        int zza27 = zzdq.zza(bArr2, zza26, zzdt2);
                        if (i14 != zzdt2.zza) {
                            return zza26;
                        }
                        zza26 = zzdq.zza(zza25, bArr, zza27, i2, i37, zzdt);
                        zzfl.add(zzdt2.zzc);
                    }
                    return zza26;
                }
                break;
        }
        return i12;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzdt r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r12 = r7.zzb((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zzgh r2 = r7.zzs
            boolean r2 = r2.zzc(r1)
            if (r2 == 0) goto L_0x0022
            com.google.android.gms.internal.measurement.zzgh r2 = r7.zzs
            java.lang.Object r2 = r2.zze(r12)
            com.google.android.gms.internal.measurement.zzgh r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0022:
            com.google.android.gms.internal.measurement.zzgh r8 = r7.zzs
            com.google.android.gms.internal.measurement.zzgf r8 = r8.zzf(r12)
            com.google.android.gms.internal.measurement.zzgh r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.measurement.zzdq.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x009c
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x009c
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x0040:
            if (r10 >= r13) goto L_0x0090
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x0050
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.measurement.zzdt) r15)
            int r10 = r15.zza
            r2 = r1
            goto L_0x0051
        L_0x0050:
            r2 = r1
        L_0x0051:
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0076
            r4 = 2
            if (r1 == r4) goto L_0x005c
            goto L_0x008b
        L_0x005c:
            com.google.android.gms.internal.measurement.zzim r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x008b
            com.google.android.gms.internal.measurement.zzim r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzim) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzdt) r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x0040
        L_0x0076:
            com.google.android.gms.internal.measurement.zzim r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x008b
            com.google.android.gms.internal.measurement.zzim r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzim) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzdt) r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x0040
        L_0x008b:
            int r10 = com.google.android.gms.internal.measurement.zzdq.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.measurement.zzdt) r15)
            goto L_0x0040
        L_0x0090:
            if (r10 != r13) goto L_0x0097
            r12.put(r14, r0)
            return r13
        L_0x0097:
            com.google.android.gms.internal.measurement.zzfo r8 = com.google.android.gms.internal.measurement.zzfo.zzg()
            throw r8
        L_0x009c:
            com.google.android.gms.internal.measurement.zzfo r8 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzdt):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a4, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.measurement.zzdt r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0193;
                case 52: goto L_0x0183;
                case 53: goto L_0x0173;
                case 54: goto L_0x0173;
                case 55: goto L_0x0163;
                case 56: goto L_0x0152;
                case 57: goto L_0x0142;
                case 58: goto L_0x0129;
                case 59: goto L_0x00f5;
                case 60: goto L_0x00c6;
                case 61: goto L_0x00b9;
                case 62: goto L_0x0163;
                case 63: goto L_0x008b;
                case 64: goto L_0x0142;
                case 65: goto L_0x0152;
                case 66: goto L_0x0076;
                case 67: goto L_0x0061;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a8
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a8
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.measurement.zzhd r2 = r0.zza((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza((com.google.android.gms.internal.measurement.zzhd) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.measurement.zzdt) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004c
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004d
        L_0x004c:
            r15 = 0
        L_0x004d:
            if (r15 != 0) goto L_0x0056
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0056:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0061:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.measurement.zzeg.zza((long) r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0076:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzeg.zze(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x008b:
            if (r5 != 0) goto L_0x01a8
            int r3 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.measurement.zzfk r5 = r0.zzc((int) r6)
            if (r5 == 0) goto L_0x00af
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x00a0
            goto L_0x00af
        L_0x00a0:
            com.google.android.gms.internal.measurement.zzhy r1 = zze((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zza((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x01a9
        L_0x00af:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x01a4
        L_0x00b9:
            if (r5 != r15) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x00c6:
            if (r5 != r15) goto L_0x01a8
            com.google.android.gms.internal.measurement.zzhd r2 = r0.zza((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza((com.google.android.gms.internal.measurement.zzhd) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzdt) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00de
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00df
        L_0x00de:
            r15 = 0
        L_0x00df:
            if (r15 != 0) goto L_0x00e7
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x00f0
        L_0x00e7:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00f0:
            r12.putInt(r1, r13, r8)
            goto L_0x01a9
        L_0x00f5:
            if (r5 != r15) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x0105
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0124
        L_0x0105:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0119
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.measurement.zzie.zza((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0114
            goto L_0x0119
        L_0x0114:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzh()
            throw r1
        L_0x0119:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.zzff.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0124:
            r12.putInt(r1, r13, r8)
            goto L_0x01a9
        L_0x0129:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0139
            r15 = 1
            goto L_0x013a
        L_0x0139:
            r15 = 0
        L_0x013a:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0142:
            if (r5 != r7) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x01a4
        L_0x0152:
            r2 = 1
            if (r5 != r2) goto L_0x01a8
            long r2 = com.google.android.gms.internal.measurement.zzdq.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
            goto L_0x01a4
        L_0x0163:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r11)
            int r3 = r11.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0173:
            if (r5 != 0) goto L_0x01a8
            int r2 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r11)
            long r3 = r11.zzb
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a4
        L_0x0183:
            if (r5 != r7) goto L_0x01a8
            float r2 = com.google.android.gms.internal.measurement.zzdq.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x01a4
        L_0x0193:
            r2 = 1
            if (r5 != r2) goto L_0x01a8
            double r2 = com.google.android.gms.internal.measurement.zzdq.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x01a4:
            r12.putInt(r1, r13, r8)
            goto L_0x01a9
        L_0x01a8:
            r2 = r4
        L_0x01a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.measurement.zzdt):int");
    }

    private final zzhd zza(int i) {
        int i2 = (i / 3) << 1;
        zzhd zzhd = (zzhd) this.zzd[i2];
        if (zzhd != null) {
            return zzhd;
        }
        zzhd zza2 = zzgz.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzfk zzc(int i) {
        return (zzfk) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzdt r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x001b:
            if (r0 >= r13) goto L_0x0561
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzdt) r9)
            int r3 = r9.zza
            r4 = r0
            r5 = r3
            goto L_0x002e
        L_0x002c:
            r5 = r0
            r4 = r3
        L_0x002e:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003c
            int r2 = r2 / r8
            int r1 = r15.zza((int) r3, (int) r2)
            r2 = r1
            goto L_0x0041
        L_0x003c:
            int r1 = r15.zzg(r3)
            r2 = r1
        L_0x0041:
            r1 = -1
            if (r2 != r1) goto L_0x0050
            r24 = r3
            r2 = r4
            r25 = r5
            r26 = r10
            r18 = 0
            goto L_0x04b6
        L_0x0050:
            int[] r1 = r15.zzc
            int r18 = r2 + 1
            r8 = r1[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r5
            r5 = r8 & r18
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x0380
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r18
            if (r1 == r7) goto L_0x008a
            r5 = -1
            if (r7 == r5) goto L_0x0082
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0082:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
            goto L_0x008b
        L_0x008a:
            r5 = -1
        L_0x008b:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x034b;
                case 1: goto L_0x0324;
                case 2: goto L_0x02f9;
                case 3: goto L_0x02f9;
                case 4: goto L_0x02d2;
                case 5: goto L_0x029e;
                case 6: goto L_0x0276;
                case 7: goto L_0x0241;
                case 8: goto L_0x020d;
                case 9: goto L_0x01ca;
                case 10: goto L_0x01a2;
                case 11: goto L_0x02d2;
                case 12: goto L_0x0158;
                case 13: goto L_0x0276;
                case 14: goto L_0x029e;
                case 15: goto L_0x012d;
                case 16: goto L_0x00f5;
                case 17: goto L_0x009e;
                default: goto L_0x008f;
            }
        L_0x008f:
            r12 = r31
            r13 = r35
            r9 = r2
            r11 = r3
            r32 = r7
            r8 = r19
            r18 = -1
            r7 = r4
            goto L_0x0373
        L_0x009e:
            r1 = 3
            if (r0 != r1) goto L_0x00e5
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza((int) r2)
            r1 = r31
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r33
            r4 = r8
            r8 = r19
            r18 = -1
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((com.google.android.gms.internal.measurement.zzhd) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.measurement.zzdt) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00c8
            r5 = r35
            java.lang.Object r1 = r5.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x00d7
        L_0x00c8:
            r5 = r35
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r12, r1)
        L_0x00d7:
            r6 = r6 | r22
            r12 = r31
            r13 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r34
            r9 = r5
            goto L_0x001b
        L_0x00e5:
            r5 = r35
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r5
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x00f5:
            r5 = r35
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            if (r0 != 0) goto L_0x0125
            r2 = r12
            r12 = r31
            int r13 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r4, r5)
            long r0 = r5.zzb
            long r19 = com.google.android.gms.internal.measurement.zzeg.zza((long) r0)
            r0 = r10
            r1 = r30
            r32 = r13
            r13 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r32
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x0125:
            r12 = r31
            r13 = r5
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x012d:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0153
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r4, r13)
            int r1 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzeg.zze(r1)
            r10.putInt(r14, r2, r1)
            r6 = r6 | r22
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x0153:
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x0158:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x019d
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r4, r13)
            int r1 = r13.zza
            com.google.android.gms.internal.measurement.zzfk r4 = r15.zzc((int) r9)
            if (r4 == 0) goto L_0x018e
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x0178
            goto L_0x018e
        L_0x0178:
            com.google.android.gms.internal.measurement.zzhy r2 = zze((java.lang.Object) r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza((int) r8, (java.lang.Object) r1)
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x018e:
            r10.putInt(r14, r2, r1)
            r6 = r6 | r22
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x019d:
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x01a2:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r1 = 2
            if (r0 != r1) goto L_0x01c5
            int r0 = com.google.android.gms.internal.measurement.zzdq.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
            r6 = r6 | r22
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x01c5:
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x01ca:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r1 = 2
            if (r0 != r1) goto L_0x0206
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza((int) r9)
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((com.google.android.gms.internal.measurement.zzhd) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzdt) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01ed
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x01fb
        L_0x01ed:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
        L_0x01fb:
            r6 = r6 | r22
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x001b
        L_0x0206:
            r5 = r33
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x020d:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r1 = 2
            if (r0 != r1) goto L_0x023c
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x0228
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r4, r13)
            goto L_0x022c
        L_0x0228:
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r4, r13)
        L_0x022c:
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
            r6 = r6 | r22
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x001b
        L_0x023c:
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x0241:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0271
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r4, r13)
            r32 = r0
            long r0 = r13.zzb
            r19 = 0
            int r4 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x0260
            r0 = 1
            goto L_0x0261
        L_0x0260:
            r0 = 0
        L_0x0261:
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r6 = r6 | r22
            r0 = r32
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x001b
        L_0x0271:
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x0276:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0299
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
            r6 = r6 | r22
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x001b
        L_0x0299:
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x029e:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r1 = 1
            if (r0 != r1) goto L_0x02cd
            long r19 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r4)
            r0 = r10
            r1 = r30
            r32 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            r6 = r6 | r22
            r7 = r32
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x02cd:
            r32 = r7
            r7 = r4
            goto L_0x0373
        L_0x02d2:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x0373
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r7, r13)
            int r1 = r13.zza
            r10.putInt(r14, r2, r1)
            r6 = r6 | r22
            r7 = r32
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x02f9:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x0373
            int r7 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r7, r13)
            long r4 = r13.zzb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r32
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x0324:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x0373
            float r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r7)
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            r6 = r6 | r22
            r7 = r32
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x034b:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            r1 = 1
            if (r0 != r1) goto L_0x0373
            double r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r7)
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r2, (double) r0)
            int r0 = r7 + 8
            r6 = r6 | r22
            r7 = r32
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r13 = r33
            r11 = r34
            goto L_0x001b
        L_0x0373:
            r2 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            r24 = r11
            r7 = r32
            goto L_0x04b6
        L_0x0380:
            r5 = r3
            r17 = r7
            r8 = r19
            r18 = -1
            r7 = r4
            r27 = r12
            r12 = r31
            r13 = r9
            r9 = r2
            r2 = r27
            r1 = 27
            if (r11 != r1) goto L_0x03ea
            r1 = 2
            if (r0 != r1) goto L_0x03dc
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.measurement.zzfl r0 = (com.google.android.gms.internal.measurement.zzfl) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x03b8
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03ad
            r1 = 10
            goto L_0x03af
        L_0x03ad:
            int r1 = r1 << 1
        L_0x03af:
            com.google.android.gms.internal.measurement.zzfl r0 = r0.zza(r1)
            r10.putObject(r14, r2, r0)
            r11 = r0
            goto L_0x03b9
        L_0x03b8:
            r11 = r0
        L_0x03b9:
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza((int) r9)
            r1 = r8
            r2 = r31
            r3 = r7
            r4 = r33
            r7 = r5
            r5 = r11
            r19 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r17
            r6 = r19
            r13 = r33
            goto L_0x001b
        L_0x03dc:
            r19 = r6
            r6 = r5
            r24 = r6
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            goto L_0x048d
        L_0x03ea:
            r19 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x043f
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r29
            r32 = r1
            r1 = r30
            r22 = r2
            r2 = r31
            r3 = r7
            r20 = r4
            r4 = r33
            r5 = r8
            r24 = r6
            r15 = r7
            r7 = r32
            r25 = r8
            r8 = r9
            r18 = r9
            r26 = r10
            r9 = r20
            r12 = r22
            r14 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzdt) r14)
            if (r0 != r15) goto L_0x0425
            r2 = r0
            r7 = r17
            r6 = r19
            goto L_0x04b6
        L_0x0425:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r17
            r2 = r18
            r6 = r19
            r1 = r24
            r3 = r25
            r10 = r26
            goto L_0x001b
        L_0x043f:
            r32 = r0
            r22 = r2
            r24 = r6
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x0493
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x048d
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r22
            r8 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzdt) r8)
            if (r0 != r15) goto L_0x0473
            r2 = r0
            r7 = r17
            r6 = r19
            goto L_0x04b6
        L_0x0473:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r17
            r2 = r18
            r6 = r19
            r1 = r24
            r3 = r25
            r10 = r26
            goto L_0x001b
        L_0x048d:
            r2 = r15
            r7 = r17
            r6 = r19
            goto L_0x04b6
        L_0x0493:
            r7 = r32
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r8 = r5
            r5 = r25
            r6 = r24
            r9 = r11
            r10 = r22
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzdt) r13)
            if (r0 != r15) goto L_0x0541
            r2 = r0
            r7 = r17
            r6 = r19
        L_0x04b6:
            r8 = r34
            r9 = r25
            if (r9 != r8) goto L_0x04c7
            if (r8 != 0) goto L_0x04bf
            goto L_0x04c7
        L_0x04bf:
            r10 = r29
            r13 = r30
            r0 = r2
            r3 = r9
            goto L_0x056a
        L_0x04c7:
            r10 = r29
            boolean r0 = r10.zzh
            if (r0 == 0) goto L_0x051b
            r11 = r35
            com.google.android.gms.internal.measurement.zzeq r0 = r11.zzd
            com.google.android.gms.internal.measurement.zzeq r1 = com.google.android.gms.internal.measurement.zzeq.zza()
            if (r0 == r1) goto L_0x0516
            com.google.android.gms.internal.measurement.zzgo r0 = r10.zzg
            com.google.android.gms.internal.measurement.zzeq r1 = r11.zzd
            r12 = r24
            com.google.android.gms.internal.measurement.zzfd$zzf r0 = r1.zza(r0, r12)
            if (r0 != 0) goto L_0x0505
            com.google.android.gms.internal.measurement.zzhy r4 = zze((java.lang.Object) r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzhy) r4, (com.google.android.gms.internal.measurement.zzdt) r5)
            r14 = r30
            r13 = r33
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r18
            r10 = r26
            r12 = r31
            r11 = r8
            goto L_0x001b
        L_0x0505:
            r13 = r30
            r0 = r13
            com.google.android.gms.internal.measurement.zzfd$zzd r0 = (com.google.android.gms.internal.measurement.zzfd.zzd) r0
            r0.zza()
            com.google.android.gms.internal.measurement.zzew<com.google.android.gms.internal.measurement.zzfd$zzc> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0516:
            r13 = r30
            r12 = r24
            goto L_0x0521
        L_0x051b:
            r13 = r30
            r11 = r35
            r12 = r24
        L_0x0521:
            com.google.android.gms.internal.measurement.zzhy r4 = zze((java.lang.Object) r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzhy) r4, (com.google.android.gms.internal.measurement.zzdt) r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r18
            r10 = r26
            r12 = r31
            r13 = r33
            r11 = r8
            goto L_0x001b
        L_0x0541:
            r10 = r29
            r13 = r30
            r8 = r34
            r11 = r35
            r12 = r24
            r9 = r25
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r7 = r17
            r2 = r18
            r6 = r19
            r10 = r26
            r12 = r31
            r13 = r33
            r11 = r8
            goto L_0x001b
        L_0x0561:
            r19 = r6
            r17 = r7
            r26 = r10
            r8 = r11
            r13 = r14
            r10 = r15
        L_0x056a:
            r1 = -1
            if (r7 == r1) goto L_0x0573
            long r1 = (long) r7
            r4 = r26
            r4.putInt(r13, r1, r6)
        L_0x0573:
            r1 = 0
            int r2 = r10.zzm
        L_0x0576:
            int r4 = r10.zzn
            if (r2 >= r4) goto L_0x0589
            int[] r4 = r10.zzl
            r4 = r4[r2]
            com.google.android.gms.internal.measurement.zzhv<?, ?> r5 = r10.zzq
            java.lang.Object r1 = r10.zza((java.lang.Object) r13, (int) r4, r1, r5)
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1
            int r2 = r2 + 1
            goto L_0x0576
        L_0x0589:
            if (r1 == 0) goto L_0x0590
            com.google.android.gms.internal.measurement.zzhv<?, ?> r2 = r10.zzq
            r2.zzb((java.lang.Object) r13, r1)
        L_0x0590:
            if (r8 != 0) goto L_0x059c
            r1 = r33
            if (r0 != r1) goto L_0x0597
            goto L_0x05a2
        L_0x0597:
            com.google.android.gms.internal.measurement.zzfo r0 = com.google.android.gms.internal.measurement.zzfo.zzg()
            throw r0
        L_0x059c:
            r1 = r33
            if (r0 > r1) goto L_0x05a3
            if (r3 != r8) goto L_0x05a3
        L_0x05a2:
            return r0
        L_0x05a3:
            com.google.android.gms.internal.measurement.zzfo r0 = com.google.android.gms.internal.measurement.zzfo.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzdt):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.measurement.zzdt r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x036d
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0019:
            if (r0 >= r13) goto L_0x0363
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzdt) r11)
            int r3 = r11.zza
            r8 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r8 = r3
        L_0x002e:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zza((int) r7, (int) r2)
            r4 = r0
            goto L_0x0041
        L_0x003c:
            int r0 = r15.zzg(r7)
            r4 = r0
        L_0x0041:
            if (r4 != r10) goto L_0x004f
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x032c
        L_0x004f:
            int[] r0 = r15.zzc
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0231
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0214;
                case 1: goto L_0x01f6;
                case 2: goto L_0x01d5;
                case 3: goto L_0x01d5;
                case 4: goto L_0x01b8;
                case 5: goto L_0x0196;
                case 6: goto L_0x0179;
                case 7: goto L_0x0154;
                case 8: goto L_0x012e;
                case 9: goto L_0x00fc;
                case 10: goto L_0x00e0;
                case 11: goto L_0x01b8;
                case 12: goto L_0x00c3;
                case 13: goto L_0x0179;
                case 14: goto L_0x0196;
                case 15: goto L_0x00a2;
                case 16: goto L_0x0078;
                default: goto L_0x006c;
            }
        L_0x006c:
            r10 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x0078:
            if (r6 != 0) goto L_0x0096
            int r6 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzb
            long r21 = com.google.android.gms.internal.measurement.zzeg.zza((long) r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            r0 = r6
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x0096:
            r10 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x00a2:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x00b8
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzeg.zze(r1)
            r9.putInt(r14, r2, r1)
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x00b8:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x00c3:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x00d5
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r2, r1)
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x00d5:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x00e0:
            r2 = r1
            if (r6 != r10) goto L_0x00f1
            int r0 = com.google.android.gms.internal.measurement.zzdq.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x00f1:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x030c
        L_0x00fc:
            r2 = r1
            if (r6 != r10) goto L_0x0123
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza((int) r4)
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((com.google.android.gms.internal.measurement.zzhd) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.measurement.zzdt) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x0114
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            goto L_0x011e
        L_0x0114:
            java.lang.Object r5 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzff.zza((java.lang.Object) r1, (java.lang.Object) r5)
            r9.putObject(r14, r2, r1)
        L_0x011e:
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x0123:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x030c
        L_0x012e:
            r2 = r1
            if (r6 != r10) goto L_0x0149
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x013b
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r8, r11)
            goto L_0x013f
        L_0x013b:
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r8, r11)
        L_0x013f:
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x0149:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x030c
        L_0x0154:
            r2 = r1
            if (r6 != 0) goto L_0x016e
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8, r11)
            long r5 = r11.zzb
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r0 = 0
        L_0x0165:
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x016e:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x030c
        L_0x0179:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x018b
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
            r2 = r4
            r1 = r7
            r10 = -1
            goto L_0x0019
        L_0x018b:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x030c
        L_0x0196:
            r2 = r1
            if (r6 != r0) goto L_0x01ac
            long r5 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x01ac:
            r10 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x01b8:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r2, r1)
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x01ca:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x01d5:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x01eb
            int r6 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8, r11)
            long r4 = r11.zzb
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
            r0 = r6
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x01eb:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x01f6:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x0209
            float r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r8)
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x0209:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x0214:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0226
            double r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r8)
            com.google.android.gms.internal.measurement.zzib.zza((java.lang.Object) r14, (long) r2, (double) r0)
            int r0 = r8 + 8
            r1 = r7
            r2 = r10
            r10 = -1
            goto L_0x0019
        L_0x0226:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            r26 = -1
            goto L_0x030c
        L_0x0231:
            r0 = 27
            if (r3 != r0) goto L_0x027e
            if (r6 != r10) goto L_0x0273
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzfl r0 = (com.google.android.gms.internal.measurement.zzfl) r0
            boolean r3 = r0.zza()
            if (r3 != 0) goto L_0x0258
            int r3 = r0.size()
            if (r3 != 0) goto L_0x024d
            r3 = 10
            goto L_0x024f
        L_0x024d:
            int r3 = r3 << 1
        L_0x024f:
            com.google.android.gms.internal.measurement.zzfl r0 = r0.zza(r3)
            r9.putObject(r14, r1, r0)
            r5 = r0
            goto L_0x0259
        L_0x0258:
            r5 = r0
        L_0x0259:
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza((int) r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            r10 = -1
            goto L_0x0019
        L_0x0273:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            goto L_0x030c
        L_0x027e:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x02ca
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzdt) r14)
            if (r0 != r15) goto L_0x02b7
            r2 = r0
            goto L_0x032c
        L_0x02b7:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = -1
            goto L_0x0019
        L_0x02ca:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x030e
            r7 = r30
            if (r7 != r10) goto L_0x030c
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzdt) r8)
            if (r0 != r15) goto L_0x02f9
            r2 = r0
            goto L_0x032c
        L_0x02f9:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = -1
            goto L_0x0019
        L_0x030c:
            r2 = r15
            goto L_0x032c
        L_0x030e:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzdt) r13)
            if (r0 != r15) goto L_0x0350
            r2 = r0
        L_0x032c:
            com.google.android.gms.internal.measurement.zzhy r4 = zze((java.lang.Object) r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzhy) r4, (com.google.android.gms.internal.measurement.zzdt) r5)
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = -1
            goto L_0x0019
        L_0x0350:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = -1
            goto L_0x0019
        L_0x0363:
            r4 = r31
            if (r0 != r4) goto L_0x0368
            return
        L_0x0368:
            com.google.android.gms.internal.measurement.zzfo r0 = com.google.android.gms.internal.measurement.zzfo.zzg()
            throw r0
        L_0x036d:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzdt) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdt):void");
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzib.zzf(t, zzd2);
            if (zzf2 != null) {
                zzib.zza((Object) t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhv<UT, UB> zzhv) {
        zzfk zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzib.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzhv);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfk zzfk, UB ub, zzhv<UT, UB> zzhv) {
        zzgf<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzfk.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzhv.zza();
                }
                zzec zzc2 = zzdu.zzc(zzgg.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zzgg.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzhv.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzd(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t).zzf();
            }
            int i5 = this.zzl[i3];
            int i6 = this.zzc[i5];
            int zzd2 = zzd(i5);
            if (!this.zzj) {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzb.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzd2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzd2, zza(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzib.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i5)).zzc.zza() == zzip.MESSAGE) {
                                    zzhd<?> zzhd = null;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzhd == null) {
                                            zzhd = zzgz.zza().zza(next.getClass());
                                        }
                                        if (!zzhd.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzib.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzhd zza2 = zza(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzd2, zza(i5))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean zza(Object obj, int i, zzhd zzhd) {
        return zzhd.zzd(zzib.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzis zzis) throws IOException {
        if (obj instanceof String) {
            zzis.zza(i, (String) obj);
        } else {
            zzis.zza(i, (zzdu) obj);
        }
    }

    private final void zza(Object obj, int i, zzhe zzhe) throws IOException {
        if (zzf(i)) {
            zzib.zza(obj, (long) (i & 1048575), (Object) zzhe.zzm());
        } else if (this.zzi) {
            zzib.zza(obj, (long) (i & 1048575), (Object) zzhe.zzl());
        } else {
            zzib.zza(obj, (long) (i & 1048575), (Object) zzhe.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzib.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzib.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzib.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzib.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzib.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzj) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int zzd2 = zzd(i);
            long j = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzib.zze(t, j) != 0.0d;
                case 1:
                    return zzib.zzd(t, j) != 0.0f;
                case 2:
                    return zzib.zzb(t, j) != 0;
                case 3:
                    return zzib.zzb(t, j) != 0;
                case 4:
                    return zzib.zza((Object) t, j) != 0;
                case 5:
                    return zzib.zzb(t, j) != 0;
                case 6:
                    return zzib.zza((Object) t, j) != 0;
                case 7:
                    return zzib.zzc(t, j);
                case 8:
                    Object zzf2 = zzib.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzdu) {
                        return !zzdu.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzib.zzf(t, j) != null;
                case 10:
                    return !zzdu.zza.equals(zzib.zzf(t, j));
                case 11:
                    return zzib.zza((Object) t, j) != 0;
                case 12:
                    return zzib.zza((Object) t, j) != 0;
                case 13:
                    return zzib.zza((Object) t, j) != 0;
                case 14:
                    return zzib.zzb(t, j) != 0;
                case 15:
                    return zzib.zza((Object) t, j) != 0;
                case 16:
                    return zzib.zzb(t, j) != 0;
                case 17:
                    return zzib.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zze2 = zze(i);
            return (zzib.zza((Object) t, (long) (zze2 & 1048575)) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zze2 = zze(i);
            long j = (long) (zze2 & 1048575);
            zzib.zza((Object) t, j, zzib.zza((Object) t, j) | (1 << (zze2 >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzib.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzib.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
