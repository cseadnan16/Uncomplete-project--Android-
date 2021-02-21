package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public class zzhs {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzhs zzc;
    private static volatile zzhs zzd;
    private static final zzhs zze = new zzhs(true);
    private final Map<zza, zzif.zzd<?, ?>> zzf;

    public static zzhs zza() {
        zzhs zzhs = zzc;
        if (zzhs == null) {
            synchronized (zzhs.class) {
                zzhs = zzc;
                if (zzhs == null) {
                    zzhs = zze;
                    zzc = zzhs;
                }
            }
        }
        return zzhs;
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            if (this.zza == zza2.zza && this.zzb == zza2.zzb) {
                return true;
            }
            return false;
        }
    }

    public static zzhs zzb() {
        Class<zzhs> cls = zzhs.class;
        zzhs zzhs = zzd;
        if (zzhs != null) {
            return zzhs;
        }
        synchronized (cls) {
            zzhs zzhs2 = zzd;
            if (zzhs2 != null) {
                return zzhs2;
            }
            zzhs zza2 = zzie.zza(cls);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzjn> zzif.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzf.get(new zza(containingtype, i));
    }

    zzhs() {
        this.zzf = new HashMap();
    }

    private zzhs(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
