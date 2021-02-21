package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\u0005"}, mo20370d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"}, mo20371k = 2, mo20372mv = {1, 1, 15})
/* renamed from: okio.-InflaterSourceExtensions  reason: invalid class name */
/* compiled from: InflaterSource.kt */
public final class InflaterSourceExtensions {
    public static /* synthetic */ InflaterSource inflate$default(Source $this$inflate, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkParameterIsNotNull($this$inflate, "$this$inflate");
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        return new InflaterSource($this$inflate, inflater);
    }

    public static final InflaterSource inflate(Source $this$inflate, Inflater inflater) {
        Intrinsics.checkParameterIsNotNull($this$inflate, "$this$inflate");
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        return new InflaterSource($this$inflate, inflater);
    }
}
