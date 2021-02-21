package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;

@Navigator.Name("NoOp")
class NoOpNavigator extends Navigator<NavDestination> {
    NoOpNavigator() {
    }

    public NavDestination createDestination() {
        return new NavDestination((Navigator<? extends NavDestination>) this);
    }

    public NavDestination navigate(NavDestination destination, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        return destination;
    }

    public boolean popBackStack() {
        return true;
    }
}
