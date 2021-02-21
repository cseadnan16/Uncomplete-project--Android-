package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.Util;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo20370d2 = {"<anonymous>", "", "it", "Ljava/io/IOException;", "invoke"}, mo20371k = 3, mo20372mv = {1, 1, 16})
/* compiled from: DiskLruCache.kt */
final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends Lambda implements Function1<IOException, Unit> {
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        super(1);
        this.this$0 = diskLruCache;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IOException it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        Object $this$assertThreadHoldsLock$iv = this.this$0;
        if (!Util.assertionsEnabled || Thread.holdsLock($this$assertThreadHoldsLock$iv)) {
            this.this$0.hasJournalErrors = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append($this$assertThreadHoldsLock$iv);
        throw new AssertionError(sb.toString());
    }
}
