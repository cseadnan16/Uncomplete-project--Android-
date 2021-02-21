package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.C0198Fragment;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zac extends DialogRedirect {
    private final /* synthetic */ C0198Fragment val$fragment;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaos;

    zac(Intent intent, C0198Fragment fragment, int i) {
        this.zaos = intent;
        this.val$fragment = fragment;
        this.val$requestCode = i;
    }

    public final void redirect() {
        Intent intent = this.zaos;
        if (intent != null) {
            this.val$fragment.startActivityForResult(intent, this.val$requestCode);
        }
    }
}
