package com.jovialway.bookexchange.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.C0198Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jovialway.bookexchange.Adapter.AdBookRecylerViewAdapter;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.NetWork.ApiInterface;
import com.jovialway.bookexchange.NetWork.RetrofitClient;
import com.jovialway.bookexchange.RecyclerAddBook.AdBooKResponce;
import com.jovialway.bookexchange.RecyclerAddBook.Book;
import com.jovialway.bookexchange.Utils.PaginationScrollListener;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends C0198Fragment {
    private static final String KEY_ID = "keyid";
    private static final String KEY_TOKEN = "keytoken";
    private static final int PAGE_START = 1;
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    RecyclerView AdRecylerView;
    String TAG = "BookAdFragment ";
    /* access modifiers changed from: private */
    public int TOTAL_PAGES = 5;
    /* access modifiers changed from: private */
    public AdBooKResponce adBooKResponce;
    AdBookRecylerViewAdapter adBookRecylerViewAdapter;
    private ApiInterface apiInterface;
    private Context context;
    /* access modifiers changed from: private */
    public int currentPage = 1;
    /* access modifiers changed from: private */
    public boolean isLastPage = false;
    /* access modifiers changed from: private */
    public boolean isLoading = false;
    LinearLayoutManager linearLayoutManager;
    private Context mCobtext;
    /* access modifiers changed from: private */
    public List<Book> postList = new ArrayList();
    ProgressBar progressBar;
    ProgressBar progress_bar_pagination;
    String token;

    public void onAttach(Context context2) {
        this.context = context2;
        super.onAttach(context2);
        this.token = context2.getSharedPreferences(SHARED_PREF_NAME, 0).getString(KEY_TOKEN, "");
        String str = this.TAG;
        Log.e(str, "onAttach: " + this.token);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C1214R.layout.fragment_home, container, false);
        this.linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        ProgressBar progressBar2 = (ProgressBar) view.findViewById(C1214R.C1217id.progress_bar_pagination);
        this.progress_bar_pagination = progressBar2;
        progressBar2.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C1214R.C1217id.ad_recyler_view);
        this.AdRecylerView = recyclerView;
        recyclerView.setVisibility(0);
        this.adBookRecylerViewAdapter = new AdBookRecylerViewAdapter(getContext(), this.postList);
        this.AdRecylerView.setLayoutManager(this.linearLayoutManager);
        this.AdRecylerView.setItemAnimator(new DefaultItemAnimator());
        this.AdRecylerView.setAdapter(this.adBookRecylerViewAdapter);
        this.AdRecylerView.addOnScrollListener(new PaginationScrollListener(this.linearLayoutManager) {
            /* access modifiers changed from: protected */
            public void loadMoreItems() {
                boolean unused = HomeFragment.this.isLoading = true;
                HomeFragment homeFragment = HomeFragment.this;
                int unused2 = homeFragment.currentPage = homeFragment.currentPage + 1;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        HomeFragment.this.progress_bar_pagination.setVisibility(0);
                        HomeFragment.this.loadNextPage();
                    }
                }, 1000);
            }

            public int getTotalPageCount() {
                return HomeFragment.this.TOTAL_PAGES;
            }

            public boolean isLastPage() {
                return HomeFragment.this.isLastPage;
            }

            public boolean isLoading() {
                return HomeFragment.this.isLoading;
            }
        });
        fetchAd();
        return view;
    }

    private void fetchAd() {
        Log.d(this.TAG, "loadFirstPage: ");
        String page = String.valueOf(this.currentPage);
        String str = this.TAG;
        Log.e(str, "PageBBB: " + page);
        String str2 = this.TAG;
        Log.e(str2, "TokenAA: " + this.token);
        RetrofitClient.getInstance(this.token).getApiInterface().recylerViewData(page).enqueue(new Callback<AdBooKResponce>() {
            public void onResponse(Call<AdBooKResponce> call, Response<AdBooKResponce> response) {
                AdBooKResponce unused = HomeFragment.this.adBooKResponce = response.body();
                if (response.isSuccessful()) {
                    HomeFragment homeFragment = HomeFragment.this;
                    List unused2 = homeFragment.postList = homeFragment.adBooKResponce.getBooks();
                    String str = HomeFragment.this.TAG;
                    Log.e(str, "onResponse: " + HomeFragment.this.adBooKResponce.toString());
                    HomeFragment.this.adBookRecylerViewAdapter.updateList(HomeFragment.this.postList);
                    if (HomeFragment.this.currentPage <= HomeFragment.this.TOTAL_PAGES) {
                        HomeFragment.this.adBookRecylerViewAdapter.addLoadingFooter();
                    } else {
                        boolean unused3 = HomeFragment.this.isLastPage = true;
                    }
                    String str2 = HomeFragment.this.TAG;
                    Log.e(str2, "onResponseAAA: " + HomeFragment.this.postList.size() + " ");
                }
            }

            public void onFailure(Call<AdBooKResponce> call, Throwable t) {
            }
        });
    }

    /* access modifiers changed from: private */
    public List<Book> fetchResults(Response<AdBooKResponce> response) {
        return response.body().getBooks();
    }

    /* access modifiers changed from: private */
    public void loadNextPage() {
        String str = this.TAG;
        Log.d(str, "loadNextPage: " + this.currentPage);
        RetrofitClient.getInstance(this.token).getApiInterface().recylerViewData(String.valueOf(this.currentPage)).enqueue(new Callback<AdBooKResponce>() {
            public void onResponse(Call<AdBooKResponce> call, Response<AdBooKResponce> response) {
                HomeFragment.this.adBookRecylerViewAdapter.removeLoadingFooter();
                boolean unused = HomeFragment.this.isLoading = false;
                HomeFragment.this.adBookRecylerViewAdapter.addAll(HomeFragment.this.fetchResults(response));
                if (HomeFragment.this.currentPage != HomeFragment.this.TOTAL_PAGES) {
                    HomeFragment.this.adBookRecylerViewAdapter.addLoadingFooter();
                } else {
                    boolean unused2 = HomeFragment.this.isLastPage = true;
                }
                HomeFragment.this.progress_bar_pagination.setVisibility(8);
            }

            public void onFailure(Call<AdBooKResponce> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
