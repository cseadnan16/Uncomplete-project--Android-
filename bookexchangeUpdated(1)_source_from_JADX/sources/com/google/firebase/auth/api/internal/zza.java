package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzen;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzer;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzeu;
import com.google.android.gms.internal.firebase_auth.zzev;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzfa;
import com.google.android.gms.internal.firebase_auth.zzfc;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.android.gms.internal.firebase_auth.zzfn;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.android.gms.internal.firebase_auth.zzft;
import com.google.android.gms.internal.firebase_auth.zzfu;
import com.google.android.gms.internal.firebase_auth.zzfv;
import com.google.android.gms.internal.firebase_auth.zzfx;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.internal.firebase_auth.zzga;
import com.google.android.gms.internal.firebase_auth.zzgc;
import com.google.android.gms.internal.firebase_auth.zzgd;
import com.google.android.gms.internal.firebase_auth.zzge;
import com.google.android.gms.internal.firebase_auth.zzgg;
import com.google.android.gms.internal.firebase_auth.zzgh;
import com.google.android.gms.internal.firebase_auth.zzgi;
import com.google.android.gms.internal.firebase_auth.zzgj;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.zzc;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zza {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FBAuthApiDispatcher", new String[0]);
    /* access modifiers changed from: private */
    public final zzfn zzb;
    /* access modifiers changed from: private */
    public final zzar zzc;

    public zza(zzfn zzfn, zzar zzar) {
        this.zzb = (zzfn) Preconditions.checkNotNull(zzfn);
        this.zzc = (zzar) Preconditions.checkNotNull(zzar);
    }

    public final void zza(String str, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(new zzes(str), (zzfp<zzff>) new zzc(this, zzeg));
    }

    public final void zza(zzgd zzgd, zzeg zzeg) {
        Preconditions.checkNotNull(zzgd);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(zzgd, (zzfp<zzgc>) new zzl(this, zzeg));
    }

    public final void zza(Context context, zzfy zzfy, zzeg zzeg) {
        Preconditions.checkNotNull(zzfy);
        Preconditions.checkNotNull(zzeg);
        if (this.zzc.zza()) {
            zzfy.zzc(true);
        }
        this.zzb.zza((Context) null, zzfy, (zzfp<zzga>) new zzx(this, zzeg));
    }

    public final void zzb(String str, zzeg zzeg) {
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(new zzfu(str), (zzfp<zzfx>) new zzag(this, zzeg));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzaf(this, userProfileChangeRequest, zzeg));
    }

    public final void zza(String str, String str2, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzai(this, str2, zzeg));
    }

    public final void zzb(String str, String str2, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzah(this, str2, zzeg));
    }

    public final void zzc(String str, String str2, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        zzfs zzfs = new zzfs();
        zzfs.zzh(str);
        zzfs.zzi(str2);
        this.zzb.zza(zzfs, (zzfp<zzfv>) new zzak(this, zzeg));
    }

    private final void zza(String str, zzfp<zzff> zzfp) {
        Preconditions.checkNotNull(zzfp);
        Preconditions.checkNotEmpty(str);
        zzff zzb2 = zzff.zzb(str);
        if (zzb2.zzb()) {
            zzfp.zza(zzb2);
            return;
        }
        this.zzb.zza(new zzes(zzb2.zzc()), (zzfp<zzff>) new zzaj(this, zzfp));
    }

    public final void zza(String str, String str2, String str3, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(new zzfu(str, str2, (String) null, str3), (zzfp<zzfx>) new zzb(this, zzeg));
    }

    public final void zza(Context context, String str, String str2, String str3, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza((Context) null, new zzge(str, str2, str3), (zzfp<zzgh>) new zze(this, zzeg));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzeg zzeg) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzeg);
        if (emailAuthCredential.zzf()) {
            zza(emailAuthCredential.zze(), (zzfp<zzff>) new zzd(this, emailAuthCredential, zzeg));
        } else {
            zza(new zzer(emailAuthCredential, (String) null), zzeg);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzer zzer, zzeg zzeg) {
        Preconditions.checkNotNull(zzer);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(zzer, (zzfp<zzeq>) new zzg(this, zzeg));
    }

    /* access modifiers changed from: private */
    public final void zza(zzeg zzeg, zzff zzff, zzfs zzfs, zzfq zzfq) {
        Preconditions.checkNotNull(zzeg);
        Preconditions.checkNotNull(zzff);
        Preconditions.checkNotNull(zzfs);
        Preconditions.checkNotNull(zzfq);
        this.zzb.zza(new zzev(zzff.zzd()), (zzfp<zzeu>) new zzf(this, zzfq, zzeg, zzff, zzfs));
    }

    /* access modifiers changed from: private */
    public final void zza(zzeg zzeg, zzff zzff, zzew zzew, zzfs zzfs, zzfq zzfq) {
        Preconditions.checkNotNull(zzeg);
        Preconditions.checkNotNull(zzff);
        Preconditions.checkNotNull(zzew);
        Preconditions.checkNotNull(zzfs);
        Preconditions.checkNotNull(zzfq);
        this.zzb.zza(zzfs, (zzfp<zzfv>) new zzi(this, zzfs, zzew, zzeg, zzff, zzfq));
    }

    /* access modifiers changed from: private */
    public static zzff zza(zzff zzff, zzfv zzfv) {
        Preconditions.checkNotNull(zzff);
        Preconditions.checkNotNull(zzfv);
        String zzb2 = zzfv.zzb();
        String zzc2 = zzfv.zzc();
        if (TextUtils.isEmpty(zzb2) || TextUtils.isEmpty(zzc2)) {
            return zzff;
        }
        return new zzff(zzc2, zzb2, Long.valueOf(zzfv.zzd()), zzff.zzf());
    }

    /* access modifiers changed from: private */
    public final void zza(zzff zzff, String str, String str2, Boolean bool, zzc zzc2, zzeg zzeg, zzfq zzfq) {
        Preconditions.checkNotNull(zzff);
        Preconditions.checkNotNull(zzfq);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(new zzev(zzff.zzd()), (zzfp<zzeu>) new zzh(this, zzfq, str2, str, bool, zzc2, zzeg, zzff));
    }

    public final void zzd(String str, String str2, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(new zzen(str, str2), (zzfp<zzem>) new zzk(this, zzeg));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, String str2, zzeg zzeg) {
        zzfa zzfa;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        zzgj zza2 = zzgj.zza(actionCodeSettings.zzd());
        if (zza2 != null) {
            zzfa = new zzfa(zza2);
        } else {
            zzfa = new zzfa(zzgj.OOB_REQ_TYPE_UNSPECIFIED);
        }
        zzfa.zza(str);
        zzfa.zza(actionCodeSettings);
        zzfa.zzc(str2);
        this.zzb.zza(zzfa, (zzfp<zzfc>) new zzj(this, zzeg));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        zzfa zzfa = new zzfa(zzgj.VERIFY_EMAIL);
        zzfa.zzb(str);
        if (actionCodeSettings != null) {
            zzfa.zza(actionCodeSettings);
        }
        zzb(zzfa, zzeg);
    }

    public final void zze(String str, String str2, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(new zzfn(str, (String) null, str2), (zzfp<zzfm>) new zzm(this, zzeg));
    }

    public final void zzb(String str, String str2, String str3, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(new zzfn(str, str2, str3), (zzfp<zzfm>) new zzo(this, zzeg));
    }

    public final void zza(zzfr zzfr, zzeg zzeg) {
        Preconditions.checkNotEmpty(zzfr.zzb());
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(zzfr, (zzfp<zzft>) new zzn(this, zzeg));
    }

    public final void zza(Context context, zzgg zzgg, zzeg zzeg) {
        Preconditions.checkNotNull(zzgg);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza((Context) null, zzgg, (zzfp<zzgi>) new zzq(this, zzeg));
    }

    public final void zzc(String str, String str2, String str3, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzeg);
        zza(str3, (zzfp<zzff>) new zzp(this, str, str2, zzeg));
    }

    public final void zza(Context context, String str, zzgg zzgg, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzgg);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzs(this, zzgg, (Context) null, zzeg));
    }

    public final void zza(String str, zzfy zzfy, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfy);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzu(this, zzfy, zzeg));
    }

    public final void zzc(String str, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzw(this, zzeg));
    }

    public final void zzf(String str, String str2, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzeg);
        zza(str2, (zzfp<zzff>) new zzv(this, str, zzeg));
    }

    public final void zza(zzfa zzfa, zzeg zzeg) {
        zzb(zzfa, zzeg);
    }

    public final void zzd(String str, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzaa(this, zzeg));
    }

    public final void zze(String str, zzeg zzeg) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeg);
        zza(str, (zzfp<zzff>) new zzac(this, zzeg));
    }

    public final void zzf(String str, zzeg zzeg) {
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(str, (zzfp<Void>) new zzae(this, zzeg));
    }

    private final void zzb(zzfa zzfa, zzeg zzeg) {
        Preconditions.checkNotNull(zzfa);
        Preconditions.checkNotNull(zzeg);
        this.zzb.zza(zzfa, (zzfp<zzfc>) new zzad(this, zzeg));
    }

    /* access modifiers changed from: private */
    public final void zza(zzga zzga, zzeg zzeg, zzfq zzfq) {
        Status status;
        if (zzga.zzk()) {
            zzc zzp = zzga.zzp();
            String zzd = zzga.zzd();
            String zzl = zzga.zzl();
            if (zzga.zzb()) {
                status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                status = zzaa.zza(zzga.zzj());
            }
            if (this.zzc.zza()) {
                zzeg.zza(new zzeh(status, zzp, zzd, zzl));
            } else {
                zzeg.zza(status);
            }
        } else {
            zza(new zzff(zzga.zzg(), zzga.zzc(), Long.valueOf(zzga.zzh()), "Bearer"), zzga.zzf(), zzga.zze(), Boolean.valueOf(zzga.zzi()), zzga.zzp(), zzeg, zzfq);
        }
    }
}
