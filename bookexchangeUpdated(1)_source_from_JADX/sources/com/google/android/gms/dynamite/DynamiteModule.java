package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    public static final VersionPolicy PREFER_LOCAL = new zzc();
    public static final VersionPolicy PREFER_REMOTE = new zzb();
    private static Boolean zzif;
    private static zzi zzig;
    private static zzk zzih;
    private static String zzii;
    private static int zzij = -1;
    private static final ThreadLocal<zza> zzik = new ThreadLocal<>();
    private static final VersionPolicy.zza zzil = new zza();
    private static final VersionPolicy zzim = new zzg();
    private final Context zzin;

    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public interface VersionPolicy {

        public interface zza {
            int getLocalVersion(Context context, String str);

            int zza(Context context, String str, boolean z) throws LoadingException;
        }

        public static class zzb {
            public int zzir = 0;
            public int zzis = 0;
            public int zzit = 0;
        }

        zzb zza(Context context, String str, zza zza2) throws LoadingException;
    }

    private static class zza {
        public Cursor zzio;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        VersionPolicy.zzb zza2;
        zza zza3 = zzik.get();
        zza zza4 = new zza((zza) null);
        zzik.set(zza4);
        try {
            zza2 = versionPolicy.zza(context, str, zzil);
            int i = zza2.zzir;
            int i2 = zza2.zzis;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            if (zza2.zzit == 0 || ((zza2.zzit == -1 && zza2.zzir == 0) || (zza2.zzit == 1 && zza2.zzis == 0))) {
                int i3 = zza2.zzir;
                int i4 = zza2.zzis;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i3);
                sb2.append(" and remote version is ");
                sb2.append(i4);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (zza) null);
            } else if (zza2.zzit == -1) {
                DynamiteModule zze = zze(context, str);
                if (zza4.zzio != null) {
                    zza4.zzio.close();
                }
                zzik.set(zza3);
                return zze;
            } else if (zza2.zzit == 1) {
                DynamiteModule zza5 = zza(context, str, zza2.zzis);
                if (zza4.zzio != null) {
                    zza4.zzio.close();
                }
                zzik.set(zza3);
                return zza5;
            } else {
                int i5 = zza2.zzit;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i5);
                throw new LoadingException(sb3.toString(), (zza) null);
            }
        } catch (LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
            if (zza2.zzir == 0 || versionPolicy.zza(context, str, new zzb(zza2.zzir, 0)).zzit != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", e, (zza) null);
            }
            DynamiteModule zze2 = zze(context, str);
            if (zza4.zzio != null) {
                zza4.zzio.close();
            }
            zzik.set(zza3);
            return zze2;
        } catch (Throwable th) {
            if (zza4.zzio != null) {
                zza4.zzio.close();
            }
            zzik.set(zza3);
            throw th;
        }
    }

    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, zza zza) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    private static class zzb implements VersionPolicy.zza {
        private final int zzip;
        private final int zziq = 0;

        public zzb(int i, int i2) {
            this.zzip = i;
        }

        public final int zza(Context context, String str, boolean z) {
            return 0;
        }

        public final int getLocalVersion(Context context, String str) {
            return this.zzip;
        }
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException e) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0037=Splitter:B:19:0x0037, B:36:0x007e=Splitter:B:36:0x007e} */
    public static int zza(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x00f4 }
            java.lang.Boolean r1 = zzif     // Catch:{ all -> 0x00f1 }
            if (r1 != 0) goto L_0x00be
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            monitor-enter(r1)     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
            r3 = 0
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x008e }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x003a
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008e }
            if (r4 != r2) goto L_0x0032
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008e }
            goto L_0x008b
        L_0x0032:
            zza(r4)     // Catch:{ LoadingException -> 0x0036 }
            goto L_0x0037
        L_0x0036:
            r2 = move-exception
        L_0x0037:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x008e }
            goto L_0x008b
        L_0x003a:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x008e }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x008e }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x0054
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008e }
            r2.set(r3, r4)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008e }
            goto L_0x008b
        L_0x0054:
            int r4 = zzc(r8, r9, r10)     // Catch:{ LoadingException -> 0x0081 }
            java.lang.String r5 = zzii     // Catch:{ LoadingException -> 0x0081 }
            if (r5 == 0) goto L_0x007e
            java.lang.String r5 = zzii     // Catch:{ LoadingException -> 0x0081 }
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x0081 }
            if (r5 == 0) goto L_0x0065
            goto L_0x007e
        L_0x0065:
            com.google.android.gms.dynamite.zzh r5 = new com.google.android.gms.dynamite.zzh     // Catch:{ LoadingException -> 0x0081 }
            java.lang.String r6 = zzii     // Catch:{ LoadingException -> 0x0081 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0081 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0081 }
            zza(r5)     // Catch:{ LoadingException -> 0x0081 }
            r2.set(r3, r5)     // Catch:{ LoadingException -> 0x0081 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x0081 }
            zzif = r5     // Catch:{ LoadingException -> 0x0081 }
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            return r4
        L_0x007e:
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            return r4
        L_0x0081:
            r4 = move-exception
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008e }
            r2.set(r3, r4)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008e }
        L_0x008b:
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            r1 = r2
            goto L_0x00bc
        L_0x008e:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008e }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0095, IllegalAccessException -> 0x0093, NoSuchFieldException -> 0x0091 }
        L_0x0091:
            r1 = move-exception
            goto L_0x0096
        L_0x0093:
            r1 = move-exception
            goto L_0x0096
        L_0x0095:
            r1 = move-exception
        L_0x0096:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f1 }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f1 }
            int r3 = r3.length()     // Catch:{ all -> 0x00f1 }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r4.<init>(r3)     // Catch:{ all -> 0x00f1 }
            java.lang.String r3 = "Failed to load module via V2: "
            r4.append(r3)     // Catch:{ all -> 0x00f1 }
            r4.append(r1)     // Catch:{ all -> 0x00f1 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00f1 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x00f1 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00f1 }
        L_0x00bc:
            zzif = r1     // Catch:{ all -> 0x00f1 }
        L_0x00be:
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x00ec
            int r8 = zzc(r8, r9, r10)     // Catch:{ LoadingException -> 0x00ca }
            return r8
        L_0x00ca:
            r9 = move-exception
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00f4 }
            int r1 = r9.length()     // Catch:{ all -> 0x00f4 }
            if (r1 == 0) goto L_0x00e2
            java.lang.String r9 = r0.concat(r9)     // Catch:{ all -> 0x00f4 }
            goto L_0x00e7
        L_0x00e2:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00f4 }
            r9.<init>(r0)     // Catch:{ all -> 0x00f4 }
        L_0x00e7:
            android.util.Log.w(r10, r9)     // Catch:{ all -> 0x00f4 }
            r8 = 0
            return r8
        L_0x00ec:
            int r8 = zzb((android.content.Context) r8, (java.lang.String) r9, (boolean) r10)     // Catch:{ all -> 0x00f4 }
            return r8
        L_0x00f1:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            throw r9     // Catch:{ all -> 0x00f4 }
        L_0x00f4:
            r9 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r8, r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    private static int zzb(Context context, String str, boolean z) {
        zzi zzj = zzj(context);
        if (zzj == null) {
            return 0;
        }
        try {
            if (zzj.zzak() >= 2) {
                return zzj.zzb(ObjectWrapper.wrap(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return zzj.zza(ObjectWrapper.wrap(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzc(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r10 == 0) goto L_0x000d
            java.lang.String r8 = "api_force_staging"
            goto L_0x000f
        L_0x000d:
            java.lang.String r8 = "api"
        L_0x000f:
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.<init>(r10)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.append(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.append(r9)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r8 == 0) goto L_0x008b
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r9 == 0) goto L_0x008b
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r9 <= 0) goto L_0x0084
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0081 }
            zzii = r1     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x0081 }
            if (r1 < 0) goto L_0x006f
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x0081 }
            zzij = r1     // Catch:{ all -> 0x0081 }
        L_0x006f:
            monitor-exit(r10)     // Catch:{ all -> 0x0081 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r10 = zzik     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            com.google.android.gms.dynamite.DynamiteModule$zza r10 = (com.google.android.gms.dynamite.DynamiteModule.zza) r10     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r10 == 0) goto L_0x0084
            android.database.Cursor r1 = r10.zzio     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r1 != 0) goto L_0x0084
            r10.zzio = r8     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            goto L_0x0085
        L_0x0081:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0081 }
            throw r9     // Catch:{ Exception -> 0x009e, all -> 0x009a }
        L_0x0084:
            r0 = r8
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.close()
        L_0x008a:
            return r9
        L_0x008b:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>((java.lang.String) r10, (com.google.android.gms.dynamite.zza) r0)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            throw r9     // Catch:{ Exception -> 0x009e, all -> 0x009a }
        L_0x009a:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00b6
        L_0x009e:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00a7
        L_0x00a3:
            r8 = move-exception
            goto L_0x00b6
        L_0x00a5:
            r8 = move-exception
            r9 = r0
        L_0x00a7:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00b4 }
            if (r10 == 0) goto L_0x00ac
            throw r8     // Catch:{ all -> 0x00b4 }
        L_0x00ac:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00b4 }
            throw r10     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r8 = move-exception
            r0 = r9
        L_0x00b6:
            if (r0 == 0) goto L_0x00bb
            r0.close()
        L_0x00bb:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    private static DynamiteModule zze(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule zza(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        IObjectWrapper iObjectWrapper;
        try {
            synchronized (DynamiteModule.class) {
                bool = zzif;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (zza) null);
            } else if (bool.booleanValue()) {
                return zzb(context, str, i);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i);
                Log.i("DynamiteModule", sb.toString());
                zzi zzj = zzj(context);
                if (zzj != null) {
                    if (zzj.zzak() >= 2) {
                        iObjectWrapper = zzj.zzb(ObjectWrapper.wrap(context), str, i);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        iObjectWrapper = zzj.zza(ObjectWrapper.wrap(context), str, i);
                    }
                    if (ObjectWrapper.unwrap(iObjectWrapper) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapper));
                    }
                    throw new LoadingException("Failed to load remote module.", (zza) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (zza) null);
            }
        } catch (RemoteException e) {
            throw new LoadingException("Failed to load remote module.", e, (zza) null);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new LoadingException("Failed to load remote module.", th, (zza) null);
        }
    }

    private static zzi zzj(Context context) {
        zzi zzi;
        synchronized (DynamiteModule.class) {
            if (zzig != null) {
                zzi zzi2 = zzig;
                return zzi2;
            } else if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzi = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        if (queryLocalInterface instanceof zzi) {
                            zzi = (zzi) queryLocalInterface;
                        } else {
                            zzi = new zzj(iBinder);
                        }
                    }
                    if (zzi != null) {
                        zzig = zzi;
                        return zzi;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
            }
        }
        return null;
    }

    public final Context getModuleContext() {
        return this.zzin;
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws LoadingException, RemoteException {
        zzk zzk;
        IObjectWrapper iObjectWrapper;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzk = zzih;
        }
        if (zzk != null) {
            zza zza2 = zzik.get();
            if (zza2 == null || zza2.zzio == null) {
                throw new LoadingException("No result cursor", (zza) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = zza2.zzio;
            ObjectWrapper.wrap(null);
            if (zzaj().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                iObjectWrapper = zzk.zzb(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                iObjectWrapper = zzk.zza(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            }
            Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (zza) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (zza) null);
    }

    private static Boolean zzaj() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(zzij >= 2);
        }
        return valueOf;
    }

    private static void zza(ClassLoader classLoader) throws LoadingException {
        zzk zzk;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzk = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzk) {
                    zzk = (zzk) queryLocalInterface;
                } else {
                    zzk = new zzl(iBinder);
                }
            }
            zzih = zzk;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zza) null);
        }
    }

    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzin.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (zza) null);
        }
    }

    private DynamiteModule(Context context) {
        this.zzin = (Context) Preconditions.checkNotNull(context);
    }
}
