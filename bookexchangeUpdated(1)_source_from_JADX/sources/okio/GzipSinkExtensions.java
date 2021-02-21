package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b¨\u0006\u0003"}, mo20370d2 = {"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, mo20371k = 2, mo20372mv = {1, 1, 15})
/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
/* compiled from: GzipSink.kt */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink $this$gzip) {
        Intrinsics.checkParameterIsNotNull($this$gzip, "$this$gzip");
        return new GzipSink($this$gzip);
    }
}
