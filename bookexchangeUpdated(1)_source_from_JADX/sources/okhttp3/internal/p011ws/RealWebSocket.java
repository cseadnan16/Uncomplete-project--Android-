package okhttp3.internal.p011ws;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.RealCall;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.p011ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0005[\\]^_B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u000203J\b\u00104\u001a\u000200H\u0016J\u001f\u00105\u001a\u0002002\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0000¢\u0006\u0002\b:J\u001a\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u00152\u0006\u0010>\u001a\u00020\fJ\u000e\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020AJ\u001c\u0010B\u001a\u0002002\n\u0010C\u001a\u00060Dj\u0002`E2\b\u00106\u001a\u0004\u0018\u000107J\u0016\u0010F\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u0006\u0010G\u001a\u000200J\u0018\u0010H\u001a\u0002002\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0015H\u0016J\u0010\u0010I\u001a\u0002002\u0006\u0010J\u001a\u00020\u0015H\u0016J\u0010\u0010I\u001a\u0002002\u0006\u0010K\u001a\u00020\u001dH\u0016J\u0010\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\u001dH\u0016J\u0010\u0010N\u001a\u0002002\u0006\u0010M\u001a\u00020\u001dH\u0016J\u000e\u0010O\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u001dJ\u0006\u0010P\u001a\u00020\u000fJ\b\u0010\u001e\u001a\u00020\fH\u0016J\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"J\b\u0010Q\u001a\u00020\u0006H\u0016J\b\u0010R\u001a\u000200H\u0002J\u0010\u0010S\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0015H\u0016J\u0010\u0010S\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u001dH\u0016J\u0018\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\"H\u0002J\u0006\u0010&\u001a\u00020\"J\u0006\u0010V\u001a\u000200J\r\u0010W\u001a\u00020\u000fH\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u000200H\u0000¢\u0006\u0002\bZR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, mo20370d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* renamed from: okhttp3.internal.ws.RealWebSocket */
/* compiled from: RealWebSocket.kt */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    /* access modifiers changed from: private */
    public String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    public RealWebSocket(TaskRunner taskRunner, Request originalRequest2, WebSocketListener listener2, Random random2, long pingIntervalMillis2) {
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics.checkParameterIsNotNull(originalRequest2, "originalRequest");
        Intrinsics.checkParameterIsNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(random2, "random");
        this.originalRequest = originalRequest2;
        this.listener = listener2;
        this.random = random2;
        this.pingIntervalMillis = pingIntervalMillis2;
        this.taskQueue = taskRunner.newQueue();
        if (Intrinsics.areEqual((Object) "GET", (Object) this.originalRequest.method())) {
            ByteString.Companion companion = ByteString.Companion;
            byte[] $this$apply = new byte[16];
            this.random.nextBytes($this$apply);
            this.key = ByteString.Companion.of$default(companion, $this$apply, 0, 0, 3, (Object) null).base64();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + this.originalRequest.method()).toString());
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public Request request() {
        return this.originalRequest;
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public void cancel() {
        Call call2 = this.call;
        if (call2 == null) {
            Intrinsics.throwNpe();
        }
        call2.cancel();
    }

    public final void connect(OkHttpClient client) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        OkHttpClient webSocketClient = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request request = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        Call newRealCall = RealCall.Companion.newRealCall(webSocketClient, request, true);
        this.call = newRealCall;
        if (newRealCall == null) {
            Intrinsics.throwNpe();
        }
        newRealCall.enqueue(new RealWebSocket$connect$1(this, request));
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (response.code() == 101) {
            String headerConnection = Response.header$default(response, "Connection", (String) null, 2, (Object) null);
            if (StringsKt.equals("Upgrade", headerConnection, true)) {
                String headerUpgrade = Response.header$default(response, "Upgrade", (String) null, 2, (Object) null);
                if (StringsKt.equals("websocket", headerUpgrade, true)) {
                    String headerAccept = Response.header$default(response, "Sec-WebSocket-Accept", (String) null, 2, (Object) null);
                    ByteString.Companion companion = ByteString.Companion;
                    String acceptExpected = companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (true ^ Intrinsics.areEqual((Object) acceptExpected, (Object) headerAccept)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + acceptExpected + "' but was '" + headerAccept + '\'');
                    } else if (exchange == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + headerUpgrade + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + headerConnection + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
    }

    public final void initReaderAndWriter(String name2, Streams streams2) throws IOException {
        String str = name2;
        Streams streams3 = streams2;
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(streams3, "streams");
        synchronized (this) {
            this.name = str;
            this.streams = streams3;
            this.writer = new WebSocketWriter(streams2.getClient(), streams2.getSink(), this.random);
            this.writerTask = new WriterTask();
            if (this.pingIntervalMillis != 0) {
                long pingIntervalNanos = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                String name$iv = str + " ping";
                this.taskQueue.schedule(new RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1(name$iv, name$iv, pingIntervalNanos, this, name2, streams2), pingIntervalNanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams2.getClient(), streams2.getSource(), this);
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader == null) {
                Intrinsics.throwNpe();
            }
            webSocketReader.processNextFrame();
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader == null) {
                Intrinsics.throwNpe();
            }
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            failWebSocket(e, (Response) null);
            return false;
        }
    }

    public final void awaitTermination(long timeout, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(timeout, timeUnit);
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public void onReadMessage(String text) throws IOException {
        Intrinsics.checkParameterIsNotNull(text, "text");
        this.listener.onMessage((WebSocket) this, text);
    }

    public void onReadMessage(ByteString bytes) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        this.listener.onMessage((WebSocket) this, bytes);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)     // Catch:{ all -> 0x0029 }
            boolean r0 = r1.failed     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            goto L_0x0027
        L_0x0017:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0029 }
            r0.add(r2)     // Catch:{ all -> 0x0029 }
            r1.runWriter()     // Catch:{ all -> 0x0029 }
            int r0 = r1.receivedPingCount     // Catch:{ all -> 0x0029 }
            int r0 = r0 + 1
            r1.receivedPingCount = r0     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)
            return
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p011ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString payload) {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public void onReadClose(int code, String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        boolean z = true;
        if (code != -1) {
            Object toClose = (Streams) null;
            synchronized (this) {
                if (this.receivedCloseCode != -1) {
                    z = false;
                }
                if (z) {
                    this.receivedCloseCode = code;
                    this.receivedCloseReason = reason;
                    if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                        toClose = this.streams;
                        this.streams = null;
                        this.taskQueue.shutdown();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("already closed".toString());
                }
            }
            try {
                this.listener.onClosing(this, code, reason);
                if (toClose != null) {
                    this.listener.onClosed(this, code, reason);
                }
            } finally {
                if (toClose != null) {
                    Util.closeQuietly((Closeable) toClose);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public boolean send(String text) {
        Intrinsics.checkParameterIsNotNull(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    public boolean send(ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return send(bytes, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean send(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r0 = 1001(0x3e9, float:1.403E-42)
            r2 = 0
            r6.close(r0, r2)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.runWriter()     // Catch:{ all -> 0x003e }
            r0 = 1
            monitor-exit(r6)
            return r0
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p011ws.RealWebSocket.send(okio.ByteString, int):boolean");
    }

    public final synchronized boolean pong(ByteString payload) {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
        }
        return false;
    }

    public boolean close(int code, String reason) {
        return close(code, reason, CANCEL_AFTER_CLOSE_MILLIS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean close(int r9, java.lang.String r10, long r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            okhttp3.internal.ws.WebSocketProtocol r0 = okhttp3.internal.p011ws.WebSocketProtocol.INSTANCE     // Catch:{ all -> 0x005f }
            r0.validateCloseCode(r9)     // Catch:{ all -> 0x005f }
            r0 = 0
            okio.ByteString r0 = (okio.ByteString) r0     // Catch:{ all -> 0x005f }
            r1 = 0
            r2 = 1
            if (r10 == 0) goto L_0x0043
            okio.ByteString$Companion r3 = okio.ByteString.Companion     // Catch:{ all -> 0x005f }
            okio.ByteString r3 = r3.encodeUtf8(r10)     // Catch:{ all -> 0x005f }
            r0 = r3
            int r3 = r0.size()     // Catch:{ all -> 0x005f }
            long r3 = (long) r3     // Catch:{ all -> 0x005f }
            r5 = 123(0x7b, double:6.1E-322)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0021
            r3 = 1
            goto L_0x0022
        L_0x0021:
            r3 = 0
        L_0x0022:
            if (r3 == 0) goto L_0x0025
            goto L_0x0043
        L_0x0025:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r2.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "reason.size() > 123: "
            r2.append(r3)     // Catch:{ all -> 0x005f }
            r2.append(r10)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005f }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005f }
            r1.<init>(r2)     // Catch:{ all -> 0x005f }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x005f }
            throw r1     // Catch:{ all -> 0x005f }
        L_0x0043:
            boolean r3 = r8.failed     // Catch:{ all -> 0x005f }
            if (r3 != 0) goto L_0x005d
            boolean r3 = r8.enqueuedClose     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x004c
            goto L_0x005d
        L_0x004c:
            r8.enqueuedClose = r2     // Catch:{ all -> 0x005f }
            java.util.ArrayDeque<java.lang.Object> r1 = r8.messageAndCloseQueue     // Catch:{ all -> 0x005f }
            okhttp3.internal.ws.RealWebSocket$Close r3 = new okhttp3.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x005f }
            r3.<init>(r9, r0, r11)     // Catch:{ all -> 0x005f }
            r1.add(r3)     // Catch:{ all -> 0x005f }
            r8.runWriter()     // Catch:{ all -> 0x005f }
            monitor-exit(r8)
            return r2
        L_0x005d:
            monitor-exit(r8)
            return r1
        L_0x005f:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p011ws.RealWebSocket.close(int, java.lang.String, long):boolean");
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task writerTask2 = this.writerTask;
            if (writerTask2 != null) {
                TaskQueue.schedule$default(this.taskQueue, writerTask2, 0, 2, (Object) null);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r8 = (java.lang.String) r27.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01d0, code lost:
        if (r8 != null) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01d2, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d5, code lost:
        r2.onClosed(r5, r6, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01d9, code lost:
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01db, code lost:
        r2 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r4.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01e1, code lost:
        if (r2 == null) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01e3, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01e8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01e9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ea, code lost:
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ed, code lost:
        r4 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f8, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01f9, code lost:
        r4 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0204, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0205, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0207, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0208, code lost:
        r4 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x020c, code lost:
        r2 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r4.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0210, code lost:
        if (r2 != null) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0212, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0217, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0124, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0127, code lost:
        if (r1 == null) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0129, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012b, code lost:
        if (r3 != null) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0130, code lost:
        r3.writePong(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0133, code lost:
        r4 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0139, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013a, code lost:
        r4 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0140, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0146, code lost:
        if ((r14.element instanceof okhttp3.internal.p011ws.RealWebSocket.Message) == false) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r0 = r14.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014a, code lost:
        if (r0 == null) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x014c, code lost:
        r2 = ((okhttp3.internal.p011ws.RealWebSocket.Message) r0).getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0155, code lost:
        if (r3 != null) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0157, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015a, code lost:
        r0 = r14.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015c, code lost:
        if (r0 == null) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015e, code lost:
        r4 = okio.Okio.buffer(r3.newMessageSink(((okhttp3.internal.p011ws.RealWebSocket.Message) r0).getFormatOpcode(), (long) r2.size()));
        r4.write(r2);
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        monitor-enter(r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r13.queueSize -= (long) r2.size();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        monitor-exit(r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0187, code lost:
        r4 = r26;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0196, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019e, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01a3, code lost:
        if ((r14.element instanceof okhttp3.internal.p011ws.RealWebSocket.Close) == false) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01a5, code lost:
        r0 = r14.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a7, code lost:
        if (r0 == null) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a9, code lost:
        r0 = (okhttp3.internal.p011ws.RealWebSocket.Close) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ab, code lost:
        if (r3 != null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r3.writeClose(r0.getCode(), r0.getReason());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01bb, code lost:
        r4 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c1, code lost:
        if (((okhttp3.internal.p011ws.RealWebSocket.Streams) r4.element) == null) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c3, code lost:
        r2 = r13.listener;
        r5 = r13;
        r6 = r15.element;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0212  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            r28 = this;
            r13 = r28
            r1 = 0
            r2 = 0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r3 = 0
            r0.element = r3
            r14 = r0
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            r4 = -1
            r0.element = r4
            r15 = r0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            r0.element = r5
            r12 = r0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r5 = r3
            okhttp3.internal.ws.RealWebSocket$Streams r5 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r5
            r0.element = r5
            r11 = r0
            monitor-enter(r28)
            r0 = 0
            boolean r5 = r13.failed     // Catch:{ all -> 0x022a }
            r6 = 0
            if (r5 == 0) goto L_0x0036
            monitor-exit(r28)
            return r6
        L_0x0036:
            okhttp3.internal.ws.WebSocketWriter r5 = r13.writer     // Catch:{ all -> 0x022a }
            r10 = r5
            java.util.ArrayDeque<okio.ByteString> r1 = r13.pongQueue     // Catch:{ all -> 0x0224 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0224 }
            okio.ByteString r1 = (okio.ByteString) r1     // Catch:{ all -> 0x0224 }
            r9 = r1
            if (r9 != 0) goto L_0x0115
            java.util.ArrayDeque<java.lang.Object> r1 = r13.messageAndCloseQueue     // Catch:{ all -> 0x0108 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0108 }
            r14.element = r1     // Catch:{ all -> 0x0108 }
            T r1 = r14.element     // Catch:{ all -> 0x0108 }
            boolean r1 = r1 instanceof okhttp3.internal.p011ws.RealWebSocket.Close     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x00ec
            int r1 = r13.receivedCloseCode     // Catch:{ all -> 0x0108 }
            r15.element = r1     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = r13.receivedCloseReason     // Catch:{ all -> 0x0108 }
            r12.element = r1     // Catch:{ all -> 0x0108 }
            int r1 = r15.element     // Catch:{ all -> 0x0108 }
            if (r1 == r4) goto L_0x007e
            okhttp3.internal.ws.RealWebSocket$Streams r1 = r13.streams     // Catch:{ all -> 0x0077 }
            r11.element = r1     // Catch:{ all -> 0x0077 }
            okhttp3.internal.ws.RealWebSocket$Streams r3 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r3     // Catch:{ all -> 0x0077 }
            r13.streams = r3     // Catch:{ all -> 0x0077 }
            okhttp3.internal.concurrent.TaskQueue r1 = r13.taskQueue     // Catch:{ all -> 0x0077 }
            r1.shutdown()     // Catch:{ all -> 0x0077 }
            r19 = r0
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            goto L_0x011f
        L_0x0077:
            r0 = move-exception
            r2 = r9
            r1 = r10
            r4 = r11
            r7 = r12
            goto L_0x022d
        L_0x007e:
            T r1 = r14.element     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x00da
            okhttp3.internal.ws.RealWebSocket$Close r1 = (okhttp3.internal.p011ws.RealWebSocket.Close) r1     // Catch:{ all -> 0x0108 }
            long r1 = r1.getCancelAfterCloseMillis()     // Catch:{ all -> 0x0108 }
            r7 = r1
            okhttp3.internal.concurrent.TaskQueue r1 = r13.taskQueue     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r2.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = r13.name     // Catch:{ all -> 0x0108 }
            r2.append(r3)     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = " cancel"
            r2.append(r3)     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0108 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0108 }
            long r3 = r3.toNanos(r7)     // Catch:{ all -> 0x0108 }
            r5 = r3
            r4 = r1
            r16 = 1
            r17 = 0
            okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1 r18 = new okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1     // Catch:{ all -> 0x0108 }
            r1 = r18
            r3 = r16
            r19 = r0
            r0 = r4
            r4 = r2
            r20 = r5
            r5 = r16
            r6 = r28
            r22 = r7
            r7 = r10
            r8 = r9
            r24 = r9
            r9 = r14
            r25 = r10
            r10 = r15
            r26 = r11
            r11 = r12
            r27 = r12
            r12 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00fd }
            r1 = r18
            okhttp3.internal.concurrent.Task r1 = (okhttp3.internal.concurrent.Task) r1     // Catch:{ all -> 0x00fd }
            r3 = r20
            r0.schedule(r1, r3)     // Catch:{ all -> 0x00fd }
            goto L_0x011f
        L_0x00da:
            r19 = r0
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close"
            r0.<init>(r1)     // Catch:{ all -> 0x00fd }
            throw r0     // Catch:{ all -> 0x00fd }
        L_0x00ec:
            r19 = r0
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            T r0 = r14.element     // Catch:{ all -> 0x00fd }
            if (r0 != 0) goto L_0x011f
            monitor-exit(r28)
            return r6
        L_0x00fd:
            r0 = move-exception
            r2 = r24
            r1 = r25
            r4 = r26
            r7 = r27
            goto L_0x022d
        L_0x0108:
            r0 = move-exception
            r24 = r9
            r25 = r10
            r4 = r11
            r7 = r12
            r2 = r24
            r1 = r25
            goto L_0x022d
        L_0x0115:
            r19 = r0
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
        L_0x011f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0218 }
            monitor-exit(r28)
            r1 = r24
            if (r1 == 0) goto L_0x0140
            r3 = r25
            if (r3 != 0) goto L_0x0130
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0139 }
        L_0x0130:
            r3.writePong(r1)     // Catch:{ all -> 0x0139 }
            r4 = r26
            r7 = r27
            goto L_0x01db
        L_0x0139:
            r0 = move-exception
            r4 = r26
            r7 = r27
            goto L_0x020c
        L_0x0140:
            r3 = r25
            T r0 = r14.element     // Catch:{ all -> 0x0207 }
            boolean r0 = r0 instanceof okhttp3.internal.p011ws.RealWebSocket.Message     // Catch:{ all -> 0x0207 }
            if (r0 == 0) goto L_0x019f
            T r0 = r14.element     // Catch:{ all -> 0x0139 }
            if (r0 == 0) goto L_0x0197
            okhttp3.internal.ws.RealWebSocket$Message r0 = (okhttp3.internal.p011ws.RealWebSocket.Message) r0     // Catch:{ all -> 0x0139 }
            okio.ByteString r0 = r0.getData()     // Catch:{ all -> 0x0139 }
            r2 = r0
            if (r3 != 0) goto L_0x015a
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0139 }
        L_0x015a:
            T r0 = r14.element     // Catch:{ all -> 0x0139 }
            if (r0 == 0) goto L_0x018f
            okhttp3.internal.ws.RealWebSocket$Message r0 = (okhttp3.internal.p011ws.RealWebSocket.Message) r0     // Catch:{ all -> 0x0139 }
            int r0 = r0.getFormatOpcode()     // Catch:{ all -> 0x0139 }
            int r4 = r2.size()     // Catch:{ all -> 0x0139 }
            long r4 = (long) r4     // Catch:{ all -> 0x0139 }
            okio.Sink r0 = r3.newMessageSink(r0, r4)     // Catch:{ all -> 0x0139 }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x0139 }
            r4 = r0
            r4.write((okio.ByteString) r2)     // Catch:{ all -> 0x0139 }
            r4.close()     // Catch:{ all -> 0x0139 }
            monitor-enter(r28)     // Catch:{ all -> 0x0139 }
            r0 = 0
            long r5 = r13.queueSize     // Catch:{ all -> 0x018c }
            int r7 = r2.size()     // Catch:{ all -> 0x018c }
            long r7 = (long) r7     // Catch:{ all -> 0x018c }
            long r5 = r5 - r7
            r13.queueSize = r5     // Catch:{ all -> 0x018c }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x018c }
            monitor-exit(r28)     // Catch:{ all -> 0x0139 }
            r4 = r26
            r7 = r27
            goto L_0x01db
        L_0x018c:
            r0 = move-exception
            monitor-exit(r28)     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ all -> 0x0139 }
        L_0x018f:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x0139 }
            java.lang.String r4 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message"
            r0.<init>(r4)     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ all -> 0x0139 }
        L_0x0197:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x0139 }
            java.lang.String r2 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message"
            r0.<init>(r2)     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ all -> 0x0139 }
        L_0x019f:
            T r0 = r14.element     // Catch:{ all -> 0x0207 }
            boolean r0 = r0 instanceof okhttp3.internal.p011ws.RealWebSocket.Close     // Catch:{ all -> 0x0207 }
            if (r0 == 0) goto L_0x01f9
            T r0 = r14.element     // Catch:{ all -> 0x0207 }
            if (r0 == 0) goto L_0x01ed
            okhttp3.internal.ws.RealWebSocket$Close r0 = (okhttp3.internal.p011ws.RealWebSocket.Close) r0     // Catch:{ all -> 0x0207 }
            if (r3 != 0) goto L_0x01b0
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0139 }
        L_0x01b0:
            int r2 = r0.getCode()     // Catch:{ all -> 0x0207 }
            okio.ByteString r4 = r0.getReason()     // Catch:{ all -> 0x0207 }
            r3.writeClose(r2, r4)     // Catch:{ all -> 0x0207 }
            r4 = r26
            T r2 = r4.element     // Catch:{ all -> 0x01e9 }
            okhttp3.internal.ws.RealWebSocket$Streams r2 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r2     // Catch:{ all -> 0x01e9 }
            if (r2 == 0) goto L_0x01d9
            okhttp3.WebSocketListener r2 = r13.listener     // Catch:{ all -> 0x01e9 }
            r5 = r13
            okhttp3.WebSocket r5 = (okhttp3.WebSocket) r5     // Catch:{ all -> 0x01e9 }
            int r6 = r15.element     // Catch:{ all -> 0x01e9 }
            r7 = r27
            T r8 = r7.element     // Catch:{ all -> 0x0205 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0205 }
            if (r8 != 0) goto L_0x01d5
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0205 }
        L_0x01d5:
            r2.onClosed(r5, r6, r8)     // Catch:{ all -> 0x0205 }
            goto L_0x01db
        L_0x01d9:
            r7 = r27
        L_0x01db:
            r0 = 1
            T r2 = r4.element
            okhttp3.internal.ws.RealWebSocket$Streams r2 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r2
            if (r2 == 0) goto L_0x01e8
            java.io.Closeable r2 = (java.io.Closeable) r2
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x01e8:
            return r0
        L_0x01e9:
            r0 = move-exception
            r7 = r27
            goto L_0x020c
        L_0x01ed:
            r4 = r26
            r7 = r27
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x0205 }
            java.lang.String r2 = "null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close"
            r0.<init>(r2)     // Catch:{ all -> 0x0205 }
            throw r0     // Catch:{ all -> 0x0205 }
        L_0x01f9:
            r4 = r26
            r7 = r27
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x0205 }
            r0.<init>()     // Catch:{ all -> 0x0205 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0205 }
            throw r0     // Catch:{ all -> 0x0205 }
        L_0x0205:
            r0 = move-exception
            goto L_0x020c
        L_0x0207:
            r0 = move-exception
            r4 = r26
            r7 = r27
        L_0x020c:
            T r2 = r4.element
            okhttp3.internal.ws.RealWebSocket$Streams r2 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r2
            if (r2 == 0) goto L_0x0217
            java.io.Closeable r2 = (java.io.Closeable) r2
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0217:
            throw r0
        L_0x0218:
            r0 = move-exception
            r1 = r24
            r3 = r25
            r4 = r26
            r7 = r27
            r2 = r1
            r1 = r3
            goto L_0x022d
        L_0x0224:
            r0 = move-exception
            r3 = r10
            r4 = r11
            r7 = r12
            r1 = r3
            goto L_0x022d
        L_0x022a:
            r0 = move-exception
            r4 = r11
            r7 = r12
        L_0x022d:
            monitor-exit(r28)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p011ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        if (r1 == -1) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r4 = new java.lang.StringBuilder();
        r4.append("sent ping but didn't receive pong within ");
        r4.append(r7.pingIntervalMillis);
        r4.append("ms (after ");
        r4.append(r1 - 1);
        r4.append(" successful ping/pongs)");
        failWebSocket(new java.net.SocketTimeoutException(r4.toString()), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r0 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r0.writePing(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        failWebSocket(r3, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writePingFrame$okhttp() {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            monitor-enter(r7)
            r2 = 0
            boolean r3 = r7.failed     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x000a
            monitor-exit(r7)
            return
        L_0x000a:
            okhttp3.internal.ws.WebSocketWriter r3 = r7.writer     // Catch:{ all -> 0x0068 }
            r0 = r3
            boolean r3 = r7.awaitingPong     // Catch:{ all -> 0x0068 }
            r4 = -1
            if (r3 == 0) goto L_0x0015
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0068 }
            goto L_0x0016
        L_0x0015:
            r3 = -1
        L_0x0016:
            r1 = r3
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0068 }
            r5 = 1
            int r3 = r3 + r5
            r7.sentPingCount = r3     // Catch:{ all -> 0x0068 }
            r7.awaitingPong = r5     // Catch:{ all -> 0x0068 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0068 }
            monitor-exit(r7)
            r2 = 0
            if (r1 == r4) goto L_0x0053
            java.net.SocketTimeoutException r3 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r4.append(r5)
            long r5 = r7.pingIntervalMillis
            r4.append(r5)
            java.lang.String r5 = "ms (after "
            r4.append(r5)
            int r5 = r1 + -1
            r4.append(r5)
            java.lang.String r5 = " successful ping/pongs)"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            java.lang.Exception r3 = (java.lang.Exception) r3
            r7.failWebSocket(r3, r2)
            return
        L_0x0053:
            if (r0 != 0) goto L_0x0059
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ IOException -> 0x005f }
        L_0x0059:
            okio.ByteString r3 = okio.ByteString.EMPTY     // Catch:{ IOException -> 0x005f }
            r0.writePing(r3)     // Catch:{ IOException -> 0x005f }
            goto L_0x0066
        L_0x005f:
            r3 = move-exception
            r4 = r3
            java.lang.Exception r4 = (java.lang.Exception) r4
            r7.failWebSocket(r4, r2)
        L_0x0066:
            return
        L_0x0068:
            r2 = move-exception
            monitor-exit(r7)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p011ws.RealWebSocket.writePingFrame$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4.listener.onFailure(r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r0 != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failWebSocket(java.lang.Exception r5, okhttp3.Response r6) {
        /*
            r4 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            r0 = 0
            monitor-enter(r4)
            r1 = 0
            boolean r2 = r4.failed     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x000e
            monitor-exit(r4)
            return
        L_0x000e:
            r2 = 1
            r4.failed = r2     // Catch:{ all -> 0x0041 }
            okhttp3.internal.ws.RealWebSocket$Streams r2 = r4.streams     // Catch:{ all -> 0x0041 }
            r0 = r2
            r2 = 0
            okhttp3.internal.ws.RealWebSocket$Streams r2 = (okhttp3.internal.p011ws.RealWebSocket.Streams) r2     // Catch:{ all -> 0x0041 }
            r4.streams = r2     // Catch:{ all -> 0x0041 }
            okhttp3.internal.concurrent.TaskQueue r2 = r4.taskQueue     // Catch:{ all -> 0x0041 }
            r2.shutdown()     // Catch:{ all -> 0x0041 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            monitor-exit(r4)
            okhttp3.WebSocketListener r1 = r4.listener     // Catch:{ all -> 0x0037 }
            r2 = r4
            okhttp3.WebSocket r2 = (okhttp3.WebSocket) r2     // Catch:{ all -> 0x0037 }
            r3 = r5
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x0037 }
            r1.onFailure(r2, r3, r6)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0035
            r1 = r0
            java.io.Closeable r1 = (java.io.Closeable) r1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0035:
            return
        L_0x0037:
            r1 = move-exception
            if (r0 == 0) goto L_0x0040
            r2 = r0
            java.io.Closeable r2 = (java.io.Closeable) r2
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0040:
            throw r1
        L_0x0041:
            r1 = move-exception
            monitor-exit(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p011ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo20370d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Message */
    /* compiled from: RealWebSocket.kt */
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int formatOpcode2, ByteString data2) {
            Intrinsics.checkParameterIsNotNull(data2, "data");
            this.formatOpcode = formatOpcode2;
            this.data = data2;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final ByteString getData() {
            return this.data;
        }
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo20370d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Close */
    /* compiled from: RealWebSocket.kt */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int code2, ByteString reason2, long cancelAfterCloseMillis2) {
            this.code = code2;
            this.reason = reason2;
            this.cancelAfterCloseMillis = cancelAfterCloseMillis2;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo20370d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Streams */
    /* compiled from: RealWebSocket.kt */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean client2, BufferedSource source2, BufferedSink sink2) {
            Intrinsics.checkParameterIsNotNull(source2, FirebaseAnalytics.Param.SOURCE);
            Intrinsics.checkParameterIsNotNull(sink2, "sink");
            this.client = client2;
            this.source = source2;
            this.sink = sink2;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo20370d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$WriterTask */
    /* compiled from: RealWebSocket.kt */
    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, (DefaultConstructorMarker) null);
        }

        public long runOnce() {
            try {
                if (RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0;
                }
                return -1;
            } catch (IOException e) {
                RealWebSocket.this.failWebSocket(e, (Response) null);
                return -1;
            }
        }
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo20370d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Companion */
    /* compiled from: RealWebSocket.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
