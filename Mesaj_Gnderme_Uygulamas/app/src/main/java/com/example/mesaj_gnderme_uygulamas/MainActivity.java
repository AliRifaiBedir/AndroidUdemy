package com.example.mesaj_gnderme_uygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<model> list;
    Context context=this;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        list=new ArrayList<>();
        model m1=new model("Ali","00000000000");
        model m2=new model("Veli","11111111111");
        model m3=new model("Hanzo","4444444444");
        model m4=new model("Danzo","22222222222");
        model m5=new model("Bebe","33333333333");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);

        adapter adp=new adapter(list,context,this);
        listView.setAdapter(adp);








    }





}