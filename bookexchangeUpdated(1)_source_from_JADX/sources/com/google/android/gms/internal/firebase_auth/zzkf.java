package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzkf {
    private static final Class<?> zza = zzd();
    private static final zzkz<?, ?> zzb = zza(false);
    private static final zzkz<?, ?> zzc = zza(true);
    private static final zzkz<?, ?> zzd = new zzlb();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzif.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzls zzls, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzls zzls) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzgv> list, zzls zzls) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzls zzls, zzkd zzkd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zza(i, list, zzkd);
        }
    }

    public static void zzb(int i, List<?> list, zzls zzls, zzkd zzkd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzls.zzb(i, list, zzkd);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            i = 0;
            while (i2 < size) {
                i += zzhm.zzd(zzjb.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhm.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzhm.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            i = 0;
            while (i2 < size) {
                i += zzhm.zze(zzjb.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhm.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzhm.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            i = 0;
            while (i2 < size) {
                i += zzhm.zzf(zzjb.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhm.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzhm.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzig) {
            zzig zzig = (zzig) list;
            i = 0;
            while (i2 < size) {
                i += zzhm.zzk(zzig.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhm.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzhm.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzig) {
            zzig zzig = (zzig) list;
            i = 0;
            while (i2 < size) {
                i += zzhm.zzf(zzig.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhm.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzhm.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzig) {
            zzig zzig = (zzig) list;
            i = 0;
            while (i2 < size) {
                i += zzhm.zzg(zzig.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhm.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzhm.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzig) {
            zzig zzig = (zzig) list;
            i = 0;
            while (i2 < size) {
                i += zzhm.zzh(zzig.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhm.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzhm.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhm.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhm.zzg(i, 0);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhm.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzhm.zze(i) * size;
        if (list instanceof zziy) {
            zziy zziy = (zziy) list;
            while (i4 < size) {
                Object zzb2 = zziy.zzb(i4);
                if (zzb2 instanceof zzgv) {
                    i3 = zzhm.zzb((zzgv) zzb2);
                } else {
                    i3 = zzhm.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgv) {
                    i2 = zzhm.zzb((zzgv) obj);
                } else {
                    i2 = zzhm.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    static int zza(int i, Object obj, zzkd zzkd) {
        if (obj instanceof zziw) {
            return zzhm.zza(i, (zziw) obj);
        }
        return zzhm.zzb(i, (zzjn) obj, zzkd);
    }

    static int zza(int i, List<?> list, zzkd zzkd) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhm.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zziw) {
                i2 = zzhm.zza((zziw) obj);
            } else {
                i2 = zzhm.zza((zzjn) obj, zzkd);
            }
            zze += i2;
        }
        return zze;
    }

    static int zzb(int i, List<zzgv> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzhm.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzhm.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzjn> list, zzkd zzkd) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzhm.zzc(i, list.get(i3), zzkd);
        }
        return i2;
    }

    public static zzkz<?, ?> zza() {
        return zzb;
    }

    public static zzkz<?, ?> zzb() {
        return zzc;
    }

    public static zzkz<?, ?> zzc() {
        return zzd;
    }

    private static zzkz<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzkz) zze.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzjk zzjk, T t, T t2, long j) {
        zzlf.zza((Object) t, j, zzjk.zza(zzlf.zzf(t, j), zzlf.zzf(t2, j)));
    }

    static <T, FT extends zzhx<FT>> void zza(zzhu<FT> zzhu, T t, T t2) {
        zzhv<FT> zza2 = zzhu.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzhu.zzb(t).zza(zza2);
        }
    }

    static <T, UT, UB> void zza(zzkz<UT, UB> zzkz, T t, T t2) {
        zzkz.zza((Object) t, zzkz.zzc(zzkz.zzb(t), zzkz.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzij zzij, UB ub, zzkz<UT, UB> zzkz) {
        if (zzij == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzij.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzkz);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzij.zza(intValue2)) {
                    ub = zza(i, intValue2, ub, zzkz);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzkz<UT, UB> zzkz) {
        if (ub == null) {
            ub = zzkz.zza();
        }
        zzkz.zza(ub, i, (long) i2);
        return ub;
    }
}
