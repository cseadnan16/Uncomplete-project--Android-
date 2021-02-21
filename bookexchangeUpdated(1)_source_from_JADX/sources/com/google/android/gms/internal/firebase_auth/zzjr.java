package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzjr<T> implements zzkd<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzlf.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjn zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjw zzo;
    private final zzix zzp;
    private final zzkz<?, ?> zzq;
    private final zzhu<?> zzr;
    private final zzjk zzs;

    private zzjr(int[] iArr, Object[] objArr, int i, int i2, zzjn zzjn, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjw zzjw, zzix zzix, zzkz<?, ?> zzkz, zzhu<?> zzhu, zzjk zzjk) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjn instanceof zzif;
        this.zzj = z;
        this.zzh = zzhu != null && zzhu.zza(zzjn);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjw;
        this.zzp = zzix;
        this.zzq = zzkz;
        this.zzr = zzhu;
        this.zzg = zzjn;
        this.zzs = zzjk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:163:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.firebase_auth.zzjr<T> zza(java.lang.Class<T> r36, com.google.android.gms.internal.firebase_auth.zzjl r37, com.google.android.gms.internal.firebase_auth.zzjw r38, com.google.android.gms.internal.firebase_auth.zzix r39, com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r40, com.google.android.gms.internal.firebase_auth.zzhu<?> r41, com.google.android.gms.internal.firebase_auth.zzjk r42) {
        /*
            r0 = r37
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzkb
            if (r1 == 0) goto L_0x0451
            com.google.android.gms.internal.firebase_auth.zzkb r0 = (com.google.android.gms.internal.firebase_auth.zzkb) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.firebase_auth.zzif.zzf.zzi
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
            com.google.android.gms.internal.firebase_auth.zzjn r18 = r0.zzc()
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
            com.google.android.gms.internal.firebase_auth.zzjr r0 = new com.google.android.gms.internal.firebase_auth.zzjr
            com.google.android.gms.internal.firebase_auth.zzjn r10 = r33.zzc()
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
            com.google.android.gms.internal.firebase_auth.zzks r0 = (com.google.android.gms.internal.firebase_auth.zzks) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.firebase_auth.zzif.zzf.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjr.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzjl, com.google.android.gms.internal.firebase_auth.zzjw, com.google.android.gms.internal.firebase_auth.zzix, com.google.android.gms.internal.firebase_auth.zzkz, com.google.android.gms.internal.firebase_auth.zzhu, com.google.android.gms.internal.firebase_auth.zzjk):com.google.android.gms.internal.firebase_auth.zzjr");
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
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzlf.zze(t, j)) != Double.doubleToLongBits(zzlf.zze(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzlf.zzd(t, j)) != Float.floatToIntBits(zzlf.zzd(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzlf.zzc(t, j) != zzlf.zzc(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzkf.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzkf.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzkf.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzlf.zza((Object) t, j) != zzlf.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzlf.zzb(t, j) != zzlf.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzkf.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
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
                        z = zzkf.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j));
                        break;
                    case 50:
                        z = zzkf.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j));
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
                        if (zzlf.zza((Object) t, zze2) != zzlf.zza((Object) t2, zze2) || !zzkf.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j))) {
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
                    i = (i * 53) + zzii.zza(Double.doubleToLongBits(zzlf.zze(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzlf.zzd(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + zzii.zza(zzlf.zzc(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzlf.zzf(t, j)).hashCode();
                    break;
                case 9:
                    Object zzf2 = zzlf.zzf(t, j);
                    if (zzf2 != null) {
                        i4 = zzf2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzlf.zzf(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 12:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzlf.zza((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + zzii.zza(zzlf.zzb(t, j));
                    break;
                case 17:
                    Object zzf3 = zzlf.zzf(t, j);
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
                    i = (i * 53) + zzlf.zzf(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzlf.zzf(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(Double.doubleToLongBits(zzb(t, j)));
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
                        i = (i * 53) + zzii.zza(zze(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzii.zza(zze(t, j));
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
                        i = (i * 53) + zzii.zza(zze(t, j));
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
                        i = (i * 53) + zzii.zza(zzf(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zzlf.zzf(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzlf.zzf(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzlf.zzf(t, j).hashCode();
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
                        i = (i * 53) + zzii.zza(zze(t, j));
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
                        i = (i * 53) + zzii.zza(zze(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzlf.zzf(t, j).hashCode();
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
                            zzlf.zza((Object) t, j, zzlf.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
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
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzlf.zza((Object) t, j, zzlf.zzb(t2, j));
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
                        zzkf.zza(this.zzs, t, t2, j);
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
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
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
                            zzlf.zza((Object) t, j, zzlf.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzkf.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzkf.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzlf.zzf(t, zzd2);
            Object zzf3 = zzlf.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzlf.zza((Object) t, zzd2, zzii.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzlf.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzlf.zzf(t, j);
            Object zzf3 = zzlf.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzlf.zza((Object) t, j, zzii.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzlf.zza((Object) t, j, zzf3);
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
                if (i8 < zzia.DOUBLE_LIST_PACKED.zza() || i8 > zzia.SINT64_LIST_PACKED.zza()) {
                    i3 = 0;
                } else {
                    i3 = this.zzc[i6 + 2] & 1048575;
                }
                switch (i8) {
                    case 0:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzb(i9, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzb(i9, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzd(i9, zzlf.zzb(t2, j2));
                            break;
                        }
                    case 3:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zze(i9, zzlf.zzb(t2, j2));
                            break;
                        }
                    case 4:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzf(i9, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 5:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzg(i9, 0);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzi(i9, 0);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzb(i9, true);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            Object zzf2 = zzlf.zzf(t2, j2);
                            if (!(zzf2 instanceof zzgv)) {
                                i7 += zzhm.zzb(i9, (String) zzf2);
                                break;
                            } else {
                                i7 += zzhm.zzc(i9, (zzgv) zzf2);
                                break;
                            }
                        }
                    case 9:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzkf.zza(i9, zzlf.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 10:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzc(i9, (zzgv) zzlf.zzf(t2, j2));
                            break;
                        }
                    case 11:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzg(i9, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 12:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzk(i9, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 13:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzj(i9, 0);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzh(i9, 0);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzh(i9, zzlf.zza((Object) t2, j2));
                            break;
                        }
                    case 16:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzf(i9, zzlf.zzb(t2, j2));
                            break;
                        }
                    case 17:
                        if (!zza(t2, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzc(i9, (zzjn) zzlf.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 18:
                        i7 += zzkf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 19:
                        i7 += zzkf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 20:
                        i7 += zzkf.zza(i9, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 21:
                        i7 += zzkf.zzb(i9, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 22:
                        i7 += zzkf.zze(i9, zza((Object) t2, j2), false);
                        break;
                    case 23:
                        i7 += zzkf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 24:
                        i7 += zzkf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 25:
                        i7 += zzkf.zzj(i9, zza((Object) t2, j2), false);
                        break;
                    case 26:
                        i7 += zzkf.zza(i9, zza((Object) t2, j2));
                        break;
                    case 27:
                        i7 += zzkf.zza(i9, zza((Object) t2, j2), zza(i6));
                        break;
                    case 28:
                        i7 += zzkf.zzb(i9, zza((Object) t2, j2));
                        break;
                    case 29:
                        i7 += zzkf.zzf(i9, zza((Object) t2, j2), false);
                        break;
                    case 30:
                        i7 += zzkf.zzd(i9, zza((Object) t2, j2), false);
                        break;
                    case 31:
                        i7 += zzkf.zzh(i9, zza((Object) t2, j2), false);
                        break;
                    case 32:
                        i7 += zzkf.zzi(i9, zza((Object) t2, j2), false);
                        break;
                    case 33:
                        i7 += zzkf.zzg(i9, zza((Object) t2, j2), false);
                        break;
                    case 34:
                        i7 += zzkf.zzc(i9, zza((Object) t2, j2), false);
                        break;
                    case 35:
                        int zzi2 = zzkf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzi2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzi2) + zzi2;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int zzh2 = zzkf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzh2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzh2) + zzh2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int zza2 = zzkf.zza((List<Long>) (List) unsafe.getObject(t2, j2));
                        if (zza2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zza2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zza2) + zza2;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int zzb2 = zzkf.zzb((List) unsafe.getObject(t2, j2));
                        if (zzb2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzb2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzb2) + zzb2;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int zze2 = zzkf.zze((List) unsafe.getObject(t2, j2));
                        if (zze2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zze2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zze2) + zze2;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int zzi3 = zzkf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzi3);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzi3) + zzi3;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int zzh3 = zzkf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzh3);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzh3) + zzh3;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int zzj2 = zzkf.zzj((List) unsafe.getObject(t2, j2));
                        if (zzj2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzj2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzj2) + zzj2;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int zzf3 = zzkf.zzf((List) unsafe.getObject(t2, j2));
                        if (zzf3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzf3);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzf3) + zzf3;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int zzd3 = zzkf.zzd((List) unsafe.getObject(t2, j2));
                        if (zzd3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzd3);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzd3) + zzd3;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int zzh4 = zzkf.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzh4);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzh4) + zzh4;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int zzi4 = zzkf.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzi4);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzi4) + zzi4;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int zzg2 = zzkf.zzg((List) unsafe.getObject(t2, j2));
                        if (zzg2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzg2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzg2) + zzg2;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzc2 = zzkf.zzc((List) unsafe.getObject(t2, j2));
                        if (zzc2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i3, zzc2);
                            }
                            i7 += zzhm.zze(i9) + zzhm.zzg(zzc2) + zzc2;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i7 += zzkf.zzb(i9, (List<zzjn>) zza((Object) t2, j2), zza(i6));
                        break;
                    case 50:
                        i7 += this.zzs.zza(i9, zzlf.zzf(t2, j2), zzb(i6));
                        break;
                    case 51:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzb(i9, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzb(i9, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzd(i9, zze(t2, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zze(i9, zze(t2, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzf(i9, zzd(t2, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzg(i9, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzi(i9, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzb(i9, true);
                            break;
                        }
                    case 59:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            Object zzf4 = zzlf.zzf(t2, j2);
                            if (!(zzf4 instanceof zzgv)) {
                                i7 += zzhm.zzb(i9, (String) zzf4);
                                break;
                            } else {
                                i7 += zzhm.zzc(i9, (zzgv) zzf4);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzkf.zza(i9, zzlf.zzf(t2, j2), zza(i6));
                            break;
                        }
                    case 61:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzc(i9, (zzgv) zzlf.zzf(t2, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzg(i9, zzd(t2, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzk(i9, zzd(t2, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzj(i9, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzh(i9, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzh(i9, zzd(t2, j2));
                            break;
                        }
                    case 67:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzf(i9, zze(t2, j2));
                            break;
                        }
                    case 68:
                        if (!zza(t2, i9, i6)) {
                            break;
                        } else {
                            i7 += zzhm.zzc(i9, (zzjn) zzlf.zzf(t2, j2), zza(i6));
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
            } else if (!this.zzk || i15 < zzia.DOUBLE_LIST_PACKED.zza() || i15 > zzia.SINT64_LIST_PACKED.zza()) {
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
                        i12 += zzhm.zzb(i14, 0.0d);
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzhm.zzb(i14, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzhm.zzd(i14, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzhm.zze(i14, unsafe2.getLong(t2, j3));
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i13 & i) == 0) {
                        break;
                    } else {
                        i12 += zzhm.zzf(i14, unsafe2.getInt(t2, j3));
                        break;
                    }
                case 5:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        i12 += zzhm.zzg(i14, 0);
                        break;
                    }
                case 6:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzi(i14, 0);
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzb(i14, true);
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j3);
                        if (!(object instanceof zzgv)) {
                            i12 += zzhm.zzb(i14, (String) object);
                            j = 0;
                            break;
                        } else {
                            i12 += zzhm.zzc(i14, (zzgv) object);
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzkf.zza(i14, unsafe2.getObject(t2, j3), zza(i11));
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzc(i14, (zzgv) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzg(i14, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzk(i14, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzj(i14, 0);
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzh(i14, 0);
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzh(i14, unsafe2.getInt(t2, j3));
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzf(i14, unsafe2.getLong(t2, j3));
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i13 & i) == 0) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzc(i14, (zzjn) unsafe2.getObject(t2, j3), zza(i11));
                        j = 0;
                        break;
                    }
                case 18:
                    i12 += zzkf.zzi(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 19:
                    i12 += zzkf.zzh(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 20:
                    i12 += zzkf.zza(i14, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 21:
                    i12 += zzkf.zzb(i14, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 22:
                    i12 += zzkf.zze(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 23:
                    i12 += zzkf.zzi(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 24:
                    i12 += zzkf.zzh(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 25:
                    i12 += zzkf.zzj(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 26:
                    i12 += zzkf.zza(i14, (List<?>) (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 27:
                    i12 += zzkf.zza(i14, (List<?>) (List) unsafe2.getObject(t2, j3), zza(i11));
                    j = 0;
                    break;
                case 28:
                    i12 += zzkf.zzb(i14, (List) unsafe2.getObject(t2, j3));
                    j = 0;
                    break;
                case 29:
                    i12 += zzkf.zzf(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 30:
                    i12 += zzkf.zzd(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 31:
                    i12 += zzkf.zzh(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 32:
                    i12 += zzkf.zzi(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 33:
                    i12 += zzkf.zzg(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 34:
                    i12 += zzkf.zzc(i14, (List) unsafe2.getObject(t2, j3), false);
                    j = 0;
                    break;
                case 35:
                    int zzi5 = zzkf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi5);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzi5) + zzi5;
                        j = 0;
                        break;
                    }
                case 36:
                    int zzh5 = zzkf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh5);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzh5) + zzh5;
                        j = 0;
                        break;
                    }
                case 37:
                    int zza3 = zzkf.zza((List<Long>) (List) unsafe2.getObject(t2, j3));
                    if (zza3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zza3);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zza3) + zza3;
                        j = 0;
                        break;
                    }
                case 38:
                    int zzb3 = zzkf.zzb((List) unsafe2.getObject(t2, j3));
                    if (zzb3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzb3);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzb3) + zzb3;
                        j = 0;
                        break;
                    }
                case 39:
                    int zze3 = zzkf.zze((List) unsafe2.getObject(t2, j3));
                    if (zze3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zze3);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zze3) + zze3;
                        j = 0;
                        break;
                    }
                case 40:
                    int zzi6 = zzkf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi6);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzi6) + zzi6;
                        j = 0;
                        break;
                    }
                case 41:
                    int zzh6 = zzkf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh6 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh6);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzh6) + zzh6;
                        j = 0;
                        break;
                    }
                case 42:
                    int zzj3 = zzkf.zzj((List) unsafe2.getObject(t2, j3));
                    if (zzj3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzj3);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzj3) + zzj3;
                        j = 0;
                        break;
                    }
                case 43:
                    int zzf5 = zzkf.zzf((List) unsafe2.getObject(t2, j3));
                    if (zzf5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzf5);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzf5) + zzf5;
                        j = 0;
                        break;
                    }
                case 44:
                    int zzd5 = zzkf.zzd((List) unsafe2.getObject(t2, j3));
                    if (zzd5 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzd5);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzd5) + zzd5;
                        j = 0;
                        break;
                    }
                case 45:
                    int zzh7 = zzkf.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh7 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh7);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzh7) + zzh7;
                        j = 0;
                        break;
                    }
                case 46:
                    int zzi7 = zzkf.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi7 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi7);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzi7) + zzi7;
                        j = 0;
                        break;
                    }
                case 47:
                    int zzg3 = zzkf.zzg((List) unsafe2.getObject(t2, j3));
                    if (zzg3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzg3);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzg3) + zzg3;
                        j = 0;
                        break;
                    }
                case 48:
                    int zzc3 = zzkf.zzc((List) unsafe2.getObject(t2, j3));
                    if (zzc3 <= 0) {
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzc3);
                        }
                        i12 += zzhm.zze(i14) + zzhm.zzg(zzc3) + zzc3;
                        j = 0;
                        break;
                    }
                case 49:
                    i12 += zzkf.zzb(i14, (List<zzjn>) (List) unsafe2.getObject(t2, j3), zza(i11));
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
                        i12 += zzhm.zzb(i14, 0.0d);
                        j = 0;
                        break;
                    }
                case 52:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzb(i14, 0.0f);
                        j = 0;
                        break;
                    }
                case 53:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzd(i14, zze(t2, j3));
                        j = 0;
                        break;
                    }
                case 54:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zze(i14, zze(t2, j3));
                        j = 0;
                        break;
                    }
                case 55:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzf(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 56:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzg(i14, 0);
                        j = 0;
                        break;
                    }
                case 57:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzi(i14, 0);
                        j = 0;
                        break;
                    }
                case 58:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzb(i14, true);
                        j = 0;
                        break;
                    }
                case 59:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (!(object2 instanceof zzgv)) {
                            i12 += zzhm.zzb(i14, (String) object2);
                            j = 0;
                            break;
                        } else {
                            i12 += zzhm.zzc(i14, (zzgv) object2);
                            j = 0;
                            break;
                        }
                    }
                case 60:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzkf.zza(i14, unsafe2.getObject(t2, j3), zza(i11));
                        j = 0;
                        break;
                    }
                case 61:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzc(i14, (zzgv) unsafe2.getObject(t2, j3));
                        j = 0;
                        break;
                    }
                case 62:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzg(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 63:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzk(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 64:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzj(i14, 0);
                        j = 0;
                        break;
                    }
                case 65:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzh(i14, 0);
                        j = 0;
                        break;
                    }
                case 66:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzh(i14, zzd(t2, j3));
                        j = 0;
                        break;
                    }
                case 67:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzf(i14, zze(t2, j3));
                        j = 0;
                        break;
                    }
                case 68:
                    if (!zza(t2, i14, i11)) {
                        j = 0;
                        break;
                    } else {
                        i12 += zzhm.zzc(i14, (zzjn) unsafe2.getObject(t2, j3), zza(i11));
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
        zzhv<?> zza5 = this.zzr.zza((Object) t2);
        for (int i19 = 0; i19 < zza5.zza.zzc(); i19++) {
            Map.Entry<T, Object> zzb4 = zza5.zza.zzb(i19);
            i18 += zzhv.zza((zzhx<?>) (zzhx) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry next : zza5.zza.zzd()) {
            i18 += zzhv.zza((zzhx<?>) (zzhx) next.getKey(), next.getValue());
        }
        return zza4 + i18;
    }

    private static <UT, UB> int zza(zzkz<UT, UB> zzkz, T t) {
        return zzkz.zzf(zzkz.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzlf.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b5e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.firebase_auth.zzls r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.firebase_auth.zzif.zzf.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x05c3
            com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0036
            com.google.android.gms.internal.firebase_auth.zzhu<?> r0 = r13.zzr
            com.google.android.gms.internal.firebase_auth.zzhv r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_auth.zzki<T, java.lang.Object> r1 = r0.zza
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
            com.google.android.gms.internal.firebase_auth.zzhu<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0067
            com.google.android.gms.internal.firebase_auth.zzhu<?> r10 = r13.zzr
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzgv r8 = (com.google.android.gms.internal.firebase_auth.zzgv) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzgv) r8)
            goto L_0x05a7
        L_0x0107:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
            goto L_0x05a7
        L_0x011d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzls) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x05a7
        L_0x01cb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r13.zza((int) r7)
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
            goto L_0x05a7
        L_0x01e3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zze(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x01f7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzj(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x020b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzg(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x021f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzl(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0233:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzm(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0247:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzi(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x025b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzn(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x026f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzk(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0283:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzf(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0297:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzh(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02ab:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzd(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02bf:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzc(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02d3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02fb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zze(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x030f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzj(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0323:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzg(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0337:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzl(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x034b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzm(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x035f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzi(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r9, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgv>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            goto L_0x05a7
        L_0x0387:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r13.zza((int) r7)
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
            goto L_0x05a7
        L_0x039f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            goto L_0x05a7
        L_0x03b3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzn(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03c7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzk(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03db:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzf(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03ef:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzh(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0403:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzd(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0417:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzc(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x042b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r5)
            goto L_0x05a7
        L_0x043f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r5)
            goto L_0x05a7
        L_0x0453:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
            goto L_0x05a7
        L_0x0469:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x05a7
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x05a7
        L_0x048f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a7
        L_0x04a2:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04b5:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04c8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04db:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzgv r8 = (com.google.android.gms.internal.firebase_auth.zzgv) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzgv) r8)
            goto L_0x05a7
        L_0x04ef:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
            goto L_0x05a7
        L_0x0505:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            goto L_0x05a7
        L_0x0517:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x05a7
        L_0x052a:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x05a7
        L_0x053c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x05a7
        L_0x054e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0560:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0572:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0584:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_auth.zzlf.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a7
        L_0x0596:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_auth.zzlf.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x05a7:
            int r7 = r7 + -3
            goto L_0x003d
        L_0x05ab:
            if (r1 == 0) goto L_0x05c2
            com.google.android.gms.internal.firebase_auth.zzhu<?> r14 = r13.zzr
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
            com.google.android.gms.internal.firebase_auth.zzhu<?> r0 = r13.zzr
            com.google.android.gms.internal.firebase_auth.zzhv r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_auth.zzki<T, java.lang.Object> r1 = r0.zza
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
            com.google.android.gms.internal.firebase_auth.zzhu<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0618
            com.google.android.gms.internal.firebase_auth.zzhu<?> r11 = r13.zzr
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkd r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkd) r11)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzgv r9 = (com.google.android.gms.internal.firebase_auth.zzgv) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzgv) r9)
            goto L_0x0b58
        L_0x06b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkd r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkd) r11)
            goto L_0x0b58
        L_0x06ce:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzls) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0b58
        L_0x077c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkd r11 = r13.zza((int) r8)
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15, (com.google.android.gms.internal.firebase_auth.zzkd) r11)
            goto L_0x0b58
        L_0x0794:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zze(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07a8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzj(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07bc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzg(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07d0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzl(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07e4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzm(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07f8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzi(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x080c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzn(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0820:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzk(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0834:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzf(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0848:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzh(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x085c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzd(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0870:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzc(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0884:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r4)
            goto L_0x0b58
        L_0x0898:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r4)
            goto L_0x0b58
        L_0x08ac:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zze(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08c0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzj(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08d4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzg(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08e8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzl(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08fc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzm(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0910:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzi(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0924:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r10, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgv>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            goto L_0x0b58
        L_0x0938:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkd r11 = r13.zza((int) r8)
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15, (com.google.android.gms.internal.firebase_auth.zzkd) r11)
            goto L_0x0b58
        L_0x0950:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            goto L_0x0b58
        L_0x0964:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzn(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0978:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzk(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x098c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzf(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09a0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzh(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09b4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzd(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09c8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzc(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09dc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r5)
            goto L_0x0b58
        L_0x09f0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15, (boolean) r5)
            goto L_0x0b58
        L_0x0a04:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkd r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkd) r11)
            goto L_0x0b58
        L_0x0a1a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0a2d:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0b58
        L_0x0a40:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0a53:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a66:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a79:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a8c:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzgv r9 = (com.google.android.gms.internal.firebase_auth.zzgv) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzgv) r9)
            goto L_0x0b58
        L_0x0aa0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzkd r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzkd) r11)
            goto L_0x0b58
        L_0x0ab6:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            goto L_0x0b58
        L_0x0ac8:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0b58
        L_0x0adb:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0aed:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0aff:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzlf.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0b11:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0b23:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzlf.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0b35:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_auth.zzlf.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b58
        L_0x0b47:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_auth.zzlf.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0b58:
            int r8 = r8 + 3
            goto L_0x05ee
        L_0x0b5c:
            if (r1 == 0) goto L_0x0b72
            com.google.android.gms.internal.firebase_auth.zzhu<?> r2 = r13.zzr
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
            com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            return
        L_0x0b78:
            r13.zzb(r14, (com.google.android.gms.internal.firebase_auth.zzls) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjr.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzls):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.firebase_auth.zzls r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0025
            com.google.android.gms.internal.firebase_auth.zzhu<?> r3 = r0.zzr
            com.google.android.gms.internal.firebase_auth.zzhv r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.firebase_auth.zzki<T, java.lang.Object> r5 = r3.zza
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
            com.google.android.gms.internal.firebase_auth.zzhu<?> r9 = r0.zzr
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r5)
            if (r9 > r14) goto L_0x008a
            com.google.android.gms.internal.firebase_auth.zzhu<?> r9 = r0.zzr
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
            com.google.android.gms.internal.firebase_auth.zzkd r9 = r0.zza((int) r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzkd) r9)
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
            com.google.android.gms.internal.firebase_auth.zzgv r4 = (com.google.android.gms.internal.firebase_auth.zzgv) r4
            r2.zza((int) r14, (com.google.android.gms.internal.firebase_auth.zzgv) r4)
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
            com.google.android.gms.internal.firebase_auth.zzkd r9 = r0.zza((int) r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzkd) r9)
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
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzls) r2)
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
            r0.zza((com.google.android.gms.internal.firebase_auth.zzls) r2, (int) r14, (java.lang.Object) r4, (int) r12)
            r13 = 0
            goto L_0x05c1
        L_0x0228:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r0.zza((int) r12)
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0240:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zze(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0254:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzj(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0268:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzg(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x027c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzl(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0290:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzm(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02a4:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzi(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02b8:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzn(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02cc:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzk(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02e0:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzf(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02f4:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzh(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0308:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzd(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x031c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzc(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0330:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0344:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0358:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zze(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x036c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzj(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0380:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzg(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0394:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzl(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03a8:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzm(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03bc:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzi(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03d0:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r4, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgv>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2)
            r13 = 0
            goto L_0x05c1
        L_0x03e3:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkd r10 = r0.zza((int) r12)
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2, (com.google.android.gms.internal.firebase_auth.zzkd) r10)
            r13 = 0
            goto L_0x05c1
        L_0x03fb:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2)
            r13 = 0
            goto L_0x05c1
        L_0x040e:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzn(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0422:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzk(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0436:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzf(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x044a:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzh(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x045e:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzd(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0472:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzc(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0486:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x049a:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzkf.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzls) r2, (boolean) r13)
            goto L_0x05c1
        L_0x04ad:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzkd r9 = r0.zza((int) r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzkd) r9)
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
            com.google.android.gms.internal.firebase_auth.zzgv r4 = (com.google.android.gms.internal.firebase_auth.zzgv) r4
            r2.zza((int) r14, (com.google.android.gms.internal.firebase_auth.zzgv) r4)
            goto L_0x05c1
        L_0x052c:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzkd r9 = r0.zza((int) r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzkd) r9)
            goto L_0x05c1
        L_0x053f:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzls) r2)
            goto L_0x05c1
        L_0x054e:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzlf.zzc(r1, r9)
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
            float r4 = com.google.android.gms.internal.firebase_auth.zzlf.zzd(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x05c1
        L_0x05b3:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            double r9 = com.google.android.gms.internal.firebase_auth.zzlf.zze(r1, r9)
            r2.zza((int) r14, (double) r9)
        L_0x05c1:
            int r10 = r12 + 3
            goto L_0x0030
        L_0x05c5:
            if (r5 == 0) goto L_0x05dc
            com.google.android.gms.internal.firebase_auth.zzhu<?> r4 = r0.zzr
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
            com.google.android.gms.internal.firebase_auth.zzkz<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.firebase_auth.zzls) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjr.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzls):void");
    }

    private final <K, V> void zza(zzls zzls, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzls.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private static <UT, UB> void zza(zzkz<UT, UB> zzkz, T t, zzls zzls) throws IOException {
        zzkz.zza(zzkz.zzb(t), zzls);
    }

    public final void zza(T t, zzke zzke, zzhs zzhs) throws IOException {
        int i;
        Object obj;
        zzhv<?> zzhv;
        T t2 = t;
        zzke zzke2 = zzke;
        zzhs zzhs2 = zzhs;
        if (zzhs2 != null) {
            zzkz<?, ?> zzkz = this.zzq;
            zzhu<?> zzhu = this.zzr;
            zzhv<?> zzhv2 = null;
            Object obj2 = null;
            while (true) {
                try {
                    int zza2 = zzke.zza();
                    if (zza2 < this.zze || zza2 > this.zzf) {
                        i = -1;
                    } else {
                        int i2 = 0;
                        int length = (this.zzc.length / 3) - 1;
                        while (true) {
                            if (i2 > length) {
                                i = -1;
                            } else {
                                int i3 = (length + i2) >>> 1;
                                int i4 = i3 * 3;
                                int i5 = this.zzc[i4];
                                if (zza2 == i5) {
                                    i = i4;
                                } else if (zza2 < i5) {
                                    length = i3 - 1;
                                } else {
                                    i2 = i3 + 1;
                                }
                            }
                        }
                    }
                    if (i >= 0) {
                        int zzd2 = zzd(i);
                        switch ((267386880 & zzd2) >>> 20) {
                            case 0:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzd());
                                zzb(t2, i);
                                break;
                            case 1:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zze());
                                zzb(t2, i);
                                break;
                            case 2:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzg());
                                zzb(t2, i);
                                break;
                            case 3:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzf());
                                zzb(t2, i);
                                break;
                            case 4:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzh());
                                zzb(t2, i);
                                break;
                            case 5:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzi());
                                zzb(t2, i);
                                break;
                            case 6:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzj());
                                zzb(t2, i);
                                break;
                            case 7:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzk());
                                zzb(t2, i);
                                break;
                            case 8:
                                zza((Object) t2, zzd2, zzke2);
                                zzb(t2, i);
                                break;
                            case 9:
                                if (!zza(t2, i)) {
                                    zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zza(zza(i), zzhs2));
                                    zzb(t2, i);
                                    break;
                                } else {
                                    long j = (long) (zzd2 & 1048575);
                                    zzlf.zza((Object) t2, j, zzii.zza(zzlf.zzf(t2, j), zzke2.zza(zza(i), zzhs2)));
                                    break;
                                }
                            case 10:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) zzke.zzn());
                                zzb(t2, i);
                                break;
                            case 11:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzo());
                                zzb(t2, i);
                                break;
                            case 12:
                                int zzp2 = zzke.zzp();
                                zzij zzc2 = zzc(i);
                                if (zzc2 != null) {
                                    if (!zzc2.zza(zzp2)) {
                                        obj2 = zzkf.zza(zza2, zzp2, obj2, zzkz);
                                        break;
                                    }
                                }
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzp2);
                                zzb(t2, i);
                                break;
                            case 13:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzq());
                                zzb(t2, i);
                                break;
                            case 14:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzr());
                                zzb(t2, i);
                                break;
                            case 15:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzs());
                                zzb(t2, i);
                                break;
                            case 16:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke.zzt());
                                zzb(t2, i);
                                break;
                            case 17:
                                if (!zza(t2, i)) {
                                    zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zzb(zza(i), zzhs2));
                                    zzb(t2, i);
                                    break;
                                } else {
                                    long j2 = (long) (zzd2 & 1048575);
                                    zzlf.zza((Object) t2, j2, zzii.zza(zzlf.zzf(t2, j2), zzke2.zzb(zza(i), zzhs2)));
                                    break;
                                }
                            case 18:
                                zzke2.zza(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 19:
                                zzke2.zzb(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 20:
                                zzke2.zzd(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 21:
                                zzke2.zzc(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 22:
                                zzke2.zze(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 23:
                                zzke2.zzf(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 24:
                                zzke2.zzg(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 25:
                                zzke2.zzh(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 26:
                                if (!zzf(zzd2)) {
                                    zzke2.zzi(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    zzke2.zzj(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                    break;
                                }
                            case 27:
                                zzke2.zza(this.zzp.zza(t2, (long) (zzd2 & 1048575)), zza(i), zzhs2);
                                break;
                            case 28:
                                zzke2.zzk(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 29:
                                zzke2.zzl(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 30:
                                List zza3 = this.zzp.zza(t2, (long) (zzd2 & 1048575));
                                zzke2.zzm(zza3);
                                obj2 = zzkf.zza(zza2, zza3, zzc(i), obj2, zzkz);
                                break;
                            case 31:
                                zzke2.zzn(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 32:
                                zzke2.zzo(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 33:
                                zzke2.zzp(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 34:
                                zzke2.zzq(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 35:
                                zzke2.zza(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 36:
                                zzke2.zzb(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 37:
                                zzke2.zzd(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 38:
                                zzke2.zzc(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 39:
                                zzke2.zze(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 40:
                                zzke2.zzf(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 41:
                                zzke2.zzg(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 42:
                                zzke2.zzh(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 43:
                                zzke2.zzl(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 44:
                                List zza4 = this.zzp.zza(t2, (long) (zzd2 & 1048575));
                                zzke2.zzm(zza4);
                                obj2 = zzkf.zza(zza2, zza4, zzc(i), obj2, zzkz);
                                break;
                            case 45:
                                zzke2.zzn(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 46:
                                zzke2.zzo(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 47:
                                zzke2.zzp(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 48:
                                zzke2.zzq(this.zzp.zza(t2, (long) (zzd2 & 1048575)));
                                break;
                            case 49:
                                zzke2.zzb(this.zzp.zza(t2, (long) (zzd2 & 1048575)), zza(i), zzhs2);
                                break;
                            case 50:
                                Object zzb2 = zzb(i);
                                long zzd3 = (long) (zzd(i) & 1048575);
                                Object zzf2 = zzlf.zzf(t2, zzd3);
                                if (zzf2 == null) {
                                    zzf2 = this.zzs.zzf(zzb2);
                                    zzlf.zza((Object) t2, zzd3, zzf2);
                                } else if (this.zzs.zzd(zzf2)) {
                                    Object zzf3 = this.zzs.zzf(zzb2);
                                    this.zzs.zza(zzf3, zzf2);
                                    zzlf.zza((Object) t2, zzd3, zzf3);
                                    zzf2 = zzf3;
                                }
                                zzke2.zza(this.zzs.zza(zzf2), this.zzs.zzb(zzb2), zzhs2);
                                break;
                            case 51:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Double.valueOf(zzke.zzd()));
                                zzb(t2, zza2, i);
                                break;
                            case 52:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Float.valueOf(zzke.zze()));
                                zzb(t2, zza2, i);
                                break;
                            case 53:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzg()));
                                zzb(t2, zza2, i);
                                break;
                            case 54:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzf()));
                                zzb(t2, zza2, i);
                                break;
                            case 55:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzh()));
                                zzb(t2, zza2, i);
                                break;
                            case 56:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzi()));
                                zzb(t2, zza2, i);
                                break;
                            case 57:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzj()));
                                zzb(t2, zza2, i);
                                break;
                            case 58:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Boolean.valueOf(zzke.zzk()));
                                zzb(t2, zza2, i);
                                break;
                            case 59:
                                zza((Object) t2, zzd2, zzke2);
                                zzb(t2, zza2, i);
                                break;
                            case 60:
                                if (zza(t2, zza2, i)) {
                                    long j3 = (long) (zzd2 & 1048575);
                                    zzlf.zza((Object) t2, j3, zzii.zza(zzlf.zzf(t2, j3), zzke2.zza(zza(i), zzhs2)));
                                } else {
                                    zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zza(zza(i), zzhs2));
                                    zzb(t2, i);
                                }
                                zzb(t2, zza2, i);
                                break;
                            case 61:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) zzke.zzn());
                                zzb(t2, zza2, i);
                                break;
                            case 62:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzo()));
                                zzb(t2, zza2, i);
                                break;
                            case 63:
                                int zzp3 = zzke.zzp();
                                zzij zzc3 = zzc(i);
                                if (zzc3 != null) {
                                    if (!zzc3.zza(zzp3)) {
                                        obj2 = zzkf.zza(zza2, zzp3, obj2, zzkz);
                                        break;
                                    }
                                }
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzp3));
                                zzb(t2, zza2, i);
                                break;
                            case 64:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzq()));
                                zzb(t2, zza2, i);
                                break;
                            case 65:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzr()));
                                zzb(t2, zza2, i);
                                break;
                            case 66:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Integer.valueOf(zzke.zzs()));
                                zzb(t2, zza2, i);
                                break;
                            case 67:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), (Object) Long.valueOf(zzke.zzt()));
                                zzb(t2, zza2, i);
                                break;
                            case 68:
                                zzlf.zza((Object) t2, (long) (zzd2 & 1048575), zzke2.zzb(zza(i), zzhs2));
                                zzb(t2, zza2, i);
                                break;
                            default:
                                if (obj2 == null) {
                                    obj2 = zzkz.zza();
                                }
                                if (zzkz.zza(obj2, zzke2)) {
                                    break;
                                } else {
                                    for (int i6 = this.zzm; i6 < this.zzn; i6++) {
                                        obj2 = zza((Object) t2, this.zzl[i6], obj2, zzkz);
                                    }
                                    if (obj2 != null) {
                                        zzkz.zzb((Object) t2, obj2);
                                        return;
                                    }
                                    return;
                                }
                        }
                    } else if (zza2 == Integer.MAX_VALUE) {
                        for (int i7 = this.zzm; i7 < this.zzn; i7++) {
                            obj2 = zza((Object) t2, this.zzl[i7], obj2, zzkz);
                        }
                        if (obj2 != null) {
                            zzkz.zzb((Object) t2, obj2);
                            return;
                        }
                        return;
                    } else {
                        if (!this.zzh) {
                            obj = null;
                        } else {
                            obj = zzhu.zza(zzhs2, this.zzg, zza2);
                        }
                        if (obj != null) {
                            if (zzhv2 == null) {
                                zzhv = zzhu.zzb(t2);
                            } else {
                                zzhv = zzhv2;
                            }
                            obj2 = zzhu.zza(zzke, obj, zzhs, zzhv, obj2, zzkz);
                            zzhv2 = zzhv;
                        } else {
                            zzkz.zza(zzke2);
                            if (obj2 == null) {
                                obj2 = zzkz.zzc(t2);
                            }
                            if (!zzkz.zza(obj2, zzke2)) {
                                for (int i8 = this.zzm; i8 < this.zzn; i8++) {
                                    obj2 = zza((Object) t2, this.zzl[i8], obj2, zzkz);
                                }
                                if (obj2 != null) {
                                    zzkz.zzb((Object) t2, obj2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } catch (zziq e) {
                    zzkz.zza(zzke2);
                    if (obj2 == null) {
                        obj2 = zzkz.zzc(t2);
                    }
                    if (!zzkz.zza(obj2, zzke2)) {
                        for (int i9 = this.zzm; i9 < this.zzn; i9++) {
                            obj2 = zza((Object) t2, this.zzl[i9], obj2, zzkz);
                        }
                        if (obj2 != null) {
                            zzkz.zzb((Object) t2, obj2);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    for (int i10 = this.zzm; i10 < this.zzn; i10++) {
                        obj2 = zza((Object) t2, this.zzl[i10], obj2, zzkz);
                    }
                    if (obj2 != null) {
                        zzkz.zzb((Object) t2, obj2);
                    }
                    throw th2;
                }
            }
        } else {
            throw null;
        }
    }

    private final zzkd zza(int i) {
        int i2 = (i / 3) << 1;
        zzkd zzkd = (zzkd) this.zzd[i2];
        if (zzkd != null) {
            return zzkd;
        }
        zzkd zza2 = zzjz.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzij zzc(int i) {
        return (zzij) this.zzd[((i / 3) << 1) + 1];
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
            Object zzf2 = zzlf.zzf(t, zzd2);
            if (zzf2 != null) {
                zzlf.zza((Object) t, zzd2, this.zzs.zze(zzf2));
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

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkz<UT, UB> zzkz) {
        zzij zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzlf.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzkz);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzij zzij, UB ub, zzkz<UT, UB> zzkz) {
        zzji<?, ?> zzb2 = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzij.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzkz.zza();
                }
                zzhd zzc2 = zzgv.zzc(zzjf.zza(zzb2, next.getKey(), next.getValue()));
                try {
                    zzjf.zza(zzc2.zzb(), zzb2, next.getKey(), next.getValue());
                    zzkz.zza(ub, i2, zzc2.zza());
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
                            Map<?, ?> zzc2 = this.zzs.zzc(zzlf.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzc2.isEmpty()) {
                                if (this.zzs.zzb(zzb(i5)).zzc.zza() == zzlt.MESSAGE) {
                                    zzkd<?> zzkd = null;
                                    Iterator<?> it = zzc2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzkd == null) {
                                            zzkd = zzjz.zza().zza(next.getClass());
                                        }
                                        if (!zzkd.zzd(next)) {
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
                List list = (List) zzlf.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzkd zza2 = zza(i5);
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

    private static boolean zza(Object obj, int i, zzkd zzkd) {
        return zzkd.zzd(zzlf.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzls zzls) throws IOException {
        if (obj instanceof String) {
            zzls.zza(i, (String) obj);
        } else {
            zzls.zza(i, (zzgv) obj);
        }
    }

    private final void zza(Object obj, int i, zzke zzke) throws IOException {
        if (zzf(i)) {
            zzlf.zza(obj, (long) (i & 1048575), (Object) zzke.zzm());
        } else if (this.zzi) {
            zzlf.zza(obj, (long) (i & 1048575), (Object) zzke.zzl());
        } else {
            zzlf.zza(obj, (long) (i & 1048575), (Object) zzke.zzn());
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
        return ((Double) zzlf.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzlf.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzlf.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzlf.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzlf.zzf(t, j)).booleanValue();
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
                    return zzlf.zze(t, j) != 0.0d;
                case 1:
                    return zzlf.zzd(t, j) != 0.0f;
                case 2:
                    return zzlf.zzb(t, j) != 0;
                case 3:
                    return zzlf.zzb(t, j) != 0;
                case 4:
                    return zzlf.zza((Object) t, j) != 0;
                case 5:
                    return zzlf.zzb(t, j) != 0;
                case 6:
                    return zzlf.zza((Object) t, j) != 0;
                case 7:
                    return zzlf.zzc(t, j);
                case 8:
                    Object zzf2 = zzlf.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgv) {
                        return !zzgv.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzlf.zzf(t, j) != null;
                case 10:
                    return !zzgv.zza.equals(zzlf.zzf(t, j));
                case 11:
                    return zzlf.zza((Object) t, j) != 0;
                case 12:
                    return zzlf.zza((Object) t, j) != 0;
                case 13:
                    return zzlf.zza((Object) t, j) != 0;
                case 14:
                    return zzlf.zzb(t, j) != 0;
                case 15:
                    return zzlf.zza((Object) t, j) != 0;
                case 16:
                    return zzlf.zzb(t, j) != 0;
                case 17:
                    return zzlf.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zze2 = zze(i);
            return (zzlf.zza((Object) t, (long) (zze2 & 1048575)) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zze2 = zze(i);
            long j = (long) (zze2 & 1048575);
            zzlf.zza((Object) t, j, zzlf.zza((Object) t, j) | (1 << (zze2 >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzlf.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzlf.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }
}
