package com.example.retrofit_ornek_2.RestApi;

import com.example.retrofit_ornek_2.Models.Bilgi;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends  BaseManager {
    private static ManagerAll ourInstance=new ManagerAll();
    //Instance değer döndüüyroz amacımız activyde bunun nesnesini olustumadan almak için

    public static synchronized  ManagerAll getInstance(){
        return  ourInstance;
    }
    public Call<List<Bilgi>> getirBilgi(){
        Call<List<Bilgi>> x=getRestpiClient().getir();
        return x;
    }
}
