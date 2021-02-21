package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zzc;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzt extends MultiFactorResolver {
    public static final Parcelable.Creator<zzt> CREATOR = new zzv();
    private final List<PhoneMultiFactorInfo> zza = new ArrayList();
    private final zzy zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zzc zzd;
    private final zzn zze;

    public zzt(List<PhoneMultiFactorInfo> list, zzy zzy, String str, zzc zzc2, zzn zzn) {
        for (MultiFactorInfo next : list) {
            if (next instanceof PhoneMultiFactorInfo) {
                this.zza.add((PhoneMultiFactorInfo) next);
            }
        }
        this.zzb = (zzy) Preconditions.checkNotNull(zzy);
        this.zzc = Preconditions.checkNotEmpty(str);
        this.zzd = zzc2;
        this.zze = zzn;
    }

    public static zzt zza(zzej zzej, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        List<MultiFactorInfo> zzc2 = zzej.zzc();
        ArrayList arrayList = new ArrayList();
        for (MultiFactorInfo next : zzc2) {
            if (next instanceof PhoneMultiFactorInfo) {
                arrayList.add((PhoneMultiFactorInfo) next);
            }
        }
        return new zzt(arrayList, zzy.zza(zzej.zzc(), zzej.zza()), firebaseAuth.zzb().getName(), zzej.zzb(), (zzn) firebaseUser);
    }

    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo add : this.zza) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return getFirebaseAuth().zza(multiFactorAssertion, this.zzb, (FirebaseUser) this.zze).continueWithTask(new zzw(this));
    }

    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getSession(), i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
