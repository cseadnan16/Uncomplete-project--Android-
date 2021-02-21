package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzf implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzf> CREATOR = new zzi();
    private final String zza;
    private final String zzb;
    private Map<String, Object> zzc;
    private boolean zzd;

    public zzf(String str, String str2, boolean z) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzaq.zzb(str2);
        this.zzd = z;
    }

    public zzf(boolean z) {
        this.zzd = z;
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }

    @Nullable
    public final String getProviderId() {
        return this.zza;
    }

    @Nullable
    public final Map<String, Object> getProfile() {
        return this.zzc;
    }

    @Nullable
    public final String getUsername() {
        if ("github.com".equals(this.zza)) {
            return (String) this.zzc.get(FirebaseAnalytics.Event.LOGIN);
        }
        if ("twitter.com".equals(this.zza)) {
            return (String) this.zzc.get("screen_name");
        }
        return null;
    }

    public final boolean isNewUser() {
        return this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, isNewUser());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int describeContents() {
        return 0;
    }
}
