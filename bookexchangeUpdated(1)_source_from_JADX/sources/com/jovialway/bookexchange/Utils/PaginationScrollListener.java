package com.jovialway.bookexchange.Utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
    LinearLayoutManager layoutManager;

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();

    /* access modifiers changed from: protected */
    public abstract void loadMoreItems();

    public PaginationScrollListener(LinearLayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = this.layoutManager.getChildCount();
        int totalItemCount = this.layoutManager.getItemCount();
        int firstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        if (!isLoading() && !isLastPage() && visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= getTotalPageCount()) {
            loadMoreItems();
        }
    }
}
