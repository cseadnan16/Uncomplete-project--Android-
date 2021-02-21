package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore {
    private static final String TAG = "FragmentManager";
    private final HashMap<String, FragmentStateManager> mActive = new HashMap<>();
    private final ArrayList<C0198Fragment> mAdded = new ArrayList<>();

    FragmentStore() {
    }

    /* access modifiers changed from: package-private */
    public void resetActiveFragments() {
        this.mActive.clear();
    }

    /* access modifiers changed from: package-private */
    public void restoreAddedFragments(List<String> added) {
        this.mAdded.clear();
        if (added != null) {
            for (String who : added) {
                C0198Fragment f = findActiveFragment(who);
                if (f != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(TAG, "restoreSaveState: added (" + who + "): " + f);
                    }
                    addFragment(f);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + who + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void makeActive(FragmentStateManager newlyActive) {
        this.mActive.put(newlyActive.getFragment().mWho, newlyActive);
    }

    /* access modifiers changed from: package-private */
    public void addFragment(C0198Fragment fragment) {
        if (!this.mAdded.contains(fragment)) {
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStateChange(int state) {
        Iterator<C0198Fragment> it = this.mAdded.iterator();
        while (it.hasNext()) {
            FragmentStateManager fragmentStateManager = this.mActive.get(it.next().mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.setFragmentManagerState(state);
            }
        }
        for (FragmentStateManager fragmentStateManager2 : this.mActive.values()) {
            if (fragmentStateManager2 != null) {
                fragmentStateManager2.setFragmentManagerState(state);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFragment(C0198Fragment fragment) {
        synchronized (this.mAdded) {
            this.mAdded.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public void makeInactive(FragmentStateManager newlyInactive) {
        C0198Fragment f = newlyInactive.getFragment();
        for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                C0198Fragment fragment = fragmentStateManager.getFragment();
                if (f.mWho.equals(fragment.mTargetWho)) {
                    fragment.mTarget = f;
                    fragment.mTargetWho = null;
                }
            }
        }
        this.mActive.put(f.mWho, (Object) null);
        if (f.mTargetWho != null) {
            f.mTarget = findActiveFragment(f.mTargetWho);
        }
    }

    /* access modifiers changed from: package-private */
    public void burpActive() {
        this.mActive.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public ArrayList<FragmentState> saveActiveFragments() {
        ArrayList<FragmentState> active = new ArrayList<>(this.mActive.size());
        for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                C0198Fragment f = fragmentStateManager.getFragment();
                FragmentState fs = fragmentStateManager.saveState();
                active.add(fs);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(TAG, "Saved state of " + f + ": " + fs.mSavedFragmentState);
                }
            }
        }
        return active;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> saveAddedFragments() {
        synchronized (this.mAdded) {
            if (this.mAdded.isEmpty()) {
                return null;
            }
            ArrayList<String> added = new ArrayList<>(this.mAdded.size());
            Iterator<C0198Fragment> it = this.mAdded.iterator();
            while (it.hasNext()) {
                C0198Fragment f = it.next();
                added.add(f.mWho);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(TAG, "saveAllState: adding fragment (" + f.mWho + "): " + f);
                }
            }
            return added;
        }
    }

    /* access modifiers changed from: package-private */
    public List<C0198Fragment> getFragments() {
        ArrayList arrayList;
        if (this.mAdded.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.mAdded) {
            arrayList = new ArrayList(this.mAdded);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<C0198Fragment> getActiveFragments() {
        ArrayList<C0198Fragment> activeFragments = new ArrayList<>();
        for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                activeFragments.add(fragmentStateManager.getFragment());
            } else {
                activeFragments.add((Object) null);
            }
        }
        return activeFragments;
    }

    /* access modifiers changed from: package-private */
    public int getActiveFragmentCount() {
        return this.mActive.size();
    }

    /* access modifiers changed from: package-private */
    public C0198Fragment findFragmentById(int id) {
        for (int i = this.mAdded.size() - 1; i >= 0; i--) {
            C0198Fragment f = this.mAdded.get(i);
            if (f != null && f.mFragmentId == id) {
                return f;
            }
        }
        for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                C0198Fragment f2 = fragmentStateManager.getFragment();
                if (f2.mFragmentId == id) {
                    return f2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public C0198Fragment findFragmentByTag(String tag) {
        if (tag != null) {
            for (int i = this.mAdded.size() - 1; i >= 0; i--) {
                C0198Fragment f = this.mAdded.get(i);
                if (f != null && tag.equals(f.mTag)) {
                    return f;
                }
            }
        }
        if (tag == null) {
            return null;
        }
        for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                C0198Fragment f2 = fragmentStateManager.getFragment();
                if (tag.equals(f2.mTag)) {
                    return f2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean containsActiveFragment(String who) {
        return this.mActive.containsKey(who);
    }

    /* access modifiers changed from: package-private */
    public FragmentStateManager getFragmentStateManager(String who) {
        return this.mActive.get(who);
    }

    /* access modifiers changed from: package-private */
    public C0198Fragment findFragmentByWho(String who) {
        for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
            if (fragmentStateManager != null) {
                C0198Fragment findFragmentByWho = fragmentStateManager.getFragment().findFragmentByWho(who);
                C0198Fragment f = findFragmentByWho;
                if (findFragmentByWho != null) {
                    return f;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public C0198Fragment findActiveFragment(String who) {
        FragmentStateManager fragmentStateManager = this.mActive.get(who);
        if (fragmentStateManager != null) {
            return fragmentStateManager.getFragment();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public C0198Fragment findFragmentUnder(C0198Fragment f) {
        ViewGroup container = f.mContainer;
        View view = f.mView;
        if (container == null || view == null) {
            return null;
        }
        for (int i = this.mAdded.indexOf(f) - 1; i >= 0; i--) {
            C0198Fragment underFragment = this.mAdded.get(i);
            if (underFragment.mContainer == container && underFragment.mView != null) {
                return underFragment;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String innerPrefix = prefix + "    ";
        if (!this.mActive.isEmpty()) {
            writer.print(prefix);
            writer.print("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                writer.print(prefix);
                if (fragmentStateManager != null) {
                    C0198Fragment f = fragmentStateManager.getFragment();
                    writer.println(f);
                    f.dump(innerPrefix, fd, writer, args);
                } else {
                    writer.println("null");
                }
            }
        }
        int count = this.mAdded.size();
        if (count > 0) {
            writer.print(prefix);
            writer.println("Added Fragments:");
            for (int i = 0; i < count; i++) {
                writer.print(prefix);
                writer.print("  #");
                writer.print(i);
                writer.print(": ");
                writer.println(this.mAdded.get(i).toString());
            }
        }
    }
}
