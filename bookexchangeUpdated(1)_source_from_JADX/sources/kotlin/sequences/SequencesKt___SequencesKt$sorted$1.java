package kotlin.sequences;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, mo20370d2 = {"kotlin/sequences/SequencesKt___SequencesKt$sorted$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, mo20371k = 1, mo20372mv = {1, 1, 15})
/* compiled from: _Sequences.kt */
public final class SequencesKt___SequencesKt$sorted$1 implements Sequence<T> {
    final /* synthetic */ Sequence $this_sorted;

    SequencesKt___SequencesKt$sorted$1(Sequence<? extends T> $receiver) {
        this.$this_sorted = $receiver;
    }

    public Iterator<T> iterator() {
        List sortedList = SequencesKt.toMutableList(this.$this_sorted);
        CollectionsKt.sort(sortedList);
        return sortedList.iterator();
    }
}
