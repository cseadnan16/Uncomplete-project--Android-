package okio;

import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo20370d2 = {"okio/Throttler$source$1", "Lokio/ForwardingSource;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okio"}, mo20371k = 1, mo20372mv = {1, 1, 15})
/* compiled from: Throttler.kt */
public final class Throttler$source$1 extends ForwardingSource {
    final /* synthetic */ Source $source;
    final /* synthetic */ Throttler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Throttler$source$1(Throttler $outer, Source $captured_local_variable$1, Source $super_call_param$2) {
        super($super_call_param$2);
        this.this$0 = $outer;
        this.$source = $captured_local_variable$1;
    }

    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        try {
            return super.read(sink, this.this$0.take$okio(byteCount));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
