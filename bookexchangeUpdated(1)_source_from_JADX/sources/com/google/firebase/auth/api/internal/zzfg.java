package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaa;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
final class zzfg extends zzen {
    final /* synthetic */ zzfe zza;

    zzfg(zzfe zzfe) {
        this.zza = zzfe;
    }

    public final void zza(zzff zzff) throws RemoteException {
        boolean z = true;
        if (this.zza.zzb != 1) {
            z = false;
        }
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzk = zzff;
        this.zza.zzf();
    }

    public final void zza(zzff zzff, zzew zzew) throws RemoteException {
        boolean z = this.zza.zzb == 2;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzk = zzff;
        this.zza.zzl = zzew;
        this.zza.zzf();
    }

    public final void zza(zzem zzem) throws RemoteException {
        boolean z = this.zza.zzb == 3;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzm = zzem;
        this.zza.zzf();
    }

    public final void zza(zzfm zzfm) throws RemoteException {
        boolean z = this.zza.zzb == 4;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzn = zzfm;
        this.zza.zzf();
    }

    /* renamed from: i_ */
    public final void mo17605i_() throws RemoteException {
        boolean z = this.zza.zzb == 5;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzf();
    }

    public final void zzb() throws RemoteException {
        boolean z = this.zza.zzb == 6;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzf();
    }

    public final void zza(String str) throws RemoteException {
        boolean z = this.zza.zzb == 7;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzo = str;
        this.zza.zzf();
    }

    public final void zzb(String str) throws RemoteException {
        boolean z = this.zza.zzb == 8;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzp = str;
        zza((zzfl) new zzfi(this, str));
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zza.zzb == 8;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        boolean unused = this.zza.zzx = true;
        this.zza.zzw = true;
        zza((zzfl) new zzfh(this, phoneAuthCredential));
    }

    public final void zzc(String str) throws RemoteException {
        boolean z = this.zza.zzb == 8;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzp = str;
        boolean unused = this.zza.zzx = true;
        this.zza.zzw = true;
        zza((zzfl) new zzfk(this, str));
    }

    public final void zza(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        if (this.zza.zzb == 8) {
            boolean unused = this.zza.zzx = true;
            this.zza.zzw = false;
            zza((zzfl) new zzfj(this, status));
            return;
        }
        this.zza.zzb(status);
        this.zza.zza(status);
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zza.zzb == 2;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zza(status, phoneAuthCredential, (String) null, (String) null);
    }

    public final void zza(zzeh zzeh) {
        zza(zzeh.zza(), zzeh.zzb(), zzeh.zzc(), zzeh.zzd());
    }

    public final void zza(zzej zzej) {
        this.zza.zzt = zzej;
        this.zza.zza(zzaa.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        this.zza.zzb(status);
        this.zza.zzq = authCredential;
        this.zza.zzr = str;
        this.zza.zzs = str2;
        if (this.zza.zzg != null) {
            this.zza.zzg.zza(status);
        }
        this.zza.zza(status);
    }

    public final void zzc() throws RemoteException {
        boolean z = this.zza.zzb == 9;
        int i = this.zza.zzb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzf();
    }

    private final void zza(zzfl zzfl) {
        this.zza.zzj.execute(new zzfm(this, zzfl));
    }
}
