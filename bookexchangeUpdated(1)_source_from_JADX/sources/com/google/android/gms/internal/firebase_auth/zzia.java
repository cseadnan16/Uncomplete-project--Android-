package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Type;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public enum zzia {
    DOUBLE(0, zzic.SCALAR, zzip.DOUBLE),
    FLOAT(1, zzic.SCALAR, zzip.FLOAT),
    INT64(2, zzic.SCALAR, zzip.LONG),
    UINT64(3, zzic.SCALAR, zzip.LONG),
    INT32(4, zzic.SCALAR, zzip.INT),
    FIXED64(5, zzic.SCALAR, zzip.LONG),
    FIXED32(6, zzic.SCALAR, zzip.INT),
    BOOL(7, zzic.SCALAR, zzip.BOOLEAN),
    STRING(8, zzic.SCALAR, zzip.STRING),
    MESSAGE(9, zzic.SCALAR, zzip.MESSAGE),
    BYTES(10, zzic.SCALAR, zzip.BYTE_STRING),
    UINT32(11, zzic.SCALAR, zzip.INT),
    ENUM(12, zzic.SCALAR, zzip.ENUM),
    SFIXED32(13, zzic.SCALAR, zzip.INT),
    SFIXED64(14, zzic.SCALAR, zzip.LONG),
    SINT32(15, zzic.SCALAR, zzip.INT),
    SINT64(16, zzic.SCALAR, zzip.LONG),
    GROUP(17, zzic.SCALAR, zzip.MESSAGE),
    DOUBLE_LIST(18, zzic.VECTOR, zzip.DOUBLE),
    FLOAT_LIST(19, zzic.VECTOR, zzip.FLOAT),
    INT64_LIST(20, zzic.VECTOR, zzip.LONG),
    UINT64_LIST(21, zzic.VECTOR, zzip.LONG),
    INT32_LIST(22, zzic.VECTOR, zzip.INT),
    FIXED64_LIST(23, zzic.VECTOR, zzip.LONG),
    FIXED32_LIST(24, zzic.VECTOR, zzip.INT),
    BOOL_LIST(25, zzic.VECTOR, zzip.BOOLEAN),
    STRING_LIST(26, zzic.VECTOR, zzip.STRING),
    MESSAGE_LIST(27, zzic.VECTOR, zzip.MESSAGE),
    BYTES_LIST(28, zzic.VECTOR, zzip.BYTE_STRING),
    UINT32_LIST(29, zzic.VECTOR, zzip.INT),
    ENUM_LIST(30, zzic.VECTOR, zzip.ENUM),
    SFIXED32_LIST(31, zzic.VECTOR, zzip.INT),
    SFIXED64_LIST(32, zzic.VECTOR, zzip.LONG),
    SINT32_LIST(33, zzic.VECTOR, zzip.INT),
    SINT64_LIST(34, zzic.VECTOR, zzip.LONG),
    DOUBLE_LIST_PACKED(35, zzic.PACKED_VECTOR, zzip.DOUBLE),
    FLOAT_LIST_PACKED(36, zzic.PACKED_VECTOR, zzip.FLOAT),
    INT64_LIST_PACKED(37, zzic.PACKED_VECTOR, zzip.LONG),
    UINT64_LIST_PACKED(38, zzic.PACKED_VECTOR, zzip.LONG),
    INT32_LIST_PACKED(39, zzic.PACKED_VECTOR, zzip.INT),
    FIXED64_LIST_PACKED(40, zzic.PACKED_VECTOR, zzip.LONG),
    FIXED32_LIST_PACKED(41, zzic.PACKED_VECTOR, zzip.INT),
    BOOL_LIST_PACKED(42, zzic.PACKED_VECTOR, zzip.BOOLEAN),
    UINT32_LIST_PACKED(43, zzic.PACKED_VECTOR, zzip.INT),
    ENUM_LIST_PACKED(44, zzic.PACKED_VECTOR, zzip.ENUM),
    SFIXED32_LIST_PACKED(45, zzic.PACKED_VECTOR, zzip.INT),
    SFIXED64_LIST_PACKED(46, zzic.PACKED_VECTOR, zzip.LONG),
    SINT32_LIST_PACKED(47, zzic.PACKED_VECTOR, zzip.INT),
    SINT64_LIST_PACKED(48, zzic.PACKED_VECTOR, zzip.LONG),
    GROUP_LIST(49, zzic.VECTOR, zzip.MESSAGE),
    MAP(50, zzic.MAP, zzip.VOID);
    
    private static final zzia[] zzbe = null;
    private static final Type[] zzbf = null;
    private final zzip zzaz;
    private final int zzba;
    private final zzic zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r5 = com.google.android.gms.internal.firebase_auth.zzhz.zzb[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzia(int r4, com.google.android.gms.internal.firebase_auth.zzic r5, com.google.android.gms.internal.firebase_auth.zzip r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.zzba = r4
            r1.zzbb = r5
            r1.zzaz = r6
            int[] r2 = com.google.android.gms.internal.firebase_auth.zzhz.zza
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.zzbc = r2
            goto L_0x0029
        L_0x001b:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
            goto L_0x0029
        L_0x0022:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
        L_0x0029:
            r2 = 0
            com.google.android.gms.internal.firebase_auth.zzic r0 = com.google.android.gms.internal.firebase_auth.zzic.SCALAR
            if (r5 != r0) goto L_0x003e
            int[] r5 = com.google.android.gms.internal.firebase_auth.zzhz.zzb
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003e
            if (r5 == r3) goto L_0x003e
            r3 = 3
            if (r5 == r3) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r4 = 0
        L_0x003f:
            r1.zzbd = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzia.<init>(java.lang.String, int, int, com.google.android.gms.internal.firebase_auth.zzic, com.google.android.gms.internal.firebase_auth.zzip):void");
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        int i;
        zzbf = new Type[0];
        zzia[] values = values();
        zzbe = new zzia[values.length];
        for (zzia zzia : values) {
            zzbe[zzia.zzba] = zzia;
        }
    }
}
