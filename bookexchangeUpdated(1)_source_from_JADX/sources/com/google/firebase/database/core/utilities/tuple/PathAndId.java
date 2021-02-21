package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class PathAndId {

    /* renamed from: id */
    private long f69id;
    private Path path;

    public PathAndId(Path path2, long id) {
        this.path = path2;
        this.f69id = id;
    }

    public Path getPath() {
        return this.path;
    }

    public long getId() {
        return this.f69id;
    }
}
