package com.jovialway.bookexchange.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.C0198Fragment;
import com.jovialway.bookexchange.AdBookPostModel.AdBookPostResponse;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.NetWork.RetrofitClient;
import java.util.Arrays;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostBookFragment extends C0198Fragment {
    private static final String KEY_EMAIL = "keyeemail";
    private static final String KEY_ID = "keyid";
    private static final String KEY_MOBILE = "keyemobile";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_TOKEN = "keytoken";
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    String Address;
    String BookName;
    String Catagory;
    String City;
    String Currency;
    String Discription;
    String Division;
    String Email;

    /* renamed from: Id */
    int f123Id;
    String Mobile;
    String Name;
    String Publisher;
    String Roll;
    String TAG = "PostAdFragment ";
    String UserId;
    String Writer;
    EditText address;
    EditText book_name;
    /* access modifiers changed from: private */
    public Context context;
    EditText currency;
    EditText discription;
    Spinner divspinner;
    EditText publisher;
    Spinner spenner_catagory;
    EditText spenner_roll;
    Spinner subdivspnr;
    Button submit;
    String token;
    EditText writer;

    public void onAttach(Context context2) {
        this.context = context2;
        super.onAttach(context2);
        SharedPreferences sharedPreferences = context2.getSharedPreferences(SHARED_PREF_NAME, 0);
        this.token = sharedPreferences.getString(KEY_TOKEN, "");
        this.f123Id = sharedPreferences.getInt(KEY_ID, 0);
        this.Name = sharedPreferences.getString(KEY_NAME, "");
        this.Email = sharedPreferences.getString(KEY_EMAIL, "");
        this.Mobile = sharedPreferences.getString(KEY_MOBILE, "");
        String str = this.TAG;
        Log.e(str, "onAttach: " + this.token);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C1214R.layout.fragment_post_book, container, false);
        this.book_name = (EditText) view.findViewById(C1214R.C1217id.book_name);
        this.writer = (EditText) view.findViewById(C1214R.C1217id.writer);
        this.publisher = (EditText) view.findViewById(C1214R.C1217id.publisher);
        this.discription = (EditText) view.findViewById(C1214R.C1217id.discription);
        this.address = (EditText) view.findViewById(C1214R.C1217id.address);
        this.currency = (EditText) view.findViewById(C1214R.C1217id.currency);
        this.spenner_catagory = (Spinner) view.findViewById(C1214R.C1217id.spenner_catagory);
        this.divspinner = (Spinner) view.findViewById(C1214R.C1217id.divspinner);
        this.subdivspnr = (Spinner) view.findViewById(C1214R.C1217id.subdivspnr);
        this.spenner_roll = (EditText) view.findViewById(C1214R.C1217id.spenner_roll);
        this.submit = (Button) view.findViewById(C1214R.C1217id.submit);
        List<String> divisions = Arrays.asList(getResources().getStringArray(C1214R.array.divisions));
        List<String> barisal = Arrays.asList(getResources().getStringArray(C1214R.array.barisal));
        List<String> chattogram = Arrays.asList(getResources().getStringArray(C1214R.array.chattogram));
        List<String> dhaka = Arrays.asList(getResources().getStringArray(C1214R.array.dhaka));
        List<String> khulna = Arrays.asList(getResources().getStringArray(C1214R.array.khulna));
        List<String> mymensingh = Arrays.asList(getResources().getStringArray(C1214R.array.mymensingh));
        List<String> rajshahi = Arrays.asList(getResources().getStringArray(C1214R.array.rajshahi));
        List<String> rangpur = Arrays.asList(getResources().getStringArray(C1214R.array.rangpur));
        List<String> sylhet = Arrays.asList(getResources().getStringArray(C1214R.array.sylhet));
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), 17367043, getResources().getStringArray(C1214R.array.catagory));
        arrayAdapter.setDropDownViewResource(17367050);
        this.spenner_catagory.setAdapter(arrayAdapter);
        this.spenner_catagory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PostBookFragment.this.Catagory = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter adapter = new ArrayAdapter(getContext(), 17367049, divisions);
        this.divspinner.setAdapter(adapter);
        this.divspinner.setSelection(0);
        this.subdivspnr.setSelection(0);
        final List<String> list = barisal;
        final List<String> list2 = chattogram;
        final List<String> list3 = dhaka;
        final List<String> list4 = khulna;
        C11972 r11 = r0;
        final List<String> list5 = mymensingh;
        Spinner spinner = this.divspinner;
        final List<String> list6 = rajshahi;
        ArrayAdapter arrayAdapter2 = adapter;
        final List<String> list7 = rangpur;
        ArrayAdapter arrayAdapter3 = arrayAdapter;
        final List<String> list8 = sylhet;
        C11972 r0 = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PostBookFragment.this.Division = parent.getItemAtPosition(position).toString();
                if (PostBookFragment.this.Division.equals("Barisal")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list));
                }
                if (PostBookFragment.this.Division.equals("Chattogram")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list2));
                }
                if (PostBookFragment.this.Division.equals("Dhaka")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list3));
                }
                if (PostBookFragment.this.Division.equals("Khulna")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list4));
                }
                if (PostBookFragment.this.Division.equals("Mymensingh")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list5));
                }
                if (PostBookFragment.this.Division.equals("Rajshahi")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list6));
                }
                if (PostBookFragment.this.Division.equals("Rangpur")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list7));
                }
                if (PostBookFragment.this.Division.equals("Sylhet")) {
                    PostBookFragment.this.subdivspnr.setAdapter(new ArrayAdapter<>(PostBookFragment.this.context, 17367049, list8));
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        spinner.setOnItemSelectedListener(r11);
        this.subdivspnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PostBookFragment.this.City = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PostBookFragment postBookFragment = PostBookFragment.this;
                postBookFragment.BookName = postBookFragment.book_name.getText().toString();
                PostBookFragment postBookFragment2 = PostBookFragment.this;
                postBookFragment2.Writer = postBookFragment2.writer.getText().toString();
                PostBookFragment postBookFragment3 = PostBookFragment.this;
                postBookFragment3.Publisher = postBookFragment3.publisher.getText().toString();
                PostBookFragment postBookFragment4 = PostBookFragment.this;
                postBookFragment4.Discription = postBookFragment4.discription.getText().toString();
                PostBookFragment postBookFragment5 = PostBookFragment.this;
                postBookFragment5.Address = postBookFragment5.address.getText().toString();
                PostBookFragment postBookFragment6 = PostBookFragment.this;
                postBookFragment6.Currency = postBookFragment6.currency.getText().toString();
                PostBookFragment postBookFragment7 = PostBookFragment.this;
                postBookFragment7.Roll = postBookFragment7.spenner_roll.getText().toString();
                PostBookFragment postBookFragment8 = PostBookFragment.this;
                postBookFragment8.UserId = Integer.toString(postBookFragment8.f123Id);
                if (PostBookFragment.this.BookName.equals("")) {
                    PostBookFragment.this.book_name.requestFocus();
                    PostBookFragment.this.book_name.setError("Book Name Needed");
                } else if (PostBookFragment.this.Writer.equals("")) {
                    PostBookFragment.this.writer.requestFocus();
                    PostBookFragment.this.writer.setError("It's Essential");
                } else if (PostBookFragment.this.Publisher.equals("")) {
                    PostBookFragment.this.publisher.requestFocus();
                    PostBookFragment.this.publisher.setError("It's Essential");
                } else if (PostBookFragment.this.Discription.equals("")) {
                    PostBookFragment.this.discription.requestFocus();
                    PostBookFragment.this.discription.setError("Write a Short Descripion");
                } else if (PostBookFragment.this.Currency.equals("")) {
                    PostBookFragment.this.currency.requestFocus();
                    PostBookFragment.this.currency.setError("Selling Amount  ");
                } else {
                    RetrofitClient.getInstance(PostBookFragment.this.token).getApiInterface().adBookPostData(PostBookFragment.this.Catagory, PostBookFragment.this.BookName, PostBookFragment.this.Discription, PostBookFragment.this.Writer, PostBookFragment.this.Mobile, PostBookFragment.this.Email, PostBookFragment.this.Division, PostBookFragment.this.City, PostBookFragment.this.Address, PostBookFragment.this.Publisher, PostBookFragment.this.UserId, PostBookFragment.this.Roll, PostBookFragment.this.Currency).enqueue(new Callback<AdBookPostResponse>() {
                        public void onResponse(Call<AdBookPostResponse> call, Response<AdBookPostResponse> response) {
                            if (response.isSuccessful()) {
                                AdBookPostResponse adBookPostResponse = response.body();
                                if (adBookPostResponse == null || adBookPostResponse.getStatus().intValue() != 1) {
                                    Toast.makeText(PostBookFragment.this.getActivity(), adBookPostResponse.getStatus().intValue(), 0).show();
                                } else {
                                    Toast.makeText(PostBookFragment.this.getActivity(), adBookPostResponse.getSuccess().toString(), 0).show();
                                }
                            } else {
                                String str = PostBookFragment.this.TAG;
                                Log.d(str, "onResponse: " + response.code());
                            }
                        }

                        public void onFailure(Call<AdBookPostResponse> call, Throwable t) {
                            Toast.makeText(PostBookFragment.this.getActivity(), t.getLocalizedMessage(), 0).show();
                            String str = PostBookFragment.this.TAG;
                            Log.e(str, "onFailure: " + t.getLocalizedMessage());
                        }
                    });
                }
            }
        });
        return view;
    }
}
