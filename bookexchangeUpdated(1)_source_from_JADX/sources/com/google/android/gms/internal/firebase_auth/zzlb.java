package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzlb extends zzkz<zzky, zzky> {
    zzlb() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzke zzke) {
        return false;
    }

    private static void zza(Object obj, zzky zzky) {
        ((zzif) obj).zzb = zzky;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        ((zzif) obj).zzb.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzf(Object obj) {
        return ((zzky) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zze(Object obj) {
        return ((zzky) obj).zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzky zzky = (zzky) obj;
        zzky zzky2 = (zzky) obj2;
        if (zzky2.equals(zzky.zza())) {
            return zzky;
        }
        return zzky.zza(zzky, zzky2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, zzls zzls) throws IOException {
        ((zzky) obj).zza(zzls);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzls zzls) throws IOException {
        ((zzky) obj).zzb(zzls);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzky) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzky zzky = ((zzif) obj).zzb;
        if (zzky != zzky.zza()) {
            return zzky;
        }
        zzky zzb = zzky.zzb();
        zza(obj, zzb);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzif) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzky) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        zzky zzky = (zzky) obj;
        zzky.zzc();
        return zzky;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza() {
        return zzky.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzky) obj).zza((i << 3) | 3, (Object) (zzky) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzgv zzgv) {
        ((zzky) obj).zza((i << 3) | 2, (Object) zzgv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzky) obj).zza((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzky) obj).zza((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzky) obj).zza(i << 3, (Object) Long.valueOf(j));
    }
}
