package com.example.retrofitktphanesinikurulumu.RestApi;

import com.example.retrofitktphanesinikurulumu.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/posts")//İlgili siteini URL aldık böylece

    Call<List<Bilgiler>> bilgiGetir();
    //Burada Bilgiler türünde bir list döndürecek bu metod
    //Yani Bilgiler.getuserID ver dicez gibi düşün
    //bilgiGetir() metodu çalıştıerıdığında isteği yapacak yani




}
