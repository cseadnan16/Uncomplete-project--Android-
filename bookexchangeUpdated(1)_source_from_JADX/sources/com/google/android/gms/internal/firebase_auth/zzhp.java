package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzhp implements zzls {
    private final zzhm zza;

    public static zzhp zza(zzhm zzhm) {
        if (zzhm.zza != null) {
            return zzhm.zza;
        }
        return new zzhp(zzhm);
    }

    private zzhp(zzhm zzhm) {
        zzhm zzhm2 = (zzhm) zzii.zza(zzhm, "output");
        this.zza = zzhm2;
        zzhm2.zza = this;
    }

    public final int zza() {
        return zzif.zzf.zzj;
    }

    public final void zza(int i, int i2) throws IOException {
        this.zza.zze(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zza.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zza.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zza.zza(i, d);
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzc(i, j);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zza.zze(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zza.zza(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zza.zza(i, str);
    }

    public final void zza(int i, zzgv zzgv) throws IOException {
        this.zza.zza(i, zzgv);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zze(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzkd zzkd) throws IOException {
        this.zza.zza(i, (zzjn) obj, zzkd);
    }

    public final void zzb(int i, Object obj, zzkd zzkd) throws IOException {
        zzhm zzhm = this.zza;
        zzhm.zza(i, 3);
        zzkd.zza((zzjn) obj, (zzls) zzhm.zza);
        zzhm.zza(i, 4);
    }

    public final void zza(int i) throws IOException {
        this.zza.zza(i, 3);
    }

    public final void zzb(int i) throws IOException {
        this.zza.zza(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzgv) {
            this.zza.zzb(i, (zzgv) obj);
        } else {
            this.zza.zza(i, (zzjn) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzf(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzi(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzd(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zze(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzg(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzb(list.get(i4).floatValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzb(list.get(i4).doubleValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzk(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzb(list.get(i4).booleanValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zziy) {
            zziy zziy = (zziy) list;
            while (i2 < list.size()) {
                Object zzb = zziy.zzb(i2);
                if (zzb instanceof String) {
                    this.zza.zza(i, (String) zzb);
                } else {
                    this.zza.zza(i, (zzgv) zzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzgv> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzg(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzj(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzh(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzh(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhm.zzf(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzkd zzkd) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzkd);
        }
    }

    public final void zzb(int i, List<?> list, zzkd zzkd) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzkd);
        }
    }

    public final <K, V> void zza(int i, zzji<K, V> zzji, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zza.zza(i, 2);
            this.zza.zzb(zzjf.zza(zzji, next.getKey(), next.getValue()));
            zzjf.zza(this.zza, zzji, next.getKey(), next.getValue());
        }
    }
}
