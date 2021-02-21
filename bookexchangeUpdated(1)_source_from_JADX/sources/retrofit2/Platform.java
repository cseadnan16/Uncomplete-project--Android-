package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;

class Platform {
    private static final Platform PLATFORM = findPlatform();

    Platform() {
    }

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("java.util.Optional");
            return new Java8();
        } catch (ClassNotFoundException e2) {
            return new Platform();
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor callbackExecutor) {
        if (callbackExecutor != null) {
            return Collections.singletonList(new ExecutorCallAdapterFactory(callbackExecutor));
        }
        return Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public int defaultConverterFactoriesSize() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isDefaultMethod(Method method) {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object object, @Nullable Object... args) throws Throwable {
        throw new UnsupportedOperationException();
    }

    static class Java8 extends Platform {
        Java8() {
        }

        /* access modifiers changed from: package-private */
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: package-private */
        public Object invokeDefaultMethod(Method method, Class<?> declaringClass, Object object, @Nullable Object... args) throws Throwable {
            Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[]{declaringClass, -1}).unreflectSpecial(method, declaringClass).bindTo(object).invokeWithArguments(args);
        }

        /* access modifiers changed from: package-private */
        public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor callbackExecutor) {
            List<CallAdapter.Factory> factories = new ArrayList<>(2);
            factories.add(CompletableFutureCallAdapterFactory.INSTANCE);
            if (callbackExecutor != null) {
                factories.add(new ExecutorCallAdapterFactory(callbackExecutor));
            } else {
                factories.add(DefaultCallAdapterFactory.INSTANCE);
            }
            return Collections.unmodifiableList(factories);
        }

        /* access modifiers changed from: package-private */
        public int defaultCallAdapterFactoriesSize() {
            return 2;
        }

        /* access modifiers changed from: package-private */
        public List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }

        /* access modifiers changed from: package-private */
        public int defaultConverterFactoriesSize() {
            return 1;
        }
    }

    static class Android extends Platform {
        Android() {
        }

        /* access modifiers changed from: package-private */
        public boolean isDefaultMethod(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        /* access modifiers changed from: package-private */
        public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor callbackExecutor) {
            if (callbackExecutor != null) {
                ExecutorCallAdapterFactory executorFactory = new ExecutorCallAdapterFactory(callbackExecutor);
                if (Build.VERSION.SDK_INT < 24) {
                    return Collections.singletonList(executorFactory);
                }
                return Arrays.asList(new CallAdapter.Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, executorFactory});
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public int defaultCallAdapterFactoriesSize() {
            return Build.VERSION.SDK_INT >= 24 ? 2 : 1;
        }

        /* access modifiers changed from: package-private */
        public List<? extends Converter.Factory> defaultConverterFactories() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(OptionalConverterFactory.INSTANCE);
            }
            return Collections.emptyList();
        }

        /* access modifiers changed from: package-private */
        public int defaultConverterFactoriesSize() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            public void execute(Runnable r) {
                this.handler.post(r);
            }
        }
    }
}
