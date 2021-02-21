package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzeu extends zzao implements Api.ApiOptions.HasOptions {
    private final String zzb;

    private zzeu(String str) {
        this.zzb = Preconditions.checkNotEmpty(str, "A valid API key must be provided");
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeu)) {
            return false;
        }
        return Objects.equal(this.zzb, ((zzeu) obj).zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public final /* synthetic */ zzao zza() {
        return (zzeu) clone();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new zzex(this.zzb).zza();
    }

    /* synthetic */ zzeu(String str, zzev zzev) {
        this(str);
    }
}
