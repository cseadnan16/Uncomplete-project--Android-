package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zzbx;
import com.google.android.gms.internal.firebase_auth.zzbz;
import com.google.android.gms.internal.firebase_auth.zzcb;
import com.google.android.gms.internal.firebase_auth.zzcd;
import com.google.android.gms.internal.firebase_auth.zzcf;
import com.google.android.gms.internal.firebase_auth.zzch;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzcl;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcv;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzdd;
import com.google.android.gms.internal.firebase_auth.zzdf;
import com.google.android.gms.internal.firebase_auth.zzdh;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.android.gms.internal.firebase_auth.zzdn;
import com.google.android.gms.internal.firebase_auth.zzdp;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.android.gms.internal.firebase_auth.zzdv;
import com.google.android.gms.internal.firebase_auth.zzdx;
import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzeb;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.android.gms.internal.firebase_auth.zzef;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import okhttp3.internal.p011ws.WebSocketProtocol;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzer extends zzb implements zzep {
    zzer(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    public final void zza(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(1, zza);
    }

    public final void zzb(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(2, zza);
    }

    public final void zza(zzfy zzfy, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzfy);
        zzd.zza(zza, (IInterface) zzeo);
        zza(3, zza);
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) userProfileChangeRequest);
        zzd.zza(zza, (IInterface) zzeo);
        zza(4, zza);
    }

    public final void zza(String str, String str2, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzeo);
        zza(5, zza);
    }

    public final void zzb(String str, String str2, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzeo);
        zza(6, zza);
    }

    public final void zzc(String str, String str2, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzeo);
        zza(7, zza);
    }

    public final void zzd(String str, String str2, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzeo);
        zza(8, zza);
    }

    public final void zzc(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(9, zza);
    }

    public final void zzd(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(10, zza);
    }

    public final void zza(String str, String str2, String str3, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzd.zza(zza, (IInterface) zzeo);
        zza(11, zza);
    }

    public final void zza(String str, zzfy zzfy, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) zzfy);
        zzd.zza(zza, (IInterface) zzeo);
        zza(12, zza);
    }

    public final void zze(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(13, zza);
    }

    public final void zze(String str, String str2, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzeo);
        zza(14, zza);
    }

    public final void zzf(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(15, zza);
    }

    public final void zza(zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzeo);
        zza(16, zza);
    }

    public final void zzg(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(17, zza);
    }

    public final void zzh(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(18, zza);
    }

    public final void zzi(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(19, zza);
    }

    public final void zzj(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(20, zza);
    }

    public final void zzf(String str, String str2, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzeo);
        zza(21, zza);
    }

    public final void zza(zzfr zzfr, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzfr);
        zzd.zza(zza, (IInterface) zzeo);
        zza(22, zza);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzd.zza(zza, (IInterface) zzeo);
        zza(23, zza);
    }

    public final void zza(String str, PhoneAuthCredential phoneAuthCredential, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzd.zza(zza, (IInterface) zzeo);
        zza(24, zza);
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) actionCodeSettings);
        zzd.zza(zza, (IInterface) zzeo);
        zza(25, zza);
    }

    public final void zzb(String str, ActionCodeSettings actionCodeSettings, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) actionCodeSettings);
        zzd.zza(zza, (IInterface) zzeo);
        zza(26, zza);
    }

    public final void zzk(String str, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzeo);
        zza(27, zza);
    }

    public final void zzc(String str, ActionCodeSettings actionCodeSettings, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) actionCodeSettings);
        zzd.zza(zza, (IInterface) zzeo);
        zza(28, zza);
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) emailAuthCredential);
        zzd.zza(zza, (IInterface) zzeo);
        zza(29, zza);
    }

    public final void zza(zzcn zzcn, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcn);
        zzd.zza(zza, (IInterface) zzeo);
        zza(101, zza);
    }

    public final void zza(zzdl zzdl, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdl);
        zzd.zza(zza, (IInterface) zzeo);
        zza(102, zza);
    }

    public final void zza(zzdj zzdj, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdj);
        zzd.zza(zza, (IInterface) zzeo);
        zza(103, zza);
    }

    public final void zza(zzed zzed, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzed);
        zzd.zza(zza, (IInterface) zzeo);
        zza(104, zza);
    }

    public final void zza(zzbx zzbx, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbx);
        zzd.zza(zza, (IInterface) zzeo);
        zza(105, zza);
    }

    public final void zza(zzbz zzbz, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbz);
        zzd.zza(zza, (IInterface) zzeo);
        zza(106, zza);
    }

    public final void zza(zzcf zzcf, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcf);
        zzd.zza(zza, (IInterface) zzeo);
        zza(107, zza);
    }

    public final void zza(zzdn zzdn, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdn);
        zzd.zza(zza, (IInterface) zzeo);
        zza(108, zza);
    }

    public final void zza(zzcp zzcp, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcp);
        zzd.zza(zza, (IInterface) zzeo);
        zza(109, zza);
    }

    public final void zza(zzcr zzcr, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcr);
        zzd.zza(zza, (IInterface) zzeo);
        zza(111, zza);
    }

    public final void zza(zzct zzct, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzct);
        zzd.zza(zza, (IInterface) zzeo);
        zza(112, zza);
    }

    public final void zza(zzdz zzdz, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdz);
        zzd.zza(zza, (IInterface) zzeo);
        zza(113, zza);
    }

    public final void zza(zzeb zzeb, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzeb);
        zzd.zza(zza, (IInterface) zzeo);
        zza(114, zza);
    }

    public final void zza(zzcx zzcx, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcx);
        zzd.zza(zza, (IInterface) zzeo);
        zza(115, zza);
    }

    public final void zza(zzdh zzdh, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdh);
        zzd.zza(zza, (IInterface) zzeo);
        zza(116, zza);
    }

    public final void zza(zzch zzch, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzch);
        zzd.zza(zza, (IInterface) zzeo);
        zza(117, zza);
    }

    public final void zza(zzcb zzcb, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcb);
        zzd.zza(zza, (IInterface) zzeo);
        zza(119, zza);
    }

    public final void zza(zzbw zzbw, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbw);
        zzd.zza(zza, (IInterface) zzeo);
        zza(120, zza);
    }

    public final void zza(zzcd zzcd, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcd);
        zzd.zza(zza, (IInterface) zzeo);
        zza(121, zza);
    }

    public final void zza(zzdd zzdd, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdd);
        zzd.zza(zza, (IInterface) zzeo);
        zza(122, zza);
    }

    public final void zza(zzdr zzdr, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdr);
        zzd.zza(zza, (IInterface) zzeo);
        zza(123, zza);
    }

    public final void zza(zzcv zzcv, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcv);
        zzd.zza(zza, (IInterface) zzeo);
        zza(124, zza);
    }

    public final void zza(zzcz zzcz, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcz);
        zzd.zza(zza, (IInterface) zzeo);
        zza(WebSocketProtocol.PAYLOAD_SHORT, zza);
    }

    public final void zza(zzdf zzdf, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdf);
        zzd.zza(zza, (IInterface) zzeo);
        zza(127, zza);
    }

    public final void zza(zzdb zzdb, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdb);
        zzd.zza(zza, (IInterface) zzeo);
        zza(128, zza);
    }

    public final void zza(zzdp zzdp, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdp);
        zzd.zza(zza, (IInterface) zzeo);
        zza(129, zza);
    }

    public final void zza(zzdt zzdt, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdt);
        zzd.zza(zza, (IInterface) zzeo);
        zza(130, zza);
    }

    public final void zza(zzdx zzdx, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdx);
        zzd.zza(zza, (IInterface) zzeo);
        zza(131, zza);
    }

    public final void zza(zzcj zzcj, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcj);
        zzd.zza(zza, (IInterface) zzeo);
        zza(132, zza);
    }

    public final void zza(zzdv zzdv, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdv);
        zzd.zza(zza, (IInterface) zzeo);
        zza(133, zza);
    }

    public final void zza(zzcl zzcl, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcl);
        zzd.zza(zza, (IInterface) zzeo);
        zza(134, zza);
    }

    public final void zza(zzef zzef, zzeo zzeo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzef);
        zzd.zza(zza, (IInterface) zzeo);
        zza(135, zza);
    }
}
