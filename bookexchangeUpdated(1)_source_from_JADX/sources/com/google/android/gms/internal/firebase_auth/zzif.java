package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzif;
import com.google.android.gms.internal.firebase_auth.zzif.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
public abstract class zzif<MessageType extends zzif<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgn<MessageType, BuilderType> {
    private static Map<Object, zzif<?, ?>> zzd = new ConcurrentHashMap();
    protected zzky zzb = zzky.zza();
    private int zzc = -1;

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzif<MessageType, BuilderType> implements zzjp {
        protected zzhv<zze> zzc = zzhv.zza();
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static class zzd<ContainingType extends zzjn, Type> extends zzhq<ContainingType, Type> {
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    static final class zze implements zzhx<zze> {
        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzlm zzb() {
            throw new NoSuchMethodError();
        }

        public final zzlt zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzjq zza(zzjq zzjq, zzjn zzjn) {
            throw new NoSuchMethodError();
        }

        public final zzjt zza(zzjt zzjt, zzjt zzjt2) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static final class zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static class zzc<T extends zzif<T, ?>> extends zzgo<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }

        public final /* synthetic */ Object zza(zzhh zzhh, zzhs zzhs) throws zzin {
            return zzif.zza(this.zza, zzhh, zzhs);
        }
    }

    public String toString() {
        return zzjs.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzjz.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.firebase:firebase-auth@@19.3.0 */
    public static abstract class zza<MessageType extends zzif<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgm<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (zzif) messagetype.zza(zzf.zzd, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void zzb() {
            MessageType messagetype = (zzif) this.zza.zza(zzf.zzd, (Object) null, (Object) null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: b_ */
        public final boolean mo12167b_() {
            return zzif.zza(this.zza, false);
        }

        /* renamed from: zzd */
        public MessageType zzf() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjz.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zze */
        public final MessageType zzg() {
            MessageType messagetype = (zzif) zzf();
            if (messagetype.mo12167b_()) {
                return messagetype;
            }
            throw new zzkx(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjz.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        public final /* synthetic */ zzgm zza() {
            return (zza) clone();
        }

        /* renamed from: h_ */
        public final /* synthetic */ zzjn mo12169h_() {
            return this.zzc;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza2 = (zza) ((zzif) this.zzc).zza(zzf.zze, (Object) null, (Object) null);
            zza2.zza((zzif) zzf());
            return zza2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjz.zza().zza(this).zza(this, (zzif) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzif<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzz() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    /* renamed from: b_ */
    public final boolean mo12167b_() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zzy() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i) {
        this.zzc = i;
    }

    public final void zza(zzhm zzhm) throws IOException {
        zzjz.zza().zza(this).zza(this, (zzls) zzhp.zza(zzhm));
    }

    public final int zzaa() {
        if (this.zzc == -1) {
            this.zzc = zzjz.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzif<?, ?>> T zza(Class<T> cls) {
        T t = (zzif) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzif) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzif) ((zzif) zzlf.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzif<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzjn zzjn, String str, Object[] objArr) {
        return new zzkb(zzjn, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzif<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzjz.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzim zzab() {
        return zzig.zzd();
    }

    protected static <E> zzio<E> zzac() {
        return zzkc.zzd();
    }

    static <T extends zzif<T, ?>> T zza(T t, zzhh zzhh, zzhs zzhs) throws zzin {
        T t2 = (zzif) t.zza(zzf.zzd, (Object) null, (Object) null);
        try {
            zzkd zza2 = zzjz.zza().zza(t2);
            zza2.zza(t2, zzhk.zza(zzhh), zzhs);
            zza2.zzc(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzin) {
                throw ((zzin) e.getCause());
            }
            throw new zzin(e.getMessage()).zza(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzin) {
                throw ((zzin) e2.getCause());
            }
            throw e2;
        }
    }

    public final /* synthetic */ zzjq zzad() {
        zza zza2 = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzjq zzae() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    /* renamed from: h_ */
    public final /* synthetic */ zzjn mo12169h_() {
        return (zzif) zza(zzf.zzf, (Object) null, (Object) null);
    }
}
