package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzel;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzeu extends AbstractSafeParcelable implements zzel<zzeu, zzp.zzg> {
    public static final Parcelable.Creator<zzeu> CREATOR = new zzex();
    private zzey zza;

    public zzeu() {
    }

    zzeu(zzey zzey) {
        zzey zzey2;
        if (zzey == null) {
            zzey2 = new zzey();
        } else {
            zzey2 = zzey.zza(zzey);
        }
        this.zza = zzey2;
    }

    public final List<zzew> zzb() {
        return this.zza.zza();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjx<zzp.zzg> zza() {
        return zzp.zzg.zzb();
    }

    public final /* synthetic */ zzel zza(zzjn zzjn) {
        if (zzjn instanceof zzp.zzg) {
            zzp.zzg zzg = (zzp.zzg) zzjn;
            if (zzg.zza() == 0) {
                this.zza = new zzey();
            } else {
                this.zza = zzey.zza(zzg);
            }
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of GetAccountInfoResponse.");
    }
}
