package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, mo20370d2 = {"Lokio/SegmentPool;", "", "()V", "MAX_SIZE", "", "byteCount", "getByteCount", "()J", "setByteCount", "(J)V", "next", "Lokio/Segment;", "getNext", "()Lokio/Segment;", "setNext", "(Lokio/Segment;)V", "recycle", "", "segment", "take", "okio"}, mo20371k = 1, mo20372mv = {1, 1, 15})
/* compiled from: SegmentPool.kt */
public final class SegmentPool {
    public static final SegmentPool INSTANCE = new SegmentPool();
    public static final long MAX_SIZE = 65536;
    private static long byteCount;
    private static Segment next;

    private SegmentPool() {
    }

    public final Segment getNext() {
        return next;
    }

    public final void setNext(Segment segment) {
        next = segment;
    }

    public final long getByteCount() {
        return byteCount;
    }

    public final void setByteCount(long j) {
        byteCount = j;
    }

    public final Segment take() {
        synchronized (this) {
            Segment result = next;
            if (result == null) {
                return new Segment();
            }
            next = result.next;
            result.next = null;
            byteCount -= (long) 8192;
            return result;
        }
    }

    public final void recycle(Segment segment) {
        Intrinsics.checkParameterIsNotNull(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.shared) {
            synchronized (this) {
                long j = (long) 8192;
                if (byteCount + j <= 65536) {
                    byteCount += j;
                    segment.next = next;
                    segment.limit = 0;
                    segment.pos = segment.limit;
                    next = segment;
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }
}
