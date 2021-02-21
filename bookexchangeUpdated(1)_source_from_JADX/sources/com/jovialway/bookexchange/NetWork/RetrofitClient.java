package com.jovialway.bookexchange.NetWork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://bookexchange.againwish.com/api/";
    private static RetrofitClient retrofitClient;
    private ApiInterface apiInterface;
    Gson gson = new GsonBuilder().setLenient().create();
    private Retrofit retrofit;

    /* renamed from: retrofit2  reason: collision with root package name */
    Retrofit f160retrofit2 = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(this.gson)).build();

    private RetrofitClient() {
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        this.retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(new OkHttpClient.Builder().callTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).build()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    private RetrofitClient(final String token) {
        this.retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();
                return chain.proceed(newBuilder.addHeader("Authorization", "bearer" + token).build());
            }
        }).build()).build();
    }

    public static synchronized RetrofitClient getInstance() {
        RetrofitClient retrofitClient2;
        synchronized (RetrofitClient.class) {
            if (retrofitClient == null) {
                retrofitClient = new RetrofitClient();
            }
            retrofitClient2 = retrofitClient;
        }
        return retrofitClient2;
    }

    public static synchronized RetrofitClient getInstance(String token) {
        RetrofitClient retrofitClient2;
        synchronized (RetrofitClient.class) {
            retrofitClient2 = new RetrofitClient(token);
        }
        return retrofitClient2;
    }

    public ApiInterface getApiInterface() {
        return (ApiInterface) this.retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApiInterface2() {
        return (ApiInterface) this.f160retrofit2.create(ApiInterface.class);
    }
}
