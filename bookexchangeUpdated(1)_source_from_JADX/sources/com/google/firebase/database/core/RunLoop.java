package com.google.firebase.database.core;

import java.util.concurrent.ScheduledFuture;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface RunLoop {
    void restart();

    ScheduledFuture schedule(Runnable runnable, long j);

    void scheduleNow(Runnable runnable);

    void shutdown();
}
