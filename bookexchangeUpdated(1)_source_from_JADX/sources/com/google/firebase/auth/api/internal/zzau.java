package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzf;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzgj;
import com.google.android.gms.internal.firebase_auth.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzat;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.auth.internal.zzn;
import com.google.firebase.auth.internal.zzp;
import com.google.firebase.auth.internal.zzy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public final class zzau extends zzam<zzeu> {
    private final Context zza;
    private final zzeu zzb;
    private final Future<zzal<zzeu>> zzc = zza();

    zzau(Context context, zzeu zzeu) {
        this.zza = context;
        this.zzb = zzeu;
    }

    /* access modifiers changed from: package-private */
    public final Future<zzal<zzeu>> zza() {
        Future<zzal<zzeu>> future = this.zzc;
        if (future != null) {
            return future;
        }
        return zzf.zza().zza(zzk.zza).submit(new zzed(this.zzb, this.zza));
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzba zzba) {
        zzbm zzbm = (zzbm) new zzbm(str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zza(zzbm), zzbm);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, zza zza2) {
        zzcy zzcy = (zzcy) new zzcy(str, str2).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcy), zzcy);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zza zza2) {
        zzcw zzcw = (zzcw) new zzcw(authCredential, str).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcw), zzcw);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzba zzba) {
        zzbw zzbw = (zzbw) new zzbw(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzbw), zzbw);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzba zzba) {
        zzby zzby = (zzby) new zzby(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzby), zzby);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, zza zza2, String str) {
        zzcu zzcu = (zzcu) new zzcu(str).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcu), zzcu);
    }

    public final void zza(FirebaseApp firebaseApp, zzfr zzfr, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zzec zzec = (zzec) new zzec(zzfr).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor);
        zza(zzb(zzec), zzec);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzba zzba) {
        zzdw zzdw = (zzdw) new zzdw(userProfileChangeRequest).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzdw), zzdw);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzba zzba) {
        zzdq zzdq = (zzdq) new zzdq(str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzdq), zzdq);
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzba zzba) {
        zzds zzds = (zzds) new zzds(str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzds), zzds);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzba zzba) {
        zzdu zzdu = (zzdu) new zzdu(phoneAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzdu), zzdu);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, zza zza2) {
        zzbc zzbc = (zzbc) new zzbc(str, str2, str3).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzbc), zzbc);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, String str3, zza zza2) {
        zzda zzda = (zzda) new zzda(str, str2, str3).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzda), zzda);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, zza zza2) {
        zzdc zzdc = (zzdc) new zzdc(emailAuthCredential).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzdc), zzdc);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzba zzba) {
        zzce zzce = (zzce) new zzce(str, str2, str3).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzce), zzce);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzba zzba) {
        zzcg zzcg = (zzcg) new zzcg(str, str2, str3).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzcg), zzcg);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzba zzba) {
        zzca zzca = (zzca) new zzca(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzca), zzca);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzba zzba) {
        zzcc zzcc = (zzcc) new zzcc(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzcc), zzcc);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zza zza2) {
        zzde zzde = (zzde) new zzde(phoneAuthCredential, str).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzde), zzde);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzba zzba) {
        zzci zzci = (zzci) new zzci(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzci), zzci);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzba zzba) {
        zzck zzck = (zzck) new zzck(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzck), zzck);
    }

    public final Task<SignInMethodQueryResult> zza(FirebaseApp firebaseApp, String str, String str2) {
        zzbg zzbg = (zzbg) new zzbg(str, str2).zza(firebaseApp);
        return zza(zza(zzbg), zzbg);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zza(zzgj.PASSWORD_RESET);
        zzcq zzcq = (zzcq) new zzcq(str, actionCodeSettings, str2, "sendPasswordResetEmail").zza(firebaseApp);
        return zza(zzb(zzcq), zzcq);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zza(zzgj.EMAIL_SIGNIN);
        zzcq zzcq = (zzcq) new zzcq(str, actionCodeSettings, str2, "sendSignInLinkToEmail").zza(firebaseApp);
        return zza(zzb(zzcq), zzcq);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        zzco zzco = (zzco) new zzco(str, actionCodeSettings).zza(firebaseApp);
        return zza(zzb(zzco), zzco);
    }

    public final Task<ActionCodeResult> zzb(FirebaseApp firebaseApp, String str, String str2) {
        zzay zzay = (zzay) new zzay(str, str2).zza(firebaseApp);
        return zza(zzb(zzay), zzay);
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, String str, String str2) {
        zzaw zzaw = (zzaw) new zzaw(str, str2).zza(firebaseApp);
        return zza(zzb(zzaw), zzaw);
    }

    public final Task<String> zzd(FirebaseApp firebaseApp, String str, String str2) {
        zzea zzea = (zzea) new zzea(str, str2).zza(firebaseApp);
        return zza(zzb(zzea), zzea);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, String str3) {
        zzba zzba = (zzba) new zzba(str, str2, str3).zza(firebaseApp);
        return zza(zzb(zzba), zzba);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzba zzba) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzba);
        List<String> zza2 = firebaseUser.zza();
        if (zza2 != null && zza2.contains(authCredential.getProvider())) {
            return Tasks.forException(zzeh.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzg()) {
                zzbo zzbo = (zzbo) new zzbo(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
                return zza(zzb(zzbo), zzbo);
            }
            zzbu zzbu = (zzbu) new zzbu(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
            return zza(zzb(zzbu), zzbu);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzbs zzbs = (zzbs) new zzbs((PhoneAuthCredential) authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
            return zza(zzb(zzbs), zzbs);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzba);
            zzbq zzbq = (zzbq) new zzbq(authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
            return zza(zzb(zzbq), zzbq);
        }
    }

    public final Task<AuthResult> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzba zzba) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzba);
        List<String> zza2 = firebaseUser.zza();
        if ((zza2 != null && !zza2.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzeh.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        char c = 65535;
        if (str.hashCode() == 1216985755 && str.equals("password")) {
            c = 0;
        }
        if (c != 0) {
            zzdo zzdo = (zzdo) new zzdo(str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
            return zza(zzb(zzdo), zzdo);
        }
        zzdm zzdm = (zzdm) new zzdm().zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zzb(zzdm), zzdm);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzba zzba) {
        zzcm zzcm = (zzcm) new zzcm().zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba);
        return zza(zza(zzcm), zzcm);
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, zzad zzad) {
        zzbe zzbe = (zzbe) new zzbe().zza(firebaseUser).zza(zzad).zza((zzag) zzad);
        return zza(zzb(zzbe), zzbe);
    }

    public final Task<Void> zza(String str) {
        zzcs zzcs = new zzcs(str);
        return zza(zzb(zzcs), zzcs);
    }

    public final Task<Void> zza(zzy zzy, String str, String str2, long j, boolean z, boolean z2, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzdg zzdg = new zzdg(zzy, str, str2, j, z, z2);
        zzdg.zza(onVerificationStateChangedCallbacks, activity, executor);
        return zzb(zzdg);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zza zza2) {
        zzbi zzbi = new zzbi(phoneMultiFactorAssertion, firebaseUser.zzf(), str);
        zzbi.zza(firebaseApp).zza(zza2);
        return zzb(zzbi);
    }

    public final Task<Void> zza(zzy zzy, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j, boolean z, boolean z2, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzdi zzdi = new zzdi(phoneMultiFactorInfo, zzy.zzb(), str, j, z, z2);
        zzdi.zza(onVerificationStateChangedCallbacks, activity, executor);
        return zzb(zzdi);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zza zza2) {
        zzbk zzbk = new zzbk(phoneMultiFactorAssertion, str);
        zzbk.zza(firebaseApp).zza(zza2);
        if (firebaseUser != null) {
            zzbk.zza(firebaseUser);
        }
        return zzb(zzbk);
    }

    public final Task<Void> zze(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzba zzba) {
        return zzb((zzdk) new zzdk(firebaseUser.zzf(), str).zza(firebaseApp).zza(firebaseUser).zza(zzba).zza((zzag) zzba));
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zza(zzgj.VERIFY_AND_CHANGE_EMAIL);
        return zzb(new zzdy(str, str2, actionCodeSettings));
    }

    static zzn zza(FirebaseApp firebaseApp, zzew zzew) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzew);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzj(zzew, FirebaseAuthProvider.PROVIDER_ID));
        List<zzfj> zzj = zzew.zzj();
        if (zzj != null && !zzj.isEmpty()) {
            for (int i = 0; i < zzj.size(); i++) {
                arrayList.add(new zzj(zzj.get(i)));
            }
        }
        zzn zzn = new zzn(firebaseApp, arrayList);
        zzn.zza(new zzp(zzew.zzh(), zzew.zzg()));
        zzn.zza(zzew.zzi());
        zzn.zza(zzew.zzl());
        zzn.zzb(zzat.zza(zzew.zzm()));
        return zzn;
    }

    private final <ResultT> Task<ResultT> zza(Task<ResultT> task, zzap<zzef, ResultT> zzap) {
        return task.continueWithTask(new zzat(this, zzap));
    }
}
