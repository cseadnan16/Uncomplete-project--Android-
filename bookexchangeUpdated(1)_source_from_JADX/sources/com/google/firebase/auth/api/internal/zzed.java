package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzed implements Callable<zzal<zzeu>> {
    private final zzeu zza;
    private final Context zzb;

    public zzed(zzeu zzeu, Context context) {
        this.zza = zzeu;
        this.zzb = context;
    }

    private final GoogleApi<zzeu> zza(boolean z, Context context) {
        zzeu zzeu = (zzeu) this.zza.clone();
        zzeu.zza = z;
        return new zzaq(context, zzet.zza, zzeu, new FirebaseExceptionMapper());
    }

    public final /* synthetic */ Object call() throws Exception {
        GoogleApi<zzeu> googleApi;
        int i;
        if (zzee.zza == -1 || zzee.zzb == -1) {
            int localVersion = DynamiteModule.getLocalVersion(this.zzb, "com.google.firebase.auth");
            if (localVersion == 0) {
                i = 1;
            } else {
                int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzb, 12451000);
                if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                    i = DynamiteModule.getRemoteVersion(this.zzb, "com.google.android.gms.firebase_auth");
                } else {
                    i = 0;
                }
            }
            int unused = zzee.zza = i;
            int unused2 = zzee.zzb = localVersion;
        }
        GoogleApi<zzeu> googleApi2 = null;
        if (zzee.zzb != 0) {
            googleApi = zza(true, this.zzb);
        } else {
            googleApi = null;
        }
        if (zzee.zza != 0) {
            googleApi2 = zza(false, this.zzb);
        }
        return new zzal(googleApi2, googleApi, new zzan(zzee.zza, zzee.zzb, Collections.emptyMap()));
    }
}
