package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

abstract class ServiceMethod<T> {
    /* access modifiers changed from: package-private */
    public abstract T invoke(Object[] objArr);

    ServiceMethod() {
    }

    static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method) {
        RequestFactory requestFactory = RequestFactory.parseAnnotations(retrofit, method);
        Type returnType = method.getGenericReturnType();
        if (C1244Utils.hasUnresolvableType(returnType)) {
            throw C1244Utils.methodError(method, "Method return type must not include a type variable or wildcard: %s", returnType);
        } else if (returnType != Void.TYPE) {
            return HttpServiceMethod.parseAnnotations(retrofit, method, requestFactory);
        } else {
            throw C1244Utils.methodError(method, "Service methods cannot return void.", new Object[0]);
        }
    }
}
