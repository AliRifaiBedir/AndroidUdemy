package com.example.retrofit_ornek_4_parametreli_stek.RestApi;

import com.example.retrofit_ornek_4_parametreli_stek.Models.Bilgi;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager{
    private static ManagerAll ourInstance=new ManagerAll();
    //ManagerAll'dan nesne ürerrik

    public static synchronized ManagerAll getirInstance(){
        //Bu metodla ManagerAll döndürdük
        return ourInstance;
    }
    public Call<List<Bilgi>> getirCall(){
        Call<List<Bilgi>> x=getRestApiClient().getir();
        return x;

    }


}

