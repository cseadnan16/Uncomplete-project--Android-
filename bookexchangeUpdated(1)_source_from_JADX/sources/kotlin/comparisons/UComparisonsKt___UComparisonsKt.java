package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\"\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0005\u001a+\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\b\u001a\"\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000b\u001a+\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\r\u001a\"\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0010\u001a+\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0012\u001a\"\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0015\u001a+\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b \u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, mo20370d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-5PvTz6A", "minOf-VKSA0NQ", "kotlin-stdlib"}, mo20371k = 5, mo20372mv = {1, 1, 15}, mo20374xi = 1, mo20375xs = "kotlin/comparisons/UComparisonsKt")
/* compiled from: _UComparisons.kt */
class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m955maxOfJ1ME1BU(int a, int b) {
        return UnsignedKt.uintCompare(a, b) >= 0 ? a : b;
    }

    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m960maxOfeb3DHEI(long a, long b) {
        return UnsignedKt.ulongCompare(a, b) >= 0 ? a : b;
    }

    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m956maxOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare((int) a & UByte.MAX_VALUE, (int) b & UByte.MAX_VALUE) >= 0 ? a : b;
    }

    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m954maxOf5PvTz6A(short a, short b) {
        return Intrinsics.compare((int) a & UShort.MAX_VALUE, (int) 65535 & b) >= 0 ? a : b;
    }

    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    private static final int m958maxOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m955maxOfJ1ME1BU(a, UComparisonsKt.m955maxOfJ1ME1BU(b, c));
    }

    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    private static final long m961maxOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m960maxOfeb3DHEI(a, UComparisonsKt.m960maxOfeb3DHEI(b, c));
    }

    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    private static final byte m959maxOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m956maxOfKr8caGY(a, UComparisonsKt.m956maxOfKr8caGY(b, c));
    }

    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    private static final short m957maxOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m954maxOf5PvTz6A(a, UComparisonsKt.m954maxOf5PvTz6A(b, c));
    }

    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m963minOfJ1ME1BU(int a, int b) {
        return UnsignedKt.uintCompare(a, b) <= 0 ? a : b;
    }

    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m968minOfeb3DHEI(long a, long b) {
        return UnsignedKt.ulongCompare(a, b) <= 0 ? a : b;
    }

    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m964minOfKr8caGY(byte a, byte b) {
        return Intrinsics.compare((int) a & UByte.MAX_VALUE, (int) b & UByte.MAX_VALUE) <= 0 ? a : b;
    }

    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m962minOf5PvTz6A(short a, short b) {
        return Intrinsics.compare((int) a & UShort.MAX_VALUE, (int) 65535 & b) <= 0 ? a : b;
    }

    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    private static final int m966minOfWZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.m963minOfJ1ME1BU(a, UComparisonsKt.m963minOfJ1ME1BU(b, c));
    }

    /* renamed from: minOf-sambcqE  reason: not valid java name */
    private static final long m969minOfsambcqE(long a, long b, long c) {
        return UComparisonsKt.m968minOfeb3DHEI(a, UComparisonsKt.m968minOfeb3DHEI(b, c));
    }

    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    private static final byte m967minOfb33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.m964minOfKr8caGY(a, UComparisonsKt.m964minOfKr8caGY(b, c));
    }

    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    private static final short m965minOfVKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.m962minOf5PvTz6A(a, UComparisonsKt.m962minOf5PvTz6A(b, c));
    }
}
