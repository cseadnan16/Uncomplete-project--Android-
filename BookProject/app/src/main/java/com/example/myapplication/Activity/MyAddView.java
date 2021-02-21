package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

public class MyAddView extends AppCompatActivity {

    ImageView featured_image;
    TextView address;
    Button update;
    TextView id,apartment_no,rent_date,tenant,status;
    TextView description,space_size,renters,utility,category,floor;
    LinearLayout extra_information;
    TextView bedroom,bathroom,balconi,kitchen,dining_room,drawing_room,garage;
    TextView closing_time,opening_time,nearest_famous_place_one,nearest_famous_place_two;

    String Address,ApartmentNo,RentDate,Tenant,Description,SpaceSize,Renters,Utility,Category,Floor,Bedroom,Bathroom,Balconi,Kitchen,DiningRoom,DrawingRoom,Garage,ClosingTime,OpeningTime,NearestFamousPlaceOne,NearestFamousPlaceTwo,FeaturedImage,PostTitle,Division,City,Role;
    int Id;
    String Status;

    String Tag = "MyAdPostView";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_add_view );


        featured_image = findViewById( R.id.featured_image );
        address = findViewById( R.id.address );


        id = findViewById( R.id.id );
        status = findViewById( R.id.status );
        apartment_no = findViewById( R.id.apartment_no );
        rent_date = findViewById( R.id.rent_date );
        tenant = findViewById( R.id.tenant );

        description = findViewById( R.id.description );
        space_size = findViewById( R.id.space_size );
        renters = findViewById( R.id.renters );
        utility = findViewById( R.id.utility );
        category = findViewById( R.id.category );
        floor = findViewById( R.id.floor );

        extra_information = findViewById( R.id.extra_information );
        bedroom = findViewById( R.id.bedroom );
        bathroom = findViewById( R.id.bathroom );
        balconi = findViewById( R.id.balconi );
        kitchen = findViewById( R.id.kitchen );
        dining_room = findViewById( R.id.dining_room );
        drawing_room = findViewById( R.id.drawing_room );
        garage = findViewById( R.id.garage );

        closing_time = findViewById( R.id.closing_time );
        opening_time = findViewById( R.id.opening_time );
        nearest_famous_place_one = findViewById( R.id.nearest_famous_place_one );
        nearest_famous_place_two = findViewById( R.id.nearest_famous_place_two );
        update = findViewById( R.id.update );

        Address = getIntent().getStringExtra("address");

        Id = getIntent().getIntExtra("ad_id", 0);

        PostTitle = getIntent().getStringExtra("post_title");
        Division =  getIntent().getStringExtra("division");
        City =  getIntent().getStringExtra("city");
        Role =  getIntent().getStringExtra("authority_types");

        ApartmentNo = getIntent().getStringExtra("apartment_no");
        RentDate = getIntent().getStringExtra("rent_date");
        Tenant = getIntent().getStringExtra("tenant");

        Description = getIntent().getStringExtra("description");
        SpaceSize = getIntent().getStringExtra("space_size");
        Renters = getIntent().getStringExtra("renters");
        Utility = getIntent().getStringExtra("utility");
        Category = getIntent().getStringExtra("category");
        Floor = getIntent().getStringExtra("floor");

        Bedroom = getIntent().getStringExtra("bedroom");
        Bathroom = getIntent().getStringExtra("bathroom");
        Balconi = getIntent().getStringExtra("balconi");
        Kitchen = getIntent().getStringExtra("kitchen");
        DiningRoom = getIntent().getStringExtra("dining_room");
        DrawingRoom = getIntent().getStringExtra("drawing_room");
        Garage = getIntent().getStringExtra("garage");

        ClosingTime = getIntent().getStringExtra("closing_time");
        OpeningTime = getIntent().getStringExtra("opening_time");
        NearestFamousPlaceOne = getIntent().getStringExtra("nearest_famous_place_one");
        NearestFamousPlaceTwo = getIntent().getStringExtra("nearest_famous_place_two");

        FeaturedImage = getIntent().getStringExtra("featured_image");

        Status = getIntent().getStringExtra("Status");

        Log.e( Tag,"Status Equal" + Status);


        address.setText( Address );


        id.setText( "Ad Code No : #"+Id );
        status.setText( Status );
        apartment_no.setText( "Apartment No : "+ApartmentNo );
        rent_date.setText( "Rent last Date : "+RentDate );
        tenant.setText( "Tenant type : "+Tenant );

        description.setText( Description );
        space_size.setText( "Property Spice size :"+SpaceSize+"ft2" );
        renters.setText( "Renters Amount :"+Renters+"tk" );
        utility.setText( "Utility Amount :"+Utility+"tk" );
        category.setText( "Post Category :"+Category);
        floor.setText( "Floor :"+Floor);


        if(Category.equals( "Apartment" ) || Category.equals( "Flat" ))
        {
            extra_information.setVisibility( View.GONE );
        }else {
            extra_information.setVisibility( View.VISIBLE );
        }


        bedroom.setText( "Bedroom :"+Bedroom);
        bathroom.setText( "Bathroom :"+Bathroom);
        balconi.setText( "Balconi :"+Balconi);

        if (Kitchen.equals( "1" ))
        {
            kitchen.setText( "Kitchen : Available");
        }else {
            kitchen.setText( "Kitchen : Unavailable");
        }

        if (DiningRoom.equals( "1" )){
            dining_room.setText( "Dining Room : Available" );
        }else {
            dining_room.setText( "Dining Room : Unavailable" );
        }

        if (DrawingRoom.equals( "1" )){
            drawing_room.setText( "Drawing Room : Available" );
        }else {
            dining_room.setText( "Drawing Room : Unavailable" );
        }

        if (Garage.equals( "1" )){
            garage.setText( "Garage : Available" );
        }else {
            garage.setText( "Garage : Unavailable" );
        }

        opening_time.setText( "Opening Time : "+OpeningTime );
        closing_time.setText( "Closing Time : "+ClosingTime );
        nearest_famous_place_one.setText( "Nearest famous place from property :"+NearestFamousPlaceOne );
        nearest_famous_place_two.setText( "Nearest famous place from property :"+NearestFamousPlaceTwo );



        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.image_load_bg).error(R.drawable.image_load_bg);
        Glide.with(this).load(FeaturedImage).apply(requestOptions).into(featured_image);


//        if (Status.equals(1))
//        {
//            update.setVisibility( View.VISIBLE );
//        }else {
//            update.setVisibility( View.GONE );
//        }

        update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent( MyAddView.this,MyAdUpdate.class );
//                intent.putExtra("Add_id",Id);
//
//                intent.putExtra( "featured_image",FeaturedImage);
//                startActivity( intent );
            }
        } );

    }
}
