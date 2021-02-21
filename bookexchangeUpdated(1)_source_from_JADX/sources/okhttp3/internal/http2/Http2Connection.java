package okhttp3.internal.http2;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00012\u00020\u0001:\b\u0001\u0001\u0001\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020QH\u0016J'\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WH\u0000¢\u0006\u0002\bXJ\u0012\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010WH\u0002J\u0006\u0010[\u001a\u00020QJ\u0010\u0010\\\u001a\u0004\u0018\u00010B2\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0006J&\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010`\u001a\u00020B2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020\u0012J-\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0002\bmJ+\u0010n\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0002\boJ#\u0010p\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0002\bqJ\u001d\u0010r\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000¢\u0006\u0002\btJ$\u0010u\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0015\u0010v\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0012H\u0000¢\u0006\u0002\bwJ\u0017\u0010x\u001a\u0004\u0018\u00010B2\u0006\u0010h\u001a\u00020\u0012H\u0000¢\u0006\u0002\byJ\r\u0010z\u001a\u00020QH\u0000¢\u0006\u0002\b{J\u000e\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020&J\u000e\u0010~\u001a\u00020Q2\u0006\u0010\u001a\u00020TJ\u0014\u0010\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0001\u001a\u00020\tH\u0007J\u0018\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u0001J,\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\t2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010k\u001a\u00020\u0006J/\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\t2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020QJ\"\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012J\u0007\u0010\u0001\u001a\u00020QJ\u001f\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010\u001a\u00020TH\u0000¢\u0006\u0003\b\u0001J\u001f\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000¢\u0006\u0003\b\u0001J \u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010(\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0015\u00107\u001a\u000608R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020=X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020B0AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u001e\u0010I\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010K\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo20370d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitPingsSent", "", "awaitPongsReceived", "client", "", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "awaitPong", "", "close", "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "flush", "getStream", "id", "isHealthy", "nowNs", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", "source", "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", "errorCode", "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "setSettings", "settings", "shutdown", "statusCode", "start", "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: Http2Connection.kt */
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    /* access modifiers changed from: private */
    public long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    /* access modifiers changed from: private */
    public final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    /* access modifiers changed from: private */
    public long degradedPongsReceived;
    /* access modifiers changed from: private */
    public long intervalPingsSent;
    /* access modifiers changed from: private */
    public long intervalPongsReceived;
    /* access modifiers changed from: private */
    public boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    /* access modifiers changed from: private */
    public final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    /* access modifiers changed from: private */
    public final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final TaskRunner taskRunner;
    /* access modifiers changed from: private */
    public long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    /* access modifiers changed from: private */
    public final TaskQueue writerQueue;

    public final void start() throws IOException {
        start$default(this, false, 1, (Object) null);
    }

    public Http2Connection(Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.client = builder.getClient$okhttp();
        this.listener = builder.getListener$okhttp();
        this.connectionName = builder.getConnectionName$okhttp();
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        this.writerQueue = taskRunner$okhttp.newQueue();
        this.pushQueue = this.taskRunner.newQueue();
        this.settingsListenerQueue = this.taskRunner.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        Settings $this$apply = settings;
        if (builder.getClient$okhttp()) {
            $this$apply.set(7, 16777216);
        }
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = (long) settings2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), this.client);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), this.client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long pingIntervalNanos = TimeUnit.MILLISECONDS.toNanos((long) builder.getPingIntervalMillis$okhttp());
            String name$iv = this.connectionName + " ping";
            this.writerQueue.schedule(new Http2Connection$$special$$inlined$schedule$1(name$iv, name$iv, this, pingIntervalNanos), pingIntervalNanos);
        }
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final void setPeerSettings(Settings settings) {
        Intrinsics.checkParameterIsNotNull(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final synchronized Http2Stream getStream(int id) {
        return this.streams.get(Integer.valueOf(id));
    }

    public final synchronized Http2Stream removeStream$okhttp(int streamId) {
        Http2Stream stream;
        stream = this.streams.remove(Integer.valueOf(streamId));
        notifyAll();
        return stream;
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long read) {
        long j = this.readBytesTotal + read;
        this.readBytesTotal = j;
        long readBytesToAcknowledge = j - this.readBytesAcknowledged;
        if (readBytesToAcknowledge >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater$okhttp(0, readBytesToAcknowledge);
            this.readBytesAcknowledged += readBytesToAcknowledge;
        }
    }

    public final Http2Stream pushStream(int associatedStreamId, List<Header> requestHeaders, boolean out) throws IOException {
        Intrinsics.checkParameterIsNotNull(requestHeaders, "requestHeaders");
        if (!this.client) {
            return newStream(associatedStreamId, requestHeaders, out);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final Http2Stream newStream(List<Header> requestHeaders, boolean out) throws IOException {
        Intrinsics.checkParameterIsNotNull(requestHeaders, "requestHeaders");
        return newStream(0, requestHeaders, out);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final okhttp3.internal.http2.Http2Stream newStream(int r20, java.util.List<okhttp3.internal.http2.Header> r21, boolean r22) throws java.io.IOException {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r0 = r22 ^ 1
            r10 = r0
            r11 = 0
            r12 = 0
            r13 = 0
            r1 = 0
            okhttp3.internal.http2.Http2Writer r14 = r7.writer
            monitor-enter(r14)
            r15 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00c2 }
            r0 = 0
            int r2 = r7.nextStreamId     // Catch:{ all -> 0x00bf }
            r3 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 <= r3) goto L_0x001f
            okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x00bf }
            r7.shutdown(r2)     // Catch:{ all -> 0x00bf }
        L_0x001f:
            boolean r2 = r7.isShutdown     // Catch:{ all -> 0x00bf }
            if (r2 != 0) goto L_0x00b7
            int r2 = r7.nextStreamId     // Catch:{ all -> 0x00bf }
            r6 = r2
            int r1 = r7.nextStreamId     // Catch:{ all -> 0x00b3 }
            int r1 = r1 + 2
            r7.nextStreamId = r1     // Catch:{ all -> 0x00b3 }
            okhttp3.internal.http2.Http2Stream r16 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x00b3 }
            r17 = 0
            r1 = r16
            r2 = r6
            r3 = r19
            r4 = r10
            r5 = r11
            r18 = r6
            r6 = r17
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00ae }
            r13 = r16
            r1 = 1
            if (r22 == 0) goto L_0x0061
            long r2 = r7.writeBytesTotal     // Catch:{ all -> 0x005c }
            long r4 = r7.writeBytesMaximum     // Catch:{ all -> 0x005c }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0061
            long r2 = r13.getWriteBytesTotal()     // Catch:{ all -> 0x005c }
            long r4 = r13.getWriteBytesMaximum()     // Catch:{ all -> 0x005c }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x005a
            goto L_0x0061
        L_0x005a:
            r2 = 0
            goto L_0x0062
        L_0x005c:
            r0 = move-exception
            r1 = r18
            goto L_0x00c0
        L_0x0061:
            r2 = 1
        L_0x0062:
            r12 = r2
            boolean r2 = r13.isOpen()     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x0072
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r2 = r7.streams     // Catch:{ all -> 0x005c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)     // Catch:{ all -> 0x005c }
            r2.put(r3, r13)     // Catch:{ all -> 0x005c }
        L_0x0072:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ae }
            monitor-exit(r19)     // Catch:{ all -> 0x00a9 }
            if (r8 != 0) goto L_0x007f
            okhttp3.internal.http2.Http2Writer r0 = r7.writer     // Catch:{ all -> 0x00a9 }
            r2 = r18
            r0.headers(r10, r2, r9)     // Catch:{ all -> 0x00a6 }
            goto L_0x008b
        L_0x007f:
            r2 = r18
            boolean r0 = r7.client     // Catch:{ all -> 0x00a6 }
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0097
            okhttp3.internal.http2.Http2Writer r0 = r7.writer     // Catch:{ all -> 0x00a6 }
            r0.pushPromise(r8, r2, r9)     // Catch:{ all -> 0x00a6 }
        L_0x008b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a6 }
            monitor-exit(r14)
            if (r12 == 0) goto L_0x0096
            okhttp3.internal.http2.Http2Writer r0 = r7.writer
            r0.flush()
        L_0x0096:
            return r13
        L_0x0097:
            r0 = 0
            java.lang.String r1 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a6 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a6 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00a6 }
            throw r0     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            r1 = r2
            goto L_0x00c3
        L_0x00a9:
            r0 = move-exception
            r2 = r18
            r1 = r2
            goto L_0x00c3
        L_0x00ae:
            r0 = move-exception
            r2 = r18
            r1 = r2
            goto L_0x00c0
        L_0x00b3:
            r0 = move-exception
            r2 = r6
            r1 = r2
            goto L_0x00c0
        L_0x00b7:
            okhttp3.internal.http2.ConnectionShutdownException r2 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x00bf }
            r2.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x00bf }
            throw r2     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r0 = move-exception
        L_0x00c0:
            monitor-exit(r19)     // Catch:{ all -> 0x00c2 }
            throw r0     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r0 = move-exception
        L_0x00c3:
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    public final void writeHeaders$okhttp(int streamId, boolean outFinished, List<Header> alternating) throws IOException {
        Intrinsics.checkParameterIsNotNull(alternating, "alternating");
        this.writer.headers(outFinished, streamId, alternating);
    }

    public final void writeData(int streamId, boolean outFinished, Buffer buffer, long byteCount) throws IOException {
        int i = streamId;
        boolean z = outFinished;
        Buffer buffer2 = buffer;
        if (byteCount == 0) {
            this.writer.data(z, i, buffer2, 0);
            return;
        }
        long byteCount2 = byteCount;
        while (byteCount2 > 0) {
            Ref.IntRef toWrite = new Ref.IntRef();
            synchronized (this) {
                while (this.writeBytesTotal >= this.writeBytesMaximum) {
                    try {
                        if (this.streams.containsKey(Integer.valueOf(streamId))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                toWrite.element = (int) Math.min(byteCount2, this.writeBytesMaximum - this.writeBytesTotal);
                toWrite.element = Math.min(toWrite.element, this.writer.maxDataLength());
                this.writeBytesTotal += (long) toWrite.element;
                Unit unit = Unit.INSTANCE;
            }
            byteCount2 -= (long) toWrite.element;
            this.writer.data(z && byteCount2 == 0, i, buffer2, toWrite.element);
        }
    }

    public final void writeSynResetLater$okhttp(int streamId, ErrorCode errorCode) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        String name$iv = this.connectionName + '[' + streamId + "] writeSynReset";
        this.writerQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$1(name$iv, true, name$iv, true, this, streamId, errorCode), 0);
    }

    public final void writeSynReset$okhttp(int streamId, ErrorCode statusCode) throws IOException {
        Intrinsics.checkParameterIsNotNull(statusCode, "statusCode");
        this.writer.rstStream(streamId, statusCode);
    }

    public final void writeWindowUpdateLater$okhttp(int streamId, long unacknowledgedBytesRead) {
        String name$iv = this.connectionName + '[' + streamId + "] windowUpdate";
        this.writerQueue.schedule(new Http2Connection$writeWindowUpdateLater$$inlined$execute$1(name$iv, true, name$iv, true, this, streamId, unacknowledgedBytesRead), 0);
    }

    public final void writePing(boolean reply, int payload1, int payload2) {
        try {
            this.writer.ping(reply, payload1, payload2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final void shutdown(ErrorCode statusCode) throws IOException {
        Intrinsics.checkParameterIsNotNull(statusCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.isShutdown) {
                    this.isShutdown = true;
                    int lastGoodStreamId2 = this.lastGoodStreamId;
                    Unit unit = Unit.INSTANCE;
                    this.writer.goAway(lastGoodStreamId2, statusCode, Util.EMPTY_BYTE_ARRAY);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, (IOException) null);
    }

    public final void close$okhttp(ErrorCode connectionCode, ErrorCode streamCode, IOException cause) {
        int i;
        Intrinsics.checkParameterIsNotNull(connectionCode, "connectionCode");
        Intrinsics.checkParameterIsNotNull(streamCode, "streamCode");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            try {
                shutdown(connectionCode);
            } catch (IOException e) {
            }
            Http2Stream[] http2StreamArr = null;
            synchronized (this) {
                if (!this.streams.isEmpty()) {
                    Object[] array = this.streams.values().toArray(new Http2Stream[0]);
                    if (array != null) {
                        http2StreamArr = (Http2Stream[]) array;
                        this.streams.clear();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            if (http2StreamArr != null) {
                for (Http2Stream stream : http2StreamArr) {
                    try {
                        stream.close(streamCode, cause);
                    } catch (IOException e2) {
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException e3) {
            }
            try {
                this.socket.close();
            } catch (IOException e4) {
            }
            this.writerQueue.shutdown();
            this.pushQueue.shutdown();
            this.settingsListenerQueue.shutdown();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    /* access modifiers changed from: private */
    public final void failConnection(IOException e) {
        close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, e);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        http2Connection.start(z);
    }

    public final void start(boolean sendConnectionPreface) throws IOException {
        if (sendConnectionPreface) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int windowSize = this.okHttpSettings.getInitialWindowSize();
            if (windowSize != 65535) {
                this.writer.windowUpdate(0, (long) (windowSize - 65535));
            }
        }
        new Thread(this.readerRunnable, this.connectionName).start();
    }

    public final void setSettings(Settings settings) throws IOException {
        Intrinsics.checkParameterIsNotNull(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.isShutdown) {
                    this.okHttpSettings.merge(settings);
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final synchronized boolean isHealthy(long nowNs) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived >= this.degradedPingsSent || nowNs < this.degradedPongDeadlineNs) {
            return true;
        }
        return false;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            if (this.degradedPongsReceived >= this.degradedPingsSent) {
                this.degradedPingsSent++;
                this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
                Unit unit = Unit.INSTANCE;
                String name$iv = this.connectionName + " ping";
                this.writerQueue.schedule(new Http2Connection$sendDegradedPingLater$$inlined$execute$1(name$iv, true, name$iv, true, this), 0);
            }
        }
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00107\u001a\u000208J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010#\u001a\u00020$H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006:"}, mo20370d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "build", "Lokhttp3/internal/http2/Http2Connection;", "peerName", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: Http2Connection.kt */
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        private int pingIntervalMillis;
        private PushObserver pushObserver = PushObserver.CANCEL;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        private final TaskRunner taskRunner;

        public final Builder socket(Socket socket2) throws IOException {
            return socket$default(this, socket2, (String) null, (BufferedSource) null, (BufferedSink) null, 14, (Object) null);
        }

        public final Builder socket(Socket socket2, String str) throws IOException {
            return socket$default(this, socket2, str, (BufferedSource) null, (BufferedSink) null, 12, (Object) null);
        }

        public final Builder socket(Socket socket2, String str, BufferedSource bufferedSource) throws IOException {
            return socket$default(this, socket2, str, bufferedSource, (BufferedSink) null, 8, (Object) null);
        }

        public Builder(boolean client2, TaskRunner taskRunner2) {
            Intrinsics.checkParameterIsNotNull(taskRunner2, "taskRunner");
            this.client = client2;
            this.taskRunner = taskRunner2;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Socket getSocket$okhttp() {
            Socket socket2 = this.socket;
            if (socket2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
            }
            return socket2;
        }

        public final void setSocket$okhttp(Socket socket2) {
            Intrinsics.checkParameterIsNotNull(socket2, "<set-?>");
            this.socket = socket2;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            }
            return str;
        }

        public final void setConnectionName$okhttp(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.connectionName = str;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource == null) {
                Intrinsics.throwUninitializedPropertyAccessException(FirebaseAnalytics.Param.SOURCE);
            }
            return bufferedSource;
        }

        public final void setSource$okhttp(BufferedSource bufferedSource) {
            Intrinsics.checkParameterIsNotNull(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sink");
            }
            return bufferedSink;
        }

        public final void setSink$okhttp(BufferedSink bufferedSink) {
            Intrinsics.checkParameterIsNotNull(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final void setListener$okhttp(Listener listener2) {
            Intrinsics.checkParameterIsNotNull(listener2, "<set-?>");
            this.listener = listener2;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver2) {
            Intrinsics.checkParameterIsNotNull(pushObserver2, "<set-?>");
            this.pushObserver = pushObserver2;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i, Object obj) throws IOException {
            if ((i & 2) != 0) {
                str = Util.peerName(socket2);
            }
            if ((i & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket2));
            }
            if ((i & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket2));
            }
            return builder.socket(socket2, str, bufferedSource, bufferedSink);
        }

        public final Builder socket(Socket socket2, String peerName, BufferedSource source2, BufferedSink sink2) throws IOException {
            String str;
            Intrinsics.checkParameterIsNotNull(socket2, "socket");
            Intrinsics.checkParameterIsNotNull(peerName, "peerName");
            Intrinsics.checkParameterIsNotNull(source2, FirebaseAnalytics.Param.SOURCE);
            Intrinsics.checkParameterIsNotNull(sink2, "sink");
            Builder $this$apply = this;
            $this$apply.socket = socket2;
            if ($this$apply.client) {
                str = "OkHttp " + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            $this$apply.connectionName = str;
            $this$apply.source = source2;
            $this$apply.sink = sink2;
            return this;
        }

        public final Builder listener(Listener listener2) {
            Intrinsics.checkParameterIsNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.listener = listener2;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver2) {
            Intrinsics.checkParameterIsNotNull(pushObserver2, "pushObserver");
            this.pushObserver = pushObserver2;
            return this;
        }

        public final Builder pingIntervalMillis(int pingIntervalMillis2) {
            this.pingIntervalMillis = pingIntervalMillis2;
            return this;
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J8\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J.\u0010$\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J \u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016J(\u0010-\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0017H\u0016J&\u00101\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u00104\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u00105\u001a\u00020\tH\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u00068"}, mo20370d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Ljava/lang/Runnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "run", "windowUpdate", "windowSizeIncrement", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: Http2Connection.kt */
    public final class ReaderRunnable implements Runnable, Http2Reader.Handler {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection $outer, Http2Reader reader2) {
            Intrinsics.checkParameterIsNotNull(reader2, "reader");
            this.this$0 = $outer;
            this.reader = reader2;
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        public void run() {
            ErrorCode streamErrorCode;
            ErrorCode connectionErrorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode streamErrorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException errorException = null;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                connectionErrorCode = ErrorCode.NO_ERROR;
                streamErrorCode = ErrorCode.CANCEL;
            } catch (IOException e) {
                errorException = e;
                connectionErrorCode = ErrorCode.PROTOCOL_ERROR;
                streamErrorCode = ErrorCode.PROTOCOL_ERROR;
            } catch (Throwable th) {
                this.this$0.close$okhttp(connectionErrorCode, streamErrorCode2, errorException);
                Util.closeQuietly((Closeable) this.reader);
                throw th;
            }
            this.this$0.close$okhttp(connectionErrorCode, streamErrorCode, errorException);
            Util.closeQuietly((Closeable) this.reader);
        }

        public void data(boolean inFinished, int streamId, BufferedSource source, int length) throws IOException {
            Intrinsics.checkParameterIsNotNull(source, FirebaseAnalytics.Param.SOURCE);
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushDataLater$okhttp(streamId, source, length, inFinished);
                return;
            }
            Http2Stream dataStream = this.this$0.getStream(streamId);
            if (dataStream == null) {
                this.this$0.writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
                this.this$0.updateConnectionFlowControl$okhttp((long) length);
                source.skip((long) length);
                return;
            }
            dataStream.receiveData(source, length);
            if (inFinished) {
                dataStream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public void headers(boolean inFinished, int streamId, int associatedStreamId, List<Header> headerBlock) {
            Http2Connection http2Connection;
            boolean z = inFinished;
            int i = streamId;
            List<Header> list = headerBlock;
            Intrinsics.checkParameterIsNotNull(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushHeadersLater$okhttp(i, list, z);
                return;
            }
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection2) {
                try {
                    Http2Stream stream = this.this$0.getStream(i);
                    if (stream == null) {
                        try {
                            if (!this.this$0.isShutdown) {
                                if (i > this.this$0.getLastGoodStreamId$okhttp()) {
                                    if (i % 2 != this.this$0.getNextStreamId$okhttp() % 2) {
                                        Http2Stream newStream = new Http2Stream(streamId, this.this$0, false, inFinished, Util.toHeaders(headerBlock));
                                        this.this$0.setLastGoodStreamId$okhttp(i);
                                        this.this$0.getStreams$okhttp().put(Integer.valueOf(streamId), newStream);
                                        String name$iv = this.this$0.getConnectionName$okhttp() + '[' + i + "] onStream";
                                        TaskQueue this_$iv = this.this$0.taskRunner.newQueue();
                                        Http2Stream stream2 = stream;
                                        http2Connection = http2Connection2;
                                        boolean z2 = z;
                                        try {
                                            C1229xe89ff7cd http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1 = new C1229xe89ff7cd(name$iv, true, name$iv, true, newStream, this, stream2, streamId, headerBlock, inFinished);
                                            this_$iv.schedule(http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1, 0);
                                        } catch (Throwable th) {
                                            th = th;
                                            Http2Stream http2Stream = stream2;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            http2Connection = http2Connection2;
                            boolean z3 = z;
                            Http2Stream http2Stream2 = stream;
                            throw th;
                        }
                    } else {
                        Http2Stream stream3 = stream;
                        http2Connection = http2Connection2;
                        boolean z4 = z;
                        try {
                            Unit unit = Unit.INSTANCE;
                            stream3.receiveHeaders(Util.toHeaders(headerBlock), z4);
                        } catch (Throwable th3) {
                            th = th3;
                            Http2Stream http2Stream3 = stream3;
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    http2Connection = http2Connection2;
                    boolean z5 = z;
                    throw th;
                }
            }
        }

        public void rstStream(int streamId, ErrorCode errorCode) {
            Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushResetLater$okhttp(streamId, errorCode);
                return;
            }
            Http2Stream rstStream = this.this$0.removeStream$okhttp(streamId);
            if (rstStream != null) {
                rstStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean clearPrevious, Settings settings) {
            Intrinsics.checkParameterIsNotNull(settings, "settings");
            String name$iv = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            this.this$0.writerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$1(name$iv, true, name$iv, true, this, clearPrevious, settings), 0);
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            	at java.base/java.util.Objects.checkIndex(Objects.java:372)
            	at java.base/java.util.ArrayList.get(ArrayList.java:458)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public final void applyAndAckSettings(boolean r29, okhttp3.internal.http2.Settings r30) {
            /*
                r28 = this;
                r12 = r28
                r13 = r30
                java.lang.String r0 = "settings"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
                kotlin.jvm.internal.Ref$LongRef r0 = new kotlin.jvm.internal.Ref$LongRef
                r0.<init>()
                r14 = r0
                kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
                r0.<init>()
                r15 = r0
                kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
                r0.<init>()
                r11 = r0
                okhttp3.internal.http2.Http2Connection r0 = r12.this$0
                okhttp3.internal.http2.Http2Writer r16 = r0.getWriter()
                monitor-enter(r16)
                r17 = 0
                okhttp3.internal.http2.Http2Connection r10 = r12.this$0     // Catch:{ all -> 0x015e }
                monitor-enter(r10)     // Catch:{ all -> 0x015e }
                r0 = 0
                okhttp3.internal.http2.Http2Connection r1 = r12.this$0     // Catch:{ all -> 0x0154 }
                okhttp3.internal.http2.Settings r1 = r1.getPeerSettings()     // Catch:{ all -> 0x0154 }
                r9 = r1
                if (r29 == 0) goto L_0x003c
                r11.element = r13     // Catch:{ all -> 0x0034 }
                goto L_0x004c
            L_0x0034:
                r0 = move-exception
                r26 = r10
                r1 = r12
                r5 = r14
                r14 = r11
                goto L_0x015a
            L_0x003c:
                okhttp3.internal.http2.Settings r1 = new okhttp3.internal.http2.Settings     // Catch:{ all -> 0x0154 }
                r1.<init>()     // Catch:{ all -> 0x0154 }
                r2 = r1
                r3 = 0
                r2.merge(r9)     // Catch:{ all -> 0x0154 }
                r2.merge(r13)     // Catch:{ all -> 0x0154 }
                r11.element = r1     // Catch:{ all -> 0x0154 }
            L_0x004c:
                T r1 = r11.element     // Catch:{ all -> 0x0154 }
                okhttp3.internal.http2.Settings r1 = (okhttp3.internal.http2.Settings) r1     // Catch:{ all -> 0x0154 }
                int r1 = r1.getInitialWindowSize()     // Catch:{ all -> 0x0154 }
                long r7 = (long) r1     // Catch:{ all -> 0x0154 }
                int r1 = r9.getInitialWindowSize()     // Catch:{ all -> 0x0154 }
                long r1 = (long) r1     // Catch:{ all -> 0x0154 }
                long r1 = r7 - r1
                r14.element = r1     // Catch:{ all -> 0x0154 }
                long r1 = r14.element     // Catch:{ all -> 0x0154 }
                r3 = 0
                r6 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0095
                okhttp3.internal.http2.Http2Connection r1 = r12.this$0     // Catch:{ all -> 0x0034 }
                java.util.Map r1 = r1.getStreams$okhttp()     // Catch:{ all -> 0x0034 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0076
                goto L_0x0095
            L_0x0076:
                okhttp3.internal.http2.Http2Connection r1 = r12.this$0     // Catch:{ all -> 0x0034 }
                java.util.Map r1 = r1.getStreams$okhttp()     // Catch:{ all -> 0x0034 }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0034 }
                r2 = 0
                r3 = r1
                okhttp3.internal.http2.Http2Stream[] r4 = new okhttp3.internal.http2.Http2Stream[r6]     // Catch:{ all -> 0x0034 }
                java.lang.Object[] r4 = r3.toArray(r4)     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x008d
                okhttp3.internal.http2.Http2Stream[] r4 = (okhttp3.internal.http2.Http2Stream[]) r4     // Catch:{ all -> 0x0034 }
                goto L_0x0096
            L_0x008d:
                kotlin.TypeCastException r4 = new kotlin.TypeCastException     // Catch:{ all -> 0x0034 }
                java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                throw r4     // Catch:{ all -> 0x0034 }
            L_0x0095:
                r4 = 0
            L_0x0096:
                r15.element = r4     // Catch:{ all -> 0x0154 }
                okhttp3.internal.http2.Http2Connection r1 = r12.this$0     // Catch:{ all -> 0x0154 }
                T r2 = r11.element     // Catch:{ all -> 0x0154 }
                okhttp3.internal.http2.Settings r2 = (okhttp3.internal.http2.Settings) r2     // Catch:{ all -> 0x0154 }
                r1.setPeerSettings(r2)     // Catch:{ all -> 0x0154 }
                okhttp3.internal.http2.Http2Connection r1 = r12.this$0     // Catch:{ all -> 0x0154 }
                okhttp3.internal.concurrent.TaskQueue r1 = r1.settingsListenerQueue     // Catch:{ all -> 0x0154 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0154 }
                r2.<init>()     // Catch:{ all -> 0x0154 }
                okhttp3.internal.http2.Http2Connection r3 = r12.this$0     // Catch:{ all -> 0x0154 }
                java.lang.String r3 = r3.getConnectionName$okhttp()     // Catch:{ all -> 0x0154 }
                r2.append(r3)     // Catch:{ all -> 0x0154 }
                java.lang.String r3 = " onSettings"
                r2.append(r3)     // Catch:{ all -> 0x0154 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0154 }
                r5 = r1
                r3 = 0
                r18 = 1
                r19 = 0
                okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1 r20 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1     // Catch:{ all -> 0x0154 }
                r1 = r20
                r12 = r3
                r3 = r18
                r4 = r2
                r21 = r0
                r0 = r5
                r5 = r18
                r22 = 0
                r6 = r28
                r23 = r7
                r7 = r29
                r8 = r11
                r25 = r9
                r9 = r30
                r26 = r10
                r10 = r14
                r27 = r14
                r14 = r11
                r11 = r15
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x014e }
                r1 = r20
                okhttp3.internal.concurrent.Task r1 = (okhttp3.internal.concurrent.Task) r1     // Catch:{ all -> 0x014e }
                r0.schedule(r1, r12)     // Catch:{ all -> 0x014e }
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014e }
                monitor-exit(r26)     // Catch:{ all -> 0x0148 }
                r1 = r28
                okhttp3.internal.http2.Http2Connection r0 = r1.this$0     // Catch:{ IOException -> 0x010b, all -> 0x0107 }
                okhttp3.internal.http2.Http2Writer r0 = r0.getWriter()     // Catch:{ IOException -> 0x010b, all -> 0x0107 }
                T r2 = r14.element     // Catch:{ IOException -> 0x010b, all -> 0x0107 }
                okhttp3.internal.http2.Settings r2 = (okhttp3.internal.http2.Settings) r2     // Catch:{ IOException -> 0x010b, all -> 0x0107 }
                r0.applyAndAckSettings(r2)     // Catch:{ IOException -> 0x010b, all -> 0x0107 }
                goto L_0x0111
            L_0x0107:
                r0 = move-exception
                r5 = r27
                goto L_0x0162
            L_0x010b:
                r0 = move-exception
                okhttp3.internal.http2.Http2Connection r2 = r1.this$0     // Catch:{ all -> 0x0146 }
                r2.failConnection(r0)     // Catch:{ all -> 0x0146 }
            L_0x0111:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0146 }
                monitor-exit(r16)
                T r0 = r15.element
                okhttp3.internal.http2.Http2Stream[] r0 = (okhttp3.internal.http2.Http2Stream[]) r0
                if (r0 == 0) goto L_0x0143
                T r0 = r15.element
                okhttp3.internal.http2.Http2Stream[] r0 = (okhttp3.internal.http2.Http2Stream[]) r0
                if (r0 != 0) goto L_0x0125
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0125:
                int r2 = r0.length
                r6 = 0
            L_0x0127:
                if (r6 >= r2) goto L_0x0140
                r3 = r0[r6]
                monitor-enter(r3)
                r4 = 0
                r5 = r27
                long r7 = r5.element     // Catch:{ all -> 0x013d }
                r3.addBytesToWriteWindow(r7)     // Catch:{ all -> 0x013d }
                kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x013d }
                monitor-exit(r3)
                int r6 = r6 + 1
                r27 = r5
                goto L_0x0127
            L_0x013d:
                r0 = move-exception
                monitor-exit(r3)
                throw r0
            L_0x0140:
                r5 = r27
                goto L_0x0145
            L_0x0143:
                r5 = r27
            L_0x0145:
                return
            L_0x0146:
                r0 = move-exception
                goto L_0x014b
            L_0x0148:
                r0 = move-exception
                r1 = r28
            L_0x014b:
                r5 = r27
                goto L_0x0162
            L_0x014e:
                r0 = move-exception
                r1 = r28
                r5 = r27
                goto L_0x015a
            L_0x0154:
                r0 = move-exception
                r26 = r10
                r1 = r12
                r5 = r14
                r14 = r11
            L_0x015a:
                monitor-exit(r26)     // Catch:{ all -> 0x015c }
                throw r0     // Catch:{ all -> 0x015c }
            L_0x015c:
                r0 = move-exception
                goto L_0x0162
            L_0x015e:
                r0 = move-exception
                r1 = r12
                r5 = r14
                r14 = r11
            L_0x0162:
                monitor-exit(r16)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.applyAndAckSettings(boolean, okhttp3.internal.http2.Settings):void");
        }

        public void ackSettings() {
        }

        public void ping(boolean ack, int payload1, int payload2) {
            int i = payload1;
            if (ack) {
                synchronized (this.this$0) {
                    if (i == 1) {
                        Http2Connection http2Connection = this.this$0;
                        long access$getIntervalPongsReceived$p = http2Connection.intervalPongsReceived;
                        http2Connection.intervalPongsReceived = 1 + access$getIntervalPongsReceived$p;
                        Long.valueOf(access$getIntervalPongsReceived$p);
                    } else if (i == 2) {
                        Http2Connection http2Connection2 = this.this$0;
                        long access$getDegradedPongsReceived$p = http2Connection2.degradedPongsReceived;
                        http2Connection2.degradedPongsReceived = 1 + access$getDegradedPongsReceived$p;
                        Long.valueOf(access$getDegradedPongsReceived$p);
                    } else if (i != 3) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        Http2Connection http2Connection3 = this.this$0;
                        http2Connection3.awaitPongsReceived = http2Connection3.awaitPongsReceived + 1;
                        Object $this$notifyAll$iv = this.this$0;
                        if ($this$notifyAll$iv != null) {
                            $this$notifyAll$iv.notifyAll();
                            Object $this$notifyAll$iv2 = Unit.INSTANCE;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                        }
                    }
                }
                return;
            }
            String name$iv = this.this$0.getConnectionName$okhttp() + " ping";
            this.this$0.writerQueue.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$1(name$iv, true, name$iv, true, this, payload1, payload2), 0);
        }

        public void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
            int i;
            Http2Stream[] streamsCopy;
            Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
            Intrinsics.checkParameterIsNotNull(debugData, "debugData");
            int size = debugData.size();
            synchronized (this.this$0) {
                Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array != null) {
                    streamsCopy = (Http2Stream[]) array;
                    this.this$0.isShutdown = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            for (Http2Stream http2Stream : streamsCopy) {
                if (http2Stream.getId() > lastGoodStreamId && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        public void windowUpdate(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                synchronized (this.this$0) {
                    Http2Connection http2Connection = this.this$0;
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + windowSizeIncrement;
                    Object $this$notifyAll$iv = this.this$0;
                    if ($this$notifyAll$iv != null) {
                        $this$notifyAll$iv.notifyAll();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                    }
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(streamId);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(windowSizeIncrement);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        public void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders) {
            Intrinsics.checkParameterIsNotNull(requestHeaders, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(promisedStreamId, requestHeaders);
        }

        public void alternateService(int streamId, String origin, ByteString protocol, String host, int port, long maxAge) {
            Intrinsics.checkParameterIsNotNull(origin, "origin");
            Intrinsics.checkParameterIsNotNull(protocol, "protocol");
            Intrinsics.checkParameterIsNotNull(host, "host");
        }
    }

    public final boolean pushedStream$okhttp(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    public final void pushRequestLater$okhttp(int streamId, List<Header> requestHeaders) {
        int i = streamId;
        Intrinsics.checkParameterIsNotNull(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(streamId));
            String name$iv = this.connectionName + '[' + i + "] onRequest";
            this.pushQueue.schedule(new Http2Connection$pushRequestLater$$inlined$execute$1(name$iv, true, name$iv, true, this, streamId, requestHeaders), 0);
        }
    }

    public final void pushHeadersLater$okhttp(int streamId, List<Header> requestHeaders, boolean inFinished) {
        Intrinsics.checkParameterIsNotNull(requestHeaders, "requestHeaders");
        String name$iv = this.connectionName + '[' + streamId + "] onHeaders";
        this.pushQueue.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$1(name$iv, true, name$iv, true, this, streamId, requestHeaders, inFinished), 0);
    }

    public final void pushDataLater$okhttp(int streamId, BufferedSource source, int byteCount, boolean inFinished) throws IOException {
        BufferedSource bufferedSource = source;
        int i = byteCount;
        Intrinsics.checkParameterIsNotNull(bufferedSource, FirebaseAnalytics.Param.SOURCE);
        Buffer buffer = new Buffer();
        bufferedSource.require((long) i);
        bufferedSource.read(buffer, (long) i);
        String name$iv = this.connectionName + '[' + streamId + "] onData";
        this.pushQueue.schedule(new Http2Connection$pushDataLater$$inlined$execute$1(name$iv, true, name$iv, true, this, streamId, buffer, byteCount, inFinished), 0);
    }

    public final void pushResetLater$okhttp(int streamId, ErrorCode errorCode) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        String name$iv = this.connectionName + '[' + streamId + "] onReset";
        this.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$1(name$iv, true, name$iv, true, this, streamId, errorCode), 0);
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, mo20370d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: Http2Connection.kt */
    public static abstract class Listener {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public abstract void onStream(Http2Stream http2Stream) throws IOException;

        public void onSettings(Http2Connection connection, Settings settings) {
            Intrinsics.checkParameterIsNotNull(connection, "connection");
            Intrinsics.checkParameterIsNotNull(settings, "settings");
        }

        @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo20370d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
        /* compiled from: Http2Connection.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo20370d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "AWAIT_PING", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: Http2Connection.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    static {
        Settings settings = new Settings();
        Settings $this$apply = settings;
        $this$apply.set(7, 65535);
        $this$apply.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }
}
