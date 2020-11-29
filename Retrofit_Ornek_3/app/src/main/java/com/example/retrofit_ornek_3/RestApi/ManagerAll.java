package com.example.retrofit_ornek_3.RestApi;

import com.example.retrofit_ornek_3.Models.Bilgi;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    //Burada kendi dönecek çünkü mainactivyde burdaki metodlara erişmek için
    private  static  ManagerAll ourgetInstance=new ManagerAll();
    //Nesnesini olusturmayacağımız için static verdik

    //Bu metod bu sınıfı döndürecek ManagerAll sınıfını
    public static synchronized ManagerAll getInstance(){
        return  ourgetInstance;
    }

    //Burada ise url de dönecek olan list şeklinde metopdu tanımladık
    public Call<List<Bilgi>> getirBilgi(){
        Call<List<Bilgi>> x=getRestApiClient().getir();
        return x;


    }

}
