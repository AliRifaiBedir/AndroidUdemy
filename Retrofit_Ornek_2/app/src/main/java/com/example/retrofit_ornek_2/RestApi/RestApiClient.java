package com.example.retrofit_ornek_2.RestApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {
    private  RestApi mRestApi;

    public RestApiClient(String restApiServiceUrl){
        OkHttpClient.Builder builder=new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .connectTimeout(3,TimeUnit.SECONDS);


        OkHttpClient okHttpClient=builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mRestApi=retrofit.create(RestApi.class);

    }

    public RestApi getRestApi() {
        return  mRestApi;
    }
}
