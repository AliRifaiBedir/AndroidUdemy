package com.example.retrofit_ornek_4_parametreli_stek.RestApi;

import com.example.retrofit_ornek_4_parametreli_stek.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/comments")
    Call<List<Bilgi>> getir();
    //getir adlı metodolusturduk
}
