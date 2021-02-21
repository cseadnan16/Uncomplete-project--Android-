package com.google.android.gms.internal.firebase_auth;

import java.io.Serializable;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzan extends zzal implements Serializable {
    private final Pattern zza;

    zzan(Pattern pattern) {
        this.zza = (Pattern) zzav.zza(pattern);
    }

    public final zzam zza(CharSequence charSequence) {
        return new zzaq(this.zza.matcher(charSequence));
    }

    public final String toString() {
        return this.zza.toString();
    }
}
