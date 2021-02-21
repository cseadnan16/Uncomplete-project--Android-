package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.zzc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzey> CREATOR = new zzfb();
    private List<zzew> zza;

    public zzey() {
        this.zza = new ArrayList();
    }

    zzey(List<zzew> list) {
        List<zzew> list2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zza = list2;
    }

    public final List<zzew> zza() {
        return this.zza;
    }

    public static zzey zza(zzey zzey) {
        Preconditions.checkNotNull(zzey);
        List<zzew> list = zzey.zza;
        zzey zzey2 = new zzey();
        if (list != null && !list.isEmpty()) {
            zzey2.zza.addAll(list);
        }
        return zzey2;
    }

    public static zzey zza(zzp.zzg zzg) {
        ArrayList arrayList = new ArrayList(zzg.zza());
        for (int i = 0; i < zzg.zza(); i++) {
            zzz zza2 = zzg.zza(i);
            zzew zzew = r4;
            zzew zzew2 = new zzew(Strings.emptyToNull(zza2.zza()), Strings.emptyToNull(zza2.zzb()), zza2.zze(), Strings.emptyToNull(zza2.zzc()), Strings.emptyToNull(zza2.zzd()), zzfl.zza(zza2.zzf()), Strings.emptyToNull(zza2.zzi()), Strings.emptyToNull(zza2.zzj()), zza2.zzh(), zza2.zzg(), false, (zzc) null, zzfh.zza(zza2.zzk()));
            arrayList.add(zzew);
        }
        return new zzey(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
