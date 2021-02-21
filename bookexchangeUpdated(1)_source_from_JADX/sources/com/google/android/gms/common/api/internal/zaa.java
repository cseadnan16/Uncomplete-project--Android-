package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C1245zaa> zaco;

    public zaa(Activity activity) {
        this(C1245zaa.zaa(activity));
    }

    private zaa(C1245zaa zaa) {
        this.zaco = new WeakReference<>(zaa);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C1245zaa zaa = (C1245zaa) this.zaco.get();
        if (zaa != null) {
            zaa.zaa(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    static class C1245zaa extends LifecycleCallback {
        private List<Runnable> zacn = new ArrayList();

        /* access modifiers changed from: private */
        public static C1245zaa zaa(Activity activity) {
            C1245zaa zaa;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                zaa = (C1245zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C1245zaa.class);
                if (zaa == null) {
                    zaa = new C1245zaa(fragment);
                }
            }
            return zaa;
        }

        private C1245zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zacn.add(runnable);
        }

        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacn;
                this.zacn = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }
    }
}
