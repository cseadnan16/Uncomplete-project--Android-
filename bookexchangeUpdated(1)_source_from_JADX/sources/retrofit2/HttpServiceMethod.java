package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final CallAdapter<ResponseT, ReturnT> callAdapter;
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory2) {
        CallAdapter<ResponseT, ReturnT> callAdapter2 = createCallAdapter(retrofit, method);
        Type responseType = callAdapter2.responseType();
        if (responseType == Response.class || responseType == Response.class) {
            throw C1244Utils.methodError(method, "'" + C1244Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (!requestFactory2.httpMethod.equals("HEAD") || Void.class.equals(responseType)) {
            return new HttpServiceMethod<>(requestFactory2, retrofit.callFactory, callAdapter2, createResponseConverter(retrofit, method, responseType));
        } else {
            throw C1244Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method) {
        Type returnType = method.getGenericReturnType();
        try {
            return retrofit.callAdapter(returnType, method.getAnnotations());
        } catch (RuntimeException e) {
            throw C1244Utils.methodError(method, e, "Unable to create call adapter for %s", returnType);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type responseType) {
        try {
            return retrofit.responseBodyConverter(responseType, method.getAnnotations());
        } catch (RuntimeException e) {
            throw C1244Utils.methodError(method, e, "Unable to create converter for %s", responseType);
        }
    }

    private HttpServiceMethod(RequestFactory requestFactory2, Call.Factory callFactory2, CallAdapter<ResponseT, ReturnT> callAdapter2, Converter<ResponseBody, ResponseT> responseConverter2) {
        this.requestFactory = requestFactory2;
        this.callFactory = callFactory2;
        this.callAdapter = callAdapter2;
        this.responseConverter = responseConverter2;
    }

    /* access modifiers changed from: package-private */
    public ReturnT invoke(Object[] args) {
        return this.callAdapter.adapt(new OkHttpCall(this.requestFactory, args, this.callFactory, this.responseConverter));
    }
}
