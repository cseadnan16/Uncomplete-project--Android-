package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzff extends SQLiteOpenHelper {
    private final /* synthetic */ zzfg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzff(zzfg zzfg, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzfg;
    }

    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException e2) {
            this.zza.zzr().zzf().zza("Opening the local database failed, dropping and recreating it");
            if (!this.zza.zzn().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zza.zzr().zzf().zza("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e3) {
                this.zza.zzr().zzf().zza("Failed to open local database. Events will bypass local storage", e3);
                return null;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 15
            if (r0 >= r1) goto L_0x001e
            r0 = 0
            java.lang.String r1 = "PRAGMA journal_mode=memory"
            android.database.Cursor r0 = r8.rawQuery(r1, r0)     // Catch:{ all -> 0x0017 }
            r0.moveToFirst()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x001e
            r0.close()
            goto L_0x001e
        L_0x0017:
            r8 = move-exception
            if (r0 == 0) goto L_0x001d
            r0.close()
        L_0x001d:
            throw r8
        L_0x001e:
            com.google.android.gms.measurement.internal.zzfg r0 = r7.zza
            com.google.android.gms.measurement.internal.zzfk r1 = r0.zzr()
            r6 = 0
            java.lang.String r3 = "messages"
            java.lang.String r4 = "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)"
            java.lang.String r5 = "type,entry"
            r2 = r8
            com.google.android.gms.measurement.internal.zzag.zza(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzff.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzag.zza(this.zza.zzr(), sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
