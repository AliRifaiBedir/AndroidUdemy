package com.example.retrofit_ornek_3.RestApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {
    //Bize bu kod bir interface döndürüyor

    private  RestApi mRestApi;

    public RestApiClient(String restApiServiceUrl){
        //Burada alınan url ile  gerekli işlemleri yaptıktan sonra interface dönüyor
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

    public RestApi getRestApi()
    {
        return  mRestApi;
    }
}
