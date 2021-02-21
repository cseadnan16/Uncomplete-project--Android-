package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Adapter.AdPostRecylerViewAdapter;
import com.example.myapplication.Adapter.CategoryRecylerViewAdapter;
import com.example.myapplication.Adapter.MyPostRecylerViewAdapter;
import com.example.myapplication.CategoryRecyclerViewModel.CategoryActivePost;
import com.example.myapplication.CategoryRecyclerViewModel.CategoryRecyclerViewResponse;
import com.example.myapplication.MyPostRecylerViewModel.MyPost;
import com.example.myapplication.MyPostRecylerViewModel.MyPostRecylerViewResponce;
import com.example.myapplication.R;
import com.example.myapplication.networking.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRecylerView extends AppCompatActivity {


    String category,token;
    RecyclerView ad_recyler_view;
    String TAG="CategoryRecylerView";

    CategoryRecylerViewAdapter categoryRecylerViewAdapter;
    RecyclerView myPostRecylerView;
    CategoryRecyclerViewResponse categoryRecyclerViewResponse;

    private List<CategoryActivePost> myPostList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.category_recyler_view);

        category = getIntent().getStringExtra("category");
        Log.e( TAG,"CategoryRecyclerViewResponseCategory : "+category);
        token = getIntent().getStringExtra("token");


        ad_recyler_view = findViewById( R.id.ad_recyler_view );

        categoryRecylerViewAdapter = new CategoryRecylerViewAdapter(CategoryRecylerView.this, myPostList );
        ad_recyler_view.setLayoutManager(new LinearLayoutManager(this));
        ad_recyler_view.setAdapter(categoryRecylerViewAdapter);



        fetchCategoryAd();




    }


    private void fetchCategoryAd() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

        Log.e( TAG,"CategoryRecyclerViewResponseToken"+token);


        Call<CategoryRecyclerViewResponse> call = RetrofitClient.getInstance(token).getApiInterface().categoryPostData(category);
        call.enqueue( new Callback <CategoryRecyclerViewResponse>() {
            @Override
            public void onResponse(Call <CategoryRecyclerViewResponse> call, Response <CategoryRecyclerViewResponse> response) {
                categoryRecyclerViewResponse = response.body();
                if (response.isSuccessful()){
                    myPostList = categoryRecyclerViewResponse.getCategoryActivePosts();
                    categoryRecylerViewAdapter.updateList( myPostList );

                    Log.e( TAG,"CategoryRecyclerViewResponse"+myPostList.size() );

                    Toast.makeText(CategoryRecylerView.this, "Ok", Toast.LENGTH_SHORT ).show();

                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call <CategoryRecyclerViewResponse> call, Throwable t) {
                Toast.makeText( CategoryRecylerView.this, "Fail", Toast.LENGTH_SHORT ).show();
                progressDialog.dismiss();

            }
        } );
    }
}
