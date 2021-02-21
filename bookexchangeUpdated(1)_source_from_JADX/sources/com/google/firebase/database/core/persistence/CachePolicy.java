package com.google.firebase.database.core.persistence;

import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface CachePolicy {
    public static final CachePolicy NONE = new CachePolicy() {
        public boolean shouldPrune(long currentSizeBytes, long countOfPrunableQueries) {
            return false;
        }

        public boolean shouldCheckCacheSize(long serverUpdatesSinceLastCheck) {
            return false;
        }

        public float getPercentOfQueriesToPruneAtOnce() {
            return 0.0f;
        }

        public long getMaxNumberOfQueriesToKeep() {
            return LongCompanionObject.MAX_VALUE;
        }
    };

    long getMaxNumberOfQueriesToKeep();

    float getPercentOfQueriesToPruneAtOnce();

    boolean shouldCheckCacheSize(long j);

    boolean shouldPrune(long j, long j2);
}
