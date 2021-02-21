package okhttp3.internal.http2;

import androidx.core.view.PointerIconCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo20370d2 = {"Lokhttp3/internal/http2/Huffman;", "", "()V", "CODES", "", "CODE_BIT_COUNTS", "", "root", "Lokhttp3/internal/http2/Huffman$Node;", "addCode", "", "symbol", "", "code", "codeBitCount", "decode", "source", "Lokio/BufferedSource;", "byteCount", "", "sink", "Lokio/BufferedSink;", "encode", "Lokio/ByteString;", "encodedLength", "bytes", "Node", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: Huffman.kt */
public final class Huffman {
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] CODE_BIT_COUNTS = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
    public static final Huffman INSTANCE;
    private static final Node root = new Node();

    static {
        Huffman huffman = new Huffman();
        INSTANCE = huffman;
        int length = CODE_BIT_COUNTS.length;
        for (int i = 0; i < length; i++) {
            huffman.addCode(i, CODES[i], CODE_BIT_COUNTS[i]);
        }
    }

    private Huffman() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void encode(okio.ByteString r14, okio.BufferedSink r15) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            r0 = 0
            r2 = 0
            int r3 = r14.size()
            r4 = 0
        L_0x0012:
            r5 = 8
            if (r4 >= r3) goto L_0x003d
            byte r6 = r14.getByte(r4)
            r7 = 255(0xff, float:3.57E-43)
            int r6 = okhttp3.internal.Util.and((byte) r6, (int) r7)
            int[] r7 = CODES
            r7 = r7[r6]
            byte[] r8 = CODE_BIT_COUNTS
            byte r8 = r8[r6]
            long r9 = r0 << r8
            long r11 = (long) r7
            long r0 = r9 | r11
            int r2 = r2 + r8
        L_0x002e:
            if (r2 < r5) goto L_0x0039
            int r2 = r2 + -8
            long r9 = r0 >> r2
            int r10 = (int) r9
            r15.writeByte(r10)
            goto L_0x002e
        L_0x0039:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x003d:
            if (r2 <= 0) goto L_0x0049
            int r5 = r5 - r2
            long r0 = r0 << r5
            r3 = 255(0xff, double:1.26E-321)
            long r3 = r3 >>> r2
            long r0 = r0 | r3
            int r3 = (int) r0
            r15.writeByte(r3)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Huffman.encode(okio.ByteString, okio.BufferedSink):void");
    }

    public final int encodedLength(ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        long bitCount = 0;
        int size = bytes.size();
        for (int i = 0; i < size; i++) {
            bitCount += (long) CODE_BIT_COUNTS[Util.and(bytes.getByte(i), 255)];
        }
        return (int) ((((long) 7) + bitCount) >> 3);
    }

    public final void decode(BufferedSource source, long byteCount, BufferedSink sink) {
        Intrinsics.checkParameterIsNotNull(source, FirebaseAnalytics.Param.SOURCE);
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        Node node = root;
        int accumulator = 0;
        int accumulatorBitCount = 0;
        for (long i = 0; i < byteCount; i = 1 + i) {
            accumulator = (accumulator << 8) | Util.and(source.readByte(), 255);
            accumulatorBitCount += 8;
            while (accumulatorBitCount >= 8) {
                int childIndex = (accumulator >>> (accumulatorBitCount - 8)) & 255;
                Node[] children = node.getChildren();
                if (children == null) {
                    Intrinsics.throwNpe();
                }
                Node node2 = children[childIndex];
                if (node2 == null) {
                    Intrinsics.throwNpe();
                }
                node = node2;
                if (node.getChildren() == null) {
                    sink.writeByte(node.getSymbol());
                    accumulatorBitCount -= node.getTerminalBitCount();
                    node = root;
                } else {
                    accumulatorBitCount -= 8;
                }
            }
        }
        while (accumulatorBitCount > 0) {
            int childIndex2 = (accumulator << (8 - accumulatorBitCount)) & 255;
            Node[] children2 = node.getChildren();
            if (children2 == null) {
                Intrinsics.throwNpe();
            }
            Node node3 = children2[childIndex2];
            if (node3 == null) {
                Intrinsics.throwNpe();
            }
            Node node4 = node3;
            if (node4.getChildren() == null && node4.getTerminalBitCount() <= accumulatorBitCount) {
                sink.writeByte(node4.getSymbol());
                accumulatorBitCount -= node4.getTerminalBitCount();
                node = root;
            } else {
                return;
            }
        }
    }

    private final void addCode(int symbol, int code, int codeBitCount) {
        Node terminal = new Node(symbol, codeBitCount);
        int accumulatorBitCount = codeBitCount;
        Node node = root;
        while (accumulatorBitCount > 8) {
            accumulatorBitCount -= 8;
            int childIndex = (code >>> accumulatorBitCount) & 255;
            Node[] children = node.getChildren();
            if (children == null) {
                Intrinsics.throwNpe();
            }
            Node child = children[childIndex];
            if (child == null) {
                child = new Node();
                children[childIndex] = child;
            }
            node = child;
        }
        int shift = 8 - accumulatorBitCount;
        int start = (code << shift) & 255;
        int end = 1 << shift;
        Node[] children2 = node.getChildren();
        if (children2 == null) {
            Intrinsics.throwNpe();
        }
        ArraysKt.fill((T[]) children2, terminal, start, start + end);
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, mo20370d2 = {"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: Huffman.kt */
    private static final class Node {
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public Node(int symbol2, int bits) {
            this.children = null;
            this.symbol = symbol2;
            int b = bits & 7;
            this.terminalBitCount = b == 0 ? 8 : b;
        }
    }
}
