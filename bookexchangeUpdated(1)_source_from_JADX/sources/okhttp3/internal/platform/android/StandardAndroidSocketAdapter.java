package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo20370d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocketFactory;", "paramClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "matchesSocketFactory", "", "sslSocketFactory", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
/* compiled from: StandardAndroidSocketAdapter.kt */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(Class<? super SSLSocket> sslSocketClass, Class<? super SSLSocketFactory> sslSocketFactoryClass2, Class<?> paramClass2) {
        super(sslSocketClass);
        Intrinsics.checkParameterIsNotNull(sslSocketClass, "sslSocketClass");
        Intrinsics.checkParameterIsNotNull(sslSocketFactoryClass2, "sslSocketFactoryClass");
        Intrinsics.checkParameterIsNotNull(paramClass2, "paramClass");
        this.sslSocketFactoryClass = sslSocketFactoryClass2;
        this.paramClass = paramClass2;
    }

    public boolean matchesSocketFactory(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkParameterIsNotNull(sslSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sslSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkParameterIsNotNull(sslSocketFactory, "sslSocketFactory");
        Object context = Util.readFieldOrNull(sslSocketFactory, this.paramClass, "sslParameters");
        if (context == null) {
            Intrinsics.throwNpe();
        }
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(context, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Util.readFieldOrNull(context, X509TrustManager.class, "trustManager");
    }

    @Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo20370d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "packageName", "", "okhttp"}, mo20371k = 1, mo20372mv = {1, 1, 16})
    /* compiled from: StandardAndroidSocketAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        public final SocketAdapter buildIfSupported(String packageName) {
            StandardAndroidSocketAdapter standardAndroidSocketAdapter;
            Intrinsics.checkParameterIsNotNull(packageName, "packageName");
            try {
                Class sslSocketClass = Class.forName(packageName + ".OpenSSLSocketImpl");
                if (sslSocketClass != null) {
                    Class sslSocketFactoryClass = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                    if (sslSocketFactoryClass != null) {
                        Class paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                        Intrinsics.checkExpressionValueIsNotNull(paramsClass, "paramsClass");
                        standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(sslSocketClass, sslSocketFactoryClass, paramsClass);
                        return standardAndroidSocketAdapter;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
            } catch (Exception e) {
                UtilKt.androidLog(5, "unable to load android socket classes", e);
                standardAndroidSocketAdapter = null;
            }
        }
    }
}
