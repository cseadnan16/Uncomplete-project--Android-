package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public class FacebookAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzg();
    private final String zza;

    FacebookAuthCredential(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public String getProvider() {
        return "facebook.com";
    }

    public String getSignInMethod() {
        return "facebook.com";
    }

    public static zzfy zza(FacebookAuthCredential facebookAuthCredential, String str) {
        Preconditions.checkNotNull(facebookAuthCredential);
        return new zzfy((String) null, facebookAuthCredential.zza, facebookAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    public final AuthCredential zza() {
        return new FacebookAuthCredential(this.zza);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
