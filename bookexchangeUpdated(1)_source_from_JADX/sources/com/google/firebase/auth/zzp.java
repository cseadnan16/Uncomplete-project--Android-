package com.google.firebase.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final /* synthetic */ class zzp implements ComponentFactory {
    static final ComponentFactory zza = new zzp();

    private zzp() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zzl((FirebaseApp) componentContainer.get(FirebaseApp.class));
    }
}
