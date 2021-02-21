package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzjn;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public abstract class zzgo<MessageType extends zzjn> implements zzjx<MessageType> {
    private static final zzhs zza = zzhs.zza();

    private final MessageType zzb(InputStream inputStream, zzhs zzhs) throws zzin {
        zzhh zzhh;
        if (inputStream == null) {
            byte[] bArr = zzii.zzb;
            zzhh = zzhh.zza(bArr, 0, bArr.length, false);
        } else {
            zzhh = new zzhi(inputStream);
        }
        MessageType messagetype = (zzjn) zza(zzhh, zzhs);
        try {
            zzhh.zza(0);
            return messagetype;
        } catch (zzin e) {
            throw e.zza(messagetype);
        }
    }

    public final /* synthetic */ Object zza(InputStream inputStream, zzhs zzhs) throws zzin {
        zzkx zzkx;
        zzjn zzb = zzb(inputStream, zzhs);
        if (zzb == null || zzb.mo12167b_()) {
            return zzb;
        }
        if (zzb instanceof zzgn) {
            zzkx = new zzkx((zzgn) zzb);
        } else if (zzb instanceof zzgp) {
            zzkx = new zzkx((zzgp) zzb);
        } else {
            zzkx = new zzkx(zzb);
        }
        throw new zzin(zzkx.getMessage()).zza(zzb);
    }
}
