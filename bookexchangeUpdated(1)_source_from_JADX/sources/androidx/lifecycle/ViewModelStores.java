package androidx.lifecycle;

import androidx.fragment.app.C0198Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ViewModelStores {
    private ViewModelStores() {
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelStore m15of(FragmentActivity activity) {
        return activity.getViewModelStore();
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelStore m14of(C0198Fragment fragment) {
        return fragment.getViewModelStore();
    }
}
