package com.example.retrofitktphanesinikurulumu.RestApi;

import com.example.retrofitktphanesinikurulumu.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends  BaseManager {

    private  static ManagerAll ourInstance=new ManagerAll();
    public  static synchronized ManagerAll getInstance()
    {
        return  ourInstance;
    }
    public Call<List<Bilgiler>> getirBilgiler(){
        Call<List<Bilgiler>> call=getRestApiClient().bilgiGetir();
        return call;
    }


}
