package androidx.lifecycle;

import android.app.Application;
import androidx.fragment.app.C0198Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

@Deprecated
public class ViewModelProviders {
    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m10of(C0198Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m12of(FragmentActivity activity) {
        return new ViewModelProvider(activity);
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m11of(C0198Fragment fragment, ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m13of(FragmentActivity activity, ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = activity.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(activity.getViewModelStore(), factory);
    }

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application application) {
            super(application);
        }
    }
}
