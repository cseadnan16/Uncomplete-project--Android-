package com.example.myapplication.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.AdPostRecylerViewResponce.ActivePost;
import com.example.myapplication.AdPostRecylerViewResponce.AdRecylerViewResponse;
import com.example.myapplication.Adapter.AdPostRecylerViewAdapter;
import com.example.myapplication.R;
import com.example.myapplication.networking.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView AdRecylerView;
    
    AdPostRecylerViewAdapter adPostRecylerViewAdapter;
    ProgressDialog progressDialog;

    EditText search;


    private List<ActivePost> postList=new ArrayList<>();
    private AdRecylerViewResponse recylerViewResponse;


    public HomeFragment() {
        // Required empty public constructor
    }


    String TAG="AddPostFragment ";
    private Context context;
    private Context mCobtext;
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_TOKEN = "keytoken";
    private static final String KEY_ID = "keyid";
    String token;
   // String TAG="AddPostFragment ";




    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        token = sharedPreferences.getString(KEY_TOKEN, "");
        Log.e(TAG, "onAttach: "+token );

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, parent, false);

        AdRecylerView = view.findViewById(R.id.ad_recyler_view);

        adPostRecylerViewAdapter = new AdPostRecylerViewAdapter(getContext(),postList);
        AdRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdRecylerView.setAdapter(adPostRecylerViewAdapter);


        search = view.findViewById( R.id.doctor_search );

        search.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        } );

        fetchAd();

         return view;
    }

    private void filter(String text) {
        ArrayList<ActivePost> newList = new ArrayList <>(  );
        for (ActivePost itemList : postList)
        {
            if (itemList.getAddress().toLowerCase().contains(text.toLowerCase())) {
                newList.add(itemList);
            }
        }
        adPostRecylerViewAdapter.updateList(newList);
    }


    private void fetchAd() {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

        Call<AdRecylerViewResponse> call = RetrofitClient.getInstance(token).getApiInterface().recylerViewData();
            call.enqueue(new Callback<AdRecylerViewResponse>() {
                @Override
                public void onResponse(Call<AdRecylerViewResponse> call, Response<AdRecylerViewResponse> response) {
                    recylerViewResponse = response.body();
                    if (response.isSuccessful()){
                        postList=recylerViewResponse.getActivePosts();
                        adPostRecylerViewAdapter.updateList(postList);
                        Log.e(TAG, "onResponse: "+postList.size()+" " );

                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<AdRecylerViewResponse> call, Throwable t) {

                }
            });
        }

}
