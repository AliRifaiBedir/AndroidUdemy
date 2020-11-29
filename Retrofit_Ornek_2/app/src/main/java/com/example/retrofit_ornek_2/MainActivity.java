package com.example.retrofit_ornek_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofit_ornek_2.Adapters.BilgiAdapter;
import com.example.retrofit_ornek_2.Models.Bilgi;
import com.example.retrofit_ornek_2.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> bilgiList;
    ListView list_view;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view=findViewById(R.id.list_view);
        istek();
    }

    public  void istek(){
        bilgiList=new ArrayList<>();
        Call<List<Bilgi>> listCall= ManagerAll.getInstance().getirBilgi();
        listCall.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()){
                    bilgiList=response.body();
                    BilgiAdapter adapter=new BilgiAdapter(bilgiList,context);
                    list_view.setAdapter(adapter);
                }


            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }

}