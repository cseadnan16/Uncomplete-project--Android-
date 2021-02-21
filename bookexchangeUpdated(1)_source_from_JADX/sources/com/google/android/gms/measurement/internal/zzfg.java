package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.Clock;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzfg extends zze {
    private final zzff zza = new zzff(this, zzn(), "google_app_measurement_local.db");
    private boolean zzb;

    zzfg(zzgo zzgo) {
        super(zzgo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        zzb();
        zzd();
        try {
            int delete = zzae().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cc A[SYNTHETIC, Splitter:B:48:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0123 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0123 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0123 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzb()
            r16.zzd()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000e
            return r2
        L_0x000e:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0028:
            if (r5 >= r4) goto L_0x0135
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.zzae()     // Catch:{ SQLiteFullException -> 0x0107, SQLiteDatabaseLockedException -> 0x00f4, SQLiteException -> 0x00c8, all -> 0x00c5 }
            if (r9 != 0) goto L_0x003c
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x00c3, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x00bd }
            if (r9 == 0) goto L_0x003b
            r9.close()
        L_0x003b:
            return r2
        L_0x003c:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00c3, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x00bd }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00c3, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x00bd }
            if (r12 == 0) goto L_0x005f
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            if (r0 == 0) goto L_0x005f
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            goto L_0x005f
        L_0x0054:
            r0 = move-exception
            goto L_0x00f2
        L_0x0057:
            r0 = move-exception
            goto L_0x00bf
        L_0x0059:
            r0 = move-exception
            goto L_0x00bb
        L_0x005b:
            r0 = move-exception
            r7 = r12
            goto L_0x0109
        L_0x005f:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x00a6
            com.google.android.gms.measurement.internal.zzfk r15 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            com.google.android.gms.measurement.internal.zzfm r15 = r15.zzf()     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.String r4 = "Data loss, local db full"
            r15.zza(r4)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r4 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            r10[r2] = r11     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            int r4 = r9.delete(r0, r4, r10)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            long r10 = (long) r4     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x00a6
            com.google.android.gms.measurement.internal.zzfk r4 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            r4.zza(r15, r2, r8, r10)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
        L_0x00a6:
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x005b, SQLiteDatabaseLockedException -> 0x0059, SQLiteException -> 0x0057, all -> 0x0054 }
            if (r12 == 0) goto L_0x00b4
            r12.close()
        L_0x00b4:
            if (r9 == 0) goto L_0x00b9
            r9.close()
        L_0x00b9:
            r2 = 1
            return r2
        L_0x00bb:
            r7 = r12
            goto L_0x00f6
        L_0x00bd:
            r0 = move-exception
            r12 = r7
        L_0x00bf:
            r7 = r9
            goto L_0x00ca
        L_0x00c1:
            r0 = move-exception
            goto L_0x00f6
        L_0x00c3:
            r0 = move-exception
            goto L_0x0109
        L_0x00c5:
            r0 = move-exception
            r9 = r7
            goto L_0x012a
        L_0x00c8:
            r0 = move-exception
            r12 = r7
        L_0x00ca:
            if (r7 == 0) goto L_0x00d5
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x00d5
            r7.endTransaction()     // Catch:{ all -> 0x00f0 }
        L_0x00d5:
            com.google.android.gms.measurement.internal.zzfk r2 = r16.zzr()     // Catch:{ all -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00f0 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00f0 }
            if (r12 == 0) goto L_0x00ea
            r12.close()
        L_0x00ea:
            if (r7 == 0) goto L_0x0123
            r7.close()
            goto L_0x0123
        L_0x00f0:
            r0 = move-exception
            r9 = r7
        L_0x00f2:
            r7 = r12
            goto L_0x012a
        L_0x00f4:
            r0 = move-exception
            r9 = r7
        L_0x00f6:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x0129 }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x0101
            r7.close()
        L_0x0101:
            if (r9 == 0) goto L_0x0123
            r9.close()
            goto L_0x0123
        L_0x0107:
            r0 = move-exception
            r9 = r7
        L_0x0109:
            com.google.android.gms.measurement.internal.zzfk r2 = r16.zzr()     // Catch:{ all -> 0x0129 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x0129 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x0129 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x0129 }
            if (r7 == 0) goto L_0x011e
            r7.close()
        L_0x011e:
            if (r9 == 0) goto L_0x0123
            r9.close()
        L_0x0123:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0028
        L_0x0129:
            r0 = move-exception
        L_0x012a:
            if (r7 == 0) goto L_0x012f
            r7.close()
        L_0x012f:
            if (r9 == 0) goto L_0x0134
            r9.close()
        L_0x0134:
            throw r0
        L_0x0135:
            com.google.android.gms.measurement.internal.zzfk r0 = r16.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzan zzan) {
        Parcel obtain = Parcel.obtain();
        zzan.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkz zzkz) {
        Parcel obtain = Parcel.obtain();
        zzkz.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzr().zzg().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzv zzv) {
        zzp();
        byte[] zza2 = zzla.zza((Parcelable) zzv);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01e9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01ea, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01ef, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01f0, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01f4, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01f8, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01fb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01fc, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0200, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0201, code lost:
        r13 = r24;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0207, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x020a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x020b, code lost:
        r13 = r24;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0211, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0219, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x021a, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x022d, code lost:
        if (r15.inTransaction() != false) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x022f, code lost:
        r15.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0241, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0246, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0255, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x025a, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0270, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0275, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x027c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x027d, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x027e, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0281, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0286, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0099, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009a, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009f, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a4, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01e9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:52:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01f3 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), Splitter:B:52:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01fb A[ExcHandler: all (th java.lang.Throwable), PHI: r24 
      PHI: (r24v4 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:49:0x00ac, B:35:0x0089] A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0206 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), PHI: r24 
      PHI: (r24v2 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:49:0x00ac, B:35:0x0089] A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0211 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0218 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), Splitter:B:12:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0229 A[SYNTHETIC, Splitter:B:168:0x0229] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0278 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0278 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0278 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r2 = "Error reading entries from local database"
            r23.zzd()
            r23.zzb()
            boolean r0 = r1.zzb
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r23.zzaf()
            if (r0 != 0) goto L_0x001c
            return r4
        L_0x001c:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x0021:
            if (r7 >= r5) goto L_0x028a
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r23.zzae()     // Catch:{ SQLiteFullException -> 0x025e, SQLiteDatabaseLockedException -> 0x024a, SQLiteException -> 0x0224, all -> 0x0221 }
            if (r15 != 0) goto L_0x003a
            r1.zzb = r9     // Catch:{ SQLiteFullException -> 0x0037, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0034, all -> 0x0211 }
            if (r15 == 0) goto L_0x0033
            r15.close()
        L_0x0033:
            return r3
        L_0x0034:
            r0 = move-exception
            goto L_0x0216
        L_0x0037:
            r0 = move-exception
            goto L_0x021f
        L_0x003a:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x021d, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0214, all -> 0x0211 }
            com.google.android.gms.measurement.internal.zzx r0 = r23.zzt()     // Catch:{ SQLiteFullException -> 0x021d, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0214, all -> 0x0211 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzap.zzbz     // Catch:{ SQLiteFullException -> 0x021d, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0214, all -> 0x0211 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzez<java.lang.Boolean>) r10)     // Catch:{ SQLiteFullException -> 0x021d, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0214, all -> 0x0211 }
            r10 = 100
            java.lang.String r11 = "entry"
            java.lang.String r12 = "type"
            java.lang.String r13 = "rowid"
            r19 = -1
            if (r0 == 0) goto L_0x00a8
            long r16 = zza((android.database.sqlite.SQLiteDatabase) r15)     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x009e, all -> 0x0099 }
            int r0 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r14 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0037, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0034, all -> 0x0211 }
            java.lang.String r16 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteFullException -> 0x0037, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0034, all -> 0x0211 }
            r14[r6] = r16     // Catch:{ SQLiteFullException -> 0x0037, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x0034, all -> 0x0211 }
            goto L_0x006b
        L_0x0069:
            r0 = r3
            r14 = r0
        L_0x006b:
            java.lang.String r16 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x009e, all -> 0x0099 }
            r17 = 0
            r18 = 0
            java.lang.String r21 = "rowid asc"
            java.lang.String r22 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x00a3, SQLiteDatabaseLockedException -> 0x0218, SQLiteException -> 0x009e, all -> 0x0099 }
            r10 = r15
            r11 = r16
            r13 = r0
            r24 = r15
            r15 = r17
            r16 = r18
            r17 = r21
            r18 = r22
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x0094, SQLiteDatabaseLockedException -> 0x0206, SQLiteException -> 0x008f, all -> 0x01fb }
            r10 = r0
            goto L_0x00c3
        L_0x008f:
            r0 = move-exception
            r15 = r24
            goto L_0x0216
        L_0x0094:
            r0 = move-exception
            r15 = r24
            goto L_0x021f
        L_0x0099:
            r0 = move-exception
            r24 = r15
            goto L_0x01fc
        L_0x009e:
            r0 = move-exception
            r24 = r15
            goto L_0x0216
        L_0x00a3:
            r0 = move-exception
            r24 = r15
            goto L_0x021f
        L_0x00a8:
            r24 = r15
            java.lang.String r0 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x020a, SQLiteDatabaseLockedException -> 0x0206, SQLiteException -> 0x0200, all -> 0x01fb }
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r17 = "rowid asc"
            java.lang.String r18 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x020a, SQLiteDatabaseLockedException -> 0x0206, SQLiteException -> 0x0200, all -> 0x01fb }
            r10 = r24
            r11 = r0
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x020a, SQLiteDatabaseLockedException -> 0x0206, SQLiteException -> 0x0200, all -> 0x01fb }
            r10 = r0
        L_0x00c3:
        L_0x00c4:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x01f7, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01ef, all -> 0x01e9 }
            if (r0 == 0) goto L_0x01aa
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            r11 = 2
            byte[] r12 = r10.getBlob(r11)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            if (r0 != 0) goto L_0x010e
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00f8 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00f8 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00f8 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzan> r0 = com.google.android.gms.measurement.internal.zzan.CREATOR     // Catch:{ ParseException -> 0x00f8 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00f8 }
            com.google.android.gms.measurement.internal.zzan r0 = (com.google.android.gms.measurement.internal.zzan) r0     // Catch:{ ParseException -> 0x00f8 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            if (r0 == 0) goto L_0x00f5
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
        L_0x00f5:
            goto L_0x00c4
        L_0x00f6:
            r0 = move-exception
            goto L_0x010a
        L_0x00f8:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x00f6 }
            java.lang.String r12 = "Failed to load event from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00f6 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            goto L_0x00c4
        L_0x010a:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
        L_0x010e:
            if (r0 != r9) goto L_0x0146
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x012a }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x012a }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x012a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkz> r0 = com.google.android.gms.measurement.internal.zzkz.CREATOR     // Catch:{ ParseException -> 0x012a }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x012a }
            com.google.android.gms.measurement.internal.zzkz r0 = (com.google.android.gms.measurement.internal.zzkz) r0     // Catch:{ ParseException -> 0x012a }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            goto L_0x013c
        L_0x0128:
            r0 = move-exception
            goto L_0x0142
        L_0x012a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x0128 }
            java.lang.String r12 = "Failed to load user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x0128 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            r0 = r3
        L_0x013c:
            if (r0 == 0) goto L_0x0141
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
        L_0x0141:
            goto L_0x00c4
        L_0x0142:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
        L_0x0146:
            if (r0 != r11) goto L_0x017f
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x0162 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x0162 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0162 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzv> r0 = com.google.android.gms.measurement.internal.zzv.CREATOR     // Catch:{ ParseException -> 0x0162 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x0162 }
            com.google.android.gms.measurement.internal.zzv r0 = (com.google.android.gms.measurement.internal.zzv) r0     // Catch:{ ParseException -> 0x0162 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            goto L_0x0174
        L_0x0160:
            r0 = move-exception
            goto L_0x017b
        L_0x0162:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ all -> 0x0160 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x0160 }
            java.lang.String r12 = "Failed to load conditional user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x0160 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            r0 = r3
        L_0x0174:
            if (r0 == 0) goto L_0x0179
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
        L_0x0179:
            goto L_0x00c4
        L_0x017b:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
        L_0x017f:
            r11 = 3
            if (r0 != r11) goto L_0x0191
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            java.lang.String r11 = "Skipping app launch break"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            goto L_0x00c4
        L_0x0191:
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            java.lang.String r11 = "Unknown record type in local database"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x01a5, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01a0, all -> 0x01e9 }
            goto L_0x00c4
        L_0x01a0:
            r0 = move-exception
            r15 = r24
            goto L_0x0227
        L_0x01a5:
            r0 = move-exception
            r15 = r24
            goto L_0x0261
        L_0x01aa:
            java.lang.String r0 = "messages"
            java.lang.String r11 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x01f7, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01ef, all -> 0x01e9 }
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x01f7, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01ef, all -> 0x01e9 }
            r12[r6] = r13     // Catch:{ SQLiteFullException -> 0x01f7, SQLiteDatabaseLockedException -> 0x01f3, SQLiteException -> 0x01ef, all -> 0x01e9 }
            r13 = r24
            int r0 = r13.delete(r0, r11, r12)     // Catch:{ SQLiteFullException -> 0x01e7, SQLiteDatabaseLockedException -> 0x01e5, SQLiteException -> 0x01e3, all -> 0x01e1 }
            int r11 = r4.size()     // Catch:{ SQLiteFullException -> 0x01e7, SQLiteDatabaseLockedException -> 0x01e5, SQLiteException -> 0x01e3, all -> 0x01e1 }
            if (r0 >= r11) goto L_0x01cf
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ SQLiteFullException -> 0x01e7, SQLiteDatabaseLockedException -> 0x01e5, SQLiteException -> 0x01e3, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x01e7, SQLiteDatabaseLockedException -> 0x01e5, SQLiteException -> 0x01e3, all -> 0x01e1 }
            java.lang.String r11 = "Fewer entries removed from local database than expected"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x01e7, SQLiteDatabaseLockedException -> 0x01e5, SQLiteException -> 0x01e3, all -> 0x01e1 }
        L_0x01cf:
            r13.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01e7, SQLiteDatabaseLockedException -> 0x01e5, SQLiteException -> 0x01e3, all -> 0x01e1 }
            r13.endTransaction()     // Catch:{ SQLiteFullException -> 0x01e7, SQLiteDatabaseLockedException -> 0x01e5, SQLiteException -> 0x01e3, all -> 0x01e1 }
            if (r10 == 0) goto L_0x01db
            r10.close()
        L_0x01db:
            if (r13 == 0) goto L_0x01e0
            r13.close()
        L_0x01e0:
            return r4
        L_0x01e1:
            r0 = move-exception
            goto L_0x01ec
        L_0x01e3:
            r0 = move-exception
            goto L_0x0204
        L_0x01e5:
            r0 = move-exception
            goto L_0x021b
        L_0x01e7:
            r0 = move-exception
            goto L_0x020e
        L_0x01e9:
            r0 = move-exception
            r13 = r24
        L_0x01ec:
            r3 = r10
            goto L_0x027f
        L_0x01ef:
            r0 = move-exception
            r13 = r24
            goto L_0x0204
        L_0x01f3:
            r0 = move-exception
            r13 = r24
            goto L_0x021b
        L_0x01f7:
            r0 = move-exception
            r13 = r24
            goto L_0x020e
        L_0x01fb:
            r0 = move-exception
        L_0x01fc:
            r13 = r24
            goto L_0x027f
        L_0x0200:
            r0 = move-exception
            r13 = r24
            r10 = r3
        L_0x0204:
            r15 = r13
            goto L_0x0227
        L_0x0206:
            r0 = move-exception
            r13 = r24
            goto L_0x021a
        L_0x020a:
            r0 = move-exception
            r13 = r24
            r10 = r3
        L_0x020e:
            r15 = r13
            goto L_0x0261
        L_0x0211:
            r0 = move-exception
            goto L_0x027e
        L_0x0214:
            r0 = move-exception
            r13 = r15
        L_0x0216:
            r10 = r3
            goto L_0x0227
        L_0x0218:
            r0 = move-exception
            r13 = r15
        L_0x021a:
            r10 = r3
        L_0x021b:
            r15 = r13
            goto L_0x024d
        L_0x021d:
            r0 = move-exception
            r13 = r15
        L_0x021f:
            r10 = r3
            goto L_0x0261
        L_0x0221:
            r0 = move-exception
            r13 = r3
            goto L_0x027f
        L_0x0224:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x0227:
            if (r15 == 0) goto L_0x0232
            boolean r11 = r15.inTransaction()     // Catch:{ all -> 0x027c }
            if (r11 == 0) goto L_0x0232
            r15.endTransaction()     // Catch:{ all -> 0x027c }
        L_0x0232:
            com.google.android.gms.measurement.internal.zzfk r11 = r23.zzr()     // Catch:{ all -> 0x027c }
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzf()     // Catch:{ all -> 0x027c }
            r11.zza(r2, r0)     // Catch:{ all -> 0x027c }
            r1.zzb = r9     // Catch:{ all -> 0x027c }
            if (r10 == 0) goto L_0x0244
            r10.close()
        L_0x0244:
            if (r15 == 0) goto L_0x0278
            r15.close()
            goto L_0x0278
        L_0x024a:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x024d:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x027c }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x0258
            r10.close()
        L_0x0258:
            if (r15 == 0) goto L_0x0278
            r15.close()
            goto L_0x0278
        L_0x025e:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x0261:
            com.google.android.gms.measurement.internal.zzfk r11 = r23.zzr()     // Catch:{ all -> 0x027c }
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzf()     // Catch:{ all -> 0x027c }
            r11.zza(r2, r0)     // Catch:{ all -> 0x027c }
            r1.zzb = r9     // Catch:{ all -> 0x027c }
            if (r10 == 0) goto L_0x0273
            r10.close()
        L_0x0273:
            if (r15 == 0) goto L_0x0278
            r15.close()
        L_0x0278:
            int r7 = r7 + 1
            goto L_0x0021
        L_0x027c:
            r0 = move-exception
            r3 = r10
        L_0x027e:
            r13 = r15
        L_0x027f:
            if (r3 == 0) goto L_0x0284
            r3.close()
        L_0x0284:
            if (r13 == 0) goto L_0x0289
            r13.close()
        L_0x0289:
            throw r0
        L_0x028a:
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.zza(int):java.util.List");
    }

    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzad() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzd()
            r11.zzb()
            boolean r1 = r11.zzb
            r2 = 0
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            boolean r1 = r11.zzaf()
            if (r1 != 0) goto L_0x0015
            return r2
        L_0x0015:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0019:
            if (r3 >= r1) goto L_0x0095
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.zzae()     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            if (r5 != 0) goto L_0x002b
            r11.zzb = r6     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            if (r5 == 0) goto L_0x002a
            r5.close()
        L_0x002a:
            return r2
        L_0x002b:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0079, SQLiteDatabaseLockedException -> 0x006c, SQLiteException -> 0x004d }
            if (r5 == 0) goto L_0x004a
            r5.close()
        L_0x004a:
            return r6
        L_0x004b:
            r0 = move-exception
            goto L_0x008f
        L_0x004d:
            r7 = move-exception
            if (r5 == 0) goto L_0x0059
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x004b }
            if (r8 == 0) goto L_0x0059
            r5.endTransaction()     // Catch:{ all -> 0x004b }
        L_0x0059:
            com.google.android.gms.measurement.internal.zzfk r8 = r11.zzr()     // Catch:{ all -> 0x004b }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzf()     // Catch:{ all -> 0x004b }
            r8.zza(r0, r7)     // Catch:{ all -> 0x004b }
            r11.zzb = r6     // Catch:{ all -> 0x004b }
            if (r5 == 0) goto L_0x008c
            r5.close()
            goto L_0x008c
        L_0x006c:
            r6 = move-exception
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x004b }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x008c
            r5.close()
            goto L_0x008c
        L_0x0079:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzfk r8 = r11.zzr()     // Catch:{ all -> 0x004b }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzf()     // Catch:{ all -> 0x004b }
            r8.zza(r0, r7)     // Catch:{ all -> 0x004b }
            r11.zzb = r6     // Catch:{ all -> 0x004b }
            if (r5 == 0) goto L_0x008c
            r5.close()
        L_0x008c:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x008f:
            if (r5 == 0) goto L_0x0094
            r5.close()
        L_0x0094:
            throw r0
        L_0x0095:
            com.google.android.gms.measurement.internal.zzfk r0 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zza(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.zzad():boolean");
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, (String) null, (String) null, "rowid desc", DiskLruCache.VERSION_1);
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhp zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfd zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzix zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziw zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfg zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzkc zzk() {
        return super.zzk();
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
