package com.jovialway.bookexchange.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.C0198Fragment;
import com.google.android.material.tabs.TabLayout;
import com.jovialway.bookexchange.Activity.MainActivity;
import com.jovialway.bookexchange.Activity.SubscribeActivity;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.SessionClass.C1220SessionClass;

public class ProfileFragment extends C0198Fragment {
    private static final String KEY_ADDRESS = "keyeaddress";
    private static final String KEY_EMAIL = "keyeemail";
    private static final String KEY_MOBILE = "keyemobile";
    private static final String KEY_NAME = "keyname";
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    String TAG = "MainActivity:";
    String address;
    String email;
    TextView exchangeBook;
    Button logout;
    String mobile;
    String name;
    ImageView profile_image;
    ImageView subscribe;
    TabLayout tabLayout;
    TextView updatProfile;
    TextView userAddress;
    TextView userEmail;
    TextView userName;
    TextView userNumber;
    FrameLayout viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C1214R.layout.fragment_profile, container, false);
        this.updatProfile = (TextView) v.findViewById(C1214R.C1217id.updatProfile);
        this.exchangeBook = (TextView) v.findViewById(C1214R.C1217id.exchangeBook);
        this.subscribe = (ImageView) v.findViewById(C1214R.C1217id.subscribe);
        this.userName = (TextView) v.findViewById(C1214R.C1217id.userName);
        this.userEmail = (TextView) v.findViewById(C1214R.C1217id.userEmail);
        this.userAddress = (TextView) v.findViewById(C1214R.C1217id.userAddress);
        this.userNumber = (TextView) v.findViewById(C1214R.C1217id.userNumber);
        this.profile_image = (ImageView) v.findViewById(C1214R.C1217id.profile_image);
        this.logout = (Button) v.findViewById(C1214R.C1217id.logout);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, 0);
        this.name = sharedPreferences.getString(KEY_NAME, "");
        this.mobile = sharedPreferences.getString(KEY_MOBILE, "");
        this.email = sharedPreferences.getString(KEY_EMAIL, "");
        this.address = sharedPreferences.getString(KEY_ADDRESS, "");
        this.userName.setText(this.name);
        this.userEmail.setText(this.email);
        this.userAddress.setText(this.address);
        this.userNumber.setText(this.mobile);
        this.logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                C1220SessionClass.getInstance(ProfileFragment.this.getActivity().getApplicationContext()).logout();
                ProfileFragment.this.startActivity(new Intent(ProfileFragment.this.getContext(), MainActivity.class));
            }
        });
        this.subscribe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileFragment.this.startActivity(new Intent(ProfileFragment.this.getActivity(), SubscribeActivity.class));
            }
        });
        this.updatProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileFragment.this.getActivity().getSupportFragmentManager().beginTransaction().replace(C1214R.C1217id.container, new ProfileUpdate()).addToBackStack((String) null).commit();
            }
        });
        this.exchangeBook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileFragment.this.getActivity().getSupportFragmentManager().beginTransaction().replace(C1214R.C1217id.container, new PostBookFragment()).addToBackStack((String) null).commit();
            }
        });
        return v;
    }
}
