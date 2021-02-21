package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzct extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzct> CREATOR = new zzcw();
    private final String zza;
    private final zzfy zzb;

    public zzct(String str, zzfy zzfy) {
        this.zza = str;
        this.zzb = zzfy;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzfy zzb() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
