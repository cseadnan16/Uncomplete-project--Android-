package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class FragmentContainer {
    public abstract View onFindViewById(int i);

    public abstract boolean onHasView();

    @Deprecated
    public C0198Fragment instantiate(Context context, String className, Bundle arguments) {
        return C0198Fragment.instantiate(context, className, arguments);
    }
}
