package com.example.retrofit_ornek_2.RestApi;

import com.example.retrofit_ornek_2.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/todos")
    Call<List<Bilgi>> getir();
}
