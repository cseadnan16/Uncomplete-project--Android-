package okhttp3.internal.connection;

import kotlin.Metadata;
import okio.AsyncTimeout;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, mo20370d2 = {"okhttp3/internal/connection/Transmitter$timeout$1", "Lokio/AsyncTimeout;", "timedOut", "", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: Transmitter.kt */
public final class Transmitter$timeout$1 extends AsyncTimeout {
    final /* synthetic */ Transmitter this$0;

    Transmitter$timeout$1(Transmitter $outer) {
        this.this$0 = $outer;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
        this.this$0.cancel();
    }
}
