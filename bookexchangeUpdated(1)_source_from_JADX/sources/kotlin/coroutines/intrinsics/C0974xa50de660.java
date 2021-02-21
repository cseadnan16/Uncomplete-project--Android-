package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo20368bv = {1, 0, 3}, mo20369d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo20370d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, mo20371k = 1, mo20372mv = {1, 1, 15})
/* renamed from: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1 */
/* compiled from: IntrinsicsJvm.kt */
public final class C0974xa50de660 extends RestrictedContinuationImpl {
    final /* synthetic */ Continuation $completion;
    final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
    private int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0974xa50de660(Continuation $captured_local_variable$1, Continuation $super_call_param$2, Function1 function1) {
        super($super_call_param$2);
        this.$completion = $captured_local_variable$1;
        this.$this_createCoroutineUnintercepted$inlined = function1;
    }

    /* access modifiers changed from: protected */
    public Object invokeSuspend(Object result) {
        int i = this.label;
        if (i == 0) {
            this.label = 1;
            ResultKt.throwOnFailure(result);
            Continuation it = this;
            Function1 function1 = this.$this_createCoroutineUnintercepted$inlined;
            if (function1 != null) {
                return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(it);
            }
            throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } else if (i == 1) {
            this.label = 2;
            ResultKt.throwOnFailure(result);
            return result;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
