package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzem extends AbstractSafeParcelable implements zzel<zzem, zzp.zzb> {
    public static final Parcelable.Creator<zzem> CREATOR = new zzep();
    private String zza;
    private boolean zzb;
    private String zzc;
    private boolean zzd;
    private zzfw zze;
    private List<String> zzf;

    public zzem() {
        this.zze = zzfw.zzb();
    }

    public zzem(String str, boolean z, String str2, boolean z2, zzfw zzfw, List<String> list) {
        this.zza = str;
        this.zzb = z;
        this.zzc = str2;
        this.zzd = z2;
        this.zze = zzfw == null ? zzfw.zzb() : zzfw.zza(zzfw);
        this.zzf = list;
    }

    public final List<String> zzb() {
        return this.zzf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjx<zzp.zzb> zza() {
        return zzp.zzb.zzi();
    }

    public final /* synthetic */ zzel zza(zzjn zzjn) {
        zzfw zzfw;
        if (zzjn instanceof zzp.zzb) {
            zzp.zzb zzb2 = (zzp.zzb) zzjn;
            this.zza = Strings.emptyToNull(zzb2.zza());
            this.zzb = zzb2.zzd();
            this.zzc = Strings.emptyToNull(zzb2.zze());
            this.zzd = zzb2.zzf();
            if (zzb2.zzc() == 0) {
                zzfw = zzfw.zzb();
            } else {
                zzfw = new zzfw(1, new ArrayList(zzb2.zzb()));
            }
            this.zze = zzfw;
            this.zzf = zzb2.mo12375a_() == 0 ? new ArrayList<>(0) : zzb2.zzg();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of CreateAuthUriResponse.");
    }
}
