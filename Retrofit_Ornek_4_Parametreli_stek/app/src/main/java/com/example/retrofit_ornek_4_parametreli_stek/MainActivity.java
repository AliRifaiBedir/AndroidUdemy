package com.example.retrofit_ornek_4_parametreli_stek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.retrofit_ornek_4_parametreli_stek.Models.Bilgi;
import com.example.retrofit_ornek_4_parametreli_stek.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import Adapters.BilgiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> list;
    BilgiAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        istek();
    }

    public  void istek(){
        list=new ArrayList<>();
        Call<List<Bilgi>> call= ManagerAll.getirInstance().getirCall();
        call.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()){
                    list=response.body();
                    adapter=new BilgiAdapter(list,getApplicationContext(),MainActivity.this);
                    listView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }


}