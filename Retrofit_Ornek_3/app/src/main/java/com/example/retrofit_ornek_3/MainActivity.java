package com.example.retrofit_ornek_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.retrofit_ornek_3.Adapters.BilgiAdapter;
import com.example.retrofit_ornek_3.Models.Bilgi;
import com.example.retrofit_ornek_3.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        istek();
    }

    public  void istek(){
        list=new ArrayList<>();//Liste olusturuduk
        final  ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Bilgiler Ekranı");
        progressDialog.setMessage("icerik Yükleniyor Lütfen Bekelyin");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<List<Bilgi>> servis= ManagerAll.getInstance().getirBilgi();
        //Böylece ManagerAll sınıfının metodlarını aldık ve servise atadık

        servis.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()){
                    list=response.body();
                    BilgiAdapter bilgiAdapter=new BilgiAdapter(list,getApplicationContext());
                    listView.setAdapter(bilgiAdapter);
                }
                progressDialog.cancel();

            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });

    }



}