package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzau {
    /* access modifiers changed from: private */
    public final zzaf zza;
    private final boolean zzb;
    private final zzba zzc;
    /* access modifiers changed from: private */
    public final int zzd;

    private zzau(zzba zzba) {
        this(zzba, false, zzaj.zza, Integer.MAX_VALUE);
    }

    private zzau(zzba zzba, boolean z, zzaf zzaf, int i) {
        this.zzc = zzba;
        this.zzb = false;
        this.zza = zzaf;
        this.zzd = Integer.MAX_VALUE;
    }

    public static zzau zza(char c) {
        zzah zzah = new zzah('.');
        zzav.zza(zzah);
        return new zzau(new zzax(zzah));
    }

    public static zzau zza(String str) {
        zzal zza2 = zzar.zza(str);
        if (!zza2.zza("").zza()) {
            return new zzau(new zzaz(zza2));
        }
        throw new IllegalArgumentException(zzbd.zza("The pattern may not match the empty string: %s", zza2));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzav.zza(charSequence);
        Iterator<String> zza2 = this.zzc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza2.hasNext()) {
            arrayList.add(zza2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
