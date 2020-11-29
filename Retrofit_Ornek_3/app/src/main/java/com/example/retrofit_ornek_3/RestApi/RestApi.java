package com.example.retrofit_ornek_3.RestApi;

import com.example.retrofit_ornek_3.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/photos")
    Call<List<Bilgi>> getir();
    //Interfac ayarlıyoruz

}
