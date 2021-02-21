package com.example.myapplication.networking;


import com.example.myapplication.AdPostRecylerViewResponce.AdRecylerViewResponse;
import com.example.myapplication.AdPostResponce.AdPostResponce;
import com.example.myapplication.CategoryRecyclerViewModel.CategoryRecyclerViewResponse;
import com.example.myapplication.MyPostRecylerViewModel.MyPostRecylerViewResponce;
import com.example.myapplication.ProfileModel.ProfileResponse;
import com.example.myapplication.ProfileUpdateModel.ProfileUpdateResponce;
import com.example.myapplication.RegisterModel.RegisterResponse;
import com.example.myapplication.loginModel.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("auth/user_login")
    Call<LoginResponse> userLogin(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/user_register")
    Call<RegisterResponse> userRegister(@Field("name") String name, @Field("email") String email , @Field("mobile") String mobile , @Field("password") String password);


//    @Headers({ "Content-Type: application/json;Accept: application/json"})
//    @POST("auth/user_profile")
//    Call<ProfileResponse> profileData(@Header("Authorization") String auth);



    @Headers({"Accept: application/json"})
    @POST("auth/user_profile")
    Call<ProfileResponse> profileData();

    @FormUrlEncoded
    @POST("post/save_ad")
    Call<AdPostResponce> adPostData(@Field("post_title") String post_title ,
                                    @Field("division") String division ,
                                    @Field("city") String city ,
                                    @Field("authority_types") String authority_types ,
                                    @Field("address") String address ,
                                    @Field("apartment_no") String apartment_no,
                                    @Field("rent_date") String rent_date,
                                    @Field("tenant") String tenant,
                                    @Field("description") String description,

                                    @Field("space_size") String space_size,
                                    @Field("renters") String renters,
                                    @Field("utility") String utility,

                                    @Field("category") String category,
                                    @Field("floor") String floor,

                                    @Field("bedroom") String bedroom,
                                    @Field("bathroom") String bathroom,
                                    @Field("balconi") String balconi,
                                    @Field("kitchen") String kitchen,
                                    @Field("dining_room") String dining_room,
                                    @Field("drawing_room") String drawing_room,
                                    @Field("garage") String garage,

                                    @Field("closing_time") String closing_time,
                                    @Field("opening_time") String opening_time,
                                    @Field("nearest_famous_place_one") String nearest_famous_place_one,
                                    @Field("nearest_famous_place_two") String nearest_famous_place_two,

                                    @Field("user_id") String user_id,

                                    @Field("mobile") String mobile );


    //@FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("post/show_ad")
    Call<AdRecylerViewResponse> recylerViewData();

    @FormUrlEncoded
    @POST("auth/profile_update")
    Call<ProfileUpdateResponce> profileUpdateData(@Field("name") String name,
                                                  @Field("email") String email,
                                                  @Field("address") String address);

    @Headers({"Accept: application/json"})
    @GET("post/show_my_post/{id}")
    Call<MyPostRecylerViewResponce> myPostData(@Path("id") int id);


    @Headers({"Accept: application/json"})
    @GET("post/show_ad_category/{category}")
    Call<CategoryRecyclerViewResponse> categoryPostData(@Path("category") String category);


}
