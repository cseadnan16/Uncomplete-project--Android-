package com.example.myapplication.Fragment;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.AdPostResponce.AdPostResponce;
import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.R;
import com.example.myapplication.networking.RetrofitClient;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddPostFragment extends Fragment {

    LinearLayout addMainInformation,LayoutTwo,user_other_information,Show;
    EditText address,apartment_no,description,space_size,utility_edit_text,floor_edit_text,renters_text,post_title,city,post_code;

    Spinner renters_spiner,category_spiner,division_spiner,role_spiner;
    Spinner bedroom_spiner,bathroom_spiner,balconi_spiner;
    CheckBox kitchen_box,dining_box,drawing_box,garage_box;
    TextView rent_date_piker,showText;
    Button next_one,back,next;

    String RenteDate,RentersItem,CategoryItem,Address,Apartment_no,Description,SpaceSize,Utilitytext,Floor,RentersAmounth,PostTitle,City,PostCode,DivisionSpiner,RoleSpiner;
    String BedroomData,BathroomData,BalconiData,KitchenData,DiningData,DrawingData,GarageData;

    String ClosingTime,OpeningTime,TotalClosingTime,TotalOpeningTime;
    String NearestAddressOne,NearestAddressTwo,Mobile,UserID;

    DatePickerDialog.OnDateSetListener mDateSetListener;

    EditText closing_hour,closing_minute,opening_hour,opening_minute,address_one,address_two,nMobile;
    Spinner closing_day_spiner,opening_day_spiner;
    Button back_one,submit,change;




    private Context context;
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_TOKEN = "keytoken";
    private static final String KEY_ID = "keyid";
    String token;
    String TAG="AddPostFragment ";




    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        token = sharedPreferences.getString(KEY_TOKEN, "");
        //token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvaGFiaWIwMTkuMDAwd2ViaG9zdGFwcC5jb21cL2FwaVwvYXV0aFwvdXNlcl9sb2dpbiIsImlhdCI6MTU4MjYxODg0OSwiZXhwIjoxNTgyNjIyNDQ5LCJuYmYiOjE1ODI2MTg4NDksImp0aSI6IkswUkdCTUIzd2ZTejFpbmoiLCJzdWIiOjMsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.enBfxs2ocRdl4Zg3sy4R181YFk7p62sk0mreGjnMiEg";
        Log.e(TAG, "onAttach: "+token );
    }


    public AddPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_add_post, container, false);

        addMainInformation =(LinearLayout) view.findViewById(R.id.addMainInformation);
        LayoutTwo =(LinearLayout) view.findViewById(R.id.LayoutTwo);
        user_other_information =(LinearLayout) view.findViewById(R.id.user_other_information);


        post_title =(EditText) view.findViewById(R.id.post_title);
        city =(EditText) view.findViewById(R.id.city);
        post_code =(EditText) view.findViewById(R.id.post_code);

        address =(EditText) view.findViewById(R.id.address);
        apartment_no =(EditText) view.findViewById(R.id.apartment_no);
        description =(EditText) view.findViewById(R.id.description);
        space_size =(EditText) view.findViewById(R.id.space_size);
        utility_edit_text =(EditText) view.findViewById(R.id.utility_edit_text);
        renters_text =(EditText) view.findViewById(R.id.renters_text);
        floor_edit_text =(EditText) view.findViewById(R.id.floor_edit_text);


        closing_hour =(EditText) view.findViewById(R.id.closing_hour);
        closing_minute =(EditText) view.findViewById(R.id.closing_minute);
        opening_hour =(EditText) view.findViewById(R.id.opening_hour);
        opening_minute =(EditText) view.findViewById(R.id.opening_minute);
        address_one =(EditText) view.findViewById(R.id.address_one);
        address_two =(EditText) view.findViewById(R.id.address_two);
        nMobile = (EditText) view.findViewById(R.id.mobile);


        renters_spiner =(Spinner) view.findViewById(R.id.renters_spiner);
        category_spiner =(Spinner) view.findViewById(R.id.category_spiner);

        division_spiner =(Spinner) view.findViewById(R.id.division_spiner);
        role_spiner =(Spinner) view.findViewById(R.id.role_spiner);

        category_spiner =(Spinner) view.findViewById(R.id.category_spiner);

        bedroom_spiner =(Spinner) view.findViewById(R.id.bedroom_spiner);
        bathroom_spiner =(Spinner) view.findViewById(R.id.bathroom_spiner);
        balconi_spiner =(Spinner) view.findViewById(R.id.balconi_spiner);

        closing_day_spiner =(Spinner) view.findViewById(R.id.closing_day_spiner);
        opening_day_spiner =(Spinner) view.findViewById(R.id.opening_day_spiner);

        kitchen_box =(CheckBox) view.findViewById(R.id.kitchen_box);
        dining_box =(CheckBox) view.findViewById(R.id.dining_box);
        drawing_box =(CheckBox) view.findViewById(R.id.drawing_box);
        garage_box =(CheckBox) view.findViewById(R.id.garage_box);

        //show =(TextView) view.findViewById(R.id.show);

        rent_date_piker =(TextView) view.findViewById(R.id.rent_date_piker);
        next_one =(Button) view.findViewById(R.id.next_one);
        back =(Button) view.findViewById(R.id.back);
        next =(Button) view.findViewById(R.id.next);

        back_one =(Button) view.findViewById(R.id.back_one);
        submit =(Button) view.findViewById(R.id.submit);


        ArrayAdapter<String> rentTypeAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.renters_type));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        renters_spiner.setAdapter(rentTypeAdapter);
        renters_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RentersItem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> DivisionAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.divisions));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        division_spiner.setAdapter(DivisionAdapter);
        division_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DivisionSpiner = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> RoleAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.role));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        role_spiner.setAdapter(RoleAdapter);
        role_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RoleSpiner = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> chatagoryTypeAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.category_type));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        category_spiner.setAdapter(chatagoryTypeAdapter);
        category_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CategoryItem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> BedroomAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.number));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        bedroom_spiner.setAdapter(BedroomAdapter);
        bedroom_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BedroomData = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> BathroomAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.number));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        bathroom_spiner.setAdapter(BathroomAdapter);
        bathroom_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BathroomData = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> BalconiAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.number));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        balconi_spiner.setAdapter(BalconiAdapter);
        balconi_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BalconiData = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> ClosingTimeAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        closing_day_spiner.setAdapter(ClosingTimeAdapter);
        closing_day_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ClosingTime = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> OpeningTimeAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        opening_day_spiner.setAdapter(OpeningTimeAdapter);
        opening_day_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                OpeningTime = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rent_date_piker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCalendar = Calendar.getInstance();
                int day = mCalendar.get(Calendar.DAY_OF_MONTH);
                int month = mCalendar.get(Calendar.MONTH);
                int year = mCalendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(),
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        day,month,year);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                RenteDate = dayOfMonth+"/"+month+"/"+year;
                rent_date_piker.setText(RenteDate);

            }
        };

        next_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMainInformation.setVisibility(View.GONE);

                 PostTitle =post_title.getText().toString().trim();
                 City = city.getText().toString().trim();
                 PostCode = post_code.getText().toString().trim();
                 Address = address.getText().toString().trim();
                 Description = description.getText().toString().trim();
                 SpaceSize = space_size.getText().toString().trim();
                 Utilitytext = utility_edit_text.getText().toString().trim();
                 Floor = floor_edit_text.getText().toString().trim();
                 RentersAmounth = renters_text.getText().toString().trim();

                //show.setText(Address+"  "+Apartment_no+"  "+Description+"  "+SpaceSize+"  "+Utilitytext+"   "+Floor+"  "+CategoryItem+"  "+"  "+RentersItem+"  "+RenteDate);

                if(Address.equals("") && Apartment_no.equals("") && Description.equals("") && SpaceSize.equals("") && Utilitytext.equals("") && Floor.equals("")){
                    Toast.makeText(getContext(), "Please.Enter your all information", Toast.LENGTH_SHORT).show();
                    addMainInformation.setVisibility(View.VISIBLE);
                }else
                {
                    if (CategoryItem.equals("Apartment") || CategoryItem.equals("Duplex") )
                    {
                        LayoutTwo.setVisibility(View.VISIBLE);

                    }
                    else {
                        Apartment_no = null;
                        BedroomData = "0";
                        BathroomData = "0";
                        BalconiData = "0";
                        KitchenData = "0";
                        DiningData = "0";
                        DrawingData = "0";
                        GarageData = "0";

                        user_other_information.setVisibility(View.VISIBLE);

                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMainInformation.setVisibility(View.VISIBLE);
                LayoutTwo.setVisibility(View.GONE);

                post_title.setText( PostTitle );
                city.setText( City );
                post_code.setText( PostCode );
                address.setText(Address);
//                apartment_no.setText(Apartment_no);
                description.setText(Description);
                space_size.setText(SpaceSize);
                utility_edit_text.setText(Utilitytext);
                floor_edit_text.setText(Floor);
                rent_date_piker.setText(RenteDate);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutTwo.setVisibility(View.GONE);
                user_other_information.setVisibility(View.VISIBLE);

                Apartment_no = apartment_no.getText().toString().trim();

                if(!kitchen_box.isChecked()){
                    KitchenData = "1";
                }else
                {
                    KitchenData = "0";
                }

                if (!dining_box.isChecked()){
                    DiningData = "1";
                }else
                {
                    DiningData = "0";
                }

                if (!drawing_box.isChecked()){
                    DrawingData = "1";
                }else {
                    DrawingData = "0";
                }
                if (!garage_box.isChecked()){
                    GarageData = "1";
                }else {
                    GarageData = "0";
                }
            }
        });

        back_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CategoryItem.equals("Apartment") || CategoryItem.equals("Duplex") )
                {
                    LayoutTwo.setVisibility(View.VISIBLE);
                    user_other_information.setVisibility(View.GONE);

                }
                else {
                    addMainInformation.setVisibility(View.VISIBLE);
                    user_other_information.setVisibility(View.GONE);
                }


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String ClosingHour = closing_hour.getText().toString().trim();
                String ClosingMinute = closing_minute.getText().toString().trim();

                String OpeningHour = opening_hour.getText().toString().trim();
                String OpeningMinute = opening_minute.getText().toString().trim();


                TotalClosingTime = ClosingHour+":"+ClosingMinute+" "+ClosingTime;
                TotalOpeningTime = OpeningHour+":"+OpeningMinute+" "+OpeningTime;


                NearestAddressOne = address_one.getText().toString().trim();
                NearestAddressTwo = address_two.getText().toString().trim();

                Mobile = nMobile.getText().toString().trim();





                /*showText.setText(RenteDate+"  "+RentersItem+" "+Address+" "+Apartment_no+" "+Description+" "+SpaceSize+" "+Utilitytext+" "+Floor
                        +" "+BedroomData+" "+BathroomData+" "+BalconiData+" "+KitchenData+" "+DiningData+" "+DrawingData+" "+GarageData+" "+TotalClosingTime
                        +" "+TotalOpeningTime+" "+NearestAddressOne+" "+NearestAddressTwo);*/

                SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                int user_id = sharedPreferences.getInt(KEY_ID,0);
                UserID = String.valueOf(user_id);

                Call<AdPostResponce> call = RetrofitClient.getInstance(token).getApiInterface().adPostData(PostTitle,DivisionSpiner,City,RoleSpiner,Address ,Apartment_no,RenteDate,RentersItem,Description,SpaceSize, RentersAmounth,Utilitytext,
                        CategoryItem,Floor,BedroomData,BathroomData,BalconiData,KitchenData,DiningData,DrawingData,GarageData,
                        TotalClosingTime,TotalOpeningTime,NearestAddressOne,NearestAddressTwo,UserID,Mobile);
                call.enqueue(new Callback<AdPostResponce>() {
                    @Override
                    public void onResponse(Call<AdPostResponce> call, Response<AdPostResponce> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse: " + response.code());
                            AdPostResponce adPostResponce = response.body();
                            if (adPostResponce != null && adPostResponce.getStatus() == 1) {

                                Toast.makeText(getActivity(), adPostResponce.getSuccess().toString(), Toast.LENGTH_SHORT).show();

                                post_title.setText( null );
                                city.setText( null );
                                post_code.setText( null );


                                address.setText(null);
                                apartment_no.setText(null);
                                description.setText(null);
                                space_size.setText(null);
                                utility_edit_text.setText(null);
                                floor_edit_text.setText(null);

                                closing_hour.setText(null);
                                closing_minute.setText(null);
                                opening_hour.setText(null);
                                opening_minute.setText(null);
                                address_one.setText(null);
                                address_two.setText(null);

                                PostTitle = null;
                                City = null;
                                PostCode = null;
                                DivisionSpiner = null;
                                RoleSpiner = null;
                                RenteDate = null;
                                RentersItem = null;
                                Address = null;
                                Apartment_no = null;
                                Description = null;
                                SpaceSize = null;
                                Utilitytext = null;
                                Floor = null;

                                BedroomData = null;
                                BathroomData = null;
                                BalconiData = null;
                                KitchenData = null;
                                DiningData = null;
                                DrawingData = null;
                                GarageData = null;

                                ClosingTime = null;
                                OpeningTime = null;
                                TotalClosingTime = null;
                                TotalOpeningTime = null;

                                NearestAddressOne = null;
                                NearestAddressTwo = null;

                                ((AppCompatActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContiner, new HomeFragment()).commit();





                            } else {
                                Toast.makeText(getActivity(),adPostResponce.getStatus(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.d(TAG, "onResponse: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<AdPostResponce> call, Throwable t) {
                        Toast.makeText(getActivity(),"Data Featching Faild", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });







        return view;
    }


}
