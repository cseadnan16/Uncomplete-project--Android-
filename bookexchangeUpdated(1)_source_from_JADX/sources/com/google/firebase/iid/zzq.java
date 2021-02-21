package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.Key;
import com.google.android.gms.internal.firebase_messaging.zzm;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final class zzq {
    zzq() {
    }

    /* access modifiers changed from: package-private */
    public final zzs zza(Context context, String str) throws zzt {
        zzs zzc = zzc(context, str);
        if (zzc != null) {
            return zzc;
        }
        return zzb(context, str);
    }

    /* access modifiers changed from: package-private */
    public final zzs zzb(Context context, String str) {
        zzs zzs = new zzs(zzai.zza(zzb.zza().getPublic()), System.currentTimeMillis());
        zzs zza = zza(context, str, zzs, true);
        if (zza == null || zza.equals(zzs)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Generated new key");
            }
            zza(context, str, zzs);
            return zzs;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
        }
        return zza;
    }

    static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final zzs zzc(Context context, String str) throws zzt {
        try {
            zzs zzd = zzd(context, str);
            if (zzd != null) {
                zza(context, str, zzd);
                return zzd;
            }
            e = null;
            try {
                zzs zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza, false);
                    return zza;
                }
            } catch (zzt e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzt e2) {
            e = e2;
        }
    }

    private static PublicKey zza(String str) throws zzt {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzt((Exception) e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzt((Exception) e2);
        }
    }

    private final zzs zzd(Context context, String str) throws zzt {
        File zze = zze(context, str);
        if (!zze.exists()) {
            return null;
        }
        try {
            return zza(zze);
        } catch (zzt | IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
                sb.append("Failed to read ID from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return zza(zze);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new zzt((Exception) e2);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0096=Splitter:B:31:0x0096, B:19:0x0057=Splitter:B:19:0x0057} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzs zza(android.content.Context r9, java.lang.String r10, com.google.firebase.iid.zzs r11, boolean r12) {
        /*
            r8 = this;
            r0 = 3
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r2 = android.util.Log.isLoggable(r1, r0)
            if (r2 == 0) goto L_0x000e
            java.lang.String r2 = "Writing ID to properties file"
            android.util.Log.d(r1, r2)
        L_0x000e:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            java.lang.String r3 = r11.zza()
            java.lang.String r4 = "id"
            r2.setProperty(r4, r3)
            long r3 = r11.zzb
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "cre"
            r2.setProperty(r4, r3)
            java.io.File r9 = zze(r9, r10)
            r10 = 0
            r9.createNewFile()     // Catch:{ IOException -> 0x00b0 }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x00b0 }
            java.lang.String r4 = "rw"
            r3.<init>(r9, r4)     // Catch:{ IOException -> 0x00b0 }
            java.nio.channels.FileChannel r9 = r3.getChannel()     // Catch:{ all -> 0x00a6 }
            r9.lock()     // Catch:{ all -> 0x009a }
            r4 = 0
            if (r12 == 0) goto L_0x0086
            long r6 = r9.size()     // Catch:{ all -> 0x009a }
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0086
            r9.position(r4)     // Catch:{ IOException -> 0x005d, zzt -> 0x005b }
            com.google.firebase.iid.zzs r11 = zza((java.nio.channels.FileChannel) r9)     // Catch:{ IOException -> 0x005d, zzt -> 0x005b }
            if (r9 == 0) goto L_0x0057
            r9.close()     // Catch:{ all -> 0x00a6 }
        L_0x0057:
            r3.close()     // Catch:{ IOException -> 0x00b0 }
            return r11
        L_0x005b:
            r12 = move-exception
            goto L_0x005e
        L_0x005d:
            r12 = move-exception
        L_0x005e:
            boolean r0 = android.util.Log.isLoggable(r1, r0)     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x0086
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x009a }
            int r0 = r0.length()     // Catch:{ all -> 0x009a }
            int r0 = r0 + 58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r6.<init>(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = "Tried reading ID before writing new one, but failed with: "
            r6.append(r0)     // Catch:{ all -> 0x009a }
            r6.append(r12)     // Catch:{ all -> 0x009a }
            java.lang.String r12 = r6.toString()     // Catch:{ all -> 0x009a }
            android.util.Log.d(r1, r12)     // Catch:{ all -> 0x009a }
        L_0x0086:
            r9.truncate(r4)     // Catch:{ all -> 0x009a }
            java.io.OutputStream r12 = java.nio.channels.Channels.newOutputStream(r9)     // Catch:{ all -> 0x009a }
            r2.store(r12, r10)     // Catch:{ all -> 0x009a }
            if (r9 == 0) goto L_0x0096
            r9.close()     // Catch:{ all -> 0x00a6 }
        L_0x0096:
            r3.close()     // Catch:{ IOException -> 0x00b0 }
            return r11
        L_0x009a:
            r11 = move-exception
            if (r9 == 0) goto L_0x00a5
            r9.close()     // Catch:{ all -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            r9 = move-exception
            com.google.android.gms.internal.firebase_messaging.zzm.zza(r11, r9)     // Catch:{ all -> 0x00a6 }
        L_0x00a5:
            throw r11     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r9 = move-exception
            r3.close()     // Catch:{ all -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r11 = move-exception
            com.google.android.gms.internal.firebase_messaging.zzm.zza(r9, r11)     // Catch:{ IOException -> 0x00b0 }
        L_0x00af:
            throw r9     // Catch:{ IOException -> 0x00b0 }
        L_0x00b0:
            r9 = move-exception
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r11 = java.lang.String.valueOf(r9)
            int r11 = r11.length()
            int r11 = r11 + 21
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            java.lang.String r11 = "Failed to write key: "
            r12.append(r11)
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            android.util.Log.w(r1, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzq.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzs, boolean):com.google.firebase.iid.zzs");
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File zze(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes(Key.STRING_CHARSET_NAME), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), str2);
    }

    private final zzs zza(File file) throws zzt, IOException {
        FileChannel channel;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            channel = fileInputStream.getChannel();
            channel.lock(0, LongCompanionObject.MAX_VALUE, true);
            zzs zza = zza(channel);
            if (channel != null) {
                channel.close();
            }
            fileInputStream.close();
            return zza;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzm.zza(th, th2);
            }
            throw th;
        }
        throw th;
    }

    private static zzs zza(FileChannel fileChannel) throws zzt, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        try {
            long parseLong = Long.parseLong(properties.getProperty("cre"));
            String property = properties.getProperty("id");
            if (property == null) {
                String property2 = properties.getProperty("pub");
                if (property2 != null) {
                    property = zzai.zza(zza(property2));
                } else {
                    throw new zzt("Invalid properties file");
                }
            }
            return new zzs(property, parseLong);
        } catch (NumberFormatException e) {
            throw new zzt((Exception) e);
        }
    }

    private static zzs zza(SharedPreferences sharedPreferences, String str) throws zzt {
        long zzb = zzb(sharedPreferences, str);
        String string = sharedPreferences.getString(zzat.zza(str, "id"), (String) null);
        if (string == null) {
            String string2 = sharedPreferences.getString(zzat.zza(str, "|P|"), (String) null);
            if (string2 == null) {
                return null;
            }
            string = zzai.zza(zza(string2));
        }
        return new zzs(string, zzb);
    }

    private final void zza(Context context, String str, zzs zzs) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzs.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzt e) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(zzat.zza(str, "id"), zzs.zza());
        edit.putString(zzat.zza(str, "cre"), String.valueOf(zzs.zzb));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzat.zza(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
