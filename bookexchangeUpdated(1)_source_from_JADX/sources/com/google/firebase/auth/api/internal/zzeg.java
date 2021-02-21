package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzeg {
    private final zzeo zza;
    private final Logger zzb;

    public zzeg(zzeo zzeo, Logger logger) {
        this.zza = (zzeo) Preconditions.checkNotNull(zzeo);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza(zzff zzff) {
        try {
            this.zza.zza(zzff);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zza(zzff zzff, zzew zzew) {
        try {
            this.zza.zza(zzff, zzew);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zza(zzem zzem) {
        try {
            this.zza.zza(zzem);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zza(zzfm zzfm) {
        try {
            this.zza.zza(zzfm);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zza() {
        try {
            this.zza.mo17605i_();
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public final void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending send verification code response.", e, new Object[0]);
        }
    }

    public final void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(status, phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public final void zza(zzeh zzeh) {
        try {
            this.zza.zza(zzeh);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }

    public final void zza(zzej zzej) {
        try {
            this.zza.zza(zzej);
        } catch (RemoteException e) {
            this.zzb.mo11212e("RemoteException when sending failure result for mfa", e, new Object[0]);
        }
    }
}
