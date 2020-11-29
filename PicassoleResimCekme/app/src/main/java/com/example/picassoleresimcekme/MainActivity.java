package com.example.picassoleresimcekme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.image);
        resimcek();
    }

     //Manifeswstte internet izni ve gradle da picasso library unutma
    public void resimcek(){
        Picasso.get().load("https://cdn.pixabay.com/photo/2017/09/17/02/02/png-2757379_960_720.png").into(image);
    }
}