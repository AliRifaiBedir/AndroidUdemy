package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String[] ilceler={"izmtit","şişli","karamürsel"};
   ArrayAdapter arrayAdapter;
   Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);

        arrayAdapter=new ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,ilceler);
        //ArrayAdapter da tanımlamar yapılırken (context,sabit bir layaout,dizimiz)

        spinner.setAdapter(arrayAdapter);

    }



}