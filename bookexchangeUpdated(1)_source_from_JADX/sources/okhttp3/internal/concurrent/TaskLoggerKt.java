package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.internal.http2.Http2Connection;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a2\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\b¢\u0006\u0002\u0010\u000f\u001a'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\b¨\u0006\u0012"}, mo20370d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", "T", "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, mo20371k = 2, mo20372mv = {1, 1, 16})
/* compiled from: TaskLogger.kt */
public final class TaskLoggerKt {
    public static final void taskLog(Task task, TaskQueue queue, Function0<String> messageBlock) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(queue, "queue");
        Intrinsics.checkParameterIsNotNull(messageBlock, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, queue, messageBlock.invoke());
        }
    }

    public static final <T> T logElapsed(Task task, TaskQueue queue, Function0<? extends T> block) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(queue, "queue");
        Intrinsics.checkParameterIsNotNull(block, "block");
        long startNs = -1;
        boolean loggingEnabled = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (loggingEnabled) {
            startNs = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, queue, "starting");
        }
        try {
            Object result = block.invoke();
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                log(task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - startNs));
            }
            InlineMarker.finallyEnd(1);
            return result;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                long elapsedNs = queue.getTaskRunner$okhttp().getBackend().nanoTime() - startNs;
                if (0 != 0) {
                    log(task, queue, "finished run in " + formatDuration(elapsedNs));
                } else {
                    log(task, queue, "failed a run in " + formatDuration(elapsedNs));
                }
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final void log(Task task, TaskQueue queue, String message) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(queue.getName$okhttp());
        sb.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{message}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final String formatDuration(long ns) {
        String s;
        if (ns <= ((long) -999500000)) {
            s = ((ns - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (ns <= ((long) -999500)) {
            s = ((ns - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (ns <= 0) {
            s = ((ns - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (ns < ((long) 999500)) {
            s = ((((long) 500) + ns) / ((long) 1000)) + " µs";
        } else if (ns < ((long) 999500000)) {
            s = ((((long) 500000) + ns) / ((long) 1000000)) + " ms";
        } else {
            s = ((((long) 500000000) + ns) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{s}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
