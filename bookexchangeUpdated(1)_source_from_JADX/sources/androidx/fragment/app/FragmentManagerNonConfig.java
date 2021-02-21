package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig {
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    private final Collection<C0198Fragment> mFragments;
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(Collection<C0198Fragment> fragments, Map<String, FragmentManagerNonConfig> childNonConfigs, Map<String, ViewModelStore> viewModelStores) {
        this.mFragments = fragments;
        this.mChildNonConfigs = childNonConfigs;
        this.mViewModelStores = viewModelStores;
    }

    /* access modifiers changed from: package-private */
    public boolean isRetaining(C0198Fragment f) {
        Collection<C0198Fragment> collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(f);
    }

    /* access modifiers changed from: package-private */
    public Collection<C0198Fragment> getFragments() {
        return this.mFragments;
    }

    /* access modifiers changed from: package-private */
    public Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    /* access modifiers changed from: package-private */
    public Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }
}
