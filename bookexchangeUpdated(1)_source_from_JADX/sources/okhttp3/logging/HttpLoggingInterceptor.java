package okhttp3.logging;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p006io.CloseableKt;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\bF0\u0001¨\u0006 "}, mo20370d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo20370d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: HttpLoggingInterceptor.kt */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor() {
        this((Logger) null, 1, (DefaultConstructorMarker) null);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.logger = logger2;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpLoggingInterceptor(Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger2);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void level(Level level2) {
        Intrinsics.checkParameterIsNotNull(level2, "<set-?>");
        this.level = level2;
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0007"}, mo20370d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "okhttp-logging-interceptor"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: HttpLoggingInterceptor.kt */
    public interface Logger {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final Logger DEFAULT = new HttpLoggingInterceptor$Logger$Companion$DEFAULT$1();

        void log(String str);

        @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0005"}, mo20370d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "okhttp-logging-interceptor"}, mo20371k = 1, mo20372mv = {1, 1, 16})
        /* compiled from: HttpLoggingInterceptor.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    public final void redactHeader(String name) {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        TreeSet newHeadersToRedact = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        CollectionsKt.addAll(newHeadersToRedact, this.headersToRedact);
        newHeadersToRedact.add(name);
        this.headersToRedact = newHeadersToRedact;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        Intrinsics.checkParameterIsNotNull(level2, FirebaseAnalytics.Param.LEVEL);
        this.level = level2;
        return this;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "level", imports = {}))
    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m1220deprecated_level() {
        return this.level;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        String str2;
        String requestStartMessage;
        String str3;
        String str4;
        String bodySize;
        long contentLength;
        String str5;
        String str6;
        String str7;
        Charset charset;
        Throwable th;
        Connection connection;
        Charset charset2;
        Interceptor.Chain chain2 = chain;
        Intrinsics.checkParameterIsNotNull(chain2, "chain");
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean logBody = level2 == Level.BODY;
        boolean logHeaders = logBody || level2 == Level.HEADERS;
        RequestBody requestBody = request.body();
        Connection connection2 = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        if (connection2 != null) {
            str = " " + connection2.protocol();
        } else {
            str = "";
        }
        sb.append(str);
        String requestStartMessage2 = sb.toString();
        if (logHeaders || requestBody == null) {
            str2 = "";
            requestStartMessage = requestStartMessage2;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(requestStartMessage2);
            sb2.append(" (");
            str2 = "";
            sb2.append(requestBody.contentLength());
            sb2.append("-byte body)");
            requestStartMessage = sb2.toString();
        }
        this.logger.log(requestStartMessage);
        if (logHeaders) {
            Headers headers = request.headers();
            if (requestBody != null) {
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    MediaType it = contentType;
                    if (headers.get("Content-Type") == null) {
                        Logger logger2 = this.logger;
                        StringBuilder sb3 = new StringBuilder();
                        Level level3 = level2;
                        sb3.append("Content-Type: ");
                        sb3.append(it);
                        logger2.log(sb3.toString());
                    } else {
                        MediaType mediaType = it;
                    }
                }
                if (requestBody.contentLength() == -1) {
                    connection = connection2;
                    String str8 = requestStartMessage;
                } else if (headers.get("Content-Length") == null) {
                    Logger logger3 = this.logger;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Content-Length: ");
                    connection = connection2;
                    String str9 = requestStartMessage;
                    sb4.append(requestBody.contentLength());
                    logger3.log(sb4.toString());
                } else {
                    connection = connection2;
                    String str10 = requestStartMessage;
                }
            } else {
                connection = connection2;
                String str11 = requestStartMessage;
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                logHeader(headers, i);
            }
            if (!logBody) {
                str3 = str2;
                Headers headers2 = headers;
                str4 = "UTF_8";
            } else if (requestBody == null) {
                Connection connection3 = connection;
                str3 = str2;
                Headers headers3 = headers;
                str4 = "UTF_8";
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                Connection connection4 = connection;
                str4 = "UTF_8";
                str3 = str2;
            } else if (requestBody.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                Connection connection5 = connection;
                str4 = "UTF_8";
                str3 = str2;
            } else if (requestBody.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
                Connection connection6 = connection;
                str4 = "UTF_8";
                str3 = str2;
            } else {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                MediaType contentType2 = requestBody.contentType();
                if (contentType2 == null || (charset2 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                    charset2 = StandardCharsets.UTF_8;
                    Intrinsics.checkExpressionValueIsNotNull(charset2, "UTF_8");
                }
                Connection connection7 = connection;
                MediaType mediaType2 = contentType2;
                String str12 = str2;
                this.logger.log(str12);
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    Headers headers4 = headers;
                    this.logger.log(buffer.readString(charset2));
                    Logger logger4 = this.logger;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("--> END ");
                    sb5.append(request.method());
                    sb5.append(" (");
                    str3 = str12;
                    Charset charset3 = charset2;
                    sb5.append(requestBody.contentLength());
                    sb5.append("-byte body)");
                    logger4.log(sb5.toString());
                    str4 = "UTF_8";
                } else {
                    str3 = str12;
                    Charset charset4 = charset2;
                    Headers headers5 = headers;
                    Logger logger5 = this.logger;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("--> END ");
                    sb6.append(request.method());
                    sb6.append(" (binary ");
                    str4 = "UTF_8";
                    sb6.append(requestBody.contentLength());
                    sb6.append("-byte body omitted)");
                    logger5.log(sb6.toString());
                }
            }
            this.logger.log("--> END " + request.method());
        } else {
            Connection connection8 = connection2;
            String str13 = requestStartMessage;
            str4 = "UTF_8";
            str3 = str2;
        }
        long startNs = System.nanoTime();
        try {
            Response response = chain2.proceed(request);
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                Intrinsics.throwNpe();
            }
            Request request2 = request;
            long j = startNs;
            long contentLength2 = responseBody.contentLength();
            if (contentLength2 != -1) {
                bodySize = contentLength2 + "-byte";
            } else {
                bodySize = "unknown-length";
            }
            Logger logger6 = this.logger;
            RequestBody requestBody2 = requestBody;
            StringBuilder sb7 = new StringBuilder();
            String str14 = str4;
            sb7.append("<-- ");
            sb7.append(response.code());
            if (response.message().length() == 0) {
                contentLength = contentLength2;
                str5 = "-byte body)";
                str6 = str3;
            } else {
                String message = response.message();
                str5 = "-byte body)";
                StringBuilder sb8 = new StringBuilder();
                contentLength = contentLength2;
                sb8.append(String.valueOf(' '));
                sb8.append(message);
                str6 = sb8.toString();
            }
            sb7.append(str6);
            sb7.append(' ');
            sb7.append(response.request().url());
            sb7.append(" (");
            sb7.append(tookMs);
            sb7.append("ms");
            if (!logHeaders) {
                str7 = ", " + bodySize + " body";
            } else {
                str7 = str3;
            }
            sb7.append(str7);
            sb7.append(')');
            logger6.log(sb7.toString());
            if (logHeaders) {
                Headers headers6 = response.headers();
                int size2 = headers6.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers6, i2);
                }
                if (!logBody) {
                    Headers headers7 = headers6;
                } else if (!HttpHeaders.promisesBody(response)) {
                    String str15 = bodySize;
                    Headers headers8 = headers6;
                } else if (bodyHasUnknownEncoding(response.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                    String str16 = bodySize;
                } else {
                    BufferedSource source = responseBody.source();
                    source.request(LongCompanionObject.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    Long gzippedLength = null;
                    if (StringsKt.equals("gzip", headers6.get("Content-Encoding"), true)) {
                        gzippedLength = Long.valueOf(buffer2.size());
                        Closeable gzipSource = new GzipSource(buffer2.clone());
                        Throwable th2 = null;
                        try {
                            GzipSource gzippedResponseBody = (GzipSource) gzipSource;
                            buffer2 = new Buffer();
                            String str17 = bodySize;
                            try {
                                buffer2.writeAll(gzippedResponseBody);
                                CloseableKt.closeFinally(gzipSource, th2);
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    throw th;
                                } catch (Throwable th4) {
                                    Throwable th5 = th4;
                                    CloseableKt.closeFinally(gzipSource, th);
                                    throw th5;
                                }
                            }
                        } catch (Throwable th6) {
                            String str18 = bodySize;
                            th = th6;
                            throw th;
                        }
                    }
                    MediaType contentType3 = responseBody.contentType();
                    if (contentType3 == null || (charset = contentType3.charset(StandardCharsets.UTF_8)) == null) {
                        charset = StandardCharsets.UTF_8;
                        Intrinsics.checkExpressionValueIsNotNull(charset, str14);
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                        this.logger.log(str3);
                        Logger logger7 = this.logger;
                        StringBuilder sb9 = new StringBuilder();
                        MediaType mediaType3 = contentType3;
                        sb9.append("<-- END HTTP (binary ");
                        Headers headers9 = headers6;
                        BufferedSource bufferedSource = source;
                        sb9.append(buffer2.size());
                        sb9.append("-byte body omitted)");
                        logger7.log(sb9.toString());
                        return response;
                    }
                    Headers headers10 = headers6;
                    BufferedSource bufferedSource2 = source;
                    String str19 = str3;
                    if (contentLength != 0) {
                        this.logger.log(str19);
                        this.logger.log(buffer2.clone().readString(charset));
                    }
                    if (gzippedLength != null) {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + gzippedLength + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + str5);
                    }
                }
                this.logger.log("<-- END HTTP");
            }
            return response;
        } catch (Exception e) {
            Request request3 = request;
            long j2 = startNs;
            RequestBody requestBody3 = requestBody;
            Exception e2 = e;
            this.logger.log("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    private final void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        Logger logger2 = this.logger;
        logger2.log(headers.name(i) + ": " + value);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        if (contentEncoding == null || StringsKt.equals(contentEncoding, "identity", true) || StringsKt.equals(contentEncoding, "gzip", true)) {
            return false;
        }
        return true;
    }
}
