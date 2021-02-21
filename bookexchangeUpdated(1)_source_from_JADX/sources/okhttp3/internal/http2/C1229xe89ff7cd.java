package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.platform.Platform;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, mo20370d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp", "okhttp3/internal/http2/Http2Connection$ReaderRunnable$$special$$inlined$execute$1"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* renamed from: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1 */
/* compiled from: TaskQueue.kt */
public final class C1229xe89ff7cd extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ List $headerBlock$inlined;
    final /* synthetic */ boolean $inFinished$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ Http2Stream $newStream$inlined;
    final /* synthetic */ Http2Stream $stream$inlined;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection.ReaderRunnable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1229xe89ff7cd(String $captured_local_variable$1, boolean $captured_local_variable$2, String $super_call_param$3, boolean $super_call_param$4, Http2Stream http2Stream, Http2Connection.ReaderRunnable readerRunnable, Http2Stream http2Stream2, int i, List list, boolean z) {
        super($super_call_param$3, $super_call_param$4);
        this.$name = $captured_local_variable$1;
        this.$cancelable = $captured_local_variable$2;
        this.$newStream$inlined = http2Stream;
        this.this$0 = readerRunnable;
        this.$stream$inlined = http2Stream2;
        this.$streamId$inlined = i;
        this.$headerBlock$inlined = list;
        this.$inFinished$inlined = z;
    }

    public long runOnce() {
        try {
            this.this$0.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
            return -1;
        } catch (IOException e) {
            Platform platform = Platform.Companion.get();
            platform.log("Http2Connection.Listener failure for " + this.this$0.this$0.getConnectionName$okhttp(), 4, e);
            try {
                this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e);
                return -1;
            } catch (IOException e2) {
                return -1;
            }
        }
    }
}
