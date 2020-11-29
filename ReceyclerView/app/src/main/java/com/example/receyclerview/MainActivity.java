package com.example.receyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MesajmModel> list;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    adapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.receylclerView);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adp=new adapter(this,list);
        recyclerView.setAdapter(adp);
        //adapter set edildi burada



        MesajmModel m1=new MesajmModel("Merhaba ben Alİ","Ali",R.drawable.photo);
        MesajmModel m2=new MesajmModel("Merhaba ben Bebe","Bebe",R.drawable.photo);
        MesajmModel m3=new MesajmModel("Merhaba ben At","At",R.drawable.photo);
        list.add(m1);
        list.add(m2);
        list.add(m3);





    }
}