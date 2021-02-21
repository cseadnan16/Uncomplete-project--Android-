package okhttp3;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo20370d2 = {"okhttp3/CipherSuite$Companion$ORDER_BY_NAME$1", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "compare", "", "a", "b", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: CipherSuite.kt */
public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator<String> {
    CipherSuite$Companion$ORDER_BY_NAME$1() {
    }

    public int compare(String a, String b) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        int i = 4;
        int limit = Math.min(a.length(), b.length());
        while (i < limit) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            if (charA == charB) {
                i++;
            } else if (charA < charB) {
                return -1;
            } else {
                return 1;
            }
        }
        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthA == lengthB) {
            return 0;
        }
        if (lengthA < lengthB) {
            return -1;
        }
        return 1;
    }
}
