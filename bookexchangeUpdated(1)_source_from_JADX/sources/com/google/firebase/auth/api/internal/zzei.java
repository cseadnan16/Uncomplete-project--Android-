package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_auth.zze;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzei extends GmsClient<zzep> implements zzef {
    private static Logger zza = new Logger("FirebaseAuth", "FirebaseAuth:");
    private final Context zzb;
    private final zzeu zzc;

    public zzei(Context context, Looper looper, ClientSettings clientSettings, zzeu zzeu, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzb = (Context) Preconditions.checkNotNull(context);
        this.zzc = zzeu;
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServicePackage() {
        if (this.zzc.zza) {
            zza.mo11214i("Preparing to create service connection to fallback implementation", new Object[0]);
            return this.zzb.getPackageName();
        }
        zza.mo11214i("Preparing to create service connection to gms implementation", new Object[0]);
        return "com.google.android.gms";
    }

    public final boolean requiresGooglePlayServices() {
        return DynamiteModule.getLocalVersion(this.zzb, "com.google.firebase.auth") == 0;
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        if (getServiceRequestExtraArgs == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        zzeu zzeu = this.zzc;
        if (zzeu != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", zzeu.zzb());
        }
        getServiceRequestExtraArgs.putString("com.google.firebase.auth.LIBRARY_VERSION", zzew.zzc());
        return getServiceRequestExtraArgs;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final Feature[] getApiFeatures() {
        return zze.zzc;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        if (queryLocalInterface instanceof zzep) {
            return (zzep) queryLocalInterface;
        }
        return new zzer(iBinder);
    }

    public final /* synthetic */ zzep zza() throws DeadObjectException {
        return (zzep) super.getService();
    }
}
