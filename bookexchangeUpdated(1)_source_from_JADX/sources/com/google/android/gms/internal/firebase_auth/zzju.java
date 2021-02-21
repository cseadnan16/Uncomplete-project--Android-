package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzju<T> implements zzkd<T> {
    private final zzjn zza;
    private final zzkz<?, ?> zzb;
    private final boolean zzc;
    private final zzhu<?> zzd;

    private zzju(zzkz<?, ?> zzkz, zzhu<?> zzhu, zzjn zzjn) {
        this.zzb = zzkz;
        this.zzc = zzhu.zza(zzjn);
        this.zzd = zzhu;
        this.zza = zzjn;
    }

    static <T> zzju<T> zza(zzkz<?, ?> zzkz, zzhu<?> zzhu, zzjn zzjn) {
        return new zzju<>(zzkz, zzhu, zzjn);
    }

    public final T zza() {
        return this.zza.zzae().zzf();
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        if (this.zzc) {
            return (hashCode * 53) + this.zzd.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    public final void zzb(T t, T t2) {
        zzkf.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzkf.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzls zzls) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzhx zzhx = (zzhx) next.getKey();
            if (zzhx.zzc() != zzlt.MESSAGE || zzhx.zzd() || zzhx.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zziu) {
                zzls.zza(zzhx.zza(), (Object) ((zziu) next).zza().zzc());
            } else {
                zzls.zza(zzhx.zza(), next.getValue());
            }
        }
        zzkz<?, ?> zzkz = this.zzb;
        zzkz.zzb(zzkz.zzb(t), zzls);
    }

    public final void zza(T t, zzke zzke, zzhs zzhs) throws IOException {
        boolean z;
        zzkz<?, ?> zzkz = this.zzb;
        zzhu<?> zzhu = this.zzd;
        Object zzc2 = zzkz.zzc(t);
        zzhv<?> zzb2 = zzhu.zzb(t);
        do {
            try {
                if (zzke.zza() == Integer.MAX_VALUE) {
                    zzkz.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzke.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgv zzgv = null;
                    while (zzke.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzke.zzb();
                        if (zzb4 == 16) {
                            i = zzke.zzo();
                            obj = zzhu.zza(zzhs, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhu.zza(zzke, obj, zzhs, zzb2);
                            } else {
                                zzgv = zzke.zzn();
                            }
                        } else if (!zzke.zzc()) {
                            break;
                        }
                    }
                    if (zzke.zzb() != 12) {
                        throw zzin.zze();
                    } else if (zzgv != null) {
                        if (obj != null) {
                            zzhu.zza(zzgv, obj, zzhs, zzb2);
                        } else {
                            zzkz.zza(zzc2, i, zzgv);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhu.zza(zzhs, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhu.zza(zzke, zza2, zzhs, zzb2);
                    } else {
                        z = zzkz.zza(zzc2, zzke);
                        continue;
                    }
                } else {
                    z = zzke.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzkz.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    public final int zzb(T t) {
        zzkz<?, ?> zzkz = this.zzb;
        int zze = zzkz.zze(zzkz.zzb(t)) + 0;
        if (this.zzc) {
            return zze + this.zzd.zza((Object) t).zzg();
        }
        return zze;
    }
}
