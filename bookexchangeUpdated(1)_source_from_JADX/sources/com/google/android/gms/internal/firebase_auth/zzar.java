package com.google.android.gms.internal.firebase_auth;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzar {
    private static final Logger zza = Logger.getLogger(zzar.class.getName());
    private static final zzas zzb = new zza();

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    static final class zza implements zzas {
        private zza() {
        }

        public final zzal zza(String str) {
            return new zzan(Pattern.compile(str));
        }
    }

    private zzar() {
    }

    static zzal zza(String str) {
        zzav.zza(str);
        return zzb.zza(str);
    }
}
