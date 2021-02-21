package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo20370d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "okio"}, mo20371k = 1, mo20372mv = {1, 1, 15})
/* compiled from: HashingSink.kt */
public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    @JvmStatic
    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    @JvmStatic
    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    @JvmStatic
    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    @JvmStatic
    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, String algorithm) {
        super(sink);
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        Intrinsics.checkParameterIsNotNull(algorithm, "algorithm");
        this.messageDigest = MessageDigest.getInstance(algorithm);
        this.mac = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, ByteString key, String algorithm) {
        super(sink);
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(algorithm, "algorithm");
        try {
            Mac $this$apply = Mac.getInstance(algorithm);
            $this$apply.init(new SecretKeySpec(key.toByteArray(), algorithm));
            this.mac = $this$apply;
            this.messageDigest = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void write(Buffer source, long byteCount) throws IOException {
        Intrinsics.checkParameterIsNotNull(source, FirebaseAnalytics.Param.SOURCE);
        Util.checkOffsetAndCount(source.size(), 0, byteCount);
        long hashedCount = 0;
        Segment s = source.head;
        if (s == null) {
            Intrinsics.throwNpe();
        }
        while (hashedCount < byteCount) {
            int toHash = (int) Math.min(byteCount - hashedCount, (long) (s.limit - s.pos));
            MessageDigest messageDigest2 = this.messageDigest;
            if (messageDigest2 != null) {
                messageDigest2.update(s.data, s.pos, toHash);
            } else {
                Mac mac2 = this.mac;
                if (mac2 == null) {
                    Intrinsics.throwNpe();
                }
                mac2.update(s.data, s.pos, toHash);
            }
            hashedCount += (long) toHash;
            Segment segment = s.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            s = segment;
        }
        super.write(source, byteCount);
    }

    public final ByteString hash() {
        byte[] result;
        MessageDigest messageDigest2 = this.messageDigest;
        if (messageDigest2 != null) {
            result = messageDigest2.digest();
        } else {
            Mac mac2 = this.mac;
            if (mac2 == null) {
                Intrinsics.throwNpe();
            }
            result = mac2.doFinal();
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return new ByteString(result);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m1236deprecated_hash() {
        return hash();
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, mo20370d2 = {"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, mo20371k = 1, mo20372mv = {1, 1, 15})
    /* compiled from: HashingSink.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final HashingSink md5(Sink sink) {
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        public final HashingSink sha1(Sink sink) {
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        public final HashingSink sha256(Sink sink) {
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @JvmStatic
        public final HashingSink sha512(Sink sink) {
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        @JvmStatic
        public final HashingSink hmacSha1(Sink sink, ByteString key) {
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSink hmacSha256(Sink sink, ByteString key) {
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSink hmacSha512(Sink sink, ByteString key) {
            Intrinsics.checkParameterIsNotNull(sink, "sink");
            Intrinsics.checkParameterIsNotNull(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }
    }
}
