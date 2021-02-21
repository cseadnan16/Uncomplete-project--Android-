package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\b\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\nH\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\nH\b\u001a\u0015\u0010\u0012\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\b\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\n*\u00020\u0010H\b\u001a\r\u0010\u0015\u001a\u00020\n*\u00020\u0010H\b\u001a\r\u0010\u0016\u001a\u00020\n*\u00020\u0010H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\b\u001a\u0017\u0010\u001a\u001a\u00020\u0018*\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005H\b\u001a\r\u0010\u001f\u001a\u00020\u0005*\u00020\nH\b\u001a\r\u0010 \u001a\u00020\u0005*\u00020\nH\b\u001a\r\u0010!\u001a\u00020\u0010*\u00020\nH\b\u001a\u001d\u0010\"\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\nH\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005H\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\nH\b\u001a\u001d\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\b\u001a\r\u0010/\u001a\u00020\n*\u00020\nH\b\u001a\r\u00100\u001a\u00020\n*\u00020\nH\b\u001a\r\u00101\u001a\u00020\u0007*\u00020\nH\b\u001a\u001d\u00102\u001a\u00020\n*\u00020\u00072\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a\r\u00103\u001a\u00020\u0010*\u00020\nH\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\nH\b\u001a$\u00105\u001a\u000206*\u00020\n2\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u00069"}, mo20370d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "offset", "otherOffset", "byteCount", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "", "buffer", "Lokio/Buffer;", "okio"}, mo20371k = 2, mo20372mv = {1, 1, 15})
/* compiled from: ByteString.kt */
public final class ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final String commonUtf8(ByteString $this$commonUtf8) {
        Intrinsics.checkParameterIsNotNull($this$commonUtf8, "$this$commonUtf8");
        String result = $this$commonUtf8.getUtf8$okio();
        if (result != null) {
            return result;
        }
        String result2 = Platform.toUtf8String($this$commonUtf8.internalArray$okio());
        $this$commonUtf8.setUtf8$okio(result2);
        return result2;
    }

    public static final String commonBase64(ByteString $this$commonBase64) {
        Intrinsics.checkParameterIsNotNull($this$commonBase64, "$this$commonBase64");
        return Base64.encodeBase64$default($this$commonBase64.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public static final String commonBase64Url(ByteString $this$commonBase64Url) {
        Intrinsics.checkParameterIsNotNull($this$commonBase64Url, "$this$commonBase64Url");
        return Base64.encodeBase64($this$commonBase64Url.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final String commonHex(ByteString $this$commonHex) {
        Intrinsics.checkParameterIsNotNull($this$commonHex, "$this$commonHex");
        char[] result = new char[($this$commonHex.getData$okio().length * 2)];
        int c = 0;
        for (int $this$shr$iv : $this$commonHex.getData$okio()) {
            int c2 = c + 1;
            result[c] = getHEX_DIGIT_CHARS()[($this$shr$iv >> 4) & 15];
            c = c2 + 1;
            result[c2] = getHEX_DIGIT_CHARS()[15 & $this$shr$iv];
        }
        return new String(result);
    }

    public static final ByteString commonToAsciiLowercase(ByteString $this$commonToAsciiLowercase) {
        byte b;
        Intrinsics.checkParameterIsNotNull($this$commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        int i = 0;
        while (i < $this$commonToAsciiLowercase.getData$okio().length) {
            byte c = $this$commonToAsciiLowercase.getData$okio()[i];
            byte b2 = (byte) 65;
            if (c < b2 || c > (b = (byte) 90)) {
                i++;
            } else {
                byte[] data$okio = $this$commonToAsciiLowercase.getData$okio();
                byte[] lowercase = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkExpressionValueIsNotNull(lowercase, "java.util.Arrays.copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c + 32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < b2 || c2 > b) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 + 32);
                        i2++;
                    }
                }
                return new ByteString(lowercase);
            }
        }
        return $this$commonToAsciiLowercase;
    }

    public static final ByteString commonToAsciiUppercase(ByteString $this$commonToAsciiUppercase) {
        byte b;
        Intrinsics.checkParameterIsNotNull($this$commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        int i = 0;
        while (i < $this$commonToAsciiUppercase.getData$okio().length) {
            byte c = $this$commonToAsciiUppercase.getData$okio()[i];
            byte b2 = (byte) 97;
            if (c < b2 || c > (b = (byte) 122)) {
                i++;
            } else {
                byte[] data$okio = $this$commonToAsciiUppercase.getData$okio();
                byte[] lowercase = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkExpressionValueIsNotNull(lowercase, "java.util.Arrays.copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c - 32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < b2 || c2 > b) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 - 32);
                        i2++;
                    }
                }
                return new ByteString(lowercase);
            }
        }
        return $this$commonToAsciiUppercase;
    }

    public static final ByteString commonSubstring(ByteString $this$commonSubstring, int beginIndex, int endIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonSubstring, "$this$commonSubstring");
        boolean z = true;
        if (beginIndex >= 0) {
            if (endIndex <= $this$commonSubstring.getData$okio().length) {
                if (endIndex - beginIndex < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (beginIndex == 0 && endIndex == $this$commonSubstring.getData$okio().length) {
                    return $this$commonSubstring;
                } else {
                    return new ByteString(ArraysKt.copyOfRange($this$commonSubstring.getData$okio(), beginIndex, endIndex));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring.getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public static final byte commonGetByte(ByteString $this$commonGetByte, int pos) {
        Intrinsics.checkParameterIsNotNull($this$commonGetByte, "$this$commonGetByte");
        return $this$commonGetByte.getData$okio()[pos];
    }

    public static final int commonGetSize(ByteString $this$commonGetSize) {
        Intrinsics.checkParameterIsNotNull($this$commonGetSize, "$this$commonGetSize");
        return $this$commonGetSize.getData$okio().length;
    }

    public static final byte[] commonToByteArray(ByteString $this$commonToByteArray) {
        Intrinsics.checkParameterIsNotNull($this$commonToByteArray, "$this$commonToByteArray");
        byte[] data$okio = $this$commonToByteArray.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public static final byte[] commonInternalArray(ByteString $this$commonInternalArray) {
        Intrinsics.checkParameterIsNotNull($this$commonInternalArray, "$this$commonInternalArray");
        return $this$commonInternalArray.getData$okio();
    }

    public static final boolean commonRangeEquals(ByteString $this$commonRangeEquals, int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return other.rangeEquals(otherOffset, $this$commonRangeEquals.getData$okio(), offset, byteCount);
    }

    public static final boolean commonRangeEquals(ByteString $this$commonRangeEquals, int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return offset >= 0 && offset <= $this$commonRangeEquals.getData$okio().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && Util.arrayRangeEquals($this$commonRangeEquals.getData$okio(), offset, other, otherOffset, byteCount);
    }

    public static final boolean commonStartsWith(ByteString $this$commonStartsWith, ByteString prefix) {
        Intrinsics.checkParameterIsNotNull($this$commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    public static final boolean commonStartsWith(ByteString $this$commonStartsWith, byte[] prefix) {
        Intrinsics.checkParameterIsNotNull($this$commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }

    public static final boolean commonEndsWith(ByteString $this$commonEndsWith, ByteString suffix) {
        Intrinsics.checkParameterIsNotNull($this$commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEndsWith(ByteString $this$commonEndsWith, byte[] suffix) {
        Intrinsics.checkParameterIsNotNull($this$commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonIndexOf(ByteString $this$commonIndexOf, byte[] other, int fromIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonIndexOf, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int limit = $this$commonIndexOf.getData$okio().length - other.length;
        int i = Math.max(fromIndex, 0);
        if (i > limit) {
            return -1;
        }
        while (!Util.arrayRangeEquals($this$commonIndexOf.getData$okio(), i, other, 0, other.length)) {
            if (i == limit) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public static final int commonLastIndexOf(ByteString $this$commonLastIndexOf, ByteString other, int fromIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return $this$commonLastIndexOf.lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    public static final int commonLastIndexOf(ByteString $this$commonLastIndexOf, byte[] other, int fromIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        for (int i = Math.min(fromIndex, $this$commonLastIndexOf.getData$okio().length - other.length); i >= 0; i--) {
            if (Util.arrayRangeEquals($this$commonLastIndexOf.getData$okio(), i, other, 0, other.length)) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean commonEquals(ByteString $this$commonEquals, Object other) {
        Intrinsics.checkParameterIsNotNull($this$commonEquals, "$this$commonEquals");
        if (other == $this$commonEquals) {
            return true;
        }
        if (!(other instanceof ByteString) || ((ByteString) other).size() != $this$commonEquals.getData$okio().length || !((ByteString) other).rangeEquals(0, $this$commonEquals.getData$okio(), 0, $this$commonEquals.getData$okio().length)) {
            return false;
        }
        return true;
    }

    public static final int commonHashCode(ByteString $this$commonHashCode) {
        Intrinsics.checkParameterIsNotNull($this$commonHashCode, "$this$commonHashCode");
        int result = $this$commonHashCode.getHashCode$okio();
        if (result != 0) {
            return result;
        }
        int it = Arrays.hashCode($this$commonHashCode.getData$okio());
        $this$commonHashCode.setHashCode$okio(it);
        return it;
    }

    public static final int commonCompareTo(ByteString $this$commonCompareTo, ByteString other) {
        Intrinsics.checkParameterIsNotNull($this$commonCompareTo, "$this$commonCompareTo");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int sizeA = $this$commonCompareTo.size();
        int sizeB = other.size();
        int i = 0;
        int size = Math.min(sizeA, sizeB);
        while (i < size) {
            int byteA = $this$commonCompareTo.getByte(i) & 255;
            int byteB = other.getByte(i) & 255;
            if (byteA == byteB) {
                i++;
            } else if (byteA < byteB) {
                return -1;
            } else {
                return 1;
            }
        }
        if (sizeA == sizeB) {
            return 0;
        }
        if (sizeA < sizeB) {
            return -1;
        }
        return 1;
    }

    public static final ByteString commonOf(byte[] data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final ByteString commonToByteString(byte[] $this$commonToByteString, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonToByteString, "$this$commonToByteString");
        Util.checkOffsetAndCount((long) $this$commonToByteString.length, (long) offset, (long) byteCount);
        return new ByteString(ArraysKt.copyOfRange($this$commonToByteString, offset, offset + byteCount));
    }

    public static final ByteString commonEncodeUtf8(String $this$commonEncodeUtf8) {
        Intrinsics.checkParameterIsNotNull($this$commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray($this$commonEncodeUtf8));
        byteString.setUtf8$okio($this$commonEncodeUtf8);
        return byteString;
    }

    public static final ByteString commonDecodeBase64(String $this$commonDecodeBase64) {
        Intrinsics.checkParameterIsNotNull($this$commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] decoded = Base64.decodeBase64ToArray($this$commonDecodeBase64);
        if (decoded != null) {
            return new ByteString(decoded);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String $this$commonDecodeHex) {
        Intrinsics.checkParameterIsNotNull($this$commonDecodeHex, "$this$commonDecodeHex");
        if ($this$commonDecodeHex.length() % 2 == 0) {
            byte[] result = new byte[($this$commonDecodeHex.length() / 2)];
            int length = result.length;
            for (int i = 0; i < length; i++) {
                result[i] = (byte) ((decodeHexDigit($this$commonDecodeHex.charAt(i * 2)) << 4) + decodeHexDigit($this$commonDecodeHex.charAt((i * 2) + 1)));
            }
            return new ByteString(result);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + $this$commonDecodeHex).toString());
    }

    public static final void commonWrite(ByteString $this$commonWrite, Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        buffer.write($this$commonWrite.getData$okio(), offset, byteCount);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return (c - 'a') + 10;
        }
        if ('A' <= c && 'F' >= c) {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final String commonToString(ByteString $this$commonToString) {
        Intrinsics.checkParameterIsNotNull($this$commonToString, "$this$commonToString");
        boolean z = true;
        if ($this$commonToString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int i = codePointIndexToCharIndex($this$commonToString.getData$okio(), 64);
        if (i != -1) {
            String text = $this$commonToString.utf8();
            if (text != null) {
                String substring = text.substring(0, i);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String safeText = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (i < text.length()) {
                    return "[size=" + $this$commonToString.getData$okio().length + " text=" + safeText + "…]";
                }
                return "[text=" + safeText + ']';
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else if ($this$commonToString.getData$okio().length <= 64) {
            return "[hex=" + $this$commonToString.hex() + ']';
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append($this$commonToString.getData$okio().length);
            sb.append(" hex=");
            ByteString $this$commonSubstring$iv = $this$commonToString;
            if (64 <= $this$commonSubstring$iv.getData$okio().length) {
                if (64 - 0 < 0) {
                    z = false;
                }
                if (z) {
                    if (64 != $this$commonSubstring$iv.getData$okio().length) {
                        $this$commonSubstring$iv = new ByteString(ArraysKt.copyOfRange($this$commonSubstring$iv.getData$okio(), 0, 64));
                    }
                    sb.append($this$commonSubstring$iv.hex());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring$iv.getData$okio().length + ')').toString());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0178, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0184, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0186, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01b8, code lost:
        if (31 < r14) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01c4, code lost:
        if (159 < r14) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01c6, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0241, code lost:
        if (r16 == false) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x027e, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x028a, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x028c, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x02d9, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x02e5, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x02e7, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0333, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x033f, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0341, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0381, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0386;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x038d, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x038f, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x039c, code lost:
        if (65533(0xfffd, float:9.1831E-41) < 65536(0x10000, float:9.18355E-41)) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x03ba, code lost:
        if (31 < r15) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x03c6, code lost:
        if (159 < r15) goto L_0x03ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x03c8, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x03d5, code lost:
        if (r15 < 65536) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0497, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x049c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x04a3, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x04a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x04a5, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x04f0, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x04f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x04fc, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0500;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x04fe, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x054c, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0551;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:445:0x0558, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x055c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:0x055a, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:466:0x05ab, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x05b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x05b7, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x05bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x05b9, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x05fa, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x05ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x0606, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x060a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:500:0x0608, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0615, code lost:
        if (65533(0xfffd, float:9.1831E-41) < 65536(0x10000, float:9.18355E-41)) goto L_0x0617;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:520:0x0640, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0645;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:525:0x064c, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0650;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:526:0x064e, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:531:0x065b, code lost:
        if (65533(0xfffd, float:9.1831E-41) < 65536(0x10000, float:9.18355E-41)) goto L_0x0617;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:542:0x0679, code lost:
        if (31 < r15) goto L_0x067e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:547:0x0685, code lost:
        if (159 < r15) goto L_0x0689;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:548:0x0687, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:0x0694, code lost:
        if (r15 < 65536) goto L_0x0617;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0122, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x012e, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0130, code lost:
        r16 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r29, int r30) {
        /*
            r0 = r30
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r29
            int r5 = r4.length
            r6 = r29
            r7 = 0
            r8 = r3
        L_0x000c:
            if (r8 >= r5) goto L_0x06df
            byte r9 = r6[r8]
            r10 = 127(0x7f, float:1.78E-43)
            r11 = 159(0x9f, float:2.23E-43)
            r12 = 31
            r14 = 13
            r13 = 10
            r15 = 65536(0x10000, float:9.18355E-41)
            r16 = 0
            r17 = 2
            r18 = 1
            if (r9 < 0) goto L_0x009a
            r19 = r9
            r20 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x002e
            return r1
        L_0x002e:
            r2 = r19
            if (r2 == r13) goto L_0x0048
            if (r2 == r14) goto L_0x0048
            r19 = 0
            if (r2 < 0) goto L_0x003c
            if (r12 >= r2) goto L_0x0041
        L_0x003c:
            if (r10 <= r2) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            if (r11 < r2) goto L_0x0044
        L_0x0041:
            r19 = 1
            goto L_0x0046
        L_0x0044:
            r19 = 0
        L_0x0046:
            if (r19 != 0) goto L_0x004d
        L_0x0048:
            r11 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r11) goto L_0x004f
        L_0x004d:
            r10 = -1
            return r10
        L_0x004f:
            if (r2 >= r15) goto L_0x0053
            r11 = 1
            goto L_0x0054
        L_0x0053:
            r11 = 2
        L_0x0054:
            int r1 = r1 + r11
            int r8 = r8 + 1
            r2 = r21
        L_0x005a:
            if (r8 >= r5) goto L_0x0096
            byte r11 = r6[r8]
            if (r11 < 0) goto L_0x0096
            int r11 = r8 + 1
            byte r8 = r6[r8]
            r20 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x006b
            return r1
        L_0x006b:
            if (r8 == r13) goto L_0x0082
            if (r8 == r14) goto L_0x0082
            r2 = 0
            if (r8 < 0) goto L_0x0076
            if (r12 >= r8) goto L_0x007d
        L_0x0076:
            if (r10 <= r8) goto L_0x0079
            goto L_0x007f
        L_0x0079:
            r10 = 159(0x9f, float:2.23E-43)
            if (r10 < r8) goto L_0x007f
        L_0x007d:
            r2 = 1
            goto L_0x0080
        L_0x007f:
            r2 = 0
        L_0x0080:
            if (r2 != 0) goto L_0x0087
        L_0x0082:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r8 != r2) goto L_0x0089
        L_0x0087:
            r2 = -1
            return r2
        L_0x0089:
            if (r8 >= r15) goto L_0x008d
            r2 = 1
            goto L_0x008e
        L_0x008d:
            r2 = 2
        L_0x008e:
            int r1 = r1 + r2
            r8 = r11
            r2 = r21
            r10 = 127(0x7f, float:1.78E-43)
            goto L_0x005a
        L_0x0096:
            r26 = r3
            goto L_0x06d8
        L_0x009a:
            r10 = 5
            r11 = r9
            r20 = 0
            int r10 = r11 >> r10
            r11 = -2
            if (r10 != r11) goto L_0x01e4
            r10 = r6
            r11 = 0
            int r15 = r8 + 1
            if (r5 > r15) goto L_0x00e7
            r15 = 65533(0xfffd, float:9.1831E-41)
            r21 = 0
            r22 = r15
            r23 = 0
            int r24 = r2 + 1
            if (r2 != r0) goto L_0x00b7
            return r1
        L_0x00b7:
            r2 = r22
            if (r2 == r13) goto L_0x00d1
            if (r2 == r14) goto L_0x00d1
            r13 = 0
            if (r2 < 0) goto L_0x00c4
            if (r12 >= r2) goto L_0x00cd
        L_0x00c4:
            r12 = 127(0x7f, float:1.78E-43)
            if (r12 <= r2) goto L_0x00c9
            goto L_0x00cf
        L_0x00c9:
            r12 = 159(0x9f, float:2.23E-43)
            if (r12 < r2) goto L_0x00cf
        L_0x00cd:
            r16 = 1
        L_0x00cf:
            if (r16 != 0) goto L_0x00d6
        L_0x00d1:
            r12 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r12) goto L_0x00d8
        L_0x00d6:
            r12 = -1
            return r12
        L_0x00d8:
            r12 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r12) goto L_0x00de
            r17 = 1
        L_0x00de:
            int r1 = r1 + r17
            r26 = r3
            r17 = 1
            goto L_0x01de
        L_0x00e7:
            byte r15 = r10[r8]
            int r22 = r8 + 1
            byte r12 = r10[r22]
            r22 = 0
            r24 = 192(0xc0, float:2.69E-43)
            r25 = r12
            r26 = 0
            r14 = r25 & r24
            r13 = 128(0x80, float:1.794E-43)
            if (r14 != r13) goto L_0x00fd
            r13 = 1
            goto L_0x00fe
        L_0x00fd:
            r13 = 0
        L_0x00fe:
            if (r13 != 0) goto L_0x014a
            r13 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r21 = r13
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x010d
            return r1
        L_0x010d:
            r26 = r3
            r2 = r21
            r3 = 10
            if (r2 == r3) goto L_0x0134
            r3 = 13
            if (r2 == r3) goto L_0x0134
            r3 = 0
            if (r2 < 0) goto L_0x0125
            r21 = r3
            r3 = 31
            if (r3 >= r2) goto L_0x0130
            goto L_0x0127
        L_0x0125:
            r21 = r3
        L_0x0127:
            r3 = 127(0x7f, float:1.78E-43)
            if (r3 <= r2) goto L_0x012c
            goto L_0x0132
        L_0x012c:
            r3 = 159(0x9f, float:2.23E-43)
            if (r3 < r2) goto L_0x0132
        L_0x0130:
            r16 = 1
        L_0x0132:
            if (r16 != 0) goto L_0x0139
        L_0x0134:
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r3) goto L_0x013b
        L_0x0139:
            r3 = -1
            return r3
        L_0x013b:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r3) goto L_0x0141
            r17 = 1
        L_0x0141:
            int r1 = r1 + r17
            r24 = r25
            r17 = 1
            goto L_0x01de
        L_0x014a:
            r26 = r3
            r3 = r12 ^ 3968(0xf80, float:5.56E-42)
            int r13 = r15 << 6
            r3 = r3 ^ r13
            r13 = 128(0x80, float:1.794E-43)
            if (r3 >= r13) goto L_0x019d
            r13 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r21 = r13
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0165
            return r1
        L_0x0165:
            r2 = r21
            r4 = 10
            if (r2 == r4) goto L_0x018a
            r4 = 13
            if (r2 == r4) goto L_0x018a
            r4 = 0
            if (r2 < 0) goto L_0x017b
            r21 = r4
            r4 = 31
            if (r4 >= r2) goto L_0x0186
            goto L_0x017d
        L_0x017b:
            r21 = r4
        L_0x017d:
            r4 = 127(0x7f, float:1.78E-43)
            if (r4 <= r2) goto L_0x0182
            goto L_0x0188
        L_0x0182:
            r4 = 159(0x9f, float:2.23E-43)
            if (r4 < r2) goto L_0x0188
        L_0x0186:
            r16 = 1
        L_0x0188:
            if (r16 != 0) goto L_0x018f
        L_0x018a:
            r4 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r4) goto L_0x0191
        L_0x018f:
            r4 = -1
            return r4
        L_0x0191:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r4) goto L_0x0196
            goto L_0x0198
        L_0x0196:
            r18 = 2
        L_0x0198:
            int r1 = r1 + r18
            r24 = r25
            goto L_0x01dc
        L_0x019d:
            r4 = r3
            r13 = 0
            r14 = r4
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x01a7
            return r1
        L_0x01a7:
            r2 = 10
            if (r14 == r2) goto L_0x01ca
            r2 = 13
            if (r14 == r2) goto L_0x01ca
            r2 = 0
            if (r14 < 0) goto L_0x01bb
            r24 = r2
            r2 = 31
            if (r2 >= r14) goto L_0x01c6
            goto L_0x01bd
        L_0x01bb:
            r24 = r2
        L_0x01bd:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r14) goto L_0x01c2
            goto L_0x01c8
        L_0x01c2:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r14) goto L_0x01c8
        L_0x01c6:
            r16 = 1
        L_0x01c8:
            if (r16 != 0) goto L_0x01cf
        L_0x01ca:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r14 != r2) goto L_0x01d1
        L_0x01cf:
            r2 = -1
            return r2
        L_0x01d1:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r14 >= r2) goto L_0x01d6
            goto L_0x01d8
        L_0x01d6:
            r18 = 2
        L_0x01d8:
            int r1 = r1 + r18
            r24 = r22
        L_0x01dc:
        L_0x01de:
            int r8 = r8 + r17
            r2 = r24
            goto L_0x06d8
        L_0x01e4:
            r26 = r3
            r3 = 4
            r4 = r9
            r10 = 0
            int r3 = r4 >> r3
            if (r3 != r11) goto L_0x03e6
            r3 = r6
            r11 = 0
            int r13 = r8 + 2
            if (r5 > r13) goto L_0x024a
            r4 = 65533(0xfffd, float:9.1831E-41)
            r10 = 0
            r12 = r4
            r13 = 0
            int r14 = r2 + 1
            if (r2 != r0) goto L_0x01fe
            return r1
        L_0x01fe:
            r2 = 10
            if (r12 == r2) goto L_0x021d
            r2 = 13
            if (r12 == r2) goto L_0x021d
            r2 = 0
            if (r12 < 0) goto L_0x020f
            r15 = 31
            if (r15 >= r12) goto L_0x0218
        L_0x020f:
            r15 = 127(0x7f, float:1.78E-43)
            if (r15 <= r12) goto L_0x0214
            goto L_0x021a
        L_0x0214:
            r15 = 159(0x9f, float:2.23E-43)
            if (r15 < r12) goto L_0x021a
        L_0x0218:
            r2 = 1
            goto L_0x021b
        L_0x021a:
            r2 = 0
        L_0x021b:
            if (r2 != 0) goto L_0x0222
        L_0x021d:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r12 != r2) goto L_0x0224
        L_0x0222:
            r2 = -1
            return r2
        L_0x0224:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r12 >= r2) goto L_0x022a
            r2 = 1
            goto L_0x022b
        L_0x022a:
            r2 = 2
        L_0x022b:
            int r1 = r1 + r2
            int r2 = r8 + 1
            if (r5 <= r2) goto L_0x0246
            int r2 = r8 + 1
            byte r2 = r3[r2]
            r4 = 0
            r10 = 192(0xc0, float:2.69E-43)
            r12 = r2
            r13 = 0
            r10 = r10 & r12
            r12 = 128(0x80, float:1.794E-43)
            if (r10 != r12) goto L_0x0241
            r16 = 1
        L_0x0241:
            if (r16 != 0) goto L_0x0244
            goto L_0x0246
        L_0x0244:
            goto L_0x03e1
        L_0x0246:
            r17 = 1
            goto L_0x03e1
        L_0x024a:
            byte r13 = r3[r8]
            int r14 = r8 + 1
            byte r14 = r3[r14]
            r15 = 0
            r22 = 192(0xc0, float:2.69E-43)
            r25 = r14
            r27 = 0
            r12 = r25 & r22
            r10 = 128(0x80, float:1.794E-43)
            if (r12 != r10) goto L_0x025f
            r10 = 1
            goto L_0x0260
        L_0x025f:
            r10 = 0
        L_0x0260:
            if (r10 != 0) goto L_0x02a6
            r4 = 65533(0xfffd, float:9.1831E-41)
            r10 = 0
            r12 = r4
            r15 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x026d
            return r1
        L_0x026d:
            r2 = 10
            if (r12 == r2) goto L_0x0290
            r2 = 13
            if (r12 == r2) goto L_0x0290
            r2 = 0
            if (r12 < 0) goto L_0x0281
            r22 = r2
            r2 = 31
            if (r2 >= r12) goto L_0x028c
            goto L_0x0283
        L_0x0281:
            r22 = r2
        L_0x0283:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r12) goto L_0x0288
            goto L_0x028e
        L_0x0288:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r12) goto L_0x028e
        L_0x028c:
            r16 = 1
        L_0x028e:
            if (r16 != 0) goto L_0x0295
        L_0x0290:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r12 != r2) goto L_0x0297
        L_0x0295:
            r2 = -1
            return r2
        L_0x0297:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r12 >= r2) goto L_0x029d
            r17 = 1
        L_0x029d:
            int r1 = r1 + r17
            r14 = r21
            r17 = 1
            goto L_0x03e1
        L_0x02a6:
            int r10 = r8 + 2
            byte r10 = r3[r10]
            r12 = 0
            r15 = 192(0xc0, float:2.69E-43)
            r25 = r10
            r27 = 0
            r15 = r25 & r15
            r4 = 128(0x80, float:1.794E-43)
            if (r15 != r4) goto L_0x02b9
            r4 = 1
            goto L_0x02ba
        L_0x02b9:
            r4 = 0
        L_0x02ba:
            if (r4 != 0) goto L_0x0300
            r4 = 65533(0xfffd, float:9.1831E-41)
            r12 = 0
            r15 = r4
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x02c8
            return r1
        L_0x02c8:
            r2 = 10
            if (r15 == r2) goto L_0x02eb
            r2 = 13
            if (r15 == r2) goto L_0x02eb
            r2 = 0
            if (r15 < 0) goto L_0x02dc
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x02e7
            goto L_0x02de
        L_0x02dc:
            r24 = r2
        L_0x02de:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x02e3
            goto L_0x02e9
        L_0x02e3:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x02e9
        L_0x02e7:
            r16 = 1
        L_0x02e9:
            if (r16 != 0) goto L_0x02f0
        L_0x02eb:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x02f2
        L_0x02f0:
            r2 = -1
            return r2
        L_0x02f2:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x02f7
            goto L_0x02f9
        L_0x02f7:
            r18 = 2
        L_0x02f9:
            int r1 = r1 + r18
            r14 = r22
            goto L_0x03e1
        L_0x0300:
            r4 = -123008(0xfffffffffffe1f80, float:NaN)
            r4 = r4 ^ r10
            int r12 = r14 << 6
            r4 = r4 ^ r12
            int r12 = r13 << 12
            r4 = r4 ^ r12
            r12 = 2048(0x800, float:2.87E-42)
            if (r4 >= r12) goto L_0x0357
            r12 = 65533(0xfffd, float:9.1831E-41)
            r15 = 0
            r21 = r12
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x031e
            return r1
        L_0x031e:
            r2 = r21
            r21 = r3
            r3 = 10
            if (r2 == r3) goto L_0x0345
            r3 = 13
            if (r2 == r3) goto L_0x0345
            r3 = 0
            if (r2 < 0) goto L_0x0336
            r24 = r3
            r3 = 31
            if (r3 >= r2) goto L_0x0341
            goto L_0x0338
        L_0x0336:
            r24 = r3
        L_0x0338:
            r3 = 127(0x7f, float:1.78E-43)
            if (r3 <= r2) goto L_0x033d
            goto L_0x0343
        L_0x033d:
            r3 = 159(0x9f, float:2.23E-43)
            if (r3 < r2) goto L_0x0343
        L_0x0341:
            r16 = 1
        L_0x0343:
            if (r16 != 0) goto L_0x034a
        L_0x0345:
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r3) goto L_0x034c
        L_0x034a:
            r3 = -1
            return r3
        L_0x034c:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r3) goto L_0x0352
            r17 = 1
        L_0x0352:
            int r1 = r1 + r17
            goto L_0x03dc
        L_0x0357:
            r21 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r3 <= r4) goto L_0x035f
            goto L_0x039f
        L_0x035f:
            r3 = 57343(0xdfff, float:8.0355E-41)
            if (r3 < r4) goto L_0x039f
            r3 = 65533(0xfffd, float:9.1831E-41)
            r12 = 0
            r15 = r3
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0370
            return r1
        L_0x0370:
            r2 = 10
            if (r15 == r2) goto L_0x0393
            r2 = 13
            if (r15 == r2) goto L_0x0393
            r2 = 0
            if (r15 < 0) goto L_0x0384
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x038f
            goto L_0x0386
        L_0x0384:
            r24 = r2
        L_0x0386:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x038b
            goto L_0x0391
        L_0x038b:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x0391
        L_0x038f:
            r16 = 1
        L_0x0391:
            if (r16 != 0) goto L_0x0398
        L_0x0393:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x039a
        L_0x0398:
            r2 = -1
            return r2
        L_0x039a:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x03d9
            goto L_0x03d7
        L_0x039f:
            r3 = r4
            r12 = 0
            r15 = r3
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x03a9
            return r1
        L_0x03a9:
            r2 = 10
            if (r15 == r2) goto L_0x03cc
            r2 = 13
            if (r15 == r2) goto L_0x03cc
            r2 = 0
            if (r15 < 0) goto L_0x03bd
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x03c8
            goto L_0x03bf
        L_0x03bd:
            r24 = r2
        L_0x03bf:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x03c4
            goto L_0x03ca
        L_0x03c4:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x03ca
        L_0x03c8:
            r16 = 1
        L_0x03ca:
            if (r16 != 0) goto L_0x03d1
        L_0x03cc:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x03d3
        L_0x03d1:
            r2 = -1
            return r2
        L_0x03d3:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x03d9
        L_0x03d7:
            r17 = 1
        L_0x03d9:
            int r1 = r1 + r17
        L_0x03dc:
            r14 = r25
            r17 = 3
        L_0x03e1:
            int r8 = r8 + r17
            r2 = r14
            goto L_0x06d8
        L_0x03e6:
            r3 = 3
            r4 = r9
            r10 = 0
            int r3 = r4 >> r3
            if (r3 != r11) goto L_0x069e
            r3 = r6
            r4 = 0
            int r10 = r8 + 3
            if (r5 > r10) goto L_0x0466
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 0
            r12 = r10
            r13 = 0
            int r14 = r2 + 1
            if (r2 != r0) goto L_0x03fe
            return r1
        L_0x03fe:
            r2 = 10
            if (r12 == r2) goto L_0x041d
            r2 = 13
            if (r12 == r2) goto L_0x041d
            r2 = 0
            if (r12 < 0) goto L_0x040f
            r15 = 31
            if (r15 >= r12) goto L_0x0418
        L_0x040f:
            r15 = 127(0x7f, float:1.78E-43)
            if (r15 <= r12) goto L_0x0414
            goto L_0x041a
        L_0x0414:
            r15 = 159(0x9f, float:2.23E-43)
            if (r15 < r12) goto L_0x041a
        L_0x0418:
            r2 = 1
            goto L_0x041b
        L_0x041a:
            r2 = 0
        L_0x041b:
            if (r2 != 0) goto L_0x0422
        L_0x041d:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r12 != r2) goto L_0x0424
        L_0x0422:
            r2 = -1
            return r2
        L_0x0424:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r12 >= r2) goto L_0x042a
            r2 = 1
            goto L_0x042b
        L_0x042a:
            r2 = 2
        L_0x042b:
            int r1 = r1 + r2
            int r2 = r8 + 1
            if (r5 <= r2) goto L_0x0462
            int r2 = r8 + 1
            byte r2 = r3[r2]
            r10 = 0
            r11 = 192(0xc0, float:2.69E-43)
            r12 = r2
            r13 = 0
            r11 = r11 & r12
            r12 = 128(0x80, float:1.794E-43)
            if (r11 != r12) goto L_0x0441
            r2 = 1
            goto L_0x0442
        L_0x0441:
            r2 = 0
        L_0x0442:
            if (r2 != 0) goto L_0x0445
            goto L_0x0462
        L_0x0445:
            int r2 = r8 + 2
            if (r5 <= r2) goto L_0x0460
            int r2 = r8 + 2
            byte r2 = r3[r2]
            r10 = 0
            r11 = 192(0xc0, float:2.69E-43)
            r12 = r2
            r13 = 0
            r11 = r11 & r12
            r12 = 128(0x80, float:1.794E-43)
            if (r11 != r12) goto L_0x0459
            r16 = 1
        L_0x0459:
            if (r16 != 0) goto L_0x045c
            goto L_0x0460
        L_0x045c:
            r17 = 3
            goto L_0x069a
        L_0x0460:
            goto L_0x069a
        L_0x0462:
            r17 = 1
            goto L_0x069a
        L_0x0466:
            byte r10 = r3[r8]
            int r11 = r8 + 1
            byte r11 = r3[r11]
            r12 = 0
            r13 = 192(0xc0, float:2.69E-43)
            r14 = r11
            r15 = 0
            r13 = r13 & r14
            r14 = 128(0x80, float:1.794E-43)
            if (r13 != r14) goto L_0x0478
            r12 = 1
            goto L_0x0479
        L_0x0478:
            r12 = 0
        L_0x0479:
            if (r12 != 0) goto L_0x04bf
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 0
            r14 = r12
            r15 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x0486
            return r1
        L_0x0486:
            r2 = 10
            if (r14 == r2) goto L_0x04a9
            r2 = 13
            if (r14 == r2) goto L_0x04a9
            r2 = 0
            if (r14 < 0) goto L_0x049a
            r22 = r2
            r2 = 31
            if (r2 >= r14) goto L_0x04a5
            goto L_0x049c
        L_0x049a:
            r22 = r2
        L_0x049c:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r14) goto L_0x04a1
            goto L_0x04a7
        L_0x04a1:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r14) goto L_0x04a7
        L_0x04a5:
            r16 = 1
        L_0x04a7:
            if (r16 != 0) goto L_0x04ae
        L_0x04a9:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r14 != r2) goto L_0x04b0
        L_0x04ae:
            r2 = -1
            return r2
        L_0x04b0:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r14 >= r2) goto L_0x04b6
            r17 = 1
        L_0x04b6:
            int r1 = r1 + r17
            r14 = r21
            r17 = 1
            goto L_0x069a
        L_0x04bf:
            int r12 = r8 + 2
            byte r12 = r3[r12]
            r13 = 0
            r14 = 192(0xc0, float:2.69E-43)
            r15 = r12
            r27 = 0
            r14 = r14 & r15
            r15 = 128(0x80, float:1.794E-43)
            if (r14 != r15) goto L_0x04d0
            r13 = 1
            goto L_0x04d1
        L_0x04d0:
            r13 = 0
        L_0x04d1:
            if (r13 != 0) goto L_0x0517
            r13 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r13
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x04df
            return r1
        L_0x04df:
            r2 = 10
            if (r15 == r2) goto L_0x0502
            r2 = 13
            if (r15 == r2) goto L_0x0502
            r2 = 0
            if (r15 < 0) goto L_0x04f3
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x04fe
            goto L_0x04f5
        L_0x04f3:
            r24 = r2
        L_0x04f5:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x04fa
            goto L_0x0500
        L_0x04fa:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x0500
        L_0x04fe:
            r16 = 1
        L_0x0500:
            if (r16 != 0) goto L_0x0507
        L_0x0502:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0509
        L_0x0507:
            r2 = -1
            return r2
        L_0x0509:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x050e
            goto L_0x0510
        L_0x050e:
            r18 = 2
        L_0x0510:
            int r1 = r1 + r18
            r14 = r22
            goto L_0x069a
        L_0x0517:
            int r13 = r8 + 3
            byte r13 = r3[r13]
            r14 = 0
            r15 = 192(0xc0, float:2.69E-43)
            r27 = r13
            r28 = 0
            r15 = r27 & r15
            r27 = r3
            r3 = 128(0x80, float:1.794E-43)
            if (r15 != r3) goto L_0x052c
            r3 = 1
            goto L_0x052d
        L_0x052c:
            r3 = 0
        L_0x052d:
            if (r3 != 0) goto L_0x0574
            r3 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r3
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x053b
            return r1
        L_0x053b:
            r2 = 10
            if (r15 == r2) goto L_0x055e
            r2 = 13
            if (r15 == r2) goto L_0x055e
            r2 = 0
            if (r15 < 0) goto L_0x054f
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x055a
            goto L_0x0551
        L_0x054f:
            r24 = r2
        L_0x0551:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x0556
            goto L_0x055c
        L_0x0556:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x055c
        L_0x055a:
            r16 = 1
        L_0x055c:
            if (r16 != 0) goto L_0x0563
        L_0x055e:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0565
        L_0x0563:
            r2 = -1
            return r2
        L_0x0565:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x056b
            r17 = 1
        L_0x056b:
            int r1 = r1 + r17
            r14 = r22
            r17 = 3
            goto L_0x069a
        L_0x0574:
            r3 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r13
            int r14 = r12 << 6
            r3 = r3 ^ r14
            int r14 = r11 << 12
            r3 = r3 ^ r14
            int r14 = r10 << 18
            r3 = r3 ^ r14
            r14 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r14) goto L_0x05d0
            r14 = 65533(0xfffd, float:9.1831E-41)
            r15 = 0
            r21 = r14
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0596
            return r1
        L_0x0596:
            r2 = r21
            r21 = r4
            r4 = 10
            if (r2 == r4) goto L_0x05bd
            r4 = 13
            if (r2 == r4) goto L_0x05bd
            r4 = 0
            if (r2 < 0) goto L_0x05ae
            r24 = r4
            r4 = 31
            if (r4 >= r2) goto L_0x05b9
            goto L_0x05b0
        L_0x05ae:
            r24 = r4
        L_0x05b0:
            r4 = 127(0x7f, float:1.78E-43)
            if (r4 <= r2) goto L_0x05b5
            goto L_0x05bb
        L_0x05b5:
            r4 = 159(0x9f, float:2.23E-43)
            if (r4 < r2) goto L_0x05bb
        L_0x05b9:
            r16 = 1
        L_0x05bb:
            if (r16 != 0) goto L_0x05c2
        L_0x05bd:
            r4 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r4) goto L_0x05c4
        L_0x05c2:
            r4 = -1
            return r4
        L_0x05c4:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r4) goto L_0x05ca
            r17 = 1
        L_0x05ca:
            int r1 = r1 + r17
            r14 = r25
            goto L_0x0697
        L_0x05d0:
            r21 = r4
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r4 <= r3) goto L_0x05d8
            goto L_0x061f
        L_0x05d8:
            r4 = 57343(0xdfff, float:8.0355E-41)
            if (r4 < r3) goto L_0x061f
            r4 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r4
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x05e9
            return r1
        L_0x05e9:
            r2 = 10
            if (r15 == r2) goto L_0x060c
            r2 = 13
            if (r15 == r2) goto L_0x060c
            r2 = 0
            if (r15 < 0) goto L_0x05fd
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x0608
            goto L_0x05ff
        L_0x05fd:
            r24 = r2
        L_0x05ff:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x0604
            goto L_0x060a
        L_0x0604:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x060a
        L_0x0608:
            r16 = 1
        L_0x060a:
            if (r16 != 0) goto L_0x0611
        L_0x060c:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0613
        L_0x0611:
            r2 = -1
            return r2
        L_0x0613:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0619
        L_0x0617:
            r17 = 1
        L_0x0619:
            int r1 = r1 + r17
            r14 = r25
            goto L_0x0697
        L_0x061f:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r4) goto L_0x065e
            r4 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r4
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x062f
            return r1
        L_0x062f:
            r2 = 10
            if (r15 == r2) goto L_0x0652
            r2 = 13
            if (r15 == r2) goto L_0x0652
            r2 = 0
            if (r15 < 0) goto L_0x0643
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x064e
            goto L_0x0645
        L_0x0643:
            r24 = r2
        L_0x0645:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x064a
            goto L_0x0650
        L_0x064a:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x0650
        L_0x064e:
            r16 = 1
        L_0x0650:
            if (r16 != 0) goto L_0x0657
        L_0x0652:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0659
        L_0x0657:
            r2 = -1
            return r2
        L_0x0659:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0619
            goto L_0x0617
        L_0x065e:
            r4 = r3
            r14 = 0
            r15 = r4
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0668
            return r1
        L_0x0668:
            r2 = 10
            if (r15 == r2) goto L_0x068b
            r2 = 13
            if (r15 == r2) goto L_0x068b
            r2 = 0
            if (r15 < 0) goto L_0x067c
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x0687
            goto L_0x067e
        L_0x067c:
            r24 = r2
        L_0x067e:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x0683
            goto L_0x0689
        L_0x0683:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x0689
        L_0x0687:
            r16 = 1
        L_0x0689:
            if (r16 != 0) goto L_0x0690
        L_0x068b:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0692
        L_0x0690:
            r2 = -1
            return r2
        L_0x0692:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0619
            goto L_0x0617
        L_0x0697:
            r17 = 4
        L_0x069a:
            int r8 = r8 + r17
            r2 = r14
            goto L_0x06d8
        L_0x069e:
            r3 = 65533(0xfffd, float:9.1831E-41)
            r4 = 0
            int r10 = r2 + 1
            if (r2 != r0) goto L_0x06a7
            return r1
        L_0x06a7:
            r2 = 10
            if (r3 == r2) goto L_0x06c5
            r2 = 13
            if (r3 == r2) goto L_0x06c5
            r2 = 0
            if (r3 < 0) goto L_0x06b8
            r11 = 31
            if (r11 >= r3) goto L_0x06c1
        L_0x06b8:
            r11 = 127(0x7f, float:1.78E-43)
            if (r11 <= r3) goto L_0x06bd
            goto L_0x06c3
        L_0x06bd:
            r11 = 159(0x9f, float:2.23E-43)
            if (r11 < r3) goto L_0x06c3
        L_0x06c1:
            r16 = 1
        L_0x06c3:
            if (r16 != 0) goto L_0x06ca
        L_0x06c5:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r2) goto L_0x06cc
        L_0x06ca:
            r2 = -1
            return r2
        L_0x06cc:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r2) goto L_0x06d2
            r17 = 1
        L_0x06d2:
            int r1 = r1 + r17
            int r8 = r8 + 1
            r2 = r10
        L_0x06d8:
            r4 = r29
            r3 = r26
            goto L_0x000c
        L_0x06df:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }
}
