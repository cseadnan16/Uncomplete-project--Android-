package com.jovialway.bookexchange.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jovialway.bookexchange.Activity.BookDetailsActivity;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.RecyclerAddBook.Book;
import java.util.List;

public class AdBookRecylerViewAdapter extends RecyclerView.C0354Adapter<MyViewHolder> {
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    String TAG = "AdPostRecylerViewAdapter";
    private RecyclerView.ViewHolder holder;
    private boolean isLoadingAdded = false;
    /* access modifiers changed from: private */
    public Context mContext;
    private int position;
    /* access modifiers changed from: private */
    public List<Book> postList;

    public AdBookRecylerViewAdapter(Context mContext2, List<Book> postList2) {
        this.mContext = mContext2;
        this.postList = postList2;
    }

    public List<Book> getMovies() {
        return this.postList;
    }

    public void setActivePost(List<Book> ActivePostResult) {
        this.postList = ActivePostResult;
    }

    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new MyViewHolder(inflater.inflate(C1214R.layout.book_ad_item, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder2, int position2) {
        holder2.ad_date.setText(this.postList.get(position2).getCreatedAt());
        holder2.book_name.setText(this.postList.get(position2).getBookName());
        holder2.writer.setText(this.postList.get(position2).getBookWriter());
        holder2.publisher.setText(this.postList.get(position2).getPablisher());
        RequestManager with = Glide.with(this.mContext);
        with.load("http://bookexchange.againwish.com" + this.postList.get(position2).getBookImage()).into(holder2.f122iv);
    }

    public int getItemCount() {
        String str = this.TAG;
        Log.e(str, "getItemCount: " + this.postList.size());
        List<Book> list = this.postList;
        if (list == null) {
            return 0;
        }
        return list.size() - 1;
    }

    public int getItemViewType(int position2) {
        return (position2 != this.postList.size() - 1 || !this.isLoadingAdded) ? 0 : 1;
    }

    public void add(Book r) {
        this.postList.add(r);
        notifyItemInserted(this.postList.size() - 1);
    }

    public void addAll(List<Book> moveResults) {
        for (Book result : moveResults) {
            add(result);
        }
    }

    public void remove(Book r) {
        int position2 = this.postList.indexOf(r);
        if (position2 > -1) {
            this.postList.remove(position2);
            notifyItemRemoved(position2);
        }
    }

    public void clear() {
        this.isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoadingFooter() {
        this.isLoadingAdded = true;
        add(new Book());
    }

    public void removeLoadingFooter() {
        this.isLoadingAdded = false;
        int position2 = this.postList.size() - 1;
        if (getItem(position2) != null) {
            this.postList.remove(position2);
            notifyItemRemoved(position2);
        }
    }

    public Book getItem(int position2) {
        return this.postList.get(position2);
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(this.mContext).inflate(C1214R.layout.book_ad_item, parent, false));
        viewHolder.ad_book_item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdBookRecylerViewAdapter.this.mContext, BookDetailsActivity.class);
                intent.putExtra("ad_id", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getId());
                intent.putExtra("bookName", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getBookName());
                intent.putExtra("writer", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getBookWriter());
                intent.putExtra("category", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getBookCatagory());
                intent.putExtra("publisher", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getPablisher());
                intent.putExtra("description", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getDescription());
                intent.putExtra("exchangeWith", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getRoll());
                intent.putExtra(FirebaseAnalytics.Param.CURRENCY, ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getAmounth());
                intent.putExtra("date", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getCreatedAt());
                intent.putExtra("dev", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getDivision());
                intent.putExtra("subdev", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getCity());
                intent.putExtra("adrs", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getAddress());
                intent.putExtra("mobile", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getMobile());
                intent.putExtra("mail", ((Book) AdBookRecylerViewAdapter.this.postList.get(viewHolder.getAdapterPosition())).getUserEmail());
                AdBookRecylerViewAdapter.this.mContext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        FrameLayout ad_book_item;
        TextView ad_date;
        TextView book_name;

        /* renamed from: iv */
        ImageView f122iv;
        TextView publisher;
        TextView writer;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.ad_book_item = (FrameLayout) itemView.findViewById(C1214R.C1217id.ad_book_item);
            this.ad_date = (TextView) itemView.findViewById(C1214R.C1217id.ad_date);
            this.book_name = (TextView) itemView.findViewById(C1214R.C1217id.book_name);
            this.writer = (TextView) itemView.findViewById(C1214R.C1217id.writer);
            this.publisher = (TextView) itemView.findViewById(C1214R.C1217id.publisher);
            this.f122iv = (ImageView) itemView.findViewById(C1214R.C1217id.f129iv);
        }
    }

    public void updateList(List<Book> postList2) {
        this.postList = postList2;
        notifyDataSetChanged();
    }

    public void removedLastEmptyItem() {
        int position2 = this.postList.size();
        if (getItem(position2) != null) {
            this.postList.remove(position2);
            notifyItemRemoved(position2);
        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder {
        public LoadingVH(View itemView) {
            super(itemView);
        }
    }
}
