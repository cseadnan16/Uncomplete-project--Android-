package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzgh extends zzhi {
    /* access modifiers changed from: private */
    public static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzgl zza;
    /* access modifiers changed from: private */
    public zzgl zzb;
    private final PriorityBlockingQueue<zzgm<?>> zzc = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzgm<?>> zzd = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zze = new zzgj(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzf = new zzgj(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzg = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzh = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzi;

    zzgh(zzgo zzgo) {
        super(zzgo);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final void zzd() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void zzc() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.zza;
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzgm zzgm = new zzgm(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                zzr().zzi().zza("Callable skipped the worker queue.");
            }
            zzgm.run();
        } else {
            zza((zzgm<?>) zzgm);
        }
        return zzgm;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzgm zzgm = new zzgm(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzgm.run();
        } else {
            zza((zzgm<?>) zzgm);
        }
        return zzgm;
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zza((zzgm<?>) new zzgm(this, runnable, false, "Task exception on worker thread"));
    }

    /* access modifiers changed from: package-private */
    public final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzq().zza(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzfm zzi2 = zzr().zzi();
                String valueOf = String.valueOf(str);
                zzi2.zza(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzfm zzi3 = zzr().zzi();
            String valueOf2 = String.valueOf(str);
            zzi3.zza(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    private final void zza(zzgm<?> zzgm) {
        synchronized (this.zzg) {
            this.zzc.add(zzgm);
            if (this.zza == null) {
                zzgl zzgl = new zzgl(this, "Measurement Worker", this.zzc);
                this.zza = zzgl;
                zzgl.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                this.zza.zza();
            }
        }
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zzgm zzgm = new zzgm(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzgm);
            if (this.zzb == null) {
                zzgl zzgl = new zzgl(this, "Measurement Network", this.zzd);
                this.zzb = zzgl;
                zzgl.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                this.zzb.zza();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfi zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgh zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfk zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzft zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
