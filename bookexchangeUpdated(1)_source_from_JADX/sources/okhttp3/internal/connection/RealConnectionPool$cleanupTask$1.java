package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo20370d2 = {"okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: RealConnectionPool.kt */
public final class RealConnectionPool$cleanupTask$1 extends Task {
    final /* synthetic */ RealConnectionPool this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealConnectionPool$cleanupTask$1(RealConnectionPool $outer, String $super_call_param$1) {
        super($super_call_param$1, false, 2, (DefaultConstructorMarker) null);
        this.this$0 = $outer;
    }

    public long runOnce() {
        return this.this$0.cleanup(System.nanoTime());
    }
}
