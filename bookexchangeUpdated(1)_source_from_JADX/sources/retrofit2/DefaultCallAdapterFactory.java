package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;

final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    @Nullable
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != Call.class) {
            return null;
        }
        final Type responseType = C1244Utils.getCallResponseType(returnType);
        return new CallAdapter<Object, Call<?>>() {
            public Type responseType() {
                return responseType;
            }

            public Call<Object> adapt(Call<Object> call) {
                return call;
            }
        };
    }
}
