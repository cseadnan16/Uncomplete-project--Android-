package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzje implements zzkg {
    private static final zzjo zzb = new zzjd();
    private final zzjo zza;

    public zzje() {
        this(new zzjg(zzid.zza(), zza()));
    }

    private zzje(zzjo zzjo) {
        this.zza = (zzjo) zzii.zza(zzjo, "messageInfoFactory");
    }

    public final <T> zzkd<T> zza(Class<T> cls) {
        zzkf.zza((Class<?>) cls);
        zzjl zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzif.class.isAssignableFrom(cls)) {
                return zzju.zza(zzkf.zzc(), zzhw.zza(), zzb2.zzc());
            }
            return zzju.zza(zzkf.zza(), zzhw.zzb(), zzb2.zzc());
        } else if (zzif.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzjr.zza(cls, zzb2, zzjy.zzb(), zzix.zzb(), zzkf.zzc(), zzhw.zza(), zzjm.zzb());
            }
            return zzjr.zza(cls, zzb2, zzjy.zzb(), zzix.zzb(), zzkf.zzc(), (zzhu<?>) null, zzjm.zzb());
        } else if (zza(zzb2)) {
            return zzjr.zza(cls, zzb2, zzjy.zza(), zzix.zza(), zzkf.zza(), zzhw.zzb(), zzjm.zza());
        } else {
            return zzjr.zza(cls, zzb2, zzjy.zza(), zzix.zza(), zzkf.zzb(), (zzhu<?>) null, zzjm.zza());
        }
    }

    private static boolean zza(zzjl zzjl) {
        return zzjl.zza() == zzif.zzf.zzh;
    }

    private static zzjo zza() {
        try {
            return (zzjo) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            return zzb;
        }
    }
}
