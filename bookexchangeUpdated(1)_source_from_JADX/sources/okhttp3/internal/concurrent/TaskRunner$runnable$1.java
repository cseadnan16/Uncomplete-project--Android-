package okhttp3.internal.concurrent;

import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo20370d2 = {"okhttp3/internal/concurrent/TaskRunner$runnable$1", "Ljava/lang/Runnable;", "run", "", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: TaskRunner.kt */
public final class TaskRunner$runnable$1 implements Runnable {
    final /* synthetic */ TaskRunner this$0;

    TaskRunner$runnable$1(TaskRunner $outer) {
        this.this$0 = $outer;
    }

    public void run() {
        Task awaitTaskToRun;
        while (true) {
            synchronized (this.this$0) {
                awaitTaskToRun = this.this$0.awaitTaskToRun();
            }
            if (awaitTaskToRun != null) {
                Task task = awaitTaskToRun;
                TaskQueue queue$iv = task.getQueue$okhttp();
                if (queue$iv == null) {
                    Intrinsics.throwNpe();
                }
                long startNs$iv = -1;
                boolean loggingEnabled$iv = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                if (loggingEnabled$iv) {
                    startNs$iv = queue$iv.getTaskRunner$okhttp().getBackend().nanoTime();
                    TaskLoggerKt.log(task, queue$iv, "starting");
                }
                try {
                    this.this$0.runTask(task);
                    Unit unit = Unit.INSTANCE;
                    if (loggingEnabled$iv) {
                        TaskLoggerKt.log(task, queue$iv, "finished run in " + TaskLoggerKt.formatDuration(queue$iv.getTaskRunner$okhttp().getBackend().nanoTime() - startNs$iv));
                    }
                } catch (Throwable th) {
                    if (loggingEnabled$iv) {
                        long elapsedNs$iv = queue$iv.getTaskRunner$okhttp().getBackend().nanoTime() - startNs$iv;
                        if (0 != 0) {
                            TaskLoggerKt.log(task, queue$iv, "finished run in " + TaskLoggerKt.formatDuration(elapsedNs$iv));
                        } else {
                            TaskLoggerKt.log(task, queue$iv, "failed a run in " + TaskLoggerKt.formatDuration(elapsedNs$iv));
                        }
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
