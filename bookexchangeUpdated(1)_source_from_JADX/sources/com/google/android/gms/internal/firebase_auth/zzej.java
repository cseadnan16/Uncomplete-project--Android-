package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.internal.zzat;
import com.google.firebase.auth.zzc;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzej extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzej> CREATOR = new zzel();
    private String zza;
    private List<zzfh> zzb;
    private zzc zzc;

    public zzej(String str, List<zzfh> list, zzc zzc2) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzc2;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzc zzb() {
        return this.zzc;
    }

    public final List<MultiFactorInfo> zzc() {
        return zzat.zza(this.zzb);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
