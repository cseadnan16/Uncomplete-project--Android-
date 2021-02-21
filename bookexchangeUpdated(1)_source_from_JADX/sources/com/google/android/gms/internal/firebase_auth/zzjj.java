package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzjj implements zzjk {
    zzjj() {
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzjh) obj;
    }

    public final zzji<?, ?> zzb(Object obj) {
        zzjf zzjf = (zzjf) obj;
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzc(Object obj) {
        return (zzjh) obj;
    }

    public final boolean zzd(Object obj) {
        return !((zzjh) obj).zzd();
    }

    public final Object zze(Object obj) {
        ((zzjh) obj).zzc();
        return obj;
    }

    public final Object zzf(Object obj) {
        return zzjh.zza().zzb();
    }

    public final Object zza(Object obj, Object obj2) {
        zzjh zzjh = (zzjh) obj;
        zzjh zzjh2 = (zzjh) obj2;
        if (!zzjh2.isEmpty()) {
            if (!zzjh.zzd()) {
                zzjh = zzjh.zzb();
            }
            zzjh.zza(zzjh2);
        }
        return zzjh;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzjh zzjh = (zzjh) obj;
        zzjf zzjf = (zzjf) obj2;
        if (zzjh.isEmpty()) {
            return 0;
        }
        Iterator it = zzjh.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
