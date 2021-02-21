package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo20370d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, mo20371k = 1, mo20372mv = {1, 1, 15})
/* compiled from: Pipe.kt */
public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    Pipe$sink$1(Pipe $outer) {
        this.this$0 = $outer;
    }

    public void write(Buffer source, long byteCount) {
        Buffer buffer = source;
        Intrinsics.checkParameterIsNotNull(buffer, FirebaseAnalytics.Param.SOURCE);
        long byteCount2 = byteCount;
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!this.this$0.getSinkClosed$okio()) {
                while (true) {
                    if (byteCount2 <= 0) {
                        break;
                    }
                    Sink it = this.this$0.getFoldedSink$okio();
                    if (it != null) {
                        sink = it;
                        break;
                    } else if (!this.this$0.getSourceClosed$okio()) {
                        long bufferSpaceAvailable = this.this$0.getMaxBufferSize$okio() - this.this$0.getBuffer$okio().size();
                        if (bufferSpaceAvailable == 0) {
                            this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
                        } else {
                            long bytesToWrite = Math.min(bufferSpaceAvailable, byteCount2);
                            this.this$0.getBuffer$okio().write(buffer, bytesToWrite);
                            byteCount2 -= bytesToWrite;
                            Buffer buffer$okio = this.this$0.getBuffer$okio();
                            if (buffer$okio != null) {
                                buffer$okio.notifyAll();
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                            }
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        if (sink != null) {
            Sink $this$forward$iv = sink;
            Pipe this_$iv = this.this$0;
            Timeout this_$iv$iv = $this$forward$iv.timeout();
            Timeout other$iv$iv = this_$iv.sink().timeout();
            long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
            Pipe pipe = this_$iv;
            this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (this_$iv$iv.hasDeadline()) {
                long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                if (other$iv$iv.hasDeadline()) {
                    this_$iv$iv.deadlineNanoTime(Math.min(this_$iv$iv.deadlineNanoTime(), other$iv$iv.deadlineNanoTime()));
                }
                try {
                    $this$forward$iv.write(buffer, byteCount2);
                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                    }
                    throw th2;
                }
            } else {
                if (other$iv$iv.hasDeadline()) {
                    this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                }
                try {
                    $this$forward$iv.write(buffer, byteCount2);
                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.clearDeadline();
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.clearDeadline();
                    }
                    throw th4;
                }
            }
        }
    }

    public void flush() {
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!this.this$0.getSinkClosed$okio()) {
                Sink it = this.this$0.getFoldedSink$okio();
                if (it != null) {
                    sink = it;
                } else if (this.this$0.getSourceClosed$okio()) {
                    if (this.this$0.getBuffer$okio().size() > 0) {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        if (sink != null) {
            Pipe this_$iv = this.this$0;
            Sink $this$forward$iv = sink;
            Timeout this_$iv$iv = $this$forward$iv.timeout();
            Timeout other$iv$iv = this_$iv.sink().timeout();
            long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
            this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (this_$iv$iv.hasDeadline()) {
                long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                if (other$iv$iv.hasDeadline()) {
                    this_$iv$iv.deadlineNanoTime(Math.min(this_$iv$iv.deadlineNanoTime(), other$iv$iv.deadlineNanoTime()));
                }
                try {
                    $this$forward$iv.flush();
                } finally {
                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                    }
                }
            } else {
                if (other$iv$iv.hasDeadline()) {
                    this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                }
                try {
                    $this$forward$iv.flush();
                } finally {
                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.clearDeadline();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        r1 = r15.this$0;
        r2 = r0;
        r4 = r2.timeout();
        r5 = r1.sink().timeout();
        r7 = r4.timeoutNanos();
        r4.timeout(okio.Timeout.Companion.minTimeout(r5.timeoutNanos(), r4.timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r4.hasDeadline() == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008a, code lost:
        r9 = r4.deadlineNanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0092, code lost:
        if (r5.hasDeadline() == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        r4.deadlineNanoTime(java.lang.Math.min(r4.deadlineNanoTime(), r5.deadlineNanoTime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b9, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        r4.timeout(r7, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
        if (r5.hasDeadline() != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c5, code lost:
        r4.deadlineNanoTime(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c8, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cd, code lost:
        if (r5.hasDeadline() == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cf, code lost:
        r4.deadlineNanoTime(r5.deadlineNanoTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f0, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f1, code lost:
        r4.timeout(r7, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fa, code lost:
        if (r5.hasDeadline() != false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fc, code lost:
        r4.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ff, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r15 = this;
            r0 = 0
            okio.Sink r0 = (okio.Sink) r0
            okio.Pipe r1 = r15.this$0
            okio.Buffer r1 = r1.getBuffer$okio()
            r2 = 0
            monitor-enter(r1)
            r3 = 0
            okio.Pipe r4 = r15.this$0     // Catch:{ all -> 0x010a }
            boolean r4 = r4.getSinkClosed$okio()     // Catch:{ all -> 0x010a }
            if (r4 == 0) goto L_0x0016
            monitor-exit(r1)
            return
        L_0x0016:
            okio.Pipe r4 = r15.this$0     // Catch:{ all -> 0x010a }
            okio.Sink r4 = r4.getFoldedSink$okio()     // Catch:{ all -> 0x010a }
            if (r4 == 0) goto L_0x0021
            r5 = 0
            r0 = r4
            goto L_0x0057
        L_0x0021:
            okio.Pipe r4 = r15.this$0     // Catch:{ all -> 0x010a }
            boolean r4 = r4.getSourceClosed$okio()     // Catch:{ all -> 0x010a }
            if (r4 == 0) goto L_0x0044
            okio.Pipe r4 = r15.this$0     // Catch:{ all -> 0x010a }
            okio.Buffer r4 = r4.getBuffer$okio()     // Catch:{ all -> 0x010a }
            long r4 = r4.size()     // Catch:{ all -> 0x010a }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x003a
            goto L_0x0044
        L_0x003a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x010a }
            java.lang.String r5 = "source is closed"
            r4.<init>(r5)     // Catch:{ all -> 0x010a }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x010a }
            throw r4     // Catch:{ all -> 0x010a }
        L_0x0044:
            okio.Pipe r4 = r15.this$0     // Catch:{ all -> 0x010a }
            r5 = 1
            r4.setSinkClosed$okio(r5)     // Catch:{ all -> 0x010a }
            okio.Pipe r4 = r15.this$0     // Catch:{ all -> 0x010a }
            okio.Buffer r4 = r4.getBuffer$okio()     // Catch:{ all -> 0x010a }
            if (r4 == 0) goto L_0x0102
            java.lang.Object r4 = (java.lang.Object) r4     // Catch:{ all -> 0x010a }
            r4.notifyAll()     // Catch:{ all -> 0x010a }
        L_0x0057:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010a }
            monitor-exit(r1)
            if (r0 == 0) goto L_0x0100
            okio.Pipe r1 = r15.this$0
            r2 = r0
            r3 = 0
            okio.Timeout r4 = r2.timeout()
            okio.Sink r5 = r1.sink()
            okio.Timeout r5 = r5.timeout()
            r6 = 0
            long r7 = r4.timeoutNanos()
            okio.Timeout$Companion r9 = okio.Timeout.Companion
            long r10 = r5.timeoutNanos()
            long r12 = r4.timeoutNanos()
            long r9 = r9.minTimeout(r10, r12)
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.NANOSECONDS
            r4.timeout(r9, r11)
            boolean r9 = r4.hasDeadline()
            if (r9 == 0) goto L_0x00c9
            long r9 = r4.deadlineNanoTime()
            boolean r11 = r5.hasDeadline()
            if (r11 == 0) goto L_0x00a3
            long r11 = r4.deadlineNanoTime()
            long r13 = r5.deadlineNanoTime()
            long r11 = java.lang.Math.min(r11, r13)
            r4.deadlineNanoTime(r11)
        L_0x00a3:
            r11 = 0
            r12 = r2
            r13 = 0
            r12.close()     // Catch:{ all -> 0x00b9 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.NANOSECONDS
            r4.timeout(r7, r11)
            boolean r11 = r5.hasDeadline()
            if (r11 == 0) goto L_0x00b8
            r4.deadlineNanoTime(r9)
        L_0x00b8:
            goto L_0x00ec
        L_0x00b9:
            r11 = move-exception
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.NANOSECONDS
            r4.timeout(r7, r12)
            boolean r12 = r5.hasDeadline()
            if (r12 == 0) goto L_0x00c8
            r4.deadlineNanoTime(r9)
        L_0x00c8:
            throw r11
        L_0x00c9:
            boolean r9 = r5.hasDeadline()
            if (r9 == 0) goto L_0x00d6
            long r9 = r5.deadlineNanoTime()
            r4.deadlineNanoTime(r9)
        L_0x00d6:
            r9 = 0
            r10 = r2
            r11 = 0
            r10.close()     // Catch:{ all -> 0x00f0 }
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.NANOSECONDS
            r4.timeout(r7, r9)
            boolean r9 = r5.hasDeadline()
            if (r9 == 0) goto L_0x00eb
            r4.clearDeadline()
        L_0x00eb:
        L_0x00ec:
            goto L_0x0101
        L_0x00f0:
            r9 = move-exception
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.NANOSECONDS
            r4.timeout(r7, r10)
            boolean r10 = r5.hasDeadline()
            if (r10 == 0) goto L_0x00ff
            r4.clearDeadline()
        L_0x00ff:
            throw r9
        L_0x0100:
        L_0x0101:
            return
        L_0x0102:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException     // Catch:{ all -> 0x010a }
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.Object"
            r4.<init>(r5)     // Catch:{ all -> 0x010a }
            throw r4     // Catch:{ all -> 0x010a }
        L_0x010a:
            r3 = move-exception
            monitor-exit(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.close():void");
    }

    public Timeout timeout() {
        return this.timeout;
    }
}
