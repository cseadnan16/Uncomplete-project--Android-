package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.p011ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo20370d2 = {"okhttp3/internal/connection/RealConnection$newWebSocketStreams$1", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "close", "", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: RealConnection.kt */
public final class RealConnection$newWebSocketStreams$1 extends RealWebSocket.Streams {
    final /* synthetic */ Exchange $exchange;
    final /* synthetic */ BufferedSink $sink;
    final /* synthetic */ BufferedSource $source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealConnection$newWebSocketStreams$1(Exchange $captured_local_variable$0, BufferedSource $captured_local_variable$1, BufferedSink $captured_local_variable$2, boolean $super_call_param$3, BufferedSource $super_call_param$4, BufferedSink $super_call_param$5) {
        super($super_call_param$3, $super_call_param$4, $super_call_param$5);
        this.$exchange = $captured_local_variable$0;
        this.$source = $captured_local_variable$1;
        this.$sink = $captured_local_variable$2;
    }

    public void close() {
        this.$exchange.bodyComplete(-1, true, true, null);
    }
}
