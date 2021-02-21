package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzeq extends zzb implements zzeo {
    zzeq(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    public final void zza(zzff zzff) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzff);
        zzb(1, zza);
    }

    public final void zza(zzff zzff, zzew zzew) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzff);
        zzd.zza(zza, (Parcelable) zzew);
        zzb(2, zza);
    }

    public final void zza(zzem zzem) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzem);
        zzb(3, zza);
    }

    public final void zza(zzfm zzfm) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzfm);
        zzb(4, zza);
    }

    public final void zza(Status status) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) status);
        zzb(5, zza);
    }

    /* renamed from: i_ */
    public final void mo17605i_() throws RemoteException {
        zzb(6, zza());
    }

    public final void zzb() throws RemoteException {
        zzb(7, zza());
    }

    public final void zza(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(8, zza);
    }

    public final void zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(9, zza);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzb(10, zza);
    }

    public final void zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(11, zza);
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) status);
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzb(12, zza);
    }

    public final void zzc() throws RemoteException {
        zzb(13, zza());
    }

    public final void zza(zzeh zzeh) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzeh);
        zzb(14, zza);
    }

    public final void zza(zzej zzej) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzej);
        zzb(15, zza);
    }
}
