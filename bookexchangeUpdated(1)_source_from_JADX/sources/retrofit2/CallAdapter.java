package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public interface CallAdapter<R, T> {
    T adapt(Call<R> call);

    Type responseType();

    public static abstract class Factory {
        @Nullable
        public abstract CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit);

        protected static Type getParameterUpperBound(int index, ParameterizedType type) {
            return C1244Utils.getParameterUpperBound(index, type);
        }

        protected static Class<?> getRawType(Type type) {
            return C1244Utils.getRawType(type);
        }
    }
}
