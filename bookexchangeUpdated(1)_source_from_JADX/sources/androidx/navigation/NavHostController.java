package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

public final class NavHostController extends NavController {
    public NavHostController(Context context) {
        super(context);
    }

    public void setLifecycleOwner(LifecycleOwner owner) {
        super.setLifecycleOwner(owner);
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher dispatcher) {
        super.setOnBackPressedDispatcher(dispatcher);
    }

    public void enableOnBackPressed(boolean enabled) {
        super.enableOnBackPressed(enabled);
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        super.setViewModelStore(viewModelStore);
    }
}
