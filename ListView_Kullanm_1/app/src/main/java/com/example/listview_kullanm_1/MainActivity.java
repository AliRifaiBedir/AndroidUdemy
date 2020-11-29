package com.example.listview_kullanm_1;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<KullanıcıModel> kullanıcıList;
    KullanıcıListAdapter adp;
    Context context=this;
    ListView listView;


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listID);
        kullanıcıList = new ArrayList<>();
        KullanıcıModel kl1 = new KullanıcıModel("Ali", "Bedir", "29", "GS");
        KullanıcıModel kl2 = new KullanıcıModel("Ali", "Bedir", "29", "GS");
        KullanıcıModel kl3 = new KullanıcıModel("Ali", "Bedir", "29", "GS");
        kullanıcıList.add(kl1);
        kullanıcıList.add(kl2);
        kullanıcıList.add(kl3);
        adp=new KullanıcıListAdapter(kullanıcıList,context);
        listView.setAdapter(adp);






    }


}
