package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzhv<T extends zzhx<T>> {
    private static final zzhv zzd = new zzhv(true);
    final zzki<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzhv() {
        this.zza = zzki.zza(16);
    }

    private zzhv(boolean z) {
        this(zzki.zza(0));
        zzb();
    }

    private zzhv(zzki<T, Object> zzki) {
        this.zza = zzki;
        zzb();
    }

    public static <T extends zzhx<T>> zzhv<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhv)) {
            return false;
        }
        return this.zza.equals(((zzhv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzit(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzit(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzis)) {
            return obj;
        }
        zzis zzis = (zzis) obj;
        return zzis.zza();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzis) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private static void zza(zzlm zzlm, Object obj) {
        zzii.zza(obj);
        boolean z = true;
        switch (zzhy.zza[zzlm.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzgv) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzih)) {
                    z = false;
                    break;
                }
            case 9:
                if (!(obj instanceof zzjn) && !(obj instanceof zzis)) {
                    z = false;
                    break;
                }
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzd()) {
            if (!zza(zza2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzhx<T>> boolean zza(Map.Entry<T, Object> entry) {
        zzhx zzhx = (zzhx) entry.getKey();
        if (zzhx.zzc() == zzlt.MESSAGE) {
            if (zzhx.zzd()) {
                for (zzjn b_ : (List) entry.getValue()) {
                    if (!b_.mo12167b_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjn) {
                    if (!((zzjn) value).mo12167b_()) {
                        return false;
                    }
                } else if (value instanceof zzis) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzhv<T> zzhv) {
        for (int i = 0; i < zzhv.zza.zzc(); i++) {
            zzb(zzhv.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzhv.zza.zzd()) {
            zzb(zzb2);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzjt) {
            return ((zzjt) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzhx zzhx = (zzhx) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzis) {
            zzis zzis = (zzis) value;
            value = zzis.zza();
        }
        if (zzhx.zzd()) {
            Object zza2 = zza(zzhx);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzhx, zza2);
        } else if (zzhx.zzc() == zzlt.MESSAGE) {
            Object zza4 = zza(zzhx);
            if (zza4 == null) {
                this.zza.put(zzhx, zza(value));
                return;
            }
            if (zza4 instanceof zzjt) {
                obj = zzhx.zza((zzjt) zza4, (zzjt) value);
            } else {
                obj = zzhx.zza(((zzjn) zza4).zzad(), (zzjn) value).zzg();
            }
            this.zza.put(zzhx, obj);
        } else {
            this.zza.put(zzhx, zza(value));
        }
    }

    static void zza(zzhm zzhm, zzlm zzlm, int i, Object obj) throws IOException {
        if (zzlm == zzlm.GROUP) {
            zzjn zzjn = (zzjn) obj;
            zzii.zza(zzjn);
            zzhm.zza(i, 3);
            zzjn.zza(zzhm);
            zzhm.zza(i, 4);
            return;
        }
        zzhm.zza(i, zzlm.zzb());
        switch (zzhy.zzb[zzlm.ordinal()]) {
            case 1:
                zzhm.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzhm.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzhm.zza(((Long) obj).longValue());
                return;
            case 4:
                zzhm.zza(((Long) obj).longValue());
                return;
            case 5:
                zzhm.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzhm.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzhm.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzhm.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzjn) obj).zza(zzhm);
                return;
            case 10:
                zzhm.zza((zzjn) obj);
                return;
            case 11:
                if (obj instanceof zzgv) {
                    zzhm.zza((zzgv) obj);
                    return;
                } else {
                    zzhm.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzgv) {
                    zzhm.zza((zzgv) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhm.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzhm.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzhm.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzhm.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzhm.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzhm.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzih) {
                    zzhm.zza(((zzih) obj).zza());
                    return;
                } else {
                    zzhm.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        zzhx zzhx = (zzhx) entry.getKey();
        Object value = entry.getValue();
        if (zzhx.zzc() != zzlt.MESSAGE || zzhx.zzd() || zzhx.zze()) {
            return zza((zzhx<?>) zzhx, value);
        }
        if (value instanceof zzis) {
            return zzhm.zzb(((zzhx) entry.getKey()).zza(), (zziw) (zzis) value);
        }
        return zzhm.zzb(((zzhx) entry.getKey()).zza(), (zzjn) value);
    }

    static int zza(zzlm zzlm, int i, Object obj) {
        int zze = zzhm.zze(i);
        if (zzlm == zzlm.GROUP) {
            zzii.zza((zzjn) obj);
            zze <<= 1;
        }
        return zze + zzb(zzlm, obj);
    }

    private static int zzb(zzlm zzlm, Object obj) {
        switch (zzhy.zzb[zzlm.ordinal()]) {
            case 1:
                return zzhm.zzb(((Double) obj).doubleValue());
            case 2:
                return zzhm.zzb(((Float) obj).floatValue());
            case 3:
                return zzhm.zzd(((Long) obj).longValue());
            case 4:
                return zzhm.zze(((Long) obj).longValue());
            case 5:
                return zzhm.zzf(((Integer) obj).intValue());
            case 6:
                return zzhm.zzg(((Long) obj).longValue());
            case 7:
                return zzhm.zzi(((Integer) obj).intValue());
            case 8:
                return zzhm.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzhm.zzc((zzjn) obj);
            case 10:
                if (obj instanceof zzis) {
                    return zzhm.zza((zziw) (zzis) obj);
                }
                return zzhm.zzb((zzjn) obj);
            case 11:
                if (obj instanceof zzgv) {
                    return zzhm.zzb((zzgv) obj);
                }
                return zzhm.zzb((String) obj);
            case 12:
                if (obj instanceof zzgv) {
                    return zzhm.zzb((zzgv) obj);
                }
                return zzhm.zzb((byte[]) obj);
            case 13:
                return zzhm.zzg(((Integer) obj).intValue());
            case 14:
                return zzhm.zzj(((Integer) obj).intValue());
            case 15:
                return zzhm.zzh(((Long) obj).longValue());
            case 16:
                return zzhm.zzh(((Integer) obj).intValue());
            case 17:
                return zzhm.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzih) {
                    return zzhm.zzk(((zzih) obj).zza());
                }
                return zzhm.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzhx<?> zzhx, Object obj) {
        zzlm zzb2 = zzhx.zzb();
        int zza2 = zzhx.zza();
        if (!zzhx.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzhx.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzhm.zze(zza2) + i + zzhm.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhv zzhv = new zzhv();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzhv.zzb((zzhx) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzhv.zzb((zzhx) next.getKey(), next.getValue());
        }
        zzhv.zzc = this.zzc;
        return zzhv;
    }
}
