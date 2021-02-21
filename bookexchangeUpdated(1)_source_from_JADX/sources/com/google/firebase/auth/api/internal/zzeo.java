package com.google.firebase.auth.api.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public interface zzeo extends IInterface {
    /* renamed from: i_ */
    void mo17605i_() throws RemoteException;

    void zza(Status status) throws RemoteException;

    void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zza(zzeh zzeh) throws RemoteException;

    void zza(zzej zzej) throws RemoteException;

    void zza(zzem zzem) throws RemoteException;

    void zza(zzff zzff) throws RemoteException;

    void zza(zzff zzff, zzew zzew) throws RemoteException;

    void zza(zzfm zzfm) throws RemoteException;

    void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zza(String str) throws RemoteException;

    void zzb() throws RemoteException;

    void zzb(String str) throws RemoteException;

    void zzc() throws RemoteException;

    void zzc(String str) throws RemoteException;
}
