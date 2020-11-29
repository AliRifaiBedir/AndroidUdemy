package com.example.retrofitktphanesinikurulumu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.retrofitktphanesinikurulumu.Models.Bilgiler;
import com.example.retrofitktphanesinikurulumu.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgiler> list;
    ListView listView;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listViewİD);
        istek();
    }

    public void istek(){
        list=new ArrayList<>();
        Call<List<Bilgiler>> bilgiList= ManagerAll.getInstance().getirBilgiler();
        bilgiList.enqueue(new Callback<List<Bilgiler>>() {//Burada istek attık
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
                if (response.isSuccessful()){
                    list=response.body();
                    adapter adp=new adapter(list,context);
                    listView.setAdapter(adp);





                }

            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {

            }
        });

    }


}