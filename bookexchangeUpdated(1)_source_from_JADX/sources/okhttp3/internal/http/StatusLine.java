package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.Response;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo20370d2 = {"Lokhttp3/internal/http/StatusLine;", "", "protocol", "Lokhttp3/Protocol;", "code", "", "message", "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: StatusLine.kt */
public final class StatusLine {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public StatusLine(Protocol protocol2, int code2, String message2) {
        Intrinsics.checkParameterIsNotNull(protocol2, "protocol");
        Intrinsics.checkParameterIsNotNull(message2, "message");
        this.protocol = protocol2;
        this.code = code2;
        this.message = message2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$buildString = sb;
        if (this.protocol == Protocol.HTTP_1_0) {
            $this$buildString.append("HTTP/1.0");
        } else {
            $this$buildString.append("HTTP/1.1");
        }
        $this$buildString.append(' ');
        $this$buildString.append(this.code);
        $this$buildString.append(' ');
        $this$buildString.append(this.message);
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo20370d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "()V", "HTTP_CONTINUE", "", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "get", "Lokhttp3/internal/http/StatusLine;", "response", "Lokhttp3/Response;", "parse", "statusLine", "", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: StatusLine.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final StatusLine get(Response response) {
            Intrinsics.checkParameterIsNotNull(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String statusLine) throws IOException {
            Protocol protocol;
            int codeStart;
            Protocol protocol2;
            Intrinsics.checkParameterIsNotNull(statusLine, "statusLine");
            if (StringsKt.startsWith$default(statusLine, "HTTP/1.", false, 2, (Object) null)) {
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                int httpMinorVersion = statusLine.charAt(7) - '0';
                codeStart = 9;
                if (httpMinorVersion == 0) {
                    protocol2 = Protocol.HTTP_1_0;
                } else if (httpMinorVersion == 1) {
                    protocol2 = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                protocol = protocol2;
            } else if (StringsKt.startsWith$default(statusLine, "ICY ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_0;
                codeStart = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            if (statusLine.length() >= codeStart + 3) {
                try {
                    String substring = statusLine.substring(codeStart, codeStart + 3);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int code = Integer.parseInt(substring);
                    String message = "";
                    if (statusLine.length() > codeStart + 3) {
                        if (statusLine.charAt(codeStart + 3) == ' ') {
                            String substring2 = statusLine.substring(codeStart + 4);
                            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                            message = substring2;
                        } else {
                            throw new ProtocolException("Unexpected status line: " + statusLine);
                        }
                    }
                    return new StatusLine(protocol, code, message);
                } catch (NumberFormatException e) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
        }
    }
}
