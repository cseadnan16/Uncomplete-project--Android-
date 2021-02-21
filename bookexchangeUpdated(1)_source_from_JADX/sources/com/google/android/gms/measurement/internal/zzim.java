package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzlr;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzim implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhp zza;

    private zzim(zzhp zzhp) {
        this.zza = zzhp;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        try {
            this.zza.zzr().zzx().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzp();
                        if (zzla.zza(intent)) {
                            str = "gs";
                        } else {
                            str = "auto";
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        boolean z = bundle == null;
                        if (!zzlr.zzb() || !zzap.zzcd.zza(null).booleanValue()) {
                            zza(z, data, str, queryParameter);
                        } else {
                            this.zza.zzq().zza((Runnable) new zzil(this, z, data, str, queryParameter));
                        }
                        this.zza.zzi().zza(activity, bundle);
                        return;
                    }
                }
                this.zza.zzi().zza(activity, bundle);
            }
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzi().zza(activity, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5 A[SYNTHETIC, Splitter:B:33:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ed A[Catch:{ Exception -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fe A[SYNTHETIC, Splitter:B:49:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012d A[Catch:{ Exception -> 0x01b9 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012e A[Catch:{ Exception -> 0x01b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            r2 = r21
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzca     // Catch:{ Exception -> 0x01b9 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r4)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r4 = "Activity created with data 'referrer' without required params"
            java.lang.String r5 = "utm_medium"
            java.lang.String r6 = "_cis"
            java.lang.String r7 = "utm_source"
            java.lang.String r8 = "utm_campaign"
            java.lang.String r10 = "gclid"
            if (r3 != 0) goto L_0x0043
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzap.zzcc     // Catch:{ Exception -> 0x01b9 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r11)     // Catch:{ Exception -> 0x01b9 }
            if (r3 != 0) goto L_0x0043
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzap.zzcb     // Catch:{ Exception -> 0x01b9 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r11)     // Catch:{ Exception -> 0x01b9 }
            if (r3 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r3 = 0
            goto L_0x009e
        L_0x0043:
            com.google.android.gms.measurement.internal.zzhp r3 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzla r3 = r3.zzp()     // Catch:{ Exception -> 0x01b9 }
            boolean r11 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01b9 }
            if (r11 == 0) goto L_0x0051
            r3 = 0
            goto L_0x009d
        L_0x0051:
            boolean r11 = r2.contains(r10)     // Catch:{ Exception -> 0x01b9 }
            if (r11 != 0) goto L_0x0076
            boolean r11 = r2.contains(r8)     // Catch:{ Exception -> 0x01b9 }
            if (r11 != 0) goto L_0x0076
            boolean r11 = r2.contains(r7)     // Catch:{ Exception -> 0x01b9 }
            if (r11 != 0) goto L_0x0076
            boolean r11 = r2.contains(r5)     // Catch:{ Exception -> 0x01b9 }
            if (r11 != 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzw()     // Catch:{ Exception -> 0x01b9 }
            r3.zza(r4)     // Catch:{ Exception -> 0x01b9 }
            r3 = 0
            goto L_0x009d
        L_0x0076:
            java.lang.String r11 = "https://google.com/search?"
            java.lang.String r12 = java.lang.String.valueOf(r21)     // Catch:{ Exception -> 0x01b9 }
            int r13 = r12.length()     // Catch:{ Exception -> 0x01b9 }
            if (r13 == 0) goto L_0x0087
            java.lang.String r11 = r11.concat(r12)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x008d
        L_0x0087:
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x01b9 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x01b9 }
            r11 = r12
        L_0x008d:
            android.net.Uri r11 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x01b9 }
            android.os.Bundle r3 = r3.zza((android.net.Uri) r11)     // Catch:{ Exception -> 0x01b9 }
            if (r3 == 0) goto L_0x009c
            java.lang.String r11 = "referrer"
            r3.putString(r6, r11)     // Catch:{ Exception -> 0x01b9 }
        L_0x009c:
        L_0x009d:
        L_0x009e:
            r11 = 0
            java.lang.String r12 = "_cmp"
            r13 = 1
            if (r18 == 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.zzhp r14 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzla r14 = r14.zzp()     // Catch:{ Exception -> 0x01b9 }
            r15 = r19
            android.os.Bundle r14 = r14.zza((android.net.Uri) r15)     // Catch:{ Exception -> 0x01b9 }
            if (r14 == 0) goto L_0x00ee
            java.lang.String r15 = "intent"
            r14.putString(r6, r15)     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzca     // Catch:{ Exception -> 0x01b9 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r15)     // Catch:{ Exception -> 0x01b9 }
            if (r6 == 0) goto L_0x00e7
            boolean r6 = r14.containsKey(r10)     // Catch:{ Exception -> 0x01b9 }
            if (r6 != 0) goto L_0x00e7
            if (r3 == 0) goto L_0x00e7
            boolean r6 = r3.containsKey(r10)     // Catch:{ Exception -> 0x01b9 }
            if (r6 == 0) goto L_0x00e7
            java.lang.String r6 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.Object[] r9 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r16 = r3.getString(r10)     // Catch:{ Exception -> 0x01b9 }
            r9[r11] = r16     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r9 = java.lang.String.format(r15, r9)     // Catch:{ Exception -> 0x01b9 }
            r14.putString(r6, r9)     // Catch:{ Exception -> 0x01b9 }
        L_0x00e7:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            r6.zza((java.lang.String) r0, (java.lang.String) r12, (android.os.Bundle) r14)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x00ee
        L_0x00ed:
            r14 = 0
        L_0x00ee:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzcc     // Catch:{ Exception -> 0x01b9 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r9)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r9 = "auto"
            if (r6 == 0) goto L_0x0127
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcb     // Catch:{ Exception -> 0x01b9 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r15)     // Catch:{ Exception -> 0x01b9 }
            if (r6 != 0) goto L_0x0127
            if (r3 == 0) goto L_0x0127
            boolean r6 = r3.containsKey(r10)     // Catch:{ Exception -> 0x01b9 }
            if (r6 == 0) goto L_0x0127
            if (r14 == 0) goto L_0x011c
            boolean r6 = r14.containsKey(r10)     // Catch:{ Exception -> 0x01b9 }
            if (r6 != 0) goto L_0x0127
        L_0x011c:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r14 = "_lgclid"
            java.lang.String r15 = r3.getString(r10)     // Catch:{ Exception -> 0x01b9 }
            r6.zza((java.lang.String) r9, (java.lang.String) r14, (java.lang.Object) r15, (boolean) r13)     // Catch:{ Exception -> 0x01b9 }
        L_0x0127:
            boolean r6 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01b9 }
            if (r6 == 0) goto L_0x012e
            return
        L_0x012e:
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzr()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzw()     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r14 = "Activity created with referrer"
            r6.zza(r14, r2)     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzhp r6 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzt()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzap.zzcb     // Catch:{ Exception -> 0x01b9 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r14)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r14 = "_ldl"
            if (r6 == 0) goto L_0x016b
            if (r3 == 0) goto L_0x0155
            com.google.android.gms.measurement.internal.zzhp r2 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            r2.zza((java.lang.String) r0, (java.lang.String) r12, (android.os.Bundle) r3)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x0164
        L_0x0155:
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzw()     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r3 = "Referrer does not contain valid parameters"
            r0.zza(r3, r2)     // Catch:{ Exception -> 0x01b9 }
        L_0x0164:
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            r2 = 0
            r0.zza((java.lang.String) r9, (java.lang.String) r14, (java.lang.Object) r2, (boolean) r13)     // Catch:{ Exception -> 0x01b9 }
            return
        L_0x016b:
            boolean r0 = r2.contains(r10)     // Catch:{ Exception -> 0x01b9 }
            if (r0 == 0) goto L_0x0198
            boolean r0 = r2.contains(r8)     // Catch:{ Exception -> 0x01b9 }
            if (r0 != 0) goto L_0x0196
            boolean r0 = r2.contains(r7)     // Catch:{ Exception -> 0x01b9 }
            if (r0 != 0) goto L_0x0196
            boolean r0 = r2.contains(r5)     // Catch:{ Exception -> 0x01b9 }
            if (r0 != 0) goto L_0x0196
            java.lang.String r0 = "utm_term"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x01b9 }
            if (r0 != 0) goto L_0x0196
            java.lang.String r0 = "utm_content"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x01b9 }
            if (r0 == 0) goto L_0x0198
        L_0x0196:
            r11 = 1
            goto L_0x0199
        L_0x0198:
        L_0x0199:
            if (r11 != 0) goto L_0x01a9
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ Exception -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzw()     // Catch:{ Exception -> 0x01b9 }
            r0.zza(r4)     // Catch:{ Exception -> 0x01b9 }
            return
        L_0x01a9:
            boolean r0 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01b9 }
            if (r0 != 0) goto L_0x01b6
            com.google.android.gms.measurement.internal.zzhp r0 = r1.zza     // Catch:{ Exception -> 0x01b9 }
            r0.zza((java.lang.String) r9, (java.lang.String) r14, (java.lang.Object) r2, (boolean) r13)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x01b7
        L_0x01b6:
        L_0x01b7:
            return
        L_0x01b9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhp r2 = r1.zza
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zza(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzim.zza(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzkc zzk = this.zza.zzk();
        zzk.zzq().zza((Runnable) new zzke(zzk, zzk.zzm().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        if (!zzle.zzb() || !zzap.zzax.zza(null).booleanValue()) {
            this.zza.zzi().zza(activity);
            this.zza.zzk().zzab();
            return;
        }
        this.zza.zzk().zzab();
        this.zza.zzi().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    /* synthetic */ zzim(zzhp zzhp, zzhr zzhr) {
        this(zzhp);
    }
}
