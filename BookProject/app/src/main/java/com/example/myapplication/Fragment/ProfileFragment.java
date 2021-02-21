package com.example.myapplication.Fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Activity.ProfileUpdate;
import com.example.myapplication.AdPostRecylerViewResponce.ActivePost;
import com.example.myapplication.Adapter.MyPostRecylerViewAdapter;
import com.example.myapplication.Adapter.ProfileTabViewAdapter;
import com.example.myapplication.MyPostRecylerViewModel.MyPost;
import com.example.myapplication.MyPostRecylerViewModel.MyPostRecylerViewResponce;
import com.example.myapplication.ProfileModel.ProfileResponse;
import com.example.myapplication.R;
import com.example.myapplication.networking.RetrofitClient;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    RecyclerView my_post_recyler_view;

    private MyPostRecylerViewResponce myPostRecylerViewResponce;
    private List<MyPost> myPostList = new ArrayList<>();

    String TAG="ProfileFragment ";
//    String TAG,auth="Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9oYWJpYjAxOS4wMDB3ZWJob3N0YXBwLmNvbVwvYXBpXC9hdXRoXC91c2VyX2xvZ2luIiwiaWF0IjoxNTgwNjYyODczLCJleHAiOjE1ODA2NjY0NzMsIm5iZiI6MTU4MDY2Mjg3MywianRpIjoiQ0VqQTFmZDdVc2VrWFQ5RiIsInN1YiI6MywicHJ2IjoiODdlMGFmMWVmOWZkMTU4MTJmZGVjOTcxNTNhMTRlMGIwNDc1NDZhYSJ9.lxhgKxjrN9K-AyXNhEqov0hkqxGSw3goZhy_ERLcOBU";
    String name,email,mobile,address;
    private Context context;
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_TOKEN = "keytoken";
    private static final String KEY_ID = "keyid";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_EMAIL = "keyeemail";
    private static final String KEY_ADDRESS = "keyeaddress";
    private static final String KEY_MOBILE = "keyemobile";
    String token,id;
    int Id;


    TextView userName,userEmail,userAddress,userNumber;
    ImageView profile_image;
    Button update_profile;

    TabLayout tabLayout;
    ViewPager viewPager;



    MyPostRecylerViewAdapter myPostRecylerViewAdapter;



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        token = sharedPreferences.getString(KEY_TOKEN, "");
        Id = sharedPreferences.getInt(KEY_ID,0);
        name = sharedPreferences.getString( KEY_NAME,"" );
        email = sharedPreferences.getString( KEY_EMAIL,"" );
        address = sharedPreferences.getString( KEY_ADDRESS,"" );
        mobile = sharedPreferences.getString( KEY_MOBILE,"" );
        Log.e(TAG, "onAttach: id"+Id );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);



         userName =(TextView)view.findViewById(R.id.userName);
         userEmail =(TextView)view.findViewById(R.id.userEmail);
         userAddress =(TextView)view.findViewById(R.id.userAddress);
         userNumber = (TextView)view.findViewById(R.id.userNumber);
         profile_image =(ImageView) view.findViewById(R.id.profile_image);

         update_profile = (Button) view.findViewById(R.id.update_profile);

        userName.setText( name );
        userEmail.setText( email );
        userAddress.setText( address );
        userNumber.setText( mobile );



        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);




        tabLayout.addTab(tabLayout.newTab().setText("My Add,s"));
        tabLayout.addTab(tabLayout.newTab().setText("Rent History"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ProfileTabViewAdapter adapter = new ProfileTabViewAdapter(getActivity(),getFragmentManager(), tabLayout.getTabCount());
        //Adding Fragment;
        adapter.AddFragment( new MyPostRecylerView(),"My Add,s" );
        adapter.AddFragment( new MyRentHistory(),"Rent History" );


        //set Addapter
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager( viewPager );
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




//
//        Call <ProfileResponse> call = RetrofitClient.getInstance(token).getApiInterface().profileData();
//        call.enqueue(new Callback <ProfileResponse>() {
//            @Override
//            public void onResponse(Call<ProfileResponse> call, Response <ProfileResponse> response) {
//                if (response.isSuccessful()) {
//                    Log.d(TAG, "onResponse: " + response.code());
//                    ProfileResponse profileResponse = response.body();
//                    if (profileResponse != null && profileResponse.getStatus() == 1) {
//
//                        Toast.makeText(getActivity(), profileResponse.getId().toString(), Toast.LENGTH_SHORT).show();
//
//                        name = profileResponse.getName();
//                        email = profileResponse.getEmail();
//                        mobile = profileResponse.getMobile();
//                        address = profileResponse.getAddress().toString();
//
//                        userName.setText( name );
//                        userEmail.setText( email );
//                        userAddress.setText( address );
//                        userNumber.setText( mobile );
//
//                    } else {
//                        Toast.makeText(getActivity(),profileResponse.getStatus(), Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Log.d(TAG, "onResponse: " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ProfileResponse> call, Throwable t) {
//                Toast.makeText(getActivity(),"Data Featching Faild", Toast.LENGTH_SHORT).show();
//            }
//
//
//        });



        update_profile.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( getContext(), ProfileUpdate.class );
                intent.putExtra("token", token);
                startActivity( intent );

            }
        } );

        return view;
    }


}
