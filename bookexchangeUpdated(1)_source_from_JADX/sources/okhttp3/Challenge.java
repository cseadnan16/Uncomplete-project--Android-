package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\b\u000eJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR!\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r¨\u0006\u0019"}, mo20370d2 = {"Lokhttp3/Challenge;", "", "scheme", "", "realm", "(Ljava/lang/String;Ljava/lang/String;)V", "authParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "()Ljava/util/Map;", "charset", "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", "()Ljava/lang/String;", "-deprecated_authParams", "-deprecated_charset", "equals", "", "other", "hashCode", "", "-deprecated_realm", "-deprecated_scheme", "toString", "withCharset", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: Challenge.kt */
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String scheme2, Map<String, String> authParams2) {
        String newKey;
        Intrinsics.checkParameterIsNotNull(scheme2, "scheme");
        Intrinsics.checkParameterIsNotNull(authParams2, "authParams");
        this.scheme = scheme2;
        Map newAuthParams = new LinkedHashMap();
        for (Map.Entry next : authParams2.entrySet()) {
            String key = (String) next.getKey();
            String value = (String) next.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "US");
                if (key != null) {
                    newKey = key.toLowerCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(newKey, "(this as java.lang.String).toLowerCase(locale)");
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                newKey = null;
            }
            newAuthParams.put(newKey, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(newAuthParams);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    public final String scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final Charset charset() {
        String charset = this.authParams.get("charset");
        if (charset != null) {
            try {
                Charset forName = Charset.forName(charset);
                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception e) {
            }
        }
        Charset charset2 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkExpressionValueIsNotNull(charset2, "ISO_8859_1");
        return charset2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Challenge(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "scheme"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "realm"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.util.Map r0 = java.util.Collections.singletonMap(r0, r4)
            java.lang.String r1 = "singletonMap(\"realm\", realm)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r2.<init>((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.String>) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Challenge.<init>(java.lang.String, java.lang.String):void");
    }

    public final Challenge withCharset(Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        Map authParams2 = MapsKt.toMutableMap(this.authParams);
        String name = charset.name();
        Intrinsics.checkExpressionValueIsNotNull(name, "charset.name()");
        authParams2.put("charset", name);
        return new Challenge(this.scheme, (Map<String, String>) authParams2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m1111deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authParams", imports = {}))
    /* renamed from: -deprecated_authParams  reason: not valid java name */
    public final Map<String, String> m1108deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "realm", imports = {}))
    /* renamed from: -deprecated_realm  reason: not valid java name */
    public final String m1110deprecated_realm() {
        return realm();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "charset", imports = {}))
    /* renamed from: -deprecated_charset  reason: not valid java name */
    public final Charset m1109deprecated_charset() {
        return charset();
    }

    public boolean equals(Object other) {
        return (other instanceof Challenge) && Intrinsics.areEqual((Object) ((Challenge) other).scheme, (Object) this.scheme) && Intrinsics.areEqual((Object) ((Challenge) other).authParams, (Object) this.authParams);
    }

    public int hashCode() {
        return (((29 * 31) + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}
