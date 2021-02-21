package okhttp3.internal;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo20370d2 = {"<anonymous>", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"}, mo20371k = 3, mo20372mv = {1, 1, 16})
/* compiled from: Util.kt */
final class Util$threadFactory$1 implements ThreadFactory {
    final /* synthetic */ boolean $daemon;
    final /* synthetic */ String $name;

    Util$threadFactory$1(String str, boolean z) {
        this.$name = str;
        this.$daemon = z;
    }

    public final Thread newThread(Runnable runnable) {
        Thread $this$apply = new Thread(runnable, this.$name);
        $this$apply.setDaemon(this.$daemon);
        return $this$apply;
    }
}
