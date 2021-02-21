package com.jovialway.bookexchange.NetWork;

import com.jovialway.bookexchange.AdBookPostModel.AdBookPostResponse;
import com.jovialway.bookexchange.ProfileUpdateModel.ProfileUpdateResponce;
import com.jovialway.bookexchange.RecyclerAddBook.AdBooKResponce;
import com.jovialway.bookexchange.RegisterModel.RegisterResponse;
import com.jovialway.bookexchange.loginModel.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("post/save_book")
    Call<AdBookPostResponse> adBookPostData(@Field("book_catagory") String str, @Field("book_name") String str2, @Field("description") String str3, @Field("book_writer") String str4, @Field("mobile") String str5, @Field("user_email") String str6, @Field("division") String str7, @Field("city") String str8, @Field("address") String str9, @Field("pablisher") String str10, @Field("user_id") String str11, @Field("roll") String str12, @Field("amounth") String str13);

    @FormUrlEncoded
    @POST("auth/profile_update/{id}")
    Call<ProfileUpdateResponce> profileUpdateData(@Path("id") int i, @Field("name") String str, @Field("email") String str2, @Field("address") String str3, @Field("mobile") String str4, @Field("user_profile_photo") String str5);

    @GET("post/show_book?page=")
    Call<AdBooKResponce> recylerViewData(@Query("page") String str);

    @FormUrlEncoded
    @POST("auth/user_login")
    Call<LoginResponse> userLogin(@Field("email") String str, @Field("password") String str2);

    @FormUrlEncoded
    @POST("auth/user_register")
    Call<RegisterResponse> userRegister(@Field("name") String str, @Field("email") String str2, @Field("mobile") String str3, @Field("password") String str4);
}
