package com.example.myapplication.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.Adapter.MyPostRecylerViewAdapter;
import com.example.myapplication.MyPostRecylerViewModel.MyPost;
import com.example.myapplication.MyPostRecylerViewModel.MyPostRecylerViewResponce;
import com.example.myapplication.R;
import com.example.myapplication.networking.RetrofitClient;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyPostRecylerView extends Fragment {

    String TAG="MyPostRecylerViewFragment ";
    private Context context;
    private Context mCobtext;
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_TOKEN = "keytoken";
    private static final String KEY_ID = "keyid";
    String token;
    int id;

    MyPostRecylerViewAdapter myPostRecylerViewAdapter;
    RecyclerView myPostRecylerView;
    MyPostRecylerViewResponce myPostRecylerViewResponce;

    private List <MyPost> myPostList =new ArrayList <>();




    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        token = sharedPreferences.getString(KEY_TOKEN, "");
        id = sharedPreferences.getInt(KEY_ID,0);
        Log.e(TAG, "MyPostID: "+token );

    }


    public MyPostRecylerView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.my_post_recyler_view_fragment, container, false);

        myPostRecylerView = (RecyclerView)view.findViewById( R.id.my_post_recyler_view );

        myPostRecylerViewAdapter = new MyPostRecylerViewAdapter(getContext(),myPostList);
        myPostRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myPostRecylerView.setAdapter(myPostRecylerViewAdapter);


        fetchMyAd();

        return view;
    }

    private void fetchMyAd() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading.....");
        progressDialog.show();


        Call<MyPostRecylerViewResponce> call = RetrofitClient.getInstance(token).getApiInterface().myPostData( id );
        call.enqueue( new Callback <MyPostRecylerViewResponce>() {
            @Override
            public void onResponse(Call <MyPostRecylerViewResponce> call, Response <MyPostRecylerViewResponce> response) {
                myPostRecylerViewResponce = response.body();
                if (response.isSuccessful()){
                    myPostList = myPostRecylerViewResponce.getMyPosts();
                    myPostRecylerViewAdapter.updateList( myPostList );

                    Toast.makeText( getContext(), "Ok", Toast.LENGTH_SHORT ).show();

                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call <MyPostRecylerViewResponce> call, Throwable t) {
                Toast.makeText( getContext(), "Fail", Toast.LENGTH_SHORT ).show();
                progressDialog.dismiss();

            }
        } );

    }

}
