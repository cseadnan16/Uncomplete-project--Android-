package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.platform.Platform;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u000e\u0018\u0000 02\u00020\u0001:\u00010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u001bJ\u0006\u0010%\u001a\u00020\u0005J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0012J.\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010.2\u0006\u0010/\u001a\u00020!R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00061"}, mo20370d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "cleanup", "now", "connectFailed", "", "failedRoute", "Lokhttp3/Route;", "failure", "Ljava/io/IOException;", "connectionBecameIdle", "", "connection", "connectionCount", "evictAll", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "transmitterAcquirePooledConnection", "address", "Lokhttp3/Address;", "transmitter", "Lokhttp3/internal/connection/Transmitter;", "routes", "", "requireMultiplexed", "Companion", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: RealConnectionPool.kt */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask = new RealConnectionPool$cleanupTask$1(this, "OkHttp ConnectionPool");
    private final ArrayDeque<RealConnection> connections = new ArrayDeque<>();
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    private final RouteDatabase routeDatabase = new RouteDatabase();

    public RealConnectionPool(TaskRunner taskRunner, int maxIdleConnections2, long keepAliveDuration, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.maxIdleConnections = maxIdleConnections2;
        this.keepAliveDurationNs = timeUnit.toNanos(keepAliveDuration);
        this.cleanupQueue = taskRunner.newQueue();
        if (!(keepAliveDuration > 0)) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + keepAliveDuration).toString());
        }
    }

    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    public final synchronized int idleConnectionCount() {
        int count$iv;
        Iterable<RealConnection> $this$count$iv = this.connections;
        if (!($this$count$iv instanceof Collection) || !((Collection) $this$count$iv).isEmpty()) {
            count$iv = 0;
            for (RealConnection it : $this$count$iv) {
                if (it.getTransmitters().isEmpty() && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            count$iv = 0;
        }
        return count$iv;
    }

    public final synchronized int connectionCount() {
        return this.connections.size();
    }

    public final boolean transmitterAcquirePooledConnection(Address address, Transmitter transmitter, List<Route> routes, boolean requireMultiplexed) {
        Intrinsics.checkParameterIsNotNull(address, "address");
        Intrinsics.checkParameterIsNotNull(transmitter, "transmitter");
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Iterator<RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection connection = it.next();
                if ((!requireMultiplexed || connection.isMultiplexed()) && connection.isEligible$okhttp(address, routes)) {
                    Intrinsics.checkExpressionValueIsNotNull(connection, "connection");
                    transmitter.acquireConnectionNoEvents(connection);
                    return true;
                }
            }
            return false;
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

    public final void put(RealConnection connection) {
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            this.connections.add(connection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
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

    public final boolean connectionBecameIdle(RealConnection connection) {
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        } else if (connection.getNoNewExchanges() || this.maxIdleConnections == 0) {
            this.connections.remove(connection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return true;
        } else {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return false;
        }
    }

    public final void evictAll() {
        List<RealConnection> evictedConnections = new ArrayList<>();
        synchronized (this) {
            Iterator i = this.connections.iterator();
            Intrinsics.checkExpressionValueIsNotNull(i, "connections.iterator()");
            while (i.hasNext()) {
                RealConnection connection = i.next();
                if (connection.getTransmitters().isEmpty()) {
                    connection.setNoNewExchanges(true);
                    Intrinsics.checkExpressionValueIsNotNull(connection, "connection");
                    evictedConnections.add(connection);
                    i.remove();
                }
            }
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            Unit unit = Unit.INSTANCE;
        }
        for (RealConnection connection2 : evictedConnections) {
            Util.closeQuietly(connection2.socket());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r2 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006e, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0071, code lost:
        okhttp3.internal.Util.closeQuietly(r2.socket());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long cleanup(long r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            okhttp3.internal.connection.RealConnection r2 = (okhttp3.internal.connection.RealConnection) r2
            r3 = -9223372036854775808
            monitor-enter(r11)
            r5 = 0
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r6 = r11.connections     // Catch:{ all -> 0x007b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x007b }
        L_0x000f:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x007b }
            if (r7 == 0) goto L_0x0038
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x007b }
            okhttp3.internal.connection.RealConnection r7 = (okhttp3.internal.connection.RealConnection) r7     // Catch:{ all -> 0x007b }
            java.lang.String r8 = "connection"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)     // Catch:{ all -> 0x007b }
            int r8 = r11.pruneAndGetAllocationCount(r7, r12)     // Catch:{ all -> 0x007b }
            if (r8 <= 0) goto L_0x0029
            int r0 = r0 + 1
            goto L_0x000f
        L_0x0029:
            int r1 = r1 + 1
            long r8 = r7.getIdleAtNanos$okhttp()     // Catch:{ all -> 0x007b }
            long r8 = r12 - r8
            int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x000f
            r3 = r8
            r2 = r7
            goto L_0x000f
        L_0x0038:
            long r6 = r11.keepAliveDurationNs     // Catch:{ all -> 0x007b }
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0056
            int r6 = r11.maxIdleConnections     // Catch:{ all -> 0x007b }
            if (r1 <= r6) goto L_0x0045
            goto L_0x0056
        L_0x0045:
            if (r1 <= 0) goto L_0x004c
            long r6 = r11.keepAliveDurationNs     // Catch:{ all -> 0x007b }
            long r6 = r6 - r3
            monitor-exit(r11)
            return r6
        L_0x004c:
            if (r0 <= 0) goto L_0x0052
            long r6 = r11.keepAliveDurationNs     // Catch:{ all -> 0x007b }
            monitor-exit(r11)
            return r6
        L_0x0052:
            r5 = -1
            monitor-exit(r11)
            return r5
        L_0x0056:
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r6 = r11.connections     // Catch:{ all -> 0x007b }
            r6.remove(r2)     // Catch:{ all -> 0x007b }
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r6 = r11.connections     // Catch:{ all -> 0x007b }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x007b }
            if (r6 == 0) goto L_0x0068
            okhttp3.internal.concurrent.TaskQueue r6 = r11.cleanupQueue     // Catch:{ all -> 0x007b }
            r6.cancelAll()     // Catch:{ all -> 0x007b }
        L_0x0068:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007b }
            monitor-exit(r11)
            if (r2 != 0) goto L_0x0071
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0071:
            java.net.Socket r5 = r2.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r5)
            r5 = 0
            return r5
        L_0x007b:
            r5 = move-exception
            monitor-exit(r11)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.cleanup(long):long");
    }

    private final int pruneAndGetAllocationCount(RealConnection connection, long now) {
        List references = connection.getTransmitters();
        int i = 0;
        while (i < references.size()) {
            Reference reference = references.get(i);
            if (reference.get() != null) {
                i++;
            } else if (reference != null) {
                Platform.Companion.get().logCloseableLeak("A connection to " + connection.route().address().url() + " was leaked. " + "Did you forget to close a response body?", ((Transmitter.TransmitterReference) reference).getCallStackTrace());
                references.remove(i);
                connection.setNoNewExchanges(true);
                if (references.isEmpty()) {
                    connection.setIdleAtNanos$okhttp(now - this.keepAliveDurationNs);
                    return 0;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.connection.Transmitter.TransmitterReference");
            }
        }
        return references.size();
    }

    public final void connectFailed(Route failedRoute, IOException failure) {
        Intrinsics.checkParameterIsNotNull(failedRoute, "failedRoute");
        Intrinsics.checkParameterIsNotNull(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        this.routeDatabase.failed(failedRoute);
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo20370d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: RealConnectionPool.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            Intrinsics.checkParameterIsNotNull(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }
}
