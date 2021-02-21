package com.jovialway.bookexchange.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.C0198Fragment;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.Model.SessionData;
import com.jovialway.bookexchange.NetWork.RetrofitClient;
import com.jovialway.bookexchange.ProfileUpdateModel.ProfileUpdateResponce;
import com.jovialway.bookexchange.SessionClass.C1220SessionClass;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileUpdate extends C0198Fragment {
    private static final String KEY_ADDRESS = "keyeaddress";
    private static final String KEY_EMAIL = "keyeemail";
    private static final String KEY_ID = "keyid";
    private static final String KEY_MOBILE = "keyemobile";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_PROFILE_IMAGE = "keyeprofileimage";
    private static final String KEY_TOKEN = "keytoken";
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    String Address;
    String Email;

    /* renamed from: Id */
    int f124Id;
    String Mobile;
    String Name;
    String ProfileImage;
    String TAG = "ProfileUpdate";
    TextView Token;
    EditText address;
    ImageButton back;
    private Bitmap bitmap;
    Button bottonUpdate;
    LinearLayout buttons;
    private Context context;
    EditText email;
    String encodedImage;
    String imageString;
    ImageView profile_image;
    ProgressBar progress_bar;
    String token;
    EditText user_name;

    public void onAttach(Context context2) {
        this.context = context2;
        super.onAttach(context2);
        SharedPreferences sharedPreferences = context2.getSharedPreferences(SHARED_PREF_NAME, 0);
        this.token = sharedPreferences.getString(KEY_TOKEN, "");
        this.f124Id = sharedPreferences.getInt(KEY_ID, 0);
        this.Name = sharedPreferences.getString(KEY_NAME, "");
        this.Email = sharedPreferences.getString(KEY_EMAIL, "");
        this.Mobile = sharedPreferences.getString(KEY_MOBILE, "");
        String str = this.TAG;
        Log.e(str, "onAttach: " + this.token);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C1214R.layout.fragment_profile_update, container, false);
        this.user_name = (EditText) view.findViewById(C1214R.C1217id.user_name);
        this.email = (EditText) view.findViewById(C1214R.C1217id.email);
        this.bottonUpdate = (Button) view.findViewById(C1214R.C1217id.bottonUpdate);
        this.address = (EditText) view.findViewById(C1214R.C1217id.address);
        this.profile_image = (ImageView) view.findViewById(C1214R.C1217id.profile_image);
        this.user_name.setText(this.Name);
        this.email.setText(this.Email);
        this.address.setText(this.Address);
        this.buttons = (LinearLayout) view.findViewById(C1214R.C1217id.buttons);
        ProgressBar progressBar = (ProgressBar) view.findViewById(C1214R.C1217id.progress_bar);
        this.progress_bar = progressBar;
        progressBar.setVisibility(8);
        this.profile_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileUpdate.this.chooseFile();
            }
        });
        this.bottonUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileUpdate.this.buttons.setVisibility(8);
                ProfileUpdate.this.progress_bar.setVisibility(0);
                ProfileUpdate profileUpdate = ProfileUpdate.this;
                profileUpdate.Name = profileUpdate.user_name.getText().toString();
                ProfileUpdate profileUpdate2 = ProfileUpdate.this;
                profileUpdate2.Email = profileUpdate2.email.getText().toString();
                ProfileUpdate profileUpdate3 = ProfileUpdate.this;
                profileUpdate3.Address = profileUpdate3.address.getText().toString();
                RetrofitClient.getInstance(ProfileUpdate.this.token).getApiInterface().profileUpdateData(ProfileUpdate.this.f124Id, ProfileUpdate.this.Name, ProfileUpdate.this.Email, ProfileUpdate.this.Address, ProfileUpdate.this.Mobile, ProfileUpdate.this.imageString).enqueue(new Callback<ProfileUpdateResponce>() {
                    public void onResponse(Call<ProfileUpdateResponce> call, Response<ProfileUpdateResponce> response) {
                        if (response.isSuccessful()) {
                            ProfileUpdateResponce profileUpdateResponce = response.body();
                            if (profileUpdateResponce == null || profileUpdateResponce.getStatus().intValue() != 1) {
                                Toast.makeText(ProfileUpdate.this.getContext(), "Error", 0).show();
                                ProfileUpdate.this.buttons.setVisibility(0);
                                ProfileUpdate.this.progress_bar.setVisibility(8);
                                return;
                            }
                            String str = ProfileUpdate.this.TAG;
                            Log.e(str, "Name: " + ProfileUpdate.this.Name);
                            String str2 = ProfileUpdate.this.TAG;
                            Log.e(str2, "Email: " + ProfileUpdate.this.Email);
                            String str3 = ProfileUpdate.this.TAG;
                            Log.e(str3, "Address: " + ProfileUpdate.this.Address);
                            Toast.makeText(ProfileUpdate.this.getContext(), "Profile Update", 0).show();
                            ProfileUpdate.this.ProfileImage = profileUpdateResponce.getUser().getUserProfilePhoto().toString();
                            SessionData sessionData = new SessionData();
                            sessionData.setName(ProfileUpdate.this.Name);
                            sessionData.setEmail(ProfileUpdate.this.Email);
                            sessionData.setAddress(ProfileUpdate.this.Address);
                            sessionData.setToken(ProfileUpdate.this.token);
                            sessionData.setMobile(ProfileUpdate.this.Mobile);
                            sessionData.setId(ProfileUpdate.this.f124Id);
                            sessionData.setProfile_image(ProfileUpdate.this.ProfileImage);
                            C1220SessionClass.getInstance(ProfileUpdate.this.getActivity().getApplicationContext()).userLogin(sessionData);
                            ProfileUpdate.this.buttons.setVisibility(0);
                            ProfileUpdate.this.progress_bar.setVisibility(8);
                            return;
                        }
                        Toast.makeText(ProfileUpdate.this.getContext(), "", 0).show();
                        ProfileUpdate.this.buttons.setVisibility(0);
                        ProfileUpdate.this.progress_bar.setVisibility(8);
                    }

                    public void onFailure(Call<ProfileUpdateResponce> call, Throwable t) {
                        ProfileUpdate.this.buttons.setVisibility(0);
                        ProfileUpdate.this.progress_bar.setVisibility(8);
                    }
                });
            }
        });
        return view;
    }

    /* access modifiers changed from: private */
    public void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1 && data != null && data.getData() != null) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                this.bitmap = bitmap2;
                this.profile_image.setImageBitmap(bitmap2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.imageString = getStringImage(this.bitmap);
            String str = this.TAG;
            Log.e(str, "Image_sTRING: " + this.imageString);
        }
    }

    public String getStringImage(Bitmap bitmap2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        this.encodedImage = encodeToString;
        return encodeToString;
    }
}
