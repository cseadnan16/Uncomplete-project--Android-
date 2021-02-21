package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzfh;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzat {
    public static MultiFactorInfo zza(zzfh zzfh) {
        if (zzfh != null && !TextUtils.isEmpty(zzfh.zza())) {
            return new PhoneMultiFactorInfo(zzfh.zzb(), zzfh.zzc(), zzfh.zzd(), zzfh.zza());
        }
        return null;
    }

    public static List<MultiFactorInfo> zza(List<zzfh> list) {
        if (list == null || list.isEmpty()) {
            return zzbg.zza();
        }
        ArrayList arrayList = new ArrayList();
        for (zzfh zza : list) {
            MultiFactorInfo zza2 = zza(zza);
            if (zza2 != null) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }
}
