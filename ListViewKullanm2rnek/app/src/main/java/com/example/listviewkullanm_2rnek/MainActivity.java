package com.example.listviewkullanm_2rnek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView ListView;
    List<MesajModel> List;
    MesajAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView=findViewById(R.id.ListView);

        List=new ArrayList<>();
        MesajModel m1=new MesajModel("Merhaba ben Alİ","Ali",R.drawable.photo);
        MesajModel m2=new MesajModel("Merhaba ben Bebe","Bebe",R.drawable.photo);
        MesajModel m3=new MesajModel("Merhaba ben At","At",R.drawable.photo);
        List.add(m1);
        List.add(m2);
        List.add(m3);
        adapter=new MesajAdapter(List,this);
        ListView.setAdapter(adapter);




    }
}