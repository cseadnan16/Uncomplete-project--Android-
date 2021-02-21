package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzc;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzh implements AuthResult {
    public static final Parcelable.Creator<zzh> CREATOR = new zzk();
    private zzn zza;
    private zzf zzb;
    private zzc zzc;

    zzh(zzn zzn, zzf zzf, zzc zzc2) {
        this.zza = zzn;
        this.zzb = zzf;
        this.zzc = zzc2;
    }

    public zzh(zzn zzn) {
        zzn zzn2 = (zzn) Preconditions.checkNotNull(zzn);
        this.zza = zzn2;
        List<zzj> zzh = zzn2.zzh();
        this.zzb = null;
        for (int i = 0; i < zzh.size(); i++) {
            if (!TextUtils.isEmpty(zzh.get(i).zza())) {
                this.zzb = new zzf(zzh.get(i).getProviderId(), zzh.get(i).zza(), zzn.zzi());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzf(zzn.zzi());
        }
        this.zzc = zzn.zzj();
    }

    public final FirebaseUser getUser() {
        return this.zza;
    }

    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    public final AuthCredential getCredential() {
        return this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int describeContents() {
        return 0;
    }
}
