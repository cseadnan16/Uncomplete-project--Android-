package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class DefaultClock implements Clock {
    public long millis() {
        return System.currentTimeMillis();
    }
}
