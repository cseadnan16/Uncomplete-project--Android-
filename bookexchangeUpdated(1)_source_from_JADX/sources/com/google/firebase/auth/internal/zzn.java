package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zzc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public class zzn extends FirebaseUser {
    public static final Parcelable.Creator<zzn> CREATOR = new zzq();
    private zzff zza;
    private zzj zzb;
    private String zzc;
    private String zzd;
    private List<zzj> zze;
    private List<String> zzf;
    private String zzg;
    private Boolean zzh;
    private zzp zzi;
    private boolean zzj;
    private zzc zzk;
    private zzas zzl;

    zzn(zzff zzff, zzj zzj2, String str, String str2, List<zzj> list, List<String> list2, String str3, Boolean bool, zzp zzp, boolean z, zzc zzc2, zzas zzas) {
        this.zza = zzff;
        this.zzb = zzj2;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzp;
        this.zzj = z;
        this.zzk = zzc2;
        this.zzl = zzas;
    }

    public zzn(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = ExifInterface.GPS_MEASUREMENT_2D;
        zza(list);
    }

    public String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    public Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    public String getEmail() {
        return this.zzb.getEmail();
    }

    public String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    public final String zzd() {
        Map map;
        zzff zzff = this.zza;
        if (zzff == null || zzff.zzd() == null || (map = (Map) zzar.zza(this.zza.zzd()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID)) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    public final zzn zza(String str) {
        this.zzg = str;
        return this;
    }

    public String getProviderId() {
        return this.zzb.getProviderId();
    }

    public final FirebaseApp zzc() {
        return FirebaseApp.getInstance(this.zzc);
    }

    public final List<zzj> zzh() {
        return this.zze;
    }

    public String getUid() {
        return this.zzb.getUid();
    }

    public boolean isAnonymous() {
        GetTokenResult zza2;
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzff zzff = this.zza;
            String str = "";
            if (!(zzff == null || (zza2 = zzar.zza(zzff.zzd())) == null)) {
                str = zza2.getSignInProvider();
            }
            boolean z = true;
            if (getProviderData().size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    public final List<String> zza() {
        return this.zzf;
    }

    public final FirebaseUser zza(List<? extends UserInfo> list) {
        Preconditions.checkNotNull(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzb = (zzj) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzj) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = this.zze.get(0);
        }
        return this;
    }

    public List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    public final zzff zze() {
        return this.zza;
    }

    public final String zzg() {
        return zze().zzd();
    }

    public final String zzf() {
        return this.zza.zzh();
    }

    public final void zza(zzff zzff) {
        this.zza = (zzff) Preconditions.checkNotNull(zzff);
    }

    public boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    public final void zza(zzp zzp) {
        this.zzi = zzp;
    }

    public FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    public final void zza(boolean z) {
        this.zzj = z;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final void zza(zzc zzc2) {
        this.zzk = zzc2;
    }

    public final zzc zzj() {
        return this.zzk;
    }

    public final void zzb(List<MultiFactorInfo> list) {
        this.zzl = zzas.zza(list);
    }

    public final List<MultiFactorInfo> zzk() {
        zzas zzas = this.zzl;
        if (zzas != null) {
            return zzas.zza();
        }
        return zzbg.zza();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zze(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 6, zza(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, getMetadata(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static FirebaseUser zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzn zzn = new zzn(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzn) {
            zzn zzn2 = (zzn) firebaseUser;
            zzn.zzg = zzn2.zzg;
            zzn.zzd = zzn2.zzd;
            zzn.zzi = (zzp) zzn2.getMetadata();
        } else {
            zzn.zzi = null;
        }
        if (firebaseUser.zze() != null) {
            zzn.zza(firebaseUser.zze());
        }
        if (!firebaseUser.isAnonymous()) {
            zzn.zzb();
        }
        return zzn;
    }

    public /* synthetic */ MultiFactor getMultiFactor() {
        return new zzr(this);
    }

    public final /* synthetic */ FirebaseUser zzb() {
        this.zzh = false;
        return this;
    }
}
